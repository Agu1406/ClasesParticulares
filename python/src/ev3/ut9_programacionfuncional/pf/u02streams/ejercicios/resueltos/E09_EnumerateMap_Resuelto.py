"""
OBJETIVO: Combina enumerate y map (o comprehension) para listar (índice, longitud).
SOLUCION: [(i, len(p)) for i, p in enumerate(palabras)].

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

palabras = ["sol", "luna", "pf"]
print([(i, len(p)) for i, p in enumerate(palabras)])
