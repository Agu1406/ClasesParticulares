"""
U01 — Cadenas str: creacion, indexacion y rebanado.

OBJETIVO:
  - str es inmutable (cada cambio crea una nueva cadena).
  - Indexacion desde 0; indices negativos cuentan desde el final.
  - Rebanado [inicio:fin:paso] como en listas.
  - len(), in, concatenacion con +

Paridad Java UT3 String (conceptos basicos).

Autor: Agustin. A. Marquez. Pina
"""

texto = "  Hola, FP Python  "
# repr(): devuelve la representacion oficial del texto (muestra espacios)
print("repr:", repr(texto))

# strip(): quita espacios al inicio y al final de la cadena
limpio = texto.strip()
# print(): muestra el texto ya sin espacios extra
print("strip:", limpio)
# len(): devuelve el numero de caracteres de limpio
print("longitud:", len(limpio))

# print(): acceso al primer caracter con indice [0]
print("primer caracter:", limpio[0])
# print(): rebanado [-6:] toma los ultimos 6 caracteres
print("ultimos 6:", limpio[-6:])

# print(): rebanado [7:9] toma caracteres en posiciones 7 y 8
print("subcadena [7:9]:", limpio[7:9])

saludo = "Hola" + " " + "mundo"
# print(): muestra la cadena concatenada con +
print(saludo)
# print(): repite "Ha" tres veces con el operador *
print("Ha" * 3)

# print(): compara cadenas lexicograficamente con <
print("'abc' < 'abd':", "abc" < "abd")

# for letra in "Python": recorre cada caracter de la cadena
for letra in "Python":
    # print(): muestra cada letra en la misma linea
    print(letra, end=" ")
# print(): salto de linea al acabar el bucle
print()
