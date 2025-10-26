"""
EJERCICIO 12: Diccionarios Básicos
En este ejercicio aprenderás a trabajar con diccionarios en Python.
"""

# 1. Crear diccionarios
print("=== DICCIONARIOS BÁSICOS ===")
estudiante = {
    "nombre": "Ana",
    "edad": 20,
    "carrera": "Informática",
    "promedio": 8.5
}

print(f"Estudiante: {estudiante}")
print(f"Nombre: {estudiante['nombre']}")
print(f"Edad: {estudiante.get('edad', 'No disponible')}")

# 2. Agregar y modificar elementos
print("\n=== AGREGAR Y MODIFICAR ===")
estudiante["semestre"] = 4  # Agregar nueva clave
estudiante["promedio"] = 9.0  # Modificar valor
print(f"Actualizado: {estudiante}")

# 3. Eliminar elementos
print("\n=== ELIMINAR ELEMENTOS ===")
print(f"Antes: {estudiante}")
edad_eliminada = estudiante.pop("edad")
print(f"Edad eliminada: {edad_eliminada}")
print(f"Después: {estudiante}")

# 4. Obtener todas las claves y valores
print("\n=== CLAVES Y VALORES ===")
print(f"Claves: {estudiante.keys()}")
print(f"Valores: {estudiante.values()}")
print(f"Items: {estudiante.items()}")

# 5. Iterar sobre diccionarios
print("\n=== ITERAR SOBRE DICCIONARIOS ===")
for clave, valor in estudiante.items():
    print(f"{clave}: {valor}")

# 6. Diccionarios anidados
print("\n=== DICCIONARIOS ANIDADOS ===")
libros = {
    "1984": {
        "autor": "George Orwell",
        "año": 1949,
        "páginas": 328
    },
    "El Quijote": {
        "autor": "Miguel de Cervantes",
        "año": 1605,
        "páginas": 863
    }
}

for titulo, info in libros.items():
    print(f"\n{titulo}:")
    print(f"  Autor: {info['autor']}")
    print(f"  Año: {info['año']}")
    print(f"  Páginas: {info['páginas']}")

# 7. Verificar si una clave existe
print("\n=== VERIFICAR CLAVES ===")
clave = "nombre"
if clave in estudiante:
    print(f"'{clave}' existe con valor: {estudiante[clave]}")

clave2 = "direccion"
valor = estudiante.get(clave2, "No disponible")
print(f"'{clave2}': {valor}")

# 8. Contar elementos
print("\n=== CONTAR ===")
texto = "programar en Python es genial"
conteo_letras = {}

for letra in texto.replace(" ", ""):  # Ignorar espacios
    conteo_letras[letra] = conteo_letras.get(letra, 0) + 1

print(f"Conteo de letras en '{texto}':")
for letra, cantidad in sorted(conteo_letras.items()):
    print(f"  {letra}: {cantidad}")

# PRÁCTICA: Crea un diccionario de contactos telefónicos
print("\n=== AGENDA TELEFÓNICA ===")
# TODO: Escribe tu código aquí


