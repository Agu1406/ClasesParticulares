"""
U03 — itertools basico (islice, chain, count).

OBJETIVO:
  - islice: ventana / limit+skip al estilo Stream.limit / skip.
  - chain: concatenar varios iterables en uno.
  - count: contador infinito (usar siempre con islice u otra cota).

Nivel junior: tres herramientas frecuentes, sin profundizar en el resto.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from itertools import chain, count, islice

print("\n¡INICIO DEL PROGRAMA!\n")

"""
PRIMERA PARTE — islice: primeros N / saltar y tomar.
"""
print("¡DEMO 1: ISLICE!\n")
numeros = [10, 20, 30, 40, 50, 60]

primeros_tres = list(islice(numeros, 3))
print(f"islice(xs, 3)      -> {primeros_tres}")

# Equivale a skip(2).limit(3) en Java Streams
ventana = list(islice(numeros, 2, 5))
print(f"islice(xs, 2, 5)   -> {ventana}\n")

"""
SEGUNDA PARTE — chain: unir listas / iterables.
"""
print("¡DEMO 2: CHAIN!\n")
a = [1, 2]
b = [3, 4]
c = [5]
unidos = list(chain(a, b, c))
print(f"chain(a, b, c) -> {unidos}")
print(f"chain.from_iterable([[1,2],[3]]) -> {list(chain.from_iterable([[1, 2], [3]]))}\n")

"""
TERCERA PARTE — count: secuencia infinita (siempre acotar).
"""
print("¡DEMO 3: COUNT!\n")
# count(10) -> 10, 11, 12, ... sin fin; islice lo corta
desde_diez = list(islice(count(10), 5))
print(f"islice(count(10), 5) -> {desde_diez}")

pares = list(islice((n for n in count(0) if n % 2 == 0), 6))
print(f"6 primeros pares con count: {pares}")

print("\n¡FIN DEL PROGRAMA!")
