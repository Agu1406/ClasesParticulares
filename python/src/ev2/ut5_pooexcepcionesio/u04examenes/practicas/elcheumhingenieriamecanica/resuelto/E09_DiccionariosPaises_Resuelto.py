"""
Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev

ENUNCIADO
---------
Fuente: Práctica 3 — Tipos de Datos Compuestos (T5-P3)

EJERCICIO 3. Diccionarios

Crea un programa que:
1. Solicite por teclado los nombres de tres países y sus capitales.
2. Guarde esa información en un diccionario utilizando el país como clave.
3. Muestre el diccionario por pantalla.
4. Extraiga del diccionario e imprima en pantalla lo siguiente:
   - Países almacenados
   - Capitales almacenadas
   - Lista de tuplas (país, capital) con toda la información almacenada en el diccionario
5. Pida por teclado el nombre de un país e imprima su capital utilizando .get(). Si el
   usuario teclea un país que no existe, se le mostrará el mensaje "País no encontrado".
"""

# ALGORITMO:
# 1. Pedir 3 pares pais/capital e ir metiéndolos en el diccionario.
# 2. Mostrar dict, keys, values e items.
# 3. Consultar un país con .get(pais, "País no encontrado").

capitales = {}

pais1 = input("Pais 1: ")
capital1 = input("Capital 1: ")
capitales[pais1] = capital1

pais2 = input("Pais 2: ")
capital2 = input("Capital 2: ")
capitales[pais2] = capital2

pais3 = input("Pais 3: ")
capital3 = input("Capital 3: ")
capitales[pais3] = capital3

print("Diccionario:", capitales)
print("Paises:", list(capitales.keys()))
print("Capitales:", list(capitales.values()))
print("Tuplas (pais, capital):", list(capitales.items()))

consulta = input("Consulta la capital de un pais: ")
print(capitales.get(consulta, "País no encontrado"))
