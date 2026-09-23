"""
OBJETIVO: Array de notas [5,7,9,4,8]; imprime media y maxima.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

try:
    import numpy as np
except ImportError:
    print("pip install numpy")
    raise SystemExit(1)

notas = np.array([5, 7, 9, 4, 8])
print("media:", notas.mean())
print("max:", notas.max())
