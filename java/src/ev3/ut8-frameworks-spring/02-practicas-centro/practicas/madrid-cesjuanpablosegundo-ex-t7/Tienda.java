package madrid.cesjuanpablosegundo.EX_T7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tienda {
    private Almacen almacen;
    private List<Bicicleta> bicicletasStock;
    private double caja;

    public Tienda(Almacen almacen) {
        this.almacen = almacen;
        this.bicicletasStock = new ArrayList<>();
        this.caja = 0;
    }

    public void construirAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public void agregarBici(Bicicleta bici) throws SinPlazasException {
        if (bicicletasStock.size() < almacen.getNumeroPlazas()) {
            bicicletasStock.add(bici);
        } else {
            throw new SinPlazasException("No hay plazas para agregar mas bicicletas al stock");
        }
    }

    public void agregarBicicletaReparar(Bicicleta bici) throws SinPlazasException {
        almacen.admitirBici(bici);
    }

    public void venderBicicleta(int posicion) {
        Bicicleta bici = bicicletasStock.get(posicion);
        bici.mostrarDatos();
        caja = caja + bici.getPrecio();
        bicicletasStock.remove(posicion);
    }

    public void repararBicis() {
        Iterator<Bicicleta> iterator = almacen.getBicisReparar().iterator();
        while (iterator.hasNext()) {
            Bicicleta bici = iterator.next();
            bici.mostrarDatos();
            double costeReparacion = bici.reparar();
            int minimo = 50;
            int maximo = 100;
            int cantidadExtra = (int) (Math.random() * (maximo - minimo + 1)) + minimo;
            caja = caja + costeReparacion + cantidadExtra;
            iterator.remove();
        }
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public List<Bicicleta> getBicicletasStock() {
        return bicicletasStock;
    }

    public void setBicicletasStock(List<Bicicleta> bicicletasStock) {
        this.bicicletasStock = bicicletasStock;
    }

    public double getCaja() {
        return caja;
    }

    public void setCaja(double caja) {
        this.caja = caja;
    }
}

