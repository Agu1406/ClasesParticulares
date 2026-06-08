package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madriduaxsistemagestionbanco;

public class CuentaBancaria_SIN_RESOLVER {
    // ATRBITUOS DE LA CLASE //

    // Creamos un atributo double que guarda el saldo de la cuenta (puede tener decimales)
    private double saldo;
    // Creamos un String que guarda el numero de cuenta.
    private String numeroCuenta;

    // CONSTRUCTORES DE LA CLASE //

    /**
     * Constructor de la clase "CuentaBancaria_SIN_RESOLVER" que permite
     * abrir (instanciar) cuentas de banco con saldo en
     * "-1", recibe como argumentos el numero de cuenta
     * del cliente y un saldo.
     */
    public CuentaBancaria_SIN_RESOLVER(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = -1;
    }

    /**
     * Constructor de la clase "CuentaBancaria_SIN_RESOLVER" que permite
     * abrir (instanciar) cuentas de banco con saldo en
     * "0", recibe como argumento el numero de cuenta
     * del cliente.
     */
    public CuentaBancaria_SIN_RESOLVER(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
    }

    // METODOS DE LA CLASE //

    public void ingresarDinero(double cantidad) {
        /*
         * assert se lee como lo siguiente "?Esto es verdadero o falso?" Si es verdadero sigue
         * adelante, si es falso, envia un mensaje de error personalizado.
         * */
        assert cantidad > 0 : "!Error! La cantidad de dinero a ingresar debe ser un numero positivo";
        /*
         * Si saldo actualmente fuese "200" y el efectivo a ingresar fuese "50" entonces
         * saldo = 200 + 50;
         * */
        saldo = saldo + cantidad;
    }

    public void retirarDinero(double cantidad) throws SaldoInsufienteException_SIN_RESOLVER {
        // Primer control de errores, evita que el usuario intente retirar "0" euros o menos.
        assert cantidad > 0 : "!Error! La cantidad de dinero que desea retirar debe ser mayor a cero";
        // Segundo control de errores, evita que el usuario retire mas dinero del que tiene actualmente.
        if (cantidad > saldo) {
            throw new SaldoInsufienteException_SIN_RESOLVER ("!Error! Saldo insuficiente, intente una cantida mas pequena");
        }
        // Actualiza el saldo actual de la cuenta restando la cantidad retirada.
        saldo = saldo - cantidad;
    }

    // METODOS GETTERS Y SETTERS //

    public double getSaldo() {
        return saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }
}
