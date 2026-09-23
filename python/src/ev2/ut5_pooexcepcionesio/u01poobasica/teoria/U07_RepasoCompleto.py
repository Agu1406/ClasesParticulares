"""
U07 — Repaso POO basica (UT5 u01).

OBJETIVO:
  - Integrar clase, constructor, metodos, encapsulacion y atributo de clase.
  - Servir de mapa mental antes de los ejercicios E01-E10.

Mapa:
  U01 clases/objetos · U02 constructores · U03 encapsulacion
  U04 metodos · U05 @property · U06 estatico/clase

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


class Libro:
    prestamos_totales = 0

    def __init__(self, titulo, autor):
        self._titulo = titulo
        self._autor = autor
        self._prestado = False

    @property
    def titulo(self):
        return self._titulo

    def prestar(self):
        if not self._prestado:
            self._prestado = True
            Libro.prestamos_totales = Libro.prestamos_totales + 1
            return True
        return False

    def __str__(self):
        estado = "prestado" if self._prestado else "disponible"
        return f"{self._titulo} — {self._autor} ({estado})"


print("\n¡INICIO DEL PROGRAMA!\n")

b1 = Libro("1984", "Orwell")
b2 = Libro("Dune", "Herbert")
print(b1)
print(b2)
b1.prestar()
print("Tras prestar b1:", b1)
print("Prestamos totales:", Libro.prestamos_totales)

print("\n¡FIN DEL PROGRAMA!\n")
