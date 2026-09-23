#:package Microsoft.Data.Sqlite@9.0.0

/*
U03 — Parametros y using (disposicion de recursos).

OBJETIVO:
  - Usar Parameters.AddWithValue para pasar valores (evitar SQL injection).
  - Usar using var connection para liberar la conexion automaticamente.
  - Relacionar con JDBC PreparedStatement y Python placeholders ?.

En Java JDBC: PreparedStatement con ? y setString/setDouble.
En Python: cursor.execute(sql, (valor1, valor2)) — NUNCA f-strings con input.
En C#: command.Parameters.AddWithValue("@nombre", valor) — NUNCA interpolar input en SQL.

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
        Console.WriteLine("=== U03 ParametrosYUsing: AddWithValue / using ===");
        Console.WriteLine("1. using + INSERT con parametros");
        Console.WriteLine("2. SELECT parametrizado (WHERE)");
        Console.WriteLine("3. Peligro de concatenar (NO HACER)");
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
                    DemoUsingEInsertParametros();
                    break;
                case 2:
                    DemoSelectParametrizado();
                    break;
                case 3:
                    DemoPeligroConcatenar();
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

    /*
    PRIMERA PARTE — using var + CREATE / INSERT con @parametros.
    Al salir del bloque using se dispone la conexion (Dispose/Close).
    */
    static void DemoUsingEInsertParametros()
    {
        Console.WriteLine("¡DEMO 1: using connection + Parameters.AddWithValue!\n");
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

        string nombre = "Ana";
        double nota = 8.5;
        using (SqliteCommand insert = connection.CreateCommand())
        {
            // Seguro: el valor no se concatena en el SQL
            insert.CommandText = "INSERT INTO alumnos (nombre, nota) VALUES (@nombre, @nota)";
            insert.Parameters.AddWithValue("@nombre", nombre);
            insert.Parameters.AddWithValue("@nota", nota);
            insert.ExecuteNonQuery();

            insert.Parameters.Clear();
            insert.Parameters.AddWithValue("@nombre", "Luis");
            insert.Parameters.AddWithValue("@nota", 6.0);
            insert.ExecuteNonQuery();
        }

        Console.WriteLine("Insertados 2 alumnos con parametros @nombre / @nota.");
    }

    /*
    SEGUNDA PARTE — SELECT parametrizado (WHERE).
    */
    static void DemoSelectParametrizado()
    {
        Console.WriteLine("¡DEMO 2: SELECT con @umbral!\n");
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

        double umbral = 7.0;
        using SqliteCommand command = connection.CreateCommand();
        command.CommandText =
            "SELECT nombre, nota FROM alumnos WHERE nota >= @umbral ORDER BY nota DESC";
        command.Parameters.AddWithValue("@umbral", umbral);

        using SqliteDataReader reader = command.ExecuteReader();
        while (reader.Read())
        {
            Console.WriteLine($"  {reader.GetString(0)}: {reader.GetDouble(1)}");
        }
    }

    /*
    TERCERA PARTE — Por que NO concatenar (idea de SQL injection).
    Demostracion didactica: el input malicioso cambia el significado del SQL.
    */
    static void DemoPeligroConcatenar()
    {
        Console.WriteLine("¡DEMO 3: peligro de concatenar (NO HACER)!\n");
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
                """;
            setup.ExecuteNonQuery();
        }

        // Simulamos un "nombre" malicioso que cierra la comilla y anade OR 1=1
        string entradaMaliciosa = "x' OR '1'='1";
        string sqlInseguro = $"SELECT * FROM alumnos WHERE nombre = '{entradaMaliciosa}'";
        Console.WriteLine($"SQL inseguro generado:\n  {sqlInseguro}");

        using (SqliteCommand inseguro = connection.CreateCommand())
        {
            inseguro.CommandText = sqlInseguro;
            using SqliteDataReader reader = inseguro.ExecuteReader();
            int filas = 0;
            while (reader.Read())
            {
                filas++;
            }
            Console.WriteLine($"Filas devueltas (ataque OR 1=1): {filas}");
        }

        Console.WriteLine("\nForma segura con @nombre:");
        using (SqliteCommand seguro = connection.CreateCommand())
        {
            seguro.CommandText = "SELECT * FROM alumnos WHERE nombre = @nombre";
            seguro.Parameters.AddWithValue("@nombre", entradaMaliciosa);
            using SqliteDataReader reader = seguro.ExecuteReader();
            int filas = 0;
            while (reader.Read())
            {
                filas++;
            }
            Console.WriteLine($"Filas (ninguna, busca el literal): {filas}");
        }
    }
}
