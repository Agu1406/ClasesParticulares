/*
OBJETIVO: Main llama a un metodo void Bienvenida() que imprime un mensaje.
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
            Console.WriteLine("=== E10 Main Saludo Resuelto ===");
            Console.WriteLine("1. Ejecutar ejemplo del enunciado");
            Console.WriteLine("2. Probar con tus datos");
            Console.WriteLine("0. Salir");
            Console.Write("Elige una opcion: ");
            opcion = Console.ReadLine();
            switch (opcion)
            {
                case "1":
                    Bienvenida();
                    break;
                case "2":
                    Bienvenida();
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
    static int LeerEntero(string mensaje)
    {
        Console.Write(mensaje);
        return int.Parse(Console.ReadLine() ?? "0");
    }
    static double LeerDouble(string mensaje)
    {
        Console.Write(mensaje);
        return double.Parse(Console.ReadLine() ?? "0");
    }
    static void Bienvenida()
    {
        Console.WriteLine("Bienvenido al programa");
    }
}
