"""
OBJETIVO: Usa any y all sobre una lista (equivalente a anyMatch / allMatch).
SOLUCION: all(... pares) y any(... > 10).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

numeros = [2, 4, 6, 8]
print(all(n % 2 == 0 for n in numeros))
print(any(n > 10 for n in numeros))
