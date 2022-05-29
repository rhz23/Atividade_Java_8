package views.passeio;

import bd.BDVeiculos;
import entities.Passeio;
import utils.FieldUtils;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ConsultaExcluiPasseioView extends JFrame{
    
   //Botões
   private JButton consultarButton =  new JButton("Consultar");
   private JButton excluirButton = new JButton("Excluir");
   private JButton sairButton = new JButton("Sair");

    //Labels
    private JLabel placaLabel = new JLabel("Placa: ");
    private JLabel marcaLabel = new JLabel("Marca: ");
    private JLabel modeloLabel = new JLabel("Modelo: ");
    private JLabel corLabel = new JLabel("Cor: ");
    private JLabel rodasLabel = new JLabel("Rodas: ");
    private JLabel velMaxLabel = new JLabel("Velocidade Máx.: ");
    private JLabel pistoesLabel = new JLabel("Qtd. Pistões: ");
    private JLabel potenciaLabel = new JLabel("Potência");
    private JLabel passageirosLabel = new JLabel("Qtd. Passageiros: ");

    //Fields
    private JFormattedTextField placaTextField = new JFormattedTextField();
    private JTextField marcaTextField = new JTextField(20);
    private JTextField modeloTextField = new JTextField(20);
    private JTextField corTextField = new JTextField(20);
    private JTextField velMaxTextField = new JTextField(20);
    private JTextField rodasTextField = new JTextField(20);
    private JTextField pistoesTextField = new JTextField(20);
    private JTextField potenciaTextField = new JTextField(20);
    private JTextField passageirosTextField = new JTextField(20);


    //Singleton
    FieldUtils utilidadesCampos =  FieldUtils.criaFieldUtilsUnico();

    BDVeiculos bdVeiculos = BDVeiculos.criaBDVeiculos();

    private static ConsultaExcluiPasseioView consultaExcluirPasseioViewUnico;

    public static ConsultaExcluiPasseioView criaConsultaExcluirPasseioView(){
        if (consultaExcluirPasseioViewUnico == null){
            consultaExcluirPasseioViewUnico = new ConsultaExcluiPasseioView();
        }
        return consultaExcluirPasseioViewUnico;
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConsultaExcluiPasseioView().setVisible(true);
            }
        });
    }

    //construtor
    private ConsultaExcluiPasseioView(){
        initJanela();
    }

    //metodo principal
    private void initJanela(){

        //Definições do frame
        setTitle("Consultar/Excluir pela placa");
        setBounds(200, 200, 430, 320);
        setMinimumSize(new Dimension(430, 320));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        //Action Listener dos botões
        consultarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                consultar();
            }
        });

        excluirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                excluir();
            }
        });

        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                sair();
            }
        });

        // TODO: 29/05/2022 - ver outros todo sobre essa mascara 
        //Mascaras de formato de entrada
        MaskFormatter mascaraPlaca = null;
        try{
            String numeros = "0123456789";
            mascaraPlaca = new MaskFormatter("AAAAAAA");
            mascaraPlaca.setPlaceholderCharacter('_');
        }catch(Exception e){
            System.err.println("Erro de formatação: " + e.getMessage());
            System.exit(-1);
        }

        //posição e tamanho dos botões
        consultarButton.setBounds(110, 255, 90, 20);
        excluirButton.setBounds(210, 255, 90, 20);
        sairButton.setBounds(310, 255, 90, 20);

        //posição dos labels
        placaLabel.setBounds(10, 20, 200, 20);
        marcaLabel.setBounds(10, 45, 200, 20);
        modeloLabel.setBounds(10, 70, 200, 20);
        corLabel.setBounds(10, 95, 200, 20);
        rodasLabel.setBounds(10, 120, 200, 20);
        velMaxLabel.setBounds(10, 145, 200, 20);
        pistoesLabel.setBounds(10, 170, 200, 20);
        potenciaLabel.setBounds(10, 195, 200, 20);
        passageirosLabel.setBounds(10, 220, 200, 20);

        //posição dos Fields
        placaTextField.setBounds(50, 20, 60, 20);
        marcaTextField.setBounds(55, 45, 200, 20);
        modeloTextField.setBounds(65, 70, 200, 20);
        corTextField.setBounds(40, 95, 200, 20);
        rodasTextField.setBounds(55, 120, 60, 20);
        velMaxTextField.setBounds(110, 145, 60, 20);
        pistoesTextField.setBounds(90, 170, 60, 20);
        potenciaTextField.setBounds(80, 195, 60, 20);
        passageirosTextField.setBounds(115, 220, 60, 20);

        //adicionando botão ao ContentPane
        getContentPane().add(consultarButton);
        getContentPane().add(excluirButton);
        getContentPane().add(sairButton);

        //adicionante labels ao Content Pane
        getContentPane().add(placaLabel);
        getContentPane().add(marcaLabel);
        getContentPane().add(modeloLabel);
        getContentPane().add(corLabel);
        getContentPane().add(rodasLabel);
        getContentPane().add(velMaxLabel);
        getContentPane().add(pistoesLabel);
        getContentPane().add(potenciaLabel);
        getContentPane().add(passageirosLabel);

        //formatando Fields
        placaLabel.setForeground(Color.RED);
        placaTextField.setFormatterFactory(new DefaultFormatterFactory(mascaraPlaca));
        placaTextField.setPreferredSize(new Dimension(60,20));

        //adicionante Fields ao Content Pane
        getContentPane().add(placaTextField);
        getContentPane().add(marcaTextField);
        getContentPane().add(modeloTextField);
        getContentPane().add(corTextField);
        getContentPane().add(rodasTextField);
        getContentPane().add(velMaxTextField);
        getContentPane().add(pistoesTextField);
        getContentPane().add(potenciaTextField);
        getContentPane().add(passageirosTextField);

        setVisible(true);

    }

    // TODO: 29/05/2022 -verificar interesse de passar metodos auxiliares para classe utils 
    public void consultar(){
        Passeio passeio = new Passeio();
        passeio.setPlaca(placaTextField.getText());
        passeio = (Passeio) bdVeiculos.consultarPelaPlaca(passeio);
        if(passeio != null){
            placaTextField.setText(passeio.getPlaca());
            marcaTextField.setText(passeio.getMarca());
            modeloTextField.setText(passeio.getModelo());
            corTextField.setText(passeio.getCor());
            velMaxTextField.setText(String.valueOf(passeio.getVelocMax()));
            rodasTextField.setText(String.valueOf(passeio.getQtdRodas()));
            pistoesTextField.setText(String.valueOf(passeio.getMotor().getQtdPist()));
            potenciaTextField.setText(String.valueOf(passeio.getMotor().getPotencia()));
            passageirosTextField.setText(String.valueOf(passeio.getQtdPassegeiros()));
        }
        else{
            JOptionPane.showMessageDialog(null, "Não existe veículo cadastrada com a placa informada!", "Veiculo Inexistente", JOptionPane.ERROR_MESSAGE);
            limpar();
            placaTextField.requestFocus();
        }
    }

    private void limpar(){
        ArrayList<Frame> framesList = new ArrayList<Frame>(List.of(JFrame.getFrames()));
        utilidadesCampos.limpaCampos((JFrame)(framesList.stream().filter(x -> x.isVisible() && x.isActive()).findAny().get()));
        placaTextField.requestFocus();
    }

    private void sair(){
        dispose();
    }

    public void excluir(){
        Passeio passeio = new Passeio();
        passeio.setPlaca(placaTextField.getText());
        passeio = (Passeio) bdVeiculos.consultarPelaPlaca(passeio);
        if (passeio == null){
            JOptionPane.showMessageDialog(null, "Não existe veículo cadastrada com a placa informada!", "Veiculo Inexistente", JOptionPane.ERROR_MESSAGE);
            limpar();
            placaTextField.requestFocus();
        }
        else{
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o veículo de placa " + passeio.getPlaca() + "?", "Excluir?", JOptionPane.YES_NO_CANCEL_OPTION);
            if (resposta == 0){
                bdVeiculos.excluiPasseio(passeio);
                limpar();
            }else {
                placaTextField.requestFocus();
            }
        }
    }




}
