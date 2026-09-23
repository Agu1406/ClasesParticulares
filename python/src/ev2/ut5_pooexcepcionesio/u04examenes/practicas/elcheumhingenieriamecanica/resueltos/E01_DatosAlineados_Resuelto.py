"""
Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev

ENUNCIADO
---------
Fuente: Práctica 2 — Entrada y Salida (T5-P2)

EJERCICIO 1. DATOS ALINEADOS

Escribe un programa que pida por teclado al usuario tres números reales. A continuación,
muestra en pantalla una tabla con tres filas:
- En la primera fila aparecen los valores originales.
- En la segunda fila, sus cuadrados.
- En la tercera fila, sus cubos.

Cada fila debe comenzar con una etiqueta alineada a la izquierda en un espacio de 10
caracteres. Luego, los tres valores numéricos deben mostrarse con dos cifras decimales,
ocupando 10 caracteres cada uno y alineados al centro entre dos barras verticales | .

Ejemplo de salida esperada: (ver PDF original elche-umh-t5-p2-entrada-salida.pdf)
"""

# ALGORITMO:
# 1. Pedir tres números reales por teclado.
# 2. Para cada fila (valores, cuadrados, cubos):
#    - Escribir una etiqueta a la izquierda en 10 caracteres.
#    - Escribir los tres números con 2 decimales, centrados en 10 caracteres, entre |.


def pedir_numero():
    n = float(input("Di un numero: "))
    return n


numero1 = pedir_numero()
numero2 = pedir_numero()
numero3 = pedir_numero()

print(f"{'Valores:':<10} {numero1:^10.2f} | {numero2:^10.2f} | {numero3:^10.2f}")
print(f"{'Cuadrados:':<10} {numero1 ** 2:^10.2f} | {numero2 ** 2:^10.2f} | {numero3 ** 2:^10.2f}")
print(f"{'Cubo:':<10} {numero1 ** 3:^10.2f} | {numero2 ** 3:^10.2f} | {numero3 ** 3:^10.2f}")
