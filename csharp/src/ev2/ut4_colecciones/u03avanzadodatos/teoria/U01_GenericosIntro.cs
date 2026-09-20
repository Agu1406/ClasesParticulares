/*
U01 — Introduccion a genericos.

OBJETIVO:
  - Entender que T es un tipo parametro reutilizable (generico).
  - Definir un metodo generico que funcione con int, string, etc.
  - Usar restriccion where T : IComparable<T> para comparar.
  - Demostrar una clase generica simple Caja<T> con propiedad Valor.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U01 Introduccion a genericos ===");
        Console.WriteLine("1. Maximo con int");
        Console.WriteLine("2. Maximo con string");
        Console.WriteLine("3. Intercambiar generico");
        Console.WriteLine("4. Clase Caja<T>");
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
                    DemoMaximoInt();
                    break;
                case 2:
                    DemoMaximoString();
                    break;
                case 3:
                    DemoIntercambiar();
                    break;
                case 4:
                    DemoCaja();
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
    Metodo generico: Maximo<T> devuelve el mayor de dos valores comparables.
    where T : IComparable<T> exige que T tenga CompareTo.
    */
    static T Maximo<T>(T a, T b) where T : IComparable<T>
    {
        if (a.CompareTo(b) >= 0)
        {
            return a;
        }
        else
        {
            return b;
        }
    }

    static void Intercambiar<T>(ref T a, ref T b)
    {
        T temp = a;
        a = b;
        b = temp;
    }

    /*
    PRIMERA PARTE — Metodo generico con int.
      Maximo(3, 9) infiere T = int automaticamente.
    */
    static void DemoMaximoInt()
    {
        Console.WriteLine("¡DEMO — Maximo con int!\n");

        int mayorInt = Maximo(3, 9);
        Console.WriteLine("Maximo(3, 9) = " + mayorInt);
        Console.WriteLine("Maximo(15, 7) = " + Maximo(15, 7));
    }

    /*
    SEGUNDA PARTE — Mismo metodo con string (orden lexicografico).
      "ana" vs "luis": CompareTo compara caracter a caracter.
    */
    static void DemoMaximoString()
    {
        Console.WriteLine("¡DEMO — Maximo con string!\n");

        string mayorStr = Maximo("ana", "luis");
        Console.WriteLine("Maximo(\"ana\", \"luis\") = " + mayorStr);
        Console.WriteLine("Maximo(\"zebra\", \"alga\") = " + Maximo("zebra", "alga"));
    }

    /*
    TERCERA PARTE — Intercambiar<T> con ref (generico practico).
    */
    static void DemoIntercambiar()
    {
        Console.WriteLine("¡DEMO — Intercambiar generico!\n");

        int x = 10;
        int y = 20;
        Console.WriteLine("Antes: x=" + x + ", y=" + y);
        Intercambiar(ref x, ref y);
        Console.WriteLine("Despues: x=" + x + ", y=" + y);

        string s1 = "Hola";
        string s2 = "Mundo";
        Console.WriteLine("Antes: s1=" + s1 + ", s2=" + s2);
        Intercambiar(ref s1, ref s2);
        Console.WriteLine("Despues: s1=" + s1 + ", s2=" + s2);
    }

    /*
    CUARTA PARTE — Clase generica Caja<T>.
      Caja<int> y Caja<string> son tipos distintos en tiempo de compilacion.
    */
    static void DemoCaja()
    {
        Console.WriteLine("¡DEMO — Clase Caja<T>!\n");

        Caja<int> cajaNum = new Caja<int> { Valor = 42 };
        Caja<string> cajaTxt = new Caja<string> { Valor = "Hola" };
        Caja<double> cajaPrecio = new Caja<double> { Valor = 19.99 };

        Console.WriteLine("cajaNum.Valor = " + cajaNum.Valor);
        Console.WriteLine("cajaTxt.Valor = " + cajaTxt.Valor);
        Console.WriteLine("cajaPrecio.Valor = " + cajaPrecio.Valor);
    }
}

class Caja<T>
{
    public T Valor { get; set; }
}
