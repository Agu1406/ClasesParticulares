/*
OBJETIVO: Crear Animal (base) y Perro (subclase) con HacerSonido virtual/override.
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
        Console.WriteLine("=== E01 Herencia Animal / Perro (resuelto) ===");
        Console.WriteLine("1. Ejecutar solucion");
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
        Perro perro = new Perro("Rex");
        perro.HacerSonido();
        Console.WriteLine($"Nombre: {perro.GetNombre()}");
    }
}

class Animal
{
    protected string nombre;

    public Animal(string nombre)
    {
        this.nombre = nombre;
    }

    public string GetNombre() => nombre;

    public virtual void HacerSonido()
    {
        Console.WriteLine($"{nombre} hace un sonido generico...");
    }
}

class Perro : Animal
{
    public Perro(string nombre) : base(nombre)
    {
    }

    public override void HacerSonido()
    {
        Console.WriteLine($"{nombre} dice: ¡Guau!");
    }
}
