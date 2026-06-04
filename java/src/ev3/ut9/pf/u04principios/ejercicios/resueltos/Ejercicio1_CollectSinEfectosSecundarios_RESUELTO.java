package ev3.ut9.pf.u04principios.ejercicios.resueltos;

// List.of fabrica listas inmutables de solo lectura, seguras como fuente de datos de prueba.
import java.util.List;
// Collectors materializa el stream en coleccion, String u otro tipo segun el terminal elegido.
import java.util.stream.Collectors;

/**
 * Ejercicio 1 (Principios): collect sin side effects - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Transformacion pura que genera nueva lista upper sin tocar names.
 * 
 * Que hace este codigo resuelto:
 * Imprime mayusculas y confirma que names sigue en minusculas.
 * 
 * Conceptos que demuestra:
 *   - Inmutabilidad de fuente List.of.
 *   - collect vs mutacion externa.
 *   - Separacion transformacion / efecto impresion.
 * 
 * Salida al ejecutar main:
 * [ANA, BOB, CARLOS]
[ana, bob, carlos]
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio1_CollectSinEfectosSecundarios_RESUELTO {
    public static void main(String[] args) {
        // Lista fuente en minusculas; no debe modificarse durante la transformacion funcional.
        List<String> nombres = List.of("ana", "bob", "carlos");
        // stream+collect crea upper separada; names permanece igual (sin side effects).
        List<String> upper = nombres.stream().map(String::toUpperCase).collect(Collectors.toList());
        // Muestra [ANA, BOB, CARLOS]: resultado de la transformacion funcional pura.
        System.out.println(upper);
        // Segundo println confirma que names sigue [ana, bob, carlos] sin mutacion.
        System.out.println(nombres);
    }
}
