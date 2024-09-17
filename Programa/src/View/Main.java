package View;

import java.util.Scanner;

import Repositorio.AlunoRepositorio;
import Repositorio.CursoRepositorio;
import Repositorio.InstrutorRepositorio;
import Servico.AlunoServico;
import Servico.CursoServico;
import Servico.InstrutorServico;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static AlunoRepositorio alunoRepositorio = new AlunoRepositorio();
    private static InstrutorRepositorio instrutorRepositorio = new InstrutorRepositorio();
    private static CursoRepositorio cursoRepositorio = new CursoRepositorio();
    private static AlunoServico alunoServico = new AlunoServico(alunoRepositorio);
    private static InstrutorServico instrutorServico = new InstrutorServico(instrutorRepositorio);
    private static CursoServico cursoServico = new CursoServico(cursoRepositorio);

    public static void main(String[] args) {
        boolean sair = false;
        do {
            menuPrincipal();
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    criarAluno();
                    break;
                case 2:
                    alunoServico.listarAluno();
                    break;
                case 3:
                    alterarAluno();
                    break;
                case 4:
                    removerAluno();
                    break;
                case 5:
                    criarIntrutorECurso();
                    break;
                case 0:
                    sair = true;
            }
        } while (!sair);
    }

    // MENU
    public static void menuPrincipal() {
        System.out.println("\n--------------------------------");
        System.out.println("SELECIONE SUA OPÇÃO:");
        System.out.print("| 1.Criar aluno |");
        System.out.print(" 2. Listar aluno |");
        System.out.print(" 3. Alterar Aluno |");
        System.out.print("\n| 4. Remover Aluno |");
        System.out.print(" 5. Lista de Instrutores e Cursos |");
        System.out.print("\n--------------------------------");
        System.out.print("\n| 0. Para Sair do Menu.");
        System.out.println("\n--------------------------------");
        System.out.print("Opção: ");
    }

    private static void criarAluno() {
        System.out.print("\nNome: ");
        String nome = scanner.nextLine();
        System.out.print("Curso: ");
        String curso = scanner.nextLine();
        alunoServico.adicionarAluno(nome, curso);
    }

    private static void removerAluno() {
        System.out.print("\nInforme o numero da matricula: ");
        int matricula = scanner.nextInt();
        alunoServico.removerAluno(matricula);
    }

    private static void alterarAluno() {
        System.out.print("\nInforme o numero da matricula: ");
        int matricula = scanner.nextInt();
        alunoServico.alterarAluno(matricula);
    }

    private static void criarIntrutorECurso() {
        cursoServico.adicionarCurso(Enums.TipoCurso.PRESENCIAL, "THE JAVA", 10, 30);
        cursoServico.adicionarCurso(Enums.TipoCurso.ONLINE, "THE PHP", 15, 45);
        cursoServico.listarCurso();
        instrutorServico.adicionarInstrutor("Jose", 30);
        instrutorServico.adicionarInstrutor("Mike", 25);
        instrutorServico.listarInstrutor();
    }

}
