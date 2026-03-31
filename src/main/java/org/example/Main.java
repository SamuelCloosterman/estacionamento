package org.example;



public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        Estacionamento estacionamento = new Estacionamento(totalDeVagas:10);
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
                break;

                case 2:
                break;

                case 3:estacionamento.exibirVagasLivres();
                break;
            }
        }while(opcao != 4);
        System.out.println("o usuario saiu do sistema.");
    }
}
