/*
OBJETIVO: Clase abstracta Figura con CalcularArea; Circulo implementa el area.
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
        Console.WriteLine("=== E03 Polimorfismo Circulo (resuelto) ===");
        Console.WriteLine("1. Ejecutar solucion");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"abstract class Figura con CalcularArea abstracto.
Circulo : Figura con radio; area = PI * r * r.
Crea un Circulo y muestra su area.");
    }

    static void EjecutarEjercicio()
    {
        Circulo c = new Circulo(2.5);
        Console.WriteLine($"Circulo radio={c.GetRadio()} area={c.CalcularArea():F2}");
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

    public double GetRadio() => radio;

    public override double CalcularArea()
    {
        return Math.PI * radio * radio;
    }
}
