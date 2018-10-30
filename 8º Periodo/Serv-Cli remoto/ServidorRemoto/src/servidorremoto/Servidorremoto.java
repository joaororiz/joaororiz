package servidorremoto;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Servidorremoto extends Thread {

    public int mousex = 0, mousey = 0, count = 0;

    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
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
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ServerSocket server = null;

    class recebeComandos extends Thread {

        ObjectInputStream entrada = null;
        ObjectOutputStream saida = null;
        Robot robo = null;
        Socket s = null;

        public recebeComandos(Socket s) {

            count++;
            System.out.println("IP conectado: " + s.getInetAddress());
            System.out.println("Quantidade: " + count);
            this.s = s;
            try {
                robo = new Robot();
                entrada = new ObjectInputStream(s.getInputStream());
                saida = new ObjectOutputStream(s.getOutputStream());

            } catch (IOException ex) {
                Logger.getLogger(Servidorremoto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (AWTException ex) {
                Logger.getLogger(Servidorremoto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        JFrame jframe = new JFrame();

        public void run() {
            jframe.setSize(new Dimension(80, 80));
            jframe.setUndecorated(true);
            jframe.setVisible(true);
            while (true) {
                try {
                    String comando = entrada.readUTF();

                    if (comando.contains("imagem")) {
                        int x = entrada.readInt();
                        int y = entrada.readInt();
                        System.out.println(x + " " + y);
                        Image img
                                = robo.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())).
                                        getScaledInstance(x, y, Image.SCALE_FAST);
                        saida.writeObject(retornaImagem(toBufferedImage(img)));
                        saida.flush();
                    } else if (comando.contains("mousemove")) {
                        int tL = entrada.readInt();
                        int aH = entrada.readInt();

                        int x = entrada.readInt();
                        mousex = x;
                        int y = entrada.readInt();
                        mousey = y;
                        int dW = Toolkit.getDefaultToolkit().getScreenSize().width;
                        int dH = Toolkit.getDefaultToolkit().getScreenSize().height;

                        jframe.setLocation(((mousex * dW) / tL), ((mousey * dH) / aH));

//                        robo.mouseMove(((x * dW) / tL), ((y * dH) / aH));
                    } else if (comando.contains("mouseclick")) {
                        int mouse = entrada.readInt();
                        if (mouse == 0) {
                            robo.mousePress(InputEvent.BUTTON1_MASK);
                            robo.mouseRelease(InputEvent.BUTTON1_MASK);
//                            JFrame jframe = new JFrame();
//                            jframe.setSize(new Dimension(80, 80));
//                            jframe.setLocation(mousex, mousey);
//                            jframe.setUndecorated(true);
//                            jframe.setVisible(true);

                        } else {
                            robo.mousePress(InputEvent.BUTTON3_MASK);
                            robo.mouseRelease(InputEvent.BUTTON3_MASK);
                        }

                    } else if (comando.contains("keypressed")) {
                        int key = entrada.readInt();
                        robo.keyPress(key);
                        robo.keyRelease(key);

                    } else if (comando.contains("cmd")) {
                        Runtime.getRuntime().exec(entrada.readUTF());
                    }

                    //Açoes do robo
                } catch (IOException ex) {
                    Logger.getLogger(Servidorremoto.class.getName()).log(Level.SEVERE, null, ex);
                    break;
                }
            }
        }
    }

    public void run() {
        while (true) {

            try {
                server = new ServerSocket(3312);

                while (true) {
                    new recebeComandos(server.accept()).start();
                }
            } catch (IOException ex) {
                Logger.getLogger(Servidorremoto.class.getName()).log(Level.SEVERE, null, ex);
                break;
            }
        }
    }

    public static void main(String args[]) {

        new Servidorremoto().start();
    }
}
