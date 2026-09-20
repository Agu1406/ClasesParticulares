/*
OBJETIVO: Array de Figura con Circulo y Rectangulo; recorrer y sumar areas.
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
        Console.WriteLine("=== E04 Polimorfismo array de Figura (resuelto) ===");
        Console.WriteLine("1. Ejecutar solucion");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Figura abstracta; Circulo y Rectangulo concretas.
Guarda varias en Figura[]; recorre e imprime cada area; suma el total.");
    }

    static void EjecutarEjercicio()
    {
        Figura[] figuras =
        {
            new Circulo(2.5),
            new Rectangulo(3, 4),
            new Circulo(1.0),
            new Rectangulo(2, 5)
        };

        double suma = 0;
        foreach (Figura f in figuras)
        {
            double area = f.CalcularArea();
            Console.WriteLine($"{f.GetType().Name}: area = {area:F2}");
            suma += area;
        }
        Console.WriteLine($"Suma de areas: {suma:F2}");
    }
}

abstract class Figura
{
    public abstract double CalcularArea();
}

class Circulo : Figura
{
    private double radio;

    public Circulo(double radio)
    {
        this.radio = radio;
    }

    public override double CalcularArea() => Math.PI * radio * radio;
}

class Rectangulo : Figura
{
    private double baseFigura;
    private double altura;

    public Rectangulo(double baseFigura, double altura)
    {
        this.baseFigura = baseFigura;
        this.altura = altura;
    }

    public override double CalcularArea() => baseFigura * altura;
}
