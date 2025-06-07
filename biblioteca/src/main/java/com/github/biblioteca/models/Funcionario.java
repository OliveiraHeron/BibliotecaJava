package com.github.biblioteca.models;

public class Funcionario {
    private String nome;
    private String cpf;
    private int idade;
    private String matricula;
    private String cargo;

    public Funcionario(String nome, String cpf, int idade, String matricula, String cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.matricula = matricula;
        this.cargo = cargo;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Idade: " + idade);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Cargo: " + cargo);
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
