/*
OBJETIVO: Funcion local Media(int a,int b,int c); imprime media de 6,8,10.
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
            Console.WriteLine("=== E04 Repaso Metodo Media Pendiente ===");
            Console.WriteLine("1. Revisar el ejercicio guiado");
            Console.WriteLine("0. Salir");
            Console.Write("Elige una opcion: ");
            opcion = Console.ReadLine();
            switch (opcion)
            {
                case "1":
                    Console.WriteLine("Completa una funcion local Media(int a, int b, int c).");
                    Console.WriteLine("Despues muestra el resultado de Media(6, 8, 10).");
                    double Media(int a, int b, int c)
                    {
                        // TODO: devolver la media de los tres valores.
                        return 0;
                    }
                    Console.WriteLine($"Resultado actual del esqueleto: {Media(6, 8, 10)}");
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
