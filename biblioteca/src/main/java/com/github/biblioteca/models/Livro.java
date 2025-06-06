package com.github.biblioteca.models;

import com.github.biblioteca.interfaces.Gerenciavel;

public class Livro implements Gerenciavel {
    private String titulo;
    private String autor;
    private String id;

    public Livro(String titulo, String autor, String id) {
        this.titulo = titulo;
        this.autor = autor;
        this.id = id;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @Override
    public void exibirInformacoes() {
        System.out.println("Livro: " + titulo + ", Autor: " + autor + ", id: " + id);
    }
}