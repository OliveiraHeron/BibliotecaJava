package com.github.biblioteca.models;

public class Usuario extends Pessoa {
    private String matricula;

    public Usuario(String nome, String cpf, int idade, String matricula) {
        super(nome, cpf, idade);
        this.matricula = matricula;
    }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    @Override
    public void exibirInformacoes() {
        System.out.println("Usuario: " + nome + ", CPF: " + cpf + ", Idade: " + idade + ", Matricula: " + matricula);
    }
}