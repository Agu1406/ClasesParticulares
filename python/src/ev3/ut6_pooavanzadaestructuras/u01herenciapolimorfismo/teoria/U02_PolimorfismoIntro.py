"""
U02 — Polimorfismo.

OBJETIVO:
  - Tratar objetos distintos a traves de la misma interfaz (metodo comun).
  - Recorrer una lista de la clase base y llamar al metodo sobrescrito.
  - Usar isinstance para distinguir tipos cuando haga falta.

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


print("\n¡INICIO DEL PROGRAMA!\n")

"""
PRIMERA PARTE — Un Circulo responde a calcular_area.
"""
print("¡DEMO 1: CIRCULO!\n")
c = Circulo(2)
print("Area circulo r=2:", round(c.calcular_area(), 2))

"""
SEGUNDA PARTE — Lista polimorfica: misma llamada, distinto codigo.
"""
print("\n¡DEMO 2: LISTA DE FIGURAS!\n")
figuras = [Circulo(1), Rectangulo(3, 4), Circulo(2.5)]
total = 0.0
for f in figuras:
    area = f.calcular_area()
    print(type(f).__name__, "->", round(area, 2))
    total = total + area
print("Suma areas:", round(total, 2))

"""
TERCERA PARTE — isinstance.
"""
print("\n¡DEMO 3: isinstance!\n")
for f in figuras:
    if isinstance(f, Circulo):
        print("Es circulo de radio", f.radio)
    elif isinstance(f, Rectangulo):
        print("Es rectangulo", f.base, "x", f.altura)

print("\n¡FIN DEL PROGRAMA!")
