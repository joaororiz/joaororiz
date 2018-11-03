package ed1_pilha.Encadeada;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Joao Otávio Mota Roriz
 */
public class Pilha {

    private List<Object> itens = new LinkedList<Object>();

    public Object insere(Object item) {
        this.itens.add(item);
        return null;
    }

    public Object remove() {
        return this.itens.remove(this.itens.size() - 1);
    }

    public boolean estaVazia() {
        return this.itens.size() == 0;
    }

    public String imprimirDesempilhando() {
        StringBuilder sb = new StringBuilder();
        while (!estaVazia()) {
            for (int i = 0; i < itens.size(); i++) {
                sb.append(" [");
                sb.append(remove());
                sb.append("] ");
            }
        }
        return sb.toString();
    }

    public String imprimirComoInserido() {
        StringBuilder sb = new StringBuilder();
        Pilha pilhaAux1 = new Pilha();
        Pilha pilhaAux2 = new Pilha();

        while (!estaVazia()) {
            pilhaAux1.insere(this.remove());
        }

        while (!pilhaAux1.estaVazia()) {
            pilhaAux2.insere(pilhaAux1.remove());
        }

        while (!pilhaAux2.estaVazia()) {
            this.insere(pilhaAux2.remove());
        }

        while (!estaVazia()) {
            for (int i = 0; i < itens.size(); i++) {
                sb.append(" [");
                sb.append(this.remove());
                sb.append("] ");
            }
        }
        return sb.toString();
    }

    public void criptografia(String msg) {
        for (int i = 0; i < msg.length(); i++) {
            insere(msg.charAt(i));
        }
    }

    public void decriptografia(String msg) {
        Pilha pilhaAux = new Pilha();
        
        for (int i = 0; i < msg.length(); i++) {
            pilhaAux.insere(msg.charAt(i));
        }
        
        while (!pilhaAux.estaVazia()) {
            this.insere(pilhaAux.remove());
        }
    }
}
