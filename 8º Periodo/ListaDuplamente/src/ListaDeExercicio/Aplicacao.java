package ListaDeExercicio;

import listaduplamente.*;

/**
 *
 * @author Joao Otávio Mota Roriz
 */
public class Aplicacao {

    public static void main(String args[]) {

        ListaDuplamente lista = new ListaDuplamente();
        ListaDuplamente lista2 = new ListaDuplamente();

        System.out.println("Lista inserindo no final");
        for (int i = 1; i <= 5; i++) {
            lista.addNoFim(i);
        }

        lista.imprimeLista();
        System.out.println("\n");

        System.out.println("Lista inserindo no inicio");
        lista.addNoInicio(50);
        lista.addNoInicio(40);
        lista.addNoInicio(30);

        lista.imprimeLista();

        System.out.println("\n\nRemovendo o elemento [30]...");
        lista.removeLista(30);

        System.out.println("Lista depois de Remover o elemento");
        lista.imprimeLista();
        
        System.out.println("\n\nLista invertida!");
        lista.inverteLista();
        lista.imprimeLista();
        
        System.out.println("\n\n Lista concatenada");
        lista2.addNoInicio(500);
        lista2.addNoInicio(400);
        lista2.addNoInicio(300);
        
        lista2.concatenaLista(lista2, lista);
        lista2.imprimeLista();
    }
}
