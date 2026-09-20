"""
U04 — Funciones con estructuras de control.

OBJETIVO:
  - Escribir funciones que usen if, for y while por dentro.
  - Mezclar condicionales y bucles dentro de una funcion reutilizable.
  - Devolver resultados calculados tras procesar datos.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


def imprimir_resultado(nota):
    # if / elif / else dentro de la funcion para clasificar.
    if nota >= 9:
        texto = "Sobresaliente"
    elif nota >= 5:
        texto = "Aprobado"
    else:
        texto = "Suspenso"
    print(f"  Nota {nota} -> {texto}")


def sumar_hasta(n):
    # for + acumulador: suma del 1 al n.
    total = 0
    for i in range(1, n + 1):
        total += i
    return total


def contar_pares(desde, hasta):
    # for + if: cuenta cuantos pares hay en el rango.
    contador = 0
    for i in range(desde, hasta + 1):
        if i % 2 == 0:
            contador += 1
    return contador


def primer_multiplo(base, minimo):
    # while + return: busca el primer multiplo de base >= minimo.
    candidato = minimo
    while candidato % base != 0:
        candidato += 1
    return candidato


print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE - Funcion con if/elif para clasificar.
"""
print(f"\n¡DEMO 1: CLASIFICAR NOTA!\n")

imprimir_resultado(9)
imprimir_resultado(6)
imprimir_resultado(3)

"""
SEGUNDA PARTE - Funcion con bucle for que acumula.
"""
print(f"\n¡DEMO 2: SUMA DEL 1 AL N!\n")

print(f"Suma 1..10 = {sumar_hasta(10)}")
print(f"Suma 1..100 = {sumar_hasta(100)}")

"""
TERCERA PARTE - Funcion con if + for: contar pares en un rango.
"""
print(f"\n¡DEMO 3: CONTAR PARES!\n")

print(f"Pares entre 1 y 20: {contar_pares(1, 20)}")
print(f"Pares entre 10 y 15: {contar_pares(10, 15)}")

"""
CUARTA PARTE - Funcion con while + return: buscar multiplo.
"""
print(f"\n¡DEMO 4: PRIMER MULTIPLO!\n")

print(f"Primer multiplo de 7 >= 50: {primer_multiplo(7, 50)}")

print("\n¡FIN DEL PROGRAMA!\n")
