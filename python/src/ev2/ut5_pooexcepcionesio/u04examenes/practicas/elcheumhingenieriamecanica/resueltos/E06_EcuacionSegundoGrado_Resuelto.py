"""
Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev

ENUNCIADO
---------
Fuente: Práctica 2 — Entrada y Salida (T5-P2) — EJERCICIOS ADICIONALES

Hacer un programa en Python que pida al usuario los coeficientes (A, B y C) de una ecuación
de segundo grado y muestre por pantalla las dos soluciones, suponiendo que existan.

Ecuación de 2º grado: A·x² + B·x + C = 0

(Ver ejemplo de funcionamiento en el PDF original elche-umh-t5-p2-entrada-salida.pdf)

Nota del enunciado adicional (contexto): se propone también revisar programas de prácticas
anteriores para introducir datos por teclado o ficheros y, si procede, escribir salidas en ficheros.
"""

# ALGORITMO:
# 1. Pedir A, B y C.
# 2. Calcular el discriminante D = B² - 4AC.
# 3. Si D >= 0 y A != 0:
#      x1 = (-B + sqrt(D)) / (2A)
#      x2 = (-B - sqrt(D)) / (2A)
#    (sqrt con ** 0.5)
# 4. Mostrar las dos soluciones.

A = float(input("Coeficiente A: "))
B = float(input("Coeficiente B: "))
C = float(input("Coeficiente C: "))

discriminante = B ** 2 - 4 * A * C
raiz = discriminante ** 0.5

x1 = (-B + raiz) / (2 * A)
x2 = (-B - raiz) / (2 * A)

print("Solucion 1:", x1)
print("Solucion 2:", x2)
