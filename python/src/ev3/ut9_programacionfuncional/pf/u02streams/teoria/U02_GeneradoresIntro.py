"""
U02 — Generadores con yield (lazy / pereza).

OBJETIVO:
  - Entender yield: produce valores bajo demanda (como stream perezoso).
  - Comparar lista completa vs generador (memoria / cuando se ejecuta).
  - Encadenar filtros y transformaciones sin materializar intermedios.

En Java: Stream es lazy hasta una operacion terminal.
En Python: def + yield, o generator expression (...).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


def cuadrados(hasta):
    """Genera n*n para n en 1..hasta (sin guardar la lista)."""
    for n in range(1, hasta + 1):
        yield n * n


def filtrar_pares(iterable):
    """Filtra pares de forma perezosa."""
    for x in iterable:
        if x % 2 == 0:
            yield x


print("\n¡INICIO DEL PROGRAMA!\n")

"""
PRIMERA PARTE — yield basico.
"""
print("¡DEMO 1: YIELD BASICO!\n")
gen = cuadrados(5)
print(f"tipo: {type(gen)}")
print(f"list(cuadrados(5)): {list(cuadrados(5))}")
# Consumo paso a paso
g = cuadrados(3)
print(f"next: {next(g)}, {next(g)}, {next(g)}\n")

"""
SEGUNDA PARTE — Pereza: el cuerpo no corre hasta pedir valores.
"""
print("¡DEMO 2: PEREZA!\n")


def con_efecto(xs):
    for x in xs:
        print(f"  produciendo {x}")
        yield x * 2


pipeline = con_efecto([1, 2, 3])
print("Pipeline creado (aun sin prints de produccion)")
print(f"list(pipeline): {list(pipeline)}\n")

"""
TERCERA PARTE — Encadenar generadores (pipeline estilo stream).
"""
print("¡DEMO 3: PIPELINE!\n")
fuente = range(1, 11)
resultado = list(filtrar_pares(cuadrados(10)))
print(f"cuadrados pares de 1..10: {resultado}")
# Equivalente con generator expression
alt = list(x for x in (n * n for n in fuente) if x % 2 == 0)
print(f"misma idea con gen expr: {alt}")

print("\n¡FIN DEL PROGRAMA!")
