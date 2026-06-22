"""
U09 — Patrones con bucles anidados.

OBJETIVO:
  - Bucles dentro de bucles (tablas de multiplicar, dibujos).
  - Acumular resultados en variables.
  - Factorial como producto repetido.

Autor: Agustin. A. Marquez. Pina
"""

# print(): titulo tabla del 4
print("Tabla del 4:")
# range(1, 11): multiplicadores del 1 al 10
for i in range(1, 11):
    # print(): f-string con cada fila de la tabla
    print(f"4 x {i} = {4 * i}")

# print(): titulo varias tablas
print("\nTablas del 1 al 3:")
# range(1, 4): tablas del 1, 2 y 3
for tabla in range(1, 4):
    # print(): cabecera de cada tabla
    print(f"-- Tabla del {tabla} --")
    for i in range(1, 6):
        # print(): fila de la tabla interna
        print(f"{tabla} x {i} = {tabla * i}")

# print(): titulo triangulo
print("\nTriangulo:")
# range(1, 5): filas 1 a 4
for fila in range(1, 5):
    # print(): "*" repetido fila veces (operador * con cadena)
    print("*" * fila)

n = 5
factorial = 1
# range(1, n + 1): del 1 al 5 inclusive
for i in range(1, n + 1):
    factorial *= i
# print(): f-string con el factorial calculado
print(f"\nFactorial de {n} = {factorial}")

pares = impares = 0
for i in range(1, 11):
    if i % 2 == 0:
        pares += i
    else:
        impares += i
# print(): f-string con sumas de pares e impares
print(f"Suma pares={pares}, impares={impares}")
