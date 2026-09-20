/*
OBJETIVO: abstract class Cuenta con Depositar concreto y Retirar abstracto;
  CuentaAhorro con limite diario. Menu do-while.

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
        Console.WriteLine("=== E05 Abstraccion CuentaAhorro ===");
        Console.WriteLine("1. Trabajar ejercicio");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"abstract class Cuenta: titular, saldo, Depositar, Retirar abstracto.
CuentaAhorro: limite de retiro diario; sin saldo negativo.
Crea una CuentaAhorro, deposita y retira; muestra el saldo.");
    }

    static void EjecutarEjercicio()
    {
        // TODO: Crear CuentaAhorro; Depositar y Retirar; mostrar saldo.
    }
}

// TODO: abstract class Cuenta; class CuentaAhorro : Cuenta.
