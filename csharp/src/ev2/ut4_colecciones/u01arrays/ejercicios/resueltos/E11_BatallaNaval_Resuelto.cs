/*
OBJETIVO: Batalla naval 6x6 con un barco de 3 celdas. Disparar por fila y columna
          (agua / tocado). Menu do-while, opcion 0 para salir.
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
        Console.WriteLine("=== E11 Batalla naval ===");
        Console.WriteLine("1. Jugar");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine("Tablero char[6,6]. Un barco de 3 celdas (horizontal o vertical).");
        Console.WriteLine("El jugador dispara indicando fila y columna (0-5).");
        Console.WriteLine("~ agua, * disparo al agua, X barco tocado. Hundir las 3 celdas.");
    }

    static void Pintar(char[,] tablero)
    {
        Console.Write("   ");
        for (int col = 0; col < 6; col++)
        {
            Console.Write(col + " ");
        }
        Console.WriteLine();
        for (int fila = 0; fila < 6; fila++)
        {
            Console.Write(fila + "  ");
            for (int col = 0; col < 6; col++)
            {
                Console.Write(tablero[fila, col] + " ");
            }
            Console.WriteLine();
        }
    }

    static void EjecutarEjercicio()
    {
        char[,] oculto = new char[6, 6];
        char[,] visible = new char[6, 6];
        for (int fila = 0; fila < 6; fila++)
        {
            for (int col = 0; col < 6; col++)
            {
                oculto[fila, col] = '~';
                visible[fila, col] = '~';
            }
        }

        // Barco fijo horizontal en fila 2, columnas 1-3 (didactico).
        oculto[2, 1] = 'B';
        oculto[2, 2] = 'B';
        oculto[2, 3] = 'B';

        int toques = 0;
        while (toques < 3)
        {
            Pintar(visible);
            Console.Write("Fila (0-5): ");
            int fila = int.Parse(Console.ReadLine()!);
            Console.Write("Columna (0-5): ");
            int col = int.Parse(Console.ReadLine()!);

            if (fila < 0 || fila > 5 || col < 0 || col > 5)
            {
                Console.WriteLine("Fuera del tablero.");
                continue;
            }
            if (visible[fila, col] == '*' || visible[fila, col] == 'X')
            {
                Console.WriteLine("Ya disparaste ahi.");
                continue;
            }

            if (oculto[fila, col] == 'B')
            {
                visible[fila, col] = 'X';
                toques++;
                Console.WriteLine("Tocado! (" + toques + "/3)");
            }
            else
            {
                visible[fila, col] = '*';
                Console.WriteLine("Agua.");
            }
        }

        Pintar(visible);
        Console.WriteLine("Hundido. Has ganado.");
    }
}
