"""
OBJETIVO: try/except: convierte 25 y hola a int.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

for t in ("25", "hola"):
    try:
        print(int(t))
    except ValueError:
        print("no es entero")
