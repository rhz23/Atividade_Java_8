package bd;

import entities.Carga;
import entities.Passeio;
import entities.Veiculo;
import exceptions.VeicExistException;

import java.util.ArrayList;
import java.util.List;

public class BDVeiculos {

    private static BDVeiculos bdVeiculosUnico;

    List<Passeio> listaPasseio = new ArrayList<>();
    List<Carga> listaCarga = new ArrayList<>();

    private BDVeiculos() {
    }

    public static BDVeiculos criaBDVeiculos(){
        if (bdVeiculosUnico == null){
            bdVeiculosUnico = new BDVeiculos();
        }
        return bdVeiculosUnico;
    }

    public BDVeiculos(List<Passeio> listaPasseio, List<Carga> listaCarga) {
        this.listaPasseio = listaPasseio;
        this.listaCarga = listaCarga;
    }

    public List<Passeio> getListaPasseio() {
        return listaPasseio;
    }

    public void setListaPasseio(List<Passeio> listaPasseio) {
        this.listaPasseio = listaPasseio;
    }

    public List<Carga> getListaCarga() {
        return listaCarga;
    }

    public void setListaCarga(List<Carga> listaCarga) {
        this.listaCarga = listaCarga;
    }

    public Passeio incluiPasseio(Passeio p) throws VeicExistException {

        boolean existe = false;
        for (Passeio veicPasseio: listaPasseio) {
            if (p.getPlaca().equalsIgnoreCase(veicPasseio.getPlaca())){
                existe = true;
            }
        }
        if (existe){
            throw new VeicExistException();
        }
        else{
            listaPasseio.add(p);
            return p;
        }
    }

    public void incluiCarga(Carga c) throws VeicExistException {

        boolean existe = false;
        for (Carga veicCarga: listaCarga) {
            if (c.getPlaca().equalsIgnoreCase(veicCarga.getPlaca())){
                existe = true;
            }
        }
        if (existe){
            throw new VeicExistException();
        }
        else{
            listaCarga.add(c);
        }
    }

    public Veiculo consultarPelaPlaca(Veiculo veiculo){
        if (veiculo instanceof Passeio){
            for (Passeio p : listaPasseio) {
                if (p.getPlaca().equalsIgnoreCase(veiculo.getPlaca())){
                    return p;
                }
            }
            return null;
        }
        if (veiculo instanceof Carga){
            for (Carga c : listaCarga) {
                if (c.getPlaca().equalsIgnoreCase(veiculo.getPlaca())){
                    return c;
                }
            }
            return null;
        }
        else return null;
    }

    public void excluiPasseio(Passeio veicPasseio){
            listaPasseio.remove(veicPasseio);
    }

    public void excluiCarga(Carga veicCarga){
        listaCarga.remove(veicCarga);
    }

    public void excluirTodosPasseio(){
        listaPasseio = new ArrayList<>();
    }

    public void excluirTodosCarga(){
        listaCarga = new ArrayList<>();
    }

}
