"""
OBJETIVO: Ordena ciudades ignorando mayusculas (key=str.casefold o str.lower).
SOLUCION: sorted(ciudades, key=str.casefold).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

ciudades = ["barcelona", "Almeria", "cadiz"]
print(sorted(ciudades, key=str.casefold))
