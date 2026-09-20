/*
U01 — Introduccion a List<T>.

OBJETIVO:
  - Crear una List<int> dinamica (crece al agregar elementos).
  - Agregar elementos con Add y consultar cuantos hay con Count.
  - Acceder por indice como en un array: lista[0], lista[1], etc.
  - Comparar List con array: tamano fijo vs tamano variable.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U01 Introduccion a List ===");
        Console.WriteLine("1. Crear y Add");
        Console.WriteLine("2. Acceso por indice");
        Console.WriteLine("3. Lista con valores iniciales");
        Console.WriteLine("4. Modificar por indice");
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
                    DemoCrearYAdd();
                    break;
                case 2:
                    DemoAccesoPorIndice();
                    break;
                case 3:
                    DemoValoresIniciales();
                    break;
                case 4:
                    DemoModificarPorIndice();
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
    PRIMERA PARTE — Crear lista vacia y agregar con Add.
      List<int> numeros = new List<int>(); empieza sin elementos.
      numeros.Add(10); inserta al final y la lista crece sola.
    */
    static void DemoCrearYAdd()
    {
        Console.WriteLine("¡DEMO — Crear y Add!\n");

        List<int> numeros = new List<int>();
        numeros.Add(10);
        numeros.Add(20);
        numeros.Add(30);

        Console.WriteLine("Elementos agregados: 10, 20, 30");
        Console.WriteLine("Count despues de Add: " + numeros.Count);
    }

    /*
    SEGUNDA PARTE — Acceso por indice (igual que array).
      Los indices empiezan en 0. Count indica cuantos elementos hay.
    */
    static void DemoAccesoPorIndice()
    {
        Console.WriteLine("¡DEMO — Acceso por indice!\n");

        List<int> numeros = new List<int>();
        numeros.Add(10);
        numeros.Add(20);
        numeros.Add(30);

        Console.WriteLine("numeros[0] = " + numeros[0]);
        Console.WriteLine("numeros[1] = " + numeros[1]);
        Console.WriteLine("numeros[2] = " + numeros[2]);

        for (int i = 0; i < numeros.Count; i++)
        {
            Console.WriteLine("  Posicion " + i + ": " + numeros[i]);
        }
    }

    /*
    TERCERA PARTE — Inicializacion con valores y mas Add.
      Se puede crear con elementos iniciales: new List<int> { 1, 2, 3 }.
    */
    static void DemoValoresIniciales()
    {
        Console.WriteLine("¡DEMO — Lista con valores iniciales!\n");

        List<string> nombres = new List<string> { "Ana", "Luis" };

        Console.WriteLine("Count inicial: " + nombres.Count);

        nombres.Add("Eva");
        nombres.Add("Pedro");

        Console.WriteLine("Count tras Add: " + nombres.Count);

        foreach (string nombre in nombres)
        {
            Console.WriteLine("  Nombre: " + nombre);
        }
    }

    /*
    CUARTA PARTE — Modificar por indice.
      lista[indice] = valor; reemplaza el elemento en esa posicion.
    */
    static void DemoModificarPorIndice()
    {
        Console.WriteLine("¡DEMO — Modificar por indice!\n");

        List<int> numeros = new List<int>();
        numeros.Add(10);
        numeros.Add(20);
        numeros.Add(30);

        numeros[1] = 99;
        Console.WriteLine("numeros[1] cambiado a 99");

        for (int i = 0; i < numeros.Count; i++)
        {
            Console.WriteLine("  numeros[" + i + "] = " + numeros[i]);
        }
    }
}
