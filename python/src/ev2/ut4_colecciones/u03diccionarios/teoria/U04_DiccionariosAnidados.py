"""
U04 — Diccionarios anidados.

OBJETIVO:
  - Guardar un diccionario dentro de otro.
  - Acceder con dos claves: externo[interno].
  - Recorrer estructuras anidadas (libros, fichas).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Acceso anidado.
"""
print("¡DEMO 1: ACCESO ANIDADO!\n")

libros = {
    "1984": {"autor": "George Orwell", "anio": 1949, "paginas": 328},
    "El Quijote": {"autor": "Miguel de Cervantes", "anio": 1605, "paginas": 863},
}

print(f"Autor de 1984: {libros['1984']['autor']}")
print(f"Anio El Quijote: {libros['El Quijote']['anio']}")

"""
SEGUNDA PARTE — Recorrido anidado.
"""
print("\n¡DEMO 2: RECORRIDO!\n")

for titulo, info in libros.items():
    print(f"{titulo}:")
    print(f"  Autor: {info['autor']}")
    print(f"  Anio: {info['anio']}")
    print(f"  Paginas: {info['paginas']}")

"""
TERCERA PARTE — Modificar un campo interno.
"""
print("\n¡DEMO 3: MODIFICAR!\n")

libros["1984"]["paginas"] = 330
print(f"1984 actualizado: {libros['1984']}")

print("\n¡FIN DEL PROGRAMA!\n")
