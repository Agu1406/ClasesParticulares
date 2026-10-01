#:sdk Microsoft.NET.Sdk.Web
#:package Microsoft.AspNetCore.TestHost@9.0.0
#:property PublishAot=false
#:property JsonSerializerIsReflectionEnabledByDefault=true

/*
U03 — JSON con Results.Json y cuerpo POST (ReadFromJsonAsync).

OBJETIVO:
  - Devolver JSON con Results.Json (lista u objeto).
  - Leer JSON del cuerpo con ReadFromJsonAsync.
  - Mencionar formularios (Request.Form) frente a JSON.
  - Simular GET/POST con GetTestClient (sin app.Run).

En Flask: jsonify + request.get_json().
En Spring: @ResponseBody / @RequestBody + Jackson.
En C#: Results.Json + ReadFromJsonAsync.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Net.Http.Json;
using System.Text;
using System.Text.Json;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.TestHost;

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

var builder = WebApplication.CreateBuilder();
builder.WebHost.UseTestServer();
var app = builder.Build();

/*
PRIMERA PARTE — Results.Json: respuesta JSON tipica de API.
Content-Type application/json automatico.
*/
Console.WriteLine("¡DEMO 1: Results.Json!\n");

app.MapGet("/api/frutas", () => Results.Json(new[] { "manzana", "pera", "uva" }));

/*
SEGUNDA PARTE — POST + ReadFromJsonAsync.
Equivalente a request.get_json() en Flask.
*/
Console.WriteLine("¡DEMO 2: MapPost + ReadFromJsonAsync!\n");

app.MapPost("/api/eco", async (HttpRequest request) =>
{
    var datos = await request.ReadFromJsonAsync<Dictionary<string, JsonElement>>()
                ?? new Dictionary<string, JsonElement>();
    return Results.Json(new { recibido = datos });
});

/*
TERCERA PARTE — Request.Form (formulario HTML clasico).
Equivalente pedagogico a request.form / parametros de formulario, no JSON.
*/
Console.WriteLine("¡DEMO 3: Request.Form (conceptual)!\n");

app.MapPost("/form/saludo", async (HttpRequest request) =>
{
    var form = await request.ReadFormAsync();
    var nombre = form["nombre"].FirstOrDefault() ?? "anonimo";
    return Results.Content($"<p>Hola desde form: {nombre}</p>", "text/html");
});

await app.StartAsync();
var client = app.GetTestClient();

var rFrutas = await client.GetAsync("/api/frutas");
Console.WriteLine($"Status: {(int)rFrutas.StatusCode}");
Console.WriteLine($"JSON: {await rFrutas.Content.ReadAsStringAsync()}\n");

var rEco = await client.PostAsJsonAsync("/api/eco", new { nombre = "Ana", nota = 8.5 });
Console.WriteLine($"Eco JSON: {await rEco.Content.ReadAsStringAsync()}\n");

using var formContent = new FormUrlEncodedContent(new Dictionary<string, string>
{
    ["nombre"] = "Luis"
});
var rForm = await client.PostAsync("/form/saludo", formContent);
Console.WriteLine($"saludo form -> {await rForm.Content.ReadAsStringAsync()}\n");

await app.StopAsync();
await app.DisposeAsync();

Console.WriteLine("¡FIN DEL PROGRAMA!");
