/*
OBJETIVO: Metodo double AreaTriangulo(double baseT, double altura); imprime area de 10 y 4.
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
            Console.WriteLine("=== E03 Area Triangulo Pendiente ===");
            Console.WriteLine("1. Preparar y revisar el ejercicio");
            Console.WriteLine("0. Salir");
            Console.Write("Elige una opcion: ");
            opcion = Console.ReadLine();
            switch (opcion)
            {
                case "1":
                    Console.WriteLine("Completa el metodo AreaTriangulo(double baseT, double altura).");
                    Console.WriteLine("Prueba preparada: AreaTriangulo(10, 4).");
                    Console.WriteLine($"Resultado actual del esqueleto: {AreaTriangulo(10, 4)}");
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
    static double AreaTriangulo(double baseT, double altura)
    {
        // TODO: devolver baseT * altura / 2.
        return 0;
    }
}
