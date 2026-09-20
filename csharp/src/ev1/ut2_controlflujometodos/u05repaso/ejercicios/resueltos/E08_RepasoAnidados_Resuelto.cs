/*
OBJETIVO: Nota 8: anidados SB/NT/AP/SS.
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
            Console.WriteLine("=== E08 Repaso Anidados Resuelto ===");
            Console.WriteLine("1. Ejecutar ejemplo con nota 8");
            Console.WriteLine("2. Probar con otra nota");
            Console.WriteLine("0. Salir");
            Console.Write("Elige una opcion: ");
            opcion = Console.ReadLine();
            switch (opcion)
            {
                case "1":
                    MostrarCalificacion(8);
                    break;
                case "2":
                    Console.Write("Nota: ");
                    int nota = int.Parse(Console.ReadLine() ?? "0");
                    MostrarCalificacion(nota);
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
    static void MostrarCalificacion(int nota)
    {
        if (nota >= 5)
        {
            if (nota >= 9)
            {
                Console.WriteLine("SB");
            }
            else if (nota >= 7)
            {
                Console.WriteLine("NT");
            }
            else
            {
                Console.WriteLine("AP");
            }
        }
        else
        {
            Console.WriteLine("SS");
        }
    }
}
