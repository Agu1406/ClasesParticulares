"""
U01 — Introduccion a pandas (Series y DataFrame).

OBJETIVO:
  - Crear Series y DataFrame.
  - Ver columnas, head y seleccion basica.
  - Requiere: pip install pandas

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

try:
    import pandas as pd
except ImportError:
    print("Instala pandas: pip install pandas")
    raise SystemExit(1)

print("\n¡INICIO DEL PROGRAMA!\n")

print("¡DEMO 1: SERIES!\n")
s = pd.Series([7, 8, 6], index=["Ana", "Luis", "Eva"])
print(s)
print("Luis:", s["Luis"])

print("\n¡DEMO 2: DATAFRAME!\n")
df = pd.DataFrame(
    {
        "nombre": ["Ana", "Luis", "Eva"],
        "nota": [7.5, 8.0, 6.0],
        "curso": ["A", "B", "A"],
    }
)
print(df)
print("columnas:", list(df.columns))
print("solo notas:\n", df["nota"])

print("\n¡FIN DEL PROGRAMA!\n")
