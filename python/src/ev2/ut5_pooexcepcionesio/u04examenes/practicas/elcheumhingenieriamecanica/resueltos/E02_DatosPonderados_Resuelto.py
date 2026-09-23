"""
Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev

ENUNCIADO
---------
Fuente: Práctica 2 — Entrada y Salida (T5-P2)

EJERCICIO 2. DATOS PONDERADOS

Escribe un programa que solicite al usuario:
1. Su nombre, primer apellido y segundo apellido.
2. Tres notas parciales (valores reales entre 0 y 10).
3. La nota del examen final.
4. La nota del trabajo final.

El programa debe calcular la nota final de la asignatura, aplicando la siguiente ponderación:
- 55% del promedio de las tres notas parciales,
- 30% del examen final,
- 15% del trabajo final.

Finalmente, muestra por pantalla una única línea con las iniciales del nombre completo (en
mayúsculas), seguido de True en caso de aprobado (nota total superior a 5.0), o False en caso
contrario.
"""

# ALGORITMO:
# 1. Pedir nombre y dos apellidos.
# 2. Pedir tres parciales, examen final y trabajo.
# 3. Media de parciales = (p1+p2+p3)/3.
# 4. Nota final = 0.55*media + 0.30*examen + 0.15*trabajo.
# 5. Iniciales = primera letra de cada parte, en mayúsculas.
# 6. Aprobado = True si nota_final > 5.0; si no, False.
# 7. Imprimir iniciales y aprobado en una sola línea.

nombre = input("Nombre: ")
apellido1 = input("Primer apellido: ")
apellido2 = input("Segundo apellido: ")

parcial1 = float(input("Parcial 1 (0-10): "))
parcial2 = float(input("Parcial 2 (0-10): "))
parcial3 = float(input("Parcial 3 (0-10): "))
examen = float(input("Examen final (0-10): "))
trabajo = float(input("Trabajo final (0-10): "))

media_parciales = (parcial1 + parcial2 + parcial3) / 3
nota_final = 0.55 * media_parciales + 0.30 * examen + 0.15 * trabajo

iniciales = (nombre[0] + apellido1[0] + apellido2[0]).upper()
aprobado = nota_final > 5.0

print(iniciales, aprobado)
