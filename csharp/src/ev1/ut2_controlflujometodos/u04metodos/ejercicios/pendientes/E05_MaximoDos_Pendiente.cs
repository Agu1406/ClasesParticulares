/*
OBJETIVO: Metodo int Maximo(int a, int b); imprime Maximo(12, 9).
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
            Console.WriteLine("=== E05 Maximo Dos Pendiente ===");
            Console.WriteLine("1. Preparar y revisar el ejercicio");
            Console.WriteLine("0. Salir");
            Console.Write("Elige una opcion: ");
            opcion = Console.ReadLine();
            switch (opcion)
            {
                case "1":
                    Console.WriteLine("Completa el metodo Maximo(int a, int b).");
                    Console.WriteLine("Prueba preparada: Maximo(12, 9).");
                    Console.WriteLine($"Resultado actual del esqueleto: {Maximo(12, 9)}");
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
    static int Maximo(int a, int b)
    {
        // TODO: devolver el mayor de los dos numeros.
        return 0;
    }
}
