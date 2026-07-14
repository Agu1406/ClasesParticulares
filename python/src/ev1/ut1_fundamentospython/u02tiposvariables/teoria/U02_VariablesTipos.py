"""
U01 — Variables y tipos basicos en Python.

En la clase previa entendimos que diferentes variables pueden guardar
diferente tipos de información, los cuales fueron:

  - int (números enteros)
  - double (números decimales)
  - str (texto / cadenas)
  - boolean (verdadero / falso)

Python puede decirnos si una "X" variable es de un tipo u otro usando una
función nativa de Python llamada "type()", Python usa esta función para
leer el tipo de una variable y mostrartelo.

OBJETIVO:
  - Crear variables (nombre = valor).
  - type() devuelve el tipo de una variable.

REGLAS:
  - Nombres en minusculas_con_guion_bajo (snake_case).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""
print("\nINICIO DEL PROGRAMA")

"""
PRIMERA PARTE - Mostrando y probando diferentes tipos de datos.
"""
print("\n¡IMPRIMIENDO DATOS DE EJEMPLO Y SUS TIPOS!\n")
# Variables de ejemplo para ver sus tipos de datos.
edad = 26
altura = 1.76
soy_humano = True
nombbre = "Agustín"

print(f"Edad: {edad} - Tipo {type(edad)}")
print(f"Altura: {altura} - Tipo {type(altura)}")
print(f"¿Soy humano?: {soy_humano} - Tipo: {type(soy_humano)}")
print(f"Nombre: {nombbre} - Tipo: {type(nombbre)}")

"""
SEGUNDA PARTE - Una misma variable puede cambiar de valor a lo largo de un programa.
"""
print("\n¡IMPRIMIENDO EL MISMO DATO ANTES Y DESPUÉS DE CAMBIAR SU VALOR Y TIPO¡\n")
# El valor inicial del dato es un número entero (int)
dato = 26
print(f"Valor inicial del dato: {dato} y es del tipo: {type(dato)}")

# El valor final del dato es una cadena de texto (str)
dato = "Agustín"
print(f"Valor final del dato: {dato} y es del tipo: {type(dato)}")

print("\nFIN DEL PROGRAMA\n")