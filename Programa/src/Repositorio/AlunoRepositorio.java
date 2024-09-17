package Repositorio;

import java.util.ArrayList;

import Entidades.Aluno;

public class AlunoRepositorio {
    public ArrayList<Aluno> alunos = new ArrayList<>();

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removerAluno(int id) {
        alunos.remove(id);
    }

    public ArrayList<Aluno> listarAluno() {
       return alunos;
    }

}
