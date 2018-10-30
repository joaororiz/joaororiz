package javaapplication15.TravbalhoVoo;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author João Otávio Mota Roriz
 */
public class Applicacao {

    public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        ArrayList<Cliente> listaclientes = new ArrayList<>();
        ArrayList<Voo> listavoos = new ArrayList<>();
        ArrayList<Vendas> listavendas = new ArrayList<>();
        Metodos metod = new Metodos();
        Random random = new Random();
        int qtd = 100, opMenu = 0;
        int valor = 0, value = 0;

        do {
            opMenu = new Metodos().menu();

            switch (opMenu) {
                case 0:
                    System.out.println("Sistema encerrado!");
                    break;
                case 1:
                    String[] nomesCli = new String[]{
                        "Agela Cristina",
                        "Marcos Flavio",
                        "Erick Moraes",
                        "Luiz Guilerme",
                        "Fernando Meyer"
                    };

                    String[] telefones = new String[]{
                        "64 75468464",
                        "64 35766657",
                        "53 47576656",
                        "69 35753644",
                        "69 37462664"
                    };

                    String[] cpfs = new String[]{
                        "357.754.684-64",
                        "375.357.666-57",
                        "535.747.576-56",
                        "697.357.536-44",
                        "694.374.626-64"
                    };
                    for (int i = 0; i < qtd; i++) {
                        Cliente cliente = new Cliente(i, nomesCli[random.nextInt(5)], telefones[random.nextInt(5)], cpfs[random.nextInt(5)]);
                        listaclientes.add(cliente);
                    }
                    metod.gravarCliente(listaclientes);
                    System.out.println("Cliente inserido no arquivo com sucesso!");
                    break;
                case 2:
                    String[] origem = new String[]{
                        "Rio verde",
                        "Cancum",
                        "Paris",
                        "Madri",
                        "Rio de Janeiro"
                    };

                    String[] destino = new String[]{
                        "Florida",
                        "Ibiza",
                        "Sao Paulo",
                        "Goiania",
                        "Pito"
                    };

                    String[] horas = new String[]{
                        "10:00",
                        "11:00",
                        "15:00",
                        "16:00",
                        "20:00"
                    };

                    float[] valores = new float[]{
                        500, 1000, 2000, 800, 3000
                    };

                    for (int i = 0; i < qtd; i++) {
                        Voo voo = new Voo(i, origem[random.nextInt(5)], destino[random.nextInt(5)], horas[random.nextInt(5)], valores[random.nextInt(5)]);
                        listavoos.add(voo);
                    }
                    metod.gravarVoos(listavoos);
                    System.out.println("Voos inseridos no arquivo com sucesso!");
                    break;
                case 3:
                    float[] valoresTotais = new float[]{
                        5000, 10000, 20000, 8000, 30000
                    };
                    for (int i = 0; i < qtd; i++) {
                        Vendas vendas = new Vendas(i, random.nextInt(listaclientes.size()), random.nextInt(listaclientes.size()), valoresTotais[random.nextInt(5)]);
                        listavendas.add(vendas);
                    }
                    metod.gravarVendas(listavendas);
                    System.out.println("Vendas inseridas no arquivo com sucesso!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opMenu
                != 0);
    }
}
