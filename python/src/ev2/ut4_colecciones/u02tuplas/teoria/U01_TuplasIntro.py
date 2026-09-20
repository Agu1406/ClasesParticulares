"""
U01 — Introduccion a tuplas.

OBJETIVO:
  - Crear tuplas con parentesis y acceder por indice.
  - Usar len() e indices negativos.
  - Entender la inmutabilidad frente a las listas.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Crear y acceder.
"""
print("¡DEMO 1: CREAR Y ACCEDER!\n")

coordenadas = (10, 20)
print(f"Coordenadas: {coordenadas}")
print(f"X: {coordenadas[0]}, Y: {coordenadas[1]}")
print(f"Longitud: {len(coordenadas)}")

punto = (3, 4, 5)
print(f"Ultimo (indice -1): {punto[-1]}")

"""
SEGUNDA PARTE — Tupla de un solo elemento: necesita la coma.
"""
print("\n¡DEMO 2: TUPLA DE UN ELEMENTO!\n")

no_es_tupla = (42)
si_es_tupla = (42,)
print(f"(42) es {type(no_es_tupla).__name__}: {no_es_tupla}")
print(f"(42,) es {type(si_es_tupla).__name__}: {si_es_tupla}")

"""
TERCERA PARTE — Inmutable: no se puede cambiar un elemento.
"""
print("\n¡DEMO 3: LISTA VS TUPLA!\n")

lista = [1, 2, 3]
lista[0] = 99
print(f"Lista (mutable): {lista}")

tupla = (1, 2, 3)
# tupla[0] = 99  # TypeError: las tuplas son inmutables
print(f"Tupla (inmutable): {tupla}")
print("Si necesitas cambiar datos, usa lista; si son fijos, tupla.")

print("\n¡FIN DEL PROGRAMA!\n")
