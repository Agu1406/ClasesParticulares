"""
U01 — Introduccion a la herencia.

OBJETIVO:
  - Definir una subclase con class Hija(Padre).
  - Llamar al constructor del padre con super().__init__(...).
  - Sobrescribir metodos (mismo nombre en la hija).
  - Usar _nombre como "protegido" por convencion.

En Java/C#: extends / :  y  super() / base().
En Python: class Perro(Animal) y super().__init__(...).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


class Animal:
    def __init__(self, nombre):
        self._nombre = nombre

    def hacer_sonido(self):
        return "..."

    def __str__(self):
        return f"Animal({self._nombre})"


class Perro(Animal):
    def __init__(self, nombre, raza):
        super().__init__(nombre)
        self._raza = raza

    def hacer_sonido(self):
        return "Guau"

    def __str__(self):
        return f"Perro({self._nombre}, {self._raza})"


class Gato(Animal):
    def __init__(self, nombre):
        super().__init__(nombre)

    def hacer_sonido(self):
        return "Miau"

    def __str__(self):
        return f"Gato({self._nombre})"


print("\n¡INICIO DEL PROGRAMA!\n")

"""
PRIMERA PARTE — Jerarquia: Animal, Perro, Gato.
"""
print("¡DEMO 1: CREAR JERARQUIA!\n")
generico = Animal("Criatura")
perro = Perro("Rex", "Pastor aleman")
gato = Gato("Michi")
print(generico)
print(perro)
print(gato)

"""
SEGUNDA PARTE — Override: cada uno hace su sonido.
"""
print("\n¡DEMO 2: SONIDOS!\n")
print(generico.hacer_sonido())
print(perro.hacer_sonido())
print(gato.hacer_sonido())

"""
TERCERA PARTE — Upcasting: variable tipada como Animal que apunta a Perro.
"""
print("\n¡DEMO 3: REFERENCIA DE LA BASE!\n")
ref = Perro("Luna", "Mestizo")
animal_ref = ref  # en Python no hace falta cast
print(type(animal_ref).__name__, animal_ref.hacer_sonido())

print("\n¡FIN DEL PROGRAMA!")
