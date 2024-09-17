package Repositorio;

import java.util.ArrayList;

import Entidades.Instrutor;

public class InstrutorRepositorio {
    public ArrayList<Instrutor> instrutors = new ArrayList<>();

    public void adicionarInstrutor(Instrutor instrutor) {
        instrutors.add(instrutor);
    }

    public void removerInstrutor(int id) {
        instrutors.remove(id);
    }

    public ArrayList<Instrutor> listarInstrutor() {
        return instrutors;
    }

}
