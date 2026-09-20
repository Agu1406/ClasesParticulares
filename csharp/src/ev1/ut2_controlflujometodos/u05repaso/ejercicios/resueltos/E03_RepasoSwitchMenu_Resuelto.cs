/*
OBJETIVO: Switch con opcion 1-3: Nuevo, Abrir, Salir.
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
            Console.WriteLine("=== E03 Repaso Switch Menu Resuelto ===");
            Console.WriteLine("1. Ejecutar ejemplo con opcion 2");
            Console.WriteLine("2. Elegir una opcion del switch");
            Console.WriteLine("0. Salir");
            Console.Write("Elige una opcion: ");
            opcion = Console.ReadLine();
            switch (opcion)
            {
                case "1":
                    EjecutarSwitch(2);
                    break;
                case "2":
                    Console.Write("Opcion interna (1-3): ");
                    int opInterna = int.Parse(Console.ReadLine() ?? "0");
                    EjecutarSwitch(opInterna);
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
    static void EjecutarSwitch(int op)
    {
        switch (op)
        {
            case 1:
                Console.WriteLine("Nuevo");
                break;
            case 2:
                Console.WriteLine("Abrir");
                break;
            case 3:
                Console.WriteLine("Salir");
                break;
            default:
                Console.WriteLine("Invalida");
                break;
        }
    }
}
