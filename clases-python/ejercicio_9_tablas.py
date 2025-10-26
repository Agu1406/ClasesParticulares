"""
EJERCICIO 9: Tablas y Patrones
En este ejercicio practicarás bucles creando tablas y patrones.
"""

# 1. Tabla de multiplicar del 1 al 10
print("=== TABLA DE MULTIPLICAR ===")
numero = int(input("¿De qué número quieres la tabla? "))

print(f"\nTabla del {numero}:")
for i in range(1, 11):
    resultado = numero * i
    print(f"{numero} x {i} = {resultado}")

# 2. Tablas de multiplicar completas
print("\n=== TODAS LAS TABLAS ===")
for tabla in range(1, 6):  # Del 1 al 5
    print(f"\n--- Tabla del {tabla} ---")
    for multiplicador in range(1, 11):
        print(f"{tabla} x {multiplicador} = {tabla * multiplicador}")

# 3. Patrón con asteriscos
print("\n=== PATRÓN DE ASTERISCOS ===")
alto = int(input("Introduce la altura del triángulo: "))

for i in range(1, alto + 1):
    asteriscos = "*" * i
    print(asteriscos)

# 4. Contador con números cuadrados
print("\n=== CUADRADOS DE NÚMEROS ===")
for i in range(1, 11):
    cuadrado = i ** 2
    print(f"{i}^2 = {cuadrado}")

# 5. Factorial de un número
print("\n=== CALCULADORA DE FACTORIAL ===")
numero = int(input("Introduce un número para calcular su factorial: "))
factorial = 1

for i in range(1, numero + 1):
    factorial *= i
    print(f"Paso {i}: factorial = {factorial}")

print(f"\nEl factorial de {numero} es: {factorial}")

# 6. Suma de números pares e impares
print("\n=== SUMADOR DE PARES E IMPARES ===")
suma_pares = 0
suma_impares = 0

for i in range(1, 21):  # Del 1 al 20
    if i % 2 == 0:
        suma_pares += i
    else:
        suma_impares += i

print(f"Suma de números pares: {suma_pares}")
print(f"Suma de números impares: {suma_impares}")

# PRÁCTICA: Crea una pirámide invertida de asteriscos
print("\n=== PIRÁMIDE INVERTIDA ===")
# TODO: Escribe tu código aquí


