#:package Microsoft.Data.Sqlite@9.0.0

/*
U01 — Introduccion a SQLite con ADO.NET: conexion, comando y escritura.

OBJETIVO:
  - Abrir SqliteConnection (Data Source=:memory: o fichero .db).
  - Crear comando con CreateCommand y ejecutar CREATE TABLE / INSERT.
  - Abrir la conexion con Open antes de ejecutar.
  - Relacionar con JDBC Connection / Statement / executeUpdate y Python sqlite3.

En Java JDBC: DriverManager.getConnection + Statement.executeUpdate.
En Python: sqlite3.connect + cursor.execute + commit.
En C# ADO.NET: SqliteConnection + CreateCommand + ExecuteNonQuery.

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
        Console.WriteLine("=== U01 SqliteIntro: Connection / Command ===");
        Console.WriteLine("1. Connect en :memory:");
        Console.WriteLine("2. CREATE e INSERT");
        Console.WriteLine("3. Open y ciclo basico");
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
                    DemoConnectMemory();
                    break;
                case 2:
                    DemoCreateEInsert();
                    break;
                case 3:
                    DemoOpenYCiclo();
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
    PRIMERA PARTE — Conexion en memoria (:memory:).
    Equivalente pedagogico a abrir Connection en JDBC / sqlite3.connect(":memory:").
    */
    static void DemoConnectMemory()
    {
        Console.WriteLine("¡DEMO 1: CONNECT EN :memory:!\n");
        var connection = new SqliteConnection("Data Source=:memory:");
        Console.WriteLine($"Tipo de conexion: {connection.GetType().Name}");
        Console.WriteLine($"ConnectionString: {connection.ConnectionString}");
        Console.WriteLine($"Estado inicial (sin Open): {connection.State}");
        connection.Dispose();
        Console.WriteLine("Conexion liberada (Dispose).");
    }

    /*
    SEGUNDA PARTE — CreateCommand + CREATE TABLE + INSERT + ExecuteNonQuery.
    En JDBC: Statement.executeUpdate. En Python: cursor.execute + commit.
    En SQLite in-memory no hace falta commit explicito con Microsoft.Data.Sqlite
    para que los datos vivan mientras la conexion este abierta.
    */
    static void DemoCreateEInsert()
    {
        Console.WriteLine("¡DEMO 2: CREATE E INSERT!\n");
        var connection = new SqliteConnection("Data Source=:memory:");
        connection.Open();

        SqliteCommand command = connection.CreateCommand();
        command.CommandText =
            """
            CREATE TABLE alumnos (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre TEXT NOT NULL,
                nota REAL
            )
            """;
        command.ExecuteNonQuery();

        command.CommandText = "INSERT INTO alumnos (nombre, nota) VALUES ('Ana', 8.5)";
        command.ExecuteNonQuery();
        command.CommandText = "INSERT INTO alumnos (nombre, nota) VALUES ('Luis', 6.0)";
        command.ExecuteNonQuery();

        command.CommandText = "SELECT last_insert_rowid()";
        long lastId = (long)command.ExecuteScalar()!;
        Console.WriteLine("Tabla alumnos creada e insertados 2 registros.");
        Console.WriteLine($"Ultimo rowid insertado: {lastId}");

        connection.Dispose();
    }

    /*
    TERCERA PARTE — Open es obligatorio antes de Execute*.
    Sin Open -> InvalidOperationException.
    */
    static void DemoOpenYCiclo()
    {
        Console.WriteLine("¡DEMO 3: OPEN Y CICLO BASICO!\n");
        using var connection = new SqliteConnection("Data Source=:memory:");
        Console.WriteLine($"Antes de Open: {connection.State}");
        connection.Open();
        Console.WriteLine($"Despues de Open: {connection.State}");

        using SqliteCommand command = connection.CreateCommand();
        command.CommandText = "SELECT 1 + 1";
        object? resultado = command.ExecuteScalar();
        Console.WriteLine($"ExecuteScalar SELECT 1+1 -> {resultado}");
        Console.WriteLine("(using libera la conexion al salir del metodo)");
    }
}
