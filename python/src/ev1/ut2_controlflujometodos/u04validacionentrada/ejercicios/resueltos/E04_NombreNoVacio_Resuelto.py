"""
OBJETIVO: Validar nombre con strip; secuencia ['  ', 'Ana'].
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

nombres = ["  ", "Ana"]
i = 0
ok = False
nombre = ""
while not ok:
    t = nombres[i]
    i = i + 1
    if t.strip() != "":
        nombre = t.strip()
        ok = True
    else:
        print("Nombre vacio")
print("Hola,", nombre)
