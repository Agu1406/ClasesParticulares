package ev3.ut9.pf.u01lambda.teoria;

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
 * <p><b>Practicas TPP EPIG (esqueletos alumno en {@code practicas/valenciana-epig-tpp-sesionN/}):</b></p>
 * <ul>
 *   <li>Sesion 1 - {@code 01-lambda-y-sam/practicas/valenciana-epig-tpp-sesion1/}</li>
 *   <li>Sesion 2 y 4 - {@code 02-streams-api/practicas/valenciana-epig-tpp-sesion2|4/}</li>
 *   <li>Sesion 3 - {@code 03-optional-y-composicion/practicas/valenciana-epig-tpp-sesion3/}</li>
 *   <li>Sesion 5 - {@code 05-repaso/practicas/valenciana-epig-tpp-sesion5/}</li>
 * </ul>
 *
 * <p><b>Prerrequisitos:</b> EV2 {@code ut4-colecciones} (List, bucles). Opcional: UT6
 * concurrencia para {@code parallelStream}.</p>
 *
 * <p><b>Documentos de toda la UT9</b> (PDF, chuletas): {@code 05-repaso/teoria/} — diapos
 * {@code 01_functional_prog.pdf} y carpeta {@code universidad/} (TPP EPIG).</p>
 *
 * <p><b>Ejercicios sueltos universidad:</b> numerados 11+ con prefijo {@code Uni*} en
 * {@code ejercicios/}; los proyectos integradores TPP estan en {@code practicas/} por sesion.</p>
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
public class U01_ProgramacionFuncionalIntro {

    private U01_ProgramacionFuncionalIntro() {
    }

    public static void main(String[] args) {
        System.out.println("=== UT9 Programacion funcional en Java ===");
        System.out.println("PDF UT9 (repaso): src/ev3/ut9/pf/repaso/teoria/01_functional_prog.pdf");
        System.out.println("PDF universidad: src/ev3/ut9/pf/repaso/teoria/universidad/");
        System.out.println();
        System.out.println("1. Lambda   -> ev3/ut9/pf/lambda/teoria/");
        System.out.println("2. Streams  -> ev3/ut9/pf/streams/teoria/");
        System.out.println("3. Optional -> ev3/ut9/pf/optional/teoria/");
        System.out.println("4. Principios -> ev3/ut9/pf/principios/teoria/");
        System.out.println("5. Repaso   -> ev3/ut9/pf/repaso/ejercicios/");
        System.out.println();
        System.out.println("Practicas TPP (paquete = ruta bajo src/):");
        System.out.println("  Sesion1 -> pf/lambda/practicas/valencianaepigtppsesion1/");
        System.out.println("  Sesion2+4 -> pf/streams/practicas/valencianaepigtppsesion2|4/");
        System.out.println("  Sesion3 -> pf/optional/practicas/valencianaepigtppsesion3/");
        System.out.println("  Sesion5 -> pf/repaso/practicas/valencianaepigtppsesion5/");
        System.out.println();
        System.out.println("Lee el JavaDoc de cada *Intro.java antes de ejecutar la demo.");
    }
}
