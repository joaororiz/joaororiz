package ed1_fila;

/**
 *
 * @author Joao Otávio Mota Roriz
 */
public class Aplicacao {

    public static void main(String[] args) {
        FilaCircular fila = new FilaCircular();
        
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        fila.inserir(40);
        fila.inserir(50);
        fila.inserir(60);
        fila.inserir(70);
        fila.inserir(80);
        fila.inserir(90);
        fila.remover();
        
        System.out.println("Esta cheia? " + fila.estaCheia());
    }
}
