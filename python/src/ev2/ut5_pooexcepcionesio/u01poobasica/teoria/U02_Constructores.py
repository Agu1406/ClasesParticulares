"""
U02 — Constructores con __init__.

OBJETIVO:
  - __init__ se ejecuta al crear el objeto con Libro(...).
  - Inicializar atributos desde el principio, sin asignar uno a uno despues.
  - self representa la instancia que se esta creando.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


class Libro:
    def __init__(self, titulo, autor):
        self.titulo = titulo
        self.autor = autor


print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Constructor con dos parametros.
"""
print("¡DEMO 1: LIBRO INICIALIZADO!\n")
libro1 = Libro("Clean Code", "Robert C. Martin")
print(libro1.titulo, "-", libro1.autor)

"""
SEGUNDA PARTE — Segunda instancia con otros datos.
"""
print("\n¡DEMO 2: OTRO LIBRO!\n")
libro2 = Libro("Python crash course", "Eric Matthes")
print(libro2.titulo, "-", libro2.autor)

"""
TERCERA PARTE — Cambiar atributos tras la construccion.
"""
print("\n¡DEMO 3: CAMBIOS TRAS __init__!\n")
libro1.titulo = "Clean Code (2a ed.)"
print(libro1.titulo, "-", libro1.autor)

print("\n¡FIN DEL PROGRAMA!\n")
