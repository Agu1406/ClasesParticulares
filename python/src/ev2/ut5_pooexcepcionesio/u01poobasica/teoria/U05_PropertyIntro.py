"""
U05 — Propiedades (@property).

OBJETIVO:
  - Exponer atributos controlados con @property (lectura).
  - Validar en el setter (@atributo.setter).
  - Preferir property frente a get_/set_ cuando el acceso sea natural.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


class Alumno:
    def __init__(self, nombre, nota):
        self._nombre = nombre
        self.nota = nota  # pasa por el setter

    @property
    def nombre(self):
        return self._nombre

    @property
    def nota(self):
        return self._nota

    @nota.setter
    def nota(self, valor):
        if 0 <= valor <= 10:
            self._nota = valor
        else:
            print("Nota fuera de rango; se ignora.")


print("\n¡INICIO DEL PROGRAMA!\n")

print("¡DEMO 1: LECTURA CON PROPERTY!\n")
a = Alumno("Elena", 8.5)
print(a.nombre, a.nota)

print("\n¡DEMO 2: SETTER CON VALIDACION!\n")
a.nota = 9.0
print("Tras subir nota:", a.nota)
a.nota = 15
print("Tras intento invalido:", a.nota)

print("\n¡FIN DEL PROGRAMA!\n")
