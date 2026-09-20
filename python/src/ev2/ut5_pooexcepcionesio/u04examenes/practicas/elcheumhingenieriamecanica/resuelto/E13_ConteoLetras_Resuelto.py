"""
Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev

ENUNCIADO
---------
Fuente: examen.txt — Problema 5

NORMAS (examen):
- Incluye el algoritmo lo más detallado posible, además del código.
- Solo estructuras, tipos e instrucciones vistas durante el curso.
- No librerías externas.
- No usar break ni continue.

Problema 5 [1,5 puntos]

Escribe un programa que lea una frase y genere un diccionario llamado "palabras" con las
veces que aparece cada letra en la frase.
"""

# ALGORITMO:
# 1. Leer la frase.
# 2. Crear diccionario vacío "palabras".
# 3. Recorrer cada carácter:
#      si es letra (no espacio), sumar 1 en el diccionario.
# 4. Mostrar el diccionario.
# Nota: el enunciado llama "palabras" al diccionario, aunque cuenta letras.

frase = input("Escribe una frase: ")
palabras = {}

for caracter in frase:
    if caracter != " ":
        if caracter in palabras:
            palabras[caracter] = palabras[caracter] + 1
        else:
            palabras[caracter] = 1

print(palabras)
