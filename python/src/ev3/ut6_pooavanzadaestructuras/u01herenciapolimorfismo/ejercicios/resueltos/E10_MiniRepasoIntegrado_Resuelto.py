"""
OBJETIVO: Mini-repaso: 3 demos — herencia Animal, figuras polimorficas, flota Volable.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from abc import ABC, abstractmethod
import math


print("DEMO 1 — Herencia")
class Animal:
    def __init__(self, n):
        self._n = n

    def sonido(self):
        return "..."


class Perro(Animal):
    def sonido(self):
        return "Guau"


print(Perro("Rex").sonido())

print("DEMO 2 — Figuras")
class Figura(ABC):
    @abstractmethod
    def area(self):
        pass


class Circulo(Figura):
    def __init__(self, r):
        self.r = r

    def area(self):
        return math.pi * self.r ** 2


print(round(Circulo(2).area(), 2))

print("DEMO 3 — Volable")
class Volable(ABC):
    @abstractmethod
    def despegar(self):
        pass


class Avion(Volable):
    def despegar(self):
        return "Avion despega"


print(Avion().despegar())
