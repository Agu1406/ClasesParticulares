"""
OBJETIVO: Crea un dict {palabra: longitud} con dict comprehension.
SOLUCION: {p: len(p) for p in palabras}.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

palabras = ["sol", "programacion", "pf"]
print({p: len(p) for p in palabras})
