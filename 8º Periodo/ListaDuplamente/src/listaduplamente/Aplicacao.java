package listaduplamente;

/**
 *
 * @author Joao Otávio Mota Roriz
 */
public class Aplicacao {

    public static void main(String args[]) {

        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

        System.out.println("Lista inserindo no final");
        for (int i = 1; i <= 5; i++) {
            lista.addNoFim(i);
        }

        lista.imprimeLista();
        System.out.println("\n\n");

        System.out.println("Lista inserindo no inicio");
        lista.addNoInicio(50);
        lista.addNoInicio(40);
        lista.addNoInicio(30);

        lista.imprimeLista();

        lista.removeLista(30);

        System.out.println("\n\nLista depois de Remover os elementos");
        lista.imprimeLista();
    }
}
