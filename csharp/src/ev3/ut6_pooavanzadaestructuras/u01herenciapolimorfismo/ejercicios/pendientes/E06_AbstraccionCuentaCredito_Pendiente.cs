/*
OBJETIVO: Anadir CuentaCredito (descubierto) y comparar Retirar con CuentaAhorro
  usando referencia Cuenta. Menu do-while.

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
        Console.WriteLine("=== E06 Abstraccion CuentaCredito ===");
        Console.WriteLine("1. Trabajar ejercicio");
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
        // TODO: Array Cuenta[] con ahorro y credito; Retirar(100) en cada una.
    }
}

// TODO: Cuenta, CuentaAhorro, CuentaCredito.
