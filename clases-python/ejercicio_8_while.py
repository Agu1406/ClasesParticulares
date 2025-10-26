"""
EJERCICIO 8: Bucles While
En este ejercicio aprenderás a usar bucles while para repetir código.
"""

# 1. Bucle while básico
print("=== BUCLE WHILE BÁSICO ===")
contador = 0
while contador < 5:
    print(f"Contador: {contador}")
    contador += 1  # IMPORTANTE: Incrementar para evitar bucle infinito

# 2. Adivinar un número
print("\n=== JUEGO: ADIVINA EL NÚMERO ===")
numero_secreto = 7
intentos = 3

while intentos > 0:
    adivinanza = int(input(f"Intenta adivinar el número (tienes {intentos} intentos): "))
    
    if adivinanza == numero_secreto:
        print("¡Correcto! ¡Ganaste!")
        break
    elif adivinanza < numero_secreto:
        print("El número es mayor")
    else:
        print("El número es menor")
    
    intentos -= 1

if intentos == 0:
    print(f"¡Perdiste! El número era {numero_secreto}")

# 3. Menú con bucle while
print("\n=== MENÚ REPETITIVO ===")
opcion = ""

while opcion != "3":
    print("\n1. Saludar")
    print("2. Despedirse")
    print("3. Salir")
    opcion = input("Elige una opción: ")
    
    if opcion == "1":
        print("¡Hola!")
    elif opcion == "2":
        print("¡Hasta luego!")
    elif opcion == "3":
        print("Saliendo...")
    else:
        print("Opción no válida")

# 4. Bucle con condición de salida especial
print("\n=== PEDIR DATOS HASTA QUE SEA VÁLIDO ===")
edad = -1

while edad < 0 or edad > 120:
    try:
        edad = int(input("Introduce tu edad (0-120): "))
        if edad < 0 or edad > 120:
            print("Edad no válida. Intenta de nuevo.")
    except ValueError:
        print("Por favor, introduce un número válido.")
        edad = -1

print(f"Tu edad es: {edad} años")

# PRÁCTICA: Crea un programa que sume números hasta que el usuario diga "fin"
print("\n=== SUMADOR DE NÚMEROS ===")
# TODO: Escribe tu código aquí


