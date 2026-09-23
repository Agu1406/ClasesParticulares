"""
OBJETIVO: DataFrame con columnas nombre y edad (2 filas); imprime df y la columna edad.
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

df = pd.DataFrame({"nombre": ["Ana", "Luis"], "edad": [20, 22]})
print(df)
print(df["edad"])
