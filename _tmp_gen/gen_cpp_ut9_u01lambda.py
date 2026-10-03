#!/usr/bin/env python3
"""Generate C++17 UT9 u01lambda didactic material."""
from __future__ import annotations

from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
BASE = ROOT / "cpp" / "src" / "ev3" / "ut9_programacionfuncional"
U01 = BASE / "u01lambda"

HEADER_AUTHOR = """Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

INCLUDES = """#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <functional>
#include <numeric>
using namespace std;
"""

INCLUDES_CCTYPE = """#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <functional>
#include <numeric>
#include <cctype>
using namespace std;
"""


def write(path: Path, text: str) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(text.replace("\r\n", "\n"), encoding="utf-8")
    print(f"wrote {path.relative_to(ROOT)}")


def menu_main(imprimir_body: str, cases: str) -> str:
    return f"""void ImprimirMenu()
{{
{imprimir_body}
}}

int main()
{{
    int opcion;
    do
    {{
        ImprimirMenu();
        cout << "Introduce una opcion -> ";
        cin >> opcion;
        cout << endl;

        switch (opcion)
        {{
{cases}
            case 0:
                cout << "Saliendo..." << endl;
                break;
            default:
                cout << "Opcion no valida." << endl;
                break;
        }}

        cout << endl;
    }} while (opcion != 0);

    return 0;
}}
"""


def ejercicio_pendiente(
    title: str,
    objetivo: str,
    mostrar: str,
    setup: str,
    todo: str,
    extra_includes: str = INCLUDES,
) -> str:
    return f"""/*
OBJETIVO: {objetivo}
  Menu do-while: completar desde un menu interactivo con opcion 0 para salir.

{HEADER_AUTHOR}*/

{extra_includes}
void ImprimirMenu()
{{
    cout << "=== {title} ===" << endl;
    cout << "1. Trabajar ejercicio" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}}

void MostrarObjetivo()
{{
{mostrar}
}}

void EjecutarEjercicio()
{{
{setup}
{todo}
}}

int main()
{{
    int opcion;
    do
    {{
        ImprimirMenu();
        cout << "Introduce una opcion -> ";
        cin >> opcion;
        cout << endl;

        switch (opcion)
        {{
            case 1:
                EjecutarEjercicio();
                break;
            case 2:
                MostrarObjetivo();
                break;
            case 0:
                cout << "Saliendo..." << endl;
                break;
            default:
                cout << "Opcion no valida. Intenta de nuevo." << endl;
                break;
        }}

        cout << endl;
    }} while (opcion != 0);

    return 0;
}}
"""


def ejercicio_resuelto(
    title: str,
    objetivo: str,
    solucion_line: str,
    mostrar: str,
    body: str,
    extra_includes: str = INCLUDES,
) -> str:
    return f"""/*
OBJETIVO: {objetivo}
SOLUCION: {solucion_line}

{HEADER_AUTHOR}*/

{extra_includes}
void ImprimirMenu()
{{
    cout << "=== {title} (resuelto) ===" << endl;
    cout << "1. Ejecutar solucion" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}}

void MostrarObjetivo()
{{
{mostrar}
}}

void EjecutarEjercicio()
{{
{body}
}}

int main()
{{
    int opcion;
    do
    {{
        ImprimirMenu();
        cout << "Introduce una opcion -> ";
        cin >> opcion;
        cout << endl;

        switch (opcion)
        {{
            case 1:
                EjecutarEjercicio();
                break;
            case 2:
                MostrarObjetivo();
                break;
            case 0:
                cout << "Saliendo..." << endl;
                break;
            default:
                cout << "Opcion no valida. Intenta de nuevo." << endl;
                break;
        }}

        cout << endl;
    }} while (opcion != 0);

    return 0;
}}
"""


# ---------------------------------------------------------------------------
# Teoria
# ---------------------------------------------------------------------------

U01_LAMBDA = f"""/*
U01 — Introduccion a lambdas en C++17.

Una lambda es una funcion anonima: [captura](parametros) {{ cuerpo }}.
Se pasa a algoritmos STL (sort, count_if, transform, accumulate) como predicado
o transformacion, sin escribir funtores con operator() a mano.

OBJETIVO:
  - Escribir lambdas []( ){{ }} y guardarlas en auto / std::function.
  - Contar con count_if y ordenar con sort + lambda.
  - Comparar bucle tradicional vs estilo funcional con <algorithm>.

En Java: (a, b) -> ..., Predicate / Function.
En C#: x => ..., Action / Func + LINQ.
En C++: []( ){{ }}, std::function, algoritmos STL.

{HEADER_AUTHOR}*/

{INCLUDES}
void ImprimirMenu()
{{
    cout << "=== U01 Lambda: intro + count_if / sort ===" << endl;
    cout << "1. Contar pares (bucle vs count_if)" << endl;
    cout << "2. Sumar pares * 10 (bucle vs accumulate)" << endl;
    cout << "3. Lambda en auto / function y sort" << endl;
    cout << "0. Salir" << endl;
}}

/*
PRIMERA PARTE — Contar pares: bucle vs count_if + lambda.
  Lista: 1,3,5,7,9,2,4,6,8 -> pares: 4.
*/
void DemoContarPares()
{{
    cout << "¡DEMO — Contar pares!\\n" << endl;
    vector<int> listaNumeros = {{1, 3, 5, 7, 9, 2, 4, 6, 8}};

    int totalTradicional = 0;
    for (int numero : listaNumeros)
    {{
        if (numero % 2 == 0)
        {{
            totalTradicional++;
        }}
    }}
    cout << "Tradicional: " << totalTradicional << " pares" << endl;

    int pares = count_if(listaNumeros.begin(), listaNumeros.end(),
                         [](int n) {{ return n % 2 == 0; }});
    cout << "count_if + lambda: " << pares << " pares" << endl;
}}

/*
SEGUNDA PARTE — Sumar (pares * 10): bucle vs accumulate con lambda.
*/
void DemoSumarParesPorDiez()
{{
    cout << "¡DEMO — Sumar pares * 10!\\n" << endl;
    vector<int> numeros = {{1, 2, 3, 4, 5, 6, 7, 8}};

    int resultadoImperativo = 0;
    for (int n : numeros)
    {{
        if (n % 2 == 0)
        {{
            resultadoImperativo += n * 10;
        }}
    }}
    cout << "Tradicional: " << resultadoImperativo << endl;

    int resultadoFuncional = accumulate(
        numeros.begin(), numeros.end(), 0,
        [](int acc, int n) {{ return (n % 2 == 0) ? acc + n * 10 : acc; }});
    cout << "accumulate + lambda: " << resultadoFuncional << endl;
}}

/*
TERCERA PARTE — auto / std::function y sort por longitud.
*/
void DemoLambdaYSort()
{{
    cout << "¡DEMO — Lambda y sort!\\n" << endl;

    auto saludo = []() {{ cout << "Hola desde lambda" << endl; }};
    saludo();

    function<void(const string&)> imprimir = [](const string& texto) {{
        cout << ">> " << texto << endl;
    }};
    imprimir("Consumer / function de ejemplo");

    function<int(int, int)> multiplicar = [](int a, int b) {{ return a * b; }};
    cout << "function(6,7) -> " << multiplicar(6, 7) << endl;

    vector<string> palabras = {{"java", "lambda", "stream", "pf"}};
    sort(palabras.begin(), palabras.end(),
         [](const string& a, const string& b) {{ return a.size() < b.size(); }});
    cout << "sort por longitud: ";
    for (size_t i = 0; i < palabras.size(); i++)
    {{
        if (i > 0)
        {{
            cout << ", ";
        }}
        cout << palabras[i];
    }}
    cout << endl;
}}

int main()
{{
    int opcion;
    do
    {{
        ImprimirMenu();
        cout << "Introduce una opcion -> ";
        cin >> opcion;
        cout << endl;

        switch (opcion)
        {{
            case 1:
                DemoContarPares();
                break;
            case 2:
                DemoSumarParesPorDiez();
                break;
            case 3:
                DemoLambdaYSort();
                break;
            case 0:
                cout << "Saliendo..." << endl;
                break;
            default:
                cout << "Opcion no valida." << endl;
                break;
        }}

        cout << endl;
    }} while (opcion != 0);

    return 0;
}}
"""

U02_ALGO = f"""/*
U02 — Algoritmos STL: sort, count_if y find_if.

Los algoritmos de <algorithm> reciben iteradores y predicados (a menudo lambdas).
sort reordena; count_if cuenta; find_if busca el primer elemento que cumple.

OBJETIVO:
  - Ordenar con sort y un comparador lambda.
  - Contar con count_if.
  - Buscar con find_if y comprobar el iterador contra end().

En Java: stream().sorted().filter().findFirst().
En C#: OrderBy / Count / FirstOrDefault.
En C++: sort / count_if / find_if.

{HEADER_AUTHOR}*/

{INCLUDES}
void ImprimirMenu()
{{
    cout << "=== U02 Algorithm: sort / count_if / find_if ===" << endl;
    cout << "1. sort con lambda" << endl;
    cout << "2. count_if (pares y largas)" << endl;
    cout << "3. find_if (primer elemento)" << endl;
    cout << "0. Salir" << endl;
}}

/*
PRIMERA PARTE — sort: ordenar por longitud y por valor descendente.
*/
void DemoSort()
{{
    cout << "¡DEMO — sort!\\n" << endl;
    vector<string> palabras = {{"stream", "java", "lambda", "pf"}};

    sort(palabras.begin(), palabras.end(),
         [](const string& a, const string& b) {{ return a.size() < b.size(); }});
    cout << "sort por longitud: ";
    for (size_t i = 0; i < palabras.size(); i++)
    {{
        if (i > 0)
        {{
            cout << ", ";
        }}
        cout << palabras[i];
    }}
    cout << endl;

    vector<int> numeros = {{3, 10, 1, 8}};
    sort(numeros.begin(), numeros.end(), [](int a, int b) {{ return a > b; }});
    cout << "sort descendente: ";
    for (size_t i = 0; i < numeros.size(); i++)
    {{
        if (i > 0)
        {{
            cout << ", ";
        }}
        cout << numeros[i];
    }}
    cout << endl;
}}

/*
SEGUNDA PARTE — count_if: cuantos cumplen el predicado.
*/
void DemoCountIf()
{{
    cout << "¡DEMO — count_if!\\n" << endl;
    vector<int> numeros = {{1, 2, 3, 4, 5, 6, 7, 8}};
    int pares = count_if(numeros.begin(), numeros.end(),
                         [](int n) {{ return n % 2 == 0; }});
    cout << "Pares: " << pares << endl;

    vector<string> palabras = {{"pf", "java", "lambda", "stream", "xilofono"}};
    int largas = count_if(palabras.begin(), palabras.end(),
                          [](const string& p) {{ return p.size() > 4; }});
    cout << "Palabras largas (>4): " << largas << endl;
}}

/*
TERCERA PARTE — find_if: primer elemento que cumple (o end() si no hay).
*/
void DemoFindIf()
{{
    cout << "¡DEMO — find_if!\\n" << endl;
    vector<string> palabras = {{"pf", "java", "lambda", "stream"}};

    auto it = find_if(palabras.begin(), palabras.end(),
                      [](const string& p) {{ return p.size() > 4; }});
    if (it != palabras.end())
    {{
        cout << "Primera larga (>4): " << *it << endl;
    }}
    else
    {{
        cout << "No hay palabra larga." << endl;
    }}

    auto itX = find_if(palabras.begin(), palabras.end(),
                       [](const string& p) {{ return !p.empty() && (p[0] == 'x' || p[0] == 'X'); }});
    if (itX == palabras.end())
    {{
        cout << "Ninguna empieza por x." << endl;
    }}
}}

int main()
{{
    int opcion;
    do
    {{
        ImprimirMenu();
        cout << "Introduce una opcion -> ";
        cin >> opcion;
        cout << endl;

        switch (opcion)
        {{
            case 1:
                DemoSort();
                break;
            case 2:
                DemoCountIf();
                break;
            case 3:
                DemoFindIf();
                break;
            case 0:
                cout << "Saliendo..." << endl;
                break;
            default:
                cout << "Opcion no valida." << endl;
                break;
        }}

        cout << endl;
    }} while (opcion != 0);

    return 0;
}}
"""

U03_TRANSFORM = f"""/*
U03 — transform y accumulate.

transform proyecta cada elemento (map); accumulate reduce una secuencia a un valor
(suma, producto, concatenacion...). Ambos aceptan lambdas como operacion.

OBJETIVO:
  - Usar transform para longitudes / mayusculas.
  - Usar accumulate para sumar y reducir.
  - Encadenar ideas: filtrar (copy_if) + transformar + acumular.

En Java: map / reduce.
En C#: Select / Aggregate / Sum.
En C++: transform / accumulate (+ copy_if).

{HEADER_AUTHOR}*/

{INCLUDES}
#include <cctype>

void ImprimirMenu()
{{
    cout << "=== U03 Transform / Accumulate ===" << endl;
    cout << "1. transform (map)" << endl;
    cout << "2. accumulate (reduce)" << endl;
    cout << "3. copy_if + transform + accumulate" << endl;
    cout << "0. Salir" << endl;
}}

/*
PRIMERA PARTE — transform: proyectar a otro tipo / forma.
*/
void DemoTransform()
{{
    cout << "¡DEMO — transform!\\n" << endl;
    vector<string> palabras = {{"sol", "programacion", "pf"}};

    vector<int> longitudes(palabras.size());
    transform(palabras.begin(), palabras.end(), longitudes.begin(),
              [](const string& p) {{ return static_cast<int>(p.size()); }});
    cout << "Longitudes: ";
    for (size_t i = 0; i < longitudes.size(); i++)
    {{
        if (i > 0)
        {{
            cout << ", ";
        }}
        cout << longitudes[i];
    }}
    cout << endl;

    vector<string> mayus = palabras;
    transform(mayus.begin(), mayus.end(), mayus.begin(), [](string p) {{
        transform(p.begin(), p.end(), p.begin(),
                  [](unsigned char c) {{ return static_cast<char>(toupper(c)); }});
        return p;
    }});
    cout << "Mayusculas: ";
    for (size_t i = 0; i < mayus.size(); i++)
    {{
        if (i > 0)
        {{
            cout << ", ";
        }}
        cout << mayus[i];
    }}
    cout << endl;
}}

/*
SEGUNDA PARTE — accumulate: reducir a un valor.
*/
void DemoAccumulate()
{{
    cout << "¡DEMO — accumulate!\\n" << endl;
    vector<int> numeros = {{1, 2, 3, 4, 5}};

    int suma = accumulate(numeros.begin(), numeros.end(), 0);
    cout << "Suma: " << suma << endl;

    int producto = accumulate(numeros.begin(), numeros.end(), 1,
                              [](int acc, int n) {{ return acc * n; }});
    cout << "Producto: " << producto << endl;

    vector<string> partes = {{"pro", "gra", "ma"}};
    string juntar = accumulate(partes.begin(), partes.end(), string(""),
                               [](const string& acc, const string& p) {{ return acc + p; }});
    cout << "Concat: " << juntar << endl;
}}

/*
TERCERA PARTE — copy_if (filtrar) + transform + accumulate.
*/
void DemoEncadenar()
{{
    cout << "¡DEMO — copy_if + transform + accumulate!\\n" << endl;
    vector<int> fuente = {{1, 2, 3, 4, 5, 6, 7, 8}};

    vector<int> pares;
    copy_if(fuente.begin(), fuente.end(), back_inserter(pares),
            [](int n) {{ return n % 2 == 0; }});

    vector<int> porDiez(pares.size());
    transform(pares.begin(), pares.end(), porDiez.begin(),
              [](int n) {{ return n * 10; }});

    sort(porDiez.begin(), porDiez.end());
    int total = accumulate(porDiez.begin(), porDiez.end(), 0);

    cout << "Pares*10 ordenados: ";
    for (size_t i = 0; i < porDiez.size(); i++)
    {{
        if (i > 0)
        {{
            cout << ", ";
        }}
        cout << porDiez[i];
    }}
    cout << endl;
    cout << "Suma: " << total << endl;
}}

int main()
{{
    int opcion;
    do
    {{
        ImprimirMenu();
        cout << "Introduce una opcion -> ";
        cin >> opcion;
        cout << endl;

        switch (opcion)
        {{
            case 1:
                DemoTransform();
                break;
            case 2:
                DemoAccumulate();
                break;
            case 3:
                DemoEncadenar();
                break;
            case 0:
                cout << "Saliendo..." << endl;
                break;
            default:
                cout << "Opcion no valida." << endl;
                break;
        }}

        cout << endl;
    }} while (opcion != 0);

    return 0;
}}
"""


def print_vec_loop(var: str, elem_expr: str | None = None) -> str:
    e = elem_expr or "x"
    return f"""    for (size_t i = 0; i < {var}.size(); i++)
    {{
        if (i > 0)
        {{
            cout << ", ";
        }}
        cout << {var}[i];
    }}
    cout << endl;"""


# ---------------------------------------------------------------------------
# Ejercicios
# ---------------------------------------------------------------------------

EJERCICIOS = [
    {
        "code": "E01_OrdenarPorLongitud",
        "title": "E01 OrdenarPorLongitud",
        "objetivo": "Ordena palabras por longitud (ascendente) con sort y lambda.",
        "solucion": "sort(..., [](a,b){ return a.size() < b.size(); }) e imprimir.",
        "mostrar": '    cout << "Ordena palabras por longitud (ascendente) con sort y lambda." << endl;',
        "setup": '    vector<string> palabras = {"programacion", "funcional", "java", "pf"};',
        "todo": "    // TODO: sort por longitud e imprimir (esperado: pf, java, funcional, programacion)",
        "body": """    vector<string> palabras = {"programacion", "funcional", "java", "pf"};
    sort(palabras.begin(), palabras.end(),
         [](const string& a, const string& b) { return a.size() < b.size(); });
    for (size_t i = 0; i < palabras.size(); i++)
    {
        if (i > 0)
        {
            cout << ", ";
        }
        cout << palabras[i];
    }
    cout << endl;""",
    },
    {
        "code": "E02_OrdenAlfabetico",
        "title": "E02 OrdenAlfabetico",
        "objetivo": "Ordena nombres alfabeticamente con sort (orden natural de string).",
        "solucion": "sort(nombres.begin(), nombres.end()) e imprimir.",
        "mostrar": '    cout << "Ordena nombres alfabeticamente con sort (orden natural de string)." << endl;',
        "setup": '    vector<string> nombres = {"Zoe", "Ana", "Luis", "Marta"};',
        "todo": "    // TODO: sort alfabetico e imprimir (esperado: Ana, Luis, Marta, Zoe)",
        "body": """    vector<string> nombres = {"Zoe", "Ana", "Luis", "Marta"};
    sort(nombres.begin(), nombres.end());
    for (size_t i = 0; i < nombres.size(); i++)
    {
        if (i > 0)
        {
            cout << ", ";
        }
        cout << nombres[i];
    }
    cout << endl;""",
    },
    {
        "code": "E03_CountIfPares",
        "title": "E03 CountIfPares",
        "objetivo": "Cuenta cuantos numeros pares hay con count_if y lambda.",
        "solucion": "count_if(..., [](int n){ return n % 2 == 0; }).",
        "mostrar": '    cout << "Cuenta cuantos numeros pares hay con count_if y lambda." << endl;',
        "setup": "    vector<int> numeros = {1, 3, 5, 7, 9, 2, 4, 6, 8};",
        "todo": "    // TODO: count_if pares e imprimir (esperado: 4)",
        "body": """    vector<int> numeros = {1, 3, 5, 7, 9, 2, 4, 6, 8};
    int pares = count_if(numeros.begin(), numeros.end(),
                         [](int n) { return n % 2 == 0; });
    cout << pares << endl;""",
    },
    {
        "code": "E04_FiltrarPrefijo",
        "title": "E04 FiltrarPrefijo",
        "objetivo": "Copia a otro vector las palabras que NO empiezan por 'x' (ignore case).",
        "solucion": "copy_if a otro vector excluyendo prefijo x/X.",
        "mostrar": """    cout << "Copia a otro vector las palabras que NO empiezan por 'x' (ignore case)." << endl;
    cout << "Usa copy_if + lambda (equivalente a filter / Where)." << endl;""",
        "setup": '    vector<string> palabras = {"xilofono", "casa", "Xeno", "sol"};',
        "todo": """    // TODO: copy_if a otro vector; esperado: casa, sol
    // vector<string> filtradas;
    // copy_if(...);""",
        "body": """    vector<string> palabras = {"xilofono", "casa", "Xeno", "sol"};
    vector<string> filtradas;
    copy_if(palabras.begin(), palabras.end(), back_inserter(filtradas),
            [](const string& p) {
                if (p.empty())
                {
                    return true;
                }
                char c = static_cast<char>(tolower(static_cast<unsigned char>(p[0])));
                return c != 'x';
            });
    for (size_t i = 0; i < filtradas.size(); i++)
    {
        if (i > 0)
        {
            cout << ", ";
        }
        cout << filtradas[i];
    }
    cout << endl;""",
        "includes": INCLUDES_CCTYPE,
    },
    {
        "code": "E05_TransformLongitudes",
        "title": "E05 TransformLongitudes",
        "objetivo": "Transforma palabras en sus longitudes con transform (equivalente a map).",
        "solucion": "transform a vector<int> con [](p){ return p.size(); }.",
        "mostrar": '    cout << "Transforma palabras en sus longitudes con transform (equivalente a map)." << endl;',
        "setup": '    vector<string> palabras = {"sol", "programacion", "pf"};',
        "todo": "    // TODO: transform a longitudes e imprimir (esperado: 3, 12, 2)",
        "body": """    vector<string> palabras = {"sol", "programacion", "pf"};
    vector<int> longitudes(palabras.size());
    transform(palabras.begin(), palabras.end(), longitudes.begin(),
              [](const string& p) { return static_cast<int>(p.size()); });
    for (size_t i = 0; i < longitudes.size(); i++)
    {
        if (i > 0)
        {
            cout << ", ";
        }
        cout << longitudes[i];
    }
    cout << endl;""",
    },
    {
        "code": "E06_ForEachImprimir",
        "title": "E06 ForEachImprimir",
        "objetivo": "Imprime cada numero con prefijo N= usando for_each y lambda.",
        "solucion": 'for_each(..., [](int n){ cout << "N=" << n << endl; }).',
        "mostrar": '    cout << "Imprime cada numero con prefijo N= usando for_each y lambda." << endl;',
        "setup": "    vector<int> numeros = {3, 1, 4};",
        "todo": '    // TODO: for_each imprimiendo N=n (esperado: N=3 / N=1 / N=4)',
        "body": """    vector<int> numeros = {3, 1, 4};
    for_each(numeros.begin(), numeros.end(), [](int n) {
        cout << "N=" << n << endl;
    });""",
    },
    {
        "code": "E07_SortDescendente",
        "title": "E07 SortDescendente",
        "objetivo": "Ordena numeros de mayor a menor con sort y lambda.",
        "solucion": "sort(..., [](a,b){ return a > b; }).",
        "mostrar": '    cout << "Ordena numeros de mayor a menor con sort y lambda." << endl;',
        "setup": "    vector<int> numeros = {3, 10, 1, 8};",
        "todo": "    // TODO: sort descendente e imprimir (esperado: 10, 8, 3, 1)",
        "body": """    vector<int> numeros = {3, 10, 1, 8};
    sort(numeros.begin(), numeros.end(), [](int a, int b) { return a > b; });
    for (size_t i = 0; i < numeros.size(); i++)
    {
        if (i > 0)
        {
            cout << ", ";
        }
        cout << numeros[i];
    }
    cout << endl;""",
    },
    {
        "code": "E08_SortIgnoreCase",
        "title": "E08 SortIgnoreCase",
        "objetivo": "Ordena ciudades ignorando mayusculas con sort + lambda (tolower).",
        "solucion": "sort con comparador que convierte a minusculas.",
        "mostrar": '    cout << "Ordena ciudades ignorando mayusculas con sort + lambda (tolower)." << endl;',
        "setup": '    vector<string> ciudades = {"barcelona", "Almeria", "cadiz"};',
        "todo": "    // TODO: sort ignore case e imprimir (esperado: Almeria, barcelona, cadiz)",
        "body": """    vector<string> ciudades = {"barcelona", "Almeria", "cadiz"};
    auto aMinusculas = [](string s) {
        transform(s.begin(), s.end(), s.begin(),
                  [](unsigned char c) { return static_cast<char>(tolower(c)); });
        return s;
    };
    sort(ciudades.begin(), ciudades.end(),
         [&](const string& a, const string& b) {
             return aMinusculas(a) < aMinusculas(b);
         });
    for (size_t i = 0; i < ciudades.size(); i++)
    {
        if (i > 0)
        {
            cout << ", ";
        }
        cout << ciudades[i];
    }
    cout << endl;""",
        "includes": INCLUDES_CCTYPE,
    },
    {
        "code": "E09_AnyAllEquivalente",
        "title": "E09 AnyAllEquivalente",
        "objetivo": "Usa any_of y all_of con lambdas (equivalente a Any / All de LINQ).",
        "solucion": "any_of (hay par) y all_of (todos positivos).",
        "mostrar": """    cout << "Usa any_of y all_of con lambdas." << endl;
    cout << "any_of: ¿hay algun par?  all_of: ¿todos positivos?" << endl;""",
        "setup": "    vector<int> numeros = {1, 3, 5, 8};",
        "todo": """    // TODO: any_of (hay par?) y all_of (todos > 0?); imprimir true/false
    // esperado: any_of pares -> true; all_of positivos -> true""",
        "body": """    vector<int> numeros = {1, 3, 5, 8};
    bool hayPar = any_of(numeros.begin(), numeros.end(),
                         [](int n) { return n % 2 == 0; });
    bool todosPositivos = all_of(numeros.begin(), numeros.end(),
                                 [](int n) { return n > 0; });
    cout << boolalpha;
    cout << "any_of pares: " << hayPar << endl;
    cout << "all_of positivos: " << todosPositivos << endl;""",
    },
    {
        "code": "E10_AccumulateSuma",
        "title": "E10 AccumulateSuma",
        "objetivo": "Suma todos los enteros de un vector con accumulate.",
        "solucion": "accumulate(begin, end, 0).",
        "mostrar": '    cout << "Suma todos los enteros de un vector con accumulate." << endl;',
        "setup": "    vector<int> numeros = {1, 2, 3, 4, 5};",
        "todo": "    // TODO: accumulate e imprimir suma (esperado: 15)",
        "body": """    vector<int> numeros = {1, 2, 3, 4, 5};
    int suma = accumulate(numeros.begin(), numeros.end(), 0);
    cout << suma << endl;""",
    },
]


def main() -> None:
    write(U01 / "teoria" / "U01_LambdaIntro.cpp", U01_LAMBDA)
    write(U01 / "teoria" / "U02_AlgorithmSortCount.cpp", U02_ALGO)
    write(U01 / "teoria" / "U03_TransformAccumulate.cpp", U03_TRANSFORM)

    for ej in EJERCICIOS:
        inc = ej.get("includes", INCLUDES)
        write(
            U01 / "ejercicios" / "pendientes" / f"{ej['code']}_Pendiente.cpp",
            ejercicio_pendiente(
                ej["title"],
                ej["objetivo"],
                ej["mostrar"],
                ej["setup"],
                ej["todo"],
                inc,
            ),
        )
        write(
            U01 / "ejercicios" / "resueltos" / f"{ej['code']}_Resuelto.cpp",
            ejercicio_resuelto(
                ej["title"],
                ej["objetivo"],
                ej["solucion"],
                ej["mostrar"],
                ej["body"],
                inc,
            ),
        )

    write(
        BASE / "u02algorithms" / "README.md",
        "# u02 — Algorithms STL\n",
    )
    write(
        BASE / "u03functional" / "README.md",
        "# u03 — Functional / std::function\n",
    )
    write(
        BASE / "u04principios" / "README.md",
        "# u04 — Principios de programación funcional\n",
    )
    write(
        BASE / "u05repaso" / "README.md",
        "# u05 — Repaso\n",
    )

    readme = """# UT9 — Programación funcional (C++)

Equivalente a Java `ut9_programacionfuncional` / C# `ut9_linqfuncional` / Python `ut9_programacionfuncional`.

## Mapa de subtemas

| Unidad | Carpeta | Estado |
|--------|---------|--------|
| u01 | `u01lambda/` | **Completo** (teoría U01–U03 + E01–E10 pendientes/resueltos) |
| u02 | `u02algorithms/` | Esqueleto |
| u03 | `u03functional/` | Esqueleto |
| u04 | `u04principios/` | Esqueleto |
| u05 | `u05repaso/` | Esqueleto |

Empieza por `u01lambda/teoria/U01_LambdaIntro.cpp`.

Estándar: **C++17**. Compilar, por ejemplo:

```bash
g++ -std=c++17 -o demo U01_LambdaIntro.cpp
```

### u01lambda — contenido

**Teoría**

| Archivo | Tema |
|---------|------|
| `U01_LambdaIntro.cpp` | Lambdas `[]( ){ }`, `auto` / `std::function`, `count_if`, `sort` |
| `U02_AlgorithmSortCount.cpp` | `sort`, `count_if`, `find_if` |
| `U03_TransformAccumulate.cpp` | `transform`, `accumulate`, `copy_if` |

**Ejercicios E01–E10** (pares `*_Pendiente.cpp` / `*_Resuelto.cpp`)

| # | Nombre | Idea |
|---|--------|------|
| E01 | OrdenarPorLongitud | `sort` por `size()` |
| E02 | OrdenAlfabetico | `sort` natural |
| E03 | CountIfPares | `count_if` pares |
| E04 | FiltrarPrefijo | `copy_if` a otro vector (sin prefijo x) |
| E05 | TransformLongitudes | `transform` → longitudes |
| E06 | ForEachImprimir | `for_each` con `N=` |
| E07 | SortDescendente | `sort` mayor→menor |
| E08 | SortIgnoreCase | `sort` + `tolower` |
| E09 | AnyAllEquivalente | `any_of` / `all_of` |
| E10 | AccumulateSuma | `accumulate` suma |
"""
    write(BASE / "README.md", readme)


if __name__ == "__main__":
    main()
