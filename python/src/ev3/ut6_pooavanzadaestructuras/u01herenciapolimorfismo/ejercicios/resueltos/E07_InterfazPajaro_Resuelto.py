"""
OBJETIVO: Contrato Volable (ABC) con despegar/aterrizar; clase Pajaro que lo implementa.
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
        return f"{self.nombre} despega"

    def aterrizar(self):
        return f"{self.nombre} aterriza"


p = Pajaro("Piolin")
print(p.despegar())
print(p.aterrizar())
