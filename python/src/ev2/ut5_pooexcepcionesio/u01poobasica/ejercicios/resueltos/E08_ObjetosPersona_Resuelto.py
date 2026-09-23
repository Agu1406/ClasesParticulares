"""
OBJETIVO: Clase Persona con nombre y edad; crea dos personas y muestralas.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

class Persona:
    def __init__(self, nombre, edad):
        self.nombre = nombre
        self.edad = edad

    def mostrar(self):
        print(self.nombre, self.edad)


Persona("Ana", 20).mostrar()
Persona("Luis", 25).mostrar()
