package com.github.biblioteca.models;

import java.time.LocalDate;

import com.github.biblioteca.interfaces.Gerenciavel;

public class Emprestimo implements Gerenciavel {
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = dataEmprestimo.plusDays(7);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Usuario: " + usuario.getNome() +
                " | Livro: " + livro.getTitulo() +
                " | Emprestado em: " + dataEmprestimo +
                " | Devolucao ate: " + dataDevolucao);
    }

    // Getters
    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
}
