"""
U03 — Abstraccion con ABC.

OBJETIVO:
  - Declarar una clase abstracta con abc.ABC.
  - Obligar a las hijas a implementar metodos con @abstractmethod.
  - Mezclar metodos concretos (compartidos) y abstractos (propios de cada hija).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from abc import ABC, abstractmethod


class Cuenta(ABC):
    def __init__(self, titular, saldo_inicial=0.0):
        self._titular = titular
        self._saldo = saldo_inicial

    def depositar(self, cantidad):
        if cantidad > 0:
            self._saldo = self._saldo + cantidad

    @abstractmethod
    def retirar(self, cantidad):
        pass

    def saldo(self):
        return self._saldo


class CuentaAhorro(Cuenta):
    def retirar(self, cantidad):
        if cantidad > 0 and cantidad <= self._saldo:
            self._saldo = self._saldo - cantidad
            return True
        return False


class CuentaCredito(Cuenta):
    def __init__(self, titular, saldo_inicial=0.0, descubierto=100.0):
        super().__init__(titular, saldo_inicial)
        self._descubierto = descubierto

    def retirar(self, cantidad):
        if cantidad > 0 and self._saldo - cantidad >= -self._descubierto:
            self._saldo = self._saldo - cantidad
            return True
        return False


print("\n¡INICIO DEL PROGRAMA!\n")

print("¡DEMO: AHORRO VS CREDITO!\n")
ahorro = CuentaAhorro("Ana", 50)
credito = CuentaCredito("Luis", 50, descubierto=100)

print("Retirar 80 de ahorro?", ahorro.retirar(80), "saldo", ahorro.saldo())
print("Retirar 80 de credito?", credito.retirar(80), "saldo", credito.saldo())

ahorro.depositar(100)
print("Tras depositar 100 en ahorro:", ahorro.saldo())

print("\n¡FIN DEL PROGRAMA!")
