"""
U07 — Condicionales anidados y operadores logicos.

OBJETIVO:
  - if dentro de otro if (anidado) cuando hay dos condiciones en cascada.
  - and: ambas deben ser True. or: al menos una. not: invierte.
  - Combinar con if/elif cuando match no encaja (rangos, desigualdades).

Autor: Agustin. A. Marquez. Pina
"""

edad = 20
tiene_carnet = True

if edad >= 18:
    # Primer nivel: ya es mayor de edad
    if tiene_carnet:
        # print(): solo si edad OK y ademas tiene carnet
        print("Puede conducir")
    else:
        # print(): mayor de edad pero sin carnet
        print("Necesita sacarse el carnet")
else:
    # print(): menor de edad; no se mira el carnet
    print("Es menor de edad")

# and en una sola condicion (equivalente a dos if anidados simples)
temperatura = 25
soleado = True
if temperatura > 20 and soleado:
    # print(): hace buen tiempo para salir
    print("Buen dia para salir")

# or: basta una condicion verdadera
es_finde = True
es_festivo = False
if es_finde or es_festivo:
    # print(): descanso si finde O festivo
    print("Dia de descanso")

# not: niega un booleano
llueve = False
if not llueve:
    # print(): se ejecuta porque llueve es False
    print("No hace falta paraguas")

# if / elif / else con operadores logicos
usuario = "admin"
clave = "1234"
if usuario == "admin" and clave == "1234":
    # print(): credenciales correctas
    print("Acceso concedido")
elif usuario == "admin":
    # print(): usuario bien pero clave mal
    print("Clave incorrecta")
else:
    # print(): usuario desconocido
    print("Usuario no existe")
