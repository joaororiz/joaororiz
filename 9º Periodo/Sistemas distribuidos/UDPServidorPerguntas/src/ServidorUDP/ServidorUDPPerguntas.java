package ServidorUDP;

/**
 *
 * @author João Otávio Mota Roriz
 */
import java.net.*;
import java.io.*;

public class ServidorUDPPerguntas {

    public static void main(String[] args) throws SocketException, IOException {

        char[] gabarito = new char[10];
        int acerto = 0, erro = 0;

        gabarito[0] = 'V';
        gabarito[1] = 'V';
        gabarito[2] = 'V';
        gabarito[3] = 'V';
        gabarito[4] = 'V';
        gabarito[5] = 'F';
        gabarito[6] = 'F';
        gabarito[7] = 'F';
        gabarito[8] = 'F';
        gabarito[9] = 'F';

        //cria um socket udp
        DatagramSocket s = new DatagramSocket(54545);
        byte[] buffer = new byte[1000];
        System.out.println(" *** Servidor aguardando request");

        while (true) {
            //cria datagrama para receber request do cliente
            DatagramPacket r = new DatagramPacket(buffer, buffer.length);
            s.receive(r);
            
            System.out.println(" *** Request recebido de: " + r.getAddress() + " msg: " + new String(r.getData()));

            String resposta = new String(r.getData());

            String[] aux = resposta.split(";");
            
            String compara = aux[2];
            for (int i = 0; i < Integer.parseInt(aux[1]); i++) {
                if (compara.charAt(i) == gabarito[i]) {
                    acerto++;
                } else {
                    erro++;
                }
            }

            String fim = String.valueOf("questao: " + aux[0]) + ";" + "Acertos: " + String.valueOf(acerto) + ";" + "Erros: " + String.valueOf(erro);
            System.out.println("fim:" + fim);
            r.setData(fim.getBytes());

            //envia resposta
            DatagramPacket resp = new DatagramPacket(r.getData(), r.getLength(), r.getAddress(), r.getPort());
            s.send(resp);
            s.close();
        }
    }
}
