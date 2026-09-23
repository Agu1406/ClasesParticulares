"""
U03 — Equivalente Python a referencias de metodo (Java ::).

OBJETIVO:
  - Pasar funciones por nombre (len, str.upper, int) donde Java usa ::.
  - Ver operator.itemgetter / attrgetter como atajo opcional.
  - Saber cuando hace falta lambda (logica extra).

En Java: Integer::parseInt, String::length, System.out::println.
En Python: int, len, print — las funciones ya son valores; no hay ::.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from operator import itemgetter

print("\n¡INICIO DEL PROGRAMA!\n")

"""
PRIMERA PARTE — Pasar funciones por nombre (equivalente a ::).
"""
print("¡DEMO 1: FUNCION POR NOMBRE!\n")

numero_texto = "1406"
# Java: Integer::parseInt  |  Python: int
print(f"int('1406') + 1406 -> {int(numero_texto) + 1406}")

convertir = int  # referencia al callable; equivalente a Function = Integer::parseInt
print(f"convertir('2000') -> {convertir('2000')}")

palabra = "stream"
# Java: String::length  |  Python: len (builtin)
longitud_lambda = lambda t: len(t)
longitud_ref = len
print(f"lambda: {longitud_lambda(palabra)} | por nombre: {longitud_ref(palabra)}")

nombres = ["Alice", "Bob", "John"]
print("--- forEach / print ---")
# Java: System.out::println  |  Python: print
for nombre in nombres:
    print(nombre)
# map + print no es idiomatico; list(map(print, ...)) imprime y deja None
print("--- map(str.upper) ---")
print(list(map(str.upper, nombres)))

"""
SEGUNDA PARTE — sorted/key con builtins y operator.itemgetter.
"""
print("\n¡DEMO 2: KEY Y ITEMGETTER!\n")

palabras = ["stream", "java", "lambda", "pf"]
print(f"sorted key=len: {sorted(palabras, key=len)}")

textos = ["  hola ", "  mundo "]
normalizados = list(map(str.strip, textos))
normalizados = list(map(str.upper, normalizados))
print(f"map strip+upper: {normalizados}")

pares = [("Ana", 7), ("Luis", 4), ("Eva", 9)]
# itemgetter(1) = lambda t: t[1]  (opcional, util en tuplas/dicts)
por_nota = sorted(pares, key=itemgetter(1), reverse=True)
print(f"itemgetter(1) desc: {por_nota}")

"""
TERCERA PARTE — Cuando NO basta el nombre: hace falta lambda.
"""
print("\n¡DEMO 3: CUANDO USAR LAMBDA!\n")

for nombre in ["Ana", "Luis", "Eva"]:
    print(f">> {nombre}")  # logica extra: prefijo -> no solo print

criterio = lambda p: len(p) + 1
print(f"orden con logica extra: {sorted(['Ana', 'Luis', 'Eva'], key=criterio)}")

print("\n¡FIN DEL PROGRAMA!")
