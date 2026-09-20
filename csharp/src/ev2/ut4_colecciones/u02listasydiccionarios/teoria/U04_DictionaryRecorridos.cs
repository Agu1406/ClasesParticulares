/*
U04 — Recorrer un Dictionary.

OBJETIVO:
  - Iterar con foreach sobre KeyValuePair<TKey, TValue>.
  - Mostrar cada par clave -> valor en consola.
  - Recorrer solo claves (Keys) o solo valores (Values).
  - Usar llaves { } en todos los foreach.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U04 Recorridos Dictionary ===");
        Console.WriteLine("1. foreach KeyValuePair");
        Console.WriteLine("2. Solo claves (Keys)");
        Console.WriteLine("3. Solo valores (Values)");
        Console.WriteLine("4. Logica en el recorrido");
        Console.WriteLine("5. Resumen con var");
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
                    DemoKeyValuePair();
                    break;
                case 2:
                    DemoSoloClaves();
                    break;
                case 3:
                    DemoSoloValores();
                    break;
                case 4:
                    DemoLogicaRecorrido();
                    break;
                case 5:
                    DemoResumenVar();
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

    static Dictionary<string, int> CrearNotas()
    {
        return new Dictionary<string, int>
        {
            { "Matematicas", 7 },
            { "Lengua", 8 },
            { "Historia", 6 }
        };
    }

    /*
    PRIMERA PARTE — foreach sobre KeyValuePair.
      Cada elemento es un par: par.Key (asignatura) y par.Value (nota).
    */
    static void DemoKeyValuePair()
    {
        Console.WriteLine("¡DEMO — foreach KeyValuePair!\n");

        Dictionary<string, int> notas = CrearNotas();

        foreach (KeyValuePair<string, int> par in notas)
        {
            Console.WriteLine("  " + par.Key + " -> " + par.Value);
        }
    }

    /*
    SEGUNDA PARTE — Recorrer solo claves con notas.Keys.
      Util cuando necesitas listar nombres sin el valor asociado.
    */
    static void DemoSoloClaves()
    {
        Console.WriteLine("¡DEMO — Solo claves (Keys)!\n");

        Dictionary<string, int> notas = CrearNotas();

        foreach (string asignatura in notas.Keys)
        {
            Console.WriteLine("  Asignatura: " + asignatura);
        }
    }

    /*
    TERCERA PARTE — Recorrer solo valores con notas.Values.
      Los valores pueden repetirse; las claves no.
    */
    static void DemoSoloValores()
    {
        Console.WriteLine("¡DEMO — Solo valores (Values)!\n");

        Dictionary<string, int> notas = CrearNotas();

        foreach (int nota in notas.Values)
        {
            Console.WriteLine("  Nota: " + nota);
        }
    }

    /*
    CUARTA PARTE — Recorrido con logica: contar aprobados y mostrar suspensos.
    */
    static void DemoLogicaRecorrido()
    {
        Console.WriteLine("¡DEMO — Logica en el recorrido!\n");

        Dictionary<string, int> notas = CrearNotas();
        int aprobados = 0;

        foreach (KeyValuePair<string, int> par in notas)
        {
            if (par.Value >= 5)
            {
                aprobados++;
                Console.WriteLine("  Aprobado: " + par.Key + " (" + par.Value + ")");
            }
            else
            {
                Console.WriteLine("  Suspenso: " + par.Key + " (" + par.Value + ")");
            }
        }

        Console.WriteLine("Total aprobados: " + aprobados);
    }

    /*
    QUINTA PARTE — Desestructuracion en foreach (var par).
    */
    static void DemoResumenVar()
    {
        Console.WriteLine("¡DEMO — Resumen ordenado!\n");

        Dictionary<string, int> notas = CrearNotas();

        foreach (var par in notas)
        {
            Console.WriteLine("  [" + par.Key + "] = " + par.Value);
        }
    }
}
