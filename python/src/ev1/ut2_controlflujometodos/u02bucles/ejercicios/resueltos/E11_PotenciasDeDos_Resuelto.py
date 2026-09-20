"""
OBJETIVO: Imprime las potencias de 2 desde 2^0 hasta 2^7 (1, 2, 4, ..., 128).
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

valor = 1
for i in range(8):
    print(f"2^{i} = {valor}")
    valor *= 2
