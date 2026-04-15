package com.example.prova;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome, editTextCodigo, getEditTextPreco, editTextQtdEstoque;
    private ProdutoDao produtoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextNome);
        editTextCodigo = findViewById(R.id.editTextCodigo);
        getEditTextPreco = findViewById(R.id.editTextPreco);
        editTextQtdEstoque = findViewById(R.id.editTextQtdEstoque);

        Button buttonSave = findViewById(R.id.buttonSave);
        Button buttonReport = findViewById(R.id.buttonReport);
        Button buttonUpdate = findViewById(R.id.buttonUpdate);
        Button buttonDelete = findViewById(R.id.buttonDelete);

        ProdutoDataBase db = Room.databaseBuilder(getApplicationContext(),
                        ProdutoDataBase.class, "user-database")
                .allowMainThreadQueries()
                .build();

        produtoDao = db.produtoDao();
    }

    buttonSave.setOnClickListener(v ->

    {

        String nome = editTextNome.getText().toString();
        int codigo = Integer.parseInt(editTextCodigo.getText().toString());
        int preco = Integer.parseInt(getEditTextPreco.getText().toString());
        int qtdEstoque = Integer.parseInt(editTextQtdEstoque.getText().toString());


        if (!nome.isEmpty() && !codigo.isEmpty() && !preco.isEmpty() && !qtdEstoque.isEmpty()) {
            Produto produto = new Produto(nome, codigo, preco, qtdEstoque);
            ProdutoDao.insert(produto);
            Toast.makeText(this, "Produto adicionado!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Preencha os campos obrigatórios!", Toast.LENGTH_SHORT).show();
        }
    });

    buttonUpdate.setOnClickListener(v -> {

        String nome = editTextNome.getText().toString();
        int codigo = Integer.parseInt(editTextCodigo.getText().toString());
        int preco = Integer.parseInt(getEditTextPreco.getText().toString());
        int qtdEstoque = Integer.parseInt(editTextQtdEstoque.getText().toString());

        Produto produto = produtoDao.getUserByCodigo(codigo);

        if (produto != null) {
            produto.setNome(nome);
            produto.setCodigo(codigo);
            produto.setPreco(preco);
            produto.setQtdEstoque(qtdEstoque);

            produtoDao.update(produto);
            Toast.makeText(this, "Produto atualizado!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Produto não encontrado!", Toast.LENGTH_SHORT).show();
        }
    });

    buttonDelete.setOnClickListener(v -> {

        int codigo = Integer.parseInt(editTextCodigo.getText().toString());
        Produto produto = produtoDao.getProdutoByCodigo(codigo);

        if (produto != null) {
            produtoDao.delete(produto);
            Toast.makeText(this, "Produto deletado!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Produto não encontrado!", Toast.LENGTH_SHORT).show();
        }
    });

}