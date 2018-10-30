package ed1_fila;

/**
 *
 * @author João Otávio Mota Roriz
 */
public class FilaCircular {

    private int fila[];
    private int inicio;
    private int fim;
    private int tamanho;

    public FilaCircular() {
        this.fila = new int[10];
        this.inicio = 0;
        this.fim = 0;
        this.tamanho = fila.length;
    }

    public int incrementa(int valor) {
        if (this.fim == this.tamanho - 1) {
            valor = 0;
        } else {
            valor += 1;
        }
        return valor;
    }

    public boolean estaVazia() {
        if (inicio == fim) {
            return true;
        }
        return false;
    }

    public boolean estaCheia() {
        if (incrementa(fim) == inicio) {
            return true;
        }
        return false;
    }

    public void inserir(int elemento) {
        if (estaCheia()) {
            System.out.println("Esta cheia!");
        } else {
            fila[fim] = elemento;
            fim = incrementa(fim);
        }
    }

    public int remover() {
        int aux = 0;
        if (!estaVazia()) {
            aux = fila[inicio];
            inicio = incrementa(inicio);
            return aux;
        }
        return 0;
    }
}
