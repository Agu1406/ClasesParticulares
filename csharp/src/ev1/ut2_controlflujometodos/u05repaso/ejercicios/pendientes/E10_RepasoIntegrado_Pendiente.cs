/*
OBJETIVO: Menu 1=Tabla 5, 2=Par/Impar 4, 0=Salir con do-while.
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
            Console.WriteLine("=== E10 Repaso Integrado Pendiente ===");
            Console.WriteLine("1. Ver lo que debe hacer la opcion Tabla 5");
            Console.WriteLine("2. Ver lo que debe hacer la opcion Par/Impar 4");
            Console.WriteLine("0. Salir");
            Console.Write("Elige una opcion: ");
            opcion = Console.ReadLine();
            switch (opcion)
            {
                case "1":
                    Console.WriteLine("Completa un bucle que muestre la tabla del 5 del 1 al 10.");
                    break;
                case "2":
                    Console.WriteLine("Completa la comprobacion para decidir si 4 es par o impar.");
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
