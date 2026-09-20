/*
U02 — Introduccion al polimorfismo.

Misma llamada (CalcularArea), distinto comportamiento segun el objeto real.
Tratas Circulo y Rectangulo como Figura; el runtime elige el metodo correcto.
Para bajar al tipo concreto usas is / as (equivalente a instanceof en Java).

OBJETIVO:
  - Guardar subtipos en un array o List de la clase base.
  - Ver enlace dinamico al llamar metodos virtuales/override.
  - Usar is y as para comprobar y convertir el tipo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U02 Polimorfismo: Figura / Circulo / Rectangulo ===");
        Console.WriteLine("1. Array de Figura");
        Console.WriteLine("2. Suma de areas (enlace dinamico)");
        Console.WriteLine("3. is / as (downcast seguro)");
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
                    DemoArrayFiguras();
                    break;
                case 2:
                    DemoSumaAreas();
                    break;
                case 3:
                    DemoIsAs();
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
    PRIMERA PARTE — Un array tipado como Figura puede guardar
      Circulo y Rectangulo: el tipo declarado es el de la base.
    */
    static void DemoArrayFiguras()
    {
        Console.WriteLine("¡DEMO — Array de Figura!\n");

        Figura[] figuras =
        {
            new Circulo(2.5),
            new Rectangulo(3, 4),
            new Circulo(1.0, "rojo"),
            new Rectangulo(2, 5, "azul")
        };

        foreach (Figura f in figuras)
        {
            Console.WriteLine(f);
        }
    }

    /*
    SEGUNDA PARTE — CalcularArea se resuelve en la clase real
      (Circulo o Rectangulo), no en Figura.
    */
    static void DemoSumaAreas()
    {
        Console.WriteLine("¡DEMO — Suma de areas!\n");

        Figura[] figuras =
        {
            new Circulo(2.5),
            new Rectangulo(3, 4),
            new Circulo(1.0, "rojo"),
            new Rectangulo(2, 5, "azul")
        };

        double suma = 0;
        foreach (Figura f in figuras)
        {
            double area = f.CalcularArea();
            Console.WriteLine($"{f.GetNombre()}: area = {area:F2}");
            suma += area;
        }
        Console.WriteLine($"\nSuma de areas: {suma:F2}");
    }

    /*
    TERCERA PARTE — is comprueba el tipo; as convierte o devuelve null.
      Equivalente pedagogico a instanceof + cast en Java.
    */
    static void DemoIsAs()
    {
        Console.WriteLine("¡DEMO — is / as!\n");

        Figura[] figuras =
        {
            new Circulo(2.5),
            new Rectangulo(3, 4),
            new Circulo(1.0, "rojo")
        };

        foreach (Figura f in figuras)
        {
            if (f is Circulo)
            {
                Circulo? c = f as Circulo;
                Console.WriteLine($"{c!.GetNombre()} radio={c.GetRadio()}");
            }
            else if (f is Rectangulo r)
            {
                // pattern matching: is + variable en una sola linea
                Console.WriteLine($"{r.GetNombre()} base={r.GetBase()} altura={r.GetAltura()}");
            }
        }
    }
}

abstract class Figura
{
    protected string nombre;
    protected string color;

    protected Figura(string nombre, string color)
    {
        this.nombre = nombre;
        this.color = color;
    }

    public abstract double CalcularArea();

    public string GetNombre()
    {
        return nombre;
    }

    public string GetColor()
    {
        return color;
    }

    public override string ToString()
    {
        return $"{nombre} ({color}) area={CalcularArea():F2}";
    }
}

class Circulo : Figura
{
    private double radio;

    public Circulo(double radio) : this(radio, "negro")
    {
    }

    public Circulo(double radio, string color) : base("Circulo", color)
    {
        this.radio = radio;
    }

    public double GetRadio()
    {
        return radio;
    }

    public override double CalcularArea()
    {
        return Math.PI * radio * radio;
    }
}

class Rectangulo : Figura
{
    private double baseFigura;
    private double altura;

    public Rectangulo(double baseFigura, double altura) : this(baseFigura, altura, "negro")
    {
    }

    public Rectangulo(double baseFigura, double altura, string color) : base("Rectangulo", color)
    {
        this.baseFigura = baseFigura;
        this.altura = altura;
    }

    public double GetBase()
    {
        return baseFigura;
    }

    public double GetAltura()
    {
        return altura;
    }

    public override double CalcularArea()
    {
        return baseFigura * altura;
    }
}
