"""
U03 — Bucles anidados.

OBJETIVO:
  - Entender un "for" dentro de otro "for".
  - Relacionar bucle exterior (grupos / filas) con bucle interior (repeticiones / columnas).
  - Combinar bucles anidados con "if" cuando haga falta filtrar.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""
print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE - Un "for" dentro de otro "for" (tablas de multiplicar).
"""
print(f"\n¡PROBANDO BUCLES ANIDADOS CON TABLAS DE MULTIPLICAR!\n")

# El bucle EXTERIOR elige la tabla (1, 2 o 3).
# El bucle INTERIOR imprime cada fila de esa tabla (del 1 al 5).
print("¡Tablas del 1 al 3!")
for tabla in range(1, 4):
    print(f"-- Tabla del {tabla} --")
    for i in range(1, 6):
        print(f"{tabla} x {i} = {tabla * i}")
    print("")

"""
SEGUNDA PARTE - Dibujos con bucles anidados (triangulos y cuadrado).
"""
print(f"\n¡PROBANDO BUCLES ANIDADOS CON DIBUJOS!\n")

# Triangulo "manual": el exterior elige la fila; el interior imprime cada "*".
print("¡Triangulo de asteriscos (bucle anidado)!")
for fila in range(1, 5):
    for columna in range(fila):
        print("*", end="")
    print()
print("")

# Atajo: "*" * fila hace lo mismo en una linea (sin bucle interior).
print("¡Triangulo con el atajo \"*\" * fila!")
for fila in range(1, 5):
    print("*" * fila)
print("")

# Triangulo invertido: empezamos con 4 asteriscos y vamos bajando.
print("¡Triangulo invertido!")
for fila in range(4, 0, -1):
    for columna in range(fila):
        print("*", end="")
    print()
print("")

# Cuadrado: misma cantidad de filas y columnas.
print("¡Cuadrado 4x4!")
for fila in range(4):
    for columna in range(4):
        print("*", end="")
    print()
print("")

"""
TERCERA PARTE - Bucles anidados combinados con "if".
"""
print(f"\n¡PROBANDO BUCLES ANIDADOS CON \"IF\"!\n")

# Imprimimos solo los productos pares de las tablas del 1 al 3.
print("¡Productos pares de las tablas del 1 al 3!")
for tabla in range(1, 4):
    print(f"-- Tabla del {tabla} (solo pares) --")
    for i in range(1, 6):
        producto = tabla * i
        if producto % 2 == 0:
            print(f"{tabla} x {i} = {producto}")
    print("")

print("\n¡FIN DEL PROGRAMA!\n")
