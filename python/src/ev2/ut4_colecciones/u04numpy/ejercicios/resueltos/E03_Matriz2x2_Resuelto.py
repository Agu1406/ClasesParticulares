"""
OBJETIVO: Crea matriz [[1,2],[3,4]] y muestra el elemento [1,0].
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

m = np.array([[1, 2], [3, 4]])
print(m)
print("m[1,0] =", m[1, 0])
