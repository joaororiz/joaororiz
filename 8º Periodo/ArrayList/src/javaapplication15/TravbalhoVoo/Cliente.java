package javaapplication15.TravbalhoVoo;

import java.io.Serializable;

/**
 *
 * @author Joao Otávio Mota Roriz
 */
public class Cliente implements Serializable {

    private int codigo;
    private String nome;
    private String telefone;
    private String cpf;

    public Cliente() {

    }

    public Cliente(int codigo, String nome, String telefone, String cpf) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
