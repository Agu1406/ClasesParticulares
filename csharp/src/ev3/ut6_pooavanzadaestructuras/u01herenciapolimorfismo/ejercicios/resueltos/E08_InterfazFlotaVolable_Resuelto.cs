/*
OBJETIVO: Segunda implementacion Avion de IVolable; array IVolable[] con ambos.
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
        Console.WriteLine("=== E08 Interfaz flota Pajaro/Avion (resuelto) ===");
        Console.WriteLine("1. Ejecutar solucion");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"IVolable implementado por Pajaro y Avion.
Guarda ambos en IVolable[]; recorre Despegar, altura max y Aterrizar.");
    }

    static void EjecutarEjercicio()
    {
        IVolable[] flota =
        {
            new Pajaro("aguila"),
            new Avion("A320"),
            new Pajaro("gorrion")
        };

        foreach (IVolable v in flota)
        {
            v.Despegar();
            Console.WriteLine($"  Altura max: {v.GetAlturaMaxima()} m");
            v.Aterrizar();
            Console.WriteLine();
        }
    }
}

interface IVolable
{
    void Despegar();
    void Aterrizar();
    int GetAlturaMaxima();
}

class Pajaro : IVolable
{
    private string especie;

    public Pajaro(string especie)
    {
        this.especie = especie;
    }

    public void Despegar() => Console.WriteLine($"{especie} bate las alas y despega.");
    public void Aterrizar() => Console.WriteLine($"{especie} aterriza en una rama.");
    public int GetAlturaMaxima() => 500;
}

class Avion : IVolable
{
    private string modelo;

    public Avion(string modelo)
    {
        this.modelo = modelo;
    }

    public void Despegar() => Console.WriteLine($"Avion {modelo}: despegue.");
    public void Aterrizar() => Console.WriteLine($"Avion {modelo}: aterrizaje.");
    public int GetAlturaMaxima() => 12000;
}
