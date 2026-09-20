/*
OBJETIVO: Crear fichero "salida.txt" con File.WriteAllText y un mensaje inicial. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
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
                case 3:
                    EjecutarInteractivo();
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
        Console.WriteLine("3. Crear con nombre y texto personalizados");
        Console.WriteLine("0. Salir");
        
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Crear fichero ""salida.txt"" con File.WriteAllText y un mensaje inicial.");
    }


    static void EjecutarEjercicio()
    {
        File.WriteAllText("salida.txt", "Archivo creado");
            Console.WriteLine("salida.txt creado correctamente.");
    }

    static void EjecutarInteractivo()
    {
        Console.Write("Nombre fichero: ");
        string? nombre = Console.ReadLine();
        Console.Write("Contenido: ");
        string? contenido = Console.ReadLine();
        if (!string.IsNullOrWhiteSpace(nombre))
        {
            File.WriteAllText(nombre, contenido ?? "");
            Console.WriteLine($"{nombre} creado correctamente.");
        }
    }
}
