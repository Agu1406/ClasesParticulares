"""
OBJETIVO: Lista de dicts alumnos; imprime nombres con nota > 6 y la media global.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

alumnos = [
    {"nombre": "Ana", "nota": 7},
    {"nombre": "Luis", "nota": 5},
    {"nombre": "Eva", "nota": 9},
]
buenos = [a["nombre"] for a in alumnos if a["nota"] > 6]
media = sum(a["nota"] for a in alumnos) / len(alumnos)
print(buenos)
print(media)
