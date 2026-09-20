"""
U02 — except especifico (ValueError, ZeroDivisionError).

OBJETIVO:
  - Encadenar varios except: Python ejecuta el PRIMERO que coincide.
  - Lo mas concreto va antes; Exception generica al final.
  - ValueError al convertir texto; ZeroDivisionError al dividir entre cero.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


def demo_division_cero():
    print("¡DEMO — Division entre cero!\n")
    try:
        a = int("12")
        b = 0
        print(f"Resultado: {a / b}")
    except ValueError:
        print("Formato invalido al convertir texto a numero.")
    except ZeroDivisionError:
        print("No se puede dividir entre cero.")
    except Exception as ex:
        print(f"Otro error: {ex}")


def demo_formato_invalido():
    print("¡DEMO — Formato invalido!\n")
    try:
        valor = int("doce")
        print(f"Valor: {valor}")
    except ValueError:
        print("Formato invalido: el texto no representa un entero.")
    except ZeroDivisionError:
        print("No se puede dividir entre cero.")
    except Exception as ex:
        print(f"Otro error: {ex}")


def demo_sin_errores():
    print("¡DEMO — Sin errores!\n")
    try:
        x = int("8")
        y = 2
        print(f"Division correcta: {x / y}")
    except ValueError:
        print("Formato invalido al convertir texto a numero.")
    except ZeroDivisionError:
        print("No se puede dividir entre cero.")


print("\n¡INICIO DEL PROGRAMA!\n")
demo_division_cero()
print()
demo_formato_invalido()
print()
demo_sin_errores()
print("\n¡FIN DEL PROGRAMA!\n")
