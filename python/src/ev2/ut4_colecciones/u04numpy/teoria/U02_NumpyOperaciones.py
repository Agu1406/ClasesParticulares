"""
U02 — NumPy: slicing, broadcasting y estadisticos.

OBJETIVO:
  - Rebanar arrays (slicing).
  - Sumar/restar arrays compatibles (broadcasting sencillo).
  - Usar min, max, sum, mean.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

try:
    import numpy as np
except ImportError:
    print("Instala NumPy: pip install numpy")
    raise SystemExit(1)

print("\n¡INICIO DEL PROGRAMA!\n")

v = np.array([10, 20, 30, 40, 50])
print("v[1:4] =", v[1:4])
print("v[::-1] =", v[::-1])

a = np.array([1, 2, 3])
b = np.array([10, 20, 30])
print("a + b =", a + b)
print("min/max/sum:", a.min(), a.max(), a.sum())

print("\n¡FIN DEL PROGRAMA!\n")
