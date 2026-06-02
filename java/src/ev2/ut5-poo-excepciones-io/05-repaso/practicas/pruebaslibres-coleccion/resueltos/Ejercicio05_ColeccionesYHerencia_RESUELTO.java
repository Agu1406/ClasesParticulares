package pruebaslibres.practica.coleccion.resueltos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Ejercicio05_ColeccionesYHerencia_RESUELTO {

    public static void main(String[] args) {
        Set<Object> set = construirSetSinDuplicados();
        System.out.println("Set: " + set);

        HashMap<String, Integer> mapa = construirMapa();
        System.out.println("Valor de 'dos': " + mapa.get("dos"));
        System.out.println("Valor null: " + mapa.get(null));
        System.out.println("Tamano mapa: " + mapa.size());

        HijaAccesoResuelto h = new HijaAccesoResuelto();
        System.out.println(h.resumenAccesos());
    }

    public static Set<Object> construirSetSinDuplicados() {
        Set<Object> datos = new HashSet<>();
        datos.add("JAVA");
        datos.add(5);
        datos.add(Boolean.TRUE);
        datos.add(Boolean.TRUE);
        return datos;
    }

    public static HashMap<String, Integer> construirMapa() {
        HashMap<String, Integer> mapa = new HashMap<>();
        mapa.put("uno", 1);
        mapa.put("dos", 2);
        mapa.put("tres", 3);
        mapa.put("dos", 22);
        mapa.put(null, 100);
        return mapa;
    }
}

class PadreAccesoResuelto {
    private int privado = 1;
    protected int protegido = 2;
    int porDefecto = 3;

    public int getPrivado() {
        return privado;
    }
}

class HijaAccesoResuelto extends PadreAccesoResuelto {
    public String resumenAccesos() {
        return "protegido=" + protegido + ", porDefecto=" + porDefecto + ", privado(via getter)=" + getPrivado();
    }
}
