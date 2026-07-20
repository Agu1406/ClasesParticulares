"""
U03 — match / case (equivalente moderno al switch de Java).

OBJETIVO:
  - Comparar un valor con varios casos concretos (Python 3.10+).
  - case valor: ejecuta si coincide; case _: es el default.
  - Util cuando hay muchas comparaciones de igualdad (==, in), no rangos complejos.
  - Para rangos (nota >= 9) sigue siendo mejor if / elif.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""
print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE - Sintaxis y uso del match case.
"""
print(
    f"¡MENÚ DE OPCIONES! \n"
    f"[1] Introduce la nota para saber si aprobaste. \n"
    f"[2] Introduce un número para saber si es par. \n"
    f"[3] Introduce una edad para saber a que grupo perteneces. \n"
    f"[4] Introduce un día de la semana (int) para saber cual es. \n"
    f"[5] Introduce si eres un humano o no (si o no). \n"
    f"[6] Introduce una edad para saber si puedes votar. \n"
)

opcion = input("¡Dime un número del 1 al 6! ")
print()

opcion = int(opcion)

match opcion:
    case 1:
        # PRIMER PASO - Le pedimos al usuario que introduzca una nota.
        nota = input("Dime que nota has sacado en el examen: ")
        print("")

        # SEGUNDO PASO - Transformamos la nota de "str" a "int".
        nota = int(nota)

        # TERCER PASO - Si la nota cumple X condición se ejecuta el if, si no, el else.
        if nota >= 5:
            print(f"¡Felicidades! Has aprobado con un {nota}. \n")
        else:
            print(f"¡Lo siento mucho! Has suspendido con un {nota}. \n")
    case 2:
        # PRIMER PASO - Le pedimos al usuario que introduzca un número.
        numero = input("¡Dime un número y te dire si es par o no!: ")
        print()

        # SEGUNDO PASO - Transformamos el número de "str" a "int".
        numero = int(numero)

        # TERCER PASO - Si el número es par se ejecuta el IF, si es impar, se ejecuta el ELSE.
        if numero % 2 == 0:
            print(f"¡El número {numero} es par!")
        else:
            print(f"¡El número {numero} no es par!")
    case 3:
        # En cada prueba podemos introducir una edad diferente y ver un resultado diferente.
        edad = input("¿Cuantos años tienes? ")
        print()

        # Recuerda que input guarda datos en forma de "str", para el ejemplo transformamos en "int".
        edad = int(edad)

        # Se ejecutara solo la linea cuya condición cumpla esa X edad.
        if edad <= 5:
            print(f"¡Eres un bebe!")
        elif edad <= 10:
            print(f"¡Eres un niño!")
        elif edad <= 17:
            print(f"¡Eres un adolescente!")
        elif edad <= 35:
            print(f"¡Eres un adulto joven!")
        elif edad <= 65:
            print(f"¡Eres un adulto normal!")
        else:
            print(f"¡Eres una persona mayor!")
    case 4:
        # En cada prueba introducimos un día diferente de la semana para probar el código.
        dia = input("¡Dime que día de la semana es! (1, 2, 3, 4, 5, 6, 7)")
        print()

        # Recuerda que input guarda datos en forma de "str", para el ejemplo transformamos en "int".
        dia = int(dia)

        # Solo se ejecuta una de estás opciones si la condición se cumple, lo otro se ignora.
        if dia == 1:
            print(f"¡Hoy es lunes! \n")
        elif dia == 2:
            print(f"¡Hoy es martes! \n")
        elif dia == 3:
            print(f"¡Hoy es miercoles! \n")
        elif dia == 4:
            print(f"¡Hoy es jueves! \n")
        elif dia == 5:
            print(f"¡Hoy es viernes! \n")
        elif dia == 6:
            print(f"¡Hoy es sabado! \n")
        else:
            print(f"¡Hoy es domingo! \n")
    case 5:
        # Preguntamos al usuario si es un humano.
        es_humano = input("¿Eres humano? (si o no): ")
        print()

        # Estoy transformando un "si" en un "True" y un "no" en un "False".
        es_humano = True if es_humano == "si" else False

        # Imprime "True" si es humano y "False" si no lo es.
        print(f"¿El usuario es un humano? La respuesta es: {es_humano}")
    case 6:
        # Preguntamos al usuario la edad.
        edad = input("¿Cuantos años tienes?: ")
        print()

        # Transformo la edad de "str" a "int".
        edad = int(edad)

        # Dependiendo de si la X edad cumple una condición se guarda un mensaje u otro.
        mensaje = "¡Eres mayor de edad! Puedes votar! \n" if edad >= 18 else "¡Eres menor de edad! No puedes votar. \n"

        # Imprimimos el mensaje.
        print(f"{mensaje}")
    case _:
        print(f"¡Opción no valida!")

print("\n¡FIN DEL PROGRAMA!\n")