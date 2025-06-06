package com.github.biblioteca.view;

import com.github.biblioteca.controllers.EmprestimoController;
import com.github.biblioteca.controllers.UsuarioController;
import com.github.biblioteca.controllers.LivroController;
import com.github.biblioteca.interfaces.Menu;

import java.util.Scanner;

public class EmprestimoView implements Menu {
    private EmprestimoController emprestimoController = new EmprestimoController();
    private UsuarioController usuarioController = UsuarioView.getController();
    private LivroController livroController = LivroView.getController();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n------ MENU DE EMPRESTIMOS ------");
            System.out.println("1. Registrar emprestimo");
            System.out.println("2. Listar emprestimos");
            System.out.println("0. Voltar");
            System.out.print("Opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1 -> emprestimoController.registrarEmprestimo(
                        usuarioController.getUsuarios(),
                        livroController.getLivros()
                );
                case 2 -> emprestimoController.listarEmprestimos();
                case 0 -> System.out.println("Retornando ao menu principal...");
                default -> System.out.println("Opcao invalida. Tente novamente.");
            }
        } while (opcao != 0);
    }
}
