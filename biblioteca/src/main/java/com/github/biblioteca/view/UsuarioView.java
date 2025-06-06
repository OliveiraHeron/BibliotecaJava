package com.github.biblioteca.view;

import java.util.Scanner;

import com.github.biblioteca.controllers.UsuarioController;
import com.github.biblioteca.interfaces.Menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UsuarioView implements Menu {
    private static final Logger logger = LogManager.getLogger(UsuarioView.class);
    private static final Scanner scanner = new Scanner(System.in);
    private static final UsuarioController usuarioController = new UsuarioController();

    @Override
    public void exibirMenu() {
        logger.info("Menu do usuário iniciado.");
        while (true) {
            System.out.println("\n------ MENU USUARIO ------");
            System.out.println("1. Adicionar Usuario");
            System.out.println("2. Listar Usuarios");
            System.out.println("3. Editar Usuario");
            System.out.println("4. Excluir Usuario");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Opcao: ");
            int op = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (op) {
                case 1:
                    usuarioController.adicionarUsuario();
                    break;
                case 2:
                    usuarioController.listarUsuarios();
                    break;
                case 3:
                    System.out.print("Digite o CPF do usuario a ser editado: ");
                    String cpfEditar = scanner.nextLine();
                    usuarioController.editarUsuario(cpfEditar);
                    break;
                case 4:
                    System.out.print("Digite o CPF do usuario a ser excluido: ");
                    String cpfExcluir = scanner.nextLine();
                    usuarioController.removerUsuario(cpfExcluir);
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

    public static UsuarioController getController() {
        return usuarioController;
    }
}
