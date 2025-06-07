package com.github.biblioteca.controllers;

import com.github.biblioteca.models.Livro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LivroController {
    private static final Logger logger = LogManager.getLogger(LivroController.class);
    private List<Livro> livros = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private String fileName = "livros.txt";

    public void adicionarLivro() {
        logger.info("Iniciando a adicao de um novo livro\n");

        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("ID: ");
        String id = scanner.nextLine();

        Livro livro = new Livro(titulo, autor, id);
        livros.add(livro);
        salvarEmArquivo(livro);
        System.out.println("Livro adicionado!");
    }

    public void listarLivros() {
        logger.info("Iniciando a listagem de livros\n");

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String linha;
            boolean encontrou = false;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 3) {
                    System.out.println("----------------------");
                    System.out.println("Título: " + dados[0]);
                    System.out.println("Autor: " + dados[1]);
                    System.out.println("ID: " + dados[2]);
                    System.out.println("----------------------");
                    encontrou = true;
                }
            }
            if (!encontrou) {
                System.out.println("Nenhum livro encontrado no arquivo.");
            }
        } catch (IOException e) {
            logger.error("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public void removerLivro(String id) {
        logger.info("Iniciando a remocao de um livro\n");

        List<String> linhasRestantes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 3 && !dados[2].equals(id)) {
                    linhasRestantes.add(linha);
                }
            }
        } catch (IOException e) {
            logger.error("Erro ao ler o arquivo: " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false))) {
            for (String l : linhasRestantes) {
                writer.write(l);
                writer.newLine();
            }
        } catch (IOException e) {
            logger.error("Erro ao escrever no arquivo: " + e.getMessage());
        }
        System.out.println("Livro removido!");
    }

    public void editarLivro(String id) {
        logger.info("Iniciando a edicao de um livro\n");

        boolean atualizado = false;
        List<String> linhasAtualizadas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 3 && dados[2].equals(id)) {
                    System.out.print("Novo título: ");
                    String novoTitulo = scanner.nextLine();
                    System.out.print("Novo autor: ");
                    String novoAutor = scanner.nextLine();
                    linhasAtualizadas.add(novoTitulo + "," + novoAutor + "," + id);
                    atualizado = true;
                } else {
                    linhasAtualizadas.add(linha);
                }
            }
        } catch (IOException e) {
            logger.error("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false))) {
            for (String l : linhasAtualizadas) {
                writer.write(l);
                writer.newLine();
            }
        } catch (IOException e) {
            logger.error("Erro ao escrever no arquivo: " + e.getMessage());
            return;
        }

        if (atualizado) {
            System.out.println("Livro atualizado!");
        } else {
            System.out.println("Livro nao encontrado.");
        }
    }

    private void salvarEmArquivo(Livro livro) {
        logger.info("Iniciando a abertura do arquivo\n");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(livro.getTitulo() + "," + livro.getAutor() + "," + livro.getId());
            writer.newLine();
            System.out.println("Livro salvo no arquivo!");
        } catch (IOException e) {
            logger.error("Erro ao salvar livro: " + e.getMessage());
        }
    }

    public List<Livro> getLivros() {
        return livros;
    }

}