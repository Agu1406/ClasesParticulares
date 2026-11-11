"""
OBJETIVO: Con lista simulada ['x', '7'], repetir while not valido hasta obtener entero.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

def es_entero(texto):
    return texto.strip().isdigit()


entradas = ["x", "7"]
i = 0
valido = False
numero = 0
while not valido:
    t = entradas[i]
    i = i + 1
    if es_entero(t):
        numero = int(t.strip())
        valido = True
    else:
        print("Rechazado:", t)
print("Numero:", numero)
