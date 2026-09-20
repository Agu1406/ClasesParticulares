/*
OBJETIVO: int nota=7; if >=5 Aprobado else Suspenso.
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
            Console.WriteLine("=== E01 Repaso Variables If Resuelto ===");
            Console.WriteLine("1. Ejecutar ejemplo del enunciado");
            Console.WriteLine("2. Probar con otra nota");
            Console.WriteLine("0. Salir");
            Console.Write("Elige una opcion: ");
            opcion = Console.ReadLine();
            switch (opcion)
            {
                case "1":
                    MostrarResultadoNota(7);
                    break;
                case "2":
                    Console.Write("Nota: ");
                    int nota = int.Parse(Console.ReadLine() ?? "0");
                    MostrarResultadoNota(nota);
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
    static void MostrarResultadoNota(int nota)
    {
        if (nota >= 5)
        {
            Console.WriteLine("Aprobado");
        }
        else
        {
            Console.WriteLine("Suspenso");
        }
    }
}
