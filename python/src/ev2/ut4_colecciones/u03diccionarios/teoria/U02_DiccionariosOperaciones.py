"""
U02 — Operaciones con diccionarios.

OBJETIVO:
  - Agregar y actualizar con dict[clave] = valor (como put).
  - Eliminar con pop / del / clear.
  - Actualizar varias claves con update.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Agregar y actualizar.
"""
print("¡DEMO 1: AGREGAR / ACTUALIZAR!\n")

notas = {"Ana": 7.5, "Luis": 4.0, "Marta": 8.5}
print(f"Inicial: {notas}")

notas["Luis"] = 6.0
print(f"Tras actualizar Luis: {notas}")

notas["Eva"] = 9.0
print(f"Tras agregar Eva: {notas}")

"""
SEGUNDA PARTE — pop, del y clear.
"""
print("\n¡DEMO 2: ELIMINAR!\n")

sacado = notas.pop("Luis")
print(f"pop('Luis') devolvio: {sacado}")
print(f"Tras pop: {notas}")

del notas["Eva"]
print(f"Tras del Eva: {notas}")

copia = notas.copy()
copia.clear()
print(f"Tras clear en copia: {copia}")
print(f"Original intacto: {notas}")

"""
TERCERA PARTE — update.
"""
print("\n¡DEMO 3: update()!\n")

extra = {"Pedro": 5.5, "Ana": 8.0}
notas.update(extra)
print(f"Tras update: {notas}")

print("\n¡FIN DEL PROGRAMA!\n")
