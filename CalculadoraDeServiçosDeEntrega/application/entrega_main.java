package CalculadoraDeServiçosDeEntrega.application;

import CalculadoraDeServiçosDeEntrega.entities.Entrega;

import java.util.Locale;
import java.util.Scanner;

public class entrega_main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        Entrega entrega = new Entrega();
        String diaDeSemana = "";
        String tipoEntrega = "";

        char opFimPrograma = 0;

        while (opFimPrograma != 'n') {
            System.out.println("=== Calculadora de Serviços de Entrega ===");

            System.out.print("Informe a distância da entrega(km): ");
            entrega.distanciaKm = sc.nextDouble();
            while (entrega.distanciaKm <= 0) {
                System.out.print("Valor inválido. Informe a distância da entrega(km) novamente: ");
                entrega.distanciaKm = sc.nextDouble();
            }

            System.out.print("Informe o peso do pacote (kg): ");
            entrega.pesoKg = sc.nextDouble();
            while (entrega.pesoKg <= 0) {
                System.out.print("Valor inválido. Informe o peso(kg) novamente: ");
                entrega.pesoKg = sc.nextDouble();
            }

            System.out.println("Tipo de entrega: ");
            System.out.println("[1] - Normal ");
            System.out.println("[2] - Expressa ");
            System.out.print("Digite a opção: ");
            entrega.tipoEntrega = sc.nextInt();

            while (entrega.tipoEntrega != 1 && entrega.tipoEntrega != 2) {
                System.out.print("Valor inválido. Informe o tipo de entrega novamente: ");
                entrega.tipoEntrega = sc.nextInt();
            }

            System.out.print("A entrega será em fim de semana? (S/N): ");
            char opFim = sc.next().charAt(0);
            opFim = Character.toLowerCase(opFim);

            while (opFim != 's' && opFim != 'n') {
                System.out.print("Valor Inválido. A entrega será em fim de semana? (S/N): ");
                opFim = sc.next().charAt(0);
                opFim = Character.toLowerCase(opFim);
            }

            if (opFim == 's') {
                entrega.fimDeSemana = true;
                diaDeSemana = "Fim de semana";

            } else if (opFim == 'n') {
                entrega.fimDeSemana = false;
                diaDeSemana = "Dia de semana";
            }

            if (entrega.tipoEntrega == 1) {
                tipoEntrega = "Normal";
            }
            else if (entrega.tipoEntrega == 2) {
                tipoEntrega = "Expressa";
            }

            System.out.println();
            System.out.println(" --- Resumo do Cálculo ---");
            System.out.println("Distância: " + entrega.distanciaKm + " KM");
            System.out.println("Peso: " + entrega.pesoKg + " KG");
            System.out.println("Tipo de Entrega: " + tipoEntrega);
            System.out.println("Dia: " + diaDeSemana);

            System.out.println();

            System.out.printf("Preço base: %.2f%n", entrega.precoDistancia());
            System.out.printf("Preço por Kilo: %.2f%n", entrega.precoKilo());
            if (tipoEntrega.equals("Expressa")) {
                System.out.println("Acréscimo entrega expressa (10%): R$ "
                        + String.format("%.2f", entrega.tipoDeEntrega()));
            } else if (tipoEntrega.equals("Normal")) {
                System.out.println("Acréscimo entrega normal: R$ "
                        + String.format("%.2f", entrega.tipoDeEntrega()));
            }
            System.out.println("Taxa de fim de semana: R$ "
                    + String.format("%.2f", entrega.aplicarTaxaFimdeSemana()));

            System.out.println();

            System.out.println("Valor final: R$ " + String.format("%.2f", entrega.valorTotal()));
            System.out.println("---------------------------------");

            System.out.println("Deseja calcular outro envio? (s/n): ");
            opFimPrograma = Character.toLowerCase(sc.next().charAt(0));

        }

        System.out.println("Programa Encerrado.");
    }

}
