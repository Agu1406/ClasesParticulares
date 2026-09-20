package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U02_Herencia;

/**
 * Superclase de la jerarquia de animales.
 *
 * <p><b>Objetivo:</b> atributos {@code protected} (visibles en subclases), constructor
 * y metodo {@code hacerSonido()} pensado para sobrescribirse.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 18/09/2026
 * @see Perro
 * @see Gato
 * @see U02_HerenciaIntro
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Animal {

    protected String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void hacerSonido() {
        System.out.println(nombre + " hace un sonido generico...");
    }

    @Override
    public String toString() {
        return "Animal{nombre='" + nombre + "'}";
    }
}
