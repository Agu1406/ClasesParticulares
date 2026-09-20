"""
OBJETIVO: While: pide numeros enteros hasta que el usuario escriba -1. Muestra la suma (sin contar el -1).
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

suma = 0
numero = int(input("Numero (-1 para terminar): "))
while numero != -1:
    suma += numero
    numero = int(input("Numero (-1 para terminar): "))
print(f"Suma = {suma}")
