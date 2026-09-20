package ev2.ut5_pooexcepcionesio.u02excepciones.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Modela una {@code Cuenta} con saldo encapsulado y metodo
 * {@code retirar(double)} que lanza {@code IllegalArgumentException} si el importe
 * no es positivo o supera el saldo. En el {@code main}, intenta varios retiros con
 * {@code try/catch/finally}. Enlace: teoria {@code U05_ExcepcionesYPooDemo}.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> La regla de negocio vive en el metodo de la clase (POO +
 * {@code throw}). El {@code main} solo orquesta y muestra el error; {@code finally}
 * confirma el cierre de cada operacion.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 06/09/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E14_CuentaRetirar_Resuelto {

    static class Cuenta {
        private double saldo;

        Cuenta(double saldoInicial) {
            this.saldo = saldoInicial;
        }

        public double getSaldo() {
            return saldo;
        }

        public void retirar(double importe) {
            if (importe <= 0) {
                throw new IllegalArgumentException("El importe debe ser positivo.");
            }
            if (importe > saldo) {
                throw new IllegalArgumentException("Saldo insuficiente.");
            }
            saldo -= importe;
        }
    }

    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(100);
        intentar(cuenta, 40);
        intentar(cuenta, -1);
        intentar(cuenta, 200);
        System.out.println("Saldo final: " + cuenta.getSaldo());
    }

    private static void intentar(Cuenta cuenta, double importe) {
        System.out.println("\nRetirar " + importe);
        try {
            cuenta.retirar(importe);
            System.out.println("OK. Saldo: " + cuenta.getSaldo());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("finally: operacion cerrada.");
        }
    }
}
