package Repositorio;

import java.util.ArrayList;

import Entidades.Curso;

public class CursoRepositorio {
    public ArrayList<Curso> cursos = new ArrayList<>();

    public void adicionarCurso(Curso curso) {
        cursos.add(curso);
    }

    public void removerCurso(int id) {
        cursos.remove(id);
    }

    public ArrayList<Curso> listarCurso() {
        return cursos;
    }

}
