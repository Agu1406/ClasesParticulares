/*
OBJETIVO: Menu 1=dividir 2=salir; try/catch en opcion dividir. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
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
                    EjecutarMenuDivision();
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
        Console.WriteLine("3. Menu de division interactivo");
        Console.WriteLine("0. Salir");
        
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Menu 1=dividir 2=salir; try/catch en opcion dividir.");
    }


    static void EjecutarEjercicio()
    {
        Console.WriteLine("Demo: division 10 / 0 con try/catch.");
            try
            {
                Console.WriteLine($"Resultado: {10 / 0}");
            }
            catch (DivideByZeroException)
            {
                Console.WriteLine("No se puede dividir entre cero.");
            }
    }

    static void EjecutarMenuDivision()
    {
        while (true)
        {
            Console.WriteLine("1. Dividir  2. Volver");
            Console.Write("Opcion: ");
            string? op = Console.ReadLine();

            if (op == "2")
            {
                break;
            }

            if (op == "1")
            {
                Console.Write("a: ");
                int.TryParse(Console.ReadLine(), out int a);
                Console.Write("b: ");
                int.TryParse(Console.ReadLine(), out int b);
                try
                {
                    Console.WriteLine($"Resultado: {a / b}");
                }
                catch (DivideByZeroException)
                {
                    Console.WriteLine("No se puede dividir entre cero.");
                }
            }
        }
    }
}
