"""
OBJETIVO: Crear Animal (base) y Perro (subclase) con hacer_sonido. Demo: un Perro dice Guau.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

class Animal:
    def __init__(self, nombre):
        self._nombre = nombre

    def hacer_sonido(self):
        return "..."


class Perro(Animal):
    def __init__(self, nombre):
        super().__init__(nombre)

    def hacer_sonido(self):
        return "Guau"


perro = Perro("Rex")
print(perro.hacer_sonido())
