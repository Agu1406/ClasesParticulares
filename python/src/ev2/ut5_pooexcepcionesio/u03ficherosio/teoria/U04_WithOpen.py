"""
U04 — with open (forma segura de abrir ficheros).

OBJETIVO:
  - Usar with open(...) as f: para que el fichero se cierre solo.
  - Equivale a open + close, pero mas seguro si hay un error.
  - Leer y escribir con la misma sintaxis junior.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Escribir con with (modo "w").
"""
print("¡DEMO 1: ESCRIBIR CON with!\n")

with open("with_demo.txt", "w", encoding="utf-8") as fichero:
    fichero.write("Primera\n")
    fichero.write("Segunda\n")
    fichero.write("Tercera\n")
# Aqui el fichero ya esta cerrado automaticamente.

"""
SEGUNDA PARTE — Leer con with (modo "r").
"""
print("¡DEMO 2: LEER CON with!\n")

with open("with_demo.txt", "r", encoding="utf-8") as fichero:
    contenido = fichero.read()
print(contenido)

"""
TERCERA PARTE — Append con with (modo "a").
"""
print("¡DEMO 3: APPEND CON with!\n")

with open("with_demo.txt", "a", encoding="utf-8") as fichero:
    fichero.write("Cuarta (append)\n")

with open("with_demo.txt", "r", encoding="utf-8") as fichero:
    print(fichero.read())

print("Al salir de with, el fichero queda cerrado.")
print("\n¡FIN DEL PROGRAMA!\n")
