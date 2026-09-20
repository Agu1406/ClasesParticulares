/*
OBJETIVO: abstract class Cuenta con Depositar concreto y Retirar abstracto;
  CuentaAhorro con limite diario. SOLUCION: ver codigo.

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
        Console.WriteLine("=== E05 Abstraccion CuentaAhorro (resuelto) ===");
        Console.WriteLine("1. Ejecutar solucion");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"abstract class Cuenta: titular, saldo, Depositar, Retirar abstracto.
CuentaAhorro: limite de retiro diario; sin saldo negativo.
Crea una CuentaAhorro, deposita y retira; muestra el saldo.");
    }

    static void EjecutarEjercicio()
    {
        CuentaAhorro ahorro = new CuentaAhorro("Lucia", 1000, 300);
        ahorro.Depositar(200);
        ahorro.Retirar(150);
        ahorro.Retirar(400);
        Console.WriteLine($"Saldo final: {ahorro.GetSaldo()}");
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

    public void Depositar(double cantidad)
    {
        if (cantidad <= 0)
        {
            Console.WriteLine("Cantidad invalida.");
            return;
        }
        saldo += cantidad;
        Console.WriteLine($"Deposito {cantidad}. Saldo: {saldo}");
    }

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
        if (cantidad <= 0)
        {
            Console.WriteLine("[Ahorro] Cantidad invalida.");
            return;
        }
        if (cantidad > limiteRetiroDiario)
        {
            Console.WriteLine($"[Ahorro] Supera limite diario ({limiteRetiroDiario}).");
            return;
        }
        if (cantidad > saldo)
        {
            Console.WriteLine("[Ahorro] Saldo insuficiente.");
            return;
        }
        saldo -= cantidad;
        Console.WriteLine($"[Ahorro] Retiro {cantidad}. Saldo: {saldo}");
    }
}
