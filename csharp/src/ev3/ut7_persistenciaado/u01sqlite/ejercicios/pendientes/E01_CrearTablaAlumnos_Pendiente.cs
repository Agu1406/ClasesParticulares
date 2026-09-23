#:package Microsoft.Data.Sqlite@9.0.0

/*
OBJETIVO: Crea en :memory: la tabla alumnos (id INTEGER PK AUTOINCREMENT, nombre TEXT, nota REAL).
  Menu do-while: completar desde un menu interactivo con opcion 0 para salir.

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
        Console.WriteLine("=== E01 CrearTablaAlumnos ===");
        Console.WriteLine("1. Trabajar ejercicio");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Crea en :memory: la tabla alumnos (id INTEGER PK AUTOINCREMENT, nombre TEXT, nota REAL).");
    }

    static void EjecutarEjercicio()
    {
        // TODO: SqliteConnection("Data Source=:memory:"), Open, CREATE TABLE alumnos, imprimir "Tabla creada"
    }
}
