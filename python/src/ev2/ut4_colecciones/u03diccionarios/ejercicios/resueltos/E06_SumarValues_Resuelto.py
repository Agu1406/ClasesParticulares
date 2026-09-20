"""
OBJETIVO: Suma los valores de {"a":10,"b":20,"c":5} e imprime el total.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

d = {"a": 10, "b": 20, "c": 5}
total = 0
for v in d.values():
    total += v
print(total)
