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
    private ProdutoDao produtoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        textViewReport = findViewById(R.id.textViewReport);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(v -> voltarParaCadastro());

        ProdutoDataBase db = ProdutoDataBase.getInstance(this);
        produtoDao = db.produtoDao();


        carregarRelatorio();
    }

    private void carregarRelatorio() {
        List<Produto> produtoList = produtoDao.getAllProdutos();

        StringBuilder report = new StringBuilder();

        if (produtoList.isEmpty()) {
            report.append("Nenhum produto cadastrado.");
        } else {
            for (Produto produto : produtoList) {
                report.append("Nome: ").append(produto.getNome()).append("\n")
                        .append("Código: ").append(produto.getCodigo()).append("\n")
                        .append("Preço: ").append(produto.getPreco()).append("\n")
                        .append("Estoque: ").append(produto.getQtdEstoque()).append("\n")
                        .append("----------------------\n");
            }
        }

        textViewReport.setText(report.toString());
    }

    public void voltarParaCadastro() {
        Intent intent = new Intent(ReportActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}