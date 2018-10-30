
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.imageio.ImageIO;

/**
 *
 * @author Joao Otavio
 */
public class ClienteSocket {

    public static void main(String[] args) throws IOException {

        Socket servidor = new Socket("localhost", 6969);

        System.out.println("Conectou...");

        ObjectInputStream recebe = null;
        ObjectOutputStream envia = null;

        envia = new ObjectOutputStream(servidor.getOutputStream());
        recebe = new ObjectInputStream(servidor.getInputStream());

        int idade = 25;
        envia.writeInt(idade);
        idade = recebe.readInt();
        envia.flush();

        BufferedImage img = ImageIO.read(new File("C:\\Users\\joaoo\\Pictures\\1.jpg"));
        envia.writeObject(retornaImagem(img));
        envia.flush();

        System.out.println("Idade recebida do servidor: " + idade);
        servidor.close();
    }

    public static byte[] retornaImagem(BufferedImage originalImage) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            
            ImageIO.write(originalImage, "jpg", baos);
            baos.flush();
            
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            
            return imageInByte;
            
        } catch (IOException e) {
            System.out.println("Erro ao retornar imagem: " + e.getMessage());
        }
        return null;
    }
}
