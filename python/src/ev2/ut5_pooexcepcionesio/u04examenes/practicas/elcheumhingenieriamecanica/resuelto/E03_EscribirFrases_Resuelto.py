"""
Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev

ENUNCIADO
---------
Fuente: Práctica 2 — Entrada y Salida (T5-P2)

EJERCICIO 3. ESCRITURA EN FICHEROS

Escribe un programa que solicite al usuario que introduzca tres frases distintas por teclado.
Cada frase debe guardarse en una línea diferente dentro de un fichero llamado "frases.txt".
Para que cada frase se corresponda con una línea del fichero, debes añadir al final el carácter
"\\n", que introduce un salto de línea. Al terminar, cierra correctamente el fichero.
"""

# ALGORITMO:
# 1. Pedir tres frases por teclado.
# 2. Abrir frases.txt en modo escritura.
# 3. Escribir cada frase seguida de "\n".
# 4. Cerrar el fichero.

frase1 = input("Frase 1: ")
frase2 = input("Frase 2: ")
frase3 = input("Frase 3: ")

fichero = open("frases.txt", "w", encoding="utf-8")
fichero.write(frase1 + "\n")
fichero.write(frase2 + "\n")
fichero.write(frase3 + "\n")
fichero.close()

print("Fichero frases.txt guardado correctamente.")
