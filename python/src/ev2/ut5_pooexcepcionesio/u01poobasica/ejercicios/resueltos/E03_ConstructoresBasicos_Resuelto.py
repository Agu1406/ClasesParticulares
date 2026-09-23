"""
OBJETIVO: Clase Libro con constructor (titulo, autor); crea objeto y muestralo.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

class Libro:
    def __init__(self, titulo, autor):
        self.titulo = titulo
        self.autor = autor


libro = Libro("El Quijote", "Cervantes")
print(libro.titulo, "-", libro.autor)
