"""
U01 — Variables y tipos basicos en Python.

En esta primera clase de variables aprenderemos los conceptos básicos
que giran en torno a las mismas, ¿como se escriben? ¿como funcionan?
¿que puedo guardar en ellas? Y así nos abriremos paso poco a poco en
este nuevo lenguaje.

OBJETIVO:
  - Crear variables (nombre = valor).
  - Conocer tipos: int, float, str, bool.
  - Mostrar valores con print y f-strings.

REGLAS:
  - Nombres en minusculas_con_guion_bajo (snake_case).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

# Diferentes tipos de datos de ejemplo.
numero_entero = 14
numero_decimal = 3.1416
cadena_texto = "Agustín"
soy_humano = True
hoy_lunes = False

# Variables de números enteros (int)
edad_profesor = 26
dientes = 32
amigos = 5

# Variables de números decimales (double)
altura = 1.76
saldo_banco = 1250.35
precio_hot_dog_costco = 1.50

# Variables de texto (str)
dia_semana = "Martes"
dia_actual = "7"
mes_actual = "Julio"
año_actual = "2026"
mensaje = "¿Cuando es tú cumpleaños?"

# Variables de booleanos (bool)
lloviendo = False
gane_loteria = False
tengo_mascotas = True

# Imprimir los datos de ejemplo usando "print()"

print("\nINICIO DEL PROGRAMA")

#prin("               Trozo 1         " +    Trozo 2   + "   Trozo 3    ")
print("\n ¡Soy tú profesor! Mi nombre es " + cadena_texto + ", mucho gusto. \n")

print("\n ¡IMPRIMIENDO VARIABLES DE NÚMEROS ENTEROS! \n")
print(f"Tú profesor tiene {edad_profesor} años.")
print(f"Tú profesor tiene {dientes} dientes.")
print(f"Tú profesor tiene {amigos} amigos.")

print("\n ¡IMPRIMIENDO VARIABLES DE NÚMEROS DECIMALES! \n")
print(f"Tú profesor mide {altura} centimetros.")
print(f"Tú profesor tiene {saldo_banco} euros en el banco.")
print(f"Tú profesor compro un Hot Dog en Costco por {precio_hot_dog_costco}")

print("\n ¡IMPRIMIENDO VARIABLES DE TEXTO! \n")
print("Hoy es " + dia_semana + ", " + dia_actual + " de " + mes_actual + " del " + año_actual + ".")
print(f"Hoy es {dia_semana}, {dia_actual} de {mes_actual} del {año_actual}.")
print("El nombre de tú profesor es " + cadena_texto + ".")

print("\n ¡IMPRIMIENDO VARIABLES DE BOOLEANOS! \n")
print(f"¿Hoy esta lloviendo? La respuesta es: {lloviendo}")
print(f"¿Me he ganado la loteria? La respuesta es: {gane_loteria}")
print(f"¿Tengo mascotas? La respuesta es: {tengo_mascotas}")

print("\nFIN DEL PROGRAMA\n")