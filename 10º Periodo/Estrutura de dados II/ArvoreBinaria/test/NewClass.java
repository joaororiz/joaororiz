/**
 *
 * @author João Otávio Mota Roriz
 */
public class NewClass {
        
//    public boolean remover(int v) {
//        if (root == null) {
//            return false; // se arvore vazia
//        }
//        No atual = root;
//        No pai = root;
//        boolean filho_esq = true;
//
//        // ****** Buscando o valor **********
//        while (atual.item != v) { // enquanto nao encontrou
//            pai = atual;
//            if (v < atual.item) { // caminha para esquerda
//                atual = atual.esq;
//                filho_esq = true; // é filho a esquerda? sim
//            } else { // caminha para direita
//                atual = atual.dir;
//                filho_esq = false; // é filho a esquerda? NAO
//            }
//            if (atual == null) {
//                return false; // encontrou uma folha -> sai
//            }
//        } // fim laço while de busca do valor
//
//        // **************************************************************
//        // se chegou aqui quer dizer que encontrou o valor (v)
//        // "atual": contem a referencia ao No a ser eliminado
//        // "pai": contem a referencia para o pai do No a ser eliminado
//        // "filho_esq": é verdadeiro se atual é filho a esquerda do pai
//        // **************************************************************
//        // Se nao possui nenhum filho (é uma folha), elimine-o
//        if (atual.esq == null && atual.dir == null) {
//            if (atual == root) {
//                root = null; // se raiz
//            } else if (filho_esq) {
//                pai.esq = null; // se for filho a esquerda do pai
//            } else {
//                pai.dir = null; // se for filho a direita do pai
//            }
//        } // Se é pai e nao possui um filho a direita, substitui pela subarvore a direita
//        else if (atual.dir == null) {
//            if (atual == root) {
//                root = atual.esq; // se raiz
//            } else if (filho_esq) {
//                pai.esq = atual.esq; // se for filho a esquerda do pai
//            } else {
//                pai.dir = atual.esq; // se for filho a direita do pai
//            }
//        } // Se é pai e nao possui um filho a esquerda, substitui pela subarvore a esquerda
//        else if (atual.esq == null) {
//            if (atual == root) {
//                root = atual.dir; // se raiz
//            } else if (filho_esq) {
//                pai.esq = atual.dir; // se for filho a esquerda do pai
//            } else {
//                pai.dir = atual.dir; // se for  filho a direita do pai
//            }
//        } // Se possui mais de um filho, se for um avô ou outro grau maior de parentesco
//        else {
//            No sucessor = no_sucessor(atual);
//            // Usando sucessor que seria o Nó mais a esquerda da subarvore a direita do No que deseja-se remover
//            if (atual == root) {
//                root = sucessor; // se raiz
//            } else if (filho_esq) {
//                pai.esq = sucessor; // se for filho a esquerda do pai
//            } else {
//                pai.dir = sucessor; // se for filho a direita do pai
//            }
//            sucessor.esq = atual.esq; // acertando o ponteiro a esquerda do sucessor agora que ele assumiu 
//            // a posição correta na arvore   
//        }
//
//        return true;
//    }
}
