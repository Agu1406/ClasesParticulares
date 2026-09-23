"""
OBJETIVO: DataFrame con curso y nota; media de nota por curso (groupby).
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

df = pd.DataFrame({
    "curso": ["A", "B", "A", "B"],
    "nota": [7.0, 5.0, 9.0, 6.0],
})
print(df.groupby("curso")["nota"].mean())
