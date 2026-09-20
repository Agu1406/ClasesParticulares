"""
U01 — Introduccion a diccionarios.

OBJETIVO:
  - Crear pares clave -> valor (como HashMap / Dictionary).
  - Leer con dict[clave] y con get (seguro).
  - Comprobar claves con in y consultar len().

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Crear y leer.
"""
print("¡DEMO 1: CREAR Y LEER!\n")

edades = {}
edades["Ana"] = 20
edades["Luis"] = 22
edades["Marta"] = 19
print(f"Diccionario: {edades}")
print(f"Edad de Luis: {edades['Luis']}")
print(f"Numero de personas: {len(edades)}")

"""
SEGUNDA PARTE — get y clave inexistente.
"""
print("\n¡DEMO 2: get()!\n")

print(f"get('Ana'): {edades.get('Ana')}")
print(f"get('Pedro', 'No disponible'): {edades.get('Pedro', 'No disponible')}")
# edades['Pedro']  # KeyError si la clave no existe

"""
TERCERA PARTE — in (equivale a containsKey).
"""
print("\n¡DEMO 3: CLAVE IN DICT!\n")

print(f"'Luis' in edades -> {'Luis' in edades}")
print(f"'Pedro' in edades -> {'Pedro' in edades}")

print("\n¡FIN DEL PROGRAMA!\n")
