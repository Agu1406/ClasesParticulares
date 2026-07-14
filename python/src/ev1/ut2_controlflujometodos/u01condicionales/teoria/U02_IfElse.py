"""
U02 — Condicional if-else y elif.

OBJETIVO:
    - Aprender la sintaxis y el uso de "elif".
    - Aprender la sintaxis y el uso de "if-else".
    - Aprender a personalizar los mensajes usando los ternarios.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""
print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE - Sintaxis y uso del if-else.
"""
print(f"\n¡PROBANDO EL \"IF-ELSE\" CON VALORES INTRODUCIDOS EN EL PROGRAMA!\n")
# Usamos "input" para escribir en cada prueba una nota diferente.
nota = input("¡Dime que nota sacaste en el examen y te dire si has aprobado! ")
print()

# Convertimos la nota en un número entero usando la función "int()".
nota = int(nota)

# Si la nota es mayor o igual a cinco, se ejecuta el "if".
if nota >= 5:
    print(f"¡Felicidades! Has aprobado con un {nota}. \n")
# Si la nota no es ni mayor ni igual a cinco, se ejecuta el "else".
else:
    print(f"¡Lo siento! Has suspendido con un {nota}. \n")

# Usamos "input" para escribir en cada prueba un núemro diferente.
numero = input("¡Dime un número y te dire si es par! ")
print()

# Si el resto de dividir X número entre dos es cero es un número par, se ejecuta el "if".
if numero % 2 == 0:
    print(f"El número {numero} es par.")
# Si el resto no es cero entonces es un número impar, se ejecuta el "else".
else:
    print(f"El número {numero} es impar.")
"""
SEGUNDA PARTE - Sintaxis y uso del elif.
"""
print(f"\n¡PROBANDO EL \"ELIF\" CON VALORES INTRODUCIDOS EN EL PROGRAMA!\n")

# TODO hacer un par de elifs como material de clase.

"""
TERCERA PARTE - Definir un resultado u otro usando ternarios y condiciones.
"""

# TODO hacer un par de ejemplos con ternarios.

print("\n¡FIN DEL PROGRAMA!\n")
