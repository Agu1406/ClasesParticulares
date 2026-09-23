#:package Microsoft.Data.Sqlite@9.0.0

/*
OBJETIVO: Mini-CRUD en alumnos.db: crear tabla, insertar 2, actualizar 1, borrar 1, listar.
  Menu do-while: completar desde un menu interactivo con opcion 0 para salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

using System;
using System.IO;
using Microsoft.Data.Sqlite;

public class Program
{
    const string Db = "alumnos.db";

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
        Console.WriteLine("=== E08 MiniCRUD ===");
        Console.WriteLine("1. Trabajar ejercicio");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Mini-CRUD en alumnos.db: crear tabla, insertar 2, actualizar 1, borrar 1, listar.");
    }

    static void EjecutarEjercicio()
    {
        // TODO: si existe alumnos.db, borrarlo; CREATE; INSERT Ana y Luis;
        //       UPDATE nota de Ana a 9.0; DELETE Luis; SELECT restantes;
        //       Dispose + SqliteConnection.ClearAllPools() y borrar alumnos.db
        //       (en Windows: Data Source=alumnos.db;Pooling=False)
    }
}
