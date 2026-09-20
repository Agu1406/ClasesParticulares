/*
OBJETIVO: Repaso: leer "alumnos.txt" y mostrar cada nombre. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void Main()
    {
        using System.IO;

        int opcion;

        do
        {
            ImprimirMenu();
            Console.Write("Introduce una opcion -> ");
            opcion = int.Parse(Console.ReadLine()!);

            switch (opcion)
            {
                case 1:
                    EjecutarEjercicio();
                    break;
                case 2:
                    MostrarObjetivo();
                    break;
                case 0:
                    Console.WriteLine("Saliendo...");
                    break;
                default:
                    Console.WriteLine("Opcion no valida. Intenta de nuevo.");
                    break;
            }

            if (opcion != 0)
            {
                Console.WriteLine();
                Console.WriteLine("Pulsa ENTER para continuar...");
                Console.ReadLine();
                Console.Clear();
            }
        } while (opcion != 0);
    }

    static void ImprimirMenu()
    {
        Console.WriteLine("=== EJERCICIO ===");
        Console.WriteLine("1. Ejecutar solucion");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
        
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Repaso: leer ""alumnos.txt"" y mostrar cada nombre.");
    }


    static void EjecutarEjercicio()
    {
        File.WriteAllLines("alumnos.txt", new[] { "Ana", "Luis", "Sara" });
            foreach (string nombre in File.ReadAllLines("alumnos.txt"))
            {
                Console.WriteLine(nombre);
            }
    }
}
