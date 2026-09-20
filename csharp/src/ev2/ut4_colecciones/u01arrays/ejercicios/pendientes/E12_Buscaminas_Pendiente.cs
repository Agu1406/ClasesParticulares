/*
OBJETIVO: Buscaminas 5x5 con 4 minas. Revelar una celda por turno y mostrar
          el numero de minas vecinas (bucle ±1, sin recursion). Menu do-while.

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
        Console.WriteLine("=== E12 Buscaminas ===");
        Console.WriteLine("1. Trabajar ejercicio");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine("bool[5,5] minas + int[5,5] vecinas + bool[5,5] revelado.");
        Console.WriteLine("Coloca 4 minas. Recorre vecinos fila±1, col±1 (dentro de rango).");
        Console.WriteLine("Cada turno revelas UNA celda. Si hay mina, pierdes.");
        Console.WriteLine("Ganas al revelar las 21 celdas sin mina. Sin recursion.");
    }

    static void EjecutarEjercicio()
    {
        bool[,] minas = new bool[5, 5];
        int[,] vecinas = new int[5, 5];
        bool[,] revelado = new bool[5, 5];

        // TODO: Coloca 4 minas (fijas o aleatorias) en minas[,].
        // TODO: Para cada celda, cuenta minas en las 8 vecinas (for df, dc de -1 a 1).
        // TODO: Bucle: pedir fila/columna, revelar, pintar tablero, comprobar victoria/derrota.
    }
}
