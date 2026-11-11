"""
OBJETIVO: Integrado: nombre no vacio + edad 0..120 (datos simulados).
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

nombres = ["", "Eva"]
i = 0
nombre = ""
while nombre == "":
    t = nombres[i].strip()
    i = i + 1
    if t != "":
        nombre = t
    else:
        print("Nombre vacio")

edades = ["999", "19"]
j = 0
edad = -1
ok = False
while not ok:
    t = edades[j]
    j = j + 1
    if t.isdigit():
        edad = int(t)
        if 0 <= edad <= 120:
            ok = True
        else:
            print("Edad fuera de rango")
    else:
        print("Edad no entera")

print(nombre, "tiene", edad, "anios")
