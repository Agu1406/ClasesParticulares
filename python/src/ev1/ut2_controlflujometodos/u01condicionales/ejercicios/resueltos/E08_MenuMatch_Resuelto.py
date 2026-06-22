"""
OBJETIVO: Menu texto: "1" Hola, "2" Adios, "0" Fin, otro caso invalido (match/case).
TIPO: match / case.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
"""

op = input("Opcion (1/2/0): ")
match op:
    case "1":
        print("Hola")
    case "2":
        print("Adios")
    case "0":
        print("Fin")
    case _:
        print("Opcion invalida")
