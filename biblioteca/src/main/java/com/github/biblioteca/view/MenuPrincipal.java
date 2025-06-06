package com.github.biblioteca.view;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MenuPrincipal {
    private static final Logger logger = LogManager.getLogger(MenuPrincipal.class);
    private static Scanner scanner = new Scanner(System.in);

    public static void ExibirMenu() {
        logger.info("Iniciando o sistema de biblioteca...");
        while (true) {
            System.out.println("\n------ MENU PRINCIPAL------");
            System.out.println("1. Gerenciamente de Usuarios");
            System.out.println("2. Gerenciamento de Livros");
            System.out.println("0. Sair");
            System.out.print("Opcao: ");
            int op = scanner.nextInt();

            switch (op) {
                case 1 -> UsuarioView.menuUsuario();
                case 2 -> LivroView.MenuLivro();
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