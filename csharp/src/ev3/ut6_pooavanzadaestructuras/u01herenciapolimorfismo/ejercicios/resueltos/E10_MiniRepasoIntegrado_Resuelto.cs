/*
OBJETIVO: Mini-repaso integrado: menú con 2-3 demos de jerarquia
  (herencia animales, figuras, volables). SOLUCION: ver codigo.

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
                    DemoAnimales();
                    break;
                case 2:
                    DemoFiguras();
                    break;
                case 3:
                    DemoVolables();
                    break;
                case 4:
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
        Console.WriteLine("=== E10 Mini-repaso integrado (resuelto) ===");
        Console.WriteLine("1. Demo animales (herencia)");
        Console.WriteLine("2. Demo figuras (polimorfismo)");
        Console.WriteLine("3. Demo volables (interfaces)");
        Console.WriteLine("4. Ver objetivo");
        Console.WriteLine("0. Salir");
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Integra tres demos en el mismo archivo:
  A) Animal/Perro/Gato + HacerSonido
  B) Figura[] + CalcularArea
  C) IVolable[] + Despegar/Aterrizar");
    }

    static void DemoAnimales()
    {
        Console.WriteLine("--- Animales ---\n");
        Animal[] animales = { new Perro("Rex"), new Gato("Michi") };
        foreach (Animal a in animales)
        {
            a.HacerSonido();
        }
    }

    static void DemoFiguras()
    {
        Console.WriteLine("--- Figuras ---\n");
        Figura[] figuras = { new Circulo(2), new Rectangulo(3, 4) };
        foreach (Figura f in figuras)
        {
            Console.WriteLine($"{f.GetType().Name}: {f.CalcularArea():F2}");
        }
    }

    static void DemoVolables()
    {
        Console.WriteLine("--- Volables ---\n");
        IVolable[] flota = { new Pajaro("halcon"), new Avion("A320") };
        foreach (IVolable v in flota)
        {
            v.Despegar();
            v.Aterrizar();
        }
    }
}

class Animal
{
    protected string nombre;
    public Animal(string nombre) { this.nombre = nombre; }
    public virtual void HacerSonido() => Console.WriteLine($"{nombre}...");
}

class Perro : Animal
{
    public Perro(string nombre) : base(nombre) { }
    public override void HacerSonido() => Console.WriteLine($"{nombre} dice: ¡Guau!");
}

class Gato : Animal
{
    public Gato(string nombre) : base(nombre) { }
    public override void HacerSonido() => Console.WriteLine($"{nombre} dice: ¡Miau!");
}

abstract class Figura
{
    public abstract double CalcularArea();
}

class Circulo : Figura
{
    private double radio;
    public Circulo(double radio) { this.radio = radio; }
    public override double CalcularArea() => Math.PI * radio * radio;
}

class Rectangulo : Figura
{
    private double b, h;
    public Rectangulo(double b, double h) { this.b = b; this.h = h; }
    public override double CalcularArea() => b * h;
}

interface IVolable
{
    void Despegar();
    void Aterrizar();
}

class Pajaro : IVolable
{
    private string especie;
    public Pajaro(string especie) { this.especie = especie; }
    public void Despegar() => Console.WriteLine($"{especie} despega.");
    public void Aterrizar() => Console.WriteLine($"{especie} aterriza.");
}

class Avion : IVolable
{
    private string modelo;
    public Avion(string modelo) { this.modelo = modelo; }
    public void Despegar() => Console.WriteLine($"Avion {modelo} despega.");
    public void Aterrizar() => Console.WriteLine($"Avion {modelo} aterriza.");
}
