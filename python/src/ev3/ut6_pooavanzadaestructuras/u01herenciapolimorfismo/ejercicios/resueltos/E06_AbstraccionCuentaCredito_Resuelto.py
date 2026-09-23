"""
OBJETIVO: Anadir CuentaCredito (descubierto) y comparar retirar con CuentaAhorro.
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

    @abstractmethod
    def retirar(self, cantidad):
        pass


class CuentaAhorro(Cuenta):
    def retirar(self, cantidad):
        if 0 < cantidad <= self._saldo:
            self._saldo = self._saldo - cantidad
            return True
        return False


class CuentaCredito(Cuenta):
    def __init__(self, titular, saldo=0.0, descubierto=100.0):
        super().__init__(titular, saldo)
        self._descubierto = descubierto

    def retirar(self, cantidad):
        if cantidad > 0 and self._saldo - cantidad >= -self._descubierto:
            self._saldo = self._saldo - cantidad
            return True
        return False


cuentas = [CuentaAhorro("Ana", 50), CuentaCredito("Luis", 50, 100)]
for c in cuentas:
    ok = c.retirar(100)
    print(type(c).__name__, "ok?", ok, "saldo", c._saldo)
