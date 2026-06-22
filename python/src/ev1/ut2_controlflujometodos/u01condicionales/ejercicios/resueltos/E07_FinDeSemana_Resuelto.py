"""
OBJETIVO: Dia 1-7: 6 o 7 fin de semana, si no laborable.
TIPO: if / elif + in.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

dia = int(input("Dia (1-7): "))
if dia in (6, 7):
    print("fin de semana")
else:
    print("laborable")
