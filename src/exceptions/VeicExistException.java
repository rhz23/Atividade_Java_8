package exceptions;

import javax.swing.*;

public class VeicExistException extends Exception{

    public  void veicExistException(){
        //System.out.println("\n\tJá existe um veículo com esta placa!");
        JOptionPane.showMessageDialog(null, "Já existe um veículo cadastrado com esta placa!", "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
    }
}
