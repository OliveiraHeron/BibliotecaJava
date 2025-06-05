package com.github.biblioteca.controllers;
import com.github.biblioteca.models.Livro;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LivroController {
    private List<Livro> livros = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void adicionarLivro() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        Livro livro = new Livro(titulo, autor, isbn);
        livros.add(livro);
        System.out.println("Livro adicionado!");
    }

    public void listarLivros() {
        for (Livro l : livros) {
            l.exibirInformacoes();
        }
    }

    public void removerLivro(String isbn) {
        livros.removeIf(l -> l.getIsbn().equals(isbn));
        System.out.println("Livro removido!");
    }

    public void editarLivro(String isbn) {
        for (Livro l : livros) {
            if (l.getIsbn().equals(isbn)) {
                System.out.print("Novo título: ");
                l.setTitulo(scanner.nextLine());
                System.out.print("Novo autor: ");
                l.setAutor(scanner.nextLine());
                System.out.println("Livro atualizado!");
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }
}