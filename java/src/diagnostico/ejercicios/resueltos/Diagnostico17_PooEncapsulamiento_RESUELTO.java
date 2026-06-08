package diagnostico.ejercicios.resueltos;

import java.util.Scanner;

/**
 * Encapsulamiento en cuenta bancaria
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa con una clase Cuenta bancaria encapsulada.</li>
 * <li>Atributos privados: titular y saldo. Metodos: depositar, retirar y getters.</li>
 * <li>En el main, lee titular, saldo inicial, deposito y retiro con Scanner teclado.</li>
 * <li>Crea la cuenta, realiza las operaciones e imprime titular y saldo final.</li>
 * </ul>
 *
 * <p>Diagnostico 17 — EV2 · ut5_pooexcepcionesio · RA4.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico17_PooEncapsulamiento_RESUELTO {

    static class Cuenta {
        private final String titular;
        private double saldo;

        public Cuenta(String titular, double saldoInicial) {
            this.titular = titular;
            this.saldo = saldoInicial;
        }

        public void depositar(double cantidad) {
            saldo += cantidad;
        }

        public void retirar(double cantidad) {
            saldo -= cantidad;
        }

        public double getSaldo() {
            return saldo;
        }

        public String getTitular() {
            return titular;
        }
    }
    public static void main(String[] args) {
        Scanner teclado;
        String titular;
        double saldoInicial;
        double deposito;
        double retiro;
        Cuenta cuenta;
        teclado = new Scanner(System.in);
        teclado.nextLine();
        System.out.print("Titular: ");
        titular = teclado.nextLine();
        System.out.print("Saldo inicial: ");
        saldoInicial = teclado.nextDouble();
        System.out.print("Cantidad a depositar: ");
        deposito = teclado.nextDouble();
        System.out.print("Cantidad a retirar: ");
        retiro = teclado.nextDouble();
        cuenta = new Cuenta(titular, saldoInicial);
        cuenta.depositar(deposito);
        cuenta.retirar(retiro);
        System.out.println(cuenta.getTitular() + ": " + cuenta.getSaldo());
        teclado.close();
    }
}
