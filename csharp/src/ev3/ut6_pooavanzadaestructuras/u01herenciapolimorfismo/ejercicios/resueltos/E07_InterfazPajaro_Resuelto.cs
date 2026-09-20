/*
OBJETIVO: Interfaz IVolable con Despegar/Aterrizar; clase Pajaro que la implementa.
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
        Console.WriteLine("=== E07 Interfaz IVolable / Pajaro (resuelto) ===");
        Console.WriteLine("1. Ejecutar solucion");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"interface IVolable { Despegar(); Aterrizar(); GetAlturaMaxima(); }
class Pajaro : IVolable.
Crea un Pajaro (o IVolable) y llama a Despegar y Aterrizar.");
    }

    static void EjecutarEjercicio()
    {
        IVolable pajaro = new Pajaro("aguila");
        pajaro.Despegar();
        Console.WriteLine($"Altura max: {pajaro.GetAlturaMaxima()} m");
        pajaro.Aterrizar();
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

    public int GetAlturaMaxima() => 500;
}
