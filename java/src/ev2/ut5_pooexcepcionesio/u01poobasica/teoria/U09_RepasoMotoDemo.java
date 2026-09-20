package ev2.ut5_pooexcepcionesio.u01poobasica.teoria;

/**
 * Driver del repaso {@link U09_RepasoMoto}.
 *
 * <p><b>Objetivo:</b> crear dos motos, imprimir {@code toString} y llamar a
 * {@link U09_RepasoMoto#hacerRuido()}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 05/09/2026
 * @see U09_RepasoMoto
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U09_RepasoMotoDemo {

    public static void main(String[] args) {
        U09_RepasoMoto moto001 = new U09_RepasoMoto("ABC123", "Kawazaki", "Daniel", 180);
        U09_RepasoMoto moto002 = new U09_RepasoMoto("DF5432", "Yamaha", "Agustin", 120);

        System.out.println(moto001);
        System.out.println(moto002);

        moto001.hacerRuido();
        moto002.hacerRuido();
    }
}
