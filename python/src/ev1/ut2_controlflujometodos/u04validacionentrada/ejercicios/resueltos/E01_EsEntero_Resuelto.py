"""
OBJETIVO: Funcion es_entero(texto) con isdigit; prueba '18' y 'hola'.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

def es_entero(texto):
    return texto.isdigit()


print(es_entero("18"))
print(es_entero("hola"))
if es_entero("18"):
    print("Edad:", int("18"))
else:
    print("No valido")
