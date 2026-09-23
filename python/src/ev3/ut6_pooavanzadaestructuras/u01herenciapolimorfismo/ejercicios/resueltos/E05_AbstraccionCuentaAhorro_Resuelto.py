"""
OBJETIVO: ABC Cuenta con depositar concreto y retirar abstracto; CuentaAhorro implementa retirar.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from abc import ABC, abstractmethod


class Cuenta(ABC):
    def __init__(self, titular, saldo=0.0):
        self._titular = titular
        self._saldo = saldo

    def depositar(self, cantidad):
        if cantidad > 0:
            self._saldo = self._saldo + cantidad

    @abstractmethod
    def retirar(self, cantidad):
        pass


class CuentaAhorro(Cuenta):
    def retirar(self, cantidad):
        if 0 < cantidad <= self._saldo:
            self._saldo = self._saldo - cantidad
            return True
        return False


c = CuentaAhorro("Ana", 100)
c.depositar(20)
print("Retiro 50?", c.retirar(50), "saldo", c._saldo)
