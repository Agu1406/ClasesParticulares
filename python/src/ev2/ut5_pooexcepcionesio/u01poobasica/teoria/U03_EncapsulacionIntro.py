"""
U03 — Encapsulacion basica.

OBJETIVO:
  - Ocultar datos internos con convencion _atributo (uso privado).
  - Exponer acceso controlado con metodos get / set o @property.
  - Validar en el setter (por ejemplo, saldo no negativo).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


class Cuenta:
    def __init__(self):
        self._saldo = 0.0

    def get_saldo(self):
        return self._saldo

    def set_saldo(self, valor):
        if valor >= 0:
            self._saldo = valor


print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Deposito valido mediante setter.
"""
print("¡DEMO 1: SALDO INICIAL!\n")
cuenta = Cuenta()
cuenta.set_saldo(100)
print("Saldo:", cuenta.get_saldo())

"""
SEGUNDA PARTE — Intento de saldo negativo (rechazado).
"""
print("\n¡DEMO 2: SALDO NEGATIVO RECHAZADO!\n")
cuenta.set_saldo(-50)
print("Saldo tras intento invalido:", cuenta.get_saldo())

print("\n¡FIN DEL PROGRAMA!\n")
