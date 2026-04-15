package com.example.prova;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class ReportActivity extends AppCompatActivity {

    private TextView textViewReport;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        textViewReport = findViewById(R.id.textViewReport);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(v -> voltarParaCadastro());

        ProdutoDataBase db = Room.databaseBuilder(getApplicationContext(),
                        ProdutoDataBase.class, "produto-database")
                .allowMainThreadQueries()
                .build();

        ProdutoDao produtoDao = db.produtoDao();
        List<Produto> produtoList = produtoDao.getAllUsers();

        StringBuilder report = new StringBuilder();

        for(Produto produto : produtoList){
            report.append("Nome: ").append(produto.getNome()).append("\n")
                    .append("Codigo: ").append(produto.getCodigo()).append("\n\n");
        }

        textViewReport.setText(report.toString());
    }

    public void voltarParaCadastro(){
        Intent intent = new Intent(ReportActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}