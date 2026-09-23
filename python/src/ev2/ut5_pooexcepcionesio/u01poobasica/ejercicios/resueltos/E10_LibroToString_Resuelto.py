"""
OBJETIVO: Clase Libro con __str__; muestra datos formateados.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

class Libro:
    def __init__(self, titulo, autor, anio):
        self.titulo = titulo
        self.autor = autor
        self.anio = anio

    def __str__(self):
        return f'"{self.titulo}" de {self.autor} ({self.anio})'


print(Libro("Dune", "Herbert", 1965))
