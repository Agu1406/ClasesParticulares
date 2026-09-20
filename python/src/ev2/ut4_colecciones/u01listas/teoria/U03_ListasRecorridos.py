"""
U03 — Recorridos y filtrado de listas.

OBJETIVO:
  - Recorrer con for por valor y con range/len o enumerate por indice.
  - Calcular mayor, menor y suma recorriendo (y con max/min/sum).
  - Crear una lista filtrada a partir de otra (patron habitual).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — for por valor (sin indice).
"""
print("¡DEMO 1: RECORRIDO POR VALOR!\n")

numeros = [14, 7, 23, 5]
print(f"Lista: {numeros}")

print("Recorrido for valor in lista:")
for n in numeros:
    print(f"  Valor: {n}")

"""
SEGUNDA PARTE — Recorrido con indice (range + len / enumerate).
"""
print("\n¡DEMO 2: RECORRIDO CON INDICE!\n")

print("Con range(len(...)):")
for i in range(len(numeros)):
    print(f"  Posicion {i} -> {numeros[i]}")

print("Con enumerate:")
for i, valor in enumerate(numeros):
    print(f"  Posicion {i} -> {valor}")

"""
TERCERA PARTE — Mayor, menor y suma.
  Primero a mano (entender el bucle); luego con funciones built-in.
"""
print("\n¡DEMO 3: MAYOR, MENOR Y SUMA!\n")

mayor = numeros[0]
for i in range(1, len(numeros)):
    if numeros[i] > mayor:
        mayor = numeros[i]
print(f"Mayor (a mano): {mayor}")
print(f"Mayor (max): {max(numeros)}")
print(f"Menor (min): {min(numeros)}")
print(f"Suma (sum): {sum(numeros)}")

"""
CUARTA PARTE — Filtrar: nueva lista solo con los que cumplen una condicion.
"""
print("\n¡DEMO 4: FILTRAR!\n")

mayores_que_diez = []
for n in numeros:
    if n > 10:
        mayores_que_diez.append(n)
print(f"Mayores que 10: {mayores_que_diez}")

pares = []
for n in numeros:
    if n % 2 == 0:
        pares.append(n)
print(f"Pares: {pares}")

print("\n¡FIN DEL PROGRAMA!\n")
