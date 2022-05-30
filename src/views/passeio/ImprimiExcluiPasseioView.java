package views.passeio;

import bd.BDVeiculos;
import entities.Passeio;
import utils.FieldUtils;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ImprimiExcluiPasseioView extends JFrame{

    FieldUtils utilidadesCampos =  FieldUtils.criaFieldUtilsUnico();

    BDVeiculos bdVeiculos = BDVeiculos.criaBDVeiculos();

    //Botões
    private JButton imprimirTodosButton =  new JButton("Imprimir Todos");
    private JButton excluirTodosButton = new JButton("Excluir Todos");
    private JButton sairButton = new JButton("Sair");

    //Tabela
    private String[] colunas = {"Placa", "Marca", "Modelo", "Cor", "Qtd. Rodas", "Veloc Máx", "Qtd. Pistões", "Potência", "Qtd. Passag"};
    private DefaultTableModel model = new DefaultTableModel(colunas, 0);
    private JTable tabelaDados = new JTable(model);
    private JScrollPane scrollPane = new JScrollPane(tabelaDados);

    //Lista de veiculos
    private List<Passeio> listaPasseio = bdVeiculos.getListaPasseio();

    //Singleton da classe
    private static ImprimiExcluiPasseioView imprimirExcluirPasseioViewUnico;

    public static ImprimiExcluiPasseioView criaImprimirExcluirPasseioView(){
        if (imprimirExcluirPasseioViewUnico == null){
            imprimirExcluirPasseioViewUnico = new ImprimiExcluiPasseioView();
        }
        return imprimirExcluirPasseioViewUnico;
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImprimiExcluiPasseioView().setVisible(true);
            }
        });
    }

    //construtor
    private ImprimiExcluiPasseioView(){
        initJanela();
    }

    //
    private void initJanela(){

        //Definições do Frame
        setTitle("Imprimir/Excluir todos");
        setMinimumSize(new Dimension(800, 400));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        Container container = getContentPane();

        // TODO: 29/05/2022 - avaliar migração dos paineis para classe separada 
        //Panel da Tabela
        JPanel painelTabela = new JPanel();
        painelTabela.setLayout(new GridLayout(1,1,10,10));
        painelTabela.setBorder(new EmptyBorder(10,10,0,10));
        painelTabela.add(scrollPane);

        //Painel de botoes
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(1,3,20,50));
        painelBotoes.add(imprimirTodosButton);
        painelBotoes.setBorder(new EmptyBorder(10,100,10,100));
        painelBotoes.add(excluirTodosButton);
        painelBotoes.add(sairButton);


        //Action Listener dos botões
        imprimirTodosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                imprimirTodosPasseio();
            }
        });

        excluirTodosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                excluirTodosPasseio();
            }
        });

        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                sair();
            }
        });

        // TODO: 29/05/2022 - verificar se é interessante colocar na classe utils
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

        //Mnemonics dos botões
        imprimirTodosButton.setMnemonic('I');
        excluirTodosButton.setMnemonic('E');
        sairButton.setMnemonic('S');

        //adicionando os paineis ao frame
        container.add(painelTabela, BorderLayout.CENTER);
        container.add(painelBotoes, BorderLayout.SOUTH);
    }

    //metodos
    private void sair(){
        dispose();
        model = new DefaultTableModel(colunas, 0);
        tabelaDados.setModel(model);
    }

    private void imprimirTodosPasseio(){
        listaPasseio = bdVeiculos.getListaPasseio();
        if(listaPasseio.isEmpty()){
            JOptionPane.showMessageDialog(null, "Não há veículos de passeio cadastrados!", "ERRO", JOptionPane.WARNING_MESSAGE);
        }else{
            model = new DefaultTableModel(colunas, 0);
            for (Passeio passeio: listaPasseio) {
                String[] dados = {passeio.getPlaca(), passeio.getMarca(), passeio.getModelo(), passeio.getCor(), String.valueOf(passeio.getQtdRodas()), String.valueOf(passeio.getVelocMax()), String.valueOf(passeio.getMotor().getQtdPist()), String.valueOf(passeio.getMotor().getPotencia()), String.valueOf(passeio.getQtdPassegeiros())};
                model.addRow(dados);
            }
            tabelaDados.setModel(model);
        }
    }

    private boolean excluirTodosPasseio(){
        listaPasseio = bdVeiculos.getListaPasseio();
        if(listaPasseio.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Não há veículos de passeio a serem removidos." , "ERRO",  JOptionPane.ERROR_MESSAGE);
            return false;
        }else {
            bdVeiculos.excluirTodosPasseio();
            model = new DefaultTableModel(colunas, 0);
            tabelaDados.setModel(model);
        }
        return true;
    }


}
