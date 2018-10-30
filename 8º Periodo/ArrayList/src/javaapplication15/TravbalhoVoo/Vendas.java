package javaapplication15.TravbalhoVoo;

import java.io.Serializable;

/**
 *
 * @author Joao Otávio Mota Roriz
 */
public class Vendas implements Serializable {

    private int codigo;
    private int cliente;
    private int voo;
    private float valor;

    public Vendas() {
    }

    public Vendas(int codigo, int cliente, int voo, float valor) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.voo = voo;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getVoo() {
        return voo;
    }

    public void setVoo(int voo) {
        this.voo = voo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

}
