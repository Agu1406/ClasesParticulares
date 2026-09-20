/*
U03 — Constructores con parametros.

El constructor es un metodo especial con el mismo nombre que la clase.
Se ejecuta automaticamente al hacer new y permite inicializar el objeto
con valores desde el principio, sin asignar propiedad por propiedad.

OBJETIVO:
  - Usar constructores con parametros para inicializar objetos al crearlos.
  - Evitar objetos "vacios" cuando ya conoces los datos minimos.
  - Crear varias instancias pasando argumentos distintos.
  - Entender que new Libro(...) llama al constructor antes de usar el objeto.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U03 Constructores ===");
        Console.WriteLine("1. Constructor con parametros");
        Console.WriteLine("2. Segundo libro");
        Console.WriteLine("3. Cambios tras la construccion");
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
                    DemoConstructor();
                    break;
                case 2:
                    DemoSegundoLibro();
                    break;
                case 3:
                    DemoCambiosTrasConstruccion();
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
    PRIMERA PARTE — Constructor con dos parametros.
      El objeto nace ya con Titulo y Autor asignados.
    */
    static void DemoConstructor()
    {
        Console.WriteLine("¡DEMO — Constructor con parametros!\n");

        Libro libro1 = new Libro("C# basico", "Agustin Marquez");
        Console.WriteLine($"Titulo: {libro1.Titulo}");
        Console.WriteLine($"Autor: {libro1.Autor}");
    }

    /*
    SEGUNDA PARTE — Otra instancia con otros argumentos.
      Cada new ejecuta el constructor otra vez con valores nuevos.
    */
    static void DemoSegundoLibro()
    {
        Console.WriteLine("¡DEMO — Segundo libro!\n");

        Libro libro2 = new Libro("POO en C#", "Equipo editorial");
        Console.WriteLine($"{libro2.Titulo} de {libro2.Autor}");
    }

    /*
    TERCERA PARTE — Modificar propiedades despues de construir (si tienen set).
      El constructor da el estado inicial; luego puedes cambiar lo permitido.
    */
    static void DemoCambiosTrasConstruccion()
    {
        Console.WriteLine("¡DEMO — Cambios tras la construccion!\n");

        Libro libro1 = new Libro("C# basico", "Agustin Marquez");
        libro1.Titulo = "C# basico (2ª edicion)";
        Console.WriteLine($"Titulo actualizado: {libro1.Titulo}");
        Console.WriteLine($"Autor sin cambios: {libro1.Autor}");
    }
}

class Libro
{
    public string Titulo { get; set; }
    public string Autor { get; set; }

    public Libro(string titulo, string autor)
    {
        Titulo = titulo;
        Autor = autor;
    }
}
