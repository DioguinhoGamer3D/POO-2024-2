package br.ufpb.dcx.diogo.sisprof;

import java.util.List;

public class Disciplina {
    private String nome;
    private int codigo;
    private List<Horario> horarios;
    private int matriculaProfessor;

    public Disciplina(String nome, int codigo, int matriculaProf, List<Horario> hoarios){
        this.nome=nome;
        this.codigo=codigo;
        this.horarios=hoarios;
        this.matriculaProfessor =matriculaProf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<Horario> getHorarios() {
        return this.horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public int getMatriculaProfessor() {
        return this.matriculaProfessor;
    }

    public void setMatriculaProfessor(int matriculaProfessor) {
        this.matriculaProfessor = matriculaProfessor;
    }
}
