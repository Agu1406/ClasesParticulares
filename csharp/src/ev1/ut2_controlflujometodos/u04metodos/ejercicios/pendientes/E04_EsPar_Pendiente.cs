/*
OBJETIVO: Metodo bool EsPar(int n); imprime EsPar(8) y EsPar(7).
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
            Console.WriteLine("=== E04 Es Par Pendiente ===");
            Console.WriteLine("1. Preparar y revisar el ejercicio");
            Console.WriteLine("0. Salir");
            Console.Write("Elige una opcion: ");
            opcion = Console.ReadLine();
            switch (opcion)
            {
                case "1":
                    Console.WriteLine("Completa el metodo EsPar(int n).");
                    Console.WriteLine("Pruebas preparadas: EsPar(8) y EsPar(7).");
                    Console.WriteLine($"EsPar(8): {EsPar(8)}");
                    Console.WriteLine($"EsPar(7): {EsPar(7)}");
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
    static bool EsPar(int n)
    {
        // TODO: devolver true si n es par.
        return false;
    }
}
