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


/*
//Pilha
package Repositorio;

import java.util.Stack;

import Entidades.Curso;

public class CursoRepositorio {
    private Stack<Curso> pilhaCursos = new Stack<>();

    public void adicionarCurso(Curso curso) {
        pilhaCursos.push(curso); // Empilha o curso no topo
    }

    public void removerCurso() {
        if (!pilhaCursos.isEmpty()) {
            pilhaCursos.pop(); // Desempilha o curso do topo
        }
    }

    public Stack<Curso> listarCurso() {
        return pilhaCursos; // Retorna a pilha de cursos
    }
}
*/
