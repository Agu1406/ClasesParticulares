"""
U03 — match / case (equivalente moderno al switch de Java).

OBJETIVO:
  - Comparar un valor con varios casos concretos (Python 3.10+).
  - case valor: ejecuta si coincide; case _: es el default (como default en Java).
  - Util cuando hay muchas comparaciones de igualdad (==, in), no rangos complejos.
  - Para rangos (nota >= 9) sigue siendo mejor if / elif.

EQUIVALENCIA JAVA:
  Java:  switch (opcion) { case 1: ... break; default: ... }
  Python: match opcion: case "1": ... case _: ...

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""
print("\n¡INICIO DEL PROGRAMA!\n")
"""

"""
print("\n¡FIN DEL PROGRAMA!\n")
opcion = "2"

# match: toma el valor de opcion y busca el case que coincida
match opcion:
    # case "1": se ejecuta si opcion es exactamente el texto "1"
    case "1":
        # print(): rama saludar
        print("Hola")
    # case "2": segunda opcion del menu
    case "2":
        # print(): rama despedir
        print("Adios")
    # case "0": salir del menu
    case "0":
        # print(): fin
        print("Fin")
    # case _: guion bajo = cualquier otro valor (default)
    case _:
        # print(): opcion no reconocida
        print("Opcion invalida")

# Varios valores en un mismo case con | (o logico)
dia = 6
match dia:
    # case 6 | 7: fin de semana si dia es 6 o 7
    case 6 | 7:
        # print(): sabado o domingo
        print("Fin de semana")
    case _:
        # print(): lunes a viernes
        print("Dia laborable")

# match con numeros enteros (mes -> estacion)
mes = 4
match mes:
    case 12 | 1 | 2:
        # print(): diciembre, enero, febrero
        print("Invierno")
    case 3 | 4 | 5:
        # print(): marzo, abril, mayo
        print("Primavera")
    case 6 | 7 | 8:
        # print(): verano
        print("Verano")
    case 9 | 10 | 11:
        # print(): otono
        print("Otono")
    case _:
        # print(): mes fuera de 1..12
        print("Mes no valido")

# Cuando NO usar match: condiciones con >= (mejor if/elif)
nota = 8.5
if nota >= 9:
    # print(): rango de notas con if
    print("Sobresaliente")
elif nota >= 5:
    # print(): segundo rango
    print("Aprobado")
else:
    # print(): suspenso
    print("Suspenso")
