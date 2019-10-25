package chatbotSimples;

import Try_Google_Speech_Recognition_Simple.RecFalaPtBrGoogle;

/**
 *
 * @author João Otávio Mota Roriz
 * 
 * Nome: Raimunda
 * Personalidade: Respondona, sem educação
 * Funções: Atendente de bar
 * Animação: 
 */
public class ChatBot extends RecFalaPtBrGoogle {

    public static void main(String[] args) {

        ChatBot chatBot = new ChatBot() {
            @Override
            public void resultado(String result) {

                System.out.println(result);
                if(result.toLowerCase().contains("boa noite")){
                    System.out.println("Raimunda diz: Vai catar latinha na rua");
                } if(result.toLowerCase().contains("boa tarde")){
                    System.out.println("Raimunda diz: Como vc diz tarde de esta a noite deeeeeeeeeeer");
                }
                
            }
        };

        chatBot.ini(false);
        chatBot.iniRec();
    }
}
