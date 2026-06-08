package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madriduaxsistemagestionbanco;

/**
 * Esta excepion (error) ocurre cuando el usuario intenta
 * retirar de su cuenta bancaria mas saldo del que tiene
 * actualmente disponible.
  *
 * * PLANTILLA DOCENTE: completar solucion docente.
 */
public class SaldoInsufienteException_RESUELTO extends java.lang.Exception {
    // Envia al usuario un mensaje de error (String)
    public SaldoInsufienteException_RESUELTO(String message) {
        super(message);
    }
}
