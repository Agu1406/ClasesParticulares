package ev3.ut6.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundoext7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tienda_RESUELTO {
    private Almacen_RESUELTO almacen;
    private List<Bicicleta_SIN_RESOLVER> bicicletasStock;
    private double caja;

    public Tienda_RESUELTO(Almacen_RESUELTO almacen) {
        this.almacen = almacen;
        this.bicicletasStock = new ArrayList<>();
        this.caja = 0;
    }

    public void construirAlmacen(Almacen_RESUELTO almacen) {
        this.almacen = almacen;
    }

    public void agregarBici(Bicicleta_SIN_RESOLVER bici) throws SinPlazasException_RESUELTO {
        if (bicicletasStock.size() < almacen.getNumeroPlazas()) {
            bicicletasStock.add(bici);
        } else {
            throw new SinPlazasException_RESUELTO("No hay plazas para agregar mas bicicletas al stock");
        }
    }

    public void agregarBicicletaReparar(Bicicleta_SIN_RESOLVER bici) throws SinPlazasException_RESUELTO {
        almacen.admitirBici(bici);
    }

    public void venderBicicleta(int posicion) {
        Bicicleta_SIN_RESOLVER bici = bicicletasStock.get(posicion);
        bici.mostrarDatos();
        caja = caja + bici.getPrecio();
        bicicletasStock.remove(posicion);
    }

    public void repararBicis() {
        Iterator<Bicicleta_SIN_RESOLVER> iterator = almacen.getBicisReparar().iterator();
        while (iterator.hasNext()) {
            Bicicleta_SIN_RESOLVER bici = iterator.next();
            bici.mostrarDatos();
            double costeReparacion = bici.reparar();
            int minimo = 50;
            int maximo = 100;
            int cantidadExtra = (int) (Math.random() * (maximo - minimo + 1)) + minimo;
            caja = caja + costeReparacion + cantidadExtra;
            iterator.remove();
        }
    }

    public Almacen_RESUELTO getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen_RESUELTO almacen) {
        this.almacen = almacen;
    }

    public List<Bicicleta_SIN_RESOLVER> getBicicletasStock() {
        return bicicletasStock;
    }

    public void setBicicletasStock(List<Bicicleta_SIN_RESOLVER> bicicletasStock) {
        this.bicicletasStock = bicicletasStock;
    }

    public double getCaja() {
        return caja;
    }

    public void setCaja(double caja) {
        this.caja = caja;
    }
}

