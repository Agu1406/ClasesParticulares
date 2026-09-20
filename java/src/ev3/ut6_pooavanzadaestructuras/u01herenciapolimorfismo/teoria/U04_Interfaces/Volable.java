package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U04_Interfaces;

/**
 * Interfaz: contrato de "puede volar" (solo metodos, sin estado).
 *
 * <p>A diferencia de una clase abstracta, una clase puede implementar
 * <em>varias</em> interfaces. Los metodos son public abstract por defecto.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 18/09/2026
 * @see Pajaro
 * @see Avion
 * @see U04_InterfacesIntro
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public interface Volable {

    void despegar();

    void aterrizar();

    /** Altura maxima en metros (contrato informativo). */
    int getAlturaMaxima();
}
