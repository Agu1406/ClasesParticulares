"""
OBJETIVO: Cuenta cuantos tienen nota >=5 en {"Ana":7,"Luis":4,"Marta":8}.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

notas = {"Ana": 7, "Luis": 4, "Marta": 8}
aprobados = 0
for n in notas.values():
    if n >= 5:
        aprobados += 1
print(aprobados)
