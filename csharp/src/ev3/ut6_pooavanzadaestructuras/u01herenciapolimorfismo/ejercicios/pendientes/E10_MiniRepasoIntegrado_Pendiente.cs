/*
OBJETIVO: Mini-repaso integrado: menú con 2-3 demos de jerarquia
  (herencia animales, figuras, o volables). Menu do-while.

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
        Console.WriteLine("=== E10 Mini-repaso integrado ===");
        Console.WriteLine("1. Trabajar ejercicio");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Integra al menos DOS de estas demos en el mismo archivo:
  A) Animal/Perro/Gato + HacerSonido
  B) Figura[] + CalcularArea
  C) IVolable[] + Despegar/Aterrizar
Opcion 1 del menu puede lanzar un submenu 1/2/3 de demos, o ejecutar las tres.");
    }

    static void EjecutarEjercicio()
    {
        // TODO: Implementar 2-3 demos de jerarquia (submenu o secuencia).
    }
}

// TODO: Clases de dominio necesarias para tus demos.
