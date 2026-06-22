"""
U02 — Operadores aritmeticos, comparacion y logicos.

OBJETIVO:
  - Operar con + - * / // % **
  - Comparar con == != < > <= >=
  - Combinar condiciones con and, or, not
  - Operadores de asignacion: += -= *= /=

Autor: Agustin. A. Marquez. Pina
"""

a, b = 10, 3

# print(): titulo de la seccion
print("=== ARITMETICOS ===")
# print(): f-string con el resultado de la suma (+)
print(f"{a} + {b} = {a + b}")
# print(): f-string con el resultado de la resta (-)
print(f"{a} - {b} = {a - b}")
# print(): f-string con el resultado de la multiplicacion (*)
print(f"{a} * {b} = {a * b}")
# print(): division real (/) devuelve float aunque el resultado sea entero
print(f"{a} / {b} = {a / b}")
# print(): division entera (//) descarta la parte decimal
print(f"{a} // {b} = {a // b}")
# print(): modulo (%) devuelve el resto de la division
print(f"{a} % {b} = {a % b}")
# print(): potencia (**) eleva a al exponente b
print(f"{a} ** {b} = {a ** b}")

# print(): salto de linea \\n y titulo de comparaciones
print("\n=== COMPARACION (devuelven True/False) ===")
# print(): operador > comprueba si a es mayor que b
print(f"{a} > {b} -> {a > b}")
# print(): operador == comprueba si son iguales
print(f"{a} == {b} -> {a == b}")
# print(): operador != comprueba si son distintos
print(f"{a} != {b} -> {a != b}")

# print(): titulo de operadores logicos
print("\n=== LOGICOS ===")
edad = 20
tiene_entrada = True
puede_entrar = edad >= 18 and tiene_entrada
# print(): muestra el resultado de combinar dos condiciones con and
print(f"puede_entrar: {puede_entrar}")

es_finde = False
descanso = es_finde or edad < 16
# print(): muestra el resultado de combinar con or
print(f"descanso: {descanso}")

# print(): not invierte un valor booleano
print(f"not True -> {not True}")

# print(): titulo de asignacion compuesta
print("\n=== ASIGNACION COMPUESTA ===")
x = 5
x += 2
# print(): valor de x despues de x += 2
print("x += 2 ->", x)
x *= 3
# print(): valor de x despues de x *= 3
print("x *= 3 ->", x)

# print(): titulo del ejemplo geometrico
print("\n=== EJEMPLO: perimetro y area de rectangulo ===")
ancho, alto = 8, 5
perimetro = 2 * (ancho + alto)
area = ancho * alto
# print(): f-string con perimetro y area calculados
print(f"ancho={ancho}, alto={alto} | perimetro={perimetro}, area={area}")
