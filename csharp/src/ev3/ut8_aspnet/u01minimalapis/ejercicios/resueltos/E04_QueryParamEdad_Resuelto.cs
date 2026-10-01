#:sdk Microsoft.NET.Sdk.Web
#:package Microsoft.AspNetCore.TestHost@9.0.0
#:property PublishAot=false
#:property JsonSerializerIsReflectionEnabledByDefault=true

/*
OBJETIVO: GET '/info' lee query ?edad= y responde "Edad: {edad}" (o "Edad: ?" si falta).
SOLUCION: Request.Query + GetTestClient.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

using System;
using System.Linq;
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
        Console.WriteLine("=== E04 QueryParamEdad (resuelto) ===");
        Console.WriteLine("1. Ejecutar solucion");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
    }

    static void MostrarObjetivo()
    {
        Console.WriteLine(@"GET '/info' lee query ?edad= y responde ""Edad: {edad}"" (o ""Edad: ?"" si falta).");
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

        app.MapGet("/info", (HttpRequest request) =>
        {
            var edad = request.Query["edad"].FirstOrDefault() ?? "?";
            return Results.Text($"Edad: {edad}");
        });

        await app.StartAsync();
        var client = app.GetTestClient();
        var resp = await client.GetAsync("/info?edad=20");
        Console.WriteLine(await resp.Content.ReadAsStringAsync());
        Console.WriteLine($"status={(int)resp.StatusCode}");
        var resp2 = await client.GetAsync("/info");
        Console.WriteLine(await resp2.Content.ReadAsStringAsync());

        await app.StopAsync();
        await app.DisposeAsync();
    }
}
