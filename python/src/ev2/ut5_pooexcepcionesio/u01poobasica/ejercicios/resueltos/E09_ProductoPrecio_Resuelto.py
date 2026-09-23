"""
OBJETIVO: Clase Producto con nombre y precio; calcula precio con IVA (21%).
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

class Producto:
    IVA = 0.21

    def __init__(self, nombre, precio):
        self.nombre = nombre
        self.precio = precio

    def precio_con_iva(self):
        return self.precio * (1 + Producto.IVA)


p = Producto("Teclado", 20)
print(p.nombre, round(p.precio_con_iva(), 2))
