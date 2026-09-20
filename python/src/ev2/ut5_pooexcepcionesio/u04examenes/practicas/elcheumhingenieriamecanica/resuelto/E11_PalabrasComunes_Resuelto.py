"""
Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev

ENUNCIADO
---------
Fuente: examen.txt — Problema 3

NORMAS (examen):
- Incluye el algoritmo lo más detallado posible, además del código.
- Solo estructuras, tipos e instrucciones vistas durante el curso.
- No librerías externas.
- No usar break ni continue.

Problema 3 [1,5 puntos]

Pedir por teclado varias frases (finaliza con una frase vacía). Obtener las palabras que se
repiten en todas las frases.
"""

# ALGORITMO:
# 1. Leer frases hasta que el usuario pulse Intro sin texto (frase vacía).
# 2. Convertir cada frase en un conjunto de palabras (split).
# 3. Intersección de todos los conjuntos = palabras comunes a todas.
# 4. Mostrar el resultado.
# (Sin break/continue: el bucle while controla con una bandera.)

frases = []
seguir = True
while seguir:
    frase = input("Escribe una frase (vacia para terminar): ")
    if frase == "":
        seguir = False
    else:
        frases.append(frase)

if len(frases) == 0:
    print("No se introdujo ninguna frase.")
else:
    comunes = set(frases[0].split())
    i = 1
    while i < len(frases):
        comunes = comunes & set(frases[i].split())
        i = i + 1
    print("Palabras en todas las frases:", sorted(list(comunes)))
