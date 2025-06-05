package com.github.biblioteca.controllers;
import com.github.biblioteca.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void adicionarUsuario() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        Usuario usuario = new Usuario(nome, cpf, idade, matricula);
        usuarios.add(usuario);
        System.out.println("Usuário adicionado!");
    }

    public void listarUsuarios() {
        for (Usuario u : usuarios) {
            u.exibirInformacoes();
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
}