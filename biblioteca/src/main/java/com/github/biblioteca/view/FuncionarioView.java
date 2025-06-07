package com.github.biblioteca.view;

import com.github.biblioteca.controllers.FuncionarioController;
import com.github.biblioteca.interfaces.Menu;

import java.util.Scanner;

public class FuncionarioView implements Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final FuncionarioController funcionarioController = new FuncionarioController();

    @Override
    public void exibirMenu() {
        while (true) {
            System.out.println("\n------ MENU FUNCIONÁRIO ------");
            System.out.println("1. Adicionar Funcionário");
            System.out.println("2. Listar Funcionários");
            System.out.println("3. Editar Funcionário");
            System.out.println("4. Excluir Funcionário");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Opção: ");
            int op = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (op) {
                case 1:
                    funcionarioController.adicionarFuncionario();
                    break;
                case 2:
                    funcionarioController.listarFuncionarios();
                    break;
                case 3:
                    System.out.print("Digite a matrícula do funcionário a ser editado: ");
                    String matEditar = scanner.nextLine();
                    funcionarioController.editarFuncionario(matEditar);
                    break;
                case 4:
                    System.out.print("Digite a matrícula do funcionário a ser excluído: ");
                    String matExcluir = scanner.nextLine();
                    funcionarioController.removerFuncionario(matExcluir);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("--ERRO--: Opção inválida");
                    break;
            }
        }
    }

    public FuncionarioController getController() {
        return funcionarioController;
    }
}
