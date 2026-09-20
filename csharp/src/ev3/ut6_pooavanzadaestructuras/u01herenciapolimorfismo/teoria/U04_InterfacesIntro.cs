/*
U04 — Introduccion a interfaces.

Una interfaz define un contrato (puede volar) que clases no emparentadas
por herencia (Pajaro, Avion) pueden cumplir. En C# el nombre suele llevar
prefijo I (IVolable). implements de Java se escribe con ":" igual que herencia.

OBJETIVO:
  - Declarar interface e implementarla en varias clases.
  - Usar polimorfismo con tipo interfaz (IVolable v = new Pajaro(...)).
  - Comparar idea de interface vs abstract class (herencia multiple de contratos).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U04 Interfaces: IVolable / Pajaro / Avion ===");
        Console.WriteLine("1. Flota polimorfica (IVolable[])");
        Console.WriteLine("2. Comparar abstract class vs interface");
        Console.WriteLine("3. Una llamada, dos comportamientos");
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
                    DemoFlota();
                    break;
                case 2:
                    DemoComparacion();
                    break;
                case 3:
                    DemoMismaLlamada();
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

    static void DemoFlota()
    {
        Console.WriteLine("¡DEMO — Flota IVolable!\n");

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

    static void DemoComparacion()
    {
        Console.WriteLine("¡DEMO — abstract class vs interface!\n");
        Console.WriteLine("  |                  | abstract class | interface      |");
        Console.WriteLine("  | Estado (campos)  | Si             | No (tipico)    |");
        Console.WriteLine("  | Herencia multiple| No (1 base)    | Si (varias I)  |");
        Console.WriteLine("  | Constructores    | Si             | No             |");
        Console.WriteLine("\nUsa abstract cuando hay estado/comportamiento comun.");
        Console.WriteLine("Usa interface cuando solo defines un contrato de capacidad.");
    }

    static void DemoMismaLlamada()
    {
        Console.WriteLine("¡DEMO — Misma llamada Despegar(), distinto cuerpo!\n");

        IVolable pajaro = new Pajaro("halcon");
        IVolable avion = new Avion("B737");

        pajaro.Despegar();
        avion.Despegar();
        Console.WriteLine("\nTipo declarado: IVolable | Tipos reales: Pajaro y Avion.");
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

    public void Despegar()
    {
        Console.WriteLine($"{especie} bate las alas y despega.");
    }

    public void Aterrizar()
    {
        Console.WriteLine($"{especie} aterriza en una rama.");
    }

    public int GetAlturaMaxima()
    {
        return 500;
    }

    public string GetEspecie() => especie;
}

class Avion : IVolable
{
    private string modelo;

    public Avion(string modelo)
    {
        this.modelo = modelo;
    }

    public void Despegar()
    {
        Console.WriteLine($"Avion {modelo}: motores a maxima potencia. Despegue.");
    }

    public void Aterrizar()
    {
        Console.WriteLine($"Avion {modelo}: tren de aterrizaje abajo. Aterrizaje.");
    }

    public int GetAlturaMaxima()
    {
        return 12000;
    }

    public string GetModelo() => modelo;
}
