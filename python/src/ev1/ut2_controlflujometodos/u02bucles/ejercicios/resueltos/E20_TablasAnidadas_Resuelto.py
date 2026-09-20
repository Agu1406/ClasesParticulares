"""
OBJETIVO: Bucles anidados: imprime las tablas del 1 al 3 (cada una del 1 al 5).
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

for tabla in range(1, 4):
    print(f"-- Tabla del {tabla} --")
    for i in range(1, 6):
        print(f"{tabla} x {i} = {tabla * i}")
    print()
