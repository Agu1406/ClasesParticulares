"""
U05 — if / elif / else y operador ternario.

OBJETIVO:
  - Encadenar varias condiciones con elif (rangos, escalones).
  - else cubre el caso restante.
  - Operador ternario: valor_si_true if condicion else valor_si_false
  - Si comparas muchos valores exactos (1, 2, 3...), mira U06 match/case.

Autor: Agustin. A. Marquez. Pina
"""

nota = 7.2

if nota >= 9:
    calificacion = "Sobresaliente"
elif nota >= 7:
    calificacion = "Notable"
elif nota >= 5:
    calificacion = "Aprobado"
else:
    calificacion = "Suspenso"

# print(): f-string con nota y la calificacion asignada en el if/elif
print(f"Nota {nota} -> {calificacion}")

numero = 14
if numero % 2 == 0:
    # print(): modulo % devuelve resto; si es 0 el numero es par
    print(numero, "es par")
else:
    # print(): rama else cuando el resto no es 0
    print(numero, "es impar")

edad = 16
mensaje = "puede votar" if edad >= 18 else "no puede votar"
# print(): muestra el resultado del operador ternario
print(mensaje)

respuesta = "si"
if respuesta.lower() == "si":
    # lower(): convierte el texto a minusculas antes de comparar
    print("Respuesta afirmativa")
