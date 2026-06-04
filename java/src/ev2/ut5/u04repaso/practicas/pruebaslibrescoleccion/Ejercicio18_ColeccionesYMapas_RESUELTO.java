package ev2.ut5.u04repaso.practicas.pruebaslibrescoleccion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ejercicio18_ColeccionesYMapas_RESUELTO {

    public static void main(String[] args) {
        List<String> lista = crearListaConDuplicados();
        System.out.println("List size = " + lista.size());

        Set<String> set = convertirASet(lista);
        System.out.println("Set size = " + set.size());

        Map<String, Integer> mapa = crearMapa();
        System.out.println("map.get('dos') = " + mapa.get("dos"));
        System.out.println("map.get(null) = " + mapa.get(null));
        System.out.println("map.size() = " + mapa.size());
    }

    static List<String> crearListaConDuplicados() {
        List<String> datos = new ArrayList<>();
        datos.add("ana");
        datos.add("ana");
        datos.add("luis");
        return datos;
    }

    static Set<String> convertirASet(List<String> datos) {
        return new HashSet<>(datos);
    }

    static Map<String, Integer> crearMapa() {
        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("uno", 1);
        mapa.put("dos", 2);
        mapa.put("tres", 3);
        mapa.put("dos", 22);
        mapa.put(null, 100);
        return mapa;
    }
}
