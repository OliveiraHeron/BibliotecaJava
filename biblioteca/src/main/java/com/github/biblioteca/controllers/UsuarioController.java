package com.github.biblioteca.controllers;

import com.github.biblioteca.models.Usuario;

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

public class UsuarioController {
    private static final Logger logger = LogManager.getLogger(UsuarioController.class);
    private List<Usuario> usuarios = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private String fileName = "usuarios.txt";

    public void adicionarUsuario() {
        logger.info("Iniciando a adicao de um novo usuario\n");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Matricula: ");
        String matricula = scanner.nextLine();

        Usuario usuario = new Usuario(nome, cpf, idade, matricula);
        usuarios.add(usuario);
        salvarEmArquivo(usuario);
        System.out.println("Usuario adicionado!");
    }

    public void listarUsuarios() {
        logger.info("Iniciando a listagem de usuarios\n");

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String linha;
            boolean encontrou = false;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 4) {
                    System.out.println("----------------------");
                    System.out.println("Nome: " + dados[0]);
                    System.out.println("CPF: " + dados[1]);
                    System.out.println("Idade: " + dados[2]);
                    System.out.println("Matricula: " + dados[3]);
                    System.out.println("----------------------");
                    encontrou = true;
                }
            }
            if (!encontrou) {
                System.out.println("Nenhum usuario encontrado no arquivo.");
            }
        } catch (IOException e) {
            logger.error("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public void removerUsuario(String cpf) {
        logger.info("Iniciando a remocao de um usuario\n");

        List<String> linhasRestantes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 4 && !dados[1].equals(cpf)) {
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
        System.out.println("Usuario removido!");
    }

    public void editarUsuario(String cpf) {
        logger.info("Iniciando a edicao de um usuario\n");

        boolean atualizado = false;
        List<String> linhasAtualizadas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 4 && dados[1].equals(cpf)) {
                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Nova idade: ");
                    String novoIdade = scanner.nextLine();
                    linhasAtualizadas.add(novoNome + "," + cpf + "," + novoIdade + "," + dados[3]);
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
            System.out.println("Usuario atualizado!");
        } else {
            System.out.println("Usuario não encontrado.");
        }
    }

    private void salvarEmArquivo(Usuario usuario) {
        logger.info("Iniciando a abertura do arquivo\n");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(usuario.getNome() + "," + usuario.getCpf() + "," + usuario.getIdade() + "," + usuario.getMatricula());
            writer.newLine();
            System.out.println("Usuario salvo no arquivo!");
        } catch (IOException e) {
            logger.error("Erro ao salvar livro: " + e.getMessage());
        }
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}