"""
U03 — Operadores aritmeticos.

OBJETIVO:
    - Operar con + - * / // % **
    - Comparar con == != < > <= >=
    - Combinar condiciones con and, or, not
    - Operadores de asignacion: += -= *= /=

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""
print("\nINICIO DEL PROGRAMA\n")

# Variables de ejemplo para probar las operaciones aritmeticas.
a = 10
b = 3

# Sumamos los dos números y guardamos el resultado.
resultado_s = a + b

# Restamos los dos números y guardamos el resultado.
resultado_r = a - b

# Multiplicamos los dos números y guardamos el resultado.
resultado_m = a * b

# Dividimos los dos números y guardamos el cociente.
resultado_dc = a / b

# Dividimos los dos números y guardamos el resto.
resultado_dr = a % b

# Dividimos los dos números y guardamos el cociente sin decimales.
resultado_de = a // b

# Potencia de los dos números y guardamos el resultado.
resultado_po = a ** b

print("\n¡IMPRIMIENDO OPERACIONES ARITMETICAS!\n")
# Aquí imprimimos la suma.
print(f"Suma: {a} + {b} = {resultado_s}")

# Aquí imprimimos la resta.
print(f"Resta: {a} - {b} = {resultado_r}")

# Aquí imprimimos la multiplicación.
print(f"Multiplicación: {a} X {b} = {resultado_m}")

# Aquí imprimimos el cociente de la división.
print(f"División (cociente): {a} ÷ {b} = {resultado_dc}")

# Aquí imprimimos el resto de la división.
print(f"División (resto): {a} ÷ {b} = {resultado_dr}")

# Aquí imprimimos el cociente sin decimales.
print(f"División (cociente sin decimales): {a} ÷ {b} = {resultado_de}")

# Aquí imprimimos la potencia de los números.
print(f"Potencia: {a}^{b} = {resultado_po}")


"""
Existen dos escenarios posibles al momento de realizar operaciones
aritmeticas.

Primero es cuando hago una operación y deseo guardar
el resultado para un uso posterior.

Segundo es cuando no necesito guardar el resultado y 
solo deseo visualizarlo temporalmente.
"""
resultado = a + b
print(f"La suma de {a} y {b} da como resultado {resultado}")
print(f"La resta de {a} y {b} da como resultado {a - b}")

print("\nFIN DEL PROGRAMA\n")