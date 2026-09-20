/*
U03 — Leer texto de ficheros.

File.ReadAllText devuelve todo el archivo como un unico string.
File.ReadAllLines devuelve un array de strings, una entrada por linea.
Es util recorrer lineas con foreach cuando procesas registro a registro.

OBJETIVO:
  - Preparar un fichero de ejemplo con WriteAllText.
  - Leer todo de golpe con ReadAllText.
  - Leer linea a linea con ReadAllLines y foreach { }.
  - Contar lineas y mostrar cada una numerada.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U03 Leer texto de ficheros ===");
        Console.WriteLine("1. Preparar fichero");
        Console.WriteLine("2. ReadAllText");
        Console.WriteLine("3. ReadAllLines + foreach");
        Console.WriteLine("4. Lectura segura con Exists");
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
                    DemoPrepararFichero();
                    break;
                case 2:
                    DemoReadAllText();
                    break;
                case 3:
                    DemoReadAllLines();
                    break;
                case 4:
                    DemoLecturaSegura();
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
    PRIMERA PARTE — Crear contenido de prueba con varias lineas.
    */
    static void DemoPrepararFichero()
    {
        Console.WriteLine("¡DEMO — Preparar fichero de lectura!\n");

        string fichero = "demo_ut5.txt";
        File.WriteAllText(fichero, "Linea A: inicio\nLinea B: medio\nLinea C: final\n");
        Console.WriteLine("Fichero demo_ut5.txt preparado con 3 lineas.");
    }

    /*
    SEGUNDA PARTE — ReadAllText: un solo string con saltos \n incluidos.
    */
    static void DemoReadAllText()
    {
        Console.WriteLine("¡DEMO — ReadAllText (todo el texto)!\n");

        string fichero = "demo_ut5.txt";
        string todoElTexto = File.ReadAllText(fichero);
        Console.WriteLine("--- Contenido completo ---");
        Console.WriteLine(todoElTexto);
        Console.WriteLine($"Caracteres totales: {todoElTexto.Length}");
    }

    /*
    TERCERA PARTE — ReadAllLines + foreach: procesar linea por linea.
    */
    static void DemoReadAllLines()
    {
        Console.WriteLine("¡DEMO — ReadAllLines + foreach!\n");

        string fichero = "demo_ut5.txt";
        string[] lineas = File.ReadAllLines(fichero);
        Console.WriteLine($"Numero de lineas: {lineas.Length}");
        Console.WriteLine("--- Recorrido con foreach ---");

        int numero = 1;
        foreach (string linea in lineas)
        {
            Console.WriteLine($"  {numero}. {linea}");
            numero++;
        }
    }

    /*
    CUARTA PARTE — Comprobar existencia antes de leer (buena practica).
    */
    static void DemoLecturaSegura()
    {
        Console.WriteLine("¡DEMO — Lectura segura con File.Exists!\n");

        string otroFichero = "demo_ut5_inexistente.txt";

        if (File.Exists(otroFichero))
        {
            string contenido = File.ReadAllText(otroFichero);
            Console.WriteLine(contenido);
        }
        else
        {
            Console.WriteLine($"{otroFichero} no existe; no se intenta leer.");
        }
    }
}
