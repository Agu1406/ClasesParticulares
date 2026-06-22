"""
U01 — Funciones con def.

OBJETIVO:
  - Agrupar codigo reutilizable en funciones.
  - def nombre(parametros): + cuerpo indentado.
  - return devuelve un valor al quien llama.
  - Llamar: resultado = funcion(argumentos)

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


def saludar(nombre):
    """Docstring: descripcion de la funcion saludar."""
    # print(): f-string dentro de la funcion saludar
    print(f"Hola, {nombre}!")


def sumar(a, b):
    """Docstring: devuelve la suma de a y b."""
    # return: devuelve el resultado al codigo que llamo a sumar()
    return a + b


def es_mayor_de_edad(edad):
    # return: devuelve True o False segun la edad
    return edad >= 18


# saludar(): llama a la funcion definida arriba con el argumento "Carlos"
saludar("Carlos")
# print(): muestra el resultado devuelto por sumar(3, 4)
print("3 + 4 =", sumar(3, 4))

if es_mayor_de_edad(20):
    # print(): rama if si la funcion devolvio True
    print("Acceso permitido")
else:
    # print(): rama else si devolvio False
    print("Acceso denegado")


def area_rectangulo(base, altura):
    # return: devuelve base por altura
    return base * altura


# print(): muestra el valor devuelto por area_rectangulo(5, 3)
print("Area 5x3 =", area_rectangulo(5, 3))


def repetir_mensaje(texto, veces=1):
    # range(veces): genera numeros del 0 al veces-1 para repetir el bucle
    for _ in range(veces):
        # print(): muestra texto en cada vuelta del for
        print(texto)


# repetir_mensaje(): llama con texto "Python" y veces=3
repetir_mensaje("Python", 3)
