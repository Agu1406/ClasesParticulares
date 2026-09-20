package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U02_Herencia;

/**
 * Teoria: herencia ({@code extends}), {@code super}, {@code @Override} y {@code protected}.
 *
 * <p><b>Objetivo:</b> reutilizar codigo de una superclase ({@link Animal}) en subclases
 * ({@link Perro}, {@link Gato}). La subclase puede añadir atributos y sobrescribir metodos.</p>
 *
 * <ul>
 *   <li>{@code extends} — "es un" (Perro es un Animal)</li>
 *   <li>{@code super(...)} — constructor / metodos de la superclase</li>
 *   <li>{@code @Override} — sustituye el comportamiento heredado</li>
 *   <li>{@code protected} — visible en la jerarquia (y en el mismo package)</li>
 * </ul>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 18/09/2026
 * @see Animal
 * @see Perro
 * @see Gato
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U02_HerenciaIntro {

    public static void main(String[] args) {
        System.out.println("=== HERENCIA: Animal / Perro / Gato ===\n");

        Animal generico = new Animal("Criatura");
        Perro perro = new Perro("Rex", "Pastor aleman");
        Gato gato = new Gato("Michi");

        generico.hacerSonido();
        perro.hacerSonido();
        gato.hacerSonido();

        System.out.println();
        System.out.println(perro);
        System.out.println("Raza: " + perro.getRaza());
        System.out.println(gato);

        /*
         * Upcasting: referencia Animal, objeto Perro.
         * Al llamar hacerSonido() se ejecuta la version de Perro (enlace dinamico).
         */
        System.out.println("\nUpcasting (Animal ref = new Perro(...)):");
        Animal ref = new Perro("Luna");
        ref.hacerSonido();
        System.out.println(ref.getNombre());
    }
}
