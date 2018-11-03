package ed1_pilha;

/**
 *
 * @author Joao Otávio Mota Roriz
 */
public class Pilha {

    public Object[] pilha;
    public int posicaoPilha;

    public Pilha() {
        this.posicaoPilha = -1;
        this.pilha = new Object[100];
    }

    public boolean estaVazia() {
        if (this.posicaoPilha == -1) {
            return true;
        }
        return false;
    }

    public boolean estaCheia() {
        if (this.posicaoPilha == 99) {
            return true;
        }
        return false;
    }

    public int tamanhoPilha() {
        if (this.estaVazia()) {
            return 0;
        }
        return this.posicaoPilha + 1;
    }

    public void adicionar(Object valor) {
        if (!this.estaCheia()) {
            this.pilha[++posicaoPilha] = valor;
        } else {
            System.out.println("Cheia!");
        }
    }

    public Object remover() {
        if (estaVazia()) {
            return null;
        }
        return this.pilha[this.posicaoPilha--];
    }

    public Object topo() {
        if (estaVazia()) {
            return null;
        }
        return this.pilha[this.posicaoPilha];
    }
}
