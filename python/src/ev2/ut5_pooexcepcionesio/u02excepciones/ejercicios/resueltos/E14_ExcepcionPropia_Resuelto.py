"""
OBJETIVO: Define SaldoInsuficienteError; al restar mas del saldo, raise y captura.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


class SaldoInsuficienteError(Exception):
    pass


def retirar(saldo, cantidad):
    if cantidad > saldo:
        raise SaldoInsuficienteError("Saldo insuficiente")
    return saldo - cantidad


try:
    print(retirar(50, 80))
except SaldoInsuficienteError as e:
    print(e)

print("Tras retirada valida:", retirar(50, 20))
