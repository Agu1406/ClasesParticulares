"""
OBJETIVO: Lista de Figura con Circulo y Rectangulo; recorrer y sumar areas.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from abc import ABC, abstractmethod
import math


class Figura(ABC):
    @abstractmethod
    def calcular_area(self):
        pass


class Circulo(Figura):
    def __init__(self, radio):
        self.radio = radio

    def calcular_area(self):
        return math.pi * self.radio ** 2


class Rectangulo(Figura):
    def __init__(self, base, altura):
        self.base = base
        self.altura = altura

    def calcular_area(self):
        return self.base * self.altura


figuras = [Circulo(1), Rectangulo(2, 5), Circulo(2)]
total = 0.0
for f in figuras:
    a = f.calcular_area()
    print(type(f).__name__, round(a, 2))
    total = total + a
print("Total:", round(total, 2))
