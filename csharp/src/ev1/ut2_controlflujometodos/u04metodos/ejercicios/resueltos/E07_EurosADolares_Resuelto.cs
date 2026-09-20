/*
OBJETIVO: Metodo double EurosADolares(double euros); tasa 1.08; imprime conversion de 100.
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
            Console.WriteLine("=== E07 Euros A Dolares Resuelto ===");
            Console.WriteLine("1. Ejecutar ejemplo del enunciado");
            Console.WriteLine("2. Probar con tus datos");
            Console.WriteLine("0. Salir");
            Console.Write("Elige una opcion: ");
            opcion = Console.ReadLine();
            switch (opcion)
            {
                case "1":
                    Console.WriteLine(EurosADolares(100));
                    break;
                case "2":
                    double euros = LeerDouble("Euros: ");
                    Console.WriteLine($"Dolares = {EurosADolares(euros)}");
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
    static double EurosADolares(double euros)
    {
        return euros * 1.08;
    }
}
