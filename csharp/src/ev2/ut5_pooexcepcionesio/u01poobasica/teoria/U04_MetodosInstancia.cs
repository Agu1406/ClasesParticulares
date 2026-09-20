/*
U04 — Metodos de instancia.

Un metodo de instancia opera sobre UN objeto concreto. Puede leer y usar
las propiedades de ese objeto (Ancho, Alto...) para calcular o mostrar resultados.
Se invoca con objeto.Metodo(), no con el nombre de la clase.

OBJETIVO:
  - Definir metodos que usan el estado interno del objeto.
  - Llamar metodos desde Main sobre distintas instancias.
  - Ver que cada rectangulo calcula con SUS propios Ancho y Alto.
  - Combinar constructor + propiedades + metodos en una clase coherente.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U04 Metodos de instancia ===");
        Console.WriteLine("1. Metodos de instancia");
        Console.WriteLine("2. Segundo rectangulo");
        Console.WriteLine("3. Metodo void MostrarResumen");
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
                    DemoMetodosInstancia();
                    break;
                case 2:
                    DemoSegundoRectangulo();
                    break;
                case 3:
                    DemoMostrarResumen();
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
    PRIMERA PARTE — Metodos que leen propiedades del objeto.
      rect.CalcularArea() usa rect.Ancho y rect.Alto internamente.
    */
    static void DemoMetodosInstancia()
    {
        Console.WriteLine("¡DEMO — Metodos de instancia!\n");

        Rectangulo rect = new Rectangulo(4, 3);
        Console.WriteLine($"Rectangulo {rect.Ancho} x {rect.Alto}");
        Console.WriteLine($"Area: {rect.CalcularArea()}");
        Console.WriteLine($"Perimetro: {rect.CalcularPerimetro()}");
    }

    /*
    SEGUNDA PARTE — Otro objeto, otros resultados con los mismos metodos.
      El codigo del metodo es uno; los datos cambian por instancia.
    */
    static void DemoSegundoRectangulo()
    {
        Console.WriteLine("¡DEMO — Segundo rectangulo!\n");

        Rectangulo pantalla = new Rectangulo(16, 9);
        Console.WriteLine($"Pantalla {pantalla.Ancho} x {pantalla.Alto}");
        Console.WriteLine($"Area: {pantalla.CalcularArea()}");
        Console.WriteLine($"Perimetro: {pantalla.CalcularPerimetro()}");
    }

    /*
    TERCERA PARTE — Metodo void que imprime un resumen formateado.
    */
    static void DemoMostrarResumen()
    {
        Console.WriteLine("¡DEMO — Metodo void MostrarResumen!\n");

        Rectangulo rect = new Rectangulo(4, 3);
        Rectangulo pantalla = new Rectangulo(16, 9);

        rect.MostrarResumen();
        pantalla.MostrarResumen();
    }
}

class Rectangulo
{
    public double Ancho { get; set; }
    public double Alto { get; set; }

    public Rectangulo(double ancho, double alto)
    {
        Ancho = ancho;
        Alto = alto;
    }

    public double CalcularArea()
    {
        return Ancho * Alto;
    }

    public double CalcularPerimetro()
    {
        return 2 * (Ancho + Alto);
    }

    public void MostrarResumen()
    {
        Console.WriteLine($"  -> {Ancho}x{Alto} | area={CalcularArea()}, perimetro={CalcularPerimetro()}");
    }
}
