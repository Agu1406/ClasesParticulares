"""
OBJETIVO: Dos objetos Punto independientes; cambia uno y verifica que el otro no cambia.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

class Punto:
    def __init__(self, x, y):
        self.x = x
        self.y = y


p1 = Punto(1, 2)
p2 = Punto(1, 2)
p1.x = 99
print("p1:", p1.x, p1.y)
print("p2:", p2.x, p2.y)
