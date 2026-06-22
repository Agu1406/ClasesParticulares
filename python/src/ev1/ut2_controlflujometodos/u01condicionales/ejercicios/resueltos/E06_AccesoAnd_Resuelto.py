"""
OBJETIVO: Si usuario admin Y clave 1234 imprime OK, si no ERROR.
TIPO: if + and.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

u = input("Usuario: ")
c = input("Clave: ")
if u == "admin" and c == "1234":
    print("OK")
else:
    print("ERROR")
