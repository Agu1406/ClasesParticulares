"""
Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev

ENUNCIADO
---------
Fuente: Práctica 3 — Tipos de Datos Compuestos (T5-P3)

EJERCICIO 2. Listas y Conjuntos

Si a partir de una lista de elementos que contiene valores repetidos, queremos obtener otra
lista en la que sólo aparezcan valores únicos (es decir, eliminar elementos repetidos), un truco
que puede usarse es aprovechar una característica fundamental de los conjuntos de Python,
pues estos no contienen valores repetidos.

Crea un programa que comience con una lista:
valores = [4, 6, 2, 4, 9, 6, 2, 1, 10, 2, 6, 8]

Convierte la lista a un conjunto, el cual volverás a transformar en una lista llamada sin_repetir
y ordénala de menor a mayor con la función sorted(). Obtendrás algo como:
sin_repetir: [1, 2, 4, 6, 8, 9, 10]

Crea los conjuntos de números:
- conjunto1 = {1,2,3,4,5,6}
- conjunto2 = {4,5,6,7,8,9}

Utilizando las operaciones de conjuntos, calcula e imprime en pantalla:
- Números que están en los dos conjuntos
- Números que solo están en un conjunto
- Números que solo están en el conjunto1

Pide por teclado 3 números, añádelos a un nuevo conjunto y muestra en pantalla si:
- Los 3 números están todos en alguno de los dos conjuntos.
- Los 3 números están en alguno de los dos conjuntos.
- Alguno de los números está en el conjunto1.
- Ninguno de los números está en conjunto1 ni en conjunto2.
"""

# ALGORITMO:
# 1. valores -> set -> lista ordenada sin_repetir.
# 2. Operaciones & ^ - entre conjunto1 y conjunto2.
# 3. Leer 3 números, formar conjunto nuevo y comprobar inclusiones.

valores = [4, 6, 2, 4, 9, 6, 2, 1, 10, 2, 6, 8]
sin_repetir = sorted(list(set(valores)))
print("sin_repetir:", sin_repetir)

conjunto1 = {1, 2, 3, 4, 5, 6}
conjunto2 = {4, 5, 6, 7, 8, 9}

print("En los dos conjuntos:", conjunto1 & conjunto2)
print("Solo en un conjunto:", conjunto1 ^ conjunto2)
print("Solo en conjunto1:", conjunto1 - conjunto2)

n1 = int(input("Numero 1: "))
n2 = int(input("Numero 2: "))
n3 = int(input("Numero 3: "))
nuevo = {n1, n2, n3}

union = conjunto1 | conjunto2
print("Todos en alguno de los dos (issubset de uno):", nuevo.issubset(conjunto1) or nuevo.issubset(conjunto2))
print("Estan (algunos/todos) en la union:", len(nuevo & union) > 0)
print("Alguno en conjunto1:", len(nuevo & conjunto1) > 0)
print("Ninguno en conjunto1 ni conjunto2:", len(nuevo & union) == 0)
