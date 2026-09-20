/*
OBJETIVO: Menu 1=Tabla 5, 2=Par/Impar 4, 0=Salir con do-while.
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
            Console.WriteLine("=== E10 Repaso Integrado Resuelto ===");
            Console.WriteLine("1. Tabla del 5");
            Console.WriteLine("2. Par o impar de 4");
            Console.WriteLine("0. Salir");
            Console.Write("Elige una opcion: ");
            opcion = Console.ReadLine();

            switch (opcion)
            {
                case "1":
                    for (int i = 1; i <= 10; i++)
                    {
                        Console.WriteLine($"5 x {i} = {5 * i}");
                    }
                    break;
                case "2":
                    Console.WriteLine(4 % 2 == 0 ? "Par" : "Impar");
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
