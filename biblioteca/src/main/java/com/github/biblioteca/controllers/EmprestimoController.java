package com.github.biblioteca.controllers;

import com.github.biblioteca.models.Emprestimo;
import com.github.biblioteca.models.Usuario;
import com.github.biblioteca.models.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmprestimoController {
    private List<Emprestimo> emprestimos;
    private Scanner scanner;

    public EmprestimoController() {
        emprestimos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void registrarEmprestimo(List<Usuario> usuarios, List<Livro> livros) {
        if (usuarios.isEmpty() || livros.isEmpty()) {
            System.out.println("Nao ha usuarios ou livros cadastrados.");
            return;
        }

        System.out.print("Nome do usuario: ");
        String nomeUsuario = scanner.nextLine();

        Usuario usuarioEncontrado = null;
        for (Usuario u : usuarios) {
            if (u.getNome().equalsIgnoreCase(nomeUsuario)) {
                usuarioEncontrado = u;
                break;
            }
        }

        System.out.print("Titulo do livro: ");
        String tituloLivro = scanner.nextLine();

        Livro livroEncontrado = null;
        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(tituloLivro)) {
                livroEncontrado = l;
                break;
            }
        }

        if (usuarioEncontrado != null && livroEncontrado != null) {
            Emprestimo novo = new Emprestimo(usuarioEncontrado, livroEncontrado);
            emprestimos.add(novo);
            System.out.println("Emprestimo registrado com sucesso.");
        } else {
            System.out.println("Usuario ou livro nao encontrado.");
        }
    }

    public void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum emprestimo encontrado.");
            return;
        }

        for (Emprestimo e : emprestimos) {
            e.exibirInformacoes();
        }
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}
