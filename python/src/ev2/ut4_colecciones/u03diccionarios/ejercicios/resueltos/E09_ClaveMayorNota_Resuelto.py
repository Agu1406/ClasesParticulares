"""
OBJETIVO: En {"Ana":7,"Luis":9,"Marta":8}, imprime el nombre con mayor nota.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

notas = {"Ana": 7, "Luis": 9, "Marta": 8}
nombre = max(notas, key=notas.get)
print(nombre)
