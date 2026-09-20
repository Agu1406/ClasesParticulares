"""
OBJETIVO: While: cuenta cuantos digitos tiene el numero 12345 (resultado: 5).
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

numero = 12345
contador = 0
n = numero
while n > 0:
    n = n // 10
    contador += 1
print(f"{numero} tiene {contador} digitos")
