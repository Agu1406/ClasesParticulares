"""
OBJETIVO: Clase Alumno con @property nombre y nota; crea objeto y muestralo.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

class Alumno:
    def __init__(self, nombre, nota):
        self._nombre = nombre
        self._nota = nota

    @property
    def nombre(self):
        return self._nombre

    @property
    def nota(self):
        return self._nota


a = Alumno("Luis", 7.5)
print(a.nombre, a.nota)
