# UT8 — ASP.NET Core Minimal APIs

Equivalente a Java `ut8_frameworksspring` / Python `ut8_frameworksweb` / C++ `ut8_frameworks`.

## Equivalencia pedagógica

| Concepto | Flask (Python) | Spring MVC (Java) | Minimal APIs (C#) |
|----------|----------------|-------------------|-------------------|
| App | `Flask(__name__)` | `@SpringBootApplication` | `WebApplication.CreateBuilder()` + `Build()` |
| Ruta GET | `@app.route('/')` | `@GetMapping("/")` | `app.MapGet("/", ...)` |
| Path param | `/hola/<nombre>` | `@PathVariable` | `MapGet("/hola/{nombre}", ...)` |
| Query | `request.args` | `@RequestParam` | `Request.Query` / binding |
| JSON out | `jsonify(...)` | `@ResponseBody` / Jackson | `Results.Json(...)` |
| JSON in | `request.get_json()` | `@RequestBody` | `ReadFromJsonAsync<T>()` |
| Test sin puerto | `test_client()` | `MockMvc` | `UseTestServer()` + `GetTestClient()` |

## Cómo ejecutar (file-based apps .NET)

Cada `.cs` empieza con:

```csharp
#:sdk Microsoft.NET.Sdk.Web
#:package Microsoft.AspNetCore.TestHost@9.0.0
#:property PublishAot=false
#:property JsonSerializerIsReflectionEnabledByDefault=true
```

(`PublishAot=false` + reflexión JSON: las apps file-based en .NET 10 activan AOT por defecto y rompen `Results.Json` / `PostAsJsonAsync` sin estas propiedades.)

```powershell
dotnet run --file .\U01_MinimalApisIntro.cs
```

`dotnet` descarga el SDK/paquete automáticamente. **No hace falta** `app.Run()` para las demos: se usa `StartAsync` + `GetTestClient` (HTTP in-process).

## Mapa de subtemas

| Unidad | Carpeta | Estado |
|--------|---------|--------|
| u01 | `u01minimalapis/` | **Completo** (teoría U01–U03 + E01–E08 pendientes/resueltos) |
| u02 | `u02repaso/` | Esqueleto |

### u01minimalapis — contenido

**Teoría** (demos secuenciales, sin menú)

| Archivo | Tema |
|---------|------|
| `U01_MinimalApisIntro.cs` | `WebApplication`, `MapGet("/")`, `Results.Content` HTML |
| `U02_RutasYParametros.cs` | Path `{nombre}`, query `Request.Query` |
| `U03_JsonYPost.cs` | `Results.Json`, `MapPost` + `ReadFromJsonAsync` |

**Ejercicios E01–E08** (pares `*Pendiente.cs` / `*Resuelto.cs`, menú 1/2/0)

| # | Nombre | Idea |
|---|--------|------|
| E01 | RutaRaizHola | GET `/` → texto |
| E02 | RutaAbout | GET `/about` |
| E03 | RutaSaludoNombre | GET `/saludo/{nombre}` |
| E04 | QueryParamEdad | GET `/info?edad=` |
| E05 | JsonLista | GET `/api/lenguajes` JSON |
| E06 | JsonObjetoAlumno | GET `/api/alumno` JSON |
| E07 | PostEcoJson | POST `/api/eco` eco del cuerpo |
| E08 | MiniApiAlumnos | GET lista + GET por id (404) |

Empieza por `u01minimalapis/teoria/U01_MinimalApisIntro.cs`.
