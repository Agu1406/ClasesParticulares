package ev2.ut5_pooexcepcionesio.u04repaso.practicas.pruebaslibrescoleccion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Ejercicio 05 - Colecciones y herencia.
 */
public class Ejercicio05_ColeccionesYHerencia_SIN_RESOLVER {

    public static void main(String[] args) {
        // TODO: probar Set sin duplicados y HashMap con clave repetida/null.
        // TODO: probar acceso a miembros protected/default/private con una subclase.
    }

    public static Set<Object> construirSetSinDuplicados() {
        Set<Object> datos = new HashSet<>();
        // TODO
        return datos;
    }

    public static HashMap<String, Integer> construirMapa() {
        HashMap<String, Integer> mapa = new HashMap<>();
        // TODO
        return mapa;
    }
}

class PadreAcceso {
    private int privado = 1;
    protected int protegido = 2;
    int porDefecto = 3;

    public int getPrivado() {
        return privado;
    }
}

class HijaAcceso extends PadreAcceso {
    // TODO: crear metodo resumenAccesos() que use protegido y porDefecto.
}
