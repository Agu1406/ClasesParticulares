/*
OBJETIVO: Metodo int Cuadrado(int n); imprime Cuadrado(5).
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
            Console.WriteLine("=== E06 Cuadrado Pendiente ===");
            Console.WriteLine("1. Preparar y revisar el ejercicio");
            Console.WriteLine("0. Salir");
            Console.Write("Elige una opcion: ");
            opcion = Console.ReadLine();
            switch (opcion)
            {
                case "1":
                    Console.WriteLine("Completa el metodo Cuadrado(int n).");
                    Console.WriteLine("Prueba preparada: Cuadrado(5).");
                    Console.WriteLine($"Resultado actual del esqueleto: {Cuadrado(5)}");
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
    static int Cuadrado(int n)
    {
        // TODO: devolver n * n.
        return 0;
    }
}
