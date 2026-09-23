"""
OBJETIVO: Segunda implementacion Avion de Volable; lista con Pajaro y Avion.
SOLUCION: ver codigo.

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
        return f"Pajaro {self.nombre} despega"

    def aterrizar(self):
        return f"Pajaro {self.nombre} aterriza"


class Avion(Volable):
    def __init__(self, modelo):
        self.modelo = modelo

    def despegar(self):
        return f"Avion {self.modelo} despega"

    def aterrizar(self):
        return f"Avion {self.modelo} aterriza"


flota = [Pajaro("Eagle"), Avion("A320")]
for v in flota:
    print(v.despegar())
    print(v.aterrizar())
