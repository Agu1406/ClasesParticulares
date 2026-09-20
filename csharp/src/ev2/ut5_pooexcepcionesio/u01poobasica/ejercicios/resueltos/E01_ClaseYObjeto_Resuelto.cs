/*
OBJETIVO: Clase Coche con Marca y Modelo; crea un objeto y muestra sus datos. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
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
        Console.WriteLine("3. Crear coche interactivo");
        Console.WriteLine("0. Salir");
        
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Clase Coche con Marca y Modelo; crea un objeto y muestra sus datos.");
    }


    static void EjecutarEjercicio()
    {
        Coche coche = new Coche();
            coche.Marca = "Toyota";
            coche.Modelo = "Corolla";
            Console.WriteLine($"{coche.Marca} {coche.Modelo}");
    }

    static void EjecutarInteractivo()
    {
        Console.Write("Marca: ");
        string? marca = Console.ReadLine();
        Console.Write("Modelo: ");
        string? modelo = Console.ReadLine();
        Coche coche = new Coche { Marca = marca ?? "", Modelo = modelo ?? "" };
        Console.WriteLine($"{coche.Marca} {coche.Modelo}");
    }
}


class Coche
{
    public string Marca;
    public string Modelo;
}
