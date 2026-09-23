"""
OBJETIVO: Clase CuentaBancaria con saldo privado; depositar y retirar; prueba operaciones.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

class CuentaBancaria:
    def __init__(self, saldo_inicial):
        self._saldo = saldo_inicial

    def depositar(self, cantidad):
        if cantidad > 0:
            self._saldo = self._saldo + cantidad

    def retirar(self, cantidad):
        if 0 < cantidad <= self._saldo:
            self._saldo = self._saldo - cantidad
            return True
        return False

    def saldo(self):
        return self._saldo


cuenta = CuentaBancaria(100)
cuenta.depositar(50)
cuenta.retirar(30)
print("Saldo:", cuenta.saldo(), "EUR")
