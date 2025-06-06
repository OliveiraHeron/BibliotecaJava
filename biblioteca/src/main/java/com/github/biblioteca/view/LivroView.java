package com.github.biblioteca.view;

import java.util.Scanner;

import com.github.biblioteca.controllers.LivroController;
import com.github.biblioteca.interfaces.Menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LivroView implements Menu {
    private static final Logger logger = LogManager.getLogger(LivroView.class);
    private static final Scanner scanner = new Scanner(System.in);
    private static final LivroController livroController = new LivroController();

    @Override
    public void exibirMenu() {
        logger.info("Menu de livros iniciado.");
        while (true) {
            System.out.println("\n------ MENU LIVRO ------");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Editar Livro");
            System.out.println("4. Excluir Livro");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Opcao: ");
            int op = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (op) {
                case 1:
                    livroController.adicionarLivro();
                    break;
                case 2:
                    livroController.listarLivros();
                    break;
                case 3:
                    System.out.print("Digite o ID do livro a ser editado: ");
                    String isbnEditar = scanner.nextLine();
                    livroController.editarLivro(isbnEditar);
                    break;
                case 4:
                    System.out.print("Digite o ID do livro a ser excluido: ");
                    String isbnExcluir = scanner.nextLine();
                    livroController.removerLivro(isbnExcluir);
                    break;
                case 0:
                    logger.info("Voltando ao menu principal.");
                    return;
                default:
                    System.out.println("--ERRO--: Opcao invalida");
                    break;
            }
        }
    }

    public static LivroController getController() {
        return livroController;
    }
}
