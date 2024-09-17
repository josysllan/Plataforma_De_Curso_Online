package Servico;

import java.util.ArrayList;
import java.util.Scanner;

import Entidades.Curso;
import Enums.TipoCurso;
import Interfaces.ICurso;
import Repositorio.CursoRepositorio;

public class CursoServico implements ICurso {
    private static final Scanner scanner = new Scanner(System.in);
    private CursoRepositorio cursoRepositorio = new CursoRepositorio();

    public CursoServico(CursoRepositorio cursoRepositorio) {
        this.cursoRepositorio = cursoRepositorio;
    }

    @Override
    public void adicionarCurso(TipoCurso tipoCurso, String titulo, int horaAula, int dias) {
        Curso curso = new Curso(tipoCurso, titulo, horaAula, dias);
        cursoRepositorio.adicionarCurso(curso);
        System.out.println("Curso adicionado com sucesso!");
    }

    @Override
    public void removerCurso(int id) {
        if (cursoRepositorio.cursos.isEmpty()) {
            System.out.println("erro");
        } else {
            cursoRepositorio.removerCurso(id);
            System.out.println("\nCurso: " + id + ". Removido com sucesso!");
        }
    }

    @Override
    public void alterarCurso(int id) {
        if (cursoRepositorio.cursos.isEmpty()) {
            System.out.println("Erro");
        } else if (id < 0 || id >= cursoRepositorio.cursos.size()) {
            System.out.println("Erro");
        }

        Curso curso = cursoRepositorio.cursos.get(id);
        System.out.print("Novo Tipo: 1.PRESENCIAL | 2.ONLINE |");
        int opcao = scanner.nextInt();
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Hora Aula: ");
        int horaAula = scanner.nextInt();
        System.out.print("Dias: ");
        int dias = scanner.nextInt();
        scanner.nextLine();
        switch (opcao) {
            case 1:
                curso.setTipoCurso(Enums.TipoCurso.PRESENCIAL);
                break;
            case 2:
                curso.setTipoCurso(Enums.TipoCurso.PRESENCIAL);
                break;
            default:
                break;
        }
        curso.setTitulo(titulo);
        curso.setHoraAula(horaAula);
        curso.setDias(dias);
        System.out.println("\nCurso atualizado com sucesso!");
    }

    @Override
    public void listarCurso() {
        ArrayList<Curso> cursos = cursoRepositorio.listarCurso();
        if (cursoRepositorio.cursos.isEmpty()) {
            System.out.println("erro");
        } else {
            for (int i = 0; i < cursos.size(); i++) {
                Curso c = cursos.get(i);
                c.setId(i);
                System.out.println("\n-------------------------------------------------------------------------------");
                System.out.print("Curso: " + c.getId() + "\n");
                System.out.print(" | Tipo: " + c.getTipoCurso());
                System.out.print(" | Titulo: " + c.getTitulo());
                System.out.print(" | Hora Aula: " + c.getHoraAula());
                System.out.print(" | Dias: " + c.getDias());
                System.out.println("\n-------------------------------------------------------------------------------");
            }
        }
    }

}
