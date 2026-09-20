/*
U04 — Arrays bidimensionales (matrices).

OBJETIVO:
  - Declarar una matriz con int[,] (filas y columnas).
  - Acceder a elementos con dos indices: matriz[fila, columna].
  - Recorrer una matriz con for anidados y llaves { }.
  - Entender la diferencia basica entre matriz rectangular y array escalonado.
  - Practicar class + Main + menu do-while (EV1).
  - Aplicacion: U06 Tres en raya (tablero char[3,3]).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U04 Arrays bidimensionales ===");
        Console.WriteLine("1. Crear y acceder a int[,]");
        Console.WriteLine("2. Recorrido con for anidados");
        Console.WriteLine("3. Tabla de notas 3x2");
        Console.WriteLine("4. Array escalonado (referencia)");
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
                    DemoCrearMatriz();
                    break;
                case 2:
                    DemoForAnidados();
                    break;
                case 3:
                    DemoTablaNotas();
                    break;
                case 4:
                    DemoEscalonado();
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

    static void DemoCrearMatriz()
    {
        Console.WriteLine("¡DEMO — Crear y acceder a int[,]!\n");
        int[,] matriz = {
            { 1, 2 },
            { 3, 4 }
        };

        Console.WriteLine("matriz[0,0] = " + matriz[0, 0]);
        Console.WriteLine("matriz[0,1] = " + matriz[0, 1]);
        Console.WriteLine("matriz[1,0] = " + matriz[1, 0]);
        Console.WriteLine("matriz[1,1] = " + matriz[1, 1]);
        Console.WriteLine("Filas (GetLength(0)): " + matriz.GetLength(0));
        Console.WriteLine("Columnas (GetLength(1)): " + matriz.GetLength(1));
    }

    static void DemoForAnidados()
    {
        Console.WriteLine("¡DEMO — Recorrido con for anidados!\n");
        int[,] matriz = {
            { 1, 2 },
            { 3, 4 }
        };

        for (int fila = 0; fila < matriz.GetLength(0); fila++)
        {
            for (int col = 0; col < matriz.GetLength(1); col++)
            {
                Console.WriteLine("  matriz[" + fila + "," + col + "] = " + matriz[fila, col]);
            }
        }
    }

    static void DemoTablaNotas()
    {
        Console.WriteLine("¡DEMO — Tabla de notas 3x2!\n");
        int[,] notas = new int[3, 2];
        notas[0, 0] = 7;
        notas[0, 1] = 8;
        notas[1, 0] = 6;
        notas[1, 1] = 9;
        notas[2, 0] = 5;
        notas[2, 1] = 7;

        for (int fila = 0; fila < notas.GetLength(0); fila++)
        {
            Console.Write("  Alumno " + (fila + 1) + ": ");
            for (int col = 0; col < notas.GetLength(1); col++)
            {
                Console.Write(notas[fila, col]);
                if (col < notas.GetLength(1) - 1)
                {
                    Console.Write(", ");
                }
            }
            Console.WriteLine();
        }
    }

    static void DemoEscalonado()
    {
        Console.WriteLine("¡DEMO — Array escalonado (referencia)!\n");
        int[][] escalonada = new int[2][];
        escalonada[0] = new int[] { 10, 20 };
        escalonada[1] = new int[] { 30, 40, 50 };

        for (int f = 0; f < escalonada.Length; f++)
        {
            for (int c = 0; c < escalonada[f].Length; c++)
            {
                Console.WriteLine("  escalonada[" + f + "][" + c + "] = " + escalonada[f][c]);
            }
        }
    }
}

