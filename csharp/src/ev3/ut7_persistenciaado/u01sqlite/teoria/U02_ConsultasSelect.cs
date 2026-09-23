#:package Microsoft.Data.Sqlite@9.0.0

/*
U02 — Consultas SELECT: ExecuteReader y WHERE.

OBJETIVO:
  - Ejecutar SELECT y recorrer filas con SqliteDataReader (Read).
  - Filtrar con WHERE.
  - Relacionar con JDBC ResultSet y Python fetchall / fetchone.

En Java JDBC: Statement.executeQuery + ResultSet.next().
En Python: cursor.execute("SELECT...") + fetchall() / fetchone().
En C# ADO.NET: ExecuteReader + while (reader.Read()).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

using System;
using Microsoft.Data.Sqlite;

public class Program
{
    static void ImprimirMenu()
    {
        Console.WriteLine("=== U02 ConsultasSelect: Reader / WHERE ===");
        Console.WriteLine("1. SELECT + ExecuteReader (todas las filas)");
        Console.WriteLine("2. Una fila (equivalente a fetchone)");
        Console.WriteLine("3. WHERE nota >= 7");
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
                    DemoSelectReader();
                    break;
                case 2:
                    DemoUnaFila();
                    break;
                case 3:
                    DemoWhereNota();
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

    static SqliteConnection CrearBaseDemo()
    {
        var connection = new SqliteConnection("Data Source=:memory:");
        connection.Open();

        using (SqliteCommand cmd = connection.CreateCommand())
        {
            cmd.CommandText =
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
            cmd.ExecuteNonQuery();
        }

        return connection;
    }

    /*
    PRIMERA PARTE — SELECT * + ExecuteReader (todas las filas).
    Cada Read() avanza una fila; GetInt64 / GetString / GetDouble leen columnas.
    */
    static void DemoSelectReader()
    {
        Console.WriteLine("¡DEMO 1: SELECT + ExecuteReader!\n");
        using SqliteConnection connection = CrearBaseDemo();
        using SqliteCommand command = connection.CreateCommand();
        command.CommandText = "SELECT id, nombre, nota FROM alumnos";

        int total = 0;
        using (SqliteDataReader reader = command.ExecuteReader())
        {
            while (reader.Read())
            {
                total++;
                long id = reader.GetInt64(0);
                string nombre = reader.GetString(1);
                double nota = reader.GetDouble(2);
                Console.WriteLine($"  id={id} nombre={nombre} nota={nota}");
            }
        }
        Console.WriteLine($"ExecuteReader -> {total} filas.");
    }

    /*
    SEGUNDA PARTE — Una sola fila (como fetchone): Read() una vez o null.
    Util para PRIMARY KEY o LIMIT 1.
    */
    static void DemoUnaFila()
    {
        Console.WriteLine("¡DEMO 2: una fila (fetchone)!\n");
        using SqliteConnection connection = CrearBaseDemo();
        using SqliteCommand command = connection.CreateCommand();

        command.CommandText = "SELECT id, nombre, nota FROM alumnos WHERE nombre = 'Ana'";
        using (SqliteDataReader reader = command.ExecuteReader())
        {
            if (reader.Read())
            {
                Console.WriteLine($"Ana: id={reader.GetInt64(0)} nota={reader.GetDouble(2)}");
            }
            else
            {
                Console.WriteLine("Ana: (sin filas)");
            }
        }

        command.CommandText = "SELECT id, nombre, nota FROM alumnos WHERE nombre = 'Nadie'";
        using (SqliteDataReader reader = command.ExecuteReader())
        {
            Console.WriteLine(reader.Read()
                ? $"Nadie: {reader.GetString(1)}"
                : "Nadie: (sin filas / null)");
        }
    }

    /*
    TERCERA PARTE — WHERE con condicion numerica.
    */
    static void DemoWhereNota()
    {
        Console.WriteLine("¡DEMO 3: WHERE nota >= 7!\n");
        using SqliteConnection connection = CrearBaseDemo();
        using SqliteCommand command = connection.CreateCommand();
        command.CommandText =
            "SELECT nombre, nota FROM alumnos WHERE nota >= 7 ORDER BY nota DESC";

        using SqliteDataReader reader = command.ExecuteReader();
        while (reader.Read())
        {
            Console.WriteLine($"  {reader.GetString(0)}: {reader.GetDouble(1)}");
        }
    }
}
