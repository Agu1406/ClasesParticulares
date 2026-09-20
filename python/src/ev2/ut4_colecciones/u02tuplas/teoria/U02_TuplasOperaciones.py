"""
U02 — Operaciones con tuplas.

OBJETIVO:
  - Consultar con in, index y count.
  - Concatenar (+) y repetir (*).
  - Usar rebanadas (slicing) como en listas.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — in, index y count.
"""
print("¡DEMO 1: BUSCAR!\n")

colores = ("rojo", "verde", "azul", "verde")
print(f"Tupla: {colores}")
print(f"'verde' in colores -> {'verde' in colores}")
print(f"index('azul') -> {colores.index('azul')}")
print(f"count('verde') -> {colores.count('verde')}")

"""
SEGUNDA PARTE — Concatenar y repetir (crean tuplas NUEVAS).
"""
print("\n¡DEMO 2: + Y *!\n")

a = (1, 2)
b = (3, 4)
print(f"a + b = {a + b}")
print(f"a * 3 = {a * 3}")

"""
TERCERA PARTE — Slicing.
"""
print("\n¡DEMO 3: REBANADAS!\n")

nums = (10, 20, 30, 40, 50)
print(f"nums[1:4] = {nums[1:4]}")
print(f"nums[:2] = {nums[:2]}")
print(f"nums[2:] = {nums[2:]}")

print("\n¡FIN DEL PROGRAMA!\n")
