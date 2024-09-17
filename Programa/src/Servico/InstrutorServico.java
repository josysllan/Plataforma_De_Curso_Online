package Servico;

import java.util.ArrayList;
import java.util.Scanner;

import Entidades.Instrutor;
import Interfaces.IInstrutor;
import Repositorio.InstrutorRepositorio;

public class InstrutorServico implements IInstrutor {
    private static final Scanner scanner = new Scanner(System.in);
    private InstrutorRepositorio instrutorRepositorio = new InstrutorRepositorio();

    public InstrutorServico(InstrutorRepositorio instrutorRepositorio) {
        this.instrutorRepositorio = instrutorRepositorio;
    }

    @Override
    public void adicionarInstrutor(String nome, int idade) {
        Instrutor instrutor = new Instrutor(nome, idade);
        instrutorRepositorio.adicionarInstrutor(instrutor);
        System.out.println("Instrutor adicionado com sucesso!");
    }

    @Override
    public void removerInstrutor(int id) {
        if (instrutorRepositorio.instrutors.isEmpty()) {
            System.out.println("erro");
        } else {
            instrutorRepositorio.removerInstrutor(id);
            System.out.println("\nInstrutor: " + id + ". Removido com sucesso!");
        }
    }

    @Override
    public void alterarInstrutor(int id) {
        if (instrutorRepositorio.instrutors.isEmpty()) {
            System.out.println("Erro");
        } else if (id < 0 || id >= instrutorRepositorio.instrutors.size()) {
            System.out.println("Erro");
        }

        Instrutor instrutor = instrutorRepositorio.instrutors.get(id);
        System.out.print("Novo Nome: ");
        String novoNome = scanner.nextLine();
        System.out.print("Nova Idade: ");
        int novaIdade = scanner.nextInt();
        instrutor.setNome(novoNome);
        instrutor.setIdade(novaIdade);

        System.out.println("\nInstrutor atualizado com sucesso!");
    }

    @Override
    public void listarInstrutor() {
        ArrayList<Instrutor> instrutors = instrutorRepositorio.listarInstrutor();
        if (instrutorRepositorio.instrutors.isEmpty()) {
            System.out.println("erro");
        } else {
            for (int i = 0; i < instrutors.size(); i++) {
                Instrutor ins = instrutors.get(i);
                ins.setId(i);
                System.out.println("\n-------------------------------------------------------------------------------");
                System.out.print("Instrutor: " + ins.getId() + "\n");
                System.out.print(" | Nome: " + ins.getNome());
                System.out.print(" | Idade: " + ins.getIdade());
                System.out.println("\n-------------------------------------------------------------------------------");
            }
        }
    }

}
