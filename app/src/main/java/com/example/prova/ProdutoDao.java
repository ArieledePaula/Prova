package com.example.prova;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProdutoDao {

@Insert
void insert (Produto produto);

@Query("SELECT * FROM produto")

    List<Produto> getAllProdutos();

@Delete
    void  delete(Produto produto);

@Query("SELECT * FROM produto WHERE codigo = codigo LIMIT 1")
Produto getProdutoByCodigo(int codigo);
}
