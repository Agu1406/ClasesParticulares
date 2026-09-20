/*
OBJETIVO: Foreach letras de "C#".
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
            Console.WriteLine("=== E09 Repaso String Bucle Resuelto ===");
            Console.WriteLine("1. Ejecutar ejemplo con C#");
            Console.WriteLine("2. Probar con otro texto");
            Console.WriteLine("0. Salir");
            Console.Write("Elige una opcion: ");
            opcion = Console.ReadLine();
            switch (opcion)
            {
                case "1":
                    MostrarCaracteres("C#");
                    break;
                case "2":
                    Console.Write("Texto: ");
                    string texto = Console.ReadLine() ?? "";
                    MostrarCaracteres(texto);
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
    static void MostrarCaracteres(string texto)
    {
        foreach (char c in texto)
        {
            Console.WriteLine(c);
        }
    }
}
