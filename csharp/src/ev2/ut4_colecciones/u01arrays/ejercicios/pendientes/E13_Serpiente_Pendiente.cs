/*
OBJETIVO: Serpiente por turnos en un tablero 8x8. Cuerpo en int[] posX / posY.
          Movimiento WASD un paso por turno. Sin List ni Thread.Sleep.

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
        Console.WriteLine("=== E13 Serpiente ===");
        Console.WriteLine("1. Trabajar ejercicio");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine("Tablero char[8,8]. Cuerpo: int[] posX, int[] posY y int longitud.");
        Console.WriteLine("Cada turno lees W/A/S/D, mueves la cabeza, desplazas el cuerpo.");
        Console.WriteLine("Manzana '@'. Chocar con borde o contigo mismo termina.");
        Console.WriteLine("No uses List ni Thread.Sleep: un paso por Console.ReadLine.");
    }

    static void EjecutarEjercicio()
    {
        int[] posX = new int[64];
        int[] posY = new int[64];
        int longitud = 3;

        // TODO: Inicializa el cuerpo (por ejemplo fila 4, columnas 2,3,4).
        // TODO: Coloca una manzana en una celda libre.
        // TODO: Bucle: pintar tablero, leer WASD, calcular nueva cabeza.
        // TODO: Si come manzana, longitud++. Si choca, terminar.
    }
}
