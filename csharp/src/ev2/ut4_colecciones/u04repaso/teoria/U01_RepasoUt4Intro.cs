/*
U01 — Repaso UT4: arrays, listas, diccionarios y HashSet.

OBJETIVO:
  - Repasar operaciones basicas con array (suma, recorrido).
  - Usar List<T> para CRUD simple (Add, Remove, Count).
  - Consultar Dictionary con TryGetValue y recorrer pares.
  - Aplicar HashSet para eliminar duplicados en una coleccion.
  - Consolidar recorridos con foreach y llaves { }.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U01 Repaso UT4 ===");
        Console.WriteLine("1. Array");
        Console.WriteLine("2. List");
        Console.WriteLine("3. Dictionary");
        Console.WriteLine("4. HashSet");
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
                    DemoArray();
                    break;
                case 2:
                    DemoList();
                    break;
                case 3:
                    DemoDictionary();
                    break;
                case 4:
                    DemoHashSet();
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
    PRIMERA PARTE — Array: suma y recorrido.
    */
    static void DemoArray()
    {
        Console.WriteLine("¡DEMO — Array!\n");

        int[] nums = { 1, 2, 3, 4, 5 };
        int suma = 0;

        foreach (int n in nums)
        {
            suma += n;
        }

        Console.WriteLine("Array: 1, 2, 3, 4, 5");
        Console.WriteLine("Suma: " + suma);

        for (int i = 0; i < nums.Length; i++)
        {
            Console.WriteLine("  nums[" + i + "] = " + nums[i]);
        }
    }

    /*
    SEGUNDA PARTE — List: agregar, eliminar, ordenar.
    */
    static void DemoList()
    {
        Console.WriteLine("¡DEMO — List!\n");

        List<string> nombres = new List<string> { "Ana", "Luis" };
        nombres.Add("Eva");
        nombres.Add("Pedro");
        nombres.Remove("Luis");

        Console.WriteLine("Count tras Add y Remove: " + nombres.Count);

        foreach (string nombre in nombres)
        {
            Console.WriteLine("  " + nombre);
        }
    }

    /*
    TERCERA PARTE — Dictionary: notas por alumno.
    */
    static void DemoDictionary()
    {
        Console.WriteLine("¡DEMO — Dictionary!\n");

        Dictionary<string, int> notas = new Dictionary<string, int>
        {
            { "Ana", 7 },
            { "Luis", 8 }
        };
        notas["Eva"] = 9;

        foreach (KeyValuePair<string, int> par in notas)
        {
            Console.WriteLine("  " + par.Key + ": " + par.Value);
        }

        if (notas.TryGetValue("Ana", out int notaAna))
        {
            Console.WriteLine("Nota de Ana (TryGetValue): " + notaAna);
        }
        else
        {
            Console.WriteLine("Ana no tiene nota registrada.");
        }
    }

    /*
    CUARTA PARTE — HashSet: tags unicos sin repetir.
    */
    static void DemoHashSet()
    {
        Console.WriteLine("¡DEMO — HashSet!\n");

        string[] tagsEntrada = { "csharp", "dotnet", "csharp", "ut4", "dotnet" };
        HashSet<string> tagsUnicos = new HashSet<string>();

        foreach (string tag in tagsEntrada)
        {
            tagsUnicos.Add(tag);
        }

        Console.WriteLine("Tags recibidos: " + tagsEntrada.Length);
        Console.WriteLine("Tags unicos: " + tagsUnicos.Count);

        foreach (string tag in tagsUnicos)
        {
            Console.WriteLine("  #" + tag);
        }
    }
}
