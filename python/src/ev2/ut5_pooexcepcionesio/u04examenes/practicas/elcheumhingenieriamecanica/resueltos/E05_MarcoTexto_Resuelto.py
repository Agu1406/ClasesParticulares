"""
Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev

ENUNCIADO
---------
Fuente: Práctica 2 — Entrada y Salida (T5-P2)

EJERCICIO 5. MARCO DE TEXTO

Escribe un programa que abra un fichero "linea.txt", que puedes crear manualmente y cuyo
contenido es una frase cualquiera, y genere otro fichero "marco.txt" donde se haya creado un
marco alrededor de la frase usando asteriscos.

Por ejemplo, si el fichero "linea.txt" contiene una frase, el resultado esperado en "marco.txt"
sería un rectángulo de asteriscos con la frase en el centro (ver imagen en el PDF original
elche-umh-t5-p2-entrada-salida.pdf).

El marco debe adaptarse a cualquier frase del fichero inicial, es decir, la cantidad de asteriscos
a mostrar debe generarse teniendo en cuenta la longitud de la frase.
"""

# ALGORITMO:
# 1. Leer linea.txt y quitar el salto de línea con strip().
# 2. Calcular el borde: "*" * (len(frase) + 4)  ->  "* " + frase + " *"
# 3. Escribir en marco.txt: borde, línea interior, borde.
# 4. (Opcional) mostrar marco.txt por pantalla.

# Si no existe linea.txt, el alumno lo crea a mano; aquí pedimos la frase y lo generamos.
frase_usuario = input("Escribe la frase para linea.txt: ")
fichero = open("linea.txt", "w", encoding="utf-8")
fichero.write(frase_usuario + "\n")
fichero.close()

fichero = open("linea.txt", "r", encoding="utf-8")
frase = fichero.read().strip()
fichero.close()

borde = "*" * (len(frase) + 4)
interior = "* " + frase + " *"

fichero = open("marco.txt", "w", encoding="utf-8")
fichero.write(borde + "\n")
fichero.write(interior + "\n")
fichero.write(borde + "\n")
fichero.close()

fichero = open("marco.txt", "r", encoding="utf-8")
print(fichero.read())
fichero.close()
