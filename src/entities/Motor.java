package entities;

public class Motor {

    private int qtdPist;
    private int potencia;

    public Motor(){
        qtdPist = 0;
        potencia = 0;
    }

    public Motor(int qtdPist, int potencia) {
        this.qtdPist = qtdPist;
        this.potencia = potencia;
    }

    public int getQtdPist() {
        return qtdPist;
    }

    public void setQtdPist(int qtdPist) {
        this.qtdPist = qtdPist;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "qtdPist=" + qtdPist +
                ", potencia=" + potencia + "cv" +
                '}';
    }
}
