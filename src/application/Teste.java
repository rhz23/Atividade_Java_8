package application;

import exceptions.VeicExistException;
import exceptions.VelocException;


public class Teste {

    public static void main(String[] args) throws VelocException, VeicExistException {
        Principal.criaGestaoVeiculosMainView().setVisible(true);
    }
}
