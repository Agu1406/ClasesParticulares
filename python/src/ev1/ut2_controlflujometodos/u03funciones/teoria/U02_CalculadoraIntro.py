"""
U02 — Proyecto integrador: calculadora con funciones y menu.

OBJETIVO:
  - Combinar funciones, while, if/elif y return.
  - Patron menu: repetir hasta que el usuario elija salir.
  - Separar responsabilidades: mostrar_menu, operaciones, main.

NOTA: usa input(). Para demo rapida ejecuta solo las funciones al final.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


def mostrar_menu():
    # print(): linea en blanco y separador visual
    print("\n" + "=" * 40)
    # print(): titulo del menu
    print("        CALCULADORA SIMPLE")
    # print(): cierre del marco
    print("=" * 40)
    # print(): opciones disponibles
    print("1. Sumar  2. Restar  3. Multiplicar  4. Dividir  0. Salir")


def sumar(a, b):
    # return: devuelve la suma
    return a + b


def restar(a, b):
    # return: devuelve la resta
    return a - b


def multiplicar(a, b):
    # return: devuelve el producto
    return a * b


def dividir(a, b):
    if b == 0:
        # return: devuelve mensaje de error si b es cero
        return "Error: division entre cero"
    # return: devuelve la division normal
    return a / b


def main():
    while True:
        # mostrar_menu(): llama a la funcion que pinta el menu
        mostrar_menu()
        # input(): lee la opcion del usuario como texto
        opcion = input("Opcion: ")
        if opcion == "0":
            # print(): mensaje de despedida
            print("Hasta luego")
            # break: sale del while
            break
        if opcion not in ("1", "2", "3", "4"):
            # print(): opcion no valida
            print("Opcion no valida")
            # continue: salta al inicio del while sin ejecutar el resto
            continue
        # float(input()): lee texto y lo convierte a decimal
        a = float(input("Primer numero: "))
        b = float(input("Segundo numero: "))
        if opcion == "1":
            # print(): muestra resultado de sumar(a, b)
            print("Resultado:", sumar(a, b))
        elif opcion == "2":
            # print(): muestra resultado de restar(a, b)
            print("Resultado:", restar(a, b))
        elif opcion == "3":
            # print(): muestra resultado de multiplicar(a, b)
            print("Resultado:", multiplicar(a, b))
        elif opcion == "4":
            # print(): muestra resultado de dividir(a, b)
            print("Resultado:", dividir(a, b))


# print(): demo rapida llamando a las funciones de operacion sin menu
print("Demo:", sumar(10, 3), restar(10, 3), multiplicar(10, 3), dividir(10, 3))

# Descomenta para el menu interactivo completo:
# main(): arranca el bucle del menu
# if __name__ == "__main__":
#     main()
