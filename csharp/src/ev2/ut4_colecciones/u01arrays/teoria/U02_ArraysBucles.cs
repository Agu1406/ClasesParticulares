/*
U02 — Arrays y bucles.

OBJETIVO:
  - Recorrer un array con for clasico usando el indice i.
  - Recorrer un array con foreach sin manejar indices.
  - Comparar cuando conviene cada bucle.
  - Usar siempre llaves { } en for y foreach.
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
        Console.WriteLine("=== U02 Arrays y bucles ===");
        Console.WriteLine("1. Recorrido con for");
        Console.WriteLine("2. Recorrido con foreach");
        Console.WriteLine("3. Contar aprobados con for");
        Console.WriteLine("4. foreach con string[]");
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
                    DemoFor();
                    break;
                case 2:
                    DemoForeach();
                    break;
                case 3:
                    DemoContarAprobados();
                    break;
                case 4:
                    DemoForeachString();
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
    PRIMERA PARTE — Recorrido con for.
      for (int i = 0; i < notas.Length; i++) recorre de 0 hasta Length - 1.
      Util cuando necesitas la posicion (indice) de cada elemento.
    */
    static void DemoFor()
    {
        Console.WriteLine("¡DEMO — Recorrido con for!\n");
        int[] notas = { 7, 8, 6, 9, 5 };

        for (int i = 0; i < notas.Length; i++)
        {
            Console.WriteLine("  Posicion " + i + ": nota = " + notas[i]);
        }
    }

    /*
    SEGUNDA PARTE — Recorrido con foreach.
      foreach (int nota in notas) lee cada valor directamente.
      Mas legible cuando solo necesitas el contenido, no el indice.
    */
    static void DemoForeach()
    {
        Console.WriteLine("¡DEMO — Recorrido con foreach!\n");
        int[] notas = { 7, 8, 6, 9, 5 };

        foreach (int nota in notas)
        {
            Console.WriteLine("  Nota: " + nota);
        }
    }

    /*
    TERCERA PARTE — for con logica extra (contar aprobados).
      El for permite usar el indice para condiciones adicionales.
    */
    static void DemoContarAprobados()
    {
        Console.WriteLine("¡DEMO — Contar aprobados con for!\n");
        int[] notas = { 7, 8, 6, 9, 5 };

        int aprobados = 0;
        for (int i = 0; i < notas.Length; i++)
        {
            if (notas[i] >= 5)
            {
                aprobados++;
                Console.WriteLine("  Aprobado en posicion " + i + ": " + notas[i]);
            }
        }

        Console.WriteLine("Total aprobados: " + aprobados);
    }

    /*
    CUARTA PARTE — foreach sobre array de string.
    */
    static void DemoForeachString()
    {
        Console.WriteLine("¡DEMO — foreach con string[]!\n");
        string[] alumnos = { "Ana", "Luis", "Eva" };

        foreach (string nombre in alumnos)
        {
            Console.WriteLine("  Alumno: " + nombre);
        }
    }
}

