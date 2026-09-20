/*
OBJETIVO: Funcion local Media(int a,int b,int c); imprime media de 6,8,10.
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
            Console.WriteLine("=== E04 Repaso Metodo Media Resuelto ===");
            Console.WriteLine("1. Ejecutar ejemplo del enunciado");
            Console.WriteLine("2. Probar con otros valores");
            Console.WriteLine("0. Salir");
            Console.Write("Elige una opcion: ");
            opcion = Console.ReadLine();
            switch (opcion)
            {
                case "1":
                    {
                        double Media(int a, int b, int c) => (a + b + c) / 3.0;
                        Console.WriteLine(Media(6, 8, 10));
                    }
                    break;
                case "2":
                    {
                        Console.Write("Primer numero: ");
                        int a = int.Parse(Console.ReadLine() ?? "0");
                        Console.Write("Segundo numero: ");
                        int b = int.Parse(Console.ReadLine() ?? "0");
                        Console.Write("Tercer numero: ");
                        int c = int.Parse(Console.ReadLine() ?? "0");
                        double Media(int x, int y, int z) => (x + y + z) / 3.0;
                        Console.WriteLine(Media(a, b, c));
                    }
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
}
