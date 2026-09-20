/*
U05 — Recorridos utiles sobre arrays.

OBJETIVO:
  - Calcular la suma de todos los elementos de un array.
  - Encontrar el valor maximo recorriendo el array.
  - Buscar un valor concreto y saber si existe.
  - Usar llaves { } en if, for y foreach dentro de los recorridos.
  - Practicar class + Main + menu do-while (EV1).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U05 Recorridos utiles ===");
        Console.WriteLine("1. Suma de elementos");
        Console.WriteLine("2. Valor maximo");
        Console.WriteLine("3. Buscar un valor");
        Console.WriteLine("4. Recorrido combinado");
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
                    DemoSuma();
                    break;
                case 2:
                    DemoMaximo();
                    break;
                case 3:
                    DemoBuscar();
                    break;
                case 4:
                    DemoCombinado();
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

    static void DemoSuma()
    {
        Console.WriteLine("¡DEMO — Suma de elementos!\n");
        int[] datos = { 4, 9, 2, 7, 5 };
        int suma = 0;

        foreach (int n in datos)
        {
            suma += n;
        }

        Console.WriteLine("Array: 4, 9, 2, 7, 5");
        Console.WriteLine("Suma total: " + suma);
        Console.WriteLine("Media: " + (suma / (double)datos.Length));
    }

    static void DemoMaximo()
    {
        Console.WriteLine("¡DEMO — Valor maximo!\n");
        int[] datos = { 4, 9, 2, 7, 5 };
        int maximo = datos[0];

        for (int i = 0; i < datos.Length; i++)
        {
            if (datos[i] > maximo)
            {
                maximo = datos[i];
            }
        }

        Console.WriteLine("Maximo encontrado: " + maximo);
    }

    static void DemoBuscar()
    {
        Console.WriteLine("¡DEMO — Buscar valor!\n");
        int[] datos = { 4, 9, 2, 7, 5 };
        int buscado = 7;
        bool encontrado = false;
        int posicionEncontrada = -1;

        for (int i = 0; i < datos.Length; i++)
        {
            if (datos[i] == buscado)
            {
                encontrado = true;
                posicionEncontrada = i;
            }
        }

        if (encontrado)
        {
            Console.WriteLine("El valor " + buscado + " esta en la posicion " + posicionEncontrada);
        }
        else
        {
            Console.WriteLine("El valor " + buscado + " no esta en el array");
        }

        int otroBuscado = 99;
        encontrado = false;
        foreach (int n in datos)
        {
            if (n == otroBuscado)
            {
                encontrado = true;
            }
        }

        if (encontrado)
        {
            Console.WriteLine("El valor " + otroBuscado + " existe.");
        }
        else
        {
            Console.WriteLine("El valor " + otroBuscado + " no existe.");
        }
    }

    static void DemoCombinado()
    {
        Console.WriteLine("¡DEMO — Recorrido combinado!\n");
        int[] datos = { 4, 9, 2, 7, 5 };
        int buscadoCombinado = 2;
        int suma = 0;
        int maximo = datos[0];
        bool encontrado = false;

        for (int i = 0; i < datos.Length; i++)
        {
            suma += datos[i];

            if (datos[i] > maximo)
            {
                maximo = datos[i];
            }

            if (datos[i] == buscadoCombinado)
            {
                encontrado = true;
            }
        }

        Console.WriteLine("Suma: " + suma + " | Max: " + maximo + " | Contiene " + buscadoCombinado + ": " + encontrado);
    }
}

