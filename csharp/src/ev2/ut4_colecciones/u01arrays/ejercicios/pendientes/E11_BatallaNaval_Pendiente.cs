/*
OBJETIVO: Batalla naval 6x6 con un barco de 3 celdas. Disparar por fila y columna
          (agua / tocado). Menu do-while, opcion 0 para salir.

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
        Console.WriteLine("1. Trabajar ejercicio");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine("Tablero char[6,6]. Un barco de 3 celdas (horizontal o vertical).");
        Console.WriteLine("El jugador dispara indicando fila y columna (0-5).");
        Console.WriteLine("~ agua, * disparo al agua, X barco tocado. Hundir las 3 celdas.");
    }

    static void EjecutarEjercicio()
    {
        char[,] oculto = new char[6, 6];
        char[,] visible = new char[6, 6];

        // TODO: Rellena ambos tableros con '~'.
        // TODO: Coloca un barco de 3 celdas (fijo o aleatorio) en oculto usando 'B'.
        // TODO: Bucle: pintar visible, pedir fila y columna, actualizar disparo.
        // TODO: Gana cuando las 3 celdas del barco estan tocadas (X).
    }
}
