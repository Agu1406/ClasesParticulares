#:package Microsoft.Data.Sqlite@9.0.0

/*
OBJETIVO: Borra el alumno con id=2 y muestra los ids restantes (esperado: 1 y 3).
SOLUCION: DELETE WHERE id = @id + SELECT id.

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
        Console.WriteLine("=== E06 DeletePorId (resuelto) ===");
        Console.WriteLine("1. Ejecutar solucion");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Borra el alumno con id=2 y muestra los ids restantes (esperado: 1 y 3).");
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
                """;
            setup.ExecuteNonQuery();
        }

        using (SqliteCommand delete = connection.CreateCommand())
        {
            delete.CommandText = "DELETE FROM alumnos WHERE id = @id";
            delete.Parameters.AddWithValue("@id", 2);
            delete.ExecuteNonQuery();
        }

        using SqliteCommand select = connection.CreateCommand();
        select.CommandText = "SELECT id FROM alumnos ORDER BY id";
        using SqliteDataReader reader = select.ExecuteReader();
        while (reader.Read())
        {
            Console.WriteLine(reader.GetInt64(0));
        }
    }
}
