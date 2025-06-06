package com.github.biblioteca.view;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.biblioteca.interfaces.Menu;

public class MenuPrincipal implements Menu {
    private static final Logger logger = LogManager.getLogger(MenuPrincipal.class);
    private static Scanner scanner = new Scanner(System.in);
    private static UsuarioView usuarioView = new UsuarioView();
    private static LivroView livroView = new LivroView();

    @Override
    public void exibirMenu() {
        logger.info("Iniciando o sistema de biblioteca...");
        while (true) {
            System.out.println("\n------ MENU PRINCIPAL------");
            System.out.println("1. Gerenciamente de Usuarios");
            System.out.println("2. Gerenciamento de Livros");
            System.out.println("0. Sair");
            System.out.print("Opcao: ");
            int op = scanner.nextInt();

            switch (op) {
                case 1 -> usuarioView.exibirMenu();
                case 2 -> livroView.exibirMenu();
                case 0 -> {
                    System.out.println("Encerrando programa...");
                    scanner.close();
                    logger.info("Sistema de biblioteca encerrado.");
                    return;
                }
                default -> System.out.println("--ERRO--: Opção invalida");
            }
        }
    }
}