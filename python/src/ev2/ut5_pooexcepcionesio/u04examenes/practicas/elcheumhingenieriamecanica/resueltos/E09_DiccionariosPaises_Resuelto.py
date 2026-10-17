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
# 1. Crear diccionario vacío.
# 2. Con for i in range(3): pedir pais y capital; guardarlos.
# 3. Mostrar el diccionario.
# 4. Con bucles for: listas de paises, capitales y tuplas (pais, capital).
# 5. Pedir un pais y mostrar capitales.get(..., "País no encontrado").

capitales = {}

for i in range(3):
    pais = input(f"Pais {i + 1}: ")
    capital = input(f"Capital {i + 1}: ")
    capitales[pais] = capital

print("Diccionario:", capitales)

paises = []
for pais in capitales:
    paises.append(pais)
print("Paises:", paises)

lista_capitales = []
for pais in capitales:
    lista_capitales.append(capitales[pais])
print("Capitales:", lista_capitales)

tuplas = []
for pais in capitales:
    tuplas.append((pais, capitales[pais]))
print("Tuplas (pais, capital):", tuplas)

consulta = input("Consulta la capital de un pais: ")
print(capitales.get(consulta, "País no encontrado"))
