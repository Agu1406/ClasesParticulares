"""
Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev

ENUNCIADO
---------
Fuente: Práctica 2 — Entrada y Salida (T5-P2)

EJERCICIO 4. LECTURA DE FICHEROS

Escribe un programa que abra el fichero "frases.txt" que has creado en el ejercicio anterior, lea
todo su contenido y muestre en pantalla cuántos caracteres contiene en total (incluyendo
espacios y saltos de línea). ¿Los caracteres de salto de línea han sido contabilizados?

A continuación, añade al programa el código necesario para leer las tres frases del fichero e
imprimirlas por pantalla en tres líneas consecutivas. ¿Las frases se imprimen como esperabas o
se deja una línea vacía entre ellas? ¿A qué crees que se debe ese efecto y cómo modificarías el
código para solucionarlo?
"""

# ALGORITMO:
# 1. Abrir frases.txt y leer TODO el contenido a una cadena.
# 2. Mostrar len(contenido). Sí: los "\n" cuentan como caracteres.
# 3. Separar por "\n" y mostrar cada frase.
# 4. Si usas print(linea) y la linea aún trae "\n", sale una línea vacía extra:
#    solución -> usar strip() o split y saltar cadenas vacías.

fichero = open("frases.txt", "r", encoding="utf-8")
contenido = fichero.read()
fichero.close()

print("Caracteres totales:", len(contenido))
print("Sí: los saltos de línea '\\n' también se contabilizan en len().")

# Opción incorrecta típica (deja líneas en blanco si print añade otro salto):
# for linea in contenido.split("\n"):
#     print(linea)

# Opción correcta: filtrar vacíos (o usar strip en cada línea)
lineas = contenido.split("\n")
for linea in lineas:
    if linea != "":
        print(linea)
