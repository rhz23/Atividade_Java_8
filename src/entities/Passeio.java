package entities;

import exceptions.VelocException;
import interfaces.Calcular;

import java.util.ArrayList;
import java.util.List;

public final class Passeio extends Veiculo implements Calcular {

    private int qtdPassegeiros;

    public Passeio() {
        this.qtdPassegeiros = 0;
    }

    public Passeio(String placa, String marca, String modelo, String cor, float velocMax, int qtdRodas, int qtdPist, int potencia, int qtdPassegeiros) throws VelocException {
        super(placa, marca, modelo, cor, velocMax, qtdRodas, qtdPist, potencia);
        this.qtdPassegeiros = qtdPassegeiros;
    }

    public final int getQtdPassegeiros() {
        return qtdPassegeiros;
    }

    public final void setQtdPassegeiros(int qtdPassegeiros) {
        this.qtdPassegeiros = qtdPassegeiros;
    }

    @Override
    public float calcVel(float velocMax) {
        return velocMax * 1000;
    }

    @Override
    public int calcula() {
        return this.getPlaca().length() + this.getMarca().length() + this.getModelo().length() + this.getCor().length();
    }

    @Override
    public String toString() {
        return "Veiculo Passeio{" +
                "placa='" + this.getPlaca() + '\'' +
                ", marca='" + this.getMarca() + '\'' +
                ", modelo='" + this.getModelo() + '\'' +
                ", cor='" + this.getCor() + '\'' +
                ", velocMax=" + this.getVelocMax() + "Km/h" +
                ", qtdRodas=" + this.getQtdRodas() +
                ", motor=" + this.getMotor() +
                ", qtdPassageiros=" + qtdPassegeiros +
                ", " +
                '}';
    }
}
