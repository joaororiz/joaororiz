package ClienteTCP;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author João Otávio Mota Roriz
 */
public class TCPCliente {

    public final static int SOCKET_PORTA = 13267;
    public final static String FILE_TO_SEND = "C:\\Users\\joaoo\\OneDrive\\Documentos\\NetBeansProjects\\9º Periodo\\Sistemas distribuidos\\TCPServidor\\src\\Arq\\arq.txt";

    public static void main(String[] args) {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        OutputStream os = null;
        ServerSocket servsock = null;
        Socket sock = null;

        try {
            //conecta o socket a porta remota

            while (true) {
                System.out.println("*** Enviando...");
                sock = servsock.accept();
                System.out.println("*** Conexao aceita : " + sock);
                
                // Enviat Arquivo
                File arquivo = new File(FILE_TO_SEND);
                byte[] bt = new byte[(int) arquivo.length()];
                fis = new FileInputStream(arquivo);
                bis = new BufferedInputStream(fis);
                bis.read(bt, 0, bt.length);
                os = sock.getOutputStream();
                os.write(bt, 0, bt.length);
                os.flush();
                System.out.println("*** Enviado...");
            }
        } catch (UnknownHostException e) {
            System.out.println("!!! Servidor desconhecido: " + e.getMessage());
        } catch (EOFException e) {
            System.out.println("!!! Nao ha mais dados de entrada: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("!!! E/S: " + e.getMessage());
        } finally {
            if (sock != null) {
                try {
                    sock.close();
                } catch (Exception e) {
                    System.out.println("!!! Encerramento do socket falhor: " + e.getMessage());
                }
            }
        }
    }
}
