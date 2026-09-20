/*
OBJETIVO: Buscaminas 5x5 con 4 minas. Revelar una celda por turno y mostrar
          el numero de minas vecinas (bucle ±1, sin recursion). Menu do-while.
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
        Console.WriteLine("=== E12 Buscaminas ===");
        Console.WriteLine("1. Jugar");
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

    static int ContarVecinas(bool[,] minas, int fila, int col)
    {
        int total = 0;
        for (int df = -1; df <= 1; df++)
        {
            for (int dc = -1; dc <= 1; dc++)
            {
                if (df == 0 && dc == 0)
                {
                    continue;
                }
                int nf = fila + df;
                int nc = col + dc;
                if (nf >= 0 && nf < 5 && nc >= 0 && nc < 5)
                {
                    if (minas[nf, nc])
                    {
                        total++;
                    }
                }
            }
        }
        return total;
    }

    static void Pintar(bool[,] minas, int[,] vecinas, bool[,] revelado, bool mostrarMinas)
    {
        Console.Write("   ");
        for (int col = 0; col < 5; col++)
        {
            Console.Write(col + " ");
        }
        Console.WriteLine();
        for (int fila = 0; fila < 5; fila++)
        {
            Console.Write(fila + "  ");
            for (int col = 0; col < 5; col++)
            {
                if (mostrarMinas && minas[fila, col])
                {
                    Console.Write("* ");
                }
                else if (!revelado[fila, col])
                {
                    Console.Write(". ");
                }
                else
                {
                    Console.Write(vecinas[fila, col] + " ");
                }
            }
            Console.WriteLine();
        }
    }

    static void EjecutarEjercicio()
    {
        bool[,] minas = new bool[5, 5];
        int[,] vecinas = new int[5, 5];
        bool[,] revelado = new bool[5, 5];

        // 4 minas fijas (didactico).
        minas[0, 1] = true;
        minas[1, 3] = true;
        minas[3, 0] = true;
        minas[4, 4] = true;

        for (int fila = 0; fila < 5; fila++)
        {
            for (int col = 0; col < 5; col++)
            {
                vecinas[fila, col] = ContarVecinas(minas, fila, col);
            }
        }

        int reveladas = 0;
        bool explotado = false;
        while (!explotado && reveladas < 21)
        {
            Pintar(minas, vecinas, revelado, false);
            Console.Write("Fila (0-4): ");
            int fila = int.Parse(Console.ReadLine()!);
            Console.Write("Columna (0-4): ");
            int col = int.Parse(Console.ReadLine()!);

            if (fila < 0 || fila > 4 || col < 0 || col > 4)
            {
                Console.WriteLine("Fuera del tablero.");
                continue;
            }
            if (revelado[fila, col])
            {
                Console.WriteLine("Ya revelada.");
                continue;
            }

            if (minas[fila, col])
            {
                explotado = true;
                Console.WriteLine("Mina. Has perdido.");
                Pintar(minas, vecinas, revelado, true);
            }
            else
            {
                revelado[fila, col] = true;
                reveladas++;
                Console.WriteLine("Vecinas: " + vecinas[fila, col]);
            }
        }

        if (!explotado)
        {
            Pintar(minas, vecinas, revelado, true);
            Console.WriteLine("Has ganado.");
        }
    }
}
