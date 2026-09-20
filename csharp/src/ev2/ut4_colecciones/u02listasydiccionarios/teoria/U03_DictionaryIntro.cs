/*
U03 — Introduccion a Dictionary.

OBJETIVO:
  - Crear Dictionary<string, int> para pares clave-valor.
  - Agregar entradas con Add y con el indexador clave = valor.
  - Leer un valor con el indexador [clave].
  - Consultar de forma segura con TryGetValue y if/else con llaves.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U03 Introduccion a Dictionary ===");
        Console.WriteLine("1. Add y creacion");
        Console.WriteLine("2. Indexador [clave]");
        Console.WriteLine("3. TryGetValue con if/else");
        Console.WriteLine("4. ContainsKey");
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
                    DemoAddYCreacion();
                    break;
                case 2:
                    DemoIndexador();
                    break;
                case 3:
                    DemoTryGetValue();
                    break;
                case 4:
                    DemoContainsKey();
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
    PRIMERA PARTE — Crear diccionario y agregar con Add.
      Dictionary<string, int> edades: clave string, valor int.
      edades.Add("Ana", 20); la clave debe ser unica.
    */
    static void DemoAddYCreacion()
    {
        Console.WriteLine("¡DEMO — Add y creacion!\n");

        Dictionary<string, int> edades = new Dictionary<string, int>();
        edades.Add("Ana", 20);
        edades.Add("Luis", 25);

        Console.WriteLine("Entradas agregadas con Add: Ana->20, Luis->25");
        Console.WriteLine("Count: " + edades.Count);
    }

    /*
    SEGUNDA PARTE — Indexador para escribir y leer.
      edades["Luis"] = 25; agrega o SOBREESCRIBE si la clave ya existe.
      int x = edades["Ana"]; lee el valor asociado a "Ana".
    */
    static void DemoIndexador()
    {
        Console.WriteLine("¡DEMO — Indexador [clave]!\n");

        Dictionary<string, int> edades = new Dictionary<string, int>();
        edades.Add("Ana", 20);
        edades.Add("Luis", 25);

        edades["Eva"] = 22;
        edades["Luis"] = 26;

        Console.WriteLine("Edad de Ana: " + edades["Ana"]);
        Console.WriteLine("Edad de Luis (actualizada): " + edades["Luis"]);
        Console.WriteLine("Edad de Eva: " + edades["Eva"]);
    }

    /*
    TERCERA PARTE — TryGetValue: consulta segura sin excepcion.
      Si la clave existe, devuelve true y el valor en out.
      Si no existe, devuelve false y no lanza error.
    */
    static void DemoTryGetValue()
    {
        Console.WriteLine("¡DEMO — TryGetValue con if/else!\n");

        Dictionary<string, int> edades = new Dictionary<string, int>();
        edades.Add("Ana", 20);
        edades.Add("Luis", 25);
        edades["Eva"] = 22;

        if (edades.TryGetValue("Pedro", out int edadPedro))
        {
            Console.WriteLine("Pedro tiene " + edadPedro + " anos.");
        }
        else
        {
            Console.WriteLine("Pedro no esta en el diccionario.");
        }

        if (edades.TryGetValue("Ana", out int edadAna))
        {
            Console.WriteLine("Ana tiene " + edadAna + " anos.");
        }
        else
        {
            Console.WriteLine("Ana no esta en el diccionario.");
        }

        string claveBuscar = "Luis";

        if (edades.TryGetValue(claveBuscar, out int edadEncontrada))
        {
            Console.WriteLine(claveBuscar + " encontrado: " + edadEncontrada);
        }
        else
        {
            Console.WriteLine(claveBuscar + " no encontrado.");
        }
    }

    /*
    CUARTA PARTE — ContainsKey antes de leer (alternativa a TryGetValue).
    */
    static void DemoContainsKey()
    {
        Console.WriteLine("¡DEMO — ContainsKey!\n");

        Dictionary<string, int> edades = new Dictionary<string, int>();
        edades.Add("Ana", 20);
        edades["Eva"] = 22;

        string clave = "Eva";

        if (edades.ContainsKey(clave))
        {
            Console.WriteLine(clave + " -> " + edades[clave]);
        }
        else
        {
            Console.WriteLine("Clave " + clave + " no existe.");
        }
    }
}
