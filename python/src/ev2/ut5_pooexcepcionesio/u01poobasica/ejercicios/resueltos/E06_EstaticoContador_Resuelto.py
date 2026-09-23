"""
OBJETIVO: Clase Contador con atributo de clase; incrementa 3 veces y muestra valor total.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

class Contador:
    valor = 0

    @classmethod
    def incrementar(cls):
        cls.valor = cls.valor + 1


Contador.valor = 0
Contador.incrementar()
Contador.incrementar()
Contador.incrementar()
print(Contador.valor)
