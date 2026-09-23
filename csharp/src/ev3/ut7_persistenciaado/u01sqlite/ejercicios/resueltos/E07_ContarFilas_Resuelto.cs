#:package Microsoft.Data.Sqlite@9.0.0

/*
OBJETIVO: Cuenta filas en alumnos tras insertar 4 registros (esperado: 4).
SOLUCION: SELECT COUNT(*) + ExecuteScalar.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

using System;
using Microsoft.Data.Sqlite;

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
        Console.WriteLine("=== E07 ContarFilas (resuelto) ===");
        Console.WriteLine("1. Ejecutar solucion");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Cuenta filas en alumnos tras insertar 4 registros (esperado: 4).");
    }

    static void EjecutarEjercicio()
    {
        using var connection = new SqliteConnection("Data Source=:memory:");
        connection.Open();

        using (SqliteCommand setup = connection.CreateCommand())
        {
            setup.CommandText =
                """
                CREATE TABLE alumnos (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nombre TEXT NOT NULL,
                    nota REAL
                );
                INSERT INTO alumnos (nombre, nota) VALUES ('Ana', 8.5);
                INSERT INTO alumnos (nombre, nota) VALUES ('Luis', 6.0);
                INSERT INTO alumnos (nombre, nota) VALUES ('Maria', 9.0);
                INSERT INTO alumnos (nombre, nota) VALUES ('Pedro', 4.5);
                """;
            setup.ExecuteNonQuery();
        }

        using SqliteCommand count = connection.CreateCommand();
        count.CommandText = "SELECT COUNT(*) FROM alumnos";
        Console.WriteLine(count.ExecuteScalar());
    }
}
