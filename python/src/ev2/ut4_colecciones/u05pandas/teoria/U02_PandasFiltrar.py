"""
U02 — pandas: filtrar, agrupar y describir.

OBJETIVO:
  - Filtrar filas con condiciones booleanas.
  - Usar groupby + mean.
  - describe() para resumen estadistico.

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

df = pd.DataFrame(
    {
        "nombre": ["Ana", "Luis", "Eva", "Pedro"],
        "nota": [7.5, 4.0, 9.0, 5.5],
        "curso": ["A", "B", "A", "B"],
    }
)

print("Aprobados (nota >= 5):\n", df[df["nota"] >= 5])
print("\nMedia por curso:\n", df.groupby("curso")["nota"].mean())
print("\ndescribe():\n", df["nota"].describe())

print("\n¡FIN DEL PROGRAMA!\n")
