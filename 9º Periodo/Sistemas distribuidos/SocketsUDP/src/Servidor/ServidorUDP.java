package Servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author João Otávio Mota Roriz
 */
public class ServidorUDP {
    
    public static void main(String[] args) throws SocketException, IOException {
        
        DatagramSocket s = new DatagramSocket(6789);
        byte[] buffer = new byte[1000];
        System.out.println("*** Servidor aguardando request");

        //cria datagrama para receber request do cliente
        DatagramPacket r = new DatagramPacket(buffer, buffer.length);
        s.receive(r);
        System.out.println("*** Request recebido de: " + r.getAddress());
        
        //Inverte mensagem
        StringBuilder msgRecebida = new StringBuilder(new String(r.getData()));
        String fraseInvertida = String.valueOf(msgRecebida.reverse());
        r.setData(fraseInvertida.getBytes());
        
        
        //envia resposta
        DatagramPacket resp = new DatagramPacket(r.getData(), r.getLength(), r.getAddress(), r.getPort());
        s.send(resp);
        s.close();
    }   
}
