"""
U01 — Bucle for y range().

OBJETIVO:
  - Repetir un bloque un numero conocido de veces.
  - range(stop), range(inicio, fin), range(inicio, fin, paso).
  - Recorrer cadenas de texto (str) con for letra in cadena.
  - Acumular resultados y generar tablas de multiplicar.

PARAMETRO end EN print() (muy usado en bucles):
  - Por defecto, print() termina con salto de linea (end="\\n").
  - end=" " cambia eso: despues del texto imprime un ESPACIO y NO baja de linea.
  - Asi varias vueltas del for pueden escribir en la MISMA linea: 0 1 2 3 4
  - Cuando el bucle acaba, print() sin argumentos (o print("")) fuerza un salto
    de linea para que lo siguiente no quede pegado.

  Ejemplo mental:
    print(1, end=" ")  -> escribe "1 " y el cursor sigue en la misma linea
    print(2, end=" ")  -> escribe "2 " al lado: "1 2 "
    print()            -> baja de linea

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""
print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE - Sintaxis y uso de un bucle "for" con range().
"""
print(f"\n¡PROBANDO EL BUCLE \"FOR\" CON NÚMEROS!\n")

# Podemos indicar hasta que numero llegar empezando por defecto en cero.
print("¡Primer bucle - Numeros del cero al cuatro!")
for numero in range(6):
    print(f"- {numero}")
print("")

# Tambien podemos indicar en range el punto exacto de inicio y el final.
print("¡Segundo bucle - Numeros del uno al ocho!")
for numero in range(1, 11):
    print(f"- {numero}")
print("")

# Por defecto el bucle va de uno en uno, este va de dos en dos, modificando su velocidad.
print("¡Tercer bucle - Pares del dos al diez!")
for numero in range(2, 11, 2):
    print(f"- {numero}")
print("")

"""
SEGUNDA PARTE - Uso de bucle "for" con cadenas de texto (str).
"""
print(f"\n¡PROBANDO EL BUCLE \"FOR\" CON CADENAS DE TEXTO!\n")

nombre = "Agustín"

# Un bucle también puede recorrer cada caracter de cadenas "str" uno por uno.
print(f"¡Letras del nombre \"{nombre}\"!")
for letra in nombre:
    print(f"- {letra}")
print("")

# Además, es posible modificar el print para imprimir todo en una sola linea.
print(f"\n¡Letras en la misma linea!")
for letra in nombre:
    print(letra, end=" ")
print("")

"""
TERCERA PARTE - Acumuladores y tablas de multiplicar con range().
"""
print(f"\n¡PROBANDO ACUMULADORES Y TABLAS CON \"FOR\"!\n")

total = 0
# Vamos sumando todos los números del bucle en una variable.
print("¡Sumando todos los números del uno al diez!")
for i in range(1, 11):
    total += i
print(f"¡Suma del 1 al 10 = {total}! \n")

# Con creatividad también podemos imprimir una tabla de multiplicar.
print("¡Tabla de multiplicar del 7!")
for i in range(1, 11):
    print(f"7 x {i} = {7 * i}")

print("\n¡FIN DEL PROGRAMA!\n")
