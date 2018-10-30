package javaapplication15.ArqCSV;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Joao Otávio Mota Roriz
 */
public class LerArqCSV {

    public static void main(String[] args) {
        LerArqCSV ler = new LerArqCSV();
        ler.executar();
    }

    public void executar() {
        String arq = "C:\\Users\\joaoo\\OneDrive\\Documentos\\NetBeansProjects\\8º Periodo\\TrabalhoPersist.1\\src\\trabalhopersist\\Arquivo\\transacoes.csv";

        BufferedReader buffer = null;
        String linha = "";
        String divisor = ",";

        try {
            buffer = new BufferedReader(new FileReader(arq));
            float total = 0;
            while ((linha = buffer.readLine()) != null) {
                String[] transacao = linha.split(divisor);
                System.out.println("Rua: " + transacao[0] + " Cidade: " + transacao[1]);

                total = total + Float.parseFloat(transacao[9]);
            }
//            String resultado = String.format("%.2f", total);
            Locale ptBr = new Locale("pt", "BR");
            String valorTotal = NumberFormat.getCurrencyInstance(ptBr).format(total);

            System.out.println("Total => " + valorTotal);

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("ERRO!" + ex.getMessage());
        }
    }
}
