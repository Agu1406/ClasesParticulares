"""
U01 — Introduccion a funciones (acciones sin return).

OBJETIVO:
  - Entender que es una funcion y por que sirve modularizar.
  - Definir funciones con def que solo ejecutan acciones (print).
  - Llamar una funcion varias veces desde el programa principal.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


def saludar():
    # Solo hace una accion: imprimir. No usa return.
    print("¡Hola desde la funcion saludar()!")


def imprimir_separador():
    # Reutilizamos este bloque cada vez que queramos una linea visual.
    print("-" * 30)


def contar_hasta_cinco():
    # Dentro de la funcion tambien podemos usar bucles.
    print("Contando hasta 5:", end=" ")
    for i in range(1, 6):
        print(i, end=" ")
    print()


print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE - Llamar una funcion varias veces.
"""
print(f"\n¡DEMO 1: SALUDAR!\n")

# Cada llamada ejecuta el cuerpo de saludar() otra vez.
saludar()
saludar()

"""
SEGUNDA PARTE - Funcion que imprime un separador.
"""
print(f"\n¡DEMO 2: SEPARADOR!\n")

imprimir_separador()
print("Contenido entre separadores")
imprimir_separador()

"""
TERCERA PARTE - Funcion con logica interna (bucle).
"""
print(f"\n¡DEMO 3: CONTAR HASTA 5!\n")

contar_hasta_cinco()

print("\n¡FIN DEL PROGRAMA!\n")
