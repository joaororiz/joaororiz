package Aula1_lista;

import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author João Otávio Mota Roriz
 */
public class EstruturaDeDadosI {

    public static void main(String[] args) {

        Lista lista = new Lista();

        lista.adicionar(0, 7);
        lista.imprimir();

        lista.adicionar(0, 4);
        lista.imprimir();

        System.out.println(lista.get(1));

        lista.adicionar(2, 2);
        lista.imprimir();

        System.out.println(lista.get(3));

        System.out.println(lista.remover(1));
        lista.imprimir();

        lista.adicionar(1, 5);
        lista.imprimir();

        lista.adicionar(1, 3);
        lista.imprimir();

        lista.adicionar(4, 9);
        lista.imprimir();

        lista.get(2);
        lista.imprimir();

        lista.set(3, 8);
        lista.imprimir();
    }
}
