package general.poo_basico.resueltos;

/**
 * Ejercicio 5: Cuenta bancaria simple (RESUELTO)
 * 
 * Demuestra:
 *  - Encapsulación de estado (saldo)
 *  - Funciones con validaciones sencillas
 *  - Uso de this y constructores
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio5_CuentaSimple {

    static class CuentaSimple {
        private String titular;
        private double saldo;

        public CuentaSimple(String titular, double saldoInicial) {
            this.titular = titular;
            this.saldo = saldoInicial;
        }

        public void ingresar(double cantidad) {
            if (cantidad <= 0) {
                System.out.println("La cantidad a ingresar debe ser positiva.");
                return;
            }
            saldo += cantidad;
            System.out.println("Ingreso de " + cantidad + " €. Nuevo saldo: " + saldo + " €.");
        }

        public void retirar(double cantidad) {
            if (cantidad <= 0) {
                System.out.println("La cantidad a retirar debe ser positiva.");
                return;
            }
            if (cantidad > saldo) {
                System.out.println("Saldo insuficiente para retirar " + cantidad + " €.");
                return;
            }
            saldo -= cantidad;
            System.out.println("Retirada de " + cantidad + " €. Nuevo saldo: " + saldo + " €.");
        }

        public void mostrarDatos() {
            System.out.println("Titular: " + titular);
            System.out.println("Saldo: " + saldo + " €");
        }
    }

    public static void main(String[] args) {
        CuentaSimple cuenta = new CuentaSimple("Carlos", 100);

        cuenta.mostrarDatos();
        cuenta.ingresar(50);
        cuenta.mostrarDatos();
        cuenta.retirar(30);
        cuenta.mostrarDatos();
        cuenta.retirar(200); // ejemplo de saldo insuficiente
    }
}

