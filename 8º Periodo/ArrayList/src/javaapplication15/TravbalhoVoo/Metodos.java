package javaapplication15.TravbalhoVoo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Joao Otávio Mota Roriz
 */
public class Metodos {

    public int menu() {

        Scanner ler = new Scanner(System.in);

        System.out.println(
                "0 - SAIR\n"
                + "1 - Inserir cliente \n"
                + "2 - Inserir voo \n"
                + "3 - Inserir venda");

        int op = ler.nextInt();

        return op;
    }

    public void gravarVoos(ArrayList<Voo> listaVoos) {
        File file = new File("C:\\Users\\joaoo\\OneDrive\\Documentos\\NetBeansProjects\\8º Periodo\\ArrayList\\src\\javaapplication15\\TravbalhoVoo\\Csv\\voos.csv");

        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (Voo voos : listaVoos) {
                oos.writeObject(voos.getCodigo() + ";" + voos.getOrigem() + ";" + voos.getDestino() + ";" + voos.getHoras() + ";" + voos.getValor() + "\n");
            }

            oos.flush();
            oos.close();
            fos.close();

        } catch (IOException e) {
            System.err.println("Erro ao gravar voos arquivo: " + e.getMessage());
        }
    }

    public void gravarCliente(ArrayList<Cliente> listaClientes) {
        File file = new File("C:\\Users\\joaoo\\OneDrive\\Documentos\\NetBeansProjects\\8º Periodo\\ArrayList\\src\\javaapplication15\\TravbalhoVoo\\Csv\\cliente.csv");

        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (Cliente cliente : listaClientes) {
                oos.writeObject(cliente.getCodigo() + ";" + cliente.getNome() + ";" + cliente.getCpf() + ";" + cliente.getTelefone() + "\n");
            }

            oos.flush();
            oos.close();
            fos.close();

        } catch (IOException e) {
            System.err.println("Erro ao gravar clientes arquivo: " + e.getMessage());
        }
    }

    public void gravarVendas(ArrayList<Vendas> listaVendas) {
        File file = new File("C:\\Users\\joaoo\\OneDrive\\Documentos\\NetBeansProjects\\8º Periodo\\ArrayList\\src\\javaapplication15\\TravbalhoVoo\\Csv\\vendas.csv");

        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (Vendas vendas : listaVendas) {
                oos.writeObject(vendas.getCodigo() + ";" + vendas.getCliente() + ";" + vendas.getVoo() + ";" + vendas.getValor() + "\n");
            }
            oos.flush();
            oos.close();
            fos.close();

        } catch (IOException e) {
            System.err.println("Erro ao gravar vendas arquivo: " + e.getMessage());
        }
    }
}
