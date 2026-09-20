/*
OBJETIVO: Metodo int Potencia(int baseP, int exp); imprime 2 elevado a 5.
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
            Console.WriteLine("=== E09 Potencia Pendiente ===");
            Console.WriteLine("1. Preparar y revisar el ejercicio");
            Console.WriteLine("0. Salir");
            Console.Write("Elige una opcion: ");
            opcion = Console.ReadLine();
            switch (opcion)
            {
                case "1":
                    Console.WriteLine("Completa el metodo Potencia(int baseP, int exp).");
                    Console.WriteLine("Prueba preparada: Potencia(2, 5).");
                    Console.WriteLine($"Resultado actual del esqueleto: {Potencia(2, 5)}");
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
    static int Potencia(int baseP, int exp)
    {
        // TODO: usar un bucle para multiplicar la base tantas veces como indique exp.
        return 0;
    }
}
