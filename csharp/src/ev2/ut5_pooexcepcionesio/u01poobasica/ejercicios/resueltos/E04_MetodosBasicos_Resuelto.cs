/*
OBJETIVO: Clase Circulo con radio y metodo CalcularArea(); muestra el area de r=5. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
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
                case 3:
                    EjecutarInteractivo();
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
        Console.WriteLine("=== EJERCICIO ===");
        Console.WriteLine("1. Ejecutar solucion");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("3. Calcular area con otro radio");
        Console.WriteLine("0. Salir");
        
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Clase Circulo con radio y metodo CalcularArea(); muestra el area de r=5.");
    }


    static void EjecutarEjercicio()
    {
        Circulo circulo = new Circulo(5);
            Console.WriteLine($"Area: {circulo.CalcularArea():F2}");
    }

    static void EjecutarInteractivo()
    {
        Console.Write("Radio: ");
        string? texto = Console.ReadLine();
        if (double.TryParse(texto, out double radio))
        {
            Circulo circulo = new Circulo(radio);
            Console.WriteLine($"Area: {circulo.CalcularArea():F2}");
        }
        else
        {
            Console.WriteLine("Radio invalido.");
        }
    }
}


class Circulo
{
    public double Radio { get; set; }

    public Circulo(double radio)
    {
        Radio = radio;
    }

    public double CalcularArea()
    {
        return Math.PI * Radio * Radio;
    }
}
