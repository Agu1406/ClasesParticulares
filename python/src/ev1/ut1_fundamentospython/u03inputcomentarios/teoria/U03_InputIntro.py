"""
U03 — Entrada de datos con input().

OBJETIVO:
  - input() lee texto del teclado (siempre devuelve str).
  - Convertir con int(), float(), bool() cuando haga falta.
  - Validar datos simples antes de calcular.

NOTA DIDACTICA:
  Este bloque usa valores fijos para que puedas ejecutarlo sin teclear.
  Descomenta el bloque "VERSION INTERACTIVA" para practicar con input().

Autor: Agustin. A. Marquez. Pina
"""

# --- Demo con valores fijos (ejecutable en clase sin esperar teclado) ---
nombre = "Luis"
edad_texto = "19"
# int(): convierte el texto de edad a numero entero
edad = int(edad_texto)
# print(): f-string con nombre y edad ya convertida
print(f"Hola {nombre}, tienes {edad} anos.")

num1, num2 = 12, 5
# print(): f-string con la suma de dos numeros
print(f"Suma: {num1} + {num2} = {num1 + num2}")

# --- Conversion de tipos ---
precio_texto = "9.99"
# float(): convierte texto con decimales a numero float
precio = float(precio_texto)
cantidad = 3
total = precio * cantidad
# print(): f-string con formato :.2f para mostrar dos decimales
print(f"{cantidad} x {precio:.2f} EUR = {total:.2f} EUR")

# --- VERSION INTERACTIVA (descomenta para practicar en casa) ---
# input(): lee texto del teclado y lo guarda en nombre
# nombre = input("Como te llamas? ")
# int(input(...)): lee texto y lo convierte a entero
# edad = int(input("Cuantos anos tienes? "))
# print(): saludo con edad del proximo ano
# print(f"Hola {nombre}, el ano que viene tendras {edad + 1} anos.")
#
# a = int(input("Primer numero: "))
# b = int(input("Segundo numero: "))
# print(): muestra la suma de a y b
# print("Suma:", a + b)
