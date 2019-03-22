//package ServidorTCP;
//
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.InetAddress;
//import java.net.ServerSocket;
//import java.net.Socket;
//
///**
// *
// * @author João Otávio Mota Roriz
// */
//public class TCPServidor {
//
//    public static Integer PORTA = 6789;
//    public final static String FILE_TO_RECEIVED = "C:\\Users\\joaoo\\OneDrive\\Documentos\\NetBeansProjects\\9º Periodo\\Sistemas distribuidos\\TCPServidor\\src\\Arq\\arqbaixado.txt";
//    public final static String SERVER = "127.0.0.1";  // localhost
//    public final static int FILE_SIZE = 6022386;
//
//    public static void main(String[] args) throws IOException {
//        int bytesRead;
//        int current = 0;
//        FileOutputStream fos = null;
//        BufferedOutputStream bos = null;
//        Socket sock = null;
//        try {
//
//            if (args.length > 0) {
//                PORTA = Integer.parseInt(args[0]);
//            }
//            sock = new Socket(SERVER, PORTA);
//            System.out.println("*** Servidor ***");
//            System.out.println("*** Porta de escuta (listen): " + PORTA);
//
//            while (true) {
//                //accept: bloqueia servidor até que chegue um pedido de conexão de um cliente
//                Socket cliente = sock.accept();
//                System.out.println("*** Conexão aceita de (remoto): " + cliente.getRemoteSocketAddress());
//
//                // receive file
//                byte[] mybytearray = new byte[FILE_SIZE];
//                InetAddress is = sock.getInetAddress();
//                fos = new FileOutputStream(FILE_TO_RECEIVED);
//                bos = new BufferedOutputStream(fos);
//                bytesRead = is.read(mybytearray, 0, mybytearray.length);
//                current = bytesRead;
//
//                do {
//                    bytesRead
//                            = is.read(mybytearray, current, (mybytearray.length - current));
//                    if (bytesRead >= 0) {
//                        current += bytesRead;
//                    }
//                } while (bytesRead > -1);
//
//                bos.write(mybytearray, 0, current);
//                bos.flush();
//                System.out.println("File " + FILE_TO_RECEIVED
//                        + " downloaded (" + current + " bytes read)");
//            }
//        } catch (IOException e) {
//            System.out.println("Erro na escuta: " + e.getMessage());
//        } finally {
//            if (fos != null) {
//                fos.close();
//            }
//            if (bos != null) {
//                bos.close();
//            }
//            if (sock != null) {
//                sock.close();
//            }
//        }
//    }
//}
