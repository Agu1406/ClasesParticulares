package ev3.ut9.pf.u01lambda.teoria;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Teoria: referencias a metodos (PDF diapos 12).
 *
 * <p><b>Que es?</b> Forma corta de escribir una lambda cuando el cuerpo solo llama a un
 * metodo o constructor que ya existe. Sintaxis: {@code Clase::metodo}, {@code objeto::metodo}
 * o {@code Clase::new}.</p>
 *
 * <p><b>Regla practica:</b> si la lambda solo reenvia el parametro a un metodo existente,
 * puedes usar {@code ::}. Si anades logica ({@code ">> " + x}, condiciones, etc.), lambda.</p>
 *
 * <p><b>Demo en este archivo (en orden):</b></p>
 * <ol>
 *   <li>Tipo 1 - metodo estatico ({@code Integer::parseInt}).</li>
 *   <li>Tipo 2 - objeto concreto + escalera for / for-each / forEach / {@code ::}.</li>
 *   <li>Tipo 3 - instancia generica ({@code String::length}).</li>
 *   <li>Tipo 4 - constructor ({@code ArrayList::new}).</li>
 *   <li>Usos en sort y stream.</li>
 *   <li>Cuando NO usar referencia.</li>
 * </ol>
 *
 * <p><b>Guion de clase:</b> bloques {@code /** ... *\/} con salida esperada al final de
 * cada metodo por si no puedes ejecutar.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class U01_ReferenciasMetodoIntro {

    public static void main(String[] args) {
        demostrarTipo1MetodoEstatico();
        demostrarTipo2RecorridoDeLista();
        demostrarTipo3InstanciaGenerica();
        demostrarTipo4Constructor();
        demostrarUsosEnSortYStream();
        demostrarCuandoNoUsarReferencia();
    }

    /**
     * TIPO 1 - Metodo estatico.
     * Lambda simple: texto -> Integer.parseInt(texto)
     * Referencia:     Integer::parseInt
     */
    private static void demostrarTipo1MetodoEstatico() {
        System.out.println();
        System.out.println("TIPO 1: metodo estatico (Integer::parseInt)");

        String numeroTexto = "1406";

        /**
         * Tradicional: llamo al metodo estatico parseInt y uso el Integer resultante.
         */
        Integer numeroTradicional = Integer.parseInt(numeroTexto);
        numeroTradicional += 1406;
        System.out.println("Tradicional (parseInt + suma): " + numeroTradicional);

        /**
         * Tradicional con metodo propio: mismo parseInt, pero con nombre reutilizable.
         */
        System.out.println("Tradicional (metodo convertirTextoNumero): " + convertirTextoNumero("2000"));

        /**
         * Lambda con condicion: aqui NO se puede usar :: porque hay logica extra (length < 10).
         * Contrasta con la referencia pura de abajo.
         */
        Function<String, Integer> convertidorConCondicion = texto ->
                (texto.length() < 10) ? Integer.parseInt(texto) : null;

        System.out.println("Lambda con condicion (2000): " + convertidorConCondicion.apply("2000"));
        System.out.println("Lambda con condicion (1500): " + convertidorConCondicion.apply("1500"));

        /**
         * Referencia: solo delega en parseInt, sin condiciones. Es el atajo de:
         * texto -> Integer.parseInt(texto)
         */
        Function<String, Integer> convertidorReferencia = Integer::parseInt;

        System.out.println("Referencia (2000): " + convertidorReferencia.apply("2000"));
        System.out.println("Referencia (1500): " + convertidorReferencia.apply("1500"));

        /**
         * Salida esperada:
         * TIPO 1: metodo estatico (Integer::parseInt)
         * Tradicional (parseInt + suma): 2812
         * Tradicional (metodo convertirTextoNumero): 2000
         * Lambda con condicion (2000): 2000
         * Lambda con condicion (1500): 1500
         * Referencia (2000): 2000
         * Referencia (1500): 1500
         */
    }

    static Integer convertirTextoNumero(String texto) {
        return Integer.parseInt(texto);
    }

    /**
     * TIPO 2 - Objeto concreto (System.out::println) y escalera de recorridos.
     */
    private static void demostrarTipo2RecorridoDeLista() {
        System.out.println();
        System.out.println("TIPO 2: recorrer lista (for -> for-each -> forEach -> ::)");

        List<String> listaNombres = List.of("Alice", "Bob", "John");

        System.out.println("--- for con indice (control total) ---");

        /**
         * Enfoque tradicional junior: controlas indice, condicion de parada y acceso con get().
         */
        for (int posicion = 0; posicion < listaNombres.size(); posicion++) {
            System.out.println("Posicion " + posicion + " - nombre: " + listaNombres.get(posicion));
        }

        System.out.println("--- for-each (menos ruido, misma idea) ---");

        /**
         * for-each: recorre cada elemento sin manejar el indice manualmente.
         *
         * IMPORTANTE: la variable "nombre" es una COPIA de cada String de la lista.
         * Aunque hagas nombre = nombre + " sufijo", NO modificas la lista ni los textos
         * originales (String es inmutable y la lista es inmutable con List.of).
         */
        for (String nombre : listaNombres) {
            System.out.println("Nombre: " + nombre);
        }

        System.out.println("--- forEach con lambda ---");

        /**
         * Enfoque funcional: la coleccion aplica una accion por elemento (Consumer).
         * Sacrificas control fino del indice a cambio de codigo mas declarativo (DRY).
         */
        listaNombres.forEach(nombre -> System.out.println(nombre));

        System.out.println("--- forEach con referencia (maxima simplificacion) ---");

        /**
         * System.out::println = "usa println de este objeto concreto".
         * Equivalente a la lambda de arriba cuando solo imprimes el parametro tal cual.
         */
        listaNombres.forEach(System.out::println);

        /**
         * Salida esperada (resumen):
         * Posicion 0 - nombre: Alice
         * Posicion 1 - nombre: Bob
         * Posicion 2 - nombre: John
         * Nombre: Alice
         * Nombre: Bob
         * Nombre: John
         * Alice, Bob, John (lambda)
         * Alice, Bob, John (referencia)
         */
    }

    /**
     * TIPO 3 - Instancia generica: String::length
     */
    private static void demostrarTipo3InstanciaGenerica() {
        System.out.println();
        System.out.println("TIPO 3: instancia generica (String::length)");

        Function<String, Integer> conLambda = texto -> texto.length();
        Function<String, Integer> conReferencia = String::length;

        String palabra = "stream";

        System.out.println("Con lambda:     " + conLambda.apply(palabra));
        System.out.println("Con referencia: " + conReferencia.apply(palabra));

        /**
         * Salida esperada:
         * Con lambda:     6
         * Con referencia: 6
         */
    }

    /**
     * TIPO 4 - Constructor: ArrayList::new
     */
    private static void demostrarTipo4Constructor() {
        System.out.println();
        System.out.println("TIPO 4: constructor (ArrayList::new)");

        Supplier<ArrayList<String>> conLambda = () -> new ArrayList<>();
        Supplier<ArrayList<String>> conReferencia = ArrayList::new;

        ArrayList<String> listaLambda = conLambda.get();
        ArrayList<String> listaReferencia = conReferencia.get();

        listaLambda.add("creada con lambda");
        listaReferencia.add("creada con ::new");

        System.out.println("Con lambda:     " + listaLambda);
        System.out.println("Con referencia: " + listaReferencia);

        /**
         * Salida esperada:
         * Con lambda:     [creada con lambda]
         * Con referencia: [creada con ::new]
         */
    }

    /** Reutiliza tipos 1 y 3 en sort y stream (lo veras en ejercicios y en U01_LambdaIntro). */
    private static void demostrarUsosEnSortYStream() {
        System.out.println();
        System.out.println("USOS HABITUALES: sort y stream");

        List<String> palabras = new ArrayList<>(List.of("stream", "java", "lambda", "pf"));
        palabras.sort(Comparator.comparing(String::length));
        System.out.println("Orden por longitud: " + palabras);

        List<String> textos = List.of("  hola ", "  mundo ");
        List<String> normalizados = textos.stream()
                .map(String::trim)
                .map(String::toUpperCase)
                .toList();
        System.out.println("Textos normalizados: " + normalizados);

        int suma = List.of(1, 2, 3, 4).stream().reduce(0, Integer::sum);
        System.out.println("Suma con Integer::sum: " + suma);

        /**
         * Salida esperada:
         * Orden por longitud: [pf, java, stream, lambda]
         * Textos normalizados: [HOLA, MUNDO]
         * Suma con Integer::sum: 10
         */
    }

    /** Contraejemplo: logica extra -> lambda obligatoria. */
    private static void demostrarCuandoNoUsarReferencia() {
        System.out.println();
        System.out.println("CUANDO NO USAR :: (quedarse con lambda)");

        List<String> nombres = List.of("Ana", "Luis", "Eva");

        nombres.forEach(nombre -> System.out.println(">> " + nombre));

        Comparator<String> criterioExtra = (primera, segunda) ->
                (primera.length() + 1) - (segunda.length() + 1);

        List<String> copia = new ArrayList<>(nombres);
        copia.sort(criterioExtra);
        System.out.println("Orden con logica extra: " + copia);

        /**
         * Salida esperada:
         * >> Ana
         * >> Luis
         * >> Eva
         * Orden con logica extra: [Ana, Eva, Luis]
         */
    }
}
