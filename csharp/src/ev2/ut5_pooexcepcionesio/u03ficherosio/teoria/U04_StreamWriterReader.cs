/*
U04 — StreamWriter y StreamReader con using.

Los metodos File.* son comodos para ficheros pequenos. StreamWriter/Reader
ofrecen control linea a linea. El bloque using { } cierra el stream
automaticamente aunque ocurra un error (como un finally implicito).

OBJETIVO:
  - Escribir con StreamWriter y WriteLine en bloque using.
  - Leer con StreamReader y ReadLine() en un bucle while.
  - Entender que using libera el fichero al salir del bloque.
  - Comparar con File.WriteAllText / ReadAllText de lecciones anteriores.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U04 StreamWriter y StreamReader ===");
        Console.WriteLine("1. Escribir con StreamWriter");
        Console.WriteLine("2. Leer con StreamReader");
        Console.WriteLine("3. Append con StreamWriter");
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
                    DemoEscribirStreamWriter();
                    break;
                case 2:
                    DemoLeerStreamReader();
                    break;
                case 3:
                    DemoAppendStreamWriter();
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
    PRIMERA PARTE — Escribir con StreamWriter dentro de using.
      Al cerrar el bloque, el fichero queda guardado en disco.
    */
    static void DemoEscribirStreamWriter()
    {
        Console.WriteLine("¡DEMO — Escribir con StreamWriter!\n");

        string fichero = "demo_ut5.txt";

        using (StreamWriter writer = new StreamWriter(fichero))
        {
            writer.WriteLine("Hola desde StreamWriter");
            writer.WriteLine("Segunda linea del stream");
            writer.WriteLine("Tercera linea del stream");
        }
        Console.WriteLine("Escritura completada (stream cerrado por using).");
    }

    /*
    SEGUNDA PARTE — Leer con StreamReader linea a linea.
      ReadLine() devuelve null cuando no quedan mas lineas.
    */
    static void DemoLeerStreamReader()
    {
        Console.WriteLine("¡DEMO — Leer con StreamReader!\n");

        string fichero = "demo_ut5.txt";

        using (StreamReader reader = new StreamReader(fichero))
        {
            string? linea;
            int contador = 1;

            while ((linea = reader.ReadLine()) != null)
            {
                Console.WriteLine($"  Linea {contador}: {linea}");
                contador++;
            }
        }
    }

    /*
    TERCERA PARTE — Anadir una linea mas reabriendo en modo append.
      El constructor StreamWriter(path, append: true) no borra el contenido previo.
    */
    static void DemoAppendStreamWriter()
    {
        Console.WriteLine("¡DEMO — Append con StreamWriter!\n");

        string fichero = "demo_ut5.txt";

        using (StreamWriter writerAppend = new StreamWriter(fichero, append: true))
        {
            writerAppend.WriteLine("Linea anadida en modo append");
        }

        Console.WriteLine("Contenido final del fichero:");
        using (StreamReader readerFinal = new StreamReader(fichero))
        {
            string? linea;
            while ((linea = readerFinal.ReadLine()) != null)
            {
                Console.WriteLine($"  -> {linea}");
            }
        }
    }
}
