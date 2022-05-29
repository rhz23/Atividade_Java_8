package entities;

import exceptions.VelocException;

public abstract class Veiculo {

    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private float velocMax;
    private int qtdRodas;
    private Motor motor;

    public Veiculo(){
        placa = " ";
        marca = " ";
        modelo = " ";
        cor = " ";
        velocMax = 0;
        qtdRodas = 0;
        motor = new Motor();
    }

    public Veiculo(String placa, String marca, String modelo, String cor, float velocMax, int qtdRodas, int qtdPist, int potencia) throws VelocException {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        if(velocMax > 80 && velocMax < 100){
            this.velocMax = velocMax;
        }else{
            throw new VelocException();
        }
        this.qtdRodas = qtdRodas;
        this.motor =new Motor(qtdPist, potencia);

    }

    public final String getPlaca() {
        return placa;
    }

    public final void setPlaca(String placa) {
        this.placa = placa;
    }

    public final String getMarca() {
        return marca;
    }

    public final void setMarca(String marca) {
        this.marca = marca;
    }

    public final String getModelo() {
        return modelo;
    }

    public final void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public final String getCor() {
        return cor;
    }

    public final void setCor(String cor) {
        this.cor = cor;
    }

    public final float getVelocMax() {
        return velocMax;
    }

    public final void setVelocMax(float velocMax) throws VelocException {
        if(velocMax >= 80.0 && velocMax <= 100.0){
            this.velocMax = velocMax;
        }else{
            throw new VelocException();
        }
    }

    public final int getQtdRodas() {
        return qtdRodas;
    }

    public final void setQtdRodas(int qtdRodas) {
        this.qtdRodas = qtdRodas;
    }

    public final Motor getMotor() {
        return motor;
    }

    public final void setMotor(Motor motor) {
        this.motor = motor;
    }

    public abstract float calcVel(float velocMax);

    @Override
    public String toString() {
        return "Veiculo{" +
                "placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", cor='" + cor + '\'' +
                ", velocMax=" + velocMax + "Km/h" +
                ", qtdRodas=" + qtdRodas +
                ", motor=" + motor +
                '}';
    }
}
