package ListaDeExercicio;

import listaduplamente.*;

/**
 *
 * @author João Otávio Mota Roriz
 */
public class ListaDuplamente {

    private No inicio;
    private No fim;
    private int size;

    public ListaDuplamente() {
        this.inicio = null;
        this.fim = null;
        this.size = 0;
    }

    public void addNoFim(Object info) {
        No NovoNo = new No(inicio, null, info);
        if (inicio == null) {
            inicio = fim = NovoNo;
        } else {
            fim.setProx(NovoNo);
            fim = NovoNo;
            size++;
        }
    }

    public void addNoInicio(Object info) {
        No novoNo = new No(null, inicio, info);
        if (inicio == null) {
            inicio = fim = novoNo;
        } else {
            inicio.setAnt(novoNo);
            inicio = novoNo;
            size++;
        }
    }

    public No procuraElemento(Object elemento) {
        No noAux = inicio;
        while ((noAux != null) && (noAux.getInfo() != elemento)) {
            noAux = noAux.getProx();
        }
        if ((noAux != null) && (noAux.getInfo() == elemento)) {
            return noAux;
        }
        return null;

    }

    public void removeLista(Object elemento) {
        No pos;
        pos = procuraElemento(elemento);
        if (pos != null) {
            if (inicio != fim) {
                if (pos == inicio) {
                    inicio = pos.getProx();
                    pos.getProx().setAnt(null);
                } else if (pos == fim) {
                    fim = pos.getAnt();
                    pos.getAnt().setProx(null);
                } else {
                    pos.getAnt().setProx(pos.getProx());
                    pos.getProx().setAnt(pos.getAnt());
                }
                pos.setAnt(null);
                pos.setProx(null);
            } else {
                inicio = null;
                fim = null;
            }
        } else {
            System.out.println("Elemento nao encontrado!");
        }

    }

    public void imprimeLista() {
        No NoAux;
        NoAux = inicio;
        while (NoAux != null) {
            System.out.print("[" + NoAux.getInfo() + "] ");
            NoAux = NoAux.getProx();
        }
    }

    public void imprimeListaRecusriva() {
        No NoAux;
        NoAux = inicio;
        while (NoAux != null) {
            System.out.print("[" + NoAux.getInfo() + "] ");
            NoAux = NoAux.getProx();
        }
    }

    public void inverteLista() {
        No NoAux;
        NoAux = this.fim;
        while (NoAux != null) {
            System.out.print("[" + NoAux.getInfo() + "] ");
            NoAux = NoAux.getAnt();
//            System.out.println("testes" + NoAux.getInfo());
        }
    }

    public void concatenaLista(ListaDuplamente lista1, ListaDuplamente lista2) {
        No NoAux;
        No NoAux1;
        NoAux = lista1.inicio;
        NoAux1 = lista2.inicio;
        while (NoAux != null) {
            if (NoAux == null) {
                NoAux.setProx(lista2.inicio);
                NoAux1.setAnt(lista1.fim);
            }
            NoAux = NoAux.getProx();
//            System.out.println("testes" + NoAux.getInfo());
        }
    }

}
