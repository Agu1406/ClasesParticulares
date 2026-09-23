/*
U03 — Delegates, Func, Action y Predicate.

OBJETIVO:
  - Ver delegates como tipo de "puntero a metodo".
  - Usar Action (void), Func (retorno) y Predicate (bool).
  - Pasar metodos por nombre o lambdas a APIs de colecciones.

En Java: interfaces SAM (Runnable, Supplier, Function, Predicate).
En C#: delegate / Action / Func / Predicate (built-in).

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
    // Delegate clasico (menos habitual hoy; sirve para explicar el concepto).
    delegate int Operacion(int a, int b);

    static void ImprimirMenu()
    {
        Console.WriteLine("=== U03 Delegates / Func / Action ===");
        Console.WriteLine("1. Delegate y Func que reciben funciones");
        Console.WriteLine("2. Action y Predicate");
        Console.WriteLine("3. Metodo por nombre vs lambda");
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
                    DemoRecibirFunciones();
                    break;
                case 2:
                    DemoActionPredicate();
                    break;
                case 3:
                    DemoMetodoVsLambda();
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

    static int Aplicar(Operacion op, int a, int b)
    {
        return op(a, b);
    }

    static int AplicarFunc(Func<int, int, int> op, int a, int b)
    {
        return op(a, b);
    }

    static Func<int, int> FabricarMultiplicador(int factor)
    {
        return n => n * factor;
    }

    /*
    PRIMERA PARTE — Funciones que reciben / devuelven funciones.
    */
    static void DemoRecibirFunciones()
    {
        Console.WriteLine("¡DEMO — Recibir y devolver funciones!\n");

        Operacion suma = (x, y) => x + y;
        Operacion resta = (x, y) => x - y;
        Console.WriteLine($"Aplicar(suma, 2, 6)  -> {Aplicar(suma, 2, 6)}");
        Console.WriteLine($"Aplicar(resta, 10, 5) -> {Aplicar(resta, 10, 5)}");
        Console.WriteLine($"AplicarFunc(lambda, 6, 7) -> {AplicarFunc((x, y) => x * y, 6, 7)}");

        Func<int, int> porDiez = FabricarMultiplicador(10);
        Func<int, int> porDos = FabricarMultiplicador(2);
        Console.WriteLine($"porDiez(3) -> {porDiez(3)}");
        Console.WriteLine($"porDos(8)  -> {porDos(8)}");
    }

    /*
    SEGUNDA PARTE — Action (efecto) y Predicate (condicion).
    */
    static void DemoActionPredicate()
    {
        Console.WriteLine("¡DEMO — Action y Predicate!\n");

        Action<string> imprimir = texto => Console.WriteLine($">> {texto}");
        imprimir("Action de ejemplo");

        List<int> numeros = new List<int> { 3, 1, 4 };
        numeros.ForEach(n => Console.WriteLine($"N={n}"));

        Predicate<string> vacia = t => t.Length == 0;
        Console.WriteLine("vacia(\"\") -> " + vacia(""));
        Console.WriteLine("vacia(\"csharp\") -> " + vacia("csharp"));

        Predicate<char> esMayus = c => char.IsUpper(c);
        Console.WriteLine($"esMayus('A') -> {esMayus('A')} | esMayus('a') -> {esMayus('a')}");
    }

    static int Longitud(string texto)
    {
        return texto.Length;
    }

    /*
    TERCERA PARTE — Metodo por nombre (group method) vs lambda con logica extra.
    */
    static void DemoMetodoVsLambda()
    {
        Console.WriteLine("¡DEMO — Metodo por nombre vs lambda!\n");

        Func<string, int> longitudRef = Longitud;
        Func<string, int> longitudLambda = t => t.Length;
        string palabra = "stream";
        Console.WriteLine($"metodo: {longitudRef(palabra)} | lambda: {longitudLambda(palabra)}");

        List<string> nombres = new List<string> { "Alice", "Bob", "John" };
        Console.WriteLine("--- ForEach Console.WriteLine ---");
        nombres.ForEach(Console.WriteLine);

        Console.WriteLine("--- Select ToUpper ---");
        List<string> mayus = nombres.Select(s => s.ToUpper()).ToList();
        Console.WriteLine($"[{string.Join(", ", mayus)}]");

        // Logica extra: hace falta lambda (no basta el nombre solo)
        List<string> conPrefijo = nombres.Select(n => $">> {n}").ToList();
        conPrefijo.ForEach(Console.WriteLine);

        List<string> ordenExtra = new List<string> { "Ana", "Luis", "Eva" }
            .OrderBy(p => p.Length + 1)
            .ToList();
        Console.WriteLine($"orden con logica extra: [{string.Join(", ", ordenExtra)}]");
    }
}
