package com.example.prova;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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
}