"""
U08 — Excepciones: try / except.

OBJETIVO:
  - Capturar errores en tiempo de ejecucion sin que el programa se cierre.
  - try: codigo arriesgado / except TipoError: plan B.
  - int("abc") lanza ValueError; division por cero ZeroDivisionError.

Autor: Agustin. A. Marquez. Pina
"""

texto = "42"
try:
    # int(): convierte texto a entero; puede fallar si no es numero
    numero = int(texto)
    # print(): confirma conversion correcta
    print("Conversion OK:", numero)
except ValueError:
    # print(): se ejecuta si int() lanzo ValueError
    print("No es un entero valido")

texto_malo = "hola"
try:
    # int(): intento que fallara con "hola"
    numero = int(texto_malo)
except ValueError as error:
    # print(): muestra el mensaje de error capturado en la variable error
    print("Error capturado:", error)


def dividir(a, b):
    try:
        # return: intenta dividir; puede lanzar ZeroDivisionError
        return a / b
    except ZeroDivisionError:
        # return: devuelve texto de error si b es 0
        return "No se puede dividir entre cero"


# print(): resultado de dividir(10, 2)
print(dividir(10, 2))
# print(): resultado de dividir(10, 0) con manejo de error
print(dividir(10, 0))


def leer_entero_seguro(cadena):
    try:
        # int(): convierte la cadena recibida
        return int(cadena)
    except ValueError:
        # print(): aviso al usuario
        print("Usa solo digitos")
        # return: devuelve None si fallo
        return None


# print(): llama a leer_entero_seguro con texto valido
print(leer_entero_seguro("7"))
# print(): llama con texto invalido
print(leer_entero_seguro("x"))

try:
    resultado = 10 / 2
except ZeroDivisionError:
    # print(): solo si hubo division por cero
    print("Error")
else:
    # print(): se ejecuta si no hubo excepcion en el try
    print("Todo bien, resultado =", resultado)
finally:
    # print(): finally siempre se ejecuta al salir del try/except
    print("Bloque finally: siempre se ejecuta")
