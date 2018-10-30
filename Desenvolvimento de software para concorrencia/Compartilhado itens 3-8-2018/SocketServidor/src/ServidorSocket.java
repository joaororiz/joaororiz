
import java.awt.Image;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.ImageIcon;

/**
 *
 * @author Joao Otavio
 */
public class ServidorSocket {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ServerSocket serv = new ServerSocket(6969);

        ObjectInputStream recebe = null;
        ObjectOutputStream envia = null;

        System.out.println("Excutando...");

        Socket cliente = serv.accept();

        recebe = new ObjectInputStream(cliente.getInputStream());
        envia = new ObjectOutputStream(cliente.getOutputStream());

        int idade = recebe.readInt();
        envia.writeInt(idade);

        envia.flush();
        byte[] img = (byte[]) recebe.readObject();
        Image imgI = new ImageIcon(img).getImage();
        new ExibeImagem(imgI).setVisible(true);
        cliente.close();
    }

}
