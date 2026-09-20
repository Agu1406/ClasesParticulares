/*
U02 — catch especifico (FormatException, DivideByZeroException).

Puedes encadenar varios catch. C# ejecuta el PRIMERO cuyo tipo coincide
con la excepcion lanzada. Lo mas concreto va antes; Exception generica al final.

OBJETIVO:
  - Capturar FormatException cuando el texto no es un numero valido.
  - Capturar DivideByZeroException al dividir entre cero.
  - Ordenar catch de mas especifico a mas general.
  - Probar dos escenarios distintos en demos separadas.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U02 catch especifico ===");
        Console.WriteLine("1. Division entre cero");
        Console.WriteLine("2. Formato invalido");
        Console.WriteLine("3. Sin errores");
        Console.WriteLine("0. Salir");
    }

    static void Main()
    {
        int opcion;
        do
        {
            ImprimirMenu();
            Console.Write("Introduce una opcion -> ");
            opcion = int.Parse(Console.ReadLine()!);
            Console.WriteLine();

            switch (opcion)
            {
                case 1:
                    DemoDivisionCero();
                    break;
                case 2:
                    DemoFormatoInvalido();
                    break;
                case 3:
                    DemoSinErrores();
                    break;
                case 0:
                    Console.WriteLine("Saliendo...");
                    break;
                default:
                    Console.WriteLine("Opcion no valida.");
                    break;
            }

            Console.WriteLine();
        } while (opcion != 0);
    }

    /*
    PRIMERA PARTE — Division entre cero: DivideByZeroException.
      int.Parse("12") funciona; el fallo ocurre en a / b con b = 0.
    */
    static void DemoDivisionCero()
    {
        Console.WriteLine("¡DEMO — Division entre cero!\n");

        try
        {
            int a = int.Parse("12");
            int b = 0;
            Console.WriteLine($"Resultado: {a / b}");
        }
        catch (FormatException)
        {
            Console.WriteLine("Formato invalido al convertir texto a numero.");
        }
        catch (DivideByZeroException)
        {
            Console.WriteLine("No se puede dividir entre cero.");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Otro error: {ex.Message}");
        }
    }

    /*
    SEGUNDA PARTE — Texto no numerico: FormatException.
      El orden importa: si Exception fuera primero, atraparia todo y los demas no servirian.
    */
    static void DemoFormatoInvalido()
    {
        Console.WriteLine("¡DEMO — Formato invalido!\n");

        try
        {
            int valor = int.Parse("doce");
            Console.WriteLine($"Valor: {valor}");
        }
        catch (FormatException)
        {
            Console.WriteLine("Formato invalido: el texto no representa un entero.");
        }
        catch (DivideByZeroException)
        {
            Console.WriteLine("No se puede dividir entre cero.");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Otro error: {ex.Message}");
        }
    }

    /*
    TERCERA PARTE — Caso correcto: ningun catch se ejecuta.
    */
    static void DemoSinErrores()
    {
        Console.WriteLine("¡DEMO — Sin errores!\n");

        try
        {
            int x = int.Parse("8");
            int y = 2;
            Console.WriteLine($"Division correcta: {x / y}");
        }
        catch (FormatException)
        {
            Console.WriteLine("Formato invalido al convertir texto a numero.");
        }
        catch (DivideByZeroException)
        {
            Console.WriteLine("No se puede dividir entre cero.");
        }
    }
}
