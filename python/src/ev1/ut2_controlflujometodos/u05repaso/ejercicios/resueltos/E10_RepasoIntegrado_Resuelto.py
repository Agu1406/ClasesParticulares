"""
OBJETIVO: def clasificar(n): SB si n>=9 else AP si n>=5 else SS. n=7.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

def clasificar(n):
    if n >= 9:
        return "SB"
    if n >= 5:
        return "AP"
    return "SS"

print(clasificar(7))
