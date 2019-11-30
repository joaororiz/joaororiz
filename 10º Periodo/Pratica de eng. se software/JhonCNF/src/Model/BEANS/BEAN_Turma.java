package Model.BEANS;

import java.sql.Date;

public class BEAN_Turma {

    private int idTurma;
    private String nomeTurma;
    private String descricaoTurma;
    private int disciplina_idDisciplina;
    private int professor_idProfessor;
    private String statusTurma;

    public BEAN_Turma() {
    }

    public BEAN_Turma(int idTurma, String nomeTurma, String descricaoTurma, int disciplina_idDisciplina, int professor_idProfessor, String statusTurma) {
        this.idTurma = idTurma;
        this.nomeTurma = nomeTurma;
        this.descricaoTurma = descricaoTurma;
        this.disciplina_idDisciplina = disciplina_idDisciplina;
        this.professor_idProfessor = professor_idProfessor;
        this.statusTurma = statusTurma;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public String getDescricaoTurma() {
        return descricaoTurma;
    }

    public void setDescricaoTurma(String descricaoTurma) {
        this.descricaoTurma = descricaoTurma;
    }

    public int getDisciplina_idDisciplina() {
        return disciplina_idDisciplina;
    }

    public void setDisciplina_idDisciplina(int disciplina_idDisciplina) {
        this.disciplina_idDisciplina = disciplina_idDisciplina;
    }

    public int getProfessor_idProfessor() {
        return professor_idProfessor;
    }

    public void setProfessor_idProfessor(int professor_idProfessor) {
        this.professor_idProfessor = professor_idProfessor;
    }

    public String getStatusTurma() {
        return statusTurma;
    }

    public void setStatusTurma(String statusTurma) {
        this.statusTurma = statusTurma;
    }
}