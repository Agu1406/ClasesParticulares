"""
OBJETIVO: Ordena palabras por longitud (ascendente) con sorted y key=len o lambda.
SOLUCION: sorted(palabras, key=len).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

palabras = ["programacion", "funcional", "java", "pf"]
print(sorted(palabras, key=len))
