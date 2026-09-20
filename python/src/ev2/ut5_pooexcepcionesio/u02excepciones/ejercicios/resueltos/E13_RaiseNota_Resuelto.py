"""
OBJETIVO: Funcion que valida nota 0-10 con raise ValueError; prueba 11 y 7.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


def validar_nota(nota):
    if nota < 0 or nota > 10:
        raise ValueError("La nota debe estar entre 0 y 10")
    return nota


for n in (11, 7):
    try:
        print("OK:", validar_nota(n))
    except ValueError as e:
        print("Error:", e)
