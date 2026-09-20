/*
OBJETIVO: Tabla del 7 del 1 al 10 con for.
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
            Console.WriteLine("=== E05 Repaso Tabla Resuelto ===");
            Console.WriteLine("1. Ejecutar tabla del 7");
            Console.WriteLine("2. Probar otra tabla");
            Console.WriteLine("0. Salir");
            Console.Write("Elige una opcion: ");
            opcion = Console.ReadLine();
            switch (opcion)
            {
                case "1":
                    MostrarTabla(7);
                    break;
                case "2":
                    Console.Write("Tabla del numero: ");
                    int n = int.Parse(Console.ReadLine() ?? "0");
                    MostrarTabla(n);
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
    static void MostrarTabla(int n)
    {
        for (int i = 1; i <= 10; i++)
        {
            Console.WriteLine($"{n} x {i} = {n * i}");
        }
    }
}
