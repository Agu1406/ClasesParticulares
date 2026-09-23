"""
OBJETIVO: De lista de tuplas (nombre, nota) construye un dict e imprime los aprobados.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

pares = [("Ana", 7), ("Luis", 4), ("Eva", 9)]
notas = dict(pares)
aprobados = [n for n, nota in notas.items() if nota >= 5]
print(notas)
print(aprobados)
