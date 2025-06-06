package com.github.biblioteca.models;

import com.github.biblioteca.interfaces.Gerenciavel;

public abstract class Pessoa implements Gerenciavel {
    protected String nome;
    protected String cpf;
    protected int idade;

    public Pessoa(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    // Método da interface (abstrato)
    @Override
    public abstract void exibirInformacoes();
}   