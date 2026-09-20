/*
OBJETIVO: int nota=7; if >=5 Aprobado else Suspenso.
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
            Console.WriteLine("=== E01 Repaso Variables If Pendiente ===");
            Console.WriteLine("1. Revisar el ejercicio guiado");
            Console.WriteLine("0. Salir");
            Console.Write("Elige una opcion: ");
            opcion = Console.ReadLine();
            switch (opcion)
            {
                case "1":
                    Console.WriteLine("Declara int nota = 7 y completa el if/else.");
                    Console.WriteLine("Si nota es 5 o mayor, debe mostrar Aprobado.");
                    Console.WriteLine("En caso contrario, debe mostrar Suspenso.");
                    int nota = 7;
                    Console.WriteLine($"Valor de prueba preparado: nota = {nota}");
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
