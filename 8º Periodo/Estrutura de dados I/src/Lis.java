

/**
 *
 * @author Joao Otávio Mota Roriz
 */
public class Lis {

    int tamanho = 10, qtdeElementos = 0;
    Object[] lista = new Object[tamanho];

    public Object get(int i) {
        if (i < 0 || i > tamanho - 1) {
            System.out.println("Erro ao retornar o elemento!");
        } else {
            return lista[i];
        }
        return 0;
    }

    public Object set(int i, int e) {
        if (i < 0 || i > tamanho - 1) {
            System.out.println("Erro ao setar o elemento!");
        } else {
            Object aux = lista[i];
            lista[i] = e;
            return aux;
        }
        return 0;
    }

    public boolean isEmpty() {
        if (qtdeElementos == 0) {
            return true;
        }
        return false;
    }

    public void adicionar(int i, int e) {
        if (i < 0 || i > tamanho - 1) {
            System.out.println("Erro ao adicionar o elemento!");
        } else if(lista[i] != null){
            lista[i + 1] = lista[i];
        }else if (isEmpty()) {
            lista[qtdeElementos] = e;
            qtdeElementos++;
        }
    }

    public Object remover(int i) {
        if (i < 0 || i > tamanho - 1) {
            System.out.println("Erro ao remover o elemento!");
        } else if (!isEmpty()) {
            Object aux = lista[i];
            lista[i] = 0;
            qtdeElementos--;
            return aux;
        }
        return 0;
    }

    public int size() {
        return this.lista.length;
    }

    public void mostrar() {
        String elementos = "";
        for (int i = 0; i < qtdeElementos; i++) {
            elementos += this.lista[i] + " - ";
        }
        System.out.println(elementos);
    }
}
