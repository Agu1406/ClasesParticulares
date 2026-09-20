"""
U01 — Excepciones: try / except.

OBJETIVO:
  - Capturar errores en tiempo de ejecucion sin que el programa se cierre.
  - try: codigo arriesgado / except TipoError: plan B.
  - int("abc") lanza ValueError; division por cero ZeroDivisionError.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


def dividir(a, b):
    try:
        return a / b
    except ZeroDivisionError:
        return "No se puede dividir entre cero"


def leer_entero_seguro(cadena):
    try:
        return int(cadena)
    except ValueError:
        print("Usa solo digitos")
        return None


print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Conversion segura con try / except.
"""
print("¡DEMO 1: CONVERSION OK!\n")
texto = "42"
try:
    numero = int(texto)
    print("Conversion OK:", numero)
except ValueError:
    print("No es un entero valido")

"""
SEGUNDA PARTE — Capturar el mensaje de error con as.
"""
print("\n¡DEMO 2: TEXTO INVALIDO!\n")
texto_malo = "hola"
try:
    numero = int(texto_malo)
except ValueError as error:
    print("Error capturado:", error)

"""
TERCERA PARTE — Funciones que devuelven un plan B.
"""
print("\n¡DEMO 3: DIVISION Y LECTURA!\n")
print(dividir(10, 2))
print(dividir(10, 0))
print(leer_entero_seguro("7"))
print(leer_entero_seguro("x"))

print("\n¡FIN DEL PROGRAMA!\n")
