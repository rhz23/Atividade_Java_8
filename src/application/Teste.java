package application;

import bd.BDVeiculos;
import entities.Carga;
import entities.Passeio;
import exceptions.VeicExistException;
import exceptions.VelocException;
import utils.Leitura;
import views.GestaoVeiculosMainView;

import javax.swing.*;

public class Teste {


    //static Leitura lt = new Leitura();
//    static BDVeiculos bdVeiculos =  new BDVeiculos();



    public static void main(String[] args) throws VelocException, VeicExistException {




        /*
        int opt = 0;

        while (opt !=99){
            System.out.println("\n\nSistema de Gestão de Veículos - Menu Inicial\n");
            System.out.println("\t1. Cadastrar Veículo de Passeio");
            System.out.println("\t2. Cadastrar Veículo de Carga");
            System.out.println("\t3. Imprimir Todos os Veículos de Passeio");
            System.out.println("\t4. Imprimir Todos os Veículos de Carga");
            System.out.println("\t5. Imprimir Veículo de Passeio pela Placa");
            System.out.println("\t6. Imprimir Veículo de Carga pela Placa");
            System.out.println("\t7. Excluir Veículo de Passeio pela Placa");
            System.out.println("\t8. Excluir Veículo de Carga pela Placa");
            System.out.println("\t9. Sair do Sistema");

            try{
                opt = Integer.parseInt(lt.entDados("\nEntre com a opção desejada: "));
            }
            catch(NumberFormatException e){
                lt.entDados("\nO valor escolido deve estar entre as opções apresentadas!");
                continue;
            }

            switch (opt){
                case 1:
                    String continua;
                    do{
                        Passeio passeio = new Passeio();
                        passeio = cadastraVeiculoPasseio(passeio);
                        if(passeio != null){
                            System.out.println("\nO veículo de placa " + passeio.getPlaca() + " foi cadastrado com sucesso!");
                        }
                        else{
                            System.out.println("\n\tVeículo não cadastrado!");
                        }

                        continua = lt.entDados("\nDeseja adicionar outro veiculo de passeio? (SIM ou NAO)");
                    }while(continua.equals("SIM"));

                    break;

                case 2:
                    do{
                        Carga carga = new Carga();
                        cadastrarVeiculoCarga(carga);
                        if(carga != null){
                            System.out.println("\nO veículo de placa " + carga.getPlaca() + " foi cadastrado com sucesso!");
                        }
                        else{
                            System.out.println("\n\tVeículo não cadastrado!");
                        }
                        continua = lt.entDados("\nDeseja adicionar outro veiculo de carga? (SIM ou NAO)");
                    }while (continua.equals("SIM"));
                    break;

                case 3:
                    imprimirTodosPasseio();
                    break;

                case 4:
                    imprimirTodosCarga();
                    break;

                case 5:
                    System.out.println("\n\n==================================");
                    String placaPasseio = lt.entDados("Entre com a placa do veiculo de passeio: ");
                    imprimiPasseioPlaca(placaPasseio);
                    lt.entDados("\n\nTecle enter para retornar ao menu inicial:");
                    break;

                case 6:
                    System.out.println("\n\n==================================");
                    String placaCarga = lt.entDados("Entre com a placa do veiculo de carga: ");
                    imprimiCargaPlaca(placaCarga);
                    lt.entDados("\n\nTecle enter para retornar ao menu inicial:");
                    break;

                case 7:
                    System.out.println("\n\n==================================");
                    placaPasseio = lt.entDados("Entre com a placa do veiculo de Passeio que deseja excluir: ");
                    excluirPasseioPlaca(placaPasseio);
                    break;

                case 8:
                    System.out.println("\n\n==================================");
                    placaCarga = lt.entDados("Entre com a placa do veiculo de Carga que deseja excluir: ");
                    excluirCargaPlaca(placaCarga);
                    break;

                case 9:

                    String confirma = lt.entDados("Deseja realmente sair do sistema? <S/N>");
                    if (confirma.equalsIgnoreCase("S")){
                        System.out.println("\n\nSaindo do sistema==================");
                        System.out.println("Aplicação encerrada");
                        opt = 99;
                    }
                    break;

                default:
                    System.out.println("Entre com uma das opções abaixo:");

                    break;
            }
        }
    }

    private static Passeio cadastraVeiculoPasseio(Passeio passeio) throws VelocException {
        System.out.println("\n\n==================================\n");
        passeio.setPlaca(lt.entDados("Entre com o valor da placa: "));
        passeio.setMarca(lt.entDados("Entre com o nome da marca: "));
        passeio.setModelo(lt.entDados("Entre com o nome do modelo: "));
        passeio.setCor(lt.entDados("Entre com a cor do veiculo: "));

        try {
            passeio.setVelocMax(Float.parseFloat(lt.entDados("Entre com a velocidade máxima: ")));
        }catch(VelocException e){
            passeio.setVelocMax(e.velocException(passeio));
        }

        passeio.setQtdRodas(Integer.parseInt(lt.entDados("Entre com a quantidade de rodas: ")));
        passeio.getMotor().setQtdPist(Integer.parseInt(lt.entDados("Entre com a quantidade de pistões do motor do veiculo: ")));
        passeio.getMotor().setPotencia(Integer.parseInt(lt.entDados("Entre com a potencia do veiculo: ")));
        passeio.setQtdPassegeiros(Integer.parseInt(lt.entDados("Entre com a quantidade de passageiros do veiculo: ")));

        try{
            bdVeiculos.incluiPasseio(passeio);
            return passeio;
        }
        catch(VeicExistException e){
            e.veicExistException();
            return null;
        }
    }

    private static Carga cadastrarVeiculoCarga(Carga carga) throws VelocException {
        System.out.println("\n\n==================================\n");
        carga.setPlaca(lt.entDados("Entre com o valor da placa do veiculo: "));
        carga.setMarca(lt.entDados("Entre com o nome da marca do veiculo: "));
        carga.setModelo(lt.entDados("Entre com o modelo do veiculo: "));
        carga.setCor(lt.entDados("Entre com a cor do veiculo: "));

        try {
            carga.setVelocMax(Float.parseFloat(lt.entDados("Entre com a velocidade máxima: ")));
        }catch(VelocException e){
            carga.setVelocMax(e.velocException(carga));
        }

        carga.setQtdRodas(Integer.parseInt(lt.entDados("Entre com a quantidade de rodas do veiculo: ")));
        carga.getMotor().setQtdPist(Integer.parseInt(lt.entDados("Entre com a quantidade de pistões do motor do veiculo: ")));
        carga.getMotor().setPotencia(Integer.parseInt(lt.entDados("Entre com a potencia do veiculo: ")));
        carga.setCargaMax(Integer.parseInt(lt.entDados("Entre com a carga maxima suportada pelo veiculo: ")));
        carga.setTara(Integer.parseInt((lt.entDados("Entre com o peso de tara do veiculo: "))));

        try{
            bdVeiculos.incluiCarga(carga);
            return carga;
        }
        catch(VeicExistException e){
            e.veicExistException();
            return null;
        }
    }

    private static void imprimirTodosPasseio() {
        if (bdVeiculos.getListaPasseio().size() != 0){
            System.out.println("\n\n==================================\n");
            System.out.println("Os veiculos de passeio cadastrados são:");
            for (Passeio veicPasseio: bdVeiculos.getListaPasseio()) {
                System.out.println(veicPasseio);
            }
            System.out.println("\nFim da lista de veiculos==========");
        }else {
            System.out.println("\nNão há veículos de passeio cadastrados!");
        }
        lt.entDados("\nTecle enter para retornar ao menu inicial:");
    }

    private static void imprimirTodosCarga() {
        if (bdVeiculos.getListaCarga().size() != 0){
            System.out.println("\n\n==================================\n");
            System.out.println("Os veiculos de carga cadastrados são:");
            for (Carga veicCarga: bdVeiculos.getListaCarga()) {
                System.out.println(veicCarga    );
            }
            System.out.println("\nFim da lista de veiculos==========");
        }
        else{
            System.out.println("\nNão há veículos de carga cadastrados!");
        }
        lt.entDados("Tecle enter para retornar ao menu inicial:");
    }

    private static void imprimiPasseioPlaca(String placaPasseio) {
        for (Passeio veicPasseio: bdVeiculos.getListaPasseio()) {
            if (placaPasseio.equals(veicPasseio.getPlaca())){
                System.out.println("\nSeguem os dados do veiculo:");
                System.out.printf("%s", veicPasseio.getPlaca());
                System.out.printf("Veiculo Passeio{placa=%s, marca=%s, modelo=%s, cor=%s, velocMax=%.2f km/h, qtdRodas=%d, motor=Motor{qtdPist= %d, potencia= d%c cv}, qtdPassageiros= %d, velocidadeCalc = %.2f m/h, totalCaracteres = %d}",
                        veicPasseio.getPlaca(), veicPasseio.getMarca(), veicPasseio.getModelo(), veicPasseio.getCor(), veicPasseio.getVelocMax(), veicPasseio.getQtdRodas(), veicPasseio.getMotor().getQtdPist(), veicPasseio.getMotor().getPotencia(), veicPasseio.getQtdPassegeiros(), veicPasseio.calcVel(veicPasseio.getVelocMax()), veicPasseio.calcula());
            }
        }
    }

    private static void imprimiCargaPlaca(String placaCarga) {
        for (Carga veicCarga: bdVeiculos.getListaCarga()) {
            if (placaCarga.equals(veicCarga.getPlaca())){
                System.out.println("\nSeguem os dados do veiculo:");
                System.out.printf("Veiculo Carga{placa=%s, marca=%s, modelo=%s, cor=%s, velocMax=%.2f km/h, qtdRodas=%d, motor=Motor{qtdPist= %d, potencia= d%c cv}, cargaMax= %d, tara= %d, velocidadeCalc = %.2f cm/h, somaAtributos = %d}",
                        veicCarga.getPlaca(), veicCarga.getMarca(), veicCarga.getModelo(), veicCarga.getCor(), veicCarga.getVelocMax(), veicCarga.getQtdRodas(), veicCarga.getMotor().getQtdPist(), veicCarga.getMotor().getPotencia(), veicCarga.getCargaMax(), veicCarga.getTara(), veicCarga.calcVel(veicCarga.getVelocMax()), veicCarga.calcula());
            }
        }
    }

    private static void excluirPasseioPlaca(String placaPasseio){
        boolean existe = false;
        for (Passeio veicPasseio: bdVeiculos.getListaPasseio()) {
            if (placaPasseio.equalsIgnoreCase(veicPasseio.getPlaca())){
                existe = true;
                System.out.println("\n" + veicPasseio);
                String confirma = lt.entDados("\nTem certeza que deseja excluir o veículo acima: <S/N>");
                if(confirma.equalsIgnoreCase("S")){
                    bdVeiculos.excluiPasseio(veicPasseio);
                    System.out.println("Veiculo excluído!");
                    break;
                }else{
                    System.out.println("\nNenhum veículo excluido!");
                    lt.entDados("Pressione uma tecla para retornar ao menu inicial:");
                    break;
                }
            }
        }
        if (!existe){
            System.out.println("Não existe veículo com a placa informada!");
            lt.entDados("\nPressione qualquer tecla para retornar ao menu inicial:");
        }
    }

    private static void excluirCargaPlaca(String placaCarga){
        boolean existe = false;
        for (Carga veicCarga: bdVeiculos.getListaCarga()) {
            if (placaCarga.equalsIgnoreCase(veicCarga.getPlaca())){
                existe = true;
                System.out.println("\n" + veicCarga);
                String confirma = lt.entDados("\nTem certeza que deseja excluir o veículo acima: <S/N>");
                if(confirma.equalsIgnoreCase("S")){
                    bdVeiculos.excluiCarga(veicCarga);
                    System.out.println("Veiculo excluído!");
                }else{
                    System.out.println("\nNenhum veículo excluido!");
                    lt.entDados("Pressione uma tecla para retornar ao menu inicial:");
                }
            }
        }
        if (!existe){
            System.out.println("Não existe veículo com a placa informada!");
            lt.entDados("\nPressione qualquer tecla para retornar ao menu inicial:");
        }

         */
    }
}
