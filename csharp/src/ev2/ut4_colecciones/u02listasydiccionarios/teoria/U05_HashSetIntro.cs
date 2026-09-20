/*
U05 — Introduccion a HashSet.

OBJETIVO:
  - Crear HashSet<T> para almacenar elementos unicos sin duplicados.
  - Agregar con Add y comprobar pertenencia con Contains.
  - Observar que Add ignora valores repetidos (Count no crece).
  - Recorrer el conjunto con foreach y llaves { }.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U05 Introduccion a HashSet ===");
        Console.WriteLine("1. Add en HashSet");
        Console.WriteLine("2. Sin duplicados");
        Console.WriteLine("3. Contains");
        Console.WriteLine("4. Recorrido y emails unicos");
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
                    DemoAdd();
                    break;
                case 2:
                    DemoSinDuplicados();
                    break;
                case 3:
                    DemoContains();
                    break;
                case 4:
                    DemoRecorridoYEmails();
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
    PRIMERA PARTE — Crear HashSet y agregar elementos.
      HashSet no garantiza orden; si importa el orden, usa List.
    */
    static void DemoAdd()
    {
        Console.WriteLine("¡DEMO — Add en HashSet!\n");

        HashSet<string> colores = new HashSet<string>();
        colores.Add("Rojo");
        colores.Add("Verde");
        colores.Add("Azul");

        Console.WriteLine("Agregados: Rojo, Verde, Azul");
        Console.WriteLine("Count: " + colores.Count);
    }

    /*
    SEGUNDA PARTE — Duplicados: Add devuelve false si ya existia.
      Count sigue siendo 3 aunque intentemos agregar "Rojo" otra vez.
    */
    static void DemoSinDuplicados()
    {
        Console.WriteLine("¡DEMO — Sin duplicados!\n");

        HashSet<string> colores = new HashSet<string>();
        colores.Add("Rojo");
        colores.Add("Verde");
        colores.Add("Azul");

        bool agregadoRojo = colores.Add("Rojo");
        bool agregadoAmarillo = colores.Add("Amarillo");

        Console.WriteLine("Add(\"Rojo\") otra vez devolvio: " + agregadoRojo + " (false = ya existia)");
        Console.WriteLine("Add(\"Amarillo\") devolvio: " + agregadoAmarillo);
        Console.WriteLine("Count (sin duplicados): " + colores.Count);
    }

    /*
    TERCERA PARTE — Contains: busqueda rapida de pertenencia.
    */
    static void DemoContains()
    {
        Console.WriteLine("¡DEMO — Contains!\n");

        HashSet<string> colores = new HashSet<string>();
        colores.Add("Rojo");
        colores.Add("Verde");
        colores.Add("Azul");

        Console.WriteLine("Contiene Verde: " + colores.Contains("Verde"));
        Console.WriteLine("Contiene Negro: " + colores.Contains("Negro"));

        if (colores.Contains("Azul"))
        {
            Console.WriteLine("Azul esta en el conjunto.");
        }
        else
        {
            Console.WriteLine("Azul no esta.");
        }

        if (colores.Contains("Negro"))
        {
            Console.WriteLine("Negro esta en el conjunto.");
        }
        else
        {
            Console.WriteLine("Negro no esta en el conjunto.");
        }
    }

    /*
    CUARTA PARTE — Recorrer y ejemplo practico: emails unicos.
    */
    static void DemoRecorridoYEmails()
    {
        Console.WriteLine("¡DEMO — Recorrido y emails unicos!\n");

        HashSet<string> colores = new HashSet<string>();
        colores.Add("Rojo");
        colores.Add("Verde");
        colores.Add("Azul");
        colores.Add("Amarillo");

        Console.WriteLine("Colores en el HashSet:");
        foreach (string c in colores)
        {
            Console.WriteLine("  " + c);
        }

        HashSet<string> emailsUnicos = new HashSet<string>();
        string[] emailsRecibidos = { "a@mail.com", "b@mail.com", "a@mail.com", "c@mail.com", "b@mail.com" };

        foreach (string email in emailsRecibidos)
        {
            emailsUnicos.Add(email);
        }

        Console.WriteLine("\nEmails recibidos: " + emailsRecibidos.Length);
        Console.WriteLine("Emails unicos: " + emailsUnicos.Count);

        foreach (string email in emailsUnicos)
        {
            Console.WriteLine("  " + email);
        }
    }
}
