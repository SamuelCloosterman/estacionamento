package org.example;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        Estacionamento estacionamento = new Estacionamento(10);

        do {
            System.out.println("\nMENU");
            System.out.println("\n1 - Registrar entrada");
            System.out.println("\n2 - Registrar saída");
            System.out.println("\n3 - Exibir vagas livres");
            System.out.println("\n4 - Sair");
            System.out.println("\nEscolha uma opcao:");

            opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println(" o usuario digitou a opcao " + opcao);

            switch(opcao){
                case 1:
                    System.out.println("Digite a placa:");
                    String placa = scanner.nextLine();
                    System.out.println("Digite o modelo:");
                    String modelo = scanner.nextLine();
                    estacionamento.registrarEntrada(placa, modelo);
                break;

                case 2:
                    System.out.println("Digite a placa:");
                    String placaSaida = scanner.nextLine();
                    estacionamento.registrarSaida(placaSaida);
                break;

                case 3:
                estacionamento.exibirVagas();
                break;
            }
        }while(opcao != 4);
        System.out.println(" o usuario saiu do sistema.");
    }
}
