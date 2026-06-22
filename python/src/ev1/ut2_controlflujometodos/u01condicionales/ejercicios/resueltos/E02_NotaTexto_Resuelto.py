"""
OBJETIVO: Nota 0-10: >=9 SB, >=7 NT, >=5 AP, si no SS.
TIPO: if / elif / else.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
"""

nota = float(input("Nota: "))
if nota >= 9:
    print("Sobresaliente")
elif nota >= 7:
    print("Notable")
elif nota >= 5:
    print("Aprobado")
else:
    print("Suspenso")
