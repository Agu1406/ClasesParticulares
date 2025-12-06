"""
EJERCICIO 13: Diccionarios Avanzados
En este ejercicio practicarás operaciones avanzadas con diccionarios.
"""

# 1. Agregar elementos de forma segura
print("=== AGREGAR DE FORMA SEGURA ===")
inventario = {
    "manzanas": 50,
    "bananas": 30,
    "naranjas": 40
}

def agregar_producto(inventario, producto, cantidad):
    """Agrega producto al inventario de forma segura"""
    inventario[producto] = inventario.get(producto, 0) + cantidad

agregar_producto(inventario, "manzanas", 20)
agregar_producto(inventario, "peras", 10)
print(f"Inventario: {inventario}")

# 2. Encontrar valores máximo y mínimo
print("\n=== ENCONTRAR MÁXIMO Y MÍNIMO ===")
ventas = {
    "Lunes": 120,
    "Martes": 150,
    "Miércoles": 80,
    "Jueves": 200,
    "Viernes": 180
}

dia_max = max(ventas, key=ventas.get)
dia_min = min(ventas, key=ventas.get)
print(f"Mejor día: {dia_max} con {ventas[dia_max]} ventas")
print(f"Peor día: {dia_min} con {ventas[dia_min]} ventas")

# 3. Fusionar diccionarios
print("\n=== FUSIONAR DICCIONARIOS ===")
dic1 = {"a": 1, "b": 2}
dic2 = {"b": 3, "c": 4}

# Método 1: update()
dic1.update(dic2)
print(f"Fusionado: {dic1}")

# 4. Filtrar diccionario
print("\n=== FILTRAR DICCIONARIO ===")
edades = {
    "Ana": 15,
    "Luis": 18,
    "María": 16,
    "Pedro": 20,
    "Sara": 17
}

# Encontrar mayores de edad
mayores_de_edad = {nombre: edad for nombre, edad in edades.items() if edad >= 18}
print(f"Mayores de edad: {mayores_de_edad}")

# 5. Convertir diccionario en dos listas
print("\n=== CONVERTIR A LISTAS ===")
dias_semana = {
    "Lunes": "Monday",
    "Martes": "Tuesday",
    "Miércoles": "Wednesday"
}

claves = list(dias_semana.keys())
valores = list(dias_semana.values())
print(f"Claves: {claves}")
print(f"Valores: {valores}")

# 6. Crear diccionario inverso
print("\n=== DICCIONARIO INVERSO ===")
codigo_colores = {
    "negro": "black",
    "blanco": "white",
    "rojo": "red"
}

# Invertir: clave -> valor, valor -> clave
colores_inverso = {valor: clave for clave, valor in codigo_colores.items()}
print(f"Inverso: {colores_inverso}")

# 7. Contar repeticiones con diccionario
print("\n=== CONTAR REPETICIONES ===")
palabras = ["gato", "perro", "gato", "pájaro", "perro", "gato"]
conteo = {}

for palabra in palabras:
    conteo[palabra] = conteo.get(palabra, 0) + 1

print(f"Conteo: {conteo}")

# 8. Agrupar por categoría
print("\n=== AGRUPAR POR CATEGORÍA ===")
productos = [
    {"nombre": "manzana", "categoria": "fruta"},
    {"nombre": "zanahoria", "categoria": "verdura"},
    {"nombre": "banana", "categoria": "fruta"},
    {"nombre": "lechuga", "categoria": "verdura"},
    {"nombre": "naranja", "categoria": "fruta"}
]

# Agrupar productos por categoría
categorias = {}
for producto in productos:
    categoria = producto["categoria"]
    nombre = producto["nombre"]
    
    if categoria not in categorias:
        categorias[categoria] = []
    categorias[categoria].append(nombre)

for cat, items in categorias.items():
    print(f"{cat}: {items}")

# 9. Diccionario de estudiantes con notas
print("\n=== CALIFICACIONES DE ESTUDIANTES ===")
estudiantes = {
    "Ana": [8, 7, 9, 8.5],
    "Luis": [6, 7.5, 8, 7],
    "María": [9.5, 9, 10, 9.5]
}

# Calcular promedio de cada estudiante
for nombre, notas in estudiantes.items():
    promedio = sum(notas) / len(notas)
    print(f"{nombre}: {promedio = promedio:.2f}")

# PRÁCTICA: Crea un sistema de votación
print("\n=== SISTEMA DE VOTACIÓN ===")
# TODO: Escribe tu código aquí


