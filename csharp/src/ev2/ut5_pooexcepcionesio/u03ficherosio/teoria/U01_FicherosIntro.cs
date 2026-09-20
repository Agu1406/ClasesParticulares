/*
U01 — Introduccion a ficheros y rutas.

Antes de leer o escribir conviene saber DONDE esta el fichero.
Path y Directory ayudan a construir rutas; File.Exists comprueba si el archivo ya existe.

OBJETIVO:
  - Construir rutas con Path.Combine y Directory.GetCurrentDirectory().
  - Comprobar existencia con File.Exists antes de operar.
  - Obtener nombre y extension con Path.GetFileName y GetExtension.
  - Diferenciar ruta relativa (solo nombre) de ruta absoluta (completa).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U01 Introduccion a ficheros y rutas ===");
        Console.WriteLine("1. Rutas con Path y Directory");
        Console.WriteLine("2. Comprobar existencia");
        Console.WriteLine("3. Nombre y extension");
        Console.WriteLine("4. Crear fichero de demo");
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
                    DemoRutas();
                    break;
                case 2:
                    DemoExistencia();
                    break;
                case 3:
                    DemoNombreExtension();
                    break;
                case 4:
                    DemoCrearFichero();
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
    PRIMERA PARTE — Directorio actual y ruta combinada.
      Path.Combine evita errores con barras \ o / segun el sistema.
    */
    static void DemoRutas()
    {
        Console.WriteLine("¡DEMO — Rutas con Path y Directory!\n");

        string nombreFichero = "demo_ut5.txt";
        string directorioActual = Directory.GetCurrentDirectory();
        string rutaCompleta = Path.Combine(directorioActual, nombreFichero);

        Console.WriteLine($"Directorio actual: {directorioActual}");
        Console.WriteLine($"Nombre del fichero: {nombreFichero}");
        Console.WriteLine($"Ruta completa: {rutaCompleta}");
    }

    /*
    SEGUNDA PARTE — File.Exists antes de leer o escribir.
    */
    static void DemoExistencia()
    {
        Console.WriteLine("¡DEMO — Comprobar existencia!\n");

        string nombreFichero = "demo_ut5.txt";
        string directorioActual = Directory.GetCurrentDirectory();
        string rutaCompleta = Path.Combine(directorioActual, nombreFichero);

        if (File.Exists(rutaCompleta))
        {
            Console.WriteLine("El fichero demo_ut5.txt YA existe en disco.");
        }
        else
        {
            Console.WriteLine("El fichero demo_ut5.txt NO existe todavia.");
        }

        if (File.Exists("fichero_inventado_xyz.txt"))
        {
            Console.WriteLine("Existe fichero inventado (no deberia).");
        }
        else
        {
            Console.WriteLine("fichero_inventado_xyz.txt no existe (esperado).");
        }
    }

    /*
    TERCERA PARTE — Metadatos de la ruta con Path.
    */
    static void DemoNombreExtension()
    {
        Console.WriteLine("¡DEMO — Nombre y extension!\n");

        string nombreFichero = "demo_ut5.txt";
        string directorioActual = Directory.GetCurrentDirectory();
        string rutaCompleta = Path.Combine(directorioActual, nombreFichero);

        Console.WriteLine($"GetFileName: {Path.GetFileName(rutaCompleta)}");
        Console.WriteLine($"GetExtension: {Path.GetExtension(rutaCompleta)}");
        Console.WriteLine($"GetFileNameWithoutExtension: {Path.GetFileNameWithoutExtension(rutaCompleta)}");
    }

    /*
    CUARTA PARTE — Crear el fichero de demo para las siguientes lecciones.
    */
    static void DemoCrearFichero()
    {
        Console.WriteLine("¡DEMO — Crear fichero de demo!\n");

        string nombreFichero = "demo_ut5.txt";

        if (!File.Exists(nombreFichero))
        {
            File.WriteAllText(nombreFichero, "Fichero de demostracion UT5.\n");
            Console.WriteLine("Creado demo_ut5.txt con una linea inicial.");
        }
        else
        {
            Console.WriteLine("demo_ut5.txt ya estaba creado; no se sobrescribe aqui.");
        }

        Console.WriteLine($"Tras la demo, existe: {File.Exists(nombreFichero)}");
    }
}
