/*
U02 — Operaciones comunes con List.

OBJETIVO:
  - Comprobar si un valor existe con Contains (y equivalente manual).
  - Eliminar un elemento con Remove (y equivalente manual).
  - Ordenar la lista con Sort (y equivalente manual: burbuja).
  - Buscar el primer elemento que cumpla una condicion con Find.
  - Recorrer listas e imprimir posiciones.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U02 Operaciones con List ===");
        Console.WriteLine("1. Contains");
        Console.WriteLine("2. Remove");
        Console.WriteLine("3. Sort");
        Console.WriteLine("4. Find");
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
                    DemoContains();
                    break;
                case 2:
                    DemoRemove();
                    break;
                case 3:
                    DemoSort();
                    break;
                case 4:
                    DemoFind();
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
    PRIMERA PARTE — Contains: submenu con busqueda manual vs Contains().
    */
    static void DemoContains()
    {
        List<int> listaNumeros = new List<int> { 1, 3, 5, 2, 4 };
        bool continuar = true;
        int opcion;

        while (continuar)
        {
            Console.Write(
                "\n¿Cual funcion quieres usar?\n" +
                "[1] - Buscar sin \"Contains();\"\n" +
                "[2] - Buscar con \"Contains();\"\n" +
                "[3] - ¡Volver al menu principal!\n" +
                "\nIntroduce una opcion -> "
            );

            opcion = int.Parse(Console.ReadLine()!);

            switch (opcion)
            {
                case 1:
                    BuscarSinContains(listaNumeros);
                    break;
                case 2:
                    BuscarConContains(listaNumeros);
                    break;
                case 3:
                    Console.WriteLine("...Volviendo al menu principal...\n");
                    continuar = false;
                    break;
                default:
                    Console.WriteLine("\n¡Opcion no valida! Intentalo de nuevo.\n");
                    break;
            }
        }
    }

    /// <summary>
    /// Usa Contains() para verificar si un elemento existe en la lista.
    /// </summary>
    static void BuscarConContains(List<int> listaNumeros)
    {
        Console.Write("Introduce el numero que estas buscando -> ");
        int numeroBuscado = int.Parse(Console.ReadLine()!);
        Console.WriteLine();

        bool encontrado = listaNumeros.Contains(numeroBuscado);
        Console.WriteLine(encontrado
            ? $"¡El numero {numeroBuscado} se encuentra en la lista!"
            : $"¡El numero {numeroBuscado} no se encuentra en la lista!");
    }

    /// <summary>
    /// Busqueda manual equivalente a Contains: recorre con for y compara.
    /// </summary>
    static void BuscarSinContains(List<int> listaNumeros)
    {
        Console.Write("Introduce el numero que estas buscando -> ");
        int numeroBuscado = int.Parse(Console.ReadLine()!);
        Console.WriteLine();

        int posicionEncontrada = -1;

        for (int posicion = 0; posicion < listaNumeros.Count; posicion++)
        {
            if (listaNumeros[posicion] == numeroBuscado)
            {
                posicionEncontrada = posicion;
            }
        }

        if (posicionEncontrada >= 0)
        {
            Console.WriteLine($"¡El numero \"{numeroBuscado}\" se encuentra en la posicion [{posicionEncontrada}]!");
        }
        else
        {
            Console.WriteLine($"¡El numero \"{numeroBuscado}\" no se encuentra en ninguna posicion de la lista!");
        }
    }

    /*
    SEGUNDA PARTE — Remove: submenu con eliminacion manual vs Remove().
    */
    static void DemoRemove()
    {
        List<string> listaNombres1 = new List<string> { "Javier", "Agustin", "Kim", "Pedro" };
        List<string> listaNombres2 = new List<string> { "Javier", "Agustin", "Kim", "Pedro" };
        bool continuar = true;
        int opcion;

        while (continuar)
        {
            Console.Write(
                "\n¿Cual funcion quieres usar?\n" +
                "[1] - Eliminar X dato sin \"Remove();\"\n" +
                "[2] - Eliminar X dato con \"Remove();\"\n" +
                "[3] - ¡Volver al menu principal!\n" +
                "\nIntroduce una opcion -> "
            );

            opcion = int.Parse(Console.ReadLine()!);

            switch (opcion)
            {
                case 1:
                    EliminarSinRemove(listaNombres1);
                    break;
                case 2:
                    EliminarConRemove(listaNombres2);
                    break;
                case 3:
                    Console.WriteLine("...Volviendo al menu principal...\n");
                    continuar = false;
                    break;
                default:
                    Console.WriteLine("\n¡Opcion no valida! Intentalo de nuevo.\n");
                    break;
            }
        }
    }

    static void EliminarConRemove(List<string> listaNombres)
    {
        string nombre = "";
        bool valido = false;

        while (!valido)
        {
            Console.Write("Introduce el nombre que deseas eliminar -> ");
            nombre = Console.ReadLine()!;
            Console.WriteLine();

            if (listaNombres.Contains(nombre))
            {
                valido = true;
            }
            else
            {
                Console.WriteLine("¡Error! Ese nombre no existe en la lista, verificalo e intentalo de nuevo.");
            }
        }

        Console.WriteLine("¡Lista antes de usar \"Remove()\"!");
        ImprimirListaStrings(listaNombres);

        listaNombres.Remove(nombre);

        Console.WriteLine("¡Lista despues de usar \"Remove()\"!");
        ImprimirListaStrings(listaNombres);
    }

    static void EliminarSinRemove(List<string> listaNombres)
    {
        bool invalido = true;
        string nombre = "";
        ImprimirListaStrings(listaNombres);

        while (invalido)
        {
            Console.Write("Introduce el nombre que deseas eliminar -> ");
            nombre = Console.ReadLine()!;
            Console.WriteLine();

            if (listaNombres.Contains(nombre))
            {
                invalido = false;
            }
            else
            {
                Console.WriteLine("¡Error! Ese nombre no existe en la lista, verificalo e intentalo de nuevo.");
            }
        }

        int posicionBorrado = BuscarElementoStringLista(listaNombres, nombre);

        if (posicionBorrado != -1)
        {
            // Pedagogico: "borrar" dejando null (Remove() si compacta la lista).
            listaNombres[posicionBorrado] = null!;
            ImprimirListaStrings(listaNombres);
            Console.WriteLine("\n¡Nombre eliminado exitosamente de la lista!\n");
        }
    }

    static int BuscarElementoStringLista(List<string> lista, string cadena)
    {
        int posicionEncontrada = -1;

        for (int posicion = 0; posicion < lista.Count; posicion++)
        {
            if (lista[posicion] != null && lista[posicion].Equals(cadena))
            {
                posicionEncontrada = posicion;
            }
        }

        return posicionEncontrada;
    }

    static void ImprimirListaStrings(List<string> lista)
    {
        Console.WriteLine("¡Imprimiendo lista!");
        for (int posicion = 0; posicion < lista.Count; posicion++)
        {
            Console.WriteLine($"N.º[{posicion + 1}] - {lista[posicion]}");
        }
    }

    static void ImprimirListaInts(List<int> lista)
    {
        Console.WriteLine("¡Imprimiendo lista!");
        for (int posicion = 0; posicion < lista.Count; posicion++)
        {
            Console.WriteLine($"N.º[{posicion + 1}] - {lista[posicion]}");
        }
    }

    /*
    TERCERA PARTE — Sort: submenu con burbuja manual vs Sort().
    */
    static void DemoSort()
    {
        List<string> listaNombres1 = new List<string> { "Javier", "Agustin", "Kim", "Pedro" };
        List<string> listaNombres2 = new List<string> { "Javier", "Agustin", "Kim", "Pedro" };
        List<int> listaNumeros1 = new List<int> { 2, 4, 6, 1, 3, 5 };
        List<int> listaNumeros2 = new List<int> { 2, 4, 6, 1, 3, 5 };
        bool continuar = true;
        int opcion;

        while (continuar)
        {
            Console.Write(
                "\n¿Cual funcion quieres usar?\n" +
                "[1] - Ordenar lista sin \"Sort();\"\n" +
                "[2] - Ordenar lista con \"Sort();\"\n" +
                "[3] - ¡Volver al menu principal!\n" +
                "\nIntroduce una opcion -> "
            );

            opcion = int.Parse(Console.ReadLine()!);

            switch (opcion)
            {
                case 1:
                    OrdenarSinSort(listaNombres1, listaNumeros1);
                    break;
                case 2:
                    OrdenarConSort(listaNombres2, listaNumeros2);
                    break;
                case 3:
                    Console.WriteLine("...Volviendo al menu principal...\n");
                    continuar = false;
                    break;
                default:
                    Console.WriteLine("\n¡Opcion no valida! Intentalo de nuevo.\n");
                    break;
            }
        }
    }

    /// <summary>
    /// Ordena nombres y numeros con el metodo de la burbuja (sin Sort).
    /// </summary>
    static void OrdenarSinSort(List<string> listaNombres, List<int> listaNumeros)
    {
        Console.WriteLine("¡Lista de nombres ANTES de ordenar!");
        ImprimirListaStrings(listaNombres);

        for (int i = 0; i < listaNombres.Count - 1; i++)
        {
            for (int j = 0; j < listaNombres.Count - 1 - i; j++)
            {
                if (listaNombres[j].CompareTo(listaNombres[j + 1]) > 0)
                {
                    string aux = listaNombres[j];
                    listaNombres[j] = listaNombres[j + 1];
                    listaNombres[j + 1] = aux;
                }
            }
        }

        Console.WriteLine("¡Lista de nombres DESPUES de ordenar!");
        ImprimirListaStrings(listaNombres);

        Console.WriteLine("¡Lista de numeros ANTES de ordenar!");
        ImprimirListaInts(listaNumeros);

        for (int i = 0; i < listaNumeros.Count - 1; i++)
        {
            for (int j = 0; j < listaNumeros.Count - 1 - i; j++)
            {
                if (listaNumeros[j] > listaNumeros[j + 1])
                {
                    int aux = listaNumeros[j];
                    listaNumeros[j] = listaNumeros[j + 1];
                    listaNumeros[j + 1] = aux;
                }
            }
        }

        Console.WriteLine("¡Lista de numeros DESPUES de ordenar!");
        ImprimirListaInts(listaNumeros);
    }

    /// <summary>
    /// Ordena nombres y numeros con Sort() de List (in-place, menor a mayor / alfabetico).
    /// </summary>
    static void OrdenarConSort(List<string> listaNombres, List<int> listaNumeros)
    {
        Console.WriteLine("¡Lista de nombres ANTES de usar \"Sort()\"!");
        ImprimirListaStrings(listaNombres);

        listaNombres.Sort();

        Console.WriteLine("¡Lista de nombres DESPUES de usar \"Sort()\"!");
        ImprimirListaStrings(listaNombres);

        Console.WriteLine("¡Lista de numeros ANTES de usar \"Sort()\"!");
        ImprimirListaInts(listaNumeros);

        listaNumeros.Sort();

        Console.WriteLine("¡Lista de numeros DESPUES de usar \"Sort()\"!");
        ImprimirListaInts(listaNumeros);
    }

    /*
    CUARTA PARTE — Find: primer elemento que cumpla una condicion (lambda).
    */
    static void DemoFind()
    {
        Console.WriteLine("¡DEMO — Find!\n");

        List<int> nums = new List<int> { 1, 2, 5, 8 };

        int encontrado = nums.Find(x => x > 4);
        Console.WriteLine("Primer valor > 4: " + encontrado);

        int noExiste = nums.Find(x => x > 100);

        if (noExiste == 0 && !nums.Contains(0))
        {
            Console.WriteLine("No hay ningun valor > 100 (Find devolvio 0 por defecto de int).");
        }
        else
        {
            Console.WriteLine("Resultado Find > 100: " + noExiste);
        }

        List<string> palabras = new List<string> { "sol", "luna", "estrella" };
        string larga = palabras.Find(p => p.Length > 4);
        Console.WriteLine("Primera palabra con mas de 4 letras: " + larga);
    }
}
