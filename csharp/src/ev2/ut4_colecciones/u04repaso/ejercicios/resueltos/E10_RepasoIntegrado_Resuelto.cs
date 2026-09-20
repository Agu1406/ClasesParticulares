/*
OBJETIVO: Repaso: lista ints, dict resumen min/max/suma. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
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
        using System.Collections.Generic;

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
        Console.WriteLine("=== EJERCICIO ===");
        Console.WriteLine("1. Ejecutar solucion");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
        
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Repaso: lista ints, dict resumen min/max/suma.");
    }

    static void EjecutarEjercicio()
    {
        List<int> nums = new List<int> { 4, 9, 2, 7 };
        int suma = 0, max = nums[0], min = nums[0];
        foreach (int n in nums)
        {
            suma += n;
            if (n > max) max = n;
            if (n < min) min = n;
        }
        Dictionary<string, int> resumen = new Dictionary<string, int>
        {
            { "suma", suma },
            { "max", max },
            { "min", min }
        };
        foreach (KeyValuePair<string, int> par in resumen)
        {
            Console.WriteLine(par.Key + ": " + par.Value);
        }
    }
}
