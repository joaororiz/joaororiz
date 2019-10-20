package ArvoreBinaria_AVL;

/**
 *
 * @author Joao Otávio Mota Roriz
 */
public class Aplicacao {

    public static void main(String args[]) {

       ArvoreAvl arvoreAvl = new ArvoreAvl();
       
        arvoreAvl.inserir(15);
        arvoreAvl.inserir(7);
        arvoreAvl.inserir(20);
        arvoreAvl.inserir(18);
        arvoreAvl.inserir(19);
        arvoreAvl.inserir(16);
        arvoreAvl.inserir(8);
        
        System.out.println(arvoreAvl.emOrdem());
    }
}
