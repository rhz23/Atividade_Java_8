package views;

import views.carga.CargaView;
import views.passeio.PasseioView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GestaoVeiculosMainView extends JFrame {

    //Singleton
    private static GestaoVeiculosMainView gestaoVeiculosMainViewUnico;

    public static GestaoVeiculosMainView criaGestaoVeiculosMainView(){
        if (gestaoVeiculosMainViewUnico == null){
            gestaoVeiculosMainViewUnico = new GestaoVeiculosMainView();
        }
        return gestaoVeiculosMainViewUnico;
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GestaoVeiculosMainView().setVisible(true);
            }
        });
    }

    private GestaoVeiculosMainView(){
        initJanela();
    }

    //metodo principal
    private void initJanela(){

        //new JFrame("Gestão de Veiculos");
        setTitle("Gestão de Veiculos");
        setBounds(200, 200, 350, 170);
        setMinimumSize(new Dimension(350, 170));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        //Botões
        JButton passeioButton = new JButton();
        JButton cargaButton =  new JButton();

        //Labels
        JLabel passeioButtonLabel = new JLabel("Passeio");
        JLabel cargaButtonLabel = new JLabel("Carga");

        //Action Listener dos botões
        passeioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                PasseioView.criaPasseioView().setVisible(true);
            }
        });

        cargaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                CargaView.criaCargaView().setVisible(true);
            }
        });
        

        //posição e tamanho dos botões
        passeioButton.setBounds(10, 20, 30, 20);
        cargaButton.setBounds(10, 45, 30, 20);


        //posição dos labels
        passeioButtonLabel.setBounds(50, 20, 200, 20);
        cargaButtonLabel.setBounds(50, 45, 200, 20);


        //adicionando botão ao ContentPane
        getContentPane().add(passeioButton);
        getContentPane().add(cargaButton);


        //adicionante labels ao Content Pane
        getContentPane().add(passeioButtonLabel);
        getContentPane().add(cargaButtonLabel);
    }

    private void sair(){
        dispose();
    }
}
