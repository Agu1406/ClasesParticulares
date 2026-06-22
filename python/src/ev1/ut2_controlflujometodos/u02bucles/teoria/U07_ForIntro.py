"""
U07 — Bucle for y range().

OBJETIVO:
  - Repetir un bloque un numero conocido de veces.
  - range(stop), range(inicio, fin), range(inicio, fin, paso).
  - Recorrer listas y cadenas con for elemento in secuencia.

PARAMETRO end EN print() (muy usado en bucles):
  - Por defecto, print() termina con salto de linea (end="\\n").
  - end=" " cambia eso: despues del texto imprime un ESPACIO y NO baja de linea.
  - Asi varias vueltas del for pueden escribir en la MISMA linea: 0 1 2 3 4
  - Cuando el bucle acaba, print() sin argumentos (o print("")) fuerza un salto
    de linea para que lo siguiente no quede pegado.

  Ejemplo mental:
    print(1, end=" ")  -> escribe "1 " y el cursor sigue en la misma linea
    print(2, end=" ")  -> escribe "2 " al lado: "1 2 "
    print()            -> baja de linea

Autor: Agustin. A. Marquez. Pina
"""

# print(): titulo de la primera demo
print("=== range(5) -> 0 a 4 ===")
# range(5): genera 0,1,2,3,4; for asigna cada valor a i
for i in range(5):
    # print(): muestra i; end=" " pone un espacio al final SIN saltar de linea
    # (si no pusieras end, cada numero saldria en una linea distinta)
    print(i, end=" ")
# print(): sin texto, solo hace salto de linea tras la secuencia 0 1 2 3 4
print()

# print(): titulo segunda demo
print("\n=== range(1, 6) -> 1 a 5 ===")
# range(1, 6): del 1 al 5 (el 6 no se incluye)
for n in range(1, 6):
    # print(): mismo truco: todos los numeros en una linea separados por espacio
    print(n, end=" ")
# print(): cierra la linea antes del siguiente bloque
print()

# print(): titulo tercera demo
print("\n=== range(0, 10, 2) ===")
# range(0, 10, 2): de 0 a 8 saltando de 2 en 2
for n in range(0, 10, 2):
    # print(): imprime 0 2 4 6 8 en la misma fila gracias a end=" "
    print(n, end=" ")
# print(): salto de linea final
print()

frutas = ["manzana", "pera", "uva"]
# for ... in frutas: recorre cada elemento de la lista
for fruta in frutas:
    # print(): aqui NO usamos end; cada fruta va en su propia linea (comportamiento por defecto)
    print("-", fruta)

# enumerate(frutas, start=1): devuelve parejas (indice, elemento)
for indice, fruta in enumerate(frutas, start=1):
    # print(): f-string con numero y fruta
    print(f"{indice}. {fruta}")

total = 0
# range(1, 11): numeros del 1 al 10
for i in range(1, 11):
    total += i
# print(): muestra la suma acumulada
print("Suma 1..10 =", total)

# print(): titulo tabla del 7
print("\nTabla del 7:")
for i in range(1, 11):
    # print(): cada fila de la tabla en linea nueva (end por defecto es \\n)
    print(f"7 x {i} = {7 * i}")
