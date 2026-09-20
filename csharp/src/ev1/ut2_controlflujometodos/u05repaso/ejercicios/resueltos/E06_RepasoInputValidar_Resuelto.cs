/*
OBJETIVO: Lee entero; si es negativo muestra Error, si no OK.
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
            Console.WriteLine("=== E06 Repaso Input Validar Resuelto ===");
            Console.WriteLine("1. Ejecutar validacion");
            Console.WriteLine("0. Salir");
            Console.Write("Elige una opcion: ");
            opcion = Console.ReadLine();
            switch (opcion)
            {
                case "1":
                    Console.Write("Numero: ");
                    int n = int.Parse(Console.ReadLine() ?? "0");
                    if (n < 0)
                    {
                        Console.WriteLine("Error");
                    }
                    else
                    {
                        Console.WriteLine("OK");
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
