"""
U01 — Expresiones lambda, map, filter y sorted.

OBJETIVO:
  - Entender lambda como funcion anonima de una expresion.
  - Usar filter y map (o list comprehensions equivalentes).
  - Ordenar con sorted(..., key=...) sin comparadores verbosos.

En Java: (a, b) -> a.length() - b.length(), stream().filter().map().
En Python: lambda x: ..., filter/map, sorted(lista, key=len).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")

"""
PRIMERA PARTE — Contar pares: bucle vs filter + lambda.
Lista: (1, 3, 5, 7, 9, 2, 4, 6, 8) -> pares: 4.
"""
print("¡DEMO 1: CONTAR PARES!\n")
lista_numeros = [1, 3, 5, 7, 9, 2, 4, 6, 8]

total_tradicional = 0
for numero in lista_numeros:
    if numero % 2 == 0:
        total_tradicional += 1
print(f"Tradicional: {total_tradicional} pares")

pares = list(filter(lambda n: n % 2 == 0, lista_numeros))
print(f"filter + lambda: {len(pares)} pares -> {pares}")

# Idiomatico Python: comprehension (suele preferirse a filter)
pares_comp = [n for n in lista_numeros if n % 2 == 0]
print(f"comprehension: {len(pares_comp)} pares\n")

"""
SEGUNDA PARTE — Sumar (pares * 10): bucle vs filter + map.
"""
print("¡DEMO 2: SUMAR PARES * 10!\n")
numeros = [1, 2, 3, 4, 5, 6, 7, 8]

resultado_imperativo = 0
for n in numeros:
    if n % 2 == 0:
        resultado_imperativo += n * 10
print(f"Tradicional: {resultado_imperativo}")

resultado_funcional = sum(map(lambda n: n * 10, filter(lambda n: n % 2 == 0, numeros)))
print(f"filter + map + sum: {resultado_funcional}")

resultado_comp = sum(n * 10 for n in numeros if n % 2 == 0)
print(f"generator expression: {resultado_comp}\n")

"""
TERCERA PARTE — Ordenar por longitud con sorted y key=.
"""
print("¡DEMO 3: ORDENAR POR LONGITUD!\n")
palabras = ["java", "lambda", "stream", "pf"]

# key=len equivale a Comparator.comparing(String::length) en Java
ordenadas = sorted(palabras, key=len)
print(f"sorted(..., key=len): {ordenadas}")

# Misma idea con lambda explicita
ordenadas_lambda = sorted(palabras, key=lambda p: len(p))
print(f"sorted(..., key=lambda): {ordenadas_lambda}")

print("\n¡FIN DEL PROGRAMA!")
