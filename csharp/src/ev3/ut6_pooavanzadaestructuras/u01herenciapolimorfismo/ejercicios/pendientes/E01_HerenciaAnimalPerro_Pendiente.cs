/*
OBJETIVO: Crear Animal (base) y Perro (subclase) con HacerSonido virtual/override.
  Demo: un Perro dice Guau. Menu do-while: completar desde un menu interactivo con opcion 0 para salir.

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
        Console.WriteLine("=== E01 Herencia Animal / Perro ===");
        Console.WriteLine("1. Trabajar ejercicio");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Clase Animal con nombre (protected) y HacerSonido virtual.
Subclase Perro : Animal que hace override y dice Guau.
Crea un Perro y llama a HacerSonido().");
    }

    static void EjecutarEjercicio()
    {
        // TODO: Crear un Perro y llamar a HacerSonido().
    }
}

// TODO: class Animal { protected string nombre; virtual HacerSonido(); }
// TODO: class Perro : Animal { override HacerSonido(); }
