package ev3.ut6.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundoext7;

import java.util.ArrayList;
import java.util.List;

public class Almacen_SIN_RESOLVER {
    private int numeroPlazas;
    private List<Bicicleta_SIN_RESOLVER> bicisReparar;

    public Almacen_SIN_RESOLVER(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
        this.bicisReparar = new ArrayList<>();
    }

    public void admitirBici(Bicicleta_SIN_RESOLVER bici) throws SinPlazasException_SIN_RESOLVER {
        if (plazasLibres() > 0) {
            bicisReparar.add(bici);
        } else {
            throw new SinPlazasException_SIN_RESOLVER("No hay plazas libres en el almacen");
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

    public List<Bicicleta_SIN_RESOLVER> getBicisReparar() {
        return bicisReparar;
    }

    public void setBicisReparar(List<Bicicleta_SIN_RESOLVER> bicisReparar) {
        this.bicisReparar = bicisReparar;
    }
}

