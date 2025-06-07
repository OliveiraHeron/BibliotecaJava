package com.github.biblioteca.controllers;

import com.github.biblioteca.models.Funcionario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FuncionarioController {
    private static final String ARQUIVO = "funcionarios.txt";
    private final Scanner scanner = new Scanner(System.in);

    public void adicionarFuncionario() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();

        Funcionario funcionario = new Funcionario(nome, cpf, idade, matricula, cargo);
        salvarFuncionario(funcionario);
        System.out.println("Funcionário adicionado com sucesso!");
    }

    public void listarFuncionarios() {
        List<Funcionario> funcionarios = carregarFuncionarios();
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            for (Funcionario f : funcionarios) {
                f.exibirInformacoes();
                System.out.println("---------------------------");
            }
        }
    }

    public void editarFuncionario(String matricula) {
        List<Funcionario> funcionarios = carregarFuncionarios();
        boolean encontrado = false;

        for (Funcionario f : funcionarios) {
            if (f.getMatricula().equals(matricula)) {
                System.out.println("Editando funcionário: " + f.getNome());
                System.out.print("Novo nome: ");
                f.setNome(scanner.nextLine());
                System.out.print("Novo CPF: ");
                f.setCpf(scanner.nextLine());
                System.out.print("Nova idade: ");
                f.setIdade(Integer.parseInt(scanner.nextLine()));
                System.out.print("Novo cargo: ");
                f.setCargo(scanner.nextLine());
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            salvarTodos(funcionarios);
            System.out.println("Funcionário atualizado com sucesso.");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    public void removerFuncionario(String matricula) {
        List<Funcionario> funcionarios = carregarFuncionarios();
        boolean removido = funcionarios.removeIf(f -> f.getMatricula().equals(matricula));
        if (removido) {
            salvarTodos(funcionarios);
            System.out.println("Funcionário removido com sucesso.");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    private void salvarFuncionario(Funcionario funcionario) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO, true))) {
            writer.write(funcionario.getNome() + ";" + funcionario.getCpf() + ";" + funcionario.getIdade() + ";" +
                         funcionario.getMatricula() + ";" + funcionario.getCargo());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao salvar funcionário: " + e.getMessage());
        }
    }

    private void salvarTodos(List<Funcionario> funcionarios) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Funcionario f : funcionarios) {
                writer.write(f.getNome() + ";" + f.getCpf() + ";" + f.getIdade() + ";" +
                             f.getMatricula() + ";" + f.getCargo());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar funcionários: " + e.getMessage());
        }
    }

    private List<Funcionario> carregarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 5) {
                    Funcionario f = new Funcionario(partes[0], partes[1],
                            Integer.parseInt(partes[2]), partes[3], partes[4]);
                    funcionarios.add(f);
                }
            }
        } catch (FileNotFoundException e) {
            // arquivo ainda não existe, ok
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo de funcionários: " + e.getMessage());
        }
        return funcionarios;
    }
}
