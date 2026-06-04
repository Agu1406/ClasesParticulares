package ev3.ut9.pf;

/**
 * Indice UT9: programacion funcional en Java (EV3).
 *
 * <p><b>Que es la programacion funcional?</b> Un estilo de programacion donde el calculo
 * se expresa como composicion de funciones y transformaciones sobre datos, en lugar de
 * ir modificando variables paso a paso con bucles e instrucciones imperativas. No es
 * "sin clases ni objetos": en Java convive con el paradigma orientado a objetos.</p>
 *
 * <p><b>Por que la vemos en este modulo?</b> Desde Java 8 el lenguaje incorporo lambda,
 * interfaces funcionales, Optional y Stream API para escribir codigo mas expresivo en
 * tareas repetitivas: filtrar listas, transformar datos, sumar, buscar, ordenar. El
 * BOE (RA6 j) pide dominar operaciones agregadas sobre colecciones; los streams encajan
 * directamente con ese objetivo.</p>
 *
 * <p><b>Por que no sustituye todo lo que ya sabes?</b> Java sigue siendo hibrido. Los
 * bucles for, ArrayList mutables e if/else siguen siendo validos y a veces mas claros.
 * La PF aporta valor cuando reduces ruido mecanico (indices, listas temporales, muchas
 * lineas para una idea simple) y cuando quieres codigo mas facil de razonar y testear.</p>
 *
 * <p><b>Que vas a aprender en UT9, en orden:</b></p>
 * <ol>
 *   <li>{@code 01-lambda-y-sam/} - expresiones lambda e interfaces funcionales (PDF 6-12)</li>
 *   <li>{@code 02-streams-api/} - pipelines sobre colecciones (PDF 16-26)</li>
 *   <li>{@code 03-optional-y-composicion/} - Optional y encadenar funciones (PDF 13-15)</li>
 *   <li>{@code 04-principios-paradigma/} - pureza, inmutabilidad, HOF, etc. (PDF 27-37)</li>
 *   <li>{@code 05-repaso/} - ejercicios que mezclan todo lo anterior</li>
 * </ol>
 *
 * <p><b>Prerrequisitos:</b> EV2 {@code ut4-colecciones} (List, bucles). Opcional: UT6
 * concurrencia para {@code parallelStream}.</p>
 *
 * <p><b>Material:</b> {@code material/01_functional_prog.pdf} (Mateo Cerdan).</p>
 *
 * <p><b>Guion de clase:</b> ejecuta este main al abrir la UT9. Recorre el indice en voz
 * alta y di a la alumna que cada carpeta {@code teoria/} explica primero el concepto
 * (JavaDoc) y despues lo demuestra con codigo ejecutable.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public final class ProgramacionFuncionalIntro {

    private ProgramacionFuncionalIntro() {
    }

    public static void main(String[] args) {
        System.out.println("=== UT9 Programacion funcional en Java ===");
        System.out.println("PDF: material/01_functional_prog.pdf");
        System.out.println();
        System.out.println("1. Lambda y SAM   -> 01-lambda-y-sam/teoria/");
        System.out.println("2. Streams API    -> 02-streams-api/teoria/");
        System.out.println("3. Optional       -> 03-optional-y-composicion/teoria/");
        System.out.println("4. Principios PF  -> 04-principios-paradigma/teoria/");
        System.out.println("5. Repaso         -> 05-repaso/ejercicios/");
        System.out.println();
        System.out.println("Lee el JavaDoc de cada *Intro.java antes de ejecutar la demo.");
    }
}
