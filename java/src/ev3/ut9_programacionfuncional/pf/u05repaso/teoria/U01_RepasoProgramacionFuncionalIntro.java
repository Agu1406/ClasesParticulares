package ev3.ut9_programacionfuncional.pf.u05repaso.teoria;

/**
 * Repaso UT9 antes de los ejercicios finales.
 *
 * <p><b>Para que sirve este archivo?</b> Checklist de conceptos antes de
 * {@code 05-repaso/ejercicios/}. Los PDF de toda la UT9 (diapos EV3 y hojas TPP) estan en
 * {@code 05-repaso/teoria/} ({@code 01_functional_prog.pdf}, {@code universidad/}).
 * El indice general de la UT esta en {@code 01-lambda-y-sam/teoria/ProgramacionFuncionalIntro.java}.</p>
 *
 * <p><b>Que repasar en cada demo:</b></p>
 * <ol>
 *   <li><b>Lambda</b> - que es, sintaxis, por que sustituye clase anonima.</li>
 *   <li><b>Streams</b> - pipeline, intermedias vs terminales, pereza, collect.</li>
 *   <li><b>Optional</b> - evitar null, orElse, map.</li>
 *   <li><b>Pureza</b> - collect vs forEach+add, List.of inmutable.</li>
 * </ol>
 *
 * <p><b>Extra recomendado:</b> reduce, composicion (andThen, Predicate.and),
 * parallelStream si viste UT6.</p>
 *
 * <p><b>Guion:</b> lee el JavaDoc de cada Intro, ejecuta la demo y solo entonces marca
 * el checkbox mental antes de pasar a ejercicios.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class U01_RepasoProgramacionFuncionalIntro {

    private U01_RepasoProgramacionFuncionalIntro() {
    }

    public static void main(String[] args) {
        System.out.println("=== Repaso UT9 Programacion funcional ===");
        System.out.println("[ ] LambdaIntro.java              - que es lambda y por que");
        System.out.println("[ ] StreamsFundamentosIntro.java  - stream vs bucles");
        System.out.println("[ ] OptionalIntro.java              - Optional vs null");
        System.out.println("[ ] FuncionesPurasyInmutabilidadIntro - pureza y collect");
        System.out.println();
        System.out.println("Extra: StreamsReduceIntro, ComposicionFuncionalIntro, StreamsParalelosIntro");
        System.out.println();
        System.out.println("Cuando marques todo, pasa a 05-repaso/ejercicios/");
    }
}
