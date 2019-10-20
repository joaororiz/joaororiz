package ArvoreBinaria_AVL;

import java.util.ArrayList;

/**
 *
 * @author João Otávio Mota Roriz
 */
public class ArvoreAvl {

    protected No raiz;

    public void inserir(int valor) {
        No novoNo = new No(valor);
        inserirAVL(this.raiz, novoNo);
    }

    public void inserirAVL(No aComparar, No aInserir) {

        if (aComparar == null) {
            this.raiz = aInserir;

        } else {

            if (aInserir.getChave() < aComparar.getChave()) {

                if (aComparar.getEsquerda() == null) {
                    aComparar.setEsquerda(aInserir);
                    aInserir.setPai(aComparar);
                    verificarBalanceamento(aComparar);

                } else {
                    inserirAVL(aComparar.getEsquerda(), aInserir);
                }

            } else if (aInserir.getChave() > aComparar.getChave()) {

                if (aComparar.getDireita() == null) {
                    aComparar.setDireita(aInserir);
                    aInserir.setPai(aComparar);
                    verificarBalanceamento(aComparar);

                } else {
                    inserirAVL(aComparar.getDireita(), aInserir);
                }

            } else {
                // O nó já existe
            }
        }
    }

    public void verificarBalanceamento(No atual) {
        setBalanceamento(atual);
        int balanceamento = atual.getBalanceamento();

        if (balanceamento == -2) {

            if (altura(atual.getEsquerda().getEsquerda()) >= altura(atual.getEsquerda().getDireita())) {
                atual = rotacaoDireita(atual);

            } else {
                atual = duplaRotacaoEsquerdaDireita(atual);
            }

        } else if (balanceamento == 2) {

            if (altura(atual.getDireita().getDireita()) >= altura(atual.getDireita().getEsquerda())) {
                atual = rotacaoEsquerda(atual);

            } else {
                atual = duplaRotacaoDireitaEsquerda(atual);
            }
        }

        if (atual.getPai() != null) {
            verificarBalanceamento(atual.getPai());
        } else {
            this.raiz = atual;
        }
    }

    public void remover(int valor) {
        removerAVL(this.raiz, valor);
    }

    public void removerAVL(No atual, int valor) {
        if (atual == null) {
            return;

        } else {

            if (atual.getChave() > valor) {
                removerAVL(atual.getEsquerda(), valor);

            } else if (atual.getChave() < valor) {
                removerAVL(atual.getDireita(), valor);

            } else if (atual.getChave() == valor) {
                removerNoEncontrado(atual);
            }
        }
    }

    public void removerNoEncontrado(No aRemover) {
        No novoNo;
        if (aRemover.getEsquerda() == null || aRemover.getDireita() == null) {

            if (aRemover.getPai() == null) {
                this.raiz = null;
                aRemover = null;
                return;
            }
            novoNo = aRemover;

        } else {
            novoNo = sucessor(aRemover);
            aRemover.setChave(novoNo.getChave());
        }

        No noAux;
        if (novoNo.getEsquerda() != null) {
            noAux = novoNo.getEsquerda();
        } else {
            noAux = novoNo.getDireita();
        }

        if (noAux != null) {
            noAux.setPai(novoNo.getPai());
        }

        if (novoNo.getPai() == null) {
            this.raiz = noAux;
        } else {
            if (novoNo == novoNo.getPai().getEsquerda()) {
                novoNo.getPai().setEsquerda(noAux);
            } else {
                novoNo.getPai().setDireita(noAux);
            }
            verificarBalanceamento(novoNo.getPai());
        }
        novoNo = null;
    }

    public No rotacaoEsquerda(No inicial) {

        No direita = inicial.getDireita();
        direita.setPai(inicial.getPai());

        inicial.setDireita(direita.getEsquerda());

        if (inicial.getDireita() != null) {
            inicial.getDireita().setPai(inicial);
        }

        direita.setEsquerda(inicial);
        inicial.setPai(direita);

        if (direita.getPai() != null) {

            if (direita.getPai().getDireita() == inicial) {
                direita.getPai().setDireita(direita);

            } else if (direita.getPai().getEsquerda() == inicial) {
                direita.getPai().setEsquerda(direita);
            }
        }

        setBalanceamento(inicial);
        setBalanceamento(direita);

        return direita;
    }

    public No rotacaoDireita(No inicial) {

        No esquerda = inicial.getEsquerda();
        esquerda.setPai(inicial.getPai());

        inicial.setEsquerda(esquerda.getDireita());

        if (inicial.getEsquerda() != null) {
            inicial.getEsquerda().setPai(inicial);
        }

        esquerda.setDireita(inicial);
        inicial.setPai(esquerda);

        if (esquerda.getPai() != null) {

            if (esquerda.getPai().getDireita() == inicial) {
                esquerda.getPai().setDireita(esquerda);

            } else if (esquerda.getPai().getEsquerda() == inicial) {
                esquerda.getPai().setEsquerda(esquerda);
            }
        }

        setBalanceamento(inicial);
        setBalanceamento(esquerda);

        return esquerda;
    }

    public No duplaRotacaoEsquerdaDireita(No inicial) {
        inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
        return rotacaoDireita(inicial);
    }

    public No duplaRotacaoDireitaEsquerda(No inicial) {
        inicial.setDireita(rotacaoDireita(inicial.getDireita()));
        return rotacaoEsquerda(inicial);
    }

    public No sucessor(No NovoNo) {
        if (NovoNo.getDireita() != null) {
            No r = NovoNo.getDireita();
            while (r.getEsquerda() != null) {
                r = r.getEsquerda();
            }
            return r;
        } else {
            No p = NovoNo.getPai();
            while (p != null && NovoNo == p.getDireita()) {
                NovoNo = p;
                p = NovoNo.getPai();
            }
            return p;
        }
    }

    private int altura(No atual) {
        if (atual == null) {
            return -1;
        }

        if (atual.getEsquerda() == null && atual.getDireita() == null) {
            return 0;

        } else if (atual.getEsquerda() == null) {
            return 1 + altura(atual.getDireita());

        } else if (atual.getDireita() == null) {
            return 1 + altura(atual.getEsquerda());

        } else {
            return 1 + Math.max(altura(atual.getEsquerda()), altura(atual.getDireita()));
        }
    }

    private void setBalanceamento(No no) {
        no.setBalanceamento(altura(no.getDireita()) - altura(no.getEsquerda()));
    }

    final protected ArrayList<No> emOrdem() {
        ArrayList<No> nos = new ArrayList<No>();
        emOrdem(raiz, nos);
        return nos;
    }

    final protected void emOrdem(No no, ArrayList<No> listaDeNos) {
        if (no == null) {
            return;
        }
        emOrdem(no.getEsquerda(), listaDeNos);
        listaDeNos.add(no);
        emOrdem(no.getDireita(), listaDeNos);
    }
}
