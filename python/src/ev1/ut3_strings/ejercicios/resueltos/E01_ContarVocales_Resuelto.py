"""
OBJETIVO: Cuenta vocales en "programacion".
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

p = "programacion"
v = "aeiou"
c = 0
for ch in p:
    if ch in v:
        c += 1
print(c)
