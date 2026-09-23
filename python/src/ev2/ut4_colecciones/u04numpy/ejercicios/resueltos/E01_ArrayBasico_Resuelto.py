"""
OBJETIVO: Crea un np.array [2,4,6,8], imprime shape y el doble de cada elemento.
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

a = np.array([2, 4, 6, 8])
print("shape:", a.shape)
print("doble:", a * 2)
