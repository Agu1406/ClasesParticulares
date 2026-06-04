package ev3.ut9.pf.principios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Teoria: funciones puras e inmutabilidad (PDF diapos 28-29).
 *
 * <p><b>Que es una funcion pura?</b> Depende solo de sus parametros, no lee ni modifica
 * estado global, y no produce efectos secundarios (imprimir, escribir fichero, mutar
 * listas externas). Misma entrada -> misma salida siempre.</p>
 *
 * <p><b>Que es inmutabilidad?</b> Datos que no cambian despues de crearse. {@code List.of}
 * devuelve lista inmutable; transformar con stream+collect crea otra lista en lugar
 * de alterar la original.</p>
 *
 * <p><b>Por que importa en PF?</b> Codigo mas facil de razonar, testear y paralelizar.
 * Si no hay estado compartido mutando, dos hilos no se pisan.</p>
 *
 * <p><b>Anti-patron mostrado:</b> forEach que hace add en lista externa. Funciona en
 * secuencial pero es fragil y incorrecto en parallelStream.</p>
 *
 * <p><b>Patron preferido:</b> map + collect devuelve nueva lista; la fuente queda intacta.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class FuncionesPurasyInmutabilidadIntro {

    public static int cuadrado(int x) {
        return x * x;
    }

    private static int contadorGlobal = 0;

    public static int fImpura() {
        return 2 * contadorGlobal;
    }

    public static void gImpura() {
        contadorGlobal++;
    }

    public static void main(String[] args) {
        System.out.println("Pura cuadrado(5): " + cuadrado(5));

        List<String> nombres = List.of("ana", "bob");
        List<String> mal = new ArrayList<>();
        nombres.stream()
                .map(String::toUpperCase)
                .forEach(mal::add);
        System.out.println("Impuro (forEach + add externo): " + mal);

        List<String> bien = nombres.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Preferible collect: " + bien);

        final List<String> inmutable = List.of("John");
        System.out.println("List.of es inmutable: " + inmutable);
    }
}
