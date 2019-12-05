package Model.BEANS;

import java.sql.Date;

public class BEAN_Turma {

    private int idTurma;
    private String nomeTurma;
    private String descricaoTurma;
    private int idDisciplina;
    private int idProfessor;
    private String statusTurma;

    public BEAN_Turma() {
    }

    public BEAN_Turma(int idTurma, String nomeTurma, String descricaoTurma, int disciplina_idDisciplina, int professor_idProfessor, String statusTurma) {
        this.idTurma = idTurma;
        this.nomeTurma = nomeTurma;
        this.descricaoTurma = descricaoTurma;
        this.idDisciplina = disciplina_idDisciplina;
        this.idProfessor = professor_idProfessor;
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

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getStatusTurma() {
        return statusTurma;
    }

    public void setStatusTurma(String statusTurma) {
        this.statusTurma = statusTurma;
    }
}