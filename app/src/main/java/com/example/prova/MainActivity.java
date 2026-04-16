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
        Button buttonDelete = findViewById(R.id.buttonDelete);

        ProdutoDataBase db = ProdutoDataBase.getInstance(this);
        produtoDao = db.produtoDao();



        buttonSave.setOnClickListener(v -> {

            String nome = editTextNome.getText().toString().trim();
            String codigoStr = editTextCodigo.getText().toString().trim();
            String precoStr = editTextPreco.getText().toString().trim();
            String qtdStr = editTextQtdEstoque.getText().toString().trim();


            if (nome.isEmpty() || codigoStr.isEmpty() || precoStr.isEmpty() || qtdStr.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                return;
            }


            if (!precoStr.matches("^\\d+(\\.\\d{1,2})?$")) {
                Toast.makeText(this, "Preço inválido! Use até 2 casas decimais.", Toast.LENGTH_SHORT).show();
                return;
            }

            double preco = Double.parseDouble(precoStr);
            if (preco <= 0) {
                Toast.makeText(this, "Preço deve ser positivo!", Toast.LENGTH_SHORT).show();
                return;
            }


            int qtdEstoque;
            try {
                qtdEstoque = Integer.parseInt(qtdStr);
                if (qtdEstoque <= 0) {
                    Toast.makeText(this, "Quantidade deve ser maior que zero!", Toast.LENGTH_SHORT).show();
                    return;
                }
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Quantidade inválida!", Toast.LENGTH_SHORT).show();
                return;
            }


            int codigo;
            try {
                codigo = Integer.parseInt(codigoStr);
                if (codigo <= 0) {
                    Toast.makeText(this, "Código deve ser positivo!", Toast.LENGTH_SHORT).show();
                    return;
                }
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Código inválido!", Toast.LENGTH_SHORT).show();
                return;
            }


            Produto produto = new Produto(nome, codigo, preco, qtdEstoque);
            produtoDao.insert(produto);

            Toast.makeText(this, "Produto cadastrado!", Toast.LENGTH_SHORT).show();
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