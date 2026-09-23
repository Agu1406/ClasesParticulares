"""
OBJETIVO: Cuenta letras de una frase en un diccionario (ignora espacios).
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

frase = "hola hola"
conteo = {}
for c in frase:
    if c != " ":
        if c in conteo:
            conteo[c] = conteo[c] + 1
        else:
            conteo[c] = 1
print(conteo)
