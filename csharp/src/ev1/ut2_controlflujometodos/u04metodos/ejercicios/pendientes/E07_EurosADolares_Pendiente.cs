/*
OBJETIVO: Metodo double EurosADolares(double euros); tasa 1.08; imprime conversion de 100.
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
            Console.WriteLine("=== E07 Euros A Dolares Pendiente ===");
            Console.WriteLine("1. Preparar y revisar el ejercicio");
            Console.WriteLine("0. Salir");
            Console.Write("Elige una opcion: ");
            opcion = Console.ReadLine();
            switch (opcion)
            {
                case "1":
                    Console.WriteLine("Completa el metodo EurosADolares(double euros) usando tasa 1.08.");
                    Console.WriteLine("Prueba preparada: EurosADolares(100).");
                    Console.WriteLine($"Resultado actual del esqueleto: {EurosADolares(100)}");
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
    static double EurosADolares(double euros)
    {
        // TODO: devolver euros * 1.08.
        return 0;
    }
}
