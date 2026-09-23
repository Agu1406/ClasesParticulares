"""
OBJETIVO: DataFrame nombre/nota; muestra solo filas con nota >= 5.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

try:
    import pandas as pd
except ImportError:
    print("pip install pandas")
    raise SystemExit(1)

df = pd.DataFrame({"nombre": ["Ana", "Luis", "Eva"], "nota": [7, 4, 9]})
print(df[df["nota"] >= 5])
