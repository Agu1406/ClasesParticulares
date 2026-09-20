/*
U03 — Literales de array y propiedad Length.

OBJETIVO:
  - Crear arrays con sintaxis new[] { ... } e inicializacion directa { }.
  - Consultar cuantos elementos hay con la propiedad .Length.
  - Comparar distintas formas equivalentes de inicializacion.
  - Recorrer usando Length como limite del bucle for.
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
        Console.WriteLine("=== U03 Literales y Length ===");
        Console.WriteLine("1. new[] { ... }");
        Console.WriteLine("2. Inicializacion abreviada");
        Console.WriteLine("3. Length y validacion de indice");
        Console.WriteLine("4. Formas equivalentes");
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
                    DemoNewArrayLiteral();
                    break;
                case 2:
                    DemoAbreviada();
                    break;
                case 3:
                    DemoValidacionIndice();
                    break;
                case 4:
                    DemoFormasEquivalentes();
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

    static void DemoNewArrayLiteral()
    {
        Console.WriteLine("¡DEMO — new[] { ... }!\n");
        int[] letras = new[] { 1, 2, 3, 4, 5 };

        Console.WriteLine("Tamano del array letras: " + letras.Length);
        Console.WriteLine("Ultimo indice valido: " + (letras.Length - 1));

        for (int i = 0; i < letras.Length; i++)
        {
            Console.WriteLine("  letras[" + i + "] = " + letras[i]);
        }
    }

    static void DemoAbreviada()
    {
        Console.WriteLine("¡DEMO — Inicializacion abreviada!\n");
        string[] nombres = { "Ana", "Luis", "Eva" };

        Console.WriteLine("Tamano nombres: " + nombres.Length);

        foreach (string nombre in nombres)
        {
            Console.WriteLine("  Nombre: " + nombre);
        }
    }

    static void DemoValidacionIndice()
    {
        Console.WriteLine("¡DEMO — Length y validacion de indice!\n");
        int[] letras = new[] { 1, 2, 3, 4, 5 };
        int indicePedido = 2;

        if (indicePedido >= 0 && indicePedido < letras.Length)
        {
            Console.WriteLine("Valor en indice " + indicePedido + ": " + letras[indicePedido]);
        }
        else
        {
            Console.WriteLine("Indice " + indicePedido + " fuera de rango (0.." + (letras.Length - 1) + ")");
        }

        int indiceInvalido = 10;
        if (indiceInvalido >= 0 && indiceInvalido < letras.Length)
        {
            Console.WriteLine("Valor: " + letras[indiceInvalido]);
        }
        else
        {
            Console.WriteLine("Indice " + indiceInvalido + " fuera de rango. Length = " + letras.Length);
        }
    }

    static void DemoFormasEquivalentes()
    {
        Console.WriteLine("¡DEMO — Formas equivalentes!\n");
        int[] vacioConNew = new int[0];
        int[] vacioLiteral = new int[] { };
        double[] precios = new double[] { 9.99, 14.50, 3.25 };

        Console.WriteLine("vacioConNew.Length = " + vacioConNew.Length);
        Console.WriteLine("vacioLiteral.Length = " + vacioLiteral.Length);
        Console.WriteLine("precios.Length = " + precios.Length);

        for (int i = 0; i < precios.Length; i++)
        {
            Console.WriteLine("  precios[" + i + "] = " + precios[i]);
        }
    }
}

