"""
U04 — Condicional if.

OBJETIVO:
  - Ejecutar codigo solo si se cumple una condicion.
  - Sintaxis: if condicion: (dos puntos + bloque indentado).
  - Las condiciones usan expresiones booleanas (True/False).
  - Solo if (sin else): el bloque se salta si la condicion es False.

SIGUIENTE BLOQUE: U05 (elif/else), U06 (match/case), U07 (anidados).

Autor: Agustin. A. Marquez. Pina
"""

edad = 17

if edad >= 18:
    # print(): solo se ejecuta si edad >= 18
    print("Mayor de edad")
# print(): esta fuera del if; siempre se ejecuta
print("Fin del programa")

nota = 6
if nota >= 5:
    # print(): muestra mensaje y el valor de nota si aprobo
    print("Aprobado con", nota)

temperatura = 22
soleado = True
if temperatura > 20 and soleado:
    # print(): se ejecuta si ambas condiciones son verdaderas (and)
    print("Buen dia para salir")

stock = 0
if stock > 0:
    # print(): solo si hay stock positivo
    print("Hay producto disponible")
