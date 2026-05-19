package org.example;
import java.util.ArrayList;
import java.time.Duration;

public class Estacionamento {
    private ArrayList<Vaga> vagas = new ArrayList<Vaga>();
    private ArrayList<Ticket> ticketsAbertos = new ArrayList<Ticket>();
    private Tarifario tarifario;

    public Estacionamento(int totalDeVagas){
        this.vagas = new ArrayList<>();
        this.tarifario = new Tarifario(2.0);
        for(int i = 1; i <= totalDeVagas; i++){
            vagas.add(new Vaga(i));
        }
    }

    public void exibirVagas() {

        System.out.println("\nLISTA DE VAGAS:");

        for(Vaga vaga : vagas) {

            if(vaga.isOcupada()) {

                System.out.println(
                        "Vaga "
                                + vaga.getNumero()
                                + " - OCUPADA"
                );

            } else {

                System.out.println(
                        "Vaga "
                                + vaga.getNumero()
                                + " - LIVRE"
                );
            }
        }
    }

    public void registrarEntrada(String placa, String modelo){
        Veiculo carro = new Veiculo(placa, modelo);
        for(Vaga vaga : vagas) {
            if(!vaga.isOcupada()) {
                vaga.setOcupada(true);
                vaga.setVeiculoEstacionado(carro);
                Ticket ticket = new Ticket(carro);
                ticketsAbertos.add(ticket);
                System.out.println(
                        "Carro estacionado na vaga "
                                + vaga.getNumero()
                );

                return;
            }
        }

        System.out.println("Estacionamento lotado.");
    }

    public void registrarSaida(String placa) {
        for(Ticket ticket : ticketsAbertos) {
            if(ticket.getCarro().getPlaca().equals(placa)) {
                ticket.registrarSaida();
                Duration tempo = Duration.between(
                        ticket.getHoraEntrada(),
                        ticket.getHoraSaida()
                );

                long minutos = tempo.toMinutes();
                double horas = minutos / 60.0;
                double valor = horas * tarifario.getValorHora();
                System.out.println(
                        "Tempo estacionado: "
                                + minutos
                                + " minutos"
                );

                for(Vaga vaga : vagas) {
                    if(vaga.getVeiculoEstacionado() != null &&
                            vaga.getVeiculoEstacionado()
                                    .getPlaca()
                                    .equals(placa)) {

                        vaga.setOcupada(false);
                        vaga.setVeiculoEstacionado(null);
                        System.out.println(
                                "Vaga "
                                        + vaga.getNumero()
                                        + " liberada."
                        );

                        System.out.printf(
                                "Valor a pagar: R$ %.2f%n",
                                valor
                        );
                        return;
                    }
                }
            }
        }

        System.out.println("Carro não encontrado.");
    }
}