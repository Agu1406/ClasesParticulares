"""
U01 — Introduccion a listas.

OBJETIVO:
  - Crear listas vacias y con valores iniciales.
  - Acceder y modificar elementos por indice (positivo y negativo).
  - Usar len() y rebanadas (slicing) basicas.
  - Entender que la lista es dinamica: crece y se reduce en ejecucion.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Crear lista vacia y con valores iniciales.
  Lista vacia: []
  Con valores: ["Ana", "Luis"]
"""
print("¡DEMO 1: CREAR LISTAS!\n")

numeros = []
print(f"Lista vacia: {numeros}")
print(f"Longitud: {len(numeros)}")

nombres = ["Ana", "Luis", "Marta"]
print(f"Lista con valores: {nombres}")
print(f"Longitud: {len(nombres)}")

"""
SEGUNDA PARTE — Acceso por indice.
  Indices empiezan en 0. El ultimo se puede leer con -1.
"""
print("\n¡DEMO 2: ACCESO POR INDICE!\n")

frutas = ["manzana", "banana", "naranja", "uva", "kiwi"]
print(f"Frutas: {frutas}")
print(f"Primera (indice 0): {frutas[0]}")
print(f"Segunda (indice 1): {frutas[1]}")
print(f"Ultima (indice -1): {frutas[-1]}")
print(f"Penultima (indice -2): {frutas[-2]}")

"""
TERCERA PARTE — Modificar por indice.
  lista[indice] = nuevo_valor reemplaza lo que habia.
"""
print("\n¡DEMO 3: MODIFICAR POR INDICE!\n")

frutas[1] = "fresa"
print(f"Tras frutas[1] = 'fresa': {frutas}")

"""
CUARTA PARTE — Rebanadas (slicing).
  lista[inicio:fin] -> desde inicio hasta fin (sin incluir fin).
"""
print("\n¡DEMO 4: REBANADAS!\n")

print(f"Primeras tres frutas[0:3]: {frutas[0:3]}")
print(f"Desde el indice 2: {frutas[2:]}")
print(f"Hasta el indice 2 (sin incluirlo): {frutas[:2]}")

print("\n¡FIN DEL PROGRAMA!\n")
