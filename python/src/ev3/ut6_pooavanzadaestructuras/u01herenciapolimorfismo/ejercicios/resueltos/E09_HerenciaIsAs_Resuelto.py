"""
OBJETIVO: Lista Animal con Perro/Gato; hacer_sonido; isinstance para leer raza del Perro.
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
    def __init__(self, nombre, raza):
        super().__init__(nombre)
        self.raza = raza

    def hacer_sonido(self):
        return "Guau"


class Gato(Animal):
    def hacer_sonido(self):
        return "Miau"


animales = [Perro("Rex", "Labrador"), Gato("Michi"), Perro("Luna", "Mestizo")]
for a in animales:
    print(a._nombre, a.hacer_sonido())
    if isinstance(a, Perro):
        print("  raza:", a.raza)
