package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundoext7;

import java.util.ArrayList;
import java.util.List;

public class Almacen_RESUELTO {
    private int numeroPlazas;
    private List<Bicicleta_SIN_RESOLVER> bicisReparar;

    public Almacen_RESUELTO(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
        this.bicisReparar = new ArrayList<>();
    }

    public void admitirBici(Bicicleta_SIN_RESOLVER bici) throws SinPlazasException_RESUELTO {
        if (plazasLibres() > 0) {
            bicisReparar.add(bici);
        } else {
            throw new SinPlazasException_RESUELTO("No hay plazas libres en el almacen");
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

