/*
OBJETIVO: Ordena nombres alfabeticamente con OrderBy (orden natural de string).
SOLUCION: OrderBy(n => n).ToList() e imprimir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

using System;
using System.Collections.Generic;
using System.Linq;

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
        Console.WriteLine("=== E02 OrdenAlfabetico (resuelto) ===");
        Console.WriteLine("1. Ejecutar solucion");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Ordena nombres alfabeticamente con OrderBy (orden natural de string).");
    }

    static void EjecutarEjercicio()
    {
        List<string> nombres = new List<string> { "Zoe", "Ana", "Luis", "Marta" };
        List<string> ordenados = nombres.OrderBy(n => n).ToList();
        Console.WriteLine($"[{string.Join(", ", ordenados)}]");
    }
}
