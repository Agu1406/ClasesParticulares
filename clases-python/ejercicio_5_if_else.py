"""
EJERCICIO 5: Condicionales Avanzadas
En este ejercicio practicarás más condicionales complejos.
"""

# 1. Verificar múltiples condiciones
print("=== VERIFICACIÓN MÚLTIPLE ===")
usuario = input("Usuario: ")
contraseña = input("Contraseña: ")

# Simulación de base de datos
usuarios_validos = {"admin": "1234", "user": "password"}

if usuario in usuarios_validos and usuarios_validos[usuario] == contraseña:
    print("✓ Acceso concedido")
else:
    print("✗ Acceso denegado")

# 2. Rangos numéricos
print("\n=== RANGOS NUMÉRICOS ===")
numero = int(input("Introduce un número: "))

if 0 <= numero <= 10:
    print("Número entre 0 y 10")
elif 11 <= numero <= 50:
    print("Número entre 11 y 50")
elif 51 <= numero <= 100:
    print("Número entre 51 y 100")
else:
    print("Número fuera de rango")

# 3. Comparar cadenas de texto
print("\n=== COMPARACIÓN DE TEXTO ===")
deseo = input("¿Te gusta programar? (si/no/a veces): ")

if deseo.lower() == "si":
    print("¡Excelente! Sigue practicando")
elif deseo.lower() == "a veces":
    print("Es normal, con la práctica te gustará más")
else:
    print("No te preocupes, mejorará con el tiempo")

# 4. Operadores ternarios (if corto)
print("\n=== OPERADOR TERNARIO ===")
numero = int(input("Introduce un número: "))
resultado = "es positivo" if numero > 0 else "es negativo o cero"
print(f"El número {resultado}")

# PRÁCTICA: Crea un sistema de recomendación de películas según la edad
# Menores de 13: Infantiles
# 13-17: Adolescentes
# 18+: Adultos
print("\n=== RECOMENDADOR DE PELÍCULAS ===")
# TODO: Escribe tu código aquí


