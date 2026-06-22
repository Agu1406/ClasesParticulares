"""
OBJETIVO: Cuenta vocales en "programacion".
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
"""

p = "programacion"
v = "aeiou"
c = 0
for ch in p:
    if ch in v:
        c += 1
print(c)
