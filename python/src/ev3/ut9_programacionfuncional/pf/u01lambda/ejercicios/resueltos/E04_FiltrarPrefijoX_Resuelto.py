"""
OBJETIVO: Elimina palabras que empiezan por 'x' (ignore case). Equivalente a removeIf.
SOLUCION: comprehension que conserva las que no empiezan por x.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

palabras = ["xilofono", "casa", "Xeno", "sol"]
quedan = [p for p in palabras if not p.lower().startswith("x")]
print(quedan)
