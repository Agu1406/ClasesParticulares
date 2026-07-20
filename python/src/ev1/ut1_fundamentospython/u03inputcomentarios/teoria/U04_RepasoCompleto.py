"""
U04 — Repaso completo.

OBJETIVO:
  - Repasar comentarios de linea (#) y docstrings (triple comilla).
  - Repasar input() y el hecho de que siempre devuelve "str".
  - Repasar la conversion de tipos con int(), float(), bool() y str().
  - Integrar todo en un mini programa de ficha de alumno.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""
print("\nINICIO DEL PROGRAMA\n")
"""
PRIMERA PARTE - Repaso de comentarios de linea y docstrings.
"""
print("\n¡REPASO DE COMENTARIOS EN PYTHON!\n")

# Este es un comentario de una linea: empieza con "#" y termina en la misma linea.
# Sirve para explicar brevemente una linea o un bloque de codigo.

""" Este es un docstring: puede ocupar varias lineas.
Se usa para documentar modulos, funciones o secciones importantes del programa.
En este repaso lo usamos para separar y explicar cada parte del codigo. """

print("¡Los comentarios no se ejecutan, solo explican el codigo! \n")

"""
SEGUNDA PARTE - Repaso de input() y el tipo de dato que devuelve.
"""
print("\n¡REPASO DE INPUT() Y SUS TIPOS DE DATO!\n")

# Dentro del parentesis de input() escribimos un mensaje que indica que dato esperamos.
nombre = input("¿Cual es tu nombre?: ")
edad = input("¿Cual es tu edad?: ")
altura = input("¿Cual es tu altura en metros? (ejemplo: 1.75): ")
es_humano = input("¿Eres humano? (True/False): ")
print()

# Todos los datos capturados con input() son del tipo "str", aunque escribamos numeros.
print(
  f"¡Datos introducidos en el programa! \n"
  f"- Nombre: {nombre} | tipo: {type(nombre)}. \n"
  f"- Edad: {edad} | tipo: {type(edad)}. \n"
  f"- Altura: {altura} | tipo: {type(altura)}. \n"
  f"- ¿Humano?: {es_humano} | tipo: {type(es_humano)}. \n"
)

"""
TERCERA PARTE - Repaso de conversion de tipos con int(), float(), bool() y str().
"""
print("\n¡REPASO DE CONVERSION DE TIPOS!\n")

# PRIMERA TRANSFORMACION: Convertimos los datos recibidos con input() a sus tipos reales.
edad_int = int(edad)
altura_float = float(altura)
es_humano_bool = bool(es_humano)

print(
  f"¡Datos convertidos correctamente! \n"
  f"- Edad: {edad_int} | tipo: {type(edad_int)}. \n"
  f"- Altura: {altura_float} | tipo: {type(altura_float)}. \n"
  f"- ¿Humano?: {es_humano_bool} | tipo: {type(es_humano_bool)}. \n"
)

# SEGUNDA TRANSFORMACION: Convertimos numeros y booleanos a cadenas de texto con str().
edad_str = str(edad_int)
altura_str = str(altura_float)
humano_str = str(es_humano_bool)

print(
  f"¡Datos convertidos de vuelta a str! \n"
  f"- Edad str: {edad_str} | tipo: {type(edad_str)}. \n"
  f"- Altura str: {altura_str} | tipo: {type(altura_str)}. \n"
  f"- Humano str: {humano_str} | tipo: {type(humano_str)}. \n"
)

# TERCERA TRANSFORMACION: Ejemplos de conversiones que NO son posibles (causarian error).
nota_texto = "7.50"
# ❌ int() no acepta decimales en formato str; habria que usar float() primero.
# nota_int = int(nota_texto)

precio_texto = "Veinte"
# ❌ float() no acepta palabras; solo numeros con punto decimal.
# precio_float = float(precio_texto)

print(
  f"¡Ejemplos de conversiones imposibles! \n"
  f"- Nota \"{nota_texto}\" a int: No es posible convertirlo directamente. \n"
  f"- Precio \"{precio_texto}\" a float: No es posible convertirlo. \n"
)

"""
CUARTA PARTE - Mini programa integrador: ficha de alumno.
"""
print("\n¡FICHA DE ALUMNO — INTEGRANDO TODO LO APRENDIDO!\n")

# Modificamos los datos ya convertidos para simular un cambio en el tiempo.
edad_proximo_ano = edad_int + 1
altura_crecida = altura_float + 0.02

# Usamos un ternario para personalizar el mensaje segun la edad (adelanto de condicionales).
mensaje_edad = "¡Eres mayor de edad! \n" if edad_int >= 18 else "¡Aun eres menor de edad! \n"

# Montamos la ficha final convirtiendo todo lo necesario a str para el mensaje.
ficha = (
  f"--- FICHA DE ALUMNO --- \n"
  f"Nombre: {nombre}. \n"
  f"Edad actual: {edad_int} años | Proximo año: {edad_proximo_ano} años. \n"
  f"Altura actual: {altura_float} m | Tras crecer: {altura_crecida} m. \n"
  f"¿Es humano?: {es_humano_bool}. \n"
  f"{mensaje_edad}"
)

print(ficha)

print("\nFIN DEL PROGRAMA\n")
