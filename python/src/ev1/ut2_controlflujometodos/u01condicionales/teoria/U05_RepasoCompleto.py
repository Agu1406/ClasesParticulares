"""
U05 — Repaso completo.

OBJETIVO:
  - Repasar el condicional "if" con distintos tipos de datos y operadores.
  - Repasar "if-else", "elif" y operadores ternarios.
  - Repasar "match / case" para multiples opciones concretas.
  - Repasar condicionales anidados y operadores logicos (and, or, not).
  - Integrar todo en un mini programa de acceso al parque de atracciones.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""
print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE - Repaso del "if" con str, float, bool e int.
"""
print(f"\n¡REPASO DEL \"IF\" CON DIFERENTES TIPOS DE DATO!\n")

nombre = "Agustín"
altura = 1.76
humano = True
jirafa = False
edad = 26

# ✅ El nombre es exactamente "Agustín", por lo tanto, el if si se ejecuta.
if nombre == "Agustín":
    print(f"¡Bienvenido, {nombre}! \n")

# ✅ La altura es mayor o igual que 1.50, por lo tanto, el if si se ejecuta.
if altura >= 1.50:
    print(f"¡Mides {altura} m! Cumples la altura minima para la montaña rusa. \n")

# ✅ "humano" es True, por lo tanto, el if si se ejecuta.
if humano:
    print(f"¡Eres un ser humano! Puedes entrar al parque. \n")

# ✅ "jirafa" es False, por lo tanto, el if con "not" si se ejecuta.
if not jirafa:
    print(f"¡No eres una jirafa! Todo correcto. \n")

# ✅ La edad es mayor o igual a 18, por lo tanto, el if si se ejecuta.
if edad >= 18:
    print(f"¡Con {edad} años eres mayor de edad! \n")

"""
SEGUNDA PARTE - Repaso de "if-else", "elif" y ternarios.
"""
print(f"\n¡REPASO DE \"IF-ELSE\", \"ELIF\" Y TERNARIOS!\n")

nota = input("¡Dime que nota sacaste en el examen (0-10)! ")
print()

nota = int(nota)

# Si la nota es mayor o igual a cinco, se ejecuta el "if". Si no, el "else".
if nota >= 5:
    print(f"¡Felicidades! Has aprobado con un {nota}. \n")
else:
    print(f"¡Lo siento! Has suspendido con un {nota}. \n")

# Solo se ejecuta una de estas opciones; el resto se ignora.
if nota >= 9:
    print(f"¡Sobresaliente! Nota: {nota}. \n")
elif nota >= 7:
    print(f"¡Notable! Nota: {nota}. \n")
elif nota >= 5:
    print(f"¡Aprobado! Nota: {nota}. \n")
else:
    print(f"¡Suspenso! Nota: {nota}. \n")

# Los ternarios permiten elegir un mensaje u otro en una sola linea.
mensaje_voto = "¡Puedes votar! \n" if edad >= 18 else "¡No puedes votar todavia! \n"
print(mensaje_voto)

"""
TERCERA PARTE - Repaso de "match / case".
"""
print(f"\n¡REPASO DE \"MATCH / CASE\"!\n")

opcion = input(
    f"¡Elige una atraccion del parque! \n"
    f"[1] Montaña rusa. \n"
    f"[2] Carritos chocones. \n"
    f"[3] Noria. \n"
    f"[4] Salir del parque. \n \n"
    f"Introduce una opcion: "
)
opcion = int(opcion)
print()

match opcion:
    case 1:
        print(f"¡Has elegido la montaña rusa! ¡Agárrate fuerte! \n")
    case 2:
        print(f"¡Has elegido los carritos chocones! ¡A chocar! \n")
    case 3:
        print(f"¡Has elegido la noria! Disfruta de las vistas. \n")
    case 4:
        print(f"¡Hasta luego! Gracias por visitar el parque. \n")
    case _:
        print(f"¡Opcion no valida! Intentalo de nuevo. \n")

"""
CUARTA PARTE - Repaso de condicionales anidados y operadores logicos (and, or, not).
"""
print(f"\n¡REPASO DE CONDICIONALES ANIDADOS Y OPERADORES LOGICOS!\n")

tiene_carnet = True
soleado = True
es_finde = True
es_festivo = False
llueve = False

# PRIMERA VALIDACION: Si es mayor de edad, entramos al bloque.
if edad >= 18:
    # SEGUNDA VALIDACION: Si ademas tiene carnet, puede conducir los karts.
    if tiene_carnet:
        print(f"¡Con {edad} años y carnet, puedes conducir los karts del parque! \n")
    else:
        print(f"¡Eres mayor de edad pero necesitas carnet para los karts! \n")
else:
    print(f"¡Con {edad} años eres menor! Los karts no son para ti. \n")

# Solo si AMBAS condiciones son True se ejecuta el if (and).
if altura >= 1.50 and soleado:
    print(f"¡Buen dia para la montaña rusa! Altura: {altura} m y hace sol. \n")

# Si UNA de las dos condiciones es True se ejecuta el if (or).
if es_finde or es_festivo:
    print(f"¡Hoy es dia de descanso! El parque esta lleno. \n")

# Si la condicion es False, el if con "not" se ejecuta.
if not llueve:
    print(f"¡No llueve! No hace falta paraguas en el parque. \n")

"""
QUINTA PARTE - Mini programa integrador: acceso a atracciones.
"""
print(f"\n¡ACCESO A ATRACCIONES — INTEGRANDO TODO LO APRENDIDO!\n")

altura_visitante = input("¿Cual es tu altura en metros? (ejemplo: 1.60): ")
print()

altura_visitante = float(altura_visitante)

# Condicional anidado + operadores logicos: decide que atracciones puede usar.
if altura_visitante >= 1.40:
    if altura_visitante >= 1.50:
        resultado = "¡Puedes subir a TODO! Montaña rusa, noria y carritos. \n"
    else:
        resultado = "¡Puedes subir a la noria y los carritos! La montaña rusa no. \n"
else:
    resultado = "¡Lo siento! No cumples la altura minima (1.40 m). \n"

print(resultado)

# Ternario final segun la altura.
mensaje_rusa = (
    f"¡Altura {altura_visitante} m! Puedes ir a la montaña rusa. \n"
    if altura_visitante >= 1.50
    else f"¡Altura {altura_visitante} m! La montaña rusa no es para ti. \n"
)
print(mensaje_rusa)

print("\n¡FIN DEL PROGRAMA!\n")
