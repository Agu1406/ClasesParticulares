#:sdk Microsoft.NET.Sdk.Web
#:package Microsoft.AspNetCore.TestHost@9.0.0
#:property PublishAot=false
#:property JsonSerializerIsReflectionEnabledByDefault=true

/*
OBJETIVO: Mini-API en memoria: GET '/api/alumnos' (lista) y GET '/api/alumnos/{id}' (uno o 404).
Datos iniciales: [{id:1,nombre:Ana,nota:8.5}, {id:2,nombre:Luis,nota:6.0}].
  Menu do-while: completar desde un menu interactivo con opcion 0 para salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.TestHost;

public class Program
{
    static readonly List<Alumno> Alumnos =
    [
        new Alumno(1, "Ana", 8.5),
        new Alumno(2, "Luis", 6.0)
    ];

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
        Console.WriteLine("=== E08 MiniApiAlumnos ===");
        Console.WriteLine("1. Trabajar ejercicio");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"Mini-API en memoria: GET '/api/alumnos' (lista) y GET '/api/alumnos/{id}' (uno o 404).");
    }

    static void EjecutarEjercicio()
    {
        EjecutarEjercicioAsync().GetAwaiter().GetResult();
    }

    static async Task EjecutarEjercicioAsync()
    {
        var builder = WebApplication.CreateBuilder();
        builder.WebHost.UseTestServer();
        var app = builder.Build();

        app.MapGet("/api/alumnos", () =>
        {
            // TODO: return Results.Json(Alumnos);
            return Results.Empty;
        });

        app.MapGet("/api/alumnos/{id:int}", (int id) =>
        {
            // TODO: buscar por id; si existe Results.Json(alumno), si no Results.Json(..., statusCode: 404)
            return Results.Empty;
        });

        // TODO: GET lista, GET /api/alumnos/1 y /api/alumnos/99
        await app.DisposeAsync();
    }
}

record Alumno(int Id, string Nombre, double Nota);
