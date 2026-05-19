package org.example;

public class Vaga {
    private int numero;
    private boolean ocupada;
    private Veiculo veiculoEstacionado;

    public Vaga(int numero) {
        this.numero = numero;
        this.ocupada = false;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Veiculo getVeiculoEstacionado() {
        return veiculoEstacionado;
    }

    public void setVeiculoEstacionado(Veiculo veiculoEstacionado) {
        this.veiculoEstacionado = veiculoEstacionado;
    }
}
