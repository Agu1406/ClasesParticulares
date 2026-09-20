/*
OBJETIVO: Repaso: clase Alumno con Nombre y Nota; crear objeto y mostrarlo. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
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
        Console.WriteLine("3. Crear alumno interactivo");
        Console.WriteLine("0. Salir");
        
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Repaso: clase Alumno con Nombre y Nota; crear objeto y mostrarlo.");
    }


    static void EjecutarEjercicio()
    {
        Alumno alumno = new Alumno { Nombre = "Pedro", Nota = 7.5 };
            Console.WriteLine($"{alumno.Nombre}: {alumno.Nota}");
    }

    static void EjecutarInteractivo()
    {
        Console.Write("Nombre: ");
        string? nombre = Console.ReadLine();
        Console.Write("Nota: ");
        if (double.TryParse(Console.ReadLine(), out double nota))
        {
            Alumno alumno = new Alumno { Nombre = nombre ?? "", Nota = nota };
            Console.WriteLine($"{alumno.Nombre}: {alumno.Nota}");
        }
        else
        {
            Console.WriteLine("Nota invalida.");
        }
    }
}


class Alumno
{
    public string Nombre { get; set; }
    public double Nota { get; set; }
}
