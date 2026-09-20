/*
OBJETIVO: Repaso: throw ArgumentException si nota fuera de rango 0..10. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
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
        Console.WriteLine("3. Validar nota introducida");
        Console.WriteLine("0. Salir");
        
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Repaso: throw ArgumentException si nota fuera de rango 0..10.");
    }


    static void EjecutarEjercicio()
    {
        try
            {
                ValidarNota(11);
            }
            catch (ArgumentException ex)
            {
                Console.WriteLine(ex.Message);
            }
    }

    static void EjecutarInteractivo()
    {
        Console.Write("Nota: ");
        if (double.TryParse(Console.ReadLine(), out double nota))
        {
            try
            {
                ValidarNota(nota);
            }
            catch (ArgumentException ex)
            {
                Console.WriteLine(ex.Message);
            }
        }
        else
        {
            Console.WriteLine("Nota invalida.");
        }
    }

    static void ValidarNota(double nota)
    {
        if (nota < 0 || nota > 10)
        {
            throw new ArgumentException("La nota debe estar entre 0 y 10.");
        }
        Console.WriteLine($"Nota valida: {nota}");
    }
}
