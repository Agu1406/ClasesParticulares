/*
U06 — Tres en raya: un tablero es una matriz char[3,3].

OBJETIVO:
  - Representar un tablero con char[,] (fila, columna).
  - Pintar la matriz en consola con for anidados.
  - Detectar ganador recorriendo filas, columnas y diagonales.
  - Jugar una partida a dos jugadores con menu do-while.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U06 Tres en raya ===");
        Console.WriteLine("1. Jugar partida (dos jugadores)");
        Console.WriteLine("2. Demo: pintar tablero");
        Console.WriteLine("3. Demo: comprobar ganador");
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
                    JugarPartida();
                    break;
                case 2:
                    DemoPintarTablero();
                    break;
                case 3:
                    DemoComprobarGanador();
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
    Hueco = ' '. Jugador 1 = 'X'. Jugador 2 = 'O'.
    Indices: fila 0..2, columna 0..2.
    */
    static void PintarTablero(char[,] tablero)
    {
        Console.WriteLine("    0   1   2");
        for (int fila = 0; fila < 3; fila++)
        {
            Console.Write(" " + fila + " ");
            for (int col = 0; col < 3; col++)
            {
                Console.Write(" " + tablero[fila, col] + " ");
                if (col < 2)
                {
                    Console.Write("|");
                }
            }
            Console.WriteLine();
            if (fila < 2)
            {
                Console.WriteLine("   ---+---+---");
            }
        }
    }

    static bool HayGanador(char[,] tablero, char ficha)
    {
        for (int i = 0; i < 3; i++)
        {
            if (tablero[i, 0] == ficha && tablero[i, 1] == ficha && tablero[i, 2] == ficha)
            {
                return true;
            }
            if (tablero[0, i] == ficha && tablero[1, i] == ficha && tablero[2, i] == ficha)
            {
                return true;
            }
        }

        if (tablero[0, 0] == ficha && tablero[1, 1] == ficha && tablero[2, 2] == ficha)
        {
            return true;
        }
        if (tablero[0, 2] == ficha && tablero[1, 1] == ficha && tablero[2, 0] == ficha)
        {
            return true;
        }

        return false;
    }

    static bool TableroLleno(char[,] tablero)
    {
        for (int fila = 0; fila < 3; fila++)
        {
            for (int col = 0; col < 3; col++)
            {
                if (tablero[fila, col] == ' ')
                {
                    return false;
                }
            }
        }
        return true;
    }

    static void JugarPartida()
    {
        Console.WriteLine("¡PARTIDA — dos jugadores!\n");
        char[,] tablero = new char[3, 3];
        for (int fila = 0; fila < 3; fila++)
        {
            for (int col = 0; col < 3; col++)
            {
                tablero[fila, col] = ' ';
            }
        }

        char turno = 'X';
        bool terminada = false;
        while (!terminada)
        {
            PintarTablero(tablero);
            Console.WriteLine("Turno de " + turno);
            Console.Write("Fila (0-2): ");
            int fila = int.Parse(Console.ReadLine()!);
            Console.Write("Columna (0-2): ");
            int col = int.Parse(Console.ReadLine()!);

            if (fila < 0 || fila > 2 || col < 0 || col > 2)
            {
                Console.WriteLine("Indice fuera de rango.");
                continue;
            }
            if (tablero[fila, col] != ' ')
            {
                Console.WriteLine("Casilla ocupada.");
                continue;
            }

            tablero[fila, col] = turno;

            if (HayGanador(tablero, turno))
            {
                PintarTablero(tablero);
                Console.WriteLine("Gana " + turno + "!");
                terminada = true;
            }
            else if (TableroLleno(tablero))
            {
                PintarTablero(tablero);
                Console.WriteLine("Empate.");
                terminada = true;
            }
            else
            {
                if (turno == 'X')
                {
                    turno = 'O';
                }
                else
                {
                    turno = 'X';
                }
            }
        }
    }

    static void DemoPintarTablero()
    {
        Console.WriteLine("¡DEMO — tablero vacio y con una jugada!\n");
        char[,] vacio = new char[3, 3];
        for (int fila = 0; fila < 3; fila++)
        {
            for (int col = 0; col < 3; col++)
            {
                vacio[fila, col] = ' ';
            }
        }
        PintarTablero(vacio);

        Console.WriteLine();
        char[,] ejemplo = {
            { 'X', ' ', 'O' },
            { ' ', 'X', ' ' },
            { ' ', ' ', ' ' }
        };
        PintarTablero(ejemplo);
    }

    static void DemoComprobarGanador()
    {
        Console.WriteLine("¡DEMO — tres en raya en diagonal!\n");
        char[,] tablero = {
            { 'X', 'O', ' ' },
            { 'O', 'X', ' ' },
            { ' ', ' ', 'X' }
        };
        PintarTablero(tablero);
        Console.WriteLine("HayGanador X: " + HayGanador(tablero, 'X'));
        Console.WriteLine("HayGanador O: " + HayGanador(tablero, 'O'));
    }
}
