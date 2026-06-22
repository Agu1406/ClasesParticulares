"""
U01 — Variables y tipos basicos en Python.

OBJETIVO:
  - Crear variables (nombre = valor).
  - Conocer tipos: int, float, str, bool.
  - Mostrar valores con print y f-strings.
  - type() devuelve el tipo de una variable.

REGLAS:
  - Nombres en minusculas_con_guion_bajo (snake_case).
  - Python infiere el tipo; no declaras int x como en Java.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

# --- Tipos numericos ---
edad = 18
altura = 1.72
# print(): muestra edad y el resultado de type(), que devuelve el tipo del valor
print("edad:", edad, "| tipo:", type(edad))
# print(): muestra altura y su tipo con type()
print("altura:", altura, "| tipo:", type(altura))

# --- Texto ---
nombre = "Maria"
inicial = 'M'
# print(): muestra nombre y confirma que es str con type()
print("nombre:", nombre, "| tipo:", type(nombre))

# --- Booleano ---
activo = True
aprobado = False
# print(): muestra el booleano y su tipo
print("activo:", activo, "| tipo:", type(activo))

# --- f-string: texto con variables incrustadas entre llaves ---
# print(): f"..." permite meter variables dentro del texto
print(f"Hola {nombre}, tienes {edad} anos y mides {altura} m")

# --- Reasignar cambia el valor (y puede cambiar el tipo) ---
dato = 10
# print(): valor y tipo antes de reasignar
print("dato:", dato, type(dato))
dato = "ahora soy texto"
# print(): valor y tipo despues de reasignar a texto
print("dato:", dato, type(dato))

# --- Constantes por convencion (MAYUSCULAS) ---
IVA = 0.21
# print(): f-string con la constante IVA
print(f"IVA del 21%: {IVA}")

# --- Casting (conversion explicita) ---
texto_numero = "25"
# int(): convierte el texto "25" a numero entero
numero = int(texto_numero)
# print(): suma el entero convertido mas 5
print("texto_numero + 5 =", numero + 5)

# float(): convierte el texto "3.14" a numero decimal
decimal_texto = float("3.14")
# print(): muestra el decimal obtenido
print("decimal_texto:", decimal_texto)
