"""
U03 — Parametros y argumentos.

OBJETIVO:
  - Distinguir parametro (en la def) de argumento (en la llamada).
  - Pasar uno o varios valores a una funcion.
  - Usar valores por defecto y argumentos nombrados.
  - Entender que Python no tiene sobrecarga por tipo (a diferencia de Java/C#).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


def mostrar_mensaje(texto, veces):
    # texto y veces son PARAMETROS: reciben los valores de la llamada.
    for _ in range(veces):
        print(texto)


def area_rectangulo(base, altura):
    return base * altura


def perimetro_cuadrado(lado):
    return lado * 4


def presentar_persona(nombre, edad, altura):
    # Varios parametros de distinto tipo (str, int, float).
    print(f"- Nombre: {nombre} | Edad: {edad} | Altura: {altura} m")


def calcular_precio_con_iva(precio, iva):
    return precio + (precio * iva / 100)


def repetir_mensaje(texto, veces=1):
    # veces=1 es un VALOR POR DEFECTO: si no lo pasas, vale 1.
    for _ in range(veces):
        print(texto)


def sumar(a, b, c=0):
    # ❌ En Python NO puedes tener dos def sumar distintas por tipo (como en Java/C#).
    # ✅ Usamos un parametro opcional: sumar(1, 2) o sumar(1, 2, 3).
    return a + b + c


print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE - Parametros en una funcion que solo imprime.
"""
print(f"\n¡DEMO 1: REPETIR MENSAJE!\n")

# "Python es genial" y 3 son ARGUMENTOS: valores concretos al llamar.
mostrar_mensaje("Python es genial", 3)
mostrar_mensaje("Fin de demo", 1)

"""
SEGUNDA PARTE - Parametros en una funcion con return.
"""
print(f"\n¡DEMO 2: AREA Y PERIMETRO!\n")

print(f"Rectangulo 5x3 -> area = {area_rectangulo(5, 3)}")
print(f"Cuadrado lado 4 -> perimetro = {perimetro_cuadrado(4)}")

"""
TERCERA PARTE - Varios parametros de distinto tipo.
"""
print(f"\n¡DEMO 3: PRESENTAR PERSONA!\n")

presentar_persona("Agustin", 26, 1.76)
presentar_persona("Eduardo", 29, 1.74)

"""
CUARTA PARTE - Parametros usados en calculos compuestos.
"""
print(f"\n¡DEMO 4: PRECIO CON IVA!\n")

precio1 = calcular_precio_con_iva(100, 21)
precio2 = calcular_precio_con_iva(49.99, 10)
print(f"100 + 21% IVA = {precio1} euros")
print(f"49.99 + 10% IVA = {precio2} euros")

"""
QUINTA PARTE - Valores por defecto y argumentos nombrados.
"""
print(f"\n¡DEMO 5: DEFAULTS Y ARGUMENTOS NOMBRADOS!\n")

# Sin el segundo argumento: veces toma el valor por defecto (1).
repetir_mensaje("Una sola vez")
# Con argumento nombrado: el orden da igual si usas el nombre del parametro.
repetir_mensaje(veces=2, texto="Dos veces (nombrado)")

print(f"sumar(1, 2)       = {sumar(1, 2)}")
print(f"sumar(1, 2, 3)    = {sumar(1, 2, 3)}")

print("\n¡FIN DEL PROGRAMA!\n")
