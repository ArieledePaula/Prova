package com.example.prova;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Produto {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nome;
    private int codigo;
    private double preco;;
    private int qtdEstoque;

    public Produto(String nome, int codigo, double preco, int qtdEstoque) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getNome() {return nome;}

    public int getCodigo() {return codigo;}

    public double getPreco() {return preco;}

    public int getQtdEstoque() {return qtdEstoque;}



    public void setNome(String nome) {this.nome = nome;}

    public void setCodigo(int codigo) {this.codigo = codigo;}

    public void setPreco(double preco) {this.preco = preco;}

    public void setQtdEstoque(int qtdEstoque) {this.qtdEstoque = qtdEstoque;}


}