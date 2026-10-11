package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U04_Interfaces;

/**
 * Implementacion de {@link Volable}: pajaro.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 18/09/2026
 * @see Volable
 * @see U04_InterfacesIntro
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Pajaro implements Volable {

    private String especie;

    public Pajaro(String especie) {
        this.especie = especie;
    }

    @Override
    public void despegar() {
        System.out.println(especie + " bate las alas y despega.");
    }

    @Override
    public void aterrizar() {
        System.out.println(especie + " aterriza en una rama.");
    }

    @Override
    public int getAlturaMaxima() {
        return 500;
    }

    public String getEspecie() {
        return especie;
    }
}
