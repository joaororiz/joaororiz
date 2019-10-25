package chatbotAndAudio;

import Try_Google_Speech_Recognition_Simple.RecFalaPtBrGoogle;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.darkprograms.speech.recognizer.GoogleResponse;
import com.darkprograms.speech.synthesiser.SynthesiserV2;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * Arquivo do reconhecimento de fala.
 *
 * @author Adejair Júnior
 */
public class ChatBot_ReconhecimentoFala extends RecFalaPtBrGoogle {

    public static boolean perguntou = false;
    public static ChatBot_ReconhecimentoFala chatBot;

    public static void main(String[] args) {

        ChatBot_ReconhecimentoFala chatBot = new ChatBot_ReconhecimentoFala() {
            String controller = "";

            @Override
            public void resultado(String result) {

                TimerTask task = new TimerTask() {
                    public void run() {
                        perguntou = false;
                        System.out.println(perguntou);

                        iniciar();

                    }
                };
                Timer timer = new Timer("Timer");
                long delay = 2000L;

                if (!perguntou) {
                    switch (result.toLowerCase()) {

                        case "oi": {
                            try {
                                responder("Olá, tudo bem com você? ririrrrirririririrri");
                                result = null;
                                perguntou = true;
                                parar();
                                timer.schedule(task, delay);

                                break;
                            } catch (JavaLayerException ex) {
                                Logger.getLogger(ChatBot_ReconhecimentoFala.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        }

                        case "bem e você": {
                            try {
                                responder("Ótimo, também estou bem, obrigado por perguntar!");
                                result = null;

                                perguntou = true;
                                parar();
                                timer.schedule(task, delay);
                                break;
                            } catch (JavaLayerException ex) {
                                Logger.getLogger(ChatBot_ReconhecimentoFala.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        }

                        case "Qual o seu nome égua": {
                            try {
                                responder("Olá, eu sou um Maluco e me chamo Raimundaaaaaaa!");
                                result = null;

                                perguntou = true;
                                parar();
                                timer.schedule(task, delay);
                                break;
                            } catch (JavaLayerException ex) {
                                Logger.getLogger(ChatBot_ReconhecimentoFala.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        }

                        case "Cansei de você": {
                            try {
                                responder("Foi ótimo conversar com você, até a próxima!");
                                result = null;

                                perguntou = true;
                                parar();
                                //timer.schedule(task, delay);
                                break;
                            } catch (JavaLayerException ex) {
                                Logger.getLogger(ChatBot_ReconhecimentoFala.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            break;
                        }

                    }
                }

            }

            @Override
            public void onResponse(GoogleResponse paramGoogleResponse) {
                throw new UnsupportedOperationException("response__ " + paramGoogleResponse);
            }
        };

        // Parametro verdadeiro é para mostrar a interface.
        chatBot.ini(false);
        chatBot.iniciar();
    }

    public static void responder(String text) throws JavaLayerException {
        SynthesiserV2 synthesiserV2 = new SynthesiserV2("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");
        synthesiserV2.setLanguage("pt-br");

        System.out.println("A linguagem utilizada pelo Sintetizador é: " + synthesiserV2.getLanguage());
        try {
            InputStream audio = synthesiserV2.getMP3Data(text);
            // converte este texto para um arquivo .mp3, na pasta raiz
            String soundFile = "./adejair_load_sound.mp3";
            FileOutputStream outStream = new FileOutputStream(soundFile);

            int read = 0;
            byte[] bytes = new byte[8192];

            // Salva o arquivo mp3.
            while ((read = audio.read(bytes)) != -1) {
                outStream.write(bytes, 0, read);
            }

            FileInputStream fileInputStream = new FileInputStream(soundFile);
            Player player = new Player(fileInputStream);
            player.play();

        } catch (IOException e) {
            System.out.println("Ocorreu um erro " + e);
        }
    }
}
