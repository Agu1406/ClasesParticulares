/*
OBJETIVO: Anadir CuentaCredito (descubierto) y comparar Retirar con CuentaAhorro
  usando referencia Cuenta. SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void Main()
    {
        int opcion;

        do
        {
            ImprimirMenu();
            Console.Write("Introduce una opcion -> ");
            opcion = int.Parse(Console.ReadLine()!);

            switch (opcion)
            {
                case 1:
                    EjecutarEjercicio();
                    break;
                case 2:
                    MostrarObjetivo();
                    break;
                case 0:
                    Console.WriteLine("Saliendo...");
                    break;
                default:
                    Console.WriteLine("Opcion no valida. Intenta de nuevo.");
                    break;
            }

            if (opcion != 0)
            {
                Console.WriteLine();
                Console.WriteLine("Pulsa ENTER para continuar...");
                Console.ReadLine();
                Console.Clear();
            }
        } while (opcion != 0);
    }

    static void ImprimirMenu()
    {
        Console.WriteLine("=== E06 Abstraccion CuentaCredito (resuelto) ===");
        Console.WriteLine("1. Ejecutar solucion");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Cuenta abstracta; CuentaAhorro y CuentaCredito.
Credito permite saldo negativo hasta limiteCredito.
Crea ambas como Cuenta[]; retira la misma cantidad y compara saldos.");
    }

    static void EjecutarEjercicio()
    {
        Cuenta[] cuentas =
        {
            new CuentaAhorro("Ana", 800, 200),
            new CuentaCredito("Luis", 50, 300)
        };

        foreach (Cuenta c in cuentas)
        {
            Console.WriteLine($"--- {c.GetTitular()} ---");
            c.Retirar(100);
            Console.WriteLine($"Saldo: {c.GetSaldo()}");
        }
    }
}

abstract class Cuenta
{
    private string titular;
    protected double saldo;

    public Cuenta(string titular, double saldoInicial)
    {
        this.titular = titular;
        saldo = saldoInicial;
    }

    public string GetTitular() => titular;
    public double GetSaldo() => saldo;

    public abstract void Retirar(double cantidad);
}

class CuentaAhorro : Cuenta
{
    private double limiteRetiroDiario;

    public CuentaAhorro(string titular, double saldoInicial, double limiteRetiroDiario)
        : base(titular, saldoInicial)
    {
        this.limiteRetiroDiario = limiteRetiroDiario;
    }

    public override void Retirar(double cantidad)
    {
        if (cantidad > limiteRetiroDiario || cantidad > saldo)
        {
            Console.WriteLine("[Ahorro] Retiro rechazado.");
            return;
        }
        saldo -= cantidad;
        Console.WriteLine($"[Ahorro] Retiro {cantidad} OK.");
    }
}

class CuentaCredito : Cuenta
{
    private double limiteCredito;

    public CuentaCredito(string titular, double saldoInicial, double limiteCredito)
        : base(titular, saldoInicial)
    {
        this.limiteCredito = limiteCredito;
    }

    public override void Retirar(double cantidad)
    {
        if (saldo - cantidad < -limiteCredito)
        {
            Console.WriteLine("[Credito] Retiro rechazado.");
            return;
        }
        saldo -= cantidad;
        Console.WriteLine($"[Credito] Retiro {cantidad} OK.");
    }
}
