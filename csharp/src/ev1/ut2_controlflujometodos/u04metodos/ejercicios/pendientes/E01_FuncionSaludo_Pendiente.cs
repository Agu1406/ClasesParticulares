/*
OBJETIVO: Metodo void Saludar(string nombre); llamalo dos veces.
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
            Console.WriteLine("=== E01 Funcion Saludo Pendiente ===");
            Console.WriteLine("1. Preparar y revisar el ejercicio");
            Console.WriteLine("0. Salir");
            Console.Write("Elige una opcion: ");
            opcion = Console.ReadLine();
            switch (opcion)
            {
                case "1":
                    Console.WriteLine("Completa el metodo Saludar(string nombre) y usalo dos veces.");
                    Console.WriteLine("Prueba preparada: Saludar(\"Luis\") y Saludar(\"Sara\").");
                    Saludar("Luis");
                    Saludar("Sara");
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
    static void Saludar(string nombre)
    {
        Console.WriteLine($"TODO: completar Saludar para mostrar un saludo a {nombre}.");
    }
}
