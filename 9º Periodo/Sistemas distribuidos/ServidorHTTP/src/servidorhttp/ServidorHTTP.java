
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 *
 * @author João Otávio Mota Roriz
 */
public class ServidorHTTP {

    public static void main(String[] args) throws IOException {
        /* cria um socket "servidor" associado a porta 8000 á aguardando conexões*/
        String linha = null;

        ServerSocket servidor = new ServerSocket(8000);
        //aceita a primeita conexao que vier
        while (true) {
            Socket socket = servidor.accept();
            //verifica se esta conectado  
            if (socket.isConnected()) {
                //imprime na tela o IP do cliente
                System.out.println("O computador " + socket.getInetAddress() + " se conectou ao servidor.");
            }
            //cria um BufferedReader a partir do InputStream do cliente
            BufferedReader buffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Requisicao: ");

            /* Lê a primeira linha contem as informaçoes da requisição*/
            linha = buffer.readLine();
            //quebra a string pelo espaço em branco
            String[] dadosReq = linha.split(" ");
            //pega o metodo
            String metodo = dadosReq[0];
            //paga o caminho do arquivo
            String caminhoArquivo = dadosReq[1];
            //pega o protocolo
            String protocolo = "http/1.1";
            //Enquanto a linha não for vazia
            while (!linha.isEmpty()) {
                //imprime a linha
                System.out.println(linha);
                //lê a proxima linha
                linha = buffer.readLine();
            }
            //se o caminho foi igual a / entao deve pegar o /index.html
            if (caminhoArquivo.equals("/")) {
                caminhoArquivo = "index.html";
            }
            //abre o arquivo pelo caminho
            File arquivo = new File(caminhoArquivo);
            byte[] conteudo;
            //status de sucesso - HTTP/1.1 200 OK
            String status = protocolo + " 200 OK\r\n";
            //se o arquivo não existe então abrimos o arquivo de erro, e mudamos o status para 404
            if (!arquivo.exists()) {
                status = protocolo + " 404 Not Found\r\n";
                arquivo = new File("404.html");
            }
            conteudo = Files.readAllBytes(arquivo.toPath());

            //cria um formato para o GMT espeficicado pelo HTTP
            SimpleDateFormat formatador = new SimpleDateFormat("E, dd MMM yyyy hh:mm:ss", Locale.ENGLISH);
            formatador.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date data = new Date();
            //Formata a dara para o padrao
            String dataFormatada = formatador.format(data) + " GMT";
            //cabeçalho padrão da resposta HTTP
            String header = status
                    + "Location: http://localhost:8000/\r\n"
                    + "Date: " + dataFormatada + "\r\n"
                    + "Server: MeuServidor/1.0\r\n"
                    + "Content-Type: text/html\r\n"
                    + "Content-Length: " + conteudo.length + "\r\n"
                    + "Connection: close\r\n"
                    + "\r\n";
            //cria o canal de resposta utilizando o outputStream
            OutputStream resposta = socket.getOutputStream();
            //escreve o headers em bytes
            resposta.write(header.getBytes());
            //escreve o conteudo em bytes
            resposta.write(conteudo);
            //encerra a resposta
            resposta.flush();
        }
    }
}
