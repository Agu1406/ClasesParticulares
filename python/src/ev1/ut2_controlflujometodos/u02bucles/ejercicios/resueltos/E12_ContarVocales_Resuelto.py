"""
OBJETIVO: Recorre "programacion" y cuenta cuantas vocales tiene (a,e,i,o,u).
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

palabra = "programacion"
vocales = 0
for letra in palabra:
    if letra in "aeiou":
        vocales += 1
print(f"Vocales en \"{palabra}\": {vocales}")
