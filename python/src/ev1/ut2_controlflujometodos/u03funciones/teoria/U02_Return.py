"""
U02 — Funciones con return.

OBJETIVO:
  - Usar return para devolver un valor al codigo que llama.
  - Guardar el resultado en una variable o usarlo en print / if.
  - Ver ejemplos que devuelven int, float, bool y str.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


def sumar(a, b):
    # return entrega el resultado y termina la funcion.
    return a + b


def area_circulo(radio):
    # Devuelve un float (numero decimal).
    return 3.1416 * radio * radio


def es_par(numero):
    # Devuelve True o False (bool).
    return numero % 2 == 0


def obtener_calificacion(nota):
    # Devuelve un str segun la nota.
    if nota >= 5:
        return "Aprobado"
    return "Suspenso"


def doble(n):
    return n * 2


def triple(n):
    return n * 3


print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE - Metodo que devuelve un numero entero (int).
"""
print(f"\n¡DEMO 1: SUMAR!\n")

total = sumar(3, 4)
print(f"3 + 4 = {total}")
print(f"10 + 2 = {sumar(10, 2)}")

"""
SEGUNDA PARTE - Funcion que devuelve un float.
"""
print(f"\n¡DEMO 2: AREA DE CIRCULO!\n")

radio = 5.0
area = area_circulo(radio)
print(f"Radio {radio} -> area = {area}")

"""
TERCERA PARTE - Funciones que devuelven bool y str.
"""
print(f"\n¡DEMO 3: ES PAR Y CALIFICACION!\n")

numero = 14
print(f"¿{numero} es par? {es_par(numero)}")

nota = 8
print(f"Nota {nota} -> {obtener_calificacion(nota)}")

# Tambien podemos usar el return dentro de un if.
if es_par(20):
    print("¡20 es par!")

"""
CUARTA PARTE - Usar el return directamente en una expresion.
"""
print(f"\n¡DEMO 4: DOBLE Y TRIPLE!\n")

x = 7
print(f"Doble de {x} = {doble(x)}, triple = {triple(x)}")

print("\n¡FIN DEL PROGRAMA!\n")
