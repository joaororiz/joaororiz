package javaapplication15;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
                + "1 - Inserir \n"
                + "2 - Remover \n"
                + "3 - Pesquisar");

        int op = ler.nextInt();

        return op;
    }

    public Cliente inserir(int cod) {

        Scanner ler = new Scanner(System.in);

        Cliente cli = new Cliente();

        System.out.println("Código: " + cod);
        cli.setCodigo(cod);

        System.out.print("Nome: ");
        String nome = ler.next();
        cli.setNome(nome);

        System.out.print("Idade: ");
        int idade = ler.nextInt();
        cli.setIdade(idade);

        System.out.print("Sexo: ");
        String sexo = ler.next();
        cli.setSexo(sexo);

        System.out.print("Profissão: ");
        String prof = ler.next();
        cli.setProfissao(prof);
        return cli;
    }

    public void gravar(List cli) {
        File file = new File("C:\\Users\\joaoo\\OneDrive\\Documentos\\NetBeansProjects\\8º Periodo\\ArrayList\\src\\javaapplication15\\Produtos.bin");

        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(cli);

            oos.flush();
            oos.close();
            fos.close();

        } catch (IOException e) {
            System.err.println("Erro ao gravar arquivo: " + e.getMessage());
        }
    }
}
