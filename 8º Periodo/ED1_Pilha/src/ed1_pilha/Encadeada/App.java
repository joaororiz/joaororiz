package ed1_pilha.Encadeada;

/**
 *
 * @author João Otávio Mota Roriz
 * 
 *     Uma mensagem é criptografada invertendo cada palavre do texto "Uma mensagem confidencial"
 * criptografado fica "amU megasnem laicnedifnoc". Implemente a criptografia a e descriptografia
 * de mensagem utilizando Pilha.
 *     Para pegar a caracteres específicos de uma String, utilize seu método CharAt(int).
 */
public class App {

    public static void main(String[] args) {

        Pilha pilha = new Pilha();

        String mensagem = "Uma mensagem confidencial";
        String mensagem1 = "Uma mensagem confidencial";
        
        System.out.println("Criptografada!");
        pilha.criptografia(mensagem);
        System.out.println(pilha.imprimirComoInserido());
        
        System.out.println("\nDecriptografada!");
        pilha.decriptografia(mensagem1);
        System.out.println(pilha.imprimirComoInserido());
    }
}
