"""
OBJETIVO: Cuenta frecuencias en ["gato","perro","gato"] e imprime el dict.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

palabras = ["gato", "perro", "gato"]
conteo = {}
for p in palabras:
    conteo[p] = conteo.get(p, 0) + 1
print(conteo)
