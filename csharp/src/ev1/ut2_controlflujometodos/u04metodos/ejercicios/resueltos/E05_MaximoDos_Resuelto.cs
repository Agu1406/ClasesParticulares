/*
OBJETIVO: Metodo int Maximo(int a, int b); imprime Maximo(12, 9).
SOLUCION: ver codigo.
PATRON: Menu do-while con opcion 0 salir y uso de Console.ReadLine().
Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/
using System;
class Program
{
    static void Main()
    {
        string? opcion;
        do
        {
            Console.WriteLine();
            Console.WriteLine("=== E05 Maximo Dos Resuelto ===");
            Console.WriteLine("1. Ejecutar ejemplo del enunciado");
            Console.WriteLine("2. Probar con tus datos");
            Console.WriteLine("0. Salir");
            Console.Write("Elige una opcion: ");
            opcion = Console.ReadLine();
            switch (opcion)
            {
                case "1":
                    Console.WriteLine(Maximo(12, 9));
                    break;
                case "2":
                    int a = LeerEntero("Primer numero: ");
                    int b = LeerEntero("Segundo numero: ");
                    Console.WriteLine($"Maximo = {Maximo(a, b)}");
                    break;
                case "0":
                    Console.WriteLine("Saliendo...");
                    break;
                default:
                    Console.WriteLine("Opcion no valida.");
                    break;
            }
        } while (opcion != "0");
    }
    static int LeerEntero(string mensaje)
    {
        Console.Write(mensaje);
        return int.Parse(Console.ReadLine() ?? "0");
    }
    static double LeerDouble(string mensaje)
    {
        Console.Write(mensaje);
        return double.Parse(Console.ReadLine() ?? "0");
    }
    static int Maximo(int a, int b)
    {
        return a > b ? a : b;
    }
}
