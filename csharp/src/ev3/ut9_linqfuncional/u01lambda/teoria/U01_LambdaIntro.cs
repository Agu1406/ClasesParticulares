/*
U01 — Expresiones lambda, Action y Func.

OBJETIVO:
  - Entender lambda (x => ...) como funcion anonima.
  - Usar Action (sin retorno) y Func (con retorno).
  - Comparar bucle tradicional vs estilo funcional basico.

En Java: (a, b) -> ..., Predicate / Function / Consumer.
En C#: x => ..., Action / Func / Predicate + LINQ.

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
        Console.WriteLine("=== U01 Lambda: Action / Func ===");
        Console.WriteLine("1. Contar pares (bucle vs Where)");
        Console.WriteLine("2. Sumar pares * 10 (Where + Select)");
        Console.WriteLine("3. Action y Func con lambda");
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
                    DemoContarPares();
                    break;
                case 2:
                    DemoSumarParesPorDiez();
                    break;
                case 3:
                    DemoActionYFunc();
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
    PRIMERA PARTE — Contar pares: bucle vs Where + lambda.
      Lista: 1,3,5,7,9,2,4,6,8 -> pares: 4.
    */
    static void DemoContarPares()
    {
        Console.WriteLine("¡DEMO — Contar pares!\n");
        List<int> listaNumeros = new List<int> { 1, 3, 5, 7, 9, 2, 4, 6, 8 };

        int totalTradicional = 0;
        foreach (int numero in listaNumeros)
        {
            if (numero % 2 == 0)
            {
                totalTradicional++;
            }
        }
        Console.WriteLine($"Tradicional: {totalTradicional} pares");

        List<int> pares = listaNumeros.Where(n => n % 2 == 0).ToList();
        Console.WriteLine($"Where + lambda: {pares.Count} pares -> [{string.Join(", ", pares)}]");
    }

    /*
    SEGUNDA PARTE — Sumar (pares * 10): bucle vs Where + Select + Sum.
    */
    static void DemoSumarParesPorDiez()
    {
        Console.WriteLine("¡DEMO — Sumar pares * 10!\n");
        List<int> numeros = new List<int> { 1, 2, 3, 4, 5, 6, 7, 8 };

        int resultadoImperativo = 0;
        foreach (int n in numeros)
        {
            if (n % 2 == 0)
            {
                resultadoImperativo += n * 10;
            }
        }
        Console.WriteLine($"Tradicional: {resultadoImperativo}");

        int resultadoFuncional = numeros
            .Where(n => n % 2 == 0)
            .Select(n => n * 10)
            .Sum();
        Console.WriteLine($"Where + Select + Sum: {resultadoFuncional}");
    }

    /*
    TERCERA PARTE — Action (efecto) y Func (valor) con lambda.
    */
    static void DemoActionYFunc()
    {
        Console.WriteLine("¡DEMO — Action y Func!\n");

        Action saludo = () => Console.WriteLine("Hola desde Action");
        saludo();

        Action<string> imprimir = texto => Console.WriteLine($">> {texto}");
        imprimir("Consumer / Action de ejemplo");

        Func<string> mensaje = () => "Programacion funcional";
        Console.WriteLine($"Func<> supplier: {mensaje()}");

        Func<int, int, int> multiplicar = (a, b) => a * b;
        Console.WriteLine($"Func<int,int,int>(6,7) -> {multiplicar(6, 7)}");

        List<string> palabras = new List<string> { "java", "lambda", "stream", "pf" };
        List<string> ordenadas = palabras.OrderBy(p => p.Length).ToList();
        Console.WriteLine($"OrderBy longitud: [{string.Join(", ", ordenadas)}]");
    }
}
