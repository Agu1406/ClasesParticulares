#:sdk Microsoft.NET.Sdk.Web
#:package Microsoft.AspNetCore.TestHost@9.0.0
#:property PublishAot=false
#:property JsonSerializerIsReflectionEnabledByDefault=true

/*
OBJETIVO: GET '/api/alumno' devuelve JSON {"nombre": "Ana", "nota": 8.5}.
SOLUCION: Results.Json de objeto anonimo + GetTestClient.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

using System;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.TestHost;

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
        Console.WriteLine("=== E06 JsonObjetoAlumno (resuelto) ===");
        Console.WriteLine("1. Ejecutar solucion");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"GET '/api/alumno' devuelve JSON {""nombre"": ""Ana"", ""nota"": 8.5}.");
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

        app.MapGet("/api/alumno", () => Results.Json(new { nombre = "Ana", nota = 8.5 }));

        await app.StartAsync();
        var client = app.GetTestClient();
        var resp = await client.GetAsync("/api/alumno");
        Console.WriteLine(await resp.Content.ReadAsStringAsync());
        Console.WriteLine($"status={(int)resp.StatusCode}");

        await app.StopAsync();
        await app.DisposeAsync();
    }
}
