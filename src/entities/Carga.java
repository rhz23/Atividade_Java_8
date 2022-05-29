package entities;

import exceptions.VelocException;
import interfaces.Calcular;

public final class Carga extends Veiculo implements Calcular {

    private int cargaMax;
    private int tara;

    public Carga() {
        this.cargaMax = 0;
        this.tara = 0;
    }

    public Carga(String placa, String marca, String modelo, String cor, float velocMax, int qtdRodas, int qtdPist, int potencia, int cargaMax, int tara) throws VelocException {
        super(placa, marca, modelo, cor, velocMax, qtdRodas, qtdPist, potencia);
        this.cargaMax = cargaMax;
        this.tara = tara;
    }

    public final int getCargaMax() {
        return cargaMax;
    }

    public final void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    public final int getTara() {
        return tara;
    }

    public final void setTara(int tara) {
        this.tara = tara;
    }

    @Override
    public int calcula() {
        return (int)this.getVelocMax() + this.getQtdRodas() + this.getMotor().getQtdPist() + this.getMotor().getPotencia() + this.getCargaMax() + this.getTara();
    }

    @Override
    public float calcVel(float velocMax) {
        return velocMax * 100000;
    }

    @Override
    public String toString() {
        return "Veiculo Carga{" +
                "placa='" + this.getPlaca() + '\'' +
                ", marca='" + this.getMarca() + '\'' +
                ", modelo='" + this.getModelo() + '\'' +
                ", cor='" + this.getCor() + '\'' +
                ", velocMax=" + this.getVelocMax() + "Km/h" +
                ", qtdRodas=" + this.getQtdRodas() +
                ", motor=" + this.getMotor() +
                ", cargaMax=" + this.getCargaMax() +
                ", tara=" + this.getTara() +
                '}';
    }
}
