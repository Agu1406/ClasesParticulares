/*
U04 — Lanzar excepciones con throw.

Ademas de capturar errores ajenos, puedes signalizar condiciones invalidas
con throw new TipoExcepcion("mensaje"). Quien llame a tu metodo puede
decidir capturarla o dejar que suba hasta un catch superior.

OBJETIVO:
  - Validar parametros con if { } y lanzar ArgumentException.
  - Capturar la excepcion en Main y mostrar el mensaje.
  - Contrastar llamada valida (sin throw) con llamada invalida.
  - Usar throw para documentar reglas de negocio en metodos propios.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U04 Lanzar excepciones con throw ===");
        Console.WriteLine("1. Edad invalida");
        Console.WriteLine("2. Edad valida");
        Console.WriteLine("3. Validar nota");
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
                    DemoEdadInvalida();
                    break;
                case 2:
                    DemoEdadValida();
                    break;
                case 3:
                    DemoValidarNota();
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

    static void ValidarEdad(int edad)
    {
        if (edad < 0)
        {
            throw new ArgumentException("La edad no puede ser negativa.");
        }
        if (edad > 120)
        {
            throw new ArgumentException("La edad no parece realista (mayor de 120).");
        }
        Console.WriteLine($"Edad valida: {edad}");
    }

    static void ValidarNota(int nota)
    {
        if (nota < 0)
        {
            throw new ArgumentException("La nota no puede ser menor que 0.");
        }
        if (nota > 10)
        {
            throw new ArgumentException("La nota no puede ser mayor que 10.");
        }
        Console.WriteLine($"Nota valida: {nota}");
    }

    /*
    PRIMERA PARTE — Edad negativa: ValidarEdad lanza ArgumentException.
    */
    static void DemoEdadInvalida()
    {
        Console.WriteLine("¡DEMO — Throw con edad invalida!\n");

        try
        {
            ValidarEdad(-5);
        }
        catch (ArgumentException ex)
        {
            Console.WriteLine($"Error capturado: {ex.Message}");
        }
    }

    /*
    SEGUNDA PARTE — Edad valida: el metodo termina sin lanzar nada.
    */
    static void DemoEdadValida()
    {
        Console.WriteLine("¡DEMO — Throw con edad valida!\n");

        try
        {
            ValidarEdad(18);
        }
        catch (ArgumentException ex)
        {
            Console.WriteLine($"Error capturado: {ex.Message}");
        }
    }

    /*
    TERCERA PARTE — Validar nota fuera de rango con otro mensaje personalizado.
    */
    static void DemoValidarNota()
    {
        Console.WriteLine("¡DEMO — Throw en validar nota!\n");

        try
        {
            ValidarNota(11);
        }
        catch (ArgumentException ex)
        {
            Console.WriteLine($"Error capturado: {ex.Message}");
        }

        try
        {
            ValidarNota(7);
        }
        catch (ArgumentException ex)
        {
            Console.WriteLine($"Error capturado: {ex.Message}");
        }
    }
}
