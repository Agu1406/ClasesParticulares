package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U04_Interfaces;

/**
 * Implementacion de {@link Volable}: avion (misma interfaz, otro comportamiento).
 *
 * @author Agustin. A. Marquez. Pina
 * @since 18/09/2026
 * @see Volable
 * @see U04_InterfacesIntro
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Avion implements Volable {

    private String modelo;

    public Avion(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public void despegar() {
        System.out.println("Avion " + modelo + ": motores a maxima potencia. Despegue.");
    }

    @Override
    public void aterrizar() {
        System.out.println("Avion " + modelo + ": tren de aterrizaje abajo. Aterrizaje.");
    }

    @Override
    public int getAlturaMaxima() {
        return 12000;
    }

    public String getModelo() {
        return modelo;
    }
}
