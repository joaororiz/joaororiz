package Model.BEANS;

import java.sql.Date;

public class BEAN_Aluno {

    private int idAluno;
    private String nomeAluno;
    private String CPFAluno;
    private Date dataNascimentoAluno;
    private String statusAluno;

    public BEAN_Aluno() {
    }

    public BEAN_Aluno(int idAluno, String nomeAluno, String CPFAluno, Date dataNascimentoAluno, String statusAluno) {
        this.idAluno = idAluno;
        this.nomeAluno = nomeAluno;
        this.CPFAluno = CPFAluno;
        this.dataNascimentoAluno = dataNascimentoAluno;
        this.statusAluno = statusAluno;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getCPFAluno() {
        return CPFAluno;
    }

    public void setCPFAluno(String CPFAluno) {
        this.CPFAluno = CPFAluno;
    }

    public Date getDataNascimentoAluno() {
        return dataNascimentoAluno;
    }

    public void setDataNascimentoAluno(Date dataNascimentoAluno) {
        this.dataNascimentoAluno = dataNascimentoAluno;
    }

    public String getStatusAluno() {
        return statusAluno;
    }

    public void setStatusAluno(String statusAluno) {
        this.statusAluno = statusAluno;
    }
}