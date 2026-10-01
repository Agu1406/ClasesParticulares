#:sdk Microsoft.NET.Sdk.Web
#:package Microsoft.AspNetCore.TestHost@9.0.0
#:property PublishAot=false
#:property JsonSerializerIsReflectionEnabledByDefault=true

/*
U02 — Rutas dinamicas (path) y query string (Request.Query).

OBJETIVO:
  - Definir rutas con parametro de path: /hola/{nombre}.
  - Leer query params con Request.Query o binding.
  - Demostrar sin servidor bloqueante con TestServer.

En Flask: /hola/<nombre> + request.args.
En Spring: @PathVariable / @RequestParam.
En C#: MapGet("/hola/{nombre}", ...) + Request.Query.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

using System;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.TestHost;

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

var builder = WebApplication.CreateBuilder();
builder.WebHost.UseTestServer();
var app = builder.Build();

/*
PRIMERA PARTE — Parametro de path /hola/{nombre}.
Equivalente a @GetMapping("/hola/{nombre}") + @PathVariable.
*/
Console.WriteLine("¡DEMO 1: /hola/{nombre}!\n");

app.MapGet("/hola/{nombre}", (string nombre) =>
    Results.Content($"<p>Hola, {nombre}!</p>", "text/html"));

/*
SEGUNDA PARTE — Query string con Request.Query.
URL ejemplo: /edad?valor=20
En Spring: @RequestParam("valor").
*/
Console.WriteLine("¡DEMO 2: Request.Query!\n");

app.MapGet("/edad", (HttpRequest request) =>
{
    var valor = request.Query["valor"].FirstOrDefault() ?? "?";
    return Results.Content($"<p>Edad recibida: {valor}</p>", "text/html");
});

await app.StartAsync();
var client = app.GetTestClient();

var r1 = await client.GetAsync("/hola/Ana");
Console.WriteLine($"GET /hola/Ana -> {await r1.Content.ReadAsStringAsync()}\n");

var r2 = await client.GetAsync("/edad?valor=20");
Console.WriteLine($"GET /edad?valor=20 -> {await r2.Content.ReadAsStringAsync()}\n");

await app.StopAsync();
await app.DisposeAsync();

Console.WriteLine("¡FIN DEL PROGRAMA!");
