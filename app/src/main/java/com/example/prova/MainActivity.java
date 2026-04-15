package com.example.prova;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome, editTextCodigo, editTextPreco, editTextQtdEstoque;
    private ProdutoDao produtoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextNome);
        editTextCodigo = findViewById(R.id.editTextCodigo);
        editTextPreco = findViewById(R.id.editTextPreco);
        editTextQtdEstoque = findViewById(R.id.editTextQtdEstoque);

        Button buttonSave = findViewById(R.id.buttonSave);
        Button buttonReport = findViewById(R.id.buttonReport);
        Button buttonUpdate = findViewById(R.id.buttonUpdate);
        Button buttonDelete = findViewById(R.id.buttonDelete);

        ProdutoDataBase db = Room.databaseBuilder(getApplicationContext(),
                        ProdutoDataBase.class, "produto-database")
                .allowMainThreadQueries()
                .build();

        produtoDao = db.produtoDao();

        buttonSave.setOnClickListener(v -> {
            String nome = editTextNome.getText().toString();
            String codigoStr = editTextCodigo.getText().toString();
            String precoStr = editTextPreco.getText().toString();
            String qtdStr = editTextQtdEstoque.getText().toString();

            if (!nome.isEmpty() && !codigoStr.isEmpty() && !precoStr.isEmpty() && !qtdStr.isEmpty()) {
                int codigo = Integer.parseInt(codigoStr);
                int preco = Integer.parseInt(precoStr);
                int qtdEstoque = Integer.parseInt(qtdStr);

                Produto produto = new Produto(nome, codigo, preco, qtdEstoque);
                produtoDao.insert(produto);

                Toast.makeText(this, "Produto adicionado!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            }
        });

        buttonUpdate.setOnClickListener(v -> {
            String codigoStr = editTextCodigo.getText().toString();

            if (!codigoStr.isEmpty()) {
                int codigo = Integer.parseInt(codigoStr);

                Produto produto = produtoDao.getProdutoByCodigo(codigo);

                if (produto != null) {
                    produto.setNome(editTextNome.getText().toString());
                    produto.setPreco(Integer.parseInt(editTextPreco.getText().toString()));
                    produto.setQtdEstoque(Integer.parseInt(editTextQtdEstoque.getText().toString()));

                    produtoDao.update(produto);

                    Toast.makeText(this, "Produto atualizado!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Produto não encontrado!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonDelete.setOnClickListener(v -> {
            String codigoStr = editTextCodigo.getText().toString();

            if (!codigoStr.isEmpty()) {
                int codigo = Integer.parseInt(codigoStr);

                Produto produto = produtoDao.getProdutoByCodigo(codigo);

                if (produto != null) {
                    produtoDao.delete(produto);
                    Toast.makeText(this, "Produto deletado!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Produto não encontrado!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonReport.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ReportActivity.class));
        });
    }
}