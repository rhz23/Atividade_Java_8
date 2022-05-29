package exceptions;

import entities.Passeio;
import entities.Veiculo;

import javax.swing.*;

public class VelocException extends Exception {

    public float velocException(Veiculo veiculo){
        //System.out.println("A velocidade máxima esta fora dos limites brasileiros");
        int velocidade;
        if (veiculo instanceof Passeio){
            velocidade =  100;
        }else{
            velocidade = 90;
        }
        JOptionPane.showMessageDialog(null, "A velocidade máxima está fora dos limites brasileiros! \n A velocidade cadastrada será de: " + velocidade, "Erro de Cadastro", JOptionPane.WARNING_MESSAGE);
        return velocidade;
    }
}
