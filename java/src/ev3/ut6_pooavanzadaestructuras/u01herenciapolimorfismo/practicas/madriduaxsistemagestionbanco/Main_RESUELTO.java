package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madriduaxsistemagestionbanco;

/**
 * Sistema de gestion bancaria (UAX).
 *
 * <p><b>Objetivo:</b> modelar cuentas bancarias con ingresos, retiros y control de saldo insuficiente.</p>
 *
 * <p>Para ello, el programa debe:</p>
 * <ul>
 *   <li>Crear cuentas con distintos saldos iniciales y operar sobre ellas.</li>
 *   <li>Lanzar {@link SaldoInsufienteException_RESUELTO} cuando no haya fondos.</li>
 *   <li>Validar importes no validos segun el enunciado.</li>
 * </ul>
 *
 * <p>Utiliza POO, excepciones personalizadas y aserciones.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
  *
 * * PLANTILLA DOCENTE: completar solucion docente.
 */
public class Main_RESUELTO {
    public static void main(String[] args) throws SaldoInsufienteException_RESUELTO {
        // Creamos las dos cuentas de banco, una con saldo "0", otra con saldo "-1".
        CuentaBancaria_RESUELTO cuentaBancariaSaldo0 = new CuentaBancaria_RESUELTO("ES0100000000000000000001");
        CuentaBancaria_RESUELTO cuentaBancariaSaldoN = new CuentaBancaria_RESUELTO("ES0100000000000000000002", -1);

        // PRIMERA PARTE - EJERCICIOS CON LA CUENTA CON SALDO "0" //

        // En la primera cuenta depositamos 1000? y retiramos 500?
        cuentaBancariaSaldo0.ingresarDinero(1000);
        cuentaBancariaSaldo0.retirarDinero(500);
        // Immprimo por pantalla ambos, el saldo de la cuenta y el numero de cuenta.
        System.out.println("Saldo de la cuenta: " + cuentaBancariaSaldo0.getSaldo());
        System.out.println("Numero de la cuenta: " + cuentaBancariaSaldo0.getNumeroCuenta());

        // SEGUNDA PARTE - EJERCICIOS CON LA CUENTA CON SALDO "-1". //

        // Intentamos depositar 1000, retirar 500, depositar 200, retirar 800, si ocurre un error lo atrapmos.
        try {
            cuentaBancariaSaldoN.ingresarDinero(1000);
            cuentaBancariaSaldoN.retirarDinero(500);
            cuentaBancariaSaldoN.ingresarDinero(200);
            cuentaBancariaSaldoN.retirarDinero(800);
            // Probamos las aserciones
            cuentaBancariaSaldoN.ingresarDinero(0);
            cuentaBancariaSaldoN.retirarDinero(-1);
        } catch (SaldoInsufienteException_RESUELTO exception) {
            System.out.println("!Lo siento! Su saldo actual es insuficiente para realizar esta operacion.");
        }
        // Impprimo por pantalla ambos, el saldo de la cuenta y el numero
        System.out.println("Saldo de la cuenta: " + cuentaBancariaSaldoN.getSaldo());
        System.out.println("Numero de la cuenta: " + cuentaBancariaSaldoN.getNumeroCuenta());

    }
}
