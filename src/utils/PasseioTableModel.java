package utils;

import entities.Passeio;
import exceptions.VelocException;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class PasseioTableModel extends AbstractTableModel {

    private String[] colunas = {"Placa", "Marca", "Modelo", "Cor", "Qtd. Rodas", "Veloc Máx", "Qtd. Pistões", "Potência", "Qtd. Passag"};
    private ArrayList<Passeio> passeioLista;
    private final int colunaPlaca = 0;
    private final int colunaMarca = 1;
    private final int colunaModelo = 2;
    private final int colunaCor = 3;
    private final int colunaRodas = 4;
    private final int colunaVelMax = 5;
    private final int colunaPistoes = 6;
    private final int colunaPotencia = 7;
    private final int colunaPassageiros = 8;

    public PasseioTableModel(){
        Passeio p1 = null;
        try {
            p1 = new Passeio("","","","",0,0,0,0,0);
        } catch (VelocException e) {
            e.printStackTrace();
        }
        passeioLista.add(p1);
    }

    public PasseioTableModel(ArrayList<Passeio> passeioLista){
        this.passeioLista = passeioLista;
    }

    //retorna se a celula é editavel
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return true;
    }

    //retorna o total de itens (que virarão linhas) da nossa lista
    @Override
    public int getRowCount() {
        return passeioLista.size();
    }

    //retorna o total de colunas da tabela
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    //retorna o nome da coluna de acordo com o indice
    @Override
    public String getColumnName(int indice) {
        return colunas[indice];
    }

    //determina o tipo de dado da coluna conforme seu indice
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case colunaPlaca:
                return String.class;
            case colunaMarca:
                return String.class;
            case colunaModelo:
                return String.class;
            case colunaCor:
                return String.class;
            case colunaRodas:
                return int.class;
            case colunaVelMax:
                return float.class;
            case colunaPistoes:
                return int.class;
            case colunaPotencia:
                return int.class;
            case colunaPassageiros:
                return int.class;
            default:
                return String.class;
        }
    }

    //preenche cada celula da tabela
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Passeio passeio = this.passeioLista.get(rowIndex);
        switch (columnIndex){
            case colunaPlaca:
                return passeio.getPlaca();
            case colunaMarca:
                return passeio.getMarca();
            case colunaModelo:
                return passeio.getModelo();
            case colunaCor:
                return passeio.getCor();
            case colunaRodas:
                return passeio.getQtdRodas();
            case colunaVelMax:
                return passeio.getVelocMax();
            case colunaPistoes:
                return passeio.getMotor().getQtdPist();
            case colunaPotencia:
                return passeio.getMotor().getPotencia();
            case colunaPassageiros:
                return passeio.getQtdPassegeiros();
        }
        return null;
    }

    //altera o valor do objeto de acordo com a célula editada
    //e notifica a alteração da tabela, para que ela seja atualizada na tela
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        Passeio passeio = this.passeioLista.get(rowIndex);
        //A coluna representa o mesmo indice do carro na lista
        switch (columnIndex){
            case colunaPlaca:
                passeio.setPlaca(String.valueOf(aValue));
            case colunaMarca:
                passeio.setMarca(String.valueOf(aValue));
            case colunaModelo:
                passeio.setModelo(String.valueOf(aValue));
            case colunaCor:
                passeio.setCor(String.valueOf(aValue));
            case colunaRodas:
                passeio.setQtdRodas((int)aValue);
            case colunaVelMax:
                try {
                    passeio.setVelocMax((float)aValue);
                } catch (VelocException e) {
                    e.printStackTrace();
                }
            case colunaPistoes:
                passeio.getMotor().setQtdPist((int)aValue);
            case colunaPotencia:
                passeio.getMotor().setPotencia((int)aValue);
            case colunaPassageiros:
                passeio.setQtdPassegeiros((int)aValue);
        }
        fireTableDataChanged();
    }
}
