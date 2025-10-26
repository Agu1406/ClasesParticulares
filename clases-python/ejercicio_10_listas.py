"""
EJERCICIO 10: Listas
En este ejercicio aprenderás a trabajar con listas en Python.
"""

# 1. Crear listas y acceder a elementos
print("=== LISTAS BÁSICAS ===")
frutas = ["manzana", "banana", "naranja", "uva", "kiwi"]
print(f"Frutas: {frutas}")

print(f"Primera fruta: {frutas[0]}")
print(f"Última fruta: {frutas[-1]}")
print(f"Primeras tres: {frutas[0:3]}")

# 2. Modificar elementos
print("\n=== MODIFICAR ELEMENTOS ===")
frutas[1] = "fresa"
print(f"Después de cambiar: {frutas}")

# 3. Agregar elementos
print("\n=== AGREGAR ELEMENTOS ===")
frutas.append("mango")  # Agregar al final
print(f"Agregando 'mango': {frutas}")

frutas.insert(2, "pera")  # Insertar en posición
print(f"Insertando 'pera': {frutas}")

# 4. Eliminar elementos
print("\n=== ELIMINAR ELEMENTOS ===")
frutas.remove("uva")  # Eliminar por valor
print(f"Eliminando 'uva': {frutas}")

fruta_eliminada = frutas.pop()  # Elimina el último
print(f"Eliminada con pop(): {fruta_eliminada}")
print(f"Lista actual: {frutas}")

# 5. Operaciones con listas
print("\n=== OPERACIONES ===")
numeros = [3, 1, 4, 1, 5, 9, 2, 6]
print(f"Números: {numeros}")
print(f"Longitud: {len(numeros)}")
print(f"Máximo: {max(numeros)}")
print(f"Mínimo: {min(numeros)}")
print(f"Suma: {sum(numeros)}")

# 6. Ordenar listas
print("\n=== ORDENAR ===")
numeros_copia = numeros.copy()
numeros_copia.sort()
print(f"Ordenada: {numeros_copia}")
print(f"Original: {numeros}")

# 7. Búsqueda en listas
print("\n=== BÚSQUEDA ===")
frutas = ["manzana", "banana", "naranja", "uva"]
buscar = "banana"

if buscar in frutas:
    indice = frutas.index(buscar)
    print(f"'{buscar}' encontrada en índice {indice}")
else:
    print(f"'{buscar}' no encontrada")

# 8. Lista de listas
print("\n=== LISTAS DE LISTAS ===")
calificaciones = [
    ["Ana", 8.5, 9.0, 7.5],
    ["Luis", 7.0, 8.0, 8.5],
    ["María", 9.0, 9.5, 9.0]
]

print("Calificaciones de estudiantes:")
for estudiante in calificaciones:
    nombre = estudiante[0]
    promedio = sum(estudiante[1:]) / len(estudiante[1:])
    print(f"{nombre}: {promedio:.2f}")

# PRÁCTICA: Crea una lista de compras
print("\n=== LISTA DE COMPRAS ===")
# TODO: Escribe tu código aquí


