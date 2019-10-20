package ArvoreBinaria;

/**
 *
 * @author Joao Otávio Mota Roriz
 */
public class No {

    private int valor;
    private No esquerda;
    private No direita;

    public No() {
    }

    public No(int valor) {
        this.valor = valor;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public No getDireita() {
        return direita;
    }

    public void setEsquerda(No p_esquerda) {
        esquerda = p_esquerda;
    }

    public void setDireita(No p_direita) {
        direita = p_direita;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        valor = valor;
    }
}
