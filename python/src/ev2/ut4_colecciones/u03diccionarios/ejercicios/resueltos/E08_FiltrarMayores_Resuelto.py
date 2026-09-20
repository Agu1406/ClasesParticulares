"""
OBJETIVO: De Ana15 Luis18 Pedro20, deja solo >=18 en un dict nuevo.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

edades = {"Ana": 15, "Luis": 18, "Pedro": 20}
mayores = {}
for n, e in edades.items():
    if e >= 18:
        mayores[n] = e
print(mayores)
