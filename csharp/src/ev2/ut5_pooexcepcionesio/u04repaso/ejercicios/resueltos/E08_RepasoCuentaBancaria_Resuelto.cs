/*
OBJETIVO: Repaso: CuentaBancaria con saldo encapsulado; depositar y retirar. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
SOLUCION: ver codigo.

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
                case 3:
                    EjecutarInteractivo();
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
        Console.WriteLine("=== EJERCICIO ===");
        Console.WriteLine("1. Ejecutar solucion");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("3. Operar cuenta interactiva");
        Console.WriteLine("0. Salir");
        
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Repaso: CuentaBancaria con saldo encapsulado; depositar y retirar.");
    }


    static void EjecutarEjercicio()
    {
        CuentaBancaria cuenta = new CuentaBancaria(200);
            cuenta.Depositar(50);
            cuenta.Retirar(80);
            Console.WriteLine($"Saldo: {cuenta.Saldo} EUR");
    }

    static void EjecutarInteractivo()
    {
        Console.Write("Saldo inicial: ");
        if (!double.TryParse(Console.ReadLine(), out double inicial))
        {
            Console.WriteLine("Saldo invalido.");
            return;
        }
        CuentaBancaria cuenta = new CuentaBancaria(inicial);
        Console.Write("Deposito: ");
        if (double.TryParse(Console.ReadLine(), out double deposito))
        {
            cuenta.Depositar(deposito);
        }
        Console.Write("Retiro: ");
        if (double.TryParse(Console.ReadLine(), out double retiro))
        {
            if (!cuenta.Retirar(retiro))
            {
                Console.WriteLine("Retiro rechazado.");
            }
        }
        Console.WriteLine($"Saldo: {cuenta.Saldo} EUR");
    }
}


class CuentaBancaria
{
    private double saldo;
    public double Saldo => saldo;

    public CuentaBancaria(double inicial) => saldo = inicial;

    public void Depositar(double c) { if (c > 0) saldo += c; }

    public bool Retirar(double c)
    {
        if (c <= 0 || c > saldo) return false;
        saldo -= c;
        return true;
    }
}
