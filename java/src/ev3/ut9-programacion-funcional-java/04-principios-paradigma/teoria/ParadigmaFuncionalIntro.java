package ev3.ut9.pf.principios;

/**
 * Teoria: que es la programacion funcional (PDF diapos 3-6).
 *
 * <p><b>Que es el paradigma funcional?</b> Un enfoque donde el programa se entiende
 * como evaluacion de funciones y transformacion de datos inmutables, minimizando
 * estado mutable y efectos secundarios ocultos.</p>
 *
 * <p><b>Por que aparece en Java si Java es orientado a objetos?</b> Porque muchos
 * problemas reales son "tomar datos, filtrarlos, transformarlos y agregarlos". Eso
 * se escribe mas claro con lambdas y streams que con cinco bucles anidados.</p>
 *
 * <p><b>Principios que veras en demos concretas:</b></p>
 * <ul>
 *   <li><b>Funciones puras</b> - misma entrada, misma salida; sin sorpresas globales.</li>
 *   <li><b>Inmutabilidad</b> - preferir datos que no cambian (List.of, final).</li>
 *   <li><b>Transparencia referencial</b> - puedo sustituir una expresion por su valor.</li>
 *   <li><b>Funciones de primera clase</b> - las paso como argumentos (lambda).</li>
 *   <li><b>Funciones de orden superior</b> - reciben o devuelven otras funciones.</li>
 * </ul>
 *
 * <p><b>No es todo o nada:</b> en proyectos Java reales mezclas estilos. Usa PF donde
 * simplifica; no forces stream en un bucle que ya es obvio.</p>
 *
 * <p><b>Indice de demos de este bloque:</b> ejecuta main para ver rutas a cada Intro.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public final class ParadigmaFuncionalIntro {

    private ParadigmaFuncionalIntro() {
    }

    public static void main(String[] args) {
        System.out.println("=== Principios del paradigma funcional ===");
        System.out.println("Funciones puras e inmutabilidad -> FuncionesPurasyInmutabilidadIntro.java");
        System.out.println("Transparencia referencial        -> TransparenciaReferencialIntro.java");
        System.out.println("Funciones de orden superior      -> FuncionesOrdenSuperiorIntro.java");
        System.out.println("Monadas (Optional, Future)       -> MonadasIntro.java");
        System.out.println("Currying                         -> CurrificacionIntro.java");
        System.out.println("Recursion declarativa            -> RecursionFuncionalIntro.java");
        System.out.println();
        System.out.println("Lee el JavaDoc de cada archivo antes de ejecutar la demo.");
    }
}
