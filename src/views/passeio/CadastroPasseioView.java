package views.passeio;

import bd.BDVeiculos;
import entities.Passeio;
import exceptions.VeicExistException;
import exceptions.VelocException;
import utils.FieldUtils;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CadastroPasseioView extends JFrame{

   //Botões
   private JButton cadastrarButton = new JButton("<html><u>C</u>adastrar");
   private JButton limparButton =  new JButton("Limpar");
   private JButton novoButton = new JButton("Novo");
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


    FieldUtils utilidadesCampos =  FieldUtils.criaFieldUtilsUnico();

    BDVeiculos bdVeiculos = BDVeiculos.criaBDVeiculos();

    private static CadastroPasseioView cadastroPasseioViewUnico;

    public static CadastroPasseioView criaCadastroPasseioView(){
        if (cadastroPasseioViewUnico == null){
            cadastroPasseioViewUnico = new CadastroPasseioView();
        }
        return cadastroPasseioViewUnico;
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CadastroPasseioView().setVisible(true);
            }
        });

    }

    private CadastroPasseioView(){
        initJanela();
    }

    private void initJanela(){

        //new JFrame("Veículo de Carga");
        setTitle("Cadastro de Passeio");
        setBounds(200, 200, 430, 320);
        setMinimumSize(new Dimension(430, 320));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        //Action Listener dos botões
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                try {
                    cadastrarPasseio();
                } catch (VelocException e) {
                    e.printStackTrace();
                }
            }
        });

        limparButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                limpar();
            }
        });

        novoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                novo();
            }
        });

        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                sair();
            }
        });

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
        cadastrarButton.setBounds(10, 255, 90, 20);
        limparButton.setBounds(110, 255, 90, 20);
        novoButton.setBounds(210, 255, 90, 20);
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
        getContentPane().add(cadastrarButton);
        getContentPane().add(limparButton);
        getContentPane().add(novoButton);
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

        //formatando FormatedTexteField
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
    }

    private void cadastrarPasseio() throws VelocException {
        Passeio passeio = new Passeio();
        passeio.setPlaca(placaTextField.getText());
        passeio.setMarca(marcaTextField.getText());
        passeio.setModelo(modeloTextField.getText());
        passeio.setCor(corTextField.getText());
        try {
            passeio.setVelocMax(Float.parseFloat(velMaxTextField.getText()));
        } catch (VelocException e) {
            passeio.setVelocMax(e.velocException(passeio));
        }
        passeio.setQtdRodas(Integer.parseInt(rodasTextField.getText()));
        passeio.getMotor().setQtdPist(Integer.parseInt(pistoesTextField.getText()));
        passeio.getMotor().setPotencia(Integer.parseInt(potenciaTextField.getText()));
        passeio.setQtdPassegeiros(Integer.parseInt(passageirosTextField.getText()));

        Passeio retorno = new Passeio();

        try{
            bdVeiculos.incluiPasseio(passeio);
            JOptionPane.showMessageDialog(null, "O veículo de placa " + passeio.getPlaca() + " foi cadastrado com sucesso!", "Cadastro Efetuado", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(VeicExistException e){
            e.veicExistException();
        }

        if(retorno != null){
            utilidadesCampos.bloqueiaCampos(this);
        }
    }

    private void limpar(){
        utilidadesCampos.limpaCampos(cadastroPasseioViewUnico);
        placaTextField.requestFocus();
        utilidadesCampos.liberaCampos(cadastroPasseioViewUnico);
    }

    private void sair(){
        limpar();
        dispose();
    }

    private void novo(){
        utilidadesCampos.liberaCampos(this);
        utilidadesCampos.limpaCampos(this);
        placaTextField.requestFocus();
    }


}
