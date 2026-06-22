"""
U05 — Repaso EV1: conceptos clave.

OBJETIVO:
  - Repasar el flujo tipico de un programa junior en Python.
  - Orden sugerido: datos -> proceso -> salida.
  - Sin practica nueva: solo recordatorio antes de evaluacion.

Autor: Agustin. A. Marquez. Pina
"""

# print(): titulo del repaso
print("=== REPASO EV1 ===")
# print(): punto 1 del indice
print("1. UT1: print, variables, tipos, operadores, input, comentarios")
# print(): punto 2 del indice
print("2. UT2: if/elif/else, for, while, funciones, excepciones basicas")
# print(): punto 3 del indice
print("3. UT3: cadenas str, metodos, f-strings")
# print(): linea en blanco
print()
# print(): patron de programa
print("Patron minimo de programa:")
# print(): paso 1 del patron
print("  # 1. Pedir o definir datos")
# print(): paso 2 del patron
print("  # 2. Procesar (operar, decidir, repetir)")
# print(): paso 3 del patron
print("  # 3. Mostrar resultado con print o return")
# print(): linea en blanco
print()
# print(): titulo del ejemplo
print("Ejemplo integrado:")


def clasificar_edad(edad):
    if edad < 18:
        # return: devuelve "menor" si edad < 18
        return "menor"
    # return: devuelve "mayor" en cualquier otro caso
    return "mayor"


edades = [15, 22, 17]
# for e in edades: recorre cada edad de la lista
for e in edades:
    # print(): f-string con edad y resultado de clasificar_edad(e)
    print(f"Edad {e} -> {clasificar_edad(e)}")
