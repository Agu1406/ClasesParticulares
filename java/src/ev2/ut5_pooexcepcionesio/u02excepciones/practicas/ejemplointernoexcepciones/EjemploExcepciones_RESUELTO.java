package ev2.ut5_pooexcepcionesio.u02excepciones.practicas.ejemplointernoexcepciones;

import java.util.Scanner;

/**
 * <p><b>OBJETIVO:</b> Practica interna — menu consola con (1) division con reglas
 * ({@code throw} + {@code parseInt}) y (2) retiro de {@code Cuenta} con validacion.
 * Captura {@code NumberFormatException} e {@code IllegalArgumentException}; usa
 * {@code finally}. Enunciado: {@code interno-ejemplo-excepciones-enunciado.md}.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code dividirConReglas} y {@code Cuenta.retirar} lanzan
 * {@code IllegalArgumentException}. El menu lee lineas y convierte con
 * {@code Integer.parseInt} / {@code Double.parseDouble}; cada operacion cierra
 * con {@code finally}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 06/09/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class EjemploExcepciones_RESUELTO {

    static class Cuenta {
        private final String titular;
        private double saldo;

        Cuenta(String titular, double saldoInicial) {
            this.titular = titular;
            this.saldo = saldoInicial;
        }

        public String getTitular() {
            return titular;
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

    public static double dividirConReglas(int dividendo, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("El divisor no puede ser cero.");
        }
        if (dividendo <= 0) {
            throw new IllegalArgumentException("El dividendo debe ser positivo.");
        }
        if (dividendo <= 100) {
            throw new IllegalArgumentException("El dividendo debe ser mayor que 100.");
        }
        return (double) dividendo / divisor;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Cuenta cuenta = new Cuenta("Daniel", 100.0);
        int opcion;

        do {
            System.out.print(
                    "\n[1] Dividir con reglas\n"
                            + "[2] Retirar de cuenta\n"
                            + "[0] Salir\n"
                            + "Opcion -> ");
            try {
                opcion = Integer.parseInt(teclado.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opcion no numerica.");
                opcion = -1;
                continue;
            }

            switch (opcion) {
                case 1:
                    operarDivision(teclado);
                    break;
                case 2:
                    operarRetiro(teclado, cuenta);
                    break;
                case 0:
                    System.out.println("Fin.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);

        teclado.close();
    }

    private static void operarDivision(Scanner teclado) {
        try {
            System.out.print("Dividendo (>100) -> ");
            int a = Integer.parseInt(teclado.nextLine().trim());
            System.out.print("Divisor -> ");
            int b = Integer.parseInt(teclado.nextLine().trim());
            System.out.println("Resultado: " + dividirConReglas(a, b));
        } catch (NumberFormatException e) {
            System.out.println("Error: escribe enteros validos.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validacion: " + e.getMessage());
        } finally {
            System.out.println("finally: operacion division cerrada.");
        }
    }

    private static void operarRetiro(Scanner teclado, Cuenta cuenta) {
        System.out.println("Cuenta de " + cuenta.getTitular() + " — saldo: " + cuenta.getSaldo());
        try {
            System.out.print("Importe a retirar -> ");
            double importe = Double.parseDouble(teclado.nextLine().trim().replace(',', '.'));
            cuenta.retirar(importe);
            System.out.println("OK. Saldo: " + cuenta.getSaldo());
        } catch (NumberFormatException e) {
            System.out.println("Error: importe no numerico.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("finally: operacion retiro cerrada.");
        }
    }
}
