"""
EJERCICIO 7: Bucles For
En este ejercicio aprenderás a repetir código con bucles for.
"""

# 1. Bucle for básico con range()
print("=== BUCLE FOR CON RANGE ===")
for i in range(5):
    print(f"Vuelta número: {i}")

# 2. Bucle for con diferentes rangos
print("\n=== RANGOS PERSONALIZADOS ===")
for numero in range(1, 11):  # Del 1 al 10
    print(f"Número: {numero}")

print("\nDe 2 en 2:")
for numero in range(0, 10, 2):  # Del 0 al 8, saltando de 2 en 2
    print(numero)

# 3. Bucle for con listas
print("\n=== BUCLE CON LISTAS ===")
frutas = ["manzana", "banana", "naranja", "uva"]

print("Mis frutas favoritas:")
for fruta in frutas:
    print(f"- {fruta}")

# 4. Bucle for con enumerate() para obtener índice
print("\n=== CON ÍNDICE ===")
for indice, fruta in enumerate(frutas):
    print(f"{indice + 1}. {fruta}")

# 5. Bucle for con cadenas de texto
print("\n=== BUCLE CON TEXTO ===")
palabra = "Python"
for letra in palabra:
    print(f"Letra: {letra}")

# 6. Bucle for con condiciones
print("\n=== CON CONDICIONES ===")
numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

print("Números pares:")
for numero in numeros:
    if numero % 2 == 0:
        print(numero)

# PRÁCTICA: Crea un programa que sume todos los números del 1 al 100
print("\n=== SUMA DEL 1 AL 100 ===")
# TODO: Escribe tu código aquí


