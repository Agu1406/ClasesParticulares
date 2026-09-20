/*
OBJETIVO: Metodo int Potencia(int baseP, int exp); imprime 2 elevado a 5.
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
            Console.WriteLine("=== E09 Potencia Resuelto ===");
            Console.WriteLine("1. Ejecutar ejemplo del enunciado");
            Console.WriteLine("2. Probar con tus datos");
            Console.WriteLine("0. Salir");
            Console.Write("Elige una opcion: ");
            opcion = Console.ReadLine();
            switch (opcion)
            {
                case "1":
                    Console.WriteLine(Potencia(2, 5));
                    break;
                case "2":
                    int baseP = LeerEntero("Base: ");
                    int exp = LeerEntero("Exponente: ");
                    Console.WriteLine($"Potencia = {Potencia(baseP, exp)}");
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
    static int Potencia(int baseP, int exp)
    {
        int r = 1;
        for (int i = 0; i < exp; i++)
        {
            r *= baseP;
        }
        return r;
    }
}
