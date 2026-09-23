"""
U01 — Comprehensions (list, dict, set) y generator expressions.

OBJETIVO:
  - Construir listas/dicts/sets de forma declarativa (sin bucles verbosos).
  - Filtrar y transformar en una sola expresion.
  - Distinguir list comprehension [...] de generator expression (...).

En Java: stream().filter().map().collect(...).
En Python: [x for x in xs if ...], {k: v for ...}, (x for x in xs).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")

"""
PRIMERA PARTE — List comprehension: pares y transformacion.
"""
print("¡DEMO 1: LIST COMPREHENSION!\n")
numeros = [1, 2, 3, 4, 5, 6, 7, 8]

pares_tradicional = []
for n in numeros:
    if n % 2 == 0:
        pares_tradicional.append(n)
print(f"Tradicional: {pares_tradicional}")

pares = [n for n in numeros if n % 2 == 0]
print(f"list comp:   {pares}")

dobles = [n * 2 for n in numeros]
print(f"dobles:      {dobles}\n")

"""
SEGUNDA PARTE — Dict y set comprehension.
"""
print("¡DEMO 2: DICT Y SET COMP!\n")
palabras = ["sol", "luna", "estrella", "pf"]

longitudes = {p: len(p) for p in palabras}
print(f"dict comp: {longitudes}")

iniciales = {p[0] for p in palabras}
print(f"set comp:  {iniciales}\n")

"""
TERCERA PARTE — Generator expression (perezosa) vs list comp (ansiosa).
"""
print("¡DEMO 3: GENERATOR EXPRESSION!\n")
# [...] materializa ya; (...) no calcula hasta iterar / sum / list
gen = (n * 10 for n in numeros if n % 2 == 0)
print(f"tipo gen: {type(gen)}")
print(f"sum(gen): {sum(gen)}")
# El generador se agoto; sum de nuevo da 0
print(f"sum otra vez: {sum(gen)}")

print("\n¡FIN DEL PROGRAMA!")
