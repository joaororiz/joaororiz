package javaapplication15.TravbalhoVoo;

import java.io.Serializable;

/**
 *
 * @author Joao Otávio Mota Roriz
 */
public class Voo implements Serializable{

    private int codigo;
    private String origem;
    private String destino;
    private String horas;
    private float valor;

    public Voo() {
    }

    public Voo(int codigo, String origem, String destino, String horas, float valor) {
        this.codigo = codigo;
        this.origem = origem;
        this.destino = destino;
        this.horas = horas;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

}
