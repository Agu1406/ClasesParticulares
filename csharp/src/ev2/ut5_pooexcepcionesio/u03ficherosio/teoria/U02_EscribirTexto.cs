/*
U02 — Escribir texto en ficheros.

File.WriteAllText crea o SOBRESCRIBE todo el contenido del archivo.
File.AppendAllText ANADE al final sin borrar lo anterior. Ambos cierran
el fichero automaticamente al terminar.

OBJETIVO:
  - Escribir contenido nuevo con WriteAllText.
  - Anadir lineas con AppendAllText sin perder lo previo.
  - Verificar el resultado leyendo el fichero al final (preview).
  - Usar nombres relativos como demo_ut5.txt en el directorio de trabajo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U02 Escribir texto en ficheros ===");
        Console.WriteLine("1. WriteAllText (sobrescribir)");
        Console.WriteLine("2. AppendAllText (anadir)");
        Console.WriteLine("3. Segundo WriteAllText");
        Console.WriteLine("4. Verificacion");
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
                    DemoWriteAllText();
                    break;
                case 2:
                    DemoAppendAllText();
                    break;
                case 3:
                    DemoSegundoWriteAllText();
                    break;
                case 4:
                    DemoVerificacion();
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
    PRIMERA PARTE — WriteAllText: crea o reemplaza todo el contenido.
      Si el fichero existia, lo borra y escribe de cero.
    */
    static void DemoWriteAllText()
    {
        Console.WriteLine("¡DEMO — WriteAllText (sobrescribir)!\n");

        string fichero = "demo_ut5.txt";
        File.WriteAllText(fichero, "Primera linea del demo UT5.\n");
        Console.WriteLine("Escrita la primera linea (contenido nuevo).");
    }

    /*
    SEGUNDA PARTE — AppendAllText: concatena al final del archivo.
      No elimina la primera linea; agrega debajo.
    */
    static void DemoAppendAllText()
    {
        Console.WriteLine("¡DEMO — AppendAllText (anadir)!\n");

        string fichero = "demo_ut5.txt";
        File.AppendAllText(fichero, "Segunda linea anadida con Append.\n");
        File.AppendAllText(fichero, "Tercera linea anadida con Append.\n");
        Console.WriteLine("Anadidas segunda y tercera linea.");
    }

    /*
    TERCERA PARTE — Otro WriteAllText demuestra que SOBRESCRIBE otra vez.
    */
    static void DemoSegundoWriteAllText()
    {
        Console.WriteLine("¡DEMO — Segundo WriteAllText (borra lo anterior)!\n");

        string fichero = "demo_ut5.txt";
        File.WriteAllText(fichero, "Contenido reemplazado por completo.\n");
        File.AppendAllText(fichero, "Linea extra tras el reemplazo.\n");
        Console.WriteLine("Fichero reescrito y luego ampliado con Append.");
    }

    /*
    CUARTA PARTE — Comprobar tamano y preview del contenido final.
    */
    static void DemoVerificacion()
    {
        Console.WriteLine("¡DEMO — Verificacion!\n");

        string fichero = "demo_ut5.txt";
        FileInfo info = new FileInfo(fichero);
        Console.WriteLine($"Tamano en bytes: {info.Length}");
        Console.WriteLine("Contenido actual:");
        Console.WriteLine(File.ReadAllText(fichero));
    }
}
