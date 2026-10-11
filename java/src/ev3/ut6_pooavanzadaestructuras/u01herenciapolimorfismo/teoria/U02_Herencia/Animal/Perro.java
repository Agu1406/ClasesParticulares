package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U02_Herencia;

/**
 * Subclase de {@link Animal}: hereda nombre y sobrescribe {@code hacerSonido()}.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 18/09/2026
 * @see Animal
 * @see U02_HerenciaIntro
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Perro extends Animal {

    private String raza;

    public Perro(String nombre) {
        this(nombre, "mestizo");
    }

    public Perro(String nombre, String raza) {
        super(nombre); // llama al constructor de Animal
        this.raza = raza;
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Guau!");
    }

    public String getRaza() {
        return raza;
    }

    @Override
    public String toString() {
        return "Perro{nombre='" + nombre + "', raza='" + raza + "'}";
    }
}
