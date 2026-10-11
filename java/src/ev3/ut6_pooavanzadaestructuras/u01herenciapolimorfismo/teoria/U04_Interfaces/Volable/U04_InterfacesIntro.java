package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U04_Interfaces;

/**
 * Teoria: interfaces ({@code implements}) frente a clases abstractas.
 *
 * <p><b>Objetivo:</b> definir un contrato ({@link Volable}) que clases no emparentadas
 * por herencia ({@link Pajaro}, {@link Avion}) pueden cumplir. Polimorfismo con
 * tipo interfaz: {@code Volable v = new Pajaro(...)}.</p>
 *
 * <table summary="comparacion">
 *   <tr><th></th><th>Clase abstracta</th><th>Interfaz</th></tr>
 *   <tr><td>Estado (atributos)</td><td>Si</td><td>Constantes (tipico)</td></tr>
 *   <tr><td>Herencia multiple</td><td>No (una sola superclase)</td><td>Si (varias interfaces)</td></tr>
 *   <tr><td>Constructores</td><td>Si</td><td>No</td></tr>
 * </table>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 18/09/2026
 * @see Volable
 * @see Pajaro
 * @see Avion
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U04_InterfacesIntro {

    public static void main(String[] args) {
        System.out.println("=== INTERFACES: Volable ===\n");

        Volable[] flota = {
                new Pajaro("aguila"),
                new Avion("A320"),
                new Pajaro("gorrion")
        };

        for (Volable v : flota) {
            v.despegar();
            System.out.println("  Altura max: " + v.getAlturaMaxima() + " m");
            v.aterrizar();
            System.out.println();
        }
    }
}
