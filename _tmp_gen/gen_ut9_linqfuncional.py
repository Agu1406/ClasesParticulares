# -*- coding: utf-8 -*-
"""Genera material didactico C# UT9 u01lambda."""
from pathlib import Path

BASE = Path(r"c:\Users\Agust\Documents\Repositorios\ClasesParticulares\csharp\src\ev3\ut9_linqfuncional")
HEADER = """Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

MENU_EJ = """    static void Main()
    {{
        int opcion;

        do
        {{
            ImprimirMenu();
            Console.Write("Introduce una opcion -> ");
            opcion = int.Parse(Console.ReadLine()!);

            switch (opcion)
            {{
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
            }}

            if (opcion != 0)
            {{
                Console.WriteLine();
                Console.WriteLine("Pulsa ENTER para continuar...");
                Console.ReadLine();
                Console.Clear();
            }}
        }} while (opcion != 0);
    }}

    static void ImprimirMenu()
    {{
        Console.WriteLine("=== {titulo} ===");
        Console.WriteLine("1. {accion}");
        Console.WriteLine("2. Ver objetivo");
        Console.WriteLine("0. Salir");
    }}

    static void MostrarObjetivo()
    {{
        Console.WriteLine(@"{objetivo}");
    }}
"""


def write(path: Path, content: str) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(content.replace("\r\n", "\n"), encoding="utf-8")
    print(path.relative_to(BASE))


def ejercicio_pendiente(nombre, titulo, objetivo, setup, todo) -> str:
    menu = MENU_EJ.format(
        titulo=titulo,
        accion="Trabajar ejercicio",
        objetivo=objetivo,
    )
    return f"""/*
OBJETIVO: {objetivo}
  Menu do-while: completar desde un menu interactivo con opcion 0 para salir.

{HEADER}*/

using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{{
{menu}
    static void EjecutarEjercicio()
    {{
{setup}
        // TODO: {todo}
    }}
}}
"""


def ejercicio_resuelto(nombre, titulo, objetivo, solucion_comment, body) -> str:
    menu = MENU_EJ.format(
        titulo=f"{titulo} (resuelto)",
        accion="Ejecutar solucion",
        objetivo=objetivo,
    )
    return f"""/*
OBJETIVO: {objetivo}
SOLUCION: {solucion_comment}

{HEADER}*/

using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{{
{menu}
    static void EjecutarEjercicio()
    {{
{body}
    }}
}}
"""


# --- README principal ---
write(
    BASE / "README.md",
    """# UT9 — LINQ y programación funcional

Equivalente a Java `ut9_programacionfuncional` / Python `ut9_programacionfuncional` / C++ `ut9_programacionfuncional`.

## Mapa de subtemas

| Unidad | Carpeta | Estado |
|--------|---------|--------|
| u01 | `u01lambda/` | **Completo** (teoría U01–U03 + E01–E12 pendientes/resueltos) |
| u02 | `u02linq/` | Esqueleto |
| u03 | `u03delegates/` | Esqueleto |
| u04 | `u04principios/` | Esqueleto |
| u05 | `u05repaso/` | Esqueleto |

Empieza por `u01lambda/teoria/U01_LambdaIntro.cs`.

### u01lambda — contenido

**Teoría**

| Archivo | Tema |
|---------|------|
| `U01_LambdaIntro.cs` | Expresiones lambda, `Action`, `Func` |
| `U02_LinqWhereSelect.cs` | LINQ `Where`, `Select`, `OrderBy` sobre `List<T>` |
| `U03_DelegatesFuncAction.cs` | Delegates, `Func`, `Action`, `Predicate` |

**Ejercicios E01–E12** (pares `*Pendiente.cs` / `*Resuelto.cs`)

| # | Nombre | Idea |
|---|--------|------|
| E01 | OrdenarPorLongitud | `OrderBy(x => x.Length)` |
| E02 | OrdenAlfabetico | `OrderBy(x => x)` |
| E03 | ActionLambda | `Action` sin parámetros |
| E04 | FiltrarPrefijo | `Where` / `RemoveAll` prefijo x |
| E05 | SelectLongitudes | `Select(x => x.Length)` |
| E06 | ForEachImprimir | `ForEach` / `Action<T>` |
| E07 | FuncMensaje | `Func<string>` (supplier) |
| E08 | CalculadoraMultiplicar | `Func<int,int,int>` |
| E09 | SortDescendente | `OrderByDescending` |
| E10 | SortIgnoreCase | orden ignore case |
| E11 | PredicadoVacia | `Predicate<string>` vacía |
| E12 | PredicadoMayuscula | `Predicate<char>` mayúscula |
""",
)

for stub in ("u02linq", "u03delegates", "u04principios", "u05repaso"):
    write(BASE / stub / "README.md", "Esqueleto\n")

# --- TEORÍA ---
write(
    BASE / "u01lambda" / "teoria" / "U01_LambdaIntro.cs",
    f"""/*
U01 — Expresiones lambda, Action y Func.

OBJETIVO:
  - Entender lambda (x => ...) como funcion anonima.
  - Usar Action (sin retorno) y Func (con retorno).
  - Comparar bucle tradicional vs estilo funcional basico.

En Java: (a, b) -> ..., Predicate / Function / Consumer.
En C#: x => ..., Action / Func / Predicate + LINQ.

{HEADER}*/

using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{{
    static void ImprimirMenu()
    {{
        Console.WriteLine("=== U01 Lambda: Action / Func ===");
        Console.WriteLine("1. Contar pares (bucle vs Where)");
        Console.WriteLine("2. Sumar pares * 10 (Where + Select)");
        Console.WriteLine("3. Action y Func con lambda");
        Console.WriteLine("0. Salir");
    }}

    static void Main()
    {{
        int opcion;
        do
        {{
            ImprimirMenu();
            Console.Write("Introduce una opcion -> ");
            opcion = int.Parse(Console.ReadLine()!);
            Console.WriteLine();

            switch (opcion)
            {{
                case 1:
                    DemoContarPares();
                    break;
                case 2:
                    DemoSumarParesPorDiez();
                    break;
                case 3:
                    DemoActionYFunc();
                    break;
                case 0:
                    Console.WriteLine("Saliendo...");
                    break;
                default:
                    Console.WriteLine("Opcion no valida.");
                    break;
            }}

            Console.WriteLine();
        }} while (opcion != 0);
    }}

    /*
    PRIMERA PARTE — Contar pares: bucle vs Where + lambda.
      Lista: 1,3,5,7,9,2,4,6,8 -> pares: 4.
    */
    static void DemoContarPares()
    {{
        Console.WriteLine("¡DEMO — Contar pares!\\n");
        List<int> listaNumeros = new List<int> {{ 1, 3, 5, 7, 9, 2, 4, 6, 8 }};

        int totalTradicional = 0;
        foreach (int numero in listaNumeros)
        {{
            if (numero % 2 == 0)
            {{
                totalTradicional++;
            }}
        }}
        Console.WriteLine($"Tradicional: {{totalTradicional}} pares");

        List<int> pares = listaNumeros.Where(n => n % 2 == 0).ToList();
        Console.WriteLine($"Where + lambda: {{pares.Count}} pares -> [{{string.Join(", ", pares)}}]");
    }}

    /*
    SEGUNDA PARTE — Sumar (pares * 10): bucle vs Where + Select + Sum.
    */
    static void DemoSumarParesPorDiez()
    {{
        Console.WriteLine("¡DEMO — Sumar pares * 10!\\n");
        List<int> numeros = new List<int> {{ 1, 2, 3, 4, 5, 6, 7, 8 }};

        int resultadoImperativo = 0;
        foreach (int n in numeros)
        {{
            if (n % 2 == 0)
            {{
                resultadoImperativo += n * 10;
            }}
        }}
        Console.WriteLine($"Tradicional: {{resultadoImperativo}}");

        int resultadoFuncional = numeros
            .Where(n => n % 2 == 0)
            .Select(n => n * 10)
            .Sum();
        Console.WriteLine($"Where + Select + Sum: {{resultadoFuncional}}");
    }}

    /*
    TERCERA PARTE — Action (efecto) y Func (valor) con lambda.
    */
    static void DemoActionYFunc()
    {{
        Console.WriteLine("¡DEMO — Action y Func!\\n");

        Action saludo = () => Console.WriteLine("Hola desde Action");
        saludo();

        Action<string> imprimir = texto => Console.WriteLine($">> {{texto}}");
        imprimir("Consumer / Action de ejemplo");

        Func<string> mensaje = () => "Programacion funcional";
        Console.WriteLine($"Func<> supplier: {{mensaje()}}");

        Func<int, int, int> multiplicar = (a, b) => a * b;
        Console.WriteLine($"Func<int,int,int>(6,7) -> {{multiplicar(6, 7)}}");

        List<string> palabras = new List<string> {{ "java", "lambda", "stream", "pf" }};
        List<string> ordenadas = palabras.OrderBy(p => p.Length).ToList();
        Console.WriteLine($"OrderBy longitud: [{{string.Join(", ", ordenadas)}}]");
    }}
}}
""",
)

write(
    BASE / "u01lambda" / "teoria" / "U02_LinqWhereSelect.cs",
    f"""/*
U02 — LINQ Where, Select y OrderBy sobre List.

OBJETIVO:
  - Filtrar con Where (predicados).
  - Transformar con Select (proyecciones).
  - Ordenar con OrderBy / OrderByDescending.
  - Encadenar operaciones y materializar con ToList().

En Java: stream().filter().map().sorted().
En C#: lista.Where(...).Select(...).OrderBy(...).ToList().

{HEADER}*/

using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{{
    static void ImprimirMenu()
    {{
        Console.WriteLine("=== U02 LINQ: Where / Select / OrderBy ===");
        Console.WriteLine("1. Where (filtrar)");
        Console.WriteLine("2. Select (transformar)");
        Console.WriteLine("3. OrderBy y encadenar");
        Console.WriteLine("0. Salir");
    }}

    static void Main()
    {{
        int opcion;
        do
        {{
            ImprimirMenu();
            Console.Write("Introduce una opcion -> ");
            opcion = int.Parse(Console.ReadLine()!);
            Console.WriteLine();

            switch (opcion)
            {{
                case 1:
                    DemoWhere();
                    break;
                case 2:
                    DemoSelect();
                    break;
                case 3:
                    DemoOrderByEncadenar();
                    break;
                case 0:
                    Console.WriteLine("Saliendo...");
                    break;
                default:
                    Console.WriteLine("Opcion no valida.");
                    break;
            }}

            Console.WriteLine();
        }} while (opcion != 0);
    }}

    /*
    PRIMERA PARTE — Where: conservar elementos que cumplen un predicado.
    */
    static void DemoWhere()
    {{
        Console.WriteLine("¡DEMO — Where!\\n");
        List<string> palabras = new List<string> {{ "pf", "java", "lambda", "stream", "xilofono" }};

        List<string> largas = palabras.Where(p => p.Length > 4).ToList();
        Console.WriteLine($"Largas (>4): [{{string.Join(", ", largas)}}]");

        List<string> sinX = palabras.Where(p => !p.StartsWith("x", StringComparison.OrdinalIgnoreCase)).ToList();
        Console.WriteLine($"Sin prefijo x: [{{string.Join(", ", sinX)}}]");
    }}

    /*
    SEGUNDA PARTE — Select: proyectar a otro tipo / forma.
    */
    static void DemoSelect()
    {{
        Console.WriteLine("¡DEMO — Select!\\n");
        List<string> palabras = new List<string> {{ "sol", "programacion", "pf" }};

        List<int> longitudes = palabras.Select(p => p.Length).ToList();
        Console.WriteLine($"Longitudes: [{{string.Join(", ", longitudes)}}]");

        List<string> mayus = palabras.Select(p => p.ToUpper()).ToList();
        Console.WriteLine($"Mayusculas: [{{string.Join(", ", mayus)}}]");
    }}

    /*
    TERCERA PARTE — OrderBy + encadenar Where/Select.
    */
    static void DemoOrderByEncadenar()
    {{
        Console.WriteLine("¡DEMO — OrderBy y encadenar!\\n");
        List<string> palabras = new List<string> {{ "stream", "java", "lambda", "pf" }};

        List<string> porLongitud = palabras.OrderBy(p => p.Length).ToList();
        Console.WriteLine($"OrderBy Length: [{{string.Join(", ", porLongitud)}}]");

        List<int> numeros = new List<int> {{ 3, 10, 1, 8 }};
        List<int> desc = numeros.OrderByDescending(n => n).ToList();
        Console.WriteLine($"OrderByDescending: [{{string.Join(", ", desc)}}]");

        // Encadenar: filtrar pares, multiplicar por 10, ordenar
        List<int> fuente = new List<int> {{ 1, 2, 3, 4, 5, 6, 7, 8 }};
        List<int> cadena = fuente
            .Where(n => n % 2 == 0)
            .Select(n => n * 10)
            .OrderBy(n => n)
            .ToList();
        Console.WriteLine($"Where+Select+OrderBy: [{{string.Join(", ", cadena)}}]");
    }}
}}
""",
)

write(
    BASE / "u01lambda" / "teoria" / "U03_DelegatesFuncAction.cs",
    f"""/*
U03 — Delegates, Func, Action y Predicate.

OBJETIVO:
  - Ver delegates como tipo de "puntero a metodo".
  - Usar Action (void), Func (retorno) y Predicate (bool).
  - Pasar metodos por nombre o lambdas a APIs de colecciones.

En Java: interfaces SAM (Runnable, Supplier, Function, Predicate).
En C#: delegate / Action / Func / Predicate (built-in).

{HEADER}*/

using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{{
    // Delegate clasico (menos habitual hoy; sirve para explicar el concepto).
    delegate int Operacion(int a, int b);

    static void ImprimirMenu()
    {{
        Console.WriteLine("=== U03 Delegates / Func / Action ===");
        Console.WriteLine("1. Delegate y Func que reciben funciones");
        Console.WriteLine("2. Action y Predicate");
        Console.WriteLine("3. Metodo por nombre vs lambda");
        Console.WriteLine("0. Salir");
    }}

    static void Main()
    {{
        int opcion;
        do
        {{
            ImprimirMenu();
            Console.Write("Introduce una opcion -> ");
            opcion = int.Parse(Console.ReadLine()!);
            Console.WriteLine();

            switch (opcion)
            {{
                case 1:
                    DemoRecibirFunciones();
                    break;
                case 2:
                    DemoActionPredicate();
                    break;
                case 3:
                    DemoMetodoVsLambda();
                    break;
                case 0:
                    Console.WriteLine("Saliendo...");
                    break;
                default:
                    Console.WriteLine("Opcion no valida.");
                    break;
            }}

            Console.WriteLine();
        }} while (opcion != 0);
    }}

    static int Aplicar(Operacion op, int a, int b)
    {{
        return op(a, b);
    }}

    static int AplicarFunc(Func<int, int, int> op, int a, int b)
    {{
        return op(a, b);
    }}

    static Func<int, int> FabricarMultiplicador(int factor)
    {{
        return n => n * factor;
    }}

    /*
    PRIMERA PARTE — Funciones que reciben / devuelven funciones.
    */
    static void DemoRecibirFunciones()
    {{
        Console.WriteLine("¡DEMO — Recibir y devolver funciones!\\n");

        Operacion suma = (x, y) => x + y;
        Operacion resta = (x, y) => x - y;
        Console.WriteLine($"Aplicar(suma, 2, 6)  -> {{Aplicar(suma, 2, 6)}}");
        Console.WriteLine($"Aplicar(resta, 10, 5) -> {{Aplicar(resta, 10, 5)}}");
        Console.WriteLine($"AplicarFunc(lambda, 6, 7) -> {{AplicarFunc((x, y) => x * y, 6, 7)}}");

        Func<int, int> porDiez = FabricarMultiplicador(10);
        Func<int, int> porDos = FabricarMultiplicador(2);
        Console.WriteLine($"porDiez(3) -> {{porDiez(3)}}");
        Console.WriteLine($"porDos(8)  -> {{porDos(8)}}");
    }}

    /*
    SEGUNDA PARTE — Action (efecto) y Predicate (condicion).
    */
    static void DemoActionPredicate()
    {{
        Console.WriteLine("¡DEMO — Action y Predicate!\\n");

        Action<string> imprimir = texto => Console.WriteLine($">> {{texto}}");
        imprimir("Action de ejemplo");

        List<int> numeros = new List<int> {{ 3, 1, 4 }};
        numeros.ForEach(n => Console.WriteLine($"N={{n}}"));

        Predicate<string> vacia = t => t.Length == 0;
        Console.WriteLine($"vacia(\\"\\") -> {{vacia(\\"\\")}}");
        Console.WriteLine($"vacia(\\"csharp\\") -> {{vacia(\\"csharp\\")}}");

        Predicate<char> esMayus = c => char.IsUpper(c);
        Console.WriteLine($"esMayus('A') -> {{esMayus('A')}} | esMayus('a') -> {{esMayus('a')}}");
    }}

    static int Longitud(string texto)
    {{
        return texto.Length;
    }}

    /*
    TERCERA PARTE — Metodo por nombre (group method) vs lambda con logica extra.
    */
    static void DemoMetodoVsLambda()
    {{
        Console.WriteLine("¡DEMO — Metodo por nombre vs lambda!\\n");

        Func<string, int> longitudRef = Longitud;
        Func<string, int> longitudLambda = t => t.Length;
        string palabra = "stream";
        Console.WriteLine($"metodo: {{longitudRef(palabra)}} | lambda: {{longitudLambda(palabra)}}");

        List<string> nombres = new List<string> {{ "Alice", "Bob", "John" }};
        Console.WriteLine("--- ForEach Console.WriteLine ---");
        nombres.ForEach(Console.WriteLine);

        Console.WriteLine("--- Select ToUpper ---");
        List<string> mayus = nombres.Select(s => s.ToUpper()).ToList();
        Console.WriteLine($"[{{string.Join(", ", mayus)}}]");

        // Logica extra: hace falta lambda (no basta el nombre solo)
        List<string> conPrefijo = nombres.Select(n => $">> {{n}}").ToList();
        conPrefijo.ForEach(Console.WriteLine);

        List<string> ordenExtra = new List<string> {{ "Ana", "Luis", "Eva" }}
            .OrderBy(p => p.Length + 1)
            .ToList();
        Console.WriteLine($"orden con logica extra: [{{string.Join(", ", ordenExtra)}}]");
    }}
}}
""",
)

# --- EJERCICIOS ---
ejercicios = [
    dict(
        id="E01",
        slug="OrdenarPorLongitud",
        titulo="E01 OrdenarPorLongitud",
        objetivo="Ordena palabras por longitud (ascendente) con OrderBy y lambda (x => x.Length).",
        setup='        List<string> palabras = new List<string> { "programacion", "funcional", "java", "pf" };',
        todo="ordenar por longitud y imprimir (esperado: pf, java, funcional, programacion)",
        solucion="OrderBy(p => p.Length).ToList() e imprimir.",
        body="""        List<string> palabras = new List<string> { "programacion", "funcional", "java", "pf" };
        List<string> ordenadas = palabras.OrderBy(p => p.Length).ToList();
        Console.WriteLine($"[{string.Join(", ", ordenadas)}]");""",
    ),
    dict(
        id="E02",
        slug="OrdenAlfabetico",
        titulo="E02 OrdenAlfabetico",
        objetivo="Ordena nombres alfabeticamente con OrderBy (orden natural de string).",
        setup='        List<string> nombres = new List<string> { "Zoe", "Ana", "Luis", "Marta" };',
        todo="OrderBy(n => n) e imprimir (esperado: Ana, Luis, Marta, Zoe)",
        solucion="OrderBy(n => n).ToList() e imprimir.",
        body="""        List<string> nombres = new List<string> { "Zoe", "Ana", "Luis", "Marta" };
        List<string> ordenados = nombres.OrderBy(n => n).ToList();
        Console.WriteLine($"[{string.Join(", ", ordenados)}]");""",
    ),
    dict(
        id="E03",
        slug="ActionLambda",
        titulo="E03 ActionLambda",
        objetivo="Define un Action sin parametros que imprima un saludo y ejecutalas.",
        setup="",
        todo='Action saludo = () => Console.WriteLine("Hola desde Action"); saludo();',
        solucion="Action saludo = () => Console.WriteLine(...); saludo();",
        body="""        Action saludo = () => Console.WriteLine("Hola desde Action");
        saludo();""",
    ),
    dict(
        id="E04",
        slug="FiltrarPrefijo",
        titulo="E04 FiltrarPrefijo",
        objetivo="Elimina palabras que empiezan por 'x' (ignore case). Equivalente a removeIf / Where.",
        setup='        List<string> palabras = new List<string> { "xilofono", "casa", "Xeno", "sol" };',
        todo="Where o RemoveAll; esperado: casa, sol",
        solucion="Where(p => !p.StartsWith(\"x\", OrdinalIgnoreCase)).ToList().",
        body="""        List<string> palabras = new List<string> { "xilofono", "casa", "Xeno", "sol" };
        List<string> quedan = palabras
            .Where(p => !p.StartsWith("x", StringComparison.OrdinalIgnoreCase))
            .ToList();
        Console.WriteLine($"[{string.Join(", ", quedan)}]");""",
    ),
    dict(
        id="E05",
        slug="SelectLongitudes",
        titulo="E05 SelectLongitudes",
        objetivo="Transforma palabras en sus longitudes con Select (equivalente a map).",
        setup='        List<string> palabras = new List<string> { "sol", "programacion", "pf" };',
        todo="Select(p => p.Length); esperado: 3, 12, 2",
        solucion="Select(p => p.Length).ToList() e imprimir.",
        body="""        List<string> palabras = new List<string> { "sol", "programacion", "pf" };
        List<int> longitudes = palabras.Select(p => p.Length).ToList();
        Console.WriteLine($"[{string.Join(", ", longitudes)}]");""",
    ),
    dict(
        id="E06",
        slug="ForEachImprimir",
        titulo="E06 ForEachImprimir",
        objetivo="Imprime cada numero con prefijo N= (equivalente a forEach / Action).",
        setup="        List<int> numeros = new List<int> { 3, 1, 4 };",
        todo='numeros.ForEach(n => Console.WriteLine($"N={n}"));',
        solucion="ForEach con Action o bucle foreach.",
        body="""        List<int> numeros = new List<int> { 3, 1, 4 };
        numeros.ForEach(n => Console.WriteLine($"N={n}"));""",
    ),
    dict(
        id="E07",
        slug="FuncMensaje",
        titulo="E07 FuncMensaje",
        objetivo='Crea un Func<string> (supplier) que devuelva un mensaje y imprimelo.',
        setup="",
        todo='Func<string> mensaje = () => "Programacion funcional"; Console.WriteLine(mensaje());',
        solucion='Func<string> mensaje = () => "..."; Console.WriteLine(mensaje());',
        body="""        Func<string> mensaje = () => "Programacion funcional";
        Console.WriteLine(mensaje());""",
    ),
    dict(
        id="E08",
        slug="CalculadoraMultiplicar",
        titulo="E08 CalculadoraMultiplicar",
        objetivo="Define un Func<int,int,int> calculadora (a, b) => a * b y calcula 6 * 7.",
        setup="",
        todo="Func<int, int, int> mult = (a, b) => a * b; Console.WriteLine(mult(6, 7)); // 42",
        solucion="Func<int, int, int> mult = (a, b) => a * b; Console.WriteLine(mult(6, 7));",
        body="""        Func<int, int, int> mult = (a, b) => a * b;
        Console.WriteLine(mult(6, 7));""",
    ),
    dict(
        id="E09",
        slug="SortDescendente",
        titulo="E09 SortDescendente",
        objetivo="Ordena numeros de mayor a menor con OrderByDescending.",
        setup="        List<int> numeros = new List<int> { 3, 10, 1, 8 };",
        todo="OrderByDescending; esperado: 10, 8, 3, 1",
        solucion="OrderByDescending(n => n).ToList() e imprimir.",
        body="""        List<int> numeros = new List<int> { 3, 10, 1, 8 };
        List<int> desc = numeros.OrderByDescending(n => n).ToList();
        Console.WriteLine($"[{string.Join(", ", desc)}]");""",
    ),
    dict(
        id="E10",
        slug="SortIgnoreCase",
        titulo="E10 SortIgnoreCase",
        objetivo="Ordena ciudades ignorando mayusculas (OrderBy con ToLowerInvariant o StringComparer).",
        setup='        List<string> ciudades = new List<string> { "barcelona", "Almeria", "cadiz" };',
        todo="OrderBy ignore case; esperado: Almeria, barcelona, cadiz",
        solucion="OrderBy(c => c.ToLowerInvariant()) o StringComparer.OrdinalIgnoreCase.",
        body="""        List<string> ciudades = new List<string> { "barcelona", "Almeria", "cadiz" };
        List<string> ordenadas = ciudades.OrderBy(c => c.ToLowerInvariant()).ToList();
        Console.WriteLine($"[{string.Join(", ", ordenadas)}]");""",
    ),
    dict(
        id="E11",
        slug="PredicadoVacia",
        titulo="E11 PredicadoVacia",
        objetivo='Predicado "esta vacia": prueba "" y "csharp" con Predicate<string>.',
        setup="",
        todo='Predicate<string> vacia = t => t.Length == 0; probar "" y "csharp" (True / False)',
        solucion="Predicate<string> vacia = t => string.IsNullOrEmpty(t) o Length == 0.",
        body="""        Predicate<string> vacia = t => t.Length == 0;
        Console.WriteLine(vacia(""));
        Console.WriteLine(vacia("csharp"));""",
    ),
    dict(
        id="E12",
        slug="PredicadoMayuscula",
        titulo="E12 PredicadoMayuscula",
        objetivo="Predicado mayuscula: prueba 'A' y 'a' con Predicate<char> / char.IsUpper.",
        setup="",
        todo="Predicate<char> esMayus = c => char.IsUpper(c); probar 'A' y 'a' (True / False)",
        solucion="Predicate<char> esMayus = char.IsUpper; o lambda con char.IsUpper.",
        body="""        Predicate<char> esMayus = c => char.IsUpper(c);
        Console.WriteLine(esMayus('A'));
        Console.WriteLine(esMayus('a'));""",
    ),
]

pend = BASE / "u01lambda" / "ejercicios" / "pendientes"
res = BASE / "u01lambda" / "ejercicios" / "resueltos"

for e in ejercicios:
    name_p = f"{e['id']}_{e['slug']}_Pendiente.cs"
    name_r = f"{e['id']}_{e['slug']}_Resuelto.cs"
    write(
        pend / name_p,
        ejercicio_pendiente(e["slug"], e["titulo"], e["objetivo"], e["setup"], e["todo"]),
    )
    write(
        res / name_r,
        ejercicio_resuelto(e["slug"], e["titulo"], e["objetivo"], e["solucion"], e["body"]),
    )

print("DONE")
