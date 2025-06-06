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
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        Usuario usuario = new Usuario(nome, cpf, idade, matricula);
        usuarios.add(usuario);
        salvarEmArquivo(usuario);
        System.out.println("Usuário adicionado!");
    }

    public void listarUsuarios() {
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
                    System.out.println("Matrícula: " + dados[3]);
                    System.out.println("----------------------");
                    encontrou = true;
                }
            }
            if (!encontrou) {
                System.out.println("Nenhum usuário encontrado no arquivo.");
            }
        } catch (IOException e) {
            logger.error("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public void removerUsuario(String cpf) {
        usuarios.removeIf(u -> u.getCpf().equals(cpf));
        System.out.println("Usuário removido!");
    }

    public void editarUsuario(String cpf) {
        for (Usuario u : usuarios) {
            if (u.getCpf().equals(cpf)) {
                System.out.print("Novo nome: ");
                u.setNome(scanner.nextLine());
                System.out.print("Nova idade: ");
                u.setIdade(Integer.parseInt(scanner.nextLine()));
                System.out.print("Nova matrícula: ");
                u.setMatricula(scanner.nextLine());
                System.out.println("Usuário atualizado!");
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
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
}