package com.github.biblioteca.controllers;

import com.github.biblioteca.models.Emprestimo;
import com.github.biblioteca.models.Usuario;
import com.github.biblioteca.models.Livro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmprestimoController {
    private static final Logger logger = LogManager.getLogger(EmprestimoController.class);
    private static Scanner scanner = new Scanner(System.in);

    public EmprestimoController() {
        scanner = new Scanner(System.in);
    }

    public void registrarEmprestimo(List<Usuario> usuarios, List<Livro> livros) {
        logger.info("Iniciando o registro de um novo emprestimo");

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
            new Emprestimo(usuarioEncontrado, livroEncontrado);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("emprestimo.txt", true))) {
                writer.write(usuarioEncontrado.getNome() + "," + livroEncontrado.getTitulo());
                writer.newLine();
            } catch (IOException e) {
                logger.error("Erro ao salvar emprestimo no arquivo: " + e.getMessage());
            }
                System.out.println("Emprestimo registrado com sucesso.");
        } else {
            System.out.println("Usuario ou livro nao encontrado.");
        }
    }

    public void listarEmprestimos() {
        logger.info("Listando todos os emprestimos registrados");

        try (BufferedReader reader = new BufferedReader(new FileReader("emprestimo.txt"))) {
            String linha;
            boolean encontrou = false;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length >= 2) {
                    System.out.println("Usuario: " + dados[0] + " | Livro: " + dados[1]);
                    encontrou = true;
                }
            }
            if (!encontrou) {
                System.out.println("Nenhum emprestimo encontrado no arquivo.");
            }
        } catch (IOException e) {
            logger.error("Erro ao ler o arquivo de emprestimos: " + e.getMessage());
        }
    }
}
