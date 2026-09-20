/*
U01 — try/catch basico.

Cuando una operacion puede fallar en tiempo de ejecucion (parse invalido,
acceso nulo, division...), el bloque try ejecuta el codigo "riesgoso" y
catch captura la excepcion para que el programa no se cierre abruptamente.

OBJETIVO:
  - Envolver codigo peligroso en try { }.
  - Capturar Exception generica en catch y mostrar ex.Message.
  - Ver que el programa continua despues del catch.
  - Contrastar un caso que falla con otro que funciona dentro del mismo try/catch.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U01 try/catch basico ===");
        Console.WriteLine("1. Parse invalido");
        Console.WriteLine("2. Parse valido");
        Console.WriteLine("3. Indice fuera de rango");
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
                    DemoParseInvalido();
                    break;
                case 2:
                    DemoParseValido();
                    break;
                case 3:
                    DemoArrayIndice();
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
    PRIMERA PARTE — Parse que falla: int.Parse("abc") lanza excepcion.
      Sin catch el programa terminaria; con catch mostramos el error y seguimos.
    */
    static void DemoParseInvalido()
    {
        Console.WriteLine("¡DEMO — try/catch con parse invalido!\n");

        try
        {
            int numero = int.Parse("abc");
            Console.WriteLine($"Numero convertido: {numero}");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error capturado: {ex.Message}");
            Console.WriteLine($"Tipo de excepcion: {ex.GetType().Name}");
        }

        Console.WriteLine("El programa sigue ejecutandose tras el catch.");
    }

    /*
    SEGUNDA PARTE — Mismo patron con entrada valida: no entra en catch.
    */
    static void DemoParseValido()
    {
        Console.WriteLine("¡DEMO — try/catch con parse valido!\n");

        try
        {
            int edad = int.Parse("25");
            Console.WriteLine($"Edad leida correctamente: {edad}");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error capturado: {ex.Message}");
        }
    }

    /*
    TERCERA PARTE — Otra operacion riesgosa: indice fuera de rango en array.
      Exception es la clase base: atrapa casi cualquier fallo.
    */
    static void DemoArrayIndice()
    {
        Console.WriteLine("¡DEMO — try/catch con array!\n");

        try
        {
            int[] valores = { 10, 20, 30 };
            Console.WriteLine(valores[5]);
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error capturado: {ex.Message}");
        }
    }
}
