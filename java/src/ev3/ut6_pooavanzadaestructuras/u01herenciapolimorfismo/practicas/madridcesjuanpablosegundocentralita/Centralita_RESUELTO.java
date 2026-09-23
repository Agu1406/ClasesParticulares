package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridcesjuanpablosegundocentralita;

import java.util.ArrayList;

public class Centralita_RESUELTO {
    private final ArrayList<Llamada_RESUELTO> llamadas = new ArrayList<>();

    public void registrarLlamada(Llamada_RESUELTO llamada) {
        llamadas.add(llamada);
        System.out.println("Llamada registrada");
        llamada.mostrarDatos();
    }

    public void mostrarLlamadas() {
        if (llamadas.isEmpty()) {
            System.out.println("No hay llamadas registradas");
            return;
        }
        for (Llamada_RESUELTO l : llamadas) {
            l.mostrarDatos();
        }
    }

    public void mostrarCostesTotales() {
        double total = 0;
        for (Llamada_RESUELTO l : llamadas) {
            total += l.getCoste();
        }
        System.out.println("Coste total = " + total);
    }
}
