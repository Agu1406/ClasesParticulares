package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.ejercicios.resueltos;

/**
 * Subclase Gato que hereda de Animal.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Gato extends Animal {

    public Gato(String nombre) {
        super(nombre, "Desconocido", "Desconocido");
    }

    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " dice: Miau!");
    }
}