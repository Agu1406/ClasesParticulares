#:package Microsoft.Data.Sqlite@9.0.0

/*
OBJETIVO: Inserta Ana(8.5), Luis(6.0), Maria(9.0) en alumnos y muestra cuantas filas hay.
SOLUCION: INSERT parametrizado + COUNT(*) + ExecuteScalar.

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
        Console.WriteLine("=== E02 InsertarAlumnos (resuelto) ===");
        Console.WriteLine("1. Ejecutar solucion");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Inserta Ana(8.5), Luis(6.0), Maria(9.0) en alumnos y muestra cuantas filas hay.");
    }

    static void EjecutarEjercicio()
    {
        using var connection = new SqliteConnection("Data Source=:memory:");
        connection.Open();

        using (SqliteCommand create = connection.CreateCommand())
        {
            create.CommandText =
                """
                CREATE TABLE alumnos (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nombre TEXT NOT NULL,
                    nota REAL
                )
                """;
            create.ExecuteNonQuery();
        }

        (string Nombre, double Nota)[] alumnos =
        {
            ("Ana", 8.5),
            ("Luis", 6.0),
            ("Maria", 9.0),
        };

        using (SqliteCommand insert = connection.CreateCommand())
        {
            insert.CommandText = "INSERT INTO alumnos (nombre, nota) VALUES (@nombre, @nota)";
            foreach (var alumno in alumnos)
            {
                insert.Parameters.Clear();
                insert.Parameters.AddWithValue("@nombre", alumno.Nombre);
                insert.Parameters.AddWithValue("@nota", alumno.Nota);
                insert.ExecuteNonQuery();
            }
        }

        using SqliteCommand count = connection.CreateCommand();
        count.CommandText = "SELECT COUNT(*) FROM alumnos";
        long total = (long)count.ExecuteScalar()!;
        Console.WriteLine(total);
    }
}
