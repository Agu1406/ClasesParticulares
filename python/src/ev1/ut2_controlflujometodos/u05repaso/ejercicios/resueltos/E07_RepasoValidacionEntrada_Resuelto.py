"""
OBJETIVO: Si "42" es digito, imprimir int("42"); si no, aviso.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

texto = "42"
if texto.isdigit():
    print(int(texto))
else:
    print("Entrada no valida")
