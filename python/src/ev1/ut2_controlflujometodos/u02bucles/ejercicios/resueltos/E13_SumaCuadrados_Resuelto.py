"""
OBJETIVO: Calcula la suma de los cuadrados del 1 al 10 (1+4+9+...+100).
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

total = 0
for i in range(1, 11):
    total += i * i
print(f"Suma de cuadrados 1..10 = {total}")
