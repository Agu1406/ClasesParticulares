package madrid.cesjuanpablosegundo.EX_T7;

import java.util.ArrayList;
import java.util.List;

public class Almacen {
    private int numeroPlazas;
    private List<Bicicleta> bicisReparar;

    public Almacen(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
        this.bicisReparar = new ArrayList<>();
    }

    public void admitirBici(Bicicleta bici) throws SinPlazasException {
        if (plazasLibres() > 0) {
            bicisReparar.add(bici);
        } else {
            throw new SinPlazasException("No hay plazas libres en el almacen");
        }
    }

    public int plazasLibres() {
        return numeroPlazas - bicisReparar.size();
    }

    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    public List<Bicicleta> getBicisReparar() {
        return bicisReparar;
    }

    public void setBicisReparar(List<Bicicleta> bicisReparar) {
        this.bicisReparar = bicisReparar;
    }
}

