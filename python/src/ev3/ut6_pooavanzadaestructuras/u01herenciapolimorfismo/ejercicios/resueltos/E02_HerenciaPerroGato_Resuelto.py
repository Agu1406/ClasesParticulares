"""
OBJETIVO: Anadir Gato a la jerarquia Animal y demostrar super() + dos sonidos distintos.
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
    def hacer_sonido(self):
        return "Guau"


class Gato(Animal):
    def hacer_sonido(self):
        return "Miau"


print(Perro("Rex").hacer_sonido())
print(Gato("Michi").hacer_sonido())
