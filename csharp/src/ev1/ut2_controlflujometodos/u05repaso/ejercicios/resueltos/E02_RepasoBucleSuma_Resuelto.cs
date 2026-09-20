/*
OBJETIVO: For: suma del 1 al 10.
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
            Console.WriteLine("=== E02 Repaso Bucle Suma Resuelto ===");
            Console.WriteLine("1. Ejecutar ejemplo del enunciado");
            Console.WriteLine("2. Probar hasta otro limite");
            Console.WriteLine("0. Salir");
            Console.Write("Elige una opcion: ");
            opcion = Console.ReadLine();
            switch (opcion)
            {
                case "1":
                    Console.WriteLine(SumarHasta(10));
                    break;
                case "2":
                    Console.Write("Limite: ");
                    int limite = int.Parse(Console.ReadLine() ?? "0");
                    Console.WriteLine(SumarHasta(limite));
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
    static int SumarHasta(int limite)
    {
        int s = 0;
        for (int i = 1; i <= limite; i++)
        {
            s += i;
        }
        return s;
    }
}
