"""
Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev

ENUNCIADO
---------
Fuente: Práctica 3 — Tipos de Datos Compuestos (T5-P3)

EJERCICIO 1. Pruebas Básicas con Listas

Crea un programa en el que pruebes las siguientes operaciones con listas.
Comienza creando dos listas: lista1 con los datos 5, 8 y 10; y lista2 con los datos 3, 2, 9, 12 y 4.

1. Usa len() para averiguar la longitud de cada lista.
2. Usa el operador + para concatenarlas, y averigua la longitud del resultado.
3. Encuentra el número mayor de ambas listas. Puedes hacerlo, bien encontrando primero
   el máximo de la lista lista1, después el máximo de la lista lista2 y finalmente el
   máximo de ambos máximos, o bien encontrando el máximo de la concatenación.
   Prueba ambos enfoques.
4. Escribe una expresión que te dé la suma del primer elemento de cada lista (debe sumar
   el 5 con el 3 y producir 8).
5. Escribe una expresión que sume el último elemento de cada lista (10+4). Si no
   conocieses las longitudes de las listas, ¿qué expresión usarías para acceder al último
   elemento? Pruébalo.
6. Escribe una asignación que sustituya el 8 de la lista lista1 por un cero, comprueba que
   el elemento ha cambiado.
7. Ejecuta la asignación "lista3=lista2", e imprime lista3 para comprobar que contiene
   los valores 3,2,9,12 y 4.
8. Modifica lista3, de modo que su primer elemento valga 7. Imprímela para comprobar
   que así es.
9. Imprime ahora lista2. Verás que su primer elemento también ha cambiado. Esto se
   debe a que, a partir de la asignación "lista3=lista2" ambas variables apuntan a la
   misma lista.
10. Añade el número 5 al final de lista1. Imprime la lista para comprobar el resultado.
11. Inserta el número 99 en la posición 1 (entre el primer y segundo elemento) de lista2.
    Imprime la lista para comprobarlo.
12. Elimina el número 9 de lista2 y verifica que ya no está.
13. Elimina el último elemento de lista1. Imprime el valor eliminado y la lista resultante.
14. Utiliza el método index() para encontrar la posición del número 10 en lista1 y el método
    count() para saber cuántas veces aparece el número 5 en esa lista.
15. Crea una sublista que contenga sólo los elementos en posición par (0, 2, 4, ...) de
    lista1.
16. Crea una copia por valor de lista1 llamada copia. Cambia el primer valor de copia y
    demuestra que lista1 no se ha visto afectada. (Usa "copia = list(lista1)")
"""

# ALGORITMO: seguir los 16 puntos del enunciado en orden, imprimiendo cada resultado.

lista1 = [5, 8, 10]
lista2 = [3, 2, 9, 12, 4]

# 1
print("1) longitudes:", len(lista1), len(lista2))

# 2
concatenada = lista1 + lista2
print("2) concatenada:", concatenada, "longitud:", len(concatenada))

# 3
max1 = max(lista1)
max2 = max(lista2)
print("3a) max de maximos:", max(max1, max2))
print("3b) max de concatenacion:", max(concatenada))

# 4
print("4) suma primeros:", lista1[0] + lista2[0])

# 5  ([-1] = ultimo sin saber la longitud)
print("5) suma ultimos:", lista1[-1] + lista2[-1])

# 6
lista1[1] = 0
print("6) lista1 tras cambiar el 8 por 0:", lista1)

# 7
lista3 = lista2
print("7) lista3:", lista3)

# 8
lista3[0] = 7
print("8) lista3 modificada:", lista3)

# 9
print("9) lista2 tambien cambio (mismo objeto):", lista2)

# 10
lista1.append(5)
print("10) lista1 con append(5):", lista1)

# 11
lista2.insert(1, 99)
print("11) lista2 con 99 en posicion 1:", lista2)

# 12
lista2.remove(9)
print("12) lista2 sin el 9:", lista2)

# 13
eliminado = lista1.pop()
print("13) eliminado:", eliminado, "lista1:", lista1)

# 14
print("14) index(10):", lista1.index(10), "count(5):", lista1.count(5))

# 15
posiciones_pares = lista1[0::2]
print("15) posiciones pares:", posiciones_pares)

# 16
copia = list(lista1)
copia[0] = 100
print("16) copia:", copia, "lista1 intacta:", lista1)
