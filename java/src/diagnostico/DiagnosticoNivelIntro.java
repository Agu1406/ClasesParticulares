package diagnostico;

/**
 * Indice de la bateria de diagnostico de nivel Java (0485).
 *
 * <p>Completa en orden los {@code DiagnosticoNN_*_SIN_RESOLVER} de
 * {@code diagnostico/ejercicios/pendientes/}. Para en el primero que no puedas
 * resolver sin mirar {@code resueltos/}: ese numero indica tu EV/UT actual.</p>
 *
 * <p>Convenciones: {@code Scanner teclado}, variables declaradas al inicio,
 * nombres descriptivos en camelCase. Lee las instrucciones en el JavaDoc de cada clase.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public final class DiagnosticoNivelIntro {

    private DiagnosticoNivelIntro() {
    }

    public static void main(String[] args) {
        System.out.println("=== Diagnostico de nivel Java (0485) — 38 ejercicios ===");
        System.out.println();
        imprimirBloque("EV1 · ut1 — RA1 Fundamentos");
        linea(1, "Tipos y media con double", "ut1", "RA1");
        linea(3, "Casteo explicito", "ut1", "RA1");
        System.out.println();
        imprimirBloque("EV1 · ut2 — RA3 Estructuras de control");
        linea(2, "Operadores logicos", "ut2", "RA3");
        linea(4, "if / else", "ut2", "RA3");
        linea(5, "if / else if", "ut2", "RA3");
        linea(6, "switch", "ut2", "RA3");
        linea(7, "bucle for", "ut2", "RA3");
        linea(8, "bucle while", "ut2", "RA3");
        linea(9, "bucle do-while", "ut2", "RA3");
        linea(10, "for + while + do-while combinados", "ut2", "RA3");
        linea(11, "metodo void", "ut2", "RA3");
        linea(12, "metodo con return", "ut2", "RA3");
        linea(13, "sobrecarga de metodos", "ut2", "RA3");
        System.out.println();
        imprimirBloque("EV1 · ut3 — RA2 POO inicial");
        linea(14, "String", "ut3", "RA2");
        linea(15, "envolventes (Integer)", "ut3", "RA2");
        linea(16, "clase simple", "ut3", "RA2");
        System.out.println();
        imprimirBloque("EV2 · ut5_pooexcepcionesio — RA4 POO");
        linea(17, "encapsulamiento", "ut5_pooexcepcionesio", "RA4");
        linea(18, "constructores", "ut5_pooexcepcionesio", "RA4");
        System.out.println();
        imprimirBloque("EV2 · ut4_colecciones — RA6 Colecciones");
        linea(19, "array 1D", "ut4_colecciones", "RA6");
        linea(20, "array 2D", "ut4_colecciones", "RA6");
        linea(21, "ArrayList", "ut4_colecciones", "RA6");
        linea(22, "HashMap", "ut4_colecciones", "RA6");
        linea(23, "HashSet", "ut4_colecciones", "RA6");
        linea(24, "for-each en colecciones", "ut4_colecciones", "RA6");
        System.out.println();
        imprimirBloque("EV2 · ut5_pooexcepcionesio — RA5 E/S y excepciones");
        linea(25, "try-catch", "ut5_pooexcepcionesio", "RA5");
        linea(26, "finally", "ut5_pooexcepcionesio", "RA5");
        linea(27, "throws", "ut5_pooexcepcionesio", "RA5");
        linea(28, "ficheros texto (NIO)", "ut5_pooexcepcionesio", "RA5");
        System.out.println();
        imprimirBloque("EV3 · ut6_pooavanzadaestructuras — RA7 OO avanzado");
        linea(29, "herencia", "ut6_pooavanzadaestructuras", "RA7");
        linea(30, "override y abstract", "ut6_pooavanzadaestructuras", "RA7");
        linea(31, "clases abstractas y polimorfismo", "ut6_pooavanzadaestructuras", "RA7");
        linea(32, "interfaces", "ut6_pooavanzadaestructuras", "RA7");
        linea(33, "Comparable", "ut6_pooavanzadaestructuras", "RA7");
        System.out.println();
        imprimirBloque("EV3 · ut9_programacionfuncional/pf — RA7 Programacion funcional");
        linea(34, "lambda + filter", "ut9_programacionfuncional/pf", "RA7");
        linea(35, "streams map/reduce", "ut9_programacionfuncional/pf", "RA7");
        linea(36, "Optional", "ut9_programacionfuncional/pf", "RA7");
        System.out.println();
        imprimirBloque("EV3 · ut7_persistenciajdbcapi — RA8/RA9 Persistencia");
        linea(37, "model + DAO en memoria", "ut7_persistenciajdbcapi", "RA8");
        linea(38, "transferencia con integridad", "ut7_persistenciajdbcapi", "RA9");
        System.out.println();
        System.out.println("Ruta: src/diagnostico/ejercicios/pendientes/");
        System.out.println("Entrada: Scanner teclado en cada ejercicio.");
    }

    private static void imprimirBloque(String titulo) {
        System.out.println("-- " + titulo + " --");
    }

    private static void linea(int numero, String tema, String ut, String ra) {
        System.out.printf("%02d  %-38s %s  %s%n", numero, tema, ut, ra);
    }
}
