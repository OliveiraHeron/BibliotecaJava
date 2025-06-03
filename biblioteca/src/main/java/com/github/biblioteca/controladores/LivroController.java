package biblioteca.src.main.java.com.github.biblioteca.controladores;
import biblioteca.src.main.java.com.github.biblioteca.modelos.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LivroController {
    private List<Livro> livros = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void adicionarLivro() {
        System.out.print("Titulo do livro: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor do livro: ");
        String autor = scanner.nextLine();
        System.out.print("Id do livro: ");
        String isbn = scanner.nextLine();

        Livro livro = new Livro(titulo, autor, isbn);
        livros.add(livro);
        System.out.println("Livro adicionado");
    }

    public void listarLivros() {
        for (Livro l : livros) {
            System.out.println("Titulo: " + l.getTitulo() + ", Autor: " + l.getAutor() + ", Id: " + l.getId());
        }
    }

    public void removerLivro(String isbn) {
        livros.removeIf(l -> l.getId().equals(isbn));
        System.out.println("Livro removido");
    }

    public void editarLivro(String isbn) {
        for (Livro l : livros) {
            if (l.getId().equals(isbn)) {
                System.out.print("Novo titulo: ");
                l.setTitulo(scanner.nextLine());
                System.out.print("Novo autor: ");
                l.setAutor(scanner.nextLine());
                System.out.println("Livro atualizado");
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public List<Livro> getLivros() {
        return livros;
    }
}