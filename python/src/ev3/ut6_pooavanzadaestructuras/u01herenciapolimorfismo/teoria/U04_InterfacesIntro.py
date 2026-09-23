"""
U04 — Interfaces (contratos) en Python.

OBJETIVO:
  - Modelar un "contrato" como ABC solo con metodos abstractos.
  - Alternativa moderna: typing.Protocol (duck typing tipado).
  - Varias clases distintas que cumplen el mismo contrato.

En Java/C#: interface IVolable.
En Python junior: ABC o Protocol.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from abc import ABC, abstractmethod


class Volable(ABC):
    @abstractmethod
    def despegar(self):
        pass

    @abstractmethod
    def aterrizar(self):
        pass


class Pajaro(Volable):
    def __init__(self, nombre):
        self.nombre = nombre

    def despegar(self):
        return f"{self.nombre} bate alas"

    def aterrizar(self):
        return f"{self.nombre} se posa"


class Avion(Volable):
    def __init__(self, modelo):
        self.modelo = modelo

    def despegar(self):
        return f"Avion {self.modelo} acelera pista"

    def aterrizar(self):
        return f"Avion {self.modelo} toca tierra"


print("\n¡INICIO DEL PROGRAMA!\n")

"""
PRIMERA PARTE — Un Pajaro cumple Volable.
"""
print("¡DEMO 1: PAJARO!\n")
p = Pajaro("Piolin")
print(p.despegar())
print(p.aterrizar())

"""
SEGUNDA PARTE — Flota heterogenea tipada como Volable.
"""
print("\n¡DEMO 2: FLOTA!\n")
flota = [Pajaro("Eagle"), Avion("A320")]
for v in flota:
    print(v.despegar())
    print(v.aterrizar())

print("\n¡FIN DEL PROGRAMA!")
