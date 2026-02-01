package general.poo_abstraccion.resueltos;

/**
 * Ejercicio 1: Abstracción con cuentas bancarias (RESUELTO)
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio1_AbstraccionCuenta {

    static abstract class CuentaBancaria {
        protected String titular;
        protected double saldo;

        public CuentaBancaria(String titular, double saldoInicial) {
            this.titular = titular;
            this.saldo = saldoInicial;
        }

        public void depositar(double cantidad) {
            if (cantidad <= 0) {
                System.out.println("La cantidad a depositar debe ser positiva.");
                return;
            }
            saldo += cantidad;
            System.out.println("Depósito de " + cantidad + " realizado. Saldo actual: " + saldo);
        }

        public abstract void retirar(double cantidad);

        public void mostrarDatos() {
            System.out.println("Titular: " + titular);
            System.out.println("Saldo: " + saldo);
        }
    }

    static class CuentaAhorro extends CuentaBancaria {

        private double limiteRetiroDiario;

        public CuentaAhorro(String titular, double saldoInicial, double limiteRetiroDiario) {
            super(titular, saldoInicial);
            this.limiteRetiroDiario = limiteRetiroDiario;
        }

        @Override
        public void retirar(double cantidad) {
            if (cantidad <= 0) {
                System.out.println("La cantidad a retirar debe ser positiva.");
                return;
            }
            if (cantidad > limiteRetiroDiario) {
                System.out.println("La cantidad supera el límite diario de retiro: " + limiteRetiroDiario);
                return;
            }
            if (cantidad > saldo) {
                System.out.println("Saldo insuficiente.");
                return;
            }
            saldo -= cantidad;
            System.out.println("Retiro de " + cantidad + " realizado. Saldo actual: " + saldo);
        }
    }

    public static void main(String[] args) {
        CuentaAhorro cuenta = new CuentaAhorro("Lucía", 1000, 300);

        cuenta.mostrarDatos();
        cuenta.depositar(200);
        cuenta.retirar(150);
        cuenta.retirar(400); // supera límite diario
        cuenta.mostrarDatos();
    }
}

