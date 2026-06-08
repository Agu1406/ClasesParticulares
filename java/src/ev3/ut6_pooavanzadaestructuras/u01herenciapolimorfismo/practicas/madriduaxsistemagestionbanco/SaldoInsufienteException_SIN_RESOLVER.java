package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madriduaxsistemagestionbanco;

/**
 * Esta excepion (error) ocurre cuando el usuario intenta
 * retirar de su cuenta bancaria mas saldo del que tiene
 * actualmente disponible.
 */
public class SaldoInsufienteException_SIN_RESOLVER extends java.lang.Exception {
    // Envia al usuario un mensaje de error (String)
    public SaldoInsufienteException_SIN_RESOLVER(String message) {
        super(message);
    }
}
