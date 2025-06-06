package com.github.biblioteca.view;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.biblioteca.controllers.LivroController;

public class LivroView {
    private static final Logger logger = LogManager.getLogger(UsuarioView.class);
    private static Scanner scanner = new Scanner(System.in);
    private static LivroController livroController = new LivroController();
    private static String ISBN;

    public static void MenuLivro() {
        logger.info("Menu de livros iniciado.");
        while (true) {
            System.out.println("\n------ MENU LIVROS ------");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Editar Livro");
            System.out.println("4. Excluir Livro");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Opcao: ");
            int op = scanner.nextInt();

            switch (op) {
                case 1:
                    livroController.adicionarLivro();
                    break;
                case 2:
                    livroController.listarLivros();
                    break;
                case 3:
                    System.out.println("Digite o ISBN do livro a ser editado:");
                    ISBN = scanner.nextLine();
                    livroController.editarLivro(ISBN);
                    break;
                case 4:
                    System.out.println("Digite o ISBN do livro a ser excluído:");
                    scanner.nextLine();
                    ISBN = scanner.nextLine();
                    livroController.removerLivro(ISBN);
                    break;
                case 0:
                    logger.info("Voltando ao menu principal.");
                    return;
                default:
                    System.out.println("--ERRO--: Opção inválida");
                    break;
            }
        }
    }
}