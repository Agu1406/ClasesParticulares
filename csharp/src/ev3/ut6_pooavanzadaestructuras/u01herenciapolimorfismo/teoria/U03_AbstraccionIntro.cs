/*
U03 — Introduccion a la abstraccion (abstract class).

En el banco existen cuentas de ahorro y de credito, pero no una
"cuenta generica" que puedas abrir tal cual. Eso se modela con abstract:
datos/operaciones comunes + metodos sin implementar que cada hija completa.

OBJETIVO:
  - Declarar abstract class y metodos abstractos.
  - Entender que new Cuenta(...) no compila.
  - Implementar retirar / tipoCuenta en CuentaAhorro y CuentaCredito.
  - Usar referencia abstracta apuntando a objetos concretos.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U03 Abstraccion: Cuenta / Ahorro / Credito ===");
        Console.WriteLine("1. Por que abstract?");
        Console.WriteLine("2. Demo CuentaAhorro");
        Console.WriteLine("3. Demo CuentaCredito");
        Console.WriteLine("4. Array de Cuenta (polimorfismo + abstraccion)");
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
                    DemoPorQueAbstract();
                    break;
                case 2:
                    DemoCuentaAhorro();
                    break;
                case 3:
                    DemoCuentaCredito();
                    break;
                case 4:
                    DemoArrayCuentas();
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

    static void DemoPorQueAbstract()
    {
        Console.WriteLine("¡DEMO — Por que abstract?\n");
        Console.WriteLine("Cuenta = molde comun. Ahorro y Credito = productos reales.");
        Console.WriteLine("No tiene sentido: new Cuenta(\"Ana\", 100);  // NO COMPILA");
        Console.WriteLine("Si una clase declara un metodo abstract, la clase debe ser abstract.");
        Console.WriteLine("La primera subclase concreta debe implementar todos los abstractos.");
    }

    static void DemoCuentaAhorro()
    {
        Console.WriteLine("¡DEMO — CuentaAhorro (limite diario, sin descubierto)!\n");

        CuentaAhorro ahorro = new CuentaAhorro("Lucia", "Pedro", 1000, 300);
        Console.WriteLine(ahorro);
        ahorro.Depositar(200);
        ahorro.Retirar(150);  // OK
        ahorro.Retirar(400);  // supera limite diario
        ahorro.Retirar(2000); // saldo insuficiente
    }

    static void DemoCuentaCredito()
    {
        Console.WriteLine("¡DEMO — CuentaCredito (descubierto hasta el limite)!\n");

        CuentaCredito credito = new CuentaCredito("Daniel", 100, 500);
        Console.WriteLine(credito);
        credito.Retirar(200);  // saldo -100, dentro del credito
        credito.Retirar(500);  // intentaria -600; limite 500 -> rechazado
        Console.WriteLine(credito);
    }

    static void DemoArrayCuentas()
    {
        Console.WriteLine("¡DEMO — Misma referencia abstracta, distinto Retirar()!\n");

        Cuenta[] cuentas =
        {
            new CuentaAhorro("Ana", 800, 200),
            new CuentaCredito("Luis", 50, 300)
        };

        foreach (Cuenta c in cuentas)
        {
            Console.WriteLine($"--- {c.TipoCuenta()} ---");
            c.Retirar(100);
            Console.WriteLine($"Saldo tras retiro: {c.GetSaldo()}");
        }
    }
}

abstract class Cuenta
{
    private string titular;
    private string? cotitular;
    protected double saldo;

    public Cuenta(string nuevoTitular, string? nuevoCotitular, double saldoInicial)
    {
        titular = nuevoTitular;
        cotitular = nuevoCotitular;
        saldo = saldoInicial;
    }

    public Cuenta(string nuevoTitular, double saldoInicial)
        : this(nuevoTitular, null, saldoInicial)
    {
    }

    public string GetTitular() => titular;
    public string? GetCotitular() => cotitular;
    public double GetSaldo() => saldo;

    public void Depositar(double cantidad)
    {
        if (cantidad <= 0)
        {
            Console.WriteLine("La cantidad a depositar debe ser positiva.");
            return;
        }
        saldo += cantidad;
        Console.WriteLine($"Deposito de {cantidad} OK. Saldo: {saldo}");
    }

    public abstract void Retirar(double cantidad);
    public abstract string TipoCuenta();

    public override string ToString()
    {
        string texto = $"\n¡Datos de la cuenta!\nTipo: {TipoCuenta()}\nTitular: {titular}\n";
        if (cotitular != null)
        {
            texto += $"Cotitular: {cotitular}\n";
        }
        texto += $"Saldo actual: {saldo}\n";
        return texto;
    }
}

class CuentaAhorro : Cuenta
{
    private double limiteRetiroDiario;

    public CuentaAhorro(string titular, double saldoInicial, double limiteRetiroDiario)
        : base(titular, saldoInicial)
    {
        this.limiteRetiroDiario = limiteRetiroDiario;
    }

    public CuentaAhorro(string titular, string cotitular, double saldoInicial, double limiteRetiroDiario)
        : base(titular, cotitular, saldoInicial)
    {
        this.limiteRetiroDiario = limiteRetiroDiario;
    }

    public override void Retirar(double cantidad)
    {
        if (cantidad <= 0)
        {
            Console.WriteLine("[Ahorro] La cantidad debe ser positiva.");
            return;
        }
        if (cantidad > limiteRetiroDiario)
        {
            Console.WriteLine($"[Ahorro] Supera el limite diario ({limiteRetiroDiario}).");
            return;
        }
        if (cantidad > saldo)
        {
            Console.WriteLine("[Ahorro] Saldo insuficiente.");
            return;
        }
        saldo -= cantidad;
        Console.WriteLine($"[Ahorro] Retiro de {cantidad} OK. Saldo: {saldo}");
    }

    public override string TipoCuenta() => "Cuenta ahorro";

    public override string ToString()
    {
        return base.ToString() + $"Limite de retiro diario: {limiteRetiroDiario}\n";
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

    public CuentaCredito(string titular, string cotitular, double saldoInicial, double limiteCredito)
        : base(titular, cotitular, saldoInicial)
    {
        this.limiteCredito = limiteCredito;
    }

    public override void Retirar(double cantidad)
    {
        if (cantidad <= 0)
        {
            Console.WriteLine("[Credito] La cantidad debe ser positiva.");
            return;
        }
        if (saldo - cantidad < -limiteCredito)
        {
            Console.WriteLine($"[Credito] Supera el limite de credito ({limiteCredito}).");
            return;
        }
        saldo -= cantidad;
        Console.WriteLine($"[Credito] Retiro de {cantidad} OK. Saldo: {saldo}");
    }

    public override string TipoCuenta() => "Cuenta credito";

    public override string ToString()
    {
        return base.ToString() + $"Limite de credito: {limiteCredito}\n";
    }
}
