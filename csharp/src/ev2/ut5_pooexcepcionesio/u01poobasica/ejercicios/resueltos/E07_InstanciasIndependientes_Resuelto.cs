/*
OBJETIVO: Dos objetos Punto independientes; cambia uno y verifica que el otro no cambia. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
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
        Console.WriteLine("3. Probar con otro valor");
        Console.WriteLine("0. Salir");
        
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Dos objetos Punto independientes; cambia uno y verifica que el otro no cambia.");
    }


    static void EjecutarEjercicio()
    {
        Punto p1 = new Punto();
            Punto p2 = new Punto();
            p1.X = 10;
            Console.WriteLine($"p1.X={p1.X}, p2.X={p2.X}");
    }

    static void EjecutarInteractivo()
    {
        Punto p1 = new Punto();
        Punto p2 = new Punto();
        Console.Write("Nuevo valor para p1.X: ");
        if (int.TryParse(Console.ReadLine(), out int x))
        {
            p1.X = x;
            Console.WriteLine($"p1.X={p1.X}, p2.X={p2.X}");
        }
        else
        {
            Console.WriteLine("Valor invalido.");
        }
    }
}


class Punto
{
    public int X { get; set; }
    public int Y { get; set; }
}
