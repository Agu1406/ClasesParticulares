package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U01_Abstraccion;

/**
 * Teoria: abstraccion con {@code abstract class} y metodos abstractos.
 *
 * <h2>Idea clave</h2>
 * <p>En el banco <em>existen</em> cuentas de ahorro y de credito, pero no una
 * "cuenta generica" que puedas abrir tal cual. En codigo eso se modela asi:</p>
 * <ul>
 *   <li>{@link Cuenta} — abstracta: datos y operaciones <b>comunes</b>
 *       (titular, cotitular, saldo, depositar, toString) + metodos
 *       <b>sin implementar</b> ({@code retirar}, {@code tipoCuenta}).</li>
 *   <li>{@link CuentaAhorro} — concreta: retiro con limite diario, sin numeros rojos.</li>
 *   <li>{@link CuentaCredito} — concreta: retiro con descubierto hasta un limite.</li>
 * </ul>
 *
 * <h2>Reglas que debes recordar</h2>
 * <ol>
 *   <li>{@code new Cuenta(...)} <b>no compila</b>: no se instancia la abstracta.</li>
 *   <li>Si una clase declara un metodo {@code abstract}, la clase debe ser {@code abstract}.</li>
 *   <li>La primera subclase <b>concreta</b> esta obligada a implementar todos los
 *       metodos abstractos heredados (o seguir siendo abstracta).</li>
 *   <li>Puedes usar una referencia del tipo abstracto apuntando a un objeto concreto
 *       ({@code Cuenta c = new CuentaAhorro(...)}): al llamar {@code c.retirar(...)}
 *       se ejecuta la version de la clase real (polimorfismo + abstraccion).</li>
 * </ol>
 *
 * <p>Orden del subtema: {@code U02_Herencia} → {@code U03_Polimorfismo} →
 * {@code U01_Abstraccion} → {@code U04_Interfaces}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 18/09/2026
 * @see Cuenta
 * @see CuentaAhorro
 * @see CuentaCredito
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U01_AbstraccionIntro {

    public static void main(String[] args) {
        System.out.println("=== 1) Por que abstract? ===");
        System.out.println("Cuenta = molde comun. Ahorro y Credito = productos reales.");
        System.out.println("No tiene sentido: new Cuenta(\"Ana\", 100);  // NO COMPILA\n");

        System.out.println("=== 2) CuentaAhorro (limite diario, sin descubierto) ===");
        CuentaAhorro ahorro = new CuentaAhorro("Lucia", "Pedro", 1000, 300);
        System.out.println(ahorro);
        ahorro.depositar(200);
        ahorro.retirar(150);  // OK
        ahorro.retirar(400);  // supera limite diario
        ahorro.retirar(2000); // saldo insuficiente

        System.out.println("\n=== 3) CuentaCredito (permite numeros rojos hasta el limite) ===");
        CuentaCredito credito = new CuentaCredito("Daniel", 100, 500);
        System.out.println(credito);
        credito.retirar(200);  // saldo -100, dentro del credito
        credito.retirar(500);  // intentaria -600; limite 500 -> rechazado
        System.out.println(credito);

        System.out.println("=== 4) Misma referencia abstracta, distinto retirar() ===");
        Cuenta[] cuentas = {
                new CuentaAhorro("Ana", 800, 200),
                new CuentaCredito("Luis", 50, 300)
        };
        for (Cuenta c : cuentas) {
            System.out.println("--- " + c.tipoCuenta() + " ---");
            c.retirar(100);
            System.out.println("Saldo tras retiro: " + c.getSaldo());
        }
    }
}
