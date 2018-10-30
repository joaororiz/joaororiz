package Aula1_lista;

/**
 *
 * @author Joao Otávio Mota Roriz
 */
public class Lista {

    public Object lista[];
    public int primero;
    public int ultimo;
    public int qtdElementos;

    public Lista() {
        this.lista = new Object[100];
        this.qtdElementos = 0;
        this.primero = 0;
        this.ultimo = 0;
    }

    public boolean isEmpty() {
        if (this.qtdElementos == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        if (this.isEmpty()) {
            return 0;
        }
        return this.qtdElementos + 1;
    }

    public Object get(int i) {
        if (i < 0 || i > this.qtdElementos - 1) {
            System.out.print("Erro ao retornar o elemento: ");
        } else {
            return lista[i];
        }
        return null;
    }

    public Object set(int i, int e) {
        if (i < 0 || i > this.qtdElementos - 1) {
            System.out.print("Erro ao setar o elemento: ");
        } else {
            Object aux = lista[i];
            lista[i] = e;
            return aux;
        }
        return null;
    }

    public void adicionar(int posicao, int valor) {
        if (ultimo >= lista.length) {
            System.out.println("Erro: Lista está cheia!");

        } else if (this.qtdElementos == 0 || posicao == this.qtdElementos) {
            this.lista[posicao] = valor;
            this.qtdElementos++;

        } else {
            Object aux = this.lista[qtdElementos - 1];
            int posi = this.qtdElementos;

            while (posi != posicao) {
                this.lista[posi] = this.lista[posi - 1];
                posi--;
            }

            this.lista[posicao] = valor;
            this.lista[this.qtdElementos] = aux;
            this.qtdElementos++;
        }
    }

    public Object remover(int i) {
        if (i < 0 || i > this.qtdElementos - 1) {
            System.out.println("Erro ao remover o elemento!");
        } else if (!isEmpty()) {
            Object aux = this.lista[i];
            int pos = i;
            while (pos < this.qtdElementos) {
                this.lista[pos] = this.lista[pos + 1];
                pos++;
            }
            this.qtdElementos--;
            return aux;
        }
        return null;
    }

    public void imprimir() {
        for (int count = 0; count < this.qtdElementos; count++) {
            System.out.print("[ " + this.lista[count] + " ]");
        }
        System.out.println("");
    }
}
