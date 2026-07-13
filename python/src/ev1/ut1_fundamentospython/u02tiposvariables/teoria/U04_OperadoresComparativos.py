"""
U04 — Operadores de comparacion.

Los comparadores son como los booleanos, devuelen "True"
si algo es cierto o verdadero y devuelven "False" si algo
es falso o no es cierto.
OBJETIVO:
  - Comparar con == != < > <= >=

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""
print("\nINICIO DEL PROGRAMA\n")

ingresos_mes_anterior = 1400.56
ingresos_mes_actual = 2345.12
valor_pi_ayer = 3.1416
valor_pi_hoy = 3.1416

# COMPARADOR DE IGUALDAD: El operador usado para verificar si dos datos son iguales es el doble signo de igual ("==").
print("\¡PRUEBA COMPARANDO LA IGUALDAD DE VALORES! (==)\n")

respuesta = ingresos_mes_actual == ingresos_mes_anterior
print(f"¿Son iguales los ingresos de este mes a los del mes anterior? La respuestas es: {respuesta}. \n")

respuesta = valor_pi_ayer == valor_pi_hoy
print(f"¿El valor de PI de ayer es el mismo de hoy? La respuesta es: {respuesta}. \n")

# COMPARADOR DE DESIGUALDAD: El operador usado para verificar si dos datos son diferentes es el signo de exclamaciín con un signo de igual ("!=").
print("\¡PRUEBA COMPARANDO LA DIFERENCIA DE VALORES! (!=)\n")
respuesta = ingresos_mes_actual != ingresos_mes_anterior
print(f"¿Los ingresos del mes anterior y del nes actual son diferentes? Respuesta: {respuesta}. \n")

print(f"¿El valor de PI de ayer es diferente al valor de PI de hoy? Respuesta: {valor_pi_ayer != valor_pi_hoy}. \n")

# COMPARADOR DE MAYOR: El operador usado para verificar si un "X" dato es mayor que otro es el signo de mayor (">").
print("\¡PRUEBA COMPARANDO CUAL DE LOS VALORES ES MAYOR! (>)\n")

print(f"¿Los ingresos de este mes superaron los del mes anterior? La respuesta es {ingresos_mes_actual > ingresos_mes_anterior}. \n")
print(f"¿El valor de PI de ayer es mayor al valor de PI de hoy? La respuesta es: {valor_pi_ayer > valor_pi_hoy}. \n")

# COMPARADOR DE MENOR: El operador usado para verificar si un "X" dato es menor que otro es el signo de mayor ("<").
print("\¡PRUEBA COMPARANDO CUAL DE LOS VALORES ES MENOR! (<)\n")

print(f"¿Los ingresos del mes anterior superaron los del mes actual? La respuesta es {ingresos_mes_actual < ingresos_mes_anterior}. \n")
print(f"¿El valor de PI de ayer es menor que el valor de PI de hoy? La respuesta es: {valor_pi_ayer < valor_pi_hoy}. \n")

# COMPARADOR DE MAYOR O IGUAL: El operador usado para verificar si un "X" dato es mayor o igual que otro es el signo de mayor y el signo de igual. (">=").

# TODO: Falta explicar y terminar de hacer esto.

# COMPARADOR DE MAYOR O IGUAL: El operador usado para verificar si un "X" dato es menor o igual que otro es el signo de menor y el signo de igual. ("<=").

# TODO: Falta explicar y terminar de hacer esto.

print("\nFIN DEL PROGRAMA\n")