"""
OBJETIVO: Pide opcion 1 o 2; si no es digito valido, repite una vez (simplificado).
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

ok = False
for _ in range(2):
    try:
        op = int(input("1 o 2: "))
        print("opcion", op)
        ok = True
        break
    except ValueError:
        print("invalido")
if not ok:
    print("fin")
