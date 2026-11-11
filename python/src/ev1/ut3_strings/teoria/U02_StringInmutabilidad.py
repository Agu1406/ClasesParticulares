"""
U02 — Inmutabilidad de str (paridad Java U01_StringInmutabilidad).

OBJETIVO:
  - Entender que str no se modifica "in situ": cada operacion crea otra cadena.
  - Ver el error tipico: llamar a un metodo y no guardar el resultado.
  - Contrastar reasignacion (s = s + "...") con olvidar asignar.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")

"""
PRIMERA PARTE — + y metodos no cambian el original si no reasignas.
"""
print("¡DEMO 1: ORIGINAL INTACTO!\n")
original = "Hola"
mas = original + " mundo"
mayus = original.upper()
print("original:", original)
print("con +:", mas)
print("upper() resultado:", mayus)
print("original sigue igual:", original)

"""
SEGUNDA PARTE — Error tipico: olvidar asignar (como concat sin guardar en Java).
"""
print("\n¡DEMO 2: OLVIDAR ASIGNAR!\n")
nombre = "Agustin"
nombre.upper()  # se crea otra cadena... y se pierde
print("Tras upper() sin asignar:", nombre)
nombre = nombre.upper()
print("Tras nombre = nombre.upper():", nombre)

"""
TERCERA PARTE — += tambien crea una cadena nueva (reasigna la variable).
"""
print("\n¡DEMO 3: += REASIGNA!\n")
texto = "Daniel"
print("id antes:", id(texto))
texto += " Masso"
print("tras +=:", texto)
print("id despues (otro objeto):", id(texto))

print("\n¡FIN DEL PROGRAMA!\n")
