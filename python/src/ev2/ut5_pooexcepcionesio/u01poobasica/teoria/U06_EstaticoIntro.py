"""
U06 — Atributos y metodos de clase / estaticos.

OBJETIVO:
  - Atributo de clase compartido por todas las instancias.
  - @staticmethod: funcion ligada a la clase sin self.
  - @classmethod: recibe cls; util para contadores o fabricas.

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

    @classmethod
    def reiniciar(cls):
        cls.valor = 0

    @staticmethod
    def descripcion():
        return "Contador compartido a nivel de clase"


class Producto:
    iva = 0.21

    def __init__(self, nombre, precio):
        self.nombre = nombre
        self.precio = precio

    def precio_con_iva(self):
        return self.precio * (1 + Producto.iva)


print("\n¡INICIO DEL PROGRAMA!\n")

print("¡DEMO 1: CONTADOR DE CLASE!\n")
Contador.reiniciar()
print("Inicial:", Contador.valor)
Contador.incrementar()
Contador.incrementar()
Contador.incrementar()
print("Tras 3 incrementos:", Contador.valor)
print(Contador.descripcion())

print("\n¡DEMO 2: IVA COMPARTIDO!\n")
p1 = Producto("Pan", 1.0)
p2 = Producto("Leche", 1.2)
print(p1.nombre, round(p1.precio_con_iva(), 2))
print(p2.nombre, round(p2.precio_con_iva(), 2))

print("\n¡FIN DEL PROGRAMA!\n")
