package general.poobasico;

/**
 * Teoría: encapsulamiento en Java.
 *
 * <p><b>Objetivo:</b> ocultar atributos con {@code private} y acceder mediante
 * métodos {@code get} / {@code set}, validando datos cuando haga falta.</p>
 *
 * <ul>
 *   <li>{@code private} — solo visible dentro de la clase.</li>
 *   <li>{@code public} getters/setters — interfaz controlada hacia fuera.</li>
 * </ul>
 *
 * <p>Practica en {@code ejercicios/encapsulamiento/pendientes} y {@code resueltos}.</p>
 *
 * @author Agustín. A. Marquez. Piña
 * @since 02/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class EncapsulamientoIntro {

    static class Cuenta {
        private double saldo;

        public double getSaldo() {
            return saldo;
        }

        public void setSaldo(double saldo) {
            if (saldo >= 0) {
                this.saldo = saldo;
            }
        }
    }

    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta();
        cuenta.setSaldo(100);
        cuenta.setSaldo(-50);
        System.out.println("Saldo: " + cuenta.getSaldo());
    }
}
