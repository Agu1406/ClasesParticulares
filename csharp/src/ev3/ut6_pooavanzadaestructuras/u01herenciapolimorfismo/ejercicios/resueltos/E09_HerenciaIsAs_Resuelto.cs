/*
OBJETIVO: Mezcla herencia + is/as: array Animal con Perro/Gato;
  detectar Perro con is y mostrar la raza. SOLUCION: ver codigo.

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
        Console.WriteLine("=== E09 Herencia + is/as (resuelto) ===");
        Console.WriteLine("1. Ejecutar solucion");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Animal[] con Perro y Gato.
Recorre: HacerSonido() en todos.
Si el elemento is Perro, usa as (o pattern) y muestra la raza.");
    }

    static void EjecutarEjercicio()
    {
        Animal[] animales =
        {
            new Perro("Rex", "Pastor aleman"),
            new Gato("Michi"),
            new Perro("Luna", "Labrador")
        };

        foreach (Animal a in animales)
        {
            a.HacerSonido();

            if (a is Perro)
            {
                Perro? p = a as Perro;
                Console.WriteLine($"  -> Es un Perro de raza {p!.GetRaza()}");
            }
            else if (a is Gato)
            {
                Console.WriteLine("  -> Es un Gato");
            }
        }
    }
}

class Animal
{
    protected string nombre;

    public Animal(string nombre)
    {
        this.nombre = nombre;
    }

    public virtual void HacerSonido()
    {
        Console.WriteLine($"{nombre} hace un sonido generico...");
    }
}

class Perro : Animal
{
    private string raza;

    public Perro(string nombre, string raza) : base(nombre)
    {
        this.raza = raza;
    }

    public override void HacerSonido()
    {
        Console.WriteLine($"{nombre} dice: ¡Guau!");
    }

    public string GetRaza() => raza;
}

class Gato : Animal
{
    public Gato(string nombre) : base(nombre)
    {
    }

    public override void HacerSonido()
    {
        Console.WriteLine($"{nombre} dice: ¡Miau!");
    }
}
