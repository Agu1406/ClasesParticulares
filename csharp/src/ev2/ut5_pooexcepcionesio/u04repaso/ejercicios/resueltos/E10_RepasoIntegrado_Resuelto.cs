/*
OBJETIVO: Repaso integrado: clase Contacto, guardar en "contacto.txt" con try/catch IO. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void Main()
    {
        using System.IO;

        int opcion;

        do
        {
            ImprimirMenu();
            Console.Write("Introduce una opcion -> ");
            opcion = int.Parse(Console.ReadLine()!);

            switch (opcion)
            {
                case 1:
                    EjecutarEjercicio();
                    break;
                case 3:
                    EjecutarInteractivo();
                    break;
                case 2:
                    MostrarObjetivo();
                    break;
                case 0:
                    Console.WriteLine("Saliendo...");
                    break;
                default:
                    Console.WriteLine("Opcion no valida. Intenta de nuevo.");
                    break;
            }

            if (opcion != 0)
            {
                Console.WriteLine();
                Console.WriteLine("Pulsa ENTER para continuar...");
                Console.ReadLine();
                Console.Clear();
            }
        } while (opcion != 0);
    }

    static void ImprimirMenu()
    {
        Console.WriteLine("=== EJERCICIO ===");
        Console.WriteLine("1. Ejecutar solucion");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("3. Guardar contacto interactivo");
        Console.WriteLine("0. Salir");
        
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Repaso integrado: clase Contacto, guardar en contacto.txt con try/catch IO.");
    }


    static void EjecutarEjercicio()
    {
        Contacto c = new Contacto("Laura", "laura@mail.com");
            try
            {
                File.WriteAllText("contacto.txt", c.ToLinea());
                Console.WriteLine("Contacto guardado en contacto.txt");
            }
            catch (IOException ex)
            {
                Console.WriteLine($"Error al escribir: {ex.Message}");
            }
    }

    static void EjecutarInteractivo()
    {
        Console.Write("Nombre: ");
        string? nombre = Console.ReadLine();
        Console.Write("Email: ");
        string? email = Console.ReadLine();
        Contacto c = new Contacto(nombre ?? "", email ?? "");
        try
        {
            File.WriteAllText("contacto.txt", c.ToLinea());
            Console.WriteLine("Contacto guardado en contacto.txt");
        }
        catch (IOException ex)
        {
            Console.WriteLine($"Error al escribir: {ex.Message}");
        }
    }
}


class Contacto
{
    public string Nombre { get; }
    public string Email { get; }

    public Contacto(string nombre, string email)
    {
        Nombre = nombre;
        Email = email;
    }

    public string ToLinea() => $"{Nombre};{Email}";
}
