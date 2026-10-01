#:sdk Microsoft.NET.Sdk.Web
#:package Microsoft.AspNetCore.TestHost@9.0.0
#:property PublishAot=false
#:property JsonSerializerIsReflectionEnabledByDefault=true

/*
OBJETIVO: GET '/info' lee query ?edad= y responde "Edad: {edad}" (o "Edad: ?" si falta).
  Menu do-while: completar desde un menu interactivo con opcion 0 para salir.

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
        Console.WriteLine("=== E04 QueryParamEdad ===");
        Console.WriteLine("1. Trabajar ejercicio");
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
            // TODO: edad = request.Query["edad"].FirstOrDefault() ?? "?"; return Results.Text($"Edad: {edad}");
            return Results.Empty;
        });

        // TODO: GetAsync("/info?edad=20") y GetAsync("/info")
        await app.DisposeAsync();
    }
}
