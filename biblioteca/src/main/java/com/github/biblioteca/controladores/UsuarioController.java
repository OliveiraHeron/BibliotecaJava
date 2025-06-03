package biblioteca.src.main.java.com.github.biblioteca.controladores;
import biblioteca.src.main.java.com.github.biblioteca.modelos.Usuario;

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
        System.out.print("Matricula: ");
        String matricula = scanner.nextLine();

        Usuario usuario = new Usuario(nome, cpf, idade, matricula);
        usuarios.add(usuario);
        System.out.println("Usuario adicionado");
    }

    public void listarUsuarios() {
        for (Usuario u : usuarios) {
            u.exibirInformacoes();
        }
    }

    public void removerUsuario(String cpf) {
        usuarios.removeIf(u -> u.getCpf().equals(cpf));
        System.out.println("Usuario removido");
    }

    public void editarUsuario(String cpf) {
        for (Usuario u : usuarios) {
            if (u.getCpf().equals(cpf)) {
                System.out.print("Novo nome: ");
                u.setNome(scanner.nextLine());
                System.out.print("Nova idade: ");
                u.setIdade(Integer.parseInt(scanner.nextLine()));
                System.out.print("Nova matricula: ");
                u.setMatricula(scanner.nextLine());
                System.out.println("Usuario atualizado");
                return;
            }
        }
        System.out.println("Usuario não encontrado.");
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}