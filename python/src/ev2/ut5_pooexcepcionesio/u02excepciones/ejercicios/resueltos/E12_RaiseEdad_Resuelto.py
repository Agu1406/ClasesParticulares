"""
OBJETIVO: Si edad < 0, raise ValueError; capturar e imprimir el mensaje. Prueba -2.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


def validar_edad(edad):
    if edad < 0:
        raise ValueError("La edad no puede ser negativa")
    return edad


try:
    print(validar_edad(-2))
except ValueError as e:
    print(e)
