"""
U04 — Condicionales anidados y operadores logicos.

OBJETIVO:
  - if dentro de otro if (anidado) cuando hay dos condiciones en cascada.
  - and: ambas deben ser True. or: al menos una. not: invierte.
  - Combinar con if/elif cuando match no encaja (rangos, desigualdades).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""
print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE - Ejemplo con "if" dentro de otros "if".
"""
print(f"\n¡PRUEBA USANDO UN \"IF\" ANIDADO DENTRO DE OTRO \"IF\"!\n")
edad = 20
tiene_carnet = True

# PRIMERA VALIDACIÓN: Si ya es mayor de edad el if se ejecuta.
if edad >= 18:
    # SEGUNDA VALIDACIÓN: Si además de ser mayor, tiene carnet, el if se ejecuta.
    if tiene_carnet:
        print("Puede conducir")
    else:
        print("Necesita sacarse el carnet")
else:
    print("Es menor de edad")

"""
SEGUNDA PARTE - Solo si ambas condiciones se cumplen usando "and" se ejeucta el "if".
"""
print(f"\n¡PRUEBA USANDO UN \"IF\" CON MULTIPLES CONDICIONES ENCADENADAS CON \"AND\"!\n")
temperatura = 25
soleado = True
if temperatura > 20 and soleado:
    print("Buen dia para salir")
"""
TERCERA PARTE - Si una (cualquiera) de las dos condiciones se cumple usando "or" se ejecuta el "if".
"""
print(f"\n¡PRUEBA USANDO UN \"IF\" CON MULTIPLES CONDICIONES ENCADENADAS CON \"OR\"!\n")
es_finde = True
es_festivo = False

if es_finde or es_festivo:
    print("Dia de descanso")

"""
CUARTA PARTE - Si una condición no se cumple (validando con not), entonces el "if" se ejecuta.
"""
print(f"\n¡PRUEBA USANDO UN \"IF\" NEGANDO CONDICIONES CON \"NOT\"!\n")
llueve = False
if not llueve:
    print("No hace falta paraguas")

print("\n¡FIN DEL PROGRAMA!\n")