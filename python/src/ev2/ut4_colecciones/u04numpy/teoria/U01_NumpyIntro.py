"""
U01 — Introduccion a NumPy (arrays).

OBJETIVO:
  - Crear arrays con np.array.
  - Ver shape, dtype y operaciones vectorizadas basicas.
  - Requiere: pip install numpy

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

print("¡DEMO 1: ARRAY 1D!\n")
a = np.array([1, 2, 3, 4])
print(a, "shape=", a.shape, "dtype=", a.dtype)

print("\n¡DEMO 2: OPERACIONES VECTORIZADAS!\n")
print("a * 2 =", a * 2)
print("a + 10 =", a + 10)
print("media =", a.mean())

print("\n¡DEMO 3: ARRAY 2D!\n")
m = np.array([[1, 2], [3, 4]])
print(m)
print("m[0, 1] =", m[0, 1])

print("\n¡FIN DEL PROGRAMA!\n")
