/*
U06 — Encapsulacion (introduccion).

Encapsular es ocultar datos sensibles (private) y ofrecer metodos o
propiedades publicas que validan antes de modificar. Asi el saldo de
una cuenta no se puede corromper desde fuera con asignaciones directas.

OBJETIVO:
  - Usar campos private y propiedades publicas de solo lectura.
  - Implementar Depositar y Retirar con validacion en bloques { }.
  - Impedir retiros invalidos sin romper el programa.
  - Ver que el usuario de la clase solo llama metodos seguros, no toca saldo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U06 Encapsulacion ===");
        Console.WriteLine("1. Cuenta con encapsulacion");
        Console.WriteLine("2. Depositar");
        Console.WriteLine("3. Retirar");
        Console.WriteLine("0. Salir");
    }

    static void Main()
    {
        int opcion;
        do
        {
            ImprimirMenu();
            Console.Write("Introduce una opcion -> ");
            opcion = int.Parse(Console.ReadLine()!);
            Console.WriteLine();

            switch (opcion)
            {
                case 1:
                    DemoCuenta();
                    break;
                case 2:
                    DemoDepositar();
                    break;
                case 3:
                    DemoRetirar();
                    break;
                case 0:
                    Console.WriteLine("Saliendo...");
                    break;
                default:
                    Console.WriteLine("Opcion no valida.");
                    break;
            }

            Console.WriteLine();
        } while (opcion != 0);
    }

    /*
    PRIMERA PARTE — Crear cuenta con saldo inicial via constructor.
      Saldo es solo lectura desde fuera (propiedad calculada sobre campo private).
    */
    static void DemoCuenta()
    {
        Console.WriteLine("¡DEMO — Cuenta con encapsulacion!\n");

        CuentaBancaria cuenta = new CuentaBancaria("ES001", 100);
        Console.WriteLine($"IBAN: {cuenta.Iban}");
        Console.WriteLine($"Saldo inicial: {cuenta.Saldo} €");
    }

    /*
    SEGUNDA PARTE — Depositar cantidades validas.
      Cantidades <= 0 se ignoran dentro del metodo (no modifican saldo).
    */
    static void DemoDepositar()
    {
        Console.WriteLine("¡DEMO — Depositar!\n");

        CuentaBancaria cuenta = new CuentaBancaria("ES001", 100);
        Console.WriteLine($"Saldo inicial: {cuenta.Saldo} €");

        cuenta.Depositar(50);
        Console.WriteLine($"Saldo tras depositar 50 €: {cuenta.Saldo} €");

        cuenta.Depositar(-10);
        Console.WriteLine($"Saldo tras intentar depositar -10 € (ignorado): {cuenta.Saldo} €");
    }

    /*
    TERCERA PARTE — Retirar con validacion: devuelve true/false.
      No permite retirar mas del saldo ni cantidades negativas.
    */
    static void DemoRetirar()
    {
        Console.WriteLine("¡DEMO — Retirar!\n");

        CuentaBancaria cuenta = new CuentaBancaria("ES001", 150);

        bool ok1 = cuenta.Retirar(30);
        Console.WriteLine($"Retirar 30 € -> {(ok1 ? "OK" : "Rechazado")}. Saldo: {cuenta.Saldo} €");

        bool ok2 = cuenta.Retirar(200);
        Console.WriteLine($"Retirar 200 € -> {(ok2 ? "OK" : "Rechazado")}. Saldo: {cuenta.Saldo} €");

        bool ok3 = cuenta.Retirar(0);
        Console.WriteLine($"Retirar 0 € -> {(ok3 ? "OK" : "Rechazado")}. Saldo: {cuenta.Saldo} €");

        Console.WriteLine($"\nSaldo final: {cuenta.Saldo} €");
    }
}

class CuentaBancaria
{
    private double saldo;

    public string Iban { get; }
    public double Saldo
    {
        get
        {
            return saldo;
        }
    }

    public CuentaBancaria(string iban, double saldoInicial)
    {
        Iban = iban;
        if (saldoInicial >= 0)
        {
            saldo = saldoInicial;
        }
        else
        {
            saldo = 0;
        }
    }

    public void Depositar(double cantidad)
    {
        if (cantidad > 0)
        {
            saldo += cantidad;
        }
    }

    public bool Retirar(double cantidad)
    {
        if (cantidad <= 0)
        {
            return false;
        }
        if (cantidad > saldo)
        {
            return false;
        }
        saldo -= cantidad;
        return true;
    }
}
