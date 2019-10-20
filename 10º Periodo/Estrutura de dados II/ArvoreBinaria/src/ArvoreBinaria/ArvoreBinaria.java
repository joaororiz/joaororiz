package ArvoreBinaria;

/**
 *
 * @author João Otávio Mota Roriz
 */
public class ArvoreBinaria {

    private No raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    public void inserir(int valor) {
        inserir(raiz, valor);
    }

    public void inserir(No node, int valor) {
        if (node == null) {
            System.out.println("No raiz: " + valor);
            raiz = new No(valor);
        } else {
            if (valor < node.getValor()) {
                if (node.getEsquerda() != null) {
                    inserir(node.getEsquerda(), valor);
                } else {
                    System.out.println("Inserindo " + valor + " a esquerda de " + node.getValor());
                    node.setEsquerda(new No(valor));
                }

            } else {
                if (node.getDireita() != null) {
                    inserir(node.getDireita(), valor);
                } else {
                    System.out.println("Inserindo " + valor + " a direita de " + node.getValor());
                    node.setDireita(new No(valor));
                }
            }
        }
    }

    public int buscar(int value) {
        if (raiz == null) {
            return 0; // se arvore vazia
        }
        No atual = raiz;  // começa a procurar desde raiz
        while (atual.getValor() != value) { // enquanto nao encontrou
            if (value < atual.getValor()) {
                atual = atual.getEsquerda(); // caminha para esquerda
            } else {
                atual = atual.getDireita(); // caminha para direita
            }
            if (atual == null) {
                return 0; // encontrou uma folha -> sai
            }
        } // fim laço while
        return atual.getValor(); // terminou o laço while e chegou aqui é pq encontrou getValor()
    }

    public boolean remover(int v) {
        if (raiz == null) {
            return false; // se arvore vazia
        }
        No atual = raiz;
        No pai = raiz;
        boolean filho_esq = true;

        // ****** Buscando o valor **********
        while (atual.getValor() != v) { // enquanto nao encontrou
            pai = atual;
            if (v < atual.getValor()) { // caminha para esquerda
                atual = atual.getEsquerda();
                filho_esq = true; // é filho a esquerda? sim
            } else { // caminha para direita
                atual = atual.getDireita();
                filho_esq = false; // é filho a esquerda? NAO
            }
            if (atual == null) {
                return false; // encontrou uma folha -> sai
            }
        }

        // Se nao possui nenhum filho (é uma folha), elimine-o
        if (atual.getEsquerda() == null && atual.getDireita() == null) {
            if (atual == raiz) {
                raiz = null; // se raiz
            } else if (filho_esq) {
                pai.setEsquerda(null); // se for filho a esquerda do pai
            } else {
                pai.setDireita(null); // se for filho a direita do pai
            }
        } // Se é pai e nao possui um filho a direita, substitui pela subarvore a direita
        else if (atual.getDireita() == null) {
            if (atual == raiz) {
                raiz = atual.getEsquerda(); // se raiz
            } else if (filho_esq) {
                pai.setEsquerda(atual.getEsquerda());// se for filho a esquerda do pai
            } else {
                pai.setDireita(atual.getEsquerda()); // se for filho a direita do pai
            }
        } // Se é pai e nao possui um filho a esquerda, substitui pela subarvore a esquerda
        else if (atual.getEsquerda() == null) {
            if (atual == raiz) {
                raiz = atual.getDireita(); // se raiz
            } else if (filho_esq) {
                pai.setEsquerda(atual.getDireita()); // se for filho a esquerda do pai
            } else {
                pai.setDireita(atual.getDireita()); // se for  filho a direita do pai
            }
        } // Se possui mais de um filho, se for um avô ou outro grau maior de parentesco
        else {
            No sucessor = no_sucessor(atual);
            // Usando sucessor que seria o Nó mais a esquerda da subarvore a direita do No que deseja-se remover
            if (atual == raiz) {
                raiz = sucessor; // se raiz
            } else if (filho_esq) {
                pai.setEsquerda(sucessor); // se for filho a esquerda do pai
            } else {
                pai.setDireita(sucessor); // se for filho a direita do pai
            }
            sucessor.setEsquerda(atual.getEsquerda()); // acertando o ponteiro a esquerda do sucessor agora que ele assumiu 
            // a posição correta na arvore   
        }

        return true;
    }

    // O sucessor é o Nó mais a esquerda da subarvore a direita do No que foi passado como parametro do metodo
    public No no_sucessor(No apaga) { // O parametro é a referencia para o No que deseja-se apagar
        No paidosucessor = apaga;
        No sucessor = apaga;
        No atual = apaga.getDireita(); // vai para a subarvore a direita

        while (atual != null) { // enquanto nao chegar no Nó mais a esquerda
            paidosucessor = sucessor;
            sucessor = atual;
            atual = atual.getEsquerda(); // caminha para a esquerda
        }

        if (sucessor != apaga.getDireita()) { // se sucessor nao é o filho a direita do Nó que deverá ser eliminado
            paidosucessor.setEsquerda(sucessor.getDireita()); // pai herda os filhos do sucessor que sempre serão a direita
            sucessor.setDireita(apaga.getDireita()); // guardando a referencia a direita do sucessor para 
            // quando ele assumir a posição correta na arvore
        }
        return sucessor;
    }

    public void preOrdem() {
        this.preOrdem(this.raiz);
    }

    public void preOrdem(No node) {
        if (node != null) {
            System.out.print("(" + node.getValor() + ") ");
            preOrdem(node.getEsquerda());
            preOrdem(node.getDireita());
        }
    }

    public void posOrdem() {
        this.posOrdem(this.raiz);
    }

    public void posOrdem(No node) {
        if (node != null) {
            posOrdem(node.getEsquerda());
            posOrdem(node.getDireita());
            System.out.print("(" + node.getValor() + ") ");
        }
    }

    public void emOrdem() {
        this.emOrdem(this.raiz);
    }

    public void emOrdem(No node) {
        if (node != null) {
            emOrdem(node.getEsquerda());
            System.out.print("(" + node.getValor() + ") ");
            emOrdem(node.getDireita());
        }
    }
}
