package views.passeio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasseioView extends JFrame{


    private static PasseioView passeioViewUnico;

    public static PasseioView criaPasseioView(){
        if (passeioViewUnico == null){
            passeioViewUnico = new PasseioView();
        }
        return passeioViewUnico;
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PasseioView().setVisible(true);
            }
        });

    }

    private PasseioView(){
        initJanela();
    }

    private void initJanela(){

        //new JFrame("Veículo de Passeio");
        setTitle("Veiculos Passeio");
        setBounds(200, 200, 350, 170);
        setMinimumSize(new Dimension(350, 170));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        //Botões

        JButton cadastrarButton = new JButton();
        JButton consultarExcluirButton =  new JButton();
        JButton imprimirExcluirAllButton = new JButton();
        JButton sairButton = new JButton();

        //Labels
        JLabel cadastrarButtonLabel = new JLabel("Cadastrar");
        JLabel consultarExcluirButtonLabel = new JLabel("Consultar/Excluir pela placa");
        JLabel imprimirExcluirAllButtonLabel = new JLabel("Imprimir/Excluir todos");
        JLabel sairButtonLabel = new JLabel("Sair");

        //Action Listener dos botões
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                CadastroPasseioView.criaCadastroPasseioView().setVisible(true);
            }
        });

        consultarExcluirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                ConsultaExcluiPasseioView.criaConsultaExcluirPasseioView().setVisible(true);
            }
        });

        imprimirExcluirAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                ImprimiExcluiPasseioView.criaImprimirExcluirPasseioView().setVisible(true);
            }
        });

        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                sair();
            }
        });

        //posição e tamanho dos botões
        cadastrarButton.setBounds(10, 20, 30, 20);
        consultarExcluirButton.setBounds(10, 45, 30, 20);
        imprimirExcluirAllButton.setBounds(10, 70, 30, 20);
        sairButton.setBounds(10, 95, 30, 20);

        //posição dos labels
        cadastrarButtonLabel.setBounds(50, 20, 200, 20);
        consultarExcluirButtonLabel.setBounds(50, 45, 200, 20);
        imprimirExcluirAllButtonLabel.setBounds(50, 70, 200, 20);
        sairButtonLabel.setBounds(50, 95, 200, 20);

        //adicionando botão ao ContentPane
        getContentPane().add(cadastrarButton);
        getContentPane().add(consultarExcluirButton);
        getContentPane().add(imprimirExcluirAllButton);
        getContentPane().add(sairButton);

        //adicionante labels ao Content Pane
        getContentPane().add(cadastrarButtonLabel);
        getContentPane().add(consultarExcluirButtonLabel);
        getContentPane().add(imprimirExcluirAllButtonLabel);
        getContentPane().add(sairButtonLabel);

        setVisible(true);

    }

    private void sair(){
        dispose();
    }
}
