package com.github.biblioteca.view;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.github.biblioteca.interfaces.Menu;

public class MenuPrincipal implements Menu {
    private static final Logger logger = LogManager.getLogger(MenuPrincipal.class);
    private static final Scanner scanner = new Scanner(System.in);
    private static final UsuarioView usuarioView = new UsuarioView();
    private static final LivroView livroView = new LivroView();
    private static final EmprestimoView emprestimoView = new EmprestimoView();
    private static final FuncionarioView funcionarioView = new FuncionarioView(); // NOVO

    @Override
    public void exibirMenu() {
        logger.info("Iniciando o sistema de biblioteca...");
        while (true) {
            System.out.println("\n------ MENU PRINCIPAL ------");
            System.out.println("1. Gerenciamento de Usuários");
            System.out.println("2. Gerenciamento de Livros");
            System.out.println("3. Gerenciamento de Empréstimos");
            System.out.println("4. Gerenciamento de Funcionários");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            int op = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (op) {
                case 1 -> usuarioView.exibirMenu();
                case 2 -> livroView.exibirMenu();
                case 3 -> emprestimoView.exibirMenu();
                case 4 -> funcionarioView.exibirMenu(); // corrigido
                case 0 -> {
                    System.out.println("Encerrando programa...");
                    logger.info("Sistema de biblioteca encerrado.");
                    return;
                }
                default -> System.out.println("--ERRO--: Opção inválida");
            }
        }
    }
}
