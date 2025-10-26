"""
EJERCICIO 3: Entrada de Datos con input()
En este ejercicio aprenderás a recibir datos del usuario.
"""

# 1. Pedir datos simples al usuario
print("=== FORMULARIO SIMPLE ===")
nombre = input("¿Cuál es tu nombre? ")
edad = input("¿Cuántos años tienes? ")

print(f"\nHola {nombre}, tienes {edad} años.")

# 2. Convertir tipos de datos
print("\n=== CONVERSIÓN DE TIPOS ===")
edad_numero = int(input("¿Cuántos años tienes? "))
peso = float(input("¿Cuánto pesas? "))
altura = float(input("¿Cuánto mides (en metros)? "))

# Calcular el IMC
imc = peso / (altura ** 2)
print(f"\nTu IMC es: {imc:.2f}")

# 3. Realizar cálculos
print("\n=== CALCULADORA SIMPLE ===")
num1 = int(input("Introduce el primer número: "))
num2 = int(input("Introduce el segundo número: "))

print(f"\nSuma: {num1} + {num2} = {num1 + num2}")
print(f"Resta: {num1} - {num2} = {num1 - num2}")
print(f"Multiplicación: {num1} * {num2} = {num1 * num2}")
if num2 != 0:
    print(f"División: {num1} / {num2} = {num1 / num2}")
else:
    print("No se puede dividir entre 0")

# PRÁCTICA: Crea un programa que calcule el costo total de una compra
# Pide: número de productos, precio por producto
# Calcula: subtotal, IVA (21%), total
print("\n=== CALCULADORA DE COMPRA ===")
# TODO: Escribe tu código aquí


