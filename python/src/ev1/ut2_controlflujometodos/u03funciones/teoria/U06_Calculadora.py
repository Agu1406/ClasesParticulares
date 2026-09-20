"""
U06 — Proyecto integrador: calculadora con funciones y menu.

OBJETIVO:
  - Combinar funciones, while, match/case y return.
  - Patron menu: repetir hasta que el usuario elija salir.
  - Separar responsabilidades: mostrar_menu, operaciones, main.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


def mostrar_menu():
    print("\n" + "=" * 40)
    print("        CALCULADORA SIMPLE")
    print("=" * 40)
    print("1. Sumar  2. Restar  3. Multiplicar  4. Dividir  0. Salir")


def sumar(a, b):
    return a + b


def restar(a, b):
    return a - b


def multiplicar(a, b):
    return a * b


def dividir(a, b):
    if b == 0:
        return "Error: division entre cero"
    return a / b


def main():
    while True:
        mostrar_menu()
        opcion = input("Opcion: ")
        match opcion:
            case "0":
                print("Hasta luego")
                break
            case "1" | "2" | "3" | "4":
                a = float(input("Primer numero: "))
                b = float(input("Segundo numero: "))
                match opcion:
                    case "1":
                        print("Resultado:", sumar(a, b))
                    case "2":
                        print("Resultado:", restar(a, b))
                    case "3":
                        print("Resultado:", multiplicar(a, b))
                    case "4":
                        print("Resultado:", dividir(a, b))
            case _:
                print("Opcion no valida")


print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Menu interactivo con input hasta elegir salir.
"""
print("¡CALCULADORA CON MENU!\n")
print("Elige una operacion (1-4) o 0 para salir.")
print("Puedes probar varias veces; el bucle termina al pulsar 0.\n")

main()

print("\n¡FIN DEL PROGRAMA!\n")
