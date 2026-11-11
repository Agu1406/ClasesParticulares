"""
U05 — Construir cadenas (paridad StringBuilder Java/C#).

OBJETIVO:
  - Ver que s += ... en un bucle crea muchas cadenas intermedias.
  - Preferir lista + "".join(...) cuando juntas muchas piezas.
  - Equivalente junior a StringBuilder.Append.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")

"""
PRIMERA PARTE — += en bucle (funciona, pero crea objetos de mas).
"""
print("¡DEMO 1: += EN BUCLE!\n")
con_mas = ""
i = 1
while i <= 5:
    con_mas = con_mas + str(i)
    if i < 5:
        con_mas = con_mas + ", "
    i = i + 1
print("Con += :", con_mas)

"""
SEGUNDA PARTE — Misma idea con lista + join (recomendado).
"""
print("\n¡DEMO 2: join!\n")
partes = []
n = 1
while n <= 5:
    partes.append(str(n))
    n = n + 1
con_join = ", ".join(partes)
print("Con join:", con_join)

"""
TERCERA PARTE — Frase a partir de palabras.
"""
print("\n¡DEMO 3: FRASE!\n")
palabras = ["Hola", "mundo", "Python"]
print(" ".join(palabras))
print("-".join(palabras))

print("\n¡FIN DEL PROGRAMA!\n")
