"""
U06 — Repaso general de la U02tiposvariables

OBJETIVO:
    - Creación de variables.
    - Imprimir mensajes por consola.
    - Identificar los tipos de variables.
    - Utilizar diferentes operadores de python.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""
print("\nINICIO DEL PROGRAMA")
"""
PRIMERA PARTE - Como crear e imprimir variables.

Existen cuatro tipos de variables / datos en Python, los cuales
son

- str: Sirve para guardar texto, palabras, oraciones, letras, 
carácteres, etc, "str" viene de la palabra "String" en inglés.

- int: Sirve para guardar números enteros de cualquier tamaño.

- float: Sirve para guardar números decimales de cualquier tamaño
el número entero va antes del punto (".") y el decimal después.

- boolean: Sirve para indicar el estado de algo, si es cierto o no,
si es verdadero o no.
"""
# El texto siempre va entre comillas dobles ("") o simples ('')
nombre_p = "Agustín"
nombre_a = 'Eduardo'

# Los números enteros no llevan comillas ni nada, van directos.
edad_p = 26
edad_a = 29

# Los números decimales llevan un "." separando el entero del decimal.
altura_p = 1.76
altura_a = 1.74

# Los booleanos tienen que ser "True" o "False" con la primera letra mayúscula.
soy_humano = True
hoy_martes = False
hoy_llueve = False
es_verano = True

"""
SEGUNDA PARTE - Imprimir datos en la consola de nuestro ordenador.

Para ejecutar scripts de python (script es el nombre que se le da a
los archivos donde escibimos el código), necesitamos tener instalado
previamente Python, en tú caso Eduardo, tienes Python 3.14, VSCODE
tiene un botón de play en la parte superior que permite ejecutar el
código.

Para imprimir datos lo que más se usa es "print()" y "print(f)", esto
nos permite imprimir variables y sus valores en nuestro programa, si
solo imprimimos texto usamos "print()" pero si también hay que imprimir
números, booleanos, etc, usamos "print(f)".
"""
print("\n¡DATOS DEL PROFESOR!\n")
# Como solamente es texto no necesito usar print con la "f".
print("- Nombre: " + nombre_p + ". \n")
# Los otros datos son números, necesitamos usar el print con "f".
print(f"- Altura: {altura_p}. \n")
print(f"- Edad: {edad_p}. \n")

# También podemos usar un solo printf para imprimir varias lineas.
print( # Aquí empieza el print.
    f"\n¡DATOS DEL ALUMNO!\n"
    f"- Nombre: {nombre_a}. \n"
    f"- Altura: {altura_a}. \n"
    f"- Edad: {edad_a}. \n"
    ) # Aquí termina el print.

# También podemos imprimir todos los datos en una sola lineas.
print("\n¡DATOS COMPLETOS EN UNA SOLA LINEA!\n")
print(f"Tú profesor se llama {nombre_p}, tiene {edad_p} años, el mide {altura_p}")
print(f"Tú en cambio te llamas {nombre_a} y tienes {edad_a} años, mides {altura_a} centimetros.")

"""
TERCERA PARTE - Operadores aritmeticos.

Python se usa muchisimo como lenguaje de procesado de datos, 
para programar LLM (lenguajes de inteligencia artificial),
entre otros, todo esto requiere realizar operaciones matemticas
de forma constante, para ello existen los siguientes operadores.
"""
# Creamos dos variables con datos para realizar pruebas.
num1 = 10
num2 = 3

# SUMA: El operador usado para sumar es el carácter de más ("+").
resultado = num1 + num2
print(
    f"\n¡EJEMPLO DE SUMA!\n"
    f"{num1} + {num2} = {resultado}. \n"
    )

# RESTA: El operador usado para restar es el gión. ("-").
resultado = num1 - num2
print(
    f"\n¡EJEMPLO DE RESTA!\n"
    f"{num1} - {num2} = {resultado}. \n"
    )

# MULTIPLICACIÓN: El operador usado para multiplicar es el astericos ("*").
resultado = num1 * num2
print(
    f"\n¡EJEMPLO DE MULTIPLICACIÓN!\n"
    f"{num1} X {num2} = {resultado}. \n"
    )

# DIVISIÓN COCIENTE CON DECIMALES: El operador usado para dividir con decimales es la barra inclinada. ("/").
resultado = num1 / num2
print(
    f"\n¡EJEMPLO DE DIVISIÓN (COCIENTE CON DECIMALES)!\n"
    f"{num1} ÷ {num2} = {resultado}. \n"
    )

# DIVISIÓN RESTO: El operador usado para dividir y ver el restado es el porcentaje ("%").
resultado = num1 % num2
print(
    f"\n¡EJEMPLO DE DIVISIÓN (RESTO)!\n"
    f"{num1} + {num2} = {resultado}. \n"
    )

# DIVISIÓN COCIENTE SIN DECIMALES: El operador usado para dividir sin decimales es una doble barra inclinada. ("//").
resultado = num1 // num2
print(
    f"\n¡EJEMPLO DE SUMA!\n"
    f"{num1} ÷ {num2} = {resultado}. \n"
    )

# POTENCIA DE UN NÚMERO: El operador usado para calcular la potencia es un doble astericos. ("**").
resultado = num1 ** num2
print(
    f"\n¡EJEMPLO DE SUMA!\n"
    f"{num1} + {num2} = {resultado}. \n"
    )

"""
CUARTA PARTE - TODO
"""

"""
QUINTA PARTE - TODO
"""
print("\nFIN DEL PROGRAMA\n")