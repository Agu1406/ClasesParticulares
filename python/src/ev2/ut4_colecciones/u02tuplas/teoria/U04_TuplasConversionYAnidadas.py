"""
U04 — Conversion y tuplas anidadas.

OBJETIVO:
  - Convertir lista <-> tupla con list() y tuple().
  - Recorrer tuplas anidadas (punto (x, y)).
  - Usar tuplas como valores en un diccionario (registro fijo).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Conversion lista <-> tupla.
"""
print("¡DEMO 1: CONVERSION!\n")

lista_colores = ["rojo", "verde", "azul"]
tupla_colores = tuple(lista_colores)
print(f"Lista: {lista_colores}")
print(f"Tupla: {tupla_colores}")

nueva_lista = list(tupla_colores)
nueva_lista.append("amarillo")
print(f"De vuelta a lista (mutable): {nueva_lista}")

"""
SEGUNDA PARTE — Tuplas anidadas.
"""
print("\n¡DEMO 2: ANIDADAS!\n")

puntos = ((0, 0), (3, 4), (5, 12))
for i, (x, y) in enumerate(puntos, 1):
    distancia = (x ** 2 + y ** 2) ** 0.5
    print(f"Punto {i}: ({x}, {y}) - Distancia: {distancia:.2f}")

"""
TERCERA PARTE — Tuplas como valores de un diccionario.
"""
print("\n¡DEMO 3: TUPLAS EN DICCIONARIO!\n")

estudiantes = {
    "Ana": (8.5, 9.0, 8.0),
    "Luis": (7.0, 8.5, 7.5),
}
for nombre, notas in estudiantes.items():
    promedio = sum(notas) / len(notas)
    print(f"{nombre}: promedio {promedio:.2f}")

print("\n¡FIN DEL PROGRAMA!\n")
