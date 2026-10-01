#:sdk Microsoft.NET.Sdk.Web
#:package Microsoft.AspNetCore.TestHost@9.0.0
#:property PublishAot=false
#:property JsonSerializerIsReflectionEnabledByDefault=true

/*
U01 — Introduccion a Minimal APIs: WebApplication, ruta raiz y HTML.

OBJETIVO:
  - Crear WebApplication con CreateBuilder + Build.
  - Registrar MapGet("/") y devolver HTML con Results.Content.
  - Relacionar con Flask @app.route y Spring @GetMapping.
  - Probar SIN bloquear con app.Run: UseTestServer + GetTestClient.

En Flask: Flask(__name__) + @app.route('/') + return "<h1>...</h1>".
En Spring: @GetMapping("/") + ResponseEntity / vista.
En C#: WebApplication + MapGet + Results.Content.

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

/*
PRIMERA PARTE — Crear la aplicacion web.
Equivalente pedagogico a Flask(__name__) / contexto Spring Boot.
*/
Console.WriteLine("¡DEMO 1: WebApplication.CreateBuilder + Build!\n");

var builder = WebApplication.CreateBuilder();
builder.WebHost.UseTestServer();
var app = builder.Build();
Console.WriteLine($"Tipo de app: {app.GetType().Name}\n");

/*
SEGUNDA PARTE — Ruta raiz MapGet("/").
En Flask: @app.route('/'). En Spring: @GetMapping("/").
*/
Console.WriteLine("¡DEMO 2: MapGet('/') + Results.Content!\n");

app.MapGet("/", () => Results.Content(
    "<h1>Hola ASP.NET</h1><p>UT8 — Minimal APIs</p>",
    "text/html"));

Console.WriteLine("Handler registrado en '/'.\n");

/*
TERCERA PARTE — Invocar la ruta sin abrir puerto (TestServer).
No uses app.Run() en demos de clase: bloquea la consola.
*/
Console.WriteLine("¡DEMO 3: StartAsync + GetTestClient (sin app.Run)!\n");

await app.StartAsync();
var client = app.GetTestClient();
var resp = await client.GetAsync("/");
Console.WriteLine($"Status: {(int)resp.StatusCode}");
Console.WriteLine($"Respuesta: {await resp.Content.ReadAsStringAsync()}\n");

await app.StopAsync();
await app.DisposeAsync();

Console.WriteLine("# Opcional — para servir en un puerto real usa app.Run() (bloquea).");
Console.WriteLine("\n¡FIN DEL PROGRAMA!");
