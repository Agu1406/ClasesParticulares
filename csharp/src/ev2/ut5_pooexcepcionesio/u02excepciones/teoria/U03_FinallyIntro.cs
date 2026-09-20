/*
U03 — Bloque finally.

finally se ejecuta SIEMPRE: haya excepcion o no, y tambien si catch la manejo.
Sirve para liberar recursos, cerrar ficheros o mostrar mensajes de cierre
que no deben omitirse aunque algo falle en try.

OBJETIVO:
  - Usar try / catch / finally en el mismo flujo.
  - Comprobar que finally corre tras un error capturado.
  - Comprobar que finally corre tambien cuando try termina bien.
  - Entender finally como codigo de "limpieza" garantizado.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U03 Bloque finally ===");
        Console.WriteLine("1. Finally tras error");
        Console.WriteLine("2. Finally sin error");
        Console.WriteLine("3. Finally como cierre");
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
                    DemoFinallyTrasError();
                    break;
                case 2:
                    DemoFinallySinError();
                    break;
                case 3:
                    DemoFinallyComoCierre();
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
    PRIMERA PARTE — Error en try: catch se ejecuta y luego finally.
    */
    static void DemoFinallyTrasError()
    {
        Console.WriteLine("¡DEMO — Finally tras error!\n");

        try
        {
            Console.WriteLine("Entrando en try...");
            int a = 10;
            int b = 0;
            int resultado = a / b;
            Console.WriteLine($"Resultado: {resultado}");
        }
        catch (DivideByZeroException)
        {
            Console.WriteLine("Division entre cero detectada en catch.");
        }
        finally
        {
            Console.WriteLine("Bloque finally: siempre se ejecuta (tras error).");
        }
    }

    /*
    SEGUNDA PARTE — try sin error: finally igualmente se ejecuta al final.
    */
    static void DemoFinallySinError()
    {
        Console.WriteLine("¡DEMO — Finally sin error!\n");

        try
        {
            Console.WriteLine("Entrando en try sin fallos...");
            int suma = 5 + 3;
            Console.WriteLine($"Suma correcta: {suma}");
        }
        catch (DivideByZeroException)
        {
            Console.WriteLine("Division entre cero detectada en catch.");
        }
        finally
        {
            Console.WriteLine("Bloque finally: siempre se ejecuta (sin error).");
        }
    }

    /*
    TERCERA PARTE — Simular "cierre de operacion" en finally.
      En programas reales aqui cerrarias ficheros o conexiones.
    */
    static void DemoFinallyComoCierre()
    {
        Console.WriteLine("¡DEMO — Finally como cierre!\n");

        bool operacionCompletada = false;

        try
        {
            int dato = int.Parse("42");
            operacionCompletada = true;
            Console.WriteLine($"Operacion OK con dato {dato}");
        }
        catch (FormatException)
        {
            Console.WriteLine("No se pudo completar la operacion.");
        }
        finally
        {
            if (operacionCompletada)
            {
                Console.WriteLine("Finally: liberando recursos (demo).");
            }
            else
            {
                Console.WriteLine("Finally: limpieza tras fallo (demo).");
            }
        }
    }
}
