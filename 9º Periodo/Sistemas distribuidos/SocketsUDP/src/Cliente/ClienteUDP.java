
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author João Otávio Mota Roriz
 */
public class ClienteUDP {

    public static void main(String[] args) throws SocketException, IOException {

        //cria um socket UDP
        DatagramSocket s = new DatagramSocket();
        System.out.println("*** Socket criado na porta: " + s.getLocalPort());
        byte[] byteArg = args[0].getBytes(); //transforma args em bytes

        InetAddress serv = InetAddress.getByName(args[1]);
        int porta = 54545;
        DatagramPacket req = new DatagramPacket(byteArg, args[0].length(), serv, porta);

        //envia datagrama contendo a mensagem m
        s.send(req);

        byte[] buffer = new byte[1000];
        DatagramPacket resp = new DatagramPacket(buffer, buffer.length);
        s.setSoTimeout(10000); //tempo de resposta

        //recebe resposta do servidor 
        s.receive(resp);
        System.out.println("* Resposta do servidor " + new String(resp.getData()));

        s.close();
    }
}
