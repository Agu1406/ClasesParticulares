"""
U04 — Metodos de instancia.

OBJETIVO:
  - Definir comportamiento dentro de la clase (calcular_area, mostrar, etc.).
  - self como primer parametro: el objeto que recibe la llamada.
  - Llamar metodos con objeto.metodo().

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


class Rectangulo:
    def __init__(self, base, altura):
        self.base = base
        self.altura = altura

    def calcular_area(self):
        return self.base * self.altura

    def calcular_perimetro(self):
        return 2 * (self.base + self.altura)

    def describir(self):
        return f"Rectangulo {self.base}x{self.altura}"


print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Metodo que devuelve un calculo.
"""
print("¡DEMO 1: AREA!\n")
r = Rectangulo(4, 5)
print("Area:", r.calcular_area())

"""
SEGUNDA PARTE — Otro metodo sobre el mismo objeto.
"""
print("\n¡DEMO 2: PERIMETRO Y DESCRIPCION!\n")
print("Perimetro:", r.calcular_perimetro())
print(r.describir())

print("\n¡FIN DEL PROGRAMA!\n")
