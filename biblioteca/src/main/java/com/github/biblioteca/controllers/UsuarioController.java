package com.github.biblioteca.controllers;
import com.github.biblioteca.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UsuarioController {
    private static final Logger logger = LogManager.getLogger(UsuarioController.class);
    private List<Usuario> usuarios = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void adicionarUsuario() {
        logger.info("Adicionando um novo usuario...");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.print("Matricula: ");
        String matricula = scanner.nextLine();

        Usuario usuario = new Usuario(nome, cpf, idade, matricula);
        usuarios.add(usuario);
        System.out.println("Usuario adicionado");
    }

    public void listarUsuarios() {
        logger.info("Listando usuarios registrados...");
        for (Usuario u : usuarios) {
            u.exibirInformacoes();
        }
    }

    public void removerUsuario(String cpf) {
        logger.info("Removendo usuario com CPF: " + cpf);
        usuarios.removeIf(u -> u.getCpf().equals(cpf));
        System.out.println("Usuario removido");
    }

    public void editarUsuario(String cpf) {
        logger.info("Editando dados do usuario com CPF: " + cpf);
        for (Usuario u : usuarios) {
            if (u.getCpf().equals(cpf)) {
                System.out.print("Novo nome: ");
                u.setNome(scanner.nextLine());
                System.out.print("Nova idade: ");
                u.setIdade(Integer.parseInt(scanner.nextLine()));
                System.out.print("Nova matricula: ");
                u.setMatricula(scanner.nextLine());
                System.out.println("Usuario atualizado");
                return;
            }
        }
        System.out.println("Usuario não encontrado.");
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}