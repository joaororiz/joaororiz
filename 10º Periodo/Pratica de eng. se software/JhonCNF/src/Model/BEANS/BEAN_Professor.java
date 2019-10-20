package Model.BEANS;

import java.sql.Date;

public class BEAN_Professor {

    private int idProfessor;
    private String nomeProfessor;
    private Date dataNascimentoProfessor;
    private String usuarioProfessor;
    private String senhaProfessor;
    private String statusProfessor;

    public BEAN_Professor() {
    }

    public BEAN_Professor(int idProfessor, String nomeProfessor, Date dataNascimentoProfessor, String usuarioProfessor, String senhaProfessor, String statusProfessor) {
        this.idProfessor = idProfessor;
        this.nomeProfessor = nomeProfessor;
        this.dataNascimentoProfessor = dataNascimentoProfessor;
        this.usuarioProfessor = usuarioProfessor;
        this.senhaProfessor = senhaProfessor;
        this.statusProfessor = statusProfessor;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public Date getDataNascimentoProfessor() {
        return dataNascimentoProfessor;
    }

    public void setDataNascimentoProfessor(Date dataNascimentoProfessor) {
        this.dataNascimentoProfessor = dataNascimentoProfessor;
    }

    public String getUsuarioProfessor() {
        return usuarioProfessor;
    }

    public void setUsuarioProfessor(String usuarioProfessor) {
        this.usuarioProfessor = usuarioProfessor;
    }

    public String getSenhaProfessor() {
        return senhaProfessor;
    }

    public void setSenhaProfessor(String senhaProfessor) {
        this.senhaProfessor = senhaProfessor;
    }

    public String getStatusProfessor() {
        return statusProfessor;
    }

    public void setStatusProfessor(String statusProfessor) {
        this.statusProfessor = statusProfessor;
    }
}