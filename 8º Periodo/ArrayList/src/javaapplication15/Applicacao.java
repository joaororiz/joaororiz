package javaapplication15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author João Otávio Mota Roriz
 */
public class Applicacao {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<Cliente> listaclientes;
        Scanner ler = new Scanner(System.in);
        Metodos metod = new Metodos();
        Random random = new Random();
        int opMenu = 0;
        File caminho = new File("C:\\Users\\joaoo\\OneDrive\\Documentos\\NetBeansProjects\\8º Periodo\\ArrayList\\src\\javaapplication15\\Produtos.bin");

        if (caminho.length() == 0) {
            listaclientes = new ArrayList<>();
        } else {
            FileInputStream arq = new FileInputStream(caminho);
            ObjectInputStream ob = new ObjectInputStream(arq);
            listaclientes = (ArrayList<Cliente>) ob.readObject();
        }

        do {
            opMenu = new Metodos().menu();

            switch (opMenu) {
                case 0:
                    System.out.println("Sistema encerrado!");
                    break;
                case 1:
                    int qtd = 500;
                    String sexo = "";
                    String[] nomesCli = new String[]{
                        "Agela Cristina Guimaraes Silva",
                        "Marcos Flavio Fabiano Januario da silva",
                        "Erick Moraes fretas",
                        "Luiz Guilerme Cordeiro Santos Silva",
                        "Fernando Meyer"
                    };

                    String[] profissoes = new String[]{
                        "Programador",
                        "Professor",
                        "Médico",
                        "Padeiro",
                        "Dentisa"
                    };
                    for (int i = 0; i < qtd; i++) {
                        if ((random.nextInt() % 2) == 0) {
                            sexo = "Masculino";
                        } else {
                            sexo = "Feminino";
                        }
                        Cliente client = new Cliente(i, nomesCli[random.nextInt(5)], random.nextInt(50), sexo, profissoes[random.nextInt(5)]);
                        listaclientes.add(client);
                    }
                    metod.gravar(listaclientes);
                    System.out.println("Inserido no arquivo com sucesso!");
                    break;
                case 2:
                    System.out.print("Informe o codigo do cliente: ");
                    int cod = ler.nextInt();
                    for (int i = 0; i < listaclientes.size(); i++) {
                        if (listaclientes.get(i).getCodigo() == cod) {
                            listaclientes.remove(i);
                            metod.gravar(listaclientes);
                            System.out.println("Cliente removido da lista com sucesso!");
                        } else {
                            System.out.println("Cliente não encontrado!");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Informe o codigo para pesquisar: ");
                    int codPesq = ler.nextInt();
                    for (Cliente cli : listaclientes) {
                        if (cli.getCodigo() == codPesq) {
                            System.out.println("\n----------cliente encontrado-----------");
                            System.out.println("Código: " + cli.getCodigo());
                            System.out.println("Nome: " + cli.getNome());
                            System.out.println("Idade: " + cli.getIdade());
                            System.out.println("Sexo: " + cli.getSexo());
                            System.out.println("Profissão: " + cli.getProfissao());
                        }
                    }
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opMenu != 0);
    }
}
