"""
EJERCICIO 4: Condicionales (if, else)
En este ejercicio aprenderás a tomar decisiones en tu código.
"""

# 1. Condicionales simples
print("=== CONDICIONALES SIMPLES ===")
edad = 18

if edad >= 18:
    print("Eres mayor de edad")
else:
    print("Eres menor de edad")

# 2. Múltiples condiciones con elif
print("\n=== MÚLTIPLES CONDICIONES ===")
nota = float(input("Introduce tu calificación (0-10): "))

if nota >= 9:
    print("¡Excelente! Sobresaliente")
elif nota >= 7:
    print("Muy bien, notable")
elif nota >= 5:
    print("Bien, suficiente")
else:
    print("Necesitas estudiar más")

# 3. Condiciones anidadas
print("\n=== CONDICIONES ANIDADAS ===")
edad = int(input("¿Cuántos años tienes? "))
tiene_carnet = input("¿Tienes carnet de conducir? (si/no): ")

if edad >= 18:
    if tiene_carnet.lower() == "si":
        print("Puedes alquilar un coche")
    else:
        print("Puedes conducir, pero necesitas carnet")
else:
    print("Eres menor de edad para conducir")

# 4. Operadores lógicos (and, or, not)
print("\n=== OPERADORES LÓGICOS ===")
temperatura = float(input("¿Cuál es la temperatura? "))
llueve = input("¿Está lloviendo? (si/no): ")

if temperatura > 25 and llueve.lower() == "no":
    print("Hace buen día, ¡sal a pasear!")
elif temperatura < 15 or llueve.lower() == "si":
    print("Mejor quedarse en casa")
else:
    print("Día normal")

# PRÁCTICA: Crea un programa que diga si un número es par o impar
print("\n=== PAR O IMPAR ===")
# TODO: Escribe tu código aquí


