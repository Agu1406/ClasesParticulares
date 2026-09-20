/*
U00 — Indice: herencia, polimorfismo, abstraccion e interfaces (UT6 u01).

OBJETIVO:
  - Ver el orden de estudio del subtema.
  - Saber que archivo abrir en cada paso.
  - Relacionar cada bloque con el equivalente Java.

Orden pedagogico (como el indice Java, no el numero de carpeta Java):
  1. Herencia        -> U01_HerenciaIntro.cs
  2. Polimorfismo    -> U02_PolimorfismoIntro.cs
  3. Abstraccion     -> U03_AbstraccionIntro.cs
  4. Interfaces      -> U04_InterfacesIntro.cs

Ejercicios: E01-E10 en ejercicios/pendientes y ejercicios/resueltos.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U00 Indice herencia / polimorfismo ===");
        Console.WriteLine("1. Ver orden de estudio");
        Console.WriteLine("2. Que archivo abrir en cada paso");
        Console.WriteLine("3. Mapa C# vs Java");
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
                    DemoOrdenEstudio();
                    break;
                case 2:
                    DemoQueAbrir();
                    break;
                case 3:
                    DemoMapaJava();
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

    static void DemoOrdenEstudio()
    {
        Console.WriteLine("¡DEMO — Orden de estudio!\n");
        Console.WriteLine("  1. Herencia       (: , base, virtual/override, protected)");
        Console.WriteLine("  2. Polimorfismo   (referencia de base, is / as)");
        Console.WriteLine("  3. Abstraccion    (abstract class / metodos abstractos)");
        Console.WriteLine("  4. Interfaces     (interface + implementacion)");
        Console.WriteLine("\nLuego practica con E01-E10.");
    }

    static void DemoQueAbrir()
    {
        Console.WriteLine("¡DEMO — Que archivo abrir!\n");
        Console.WriteLine("  U01_HerenciaIntro.cs      -> Animal / Perro / Gato");
        Console.WriteLine("  U02_PolimorfismoIntro.cs  -> Figura / Circulo / Rectangulo");
        Console.WriteLine("  U03_AbstraccionIntro.cs   -> Cuenta / CuentaAhorro / CuentaCredito");
        Console.WriteLine("  U04_InterfacesIntro.cs    -> IVolable / Pajaro / Avion");
        Console.WriteLine("\nEjecuta cada archivo con: dotnet run --file Nombre.cs");
    }

    static void DemoMapaJava()
    {
        Console.WriteLine("¡DEMO — Mapa C# vs Java!\n");
        Console.WriteLine("  Java extends      -> C# :");
        Console.WriteLine("  Java super()      -> C# base()");
        Console.WriteLine("  Java @Override    -> C# override (y virtual en la base)");
        Console.WriteLine("  Java instanceof   -> C# is / as");
        Console.WriteLine("  Java implements   -> C# : IXxx");
        Console.WriteLine("  Java Volable      -> C# IVolable (prefijo I)");
    }
}
