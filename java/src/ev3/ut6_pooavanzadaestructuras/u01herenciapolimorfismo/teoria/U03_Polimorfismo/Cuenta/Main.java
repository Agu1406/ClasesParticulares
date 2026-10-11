package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U03_Polimorfismo.Cuenta;

/**
 * Teoria: polimorfismo con cuentas bancarias.
 *
 * <p>Misma llamada {@code retirar(100)} sobre un array de {@link Cuenta}: ahorro
 * aplica limite diario; credito permite descubierto. Eso es enlace dinamico.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 11/10/2026
 * @see Cuenta
 * @see CuentaAhorro
 * @see CuentaCredito
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== POLIMORFISMO: array de Cuenta ===\n");

        Cuenta[] cuentas = new Cuenta[3];
        cuentas[0] = new CuentaAhorro("Ana", 500, 200);
        cuentas[1] = new CuentaCredito("Luis", 100, 300);
        cuentas[2] = new CuentaAhorro("Maria", 1000, 500);

        System.out.println("--- Retirar 150 en todas (enlace dinamico) ---");
        for (Cuenta c : cuentas) {
            System.out.println(c.tipoCuenta() + " de " + c.getTitular() + ":");
            c.retirar(150);
            System.out.println();
        }

        System.out.println("--- toString ---");
        for (Cuenta c : cuentas) {
            System.out.println(c);
        }

        System.out.println("\n=== instanceof + downcast ===");
        for (Cuenta c : cuentas) {
            if (c instanceof CuentaAhorro) {
                CuentaAhorro a = (CuentaAhorro) c;
                System.out.println(a.getTitular() + " limite diario=" + a.getLimiteRetiroDiario());
            } else if (c instanceof CuentaCredito) {
                CuentaCredito cr = (CuentaCredito) c;
                System.out.println(cr.getTitular() + " limite credito=" + cr.getLimiteCredito());
            }
        }
    }
}
