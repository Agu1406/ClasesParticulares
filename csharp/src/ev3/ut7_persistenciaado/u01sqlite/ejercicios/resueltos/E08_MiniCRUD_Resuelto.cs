#:package Microsoft.Data.Sqlite@9.0.0

/*
OBJETIVO: Mini-CRUD en alumnos.db: crear tabla, insertar 2, actualizar 1, borrar 1, listar.
SOLUCION: fichero alumnos.db creado y borrado en el script (CREATE/INSERT/UPDATE/DELETE/SELECT).

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
        Console.WriteLine("=== E08 MiniCRUD (resuelto) ===");
        Console.WriteLine("1. Ejecutar solucion");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Mini-CRUD en alumnos.db: crear tabla, insertar 2, actualizar 1, borrar 1, listar.");
    }

    static void EjecutarEjercicio()
    {
        if (File.Exists(Db))
        {
            File.Delete(Db);
        }

        using (var connection = new SqliteConnection($"Data Source={Db};Pooling=False"))
        {
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

            using (SqliteCommand insert = connection.CreateCommand())
            {
                insert.CommandText = "INSERT INTO alumnos (nombre, nota) VALUES (@nombre, @nota)";
                insert.Parameters.AddWithValue("@nombre", "Ana");
                insert.Parameters.AddWithValue("@nota", 8.5);
                insert.ExecuteNonQuery();

                insert.Parameters.Clear();
                insert.Parameters.AddWithValue("@nombre", "Luis");
                insert.Parameters.AddWithValue("@nota", 6.0);
                insert.ExecuteNonQuery();
            }

            using (SqliteCommand update = connection.CreateCommand())
            {
                update.CommandText = "UPDATE alumnos SET nota = @nota WHERE nombre = @nombre";
                update.Parameters.AddWithValue("@nota", 9.0);
                update.Parameters.AddWithValue("@nombre", "Ana");
                update.ExecuteNonQuery();
            }

            using (SqliteCommand delete = connection.CreateCommand())
            {
                delete.CommandText = "DELETE FROM alumnos WHERE nombre = @nombre";
                delete.Parameters.AddWithValue("@nombre", "Luis");
                delete.ExecuteNonQuery();
            }

            using SqliteCommand select = connection.CreateCommand();
            select.CommandText = "SELECT id, nombre, nota FROM alumnos";
            using SqliteDataReader reader = select.ExecuteReader();
            while (reader.Read())
            {
                Console.WriteLine($"({reader.GetInt64(0)}, '{reader.GetString(1)}', {reader.GetDouble(2)})");
            }
        }

        // En Windows el pool puede retener el fichero; ClearAllPools libera el handle.
        SqliteConnection.ClearAllPools();
        if (File.Exists(Db))
        {
            File.Delete(Db);
            Console.WriteLine($"{Db} eliminado");
        }
    }
}
