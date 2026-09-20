"""
U04 — Lanzar excepciones con raise.

OBJETIVO:
  - Validar parametros con if y signalizar fallos con raise TipoError("mensaje").
  - Capturar en el llamador la excepcion lanzada por una funcion.
  - Contrastar llamada valida (sin raise) con llamada invalida.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


def validar_edad(edad):
    if edad < 0:
        raise ValueError("La edad no puede ser negativa")
    return edad


def validar_nota(nota):
    if nota < 0 or nota > 10:
        raise ValueError("La nota debe estar entre 0 y 10")
    return nota


def dividir_positivo(a, b):
    if b == 0:
        raise ZeroDivisionError("No se puede dividir entre cero")
    return a / b


print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Edad invalida vs valida.
"""
print("¡DEMO 1: raise ValueError (edad)!\n")

try:
    print("Edad valida:", validar_edad(20))
except ValueError as e:
    print("Error:", e)

try:
    print("Edad invalida:", validar_edad(-3))
except ValueError as e:
    print("Error:", e)

"""
SEGUNDA PARTE — Validar nota.
"""
print("\n¡DEMO 2: raise ValueError (nota)!\n")

try:
    print("Nota OK:", validar_nota(7.5))
except ValueError as e:
    print("Error:", e)

try:
    print("Nota mala:", validar_nota(11))
except ValueError as e:
    print("Error:", e)

"""
TERCERA PARTE — raise ZeroDivisionError propio.
"""
print("\n¡DEMO 3: raise ZeroDivisionError!\n")

try:
    print("Division OK:", dividir_positivo(10, 2))
except ZeroDivisionError as e:
    print("Error:", e)

try:
    print("Division mala:", dividir_positivo(10, 0))
except ZeroDivisionError as e:
    print("Error:", e)

print("\n¡FIN DEL PROGRAMA!\n")
