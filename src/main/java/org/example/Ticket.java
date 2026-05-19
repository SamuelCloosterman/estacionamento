package org.example;

import java.time.LocalDateTime;

public class Ticket {
    private Veiculo carro;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;

    public Ticket(Veiculo carro) {
        this.carro = carro;
        this.horaEntrada = LocalDateTime.now();
    }

    public Veiculo getCarro() {
        return carro;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }

    public void registrarSaida() {
        this.horaSaida = LocalDateTime.now();
    }
}

