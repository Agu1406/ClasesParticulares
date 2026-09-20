/*
U05 — Miembros estaticos (introduccion).

static significa "pertenece a la clase", no a un objeto concreto.
Un campo estatico se comparte entre todas las instancias (si las hubiera).
Un metodo estatico se llama con NombreClase.Metodo(), sin new.

OBJETIVO:
  - Usar un campo estatico compartido (Contador.Valor).
  - Llamar metodos estaticos sin crear objetos.
  - Ver que el contador acumula entre llamadas a Incrementar().
  - Contrastar: estatico = uno para todos; instancia = uno por objeto.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U05 Miembros estaticos ===");
        Console.WriteLine("1. Campo estatico Valor");
        Console.WriteLine("2. Metodo estatico Incrementar");
        Console.WriteLine("3. Reiniciar contador");
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
                    DemoCampoEstatico();
                    break;
                case 2:
                    DemoIncrementar();
                    break;
                case 3:
                    DemoReiniciar();
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
    PRIMERA PARTE — Valor inicial del contador estatico.
      No hace falta new Contador(): el estado vive en la clase.
    */
    static void DemoCampoEstatico()
    {
        Console.WriteLine("¡DEMO — Campo estatico Valor!\n");

        Contador.Reiniciar();
        Console.WriteLine($"Valor inicial: {Contador.Valor}");
    }

    /*
    SEGUNDA PARTE — Incrementar varias veces con metodo estatico.
      Cada llamada modifica el MISMO Valor compartido.
    */
    static void DemoIncrementar()
    {
        Console.WriteLine("¡DEMO — Metodo estatico Incrementar!\n");

        Contador.Reiniciar();
        Contador.Incrementar();
        Console.WriteLine($"Tras 1ª llamada: {Contador.Valor}");

        Contador.Incrementar();
        Contador.Incrementar();
        Console.WriteLine($"Tras 3 incrementos en total: {Contador.Valor}");
    }

    /*
    TERCERA PARTE — Reiniciar y comprobar de nuevo.
      Demuestra que el estado estatico persiste durante todo el programa.
    */
    static void DemoReiniciar()
    {
        Console.WriteLine("¡DEMO — Reiniciar contador!\n");

        Contador.Reiniciar();
        Contador.Incrementar();
        Contador.Incrementar();
        Console.WriteLine($"Valor antes de Reiniciar(): {Contador.Valor}");

        Contador.Reiniciar();
        Console.WriteLine($"Valor tras Reiniciar(): {Contador.Valor}");

        Contador.Incrementar();
        Console.WriteLine($"Valor tras un incremento mas: {Contador.Valor}");
    }
}

class Contador
{
    public static int Valor { get; private set; }

    public static void Incrementar()
    {
        Valor++;
    }

    public static void Reiniciar()
    {
        Valor = 0;
    }
}
