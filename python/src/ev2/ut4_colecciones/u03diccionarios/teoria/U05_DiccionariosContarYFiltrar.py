"""
U05 — Contar, filtrar y maximo en diccionarios.

OBJETIVO:
  - Patron contar frecuencias con get(clave, 0) + 1.
  - Filtrar pares que cumplan una condicion (bucle, sin obligar comprension).
  - Encontrar la clave con mayor valor (max con key=).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Contar repeticiones.
"""
print("¡DEMO 1: CONTAR!\n")

palabras = ["gato", "perro", "gato", "pajaro", "perro", "gato"]
conteo = {}
for palabra in palabras:
    conteo[palabra] = conteo.get(palabra, 0) + 1
print(f"Conteo: {conteo}")

"""
SEGUNDA PARTE — Filtrar mayores de edad.
"""
print("\n¡DEMO 2: FILTRAR!\n")

edades = {"Ana": 15, "Luis": 18, "Maria": 16, "Pedro": 20}
mayores = {}
for nombre, edad in edades.items():
    if edad >= 18:
        mayores[nombre] = edad
print(f"Mayores de edad: {mayores}")

"""
TERCERA PARTE — Clave con mayor valor.
"""
print("\n¡DEMO 3: MAX POR VALOR!\n")

ventas = {"Lunes": 120, "Martes": 150, "Miercoles": 80, "Jueves": 200}
dia_max = max(ventas, key=ventas.get)
dia_min = min(ventas, key=ventas.get)
print(f"Mejor dia: {dia_max} con {ventas[dia_max]}")
print(f"Peor dia: {dia_min} con {ventas[dia_min]}")

"""
CUARTA PARTE — Agrupar por categoria.
"""
print("\n¡DEMO 4: AGRUPAR!\n")

productos = [
    {"nombre": "manzana", "categoria": "fruta"},
    {"nombre": "zanahoria", "categoria": "verdura"},
    {"nombre": "banana", "categoria": "fruta"},
]
categorias = {}
for producto in productos:
    cat = producto["categoria"]
    if cat not in categorias:
        categorias[cat] = []
    categorias[cat].append(producto["nombre"])
for cat, items in categorias.items():
    print(f"{cat}: {items}")

print("\n¡FIN DEL PROGRAMA!\n")
