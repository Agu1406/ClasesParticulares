"""
U03 — Bloques else y finally.

OBJETIVO:
  - else se ejecuta si el try termino SIN excepcion.
  - finally se ejecuta SIEMPRE: haya error o no.
  - finally sirve para limpieza o mensajes de cierre garantizados.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


def demo_else_sin_error():
    print("¡DEMO — else cuando todo va bien!\n")
    try:
        resultado = 10 / 2
    except ZeroDivisionError:
        print("Error de division")
    else:
        print("Todo bien, resultado =", resultado)
    finally:
        print("Finally: siempre se ejecuta")


def demo_finally_tras_error():
    print("\n¡DEMO — finally tras error!\n")
    try:
        print("Entrando en try...")
        a = 10
        b = 0
        print(f"Resultado: {a / b}")
    except ZeroDivisionError:
        print("Division entre cero detectada en except.")
    finally:
        print("Finally: siempre se ejecuta (tras error).")


def demo_finally_como_cierre():
    print("\n¡DEMO — finally como cierre!\n")
    operacion_completada = False
    try:
        dato = int("42")
        operacion_completada = True
        print(f"Operacion OK con dato {dato}")
    except ValueError:
        print("No se pudo completar la operacion.")
    finally:
        if operacion_completada:
            print("Finally: liberando recursos (demo).")
        else:
            print("Finally: limpieza tras fallo (demo).")


print("\n¡INICIO DEL PROGRAMA!\n")
demo_else_sin_error()
demo_finally_tras_error()
demo_finally_como_cierre()
print("\n¡FIN DEL PROGRAMA!\n")
