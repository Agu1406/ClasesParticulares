"""
EJERCICIO 11: Tuplas
En este ejercicio aprenderás a trabajar con tuplas en Python.
"""

# 1. Crear tuplas
print("=== TUPLAS BÁSICAS ===")
coordenadas = (10, 20)
print(f"Coordenadas: {coordenadas}")
print(f"X: {coordenadas[0]}, Y: {coordenadas[1]}")

# 2. Tupla vs Lista
print("\n=== DIFERENCIAS ===")
lista = [1, 2, 3]  # Mutable
lista[0] = 99  # ✅ Permitido

tupla = (1, 2, 3)  # Inmutable
# tupla[0] = 99  # ❌ Error: las tuplas son inmutables
print(f"Lista (mutable): {lista}")
print(f"Tupla (inmutable): {tupla}")

# 3. Desempaquetado de tuplas
print("\n=== DESEMPAQUETADO ===")
persona = ("Juan", 25, "Ingeniero")
nombre, edad, profesion = persona
print(f"Nombre: {nombre}")
print(f"Edad: {edad}")
print(f"Profesión: {profesion}")

# 4. Múltiples valores de retorno
print("\n=== MÚLTIPLES VALORES ===")
def obtener_estadisticas(numeros):
    promedio = sum(numeros) / len(numeros)
    maximo = max(numeros)
    minimo = min(numeros)
    return promedio, maximo, minimo  # Retorna tupla

datos = [5, 3, 9, 2, 7]
prom, maxi, mini = obtener_estadisticas(datos)
print(f"Datos: {datos}")
print(f"Promedio: {prom}, Máximo: {maxi}, Mínimo: {mini}")

# 5. Diccionarios con tuplas como valores
print("\n=== TUPLAS EN DICCIONARIOS ===")
estudiantes = {
    "Ana": (8.5, 9.0, 8.0),
    "Luis": (7.0, 8.5, 7.5),
    "María": (9.5, 9.0, 9.5)
}

for nombre, notas in estudiantes.items():
    promedio = sum(notas) / len(notas)
    print(f"{nombre}: promedio {promedio:.2f}")

# 6. Tuplas anidadas
print("\n=== TUPLAS ANIDADAS ===")
puntos = ((0, 0), (3, 4), (5, 12))

for i, (x, y) in enumerate(puntos, 1):
    distancia = (x**2 + y**2)**0.5
    print(f"Punto {i}: ({x}, {y}) - Distancia: {distancia:.2f}")

# 7. Conversión lista-tupla
print("\n=== CONVERSIÓN ===")
lista_colores = ["rojo", "verde", "azul"]
tupla_colores = tuple(lista_colores)
print(f"Lista: {lista_colores}")
print(f"Tupla: {tupla_colores}")

nueva_lista = list(tupla_colores)
print(f"De vuelta a lista: {nueva_lista}")

# PRÁCTICA: Crea tuplas para representar coordenadas de ciudades
print("\n=== COORDENADAS DE CIUDADES ===")
# TODO: Escribe tu código aquí


