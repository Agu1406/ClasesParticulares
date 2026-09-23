#:package Microsoft.Data.Sqlite@9.0.0

/*
OBJETIVO: Muestra alumnos con nota >= 7 (datos: Ana 8.5, Luis 6.0, Maria 9.0, Pedro 4.5).
SOLUCION: SELECT WHERE nota >= @umbral + ExecuteReader.

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
        Console.WriteLine("=== E04 SelectWhereNota (resuelto) ===");
        Console.WriteLine("1. Ejecutar solucion");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Muestra alumnos con nota >= 7 (datos: Ana 8.5, Luis 6.0, Maria 9.0, Pedro 4.5).");
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

        using SqliteCommand command = connection.CreateCommand();
        command.CommandText = "SELECT nombre, nota FROM alumnos WHERE nota >= @umbral";
        command.Parameters.AddWithValue("@umbral", 7);
        using SqliteDataReader reader = command.ExecuteReader();
        while (reader.Read())
        {
            Console.WriteLine($"{reader.GetString(0)}: {reader.GetDouble(1)}");
        }
    }
}
