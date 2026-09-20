/*
OBJETIVO: Serpiente por turnos en un tablero 8x8. Cuerpo en int[] posX / posY.
          Movimiento WASD un paso por turno. Sin List ni Thread.Sleep.
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
        Console.WriteLine("=== E13 Serpiente ===");
        Console.WriteLine("1. Jugar");
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

    static void Pintar(int[] posX, int[] posY, int longitud, int manzanaX, int manzanaY)
    {
        char[,] tablero = new char[8, 8];
        for (int fila = 0; fila < 8; fila++)
        {
            for (int col = 0; col < 8; col++)
            {
                tablero[fila, col] = '.';
            }
        }

        tablero[manzanaY, manzanaX] = '@';
        for (int i = 0; i < longitud; i++)
        {
            tablero[posY[i], posX[i]] = i == 0 ? 'O' : 'o';
        }

        for (int fila = 0; fila < 8; fila++)
        {
            for (int col = 0; col < 8; col++)
            {
                Console.Write(tablero[fila, col]);
            }
            Console.WriteLine();
        }
    }

    static bool CeldaOcupada(int[] posX, int[] posY, int longitud, int x, int y)
    {
        for (int i = 0; i < longitud; i++)
        {
            if (posX[i] == x && posY[i] == y)
            {
                return true;
            }
        }
        return false;
    }

    static void ColocarManzana(int[] posX, int[] posY, int longitud, out int manzanaX, out int manzanaY)
    {
        manzanaX = 6;
        manzanaY = 1;
        for (int y = 0; y < 8; y++)
        {
            for (int x = 0; x < 8; x++)
            {
                if (!CeldaOcupada(posX, posY, longitud, x, y))
                {
                    manzanaX = x;
                    manzanaY = y;
                    return;
                }
            }
        }
    }

    static void EjecutarEjercicio()
    {
        int[] posX = new int[64];
        int[] posY = new int[64];
        int longitud = 3;
        posX[0] = 4;
        posY[0] = 4;
        posX[1] = 3;
        posY[1] = 4;
        posX[2] = 2;
        posY[2] = 4;

        int manzanaX;
        int manzanaY;
        ColocarManzana(posX, posY, longitud, out manzanaX, out manzanaY);

        bool viva = true;
        while (viva)
        {
            Console.Clear();
            Pintar(posX, posY, longitud, manzanaX, manzanaY);
            Console.Write("WASD (o Q para rendirse): ");
            string tecla = (Console.ReadLine() ?? "").Trim().ToUpper();
            if (tecla == "Q")
            {
                Console.WriteLine("Fin.");
                break;
            }

            int dx = 0;
            int dy = 0;
            if (tecla == "W")
            {
                dy = -1;
            }
            else if (tecla == "S")
            {
                dy = 1;
            }
            else if (tecla == "A")
            {
                dx = -1;
            }
            else if (tecla == "D")
            {
                dx = 1;
            }
            else
            {
                Console.WriteLine("Usa W A S D.");
                Console.ReadLine();
                continue;
            }

            int nuevaX = posX[0] + dx;
            int nuevaY = posY[0] + dy;

            if (nuevaX < 0 || nuevaX > 7 || nuevaY < 0 || nuevaY > 7)
            {
                Console.WriteLine("Chocaste con el borde.");
                viva = false;
                continue;
            }

            bool come = nuevaX == manzanaX && nuevaY == manzanaY;
            int limiteCuerpo = come ? longitud : longitud - 1;
            if (CeldaOcupada(posX, posY, limiteCuerpo, nuevaX, nuevaY))
            {
                Console.WriteLine("Chocaste contigo.");
                viva = false;
                continue;
            }

            int colaX = posX[longitud - 1];
            int colaY = posY[longitud - 1];

            for (int i = longitud - 1; i >= 1; i--)
            {
                posX[i] = posX[i - 1];
                posY[i] = posY[i - 1];
            }
            posX[0] = nuevaX;
            posY[0] = nuevaY;

            if (come)
            {
                posX[longitud] = colaX;
                posY[longitud] = colaY;
                longitud++;
                ColocarManzana(posX, posY, longitud, out manzanaX, out manzanaY);
                Console.WriteLine("Manzana. Longitud = " + longitud);
            }
        }
    }
}
