package ev2.ut5_pooexcepcionesio.u01poobasica.ejercicios.pendientes;

/**
 * Ejercicio POO Basico - Encapsulamiento
 * Usa atributos privados y metodos get/set con validacion.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 05/05/2026
 */
public class Ejercicio1_EncapsulamientoCuenta_SIN_RESOLVER {
    public static void main(String[] args) {
        // TODO 1: crear una Cuenta.
        // TODO 2: llamar setSaldo con un valor valido y otro invalido.
        // TODO 3: mostrar el saldo final con getSaldo().
    }
}

class Cuenta {
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        // TODO: solo aceptar valores >= 0.
    }
}
