package ArvoreBinaria;

/**
 *
 * @author Joao Otávio Mota Roriz
 */
public class Aplicacao {

    public static void main(String args[]) {

       ArvoreBinaria arvore = new ArvoreBinaria();
       
        arvore.inserir(15);
        arvore.inserir(7);
        arvore.inserir(20);
        arvore.inserir(18);
        arvore.inserir(19);
        arvore.inserir(16);
        arvore.inserir(8);
        
        System.out.println("");
        System.out.println("Em pós-ordem: ");
        arvore.posOrdem();
        arvore.remover(16);
        System.out.println("\n");
        System.out.println("Em pré-ordem: ");
        arvore.preOrdem();
        System.out.println("\n");
        System.out.println("Em ordem: ");
        arvore.emOrdem();
        
        int valorbuscado = 8;        
        System.out.println("\n\nExiste o valor " + valorbuscado + "? " + arvore.buscar(8));
    }
}
