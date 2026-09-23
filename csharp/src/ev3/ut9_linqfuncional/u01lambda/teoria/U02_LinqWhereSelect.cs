/*
U02 — LINQ Where, Select y OrderBy sobre List.

OBJETIVO:
  - Filtrar con Where (predicados).
  - Transformar con Select (proyecciones).
  - Ordenar con OrderBy / OrderByDescending.
  - Encadenar operaciones y materializar con ToList().

En Java: stream().filter().map().sorted().
En C#: lista.Where(...).Select(...).OrderBy(...).ToList().

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
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U02 LINQ: Where / Select / OrderBy ===");
        Console.WriteLine("1. Where (filtrar)");
        Console.WriteLine("2. Select (transformar)");
        Console.WriteLine("3. OrderBy y encadenar");
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
                    DemoWhere();
                    break;
                case 2:
                    DemoSelect();
                    break;
                case 3:
                    DemoOrderByEncadenar();
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
    PRIMERA PARTE — Where: conservar elementos que cumplen un predicado.
    */
    static void DemoWhere()
    {
        Console.WriteLine("¡DEMO — Where!\n");
        List<string> palabras = new List<string> { "pf", "java", "lambda", "stream", "xilofono" };

        List<string> largas = palabras.Where(p => p.Length > 4).ToList();
        Console.WriteLine($"Largas (>4): [{string.Join(", ", largas)}]");

        List<string> sinX = palabras.Where(p => !p.StartsWith("x", StringComparison.OrdinalIgnoreCase)).ToList();
        Console.WriteLine($"Sin prefijo x: [{string.Join(", ", sinX)}]");
    }

    /*
    SEGUNDA PARTE — Select: proyectar a otro tipo / forma.
    */
    static void DemoSelect()
    {
        Console.WriteLine("¡DEMO — Select!\n");
        List<string> palabras = new List<string> { "sol", "programacion", "pf" };

        List<int> longitudes = palabras.Select(p => p.Length).ToList();
        Console.WriteLine($"Longitudes: [{string.Join(", ", longitudes)}]");

        List<string> mayus = palabras.Select(p => p.ToUpper()).ToList();
        Console.WriteLine($"Mayusculas: [{string.Join(", ", mayus)}]");
    }

    /*
    TERCERA PARTE — OrderBy + encadenar Where/Select.
    */
    static void DemoOrderByEncadenar()
    {
        Console.WriteLine("¡DEMO — OrderBy y encadenar!\n");
        List<string> palabras = new List<string> { "stream", "java", "lambda", "pf" };

        List<string> porLongitud = palabras.OrderBy(p => p.Length).ToList();
        Console.WriteLine($"OrderBy Length: [{string.Join(", ", porLongitud)}]");

        List<int> numeros = new List<int> { 3, 10, 1, 8 };
        List<int> desc = numeros.OrderByDescending(n => n).ToList();
        Console.WriteLine($"OrderByDescending: [{string.Join(", ", desc)}]");

        // Encadenar: filtrar pares, multiplicar por 10, ordenar
        List<int> fuente = new List<int> { 1, 2, 3, 4, 5, 6, 7, 8 };
        List<int> cadena = fuente
            .Where(n => n % 2 == 0)
            .Select(n => n * 10)
            .OrderBy(n => n)
            .ToList();
        Console.WriteLine($"Where+Select+OrderBy: [{string.Join(", ", cadena)}]");
    }
}
