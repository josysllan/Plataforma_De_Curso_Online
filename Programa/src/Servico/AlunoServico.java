package Servico;

import java.util.ArrayList;
import java.util.Scanner;

import Entidades.Aluno;
import Interfaces.IAluno;
import Repositorio.AlunoRepositorio;

public class AlunoServico implements IAluno {
    private static final Scanner scanner = new Scanner(System.in);
    private AlunoRepositorio alunoRepositorio = new AlunoRepositorio();

    public AlunoServico(AlunoRepositorio alunoRepositorio) {
        this.alunoRepositorio = alunoRepositorio;
    }

    @Override
    public void adicionarAluno(String nome, String curso) {
        Aluno alunos = new Aluno(nome, curso);
        alunoRepositorio.adicionarAluno(alunos);
        System.out.println("\nAluno(a) adicionado com sucesso! Matricula: " + alunos.getMatricula());
    }

    @Override
    public void alterarAluno(int id) {
        if (alunoRepositorio.alunos.isEmpty()) {
            System.out.println("Não existe aluno(s) matriculado(s)!");
        } else if (id < 0 || id >= alunoRepositorio.alunos.size()) {
            System.out.println("Matricula invalida!");
        }

        Aluno aluno = alunoRepositorio.alunos.get(id);
        System.out.print("Novo Nome: ");
        String novoNome = scanner.nextLine();
        System.out.print("Novo Curso: ");
        String novoCurso = scanner.nextLine();
        aluno.setNome(novoNome);
        aluno.setCurso(novoCurso);

        System.out.println("\nMatricula atualizada com sucesso!");
    }

    @Override
    public void removerAluno(int id) {
        if (alunoRepositorio.alunos.isEmpty()) {
            System.out.println("Não existe aluno(s) matriculado(s)!");
        } else {
            alunoRepositorio.removerAluno(id);
            System.out.println("\nMatricula: " + id + ". Removida com sucesso!");
        }
    }

    @Override
    public void listarAluno() {
        ArrayList<Aluno> alunos = alunoRepositorio.listarAluno();
        if (alunoRepositorio.alunos.isEmpty()) {
            System.out.println("Lista de alunos vazia!");
        } else {
            for (int i = 0; i < alunos.size(); i++) {
                Aluno a = alunos.get(i);
                a.setMatricula(i);
                System.out.println("\n-------------------------------------------------------------------------------");
                System.out.print("Matricula do Aluno(a): " + a.getMatricula() + "\n");
                System.out.print(" | Nome: " + a.getNome());
                System.out.print(" | Curso: " + a.getCurso());
                System.out.println("\n-------------------------------------------------------------------------------");
            }
        }
    }

}
