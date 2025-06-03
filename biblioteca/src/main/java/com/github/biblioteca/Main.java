package biblioteca.src.main.java.com.github.biblioteca;

import biblioteca.src.main.java.com.github.biblioteca.controladores.LivroController;
import biblioteca.src.main.java.com.github.biblioteca.controladores.UsuarioController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsuarioController usuarioCtrl = new UsuarioController();
        LivroController livroCtrl = new LivroController();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n------ MENU PRINCIPAL------");
            System.out.println("1. Adicionar usuario");
            System.out.println("2. Listar usuarios matriculados");
            System.out.println("3. Adicionar livro");
            System.out.println("4. Listar livros disponiveis");
            System.out.println("0. Sair");
            System.out.print("Opcao: ");
            int op = Integer.parseInt(scanner.nextLine());

            switch (op) {
                case 1 -> usuarioCtrl.adicionarUsuario();
                case 2 -> usuarioCtrl.listarUsuarios();
                case 3 -> livroCtrl.adicionarLivro();
                case 4 -> livroCtrl.listarLivros();
                case 0 -> {
                    System.out.println("Encerrando programa...");
                    return;
                }
                default -> System.out.println("--ERRO--: Opção invalida");
            }
        }
    }
}