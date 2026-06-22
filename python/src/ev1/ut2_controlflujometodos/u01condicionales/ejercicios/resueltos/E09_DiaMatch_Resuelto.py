"""
OBJETIVO: Entero dia 1-7: match con case 6 | 7 fin de semana, case _ laborable.
TIPO: match / case + |.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
"""

dia = int(input("Dia: "))
match dia:
    case 6 | 7:
        print("fin de semana")
    case _:
        print("laborable")
