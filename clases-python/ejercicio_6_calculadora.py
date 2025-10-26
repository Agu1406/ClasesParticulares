"""
EJERCICIO 6: Calculadora Completa
En este ejercicio combinarás todo lo aprendido en una calculadora.
"""

def mostrar_menu():
    """Muestra el menú de opciones"""
    print("\n" + "="*40)
    print("        CALCULADORA SIMPLE")
    print("="*40)
    print("1. Sumar")
    print("2. Restar")
    print("3. Multiplicar")
    print("4. Dividir")
    print("5. Potencia")
    print("6. Módulo")
    print("0. Salir")
    print("="*40)

def pedir_numeros():
    """Pide dos números al usuario"""
    num1 = float(input("Introduce el primer número: "))
    num2 = float(input("Introduce el segundo número: "))
    return num1, num2

def sumar(num1, num2):
    """Suma dos números"""
    return num1 + num2

def restar(num1, num2):
    """Resta dos números"""
    return num1 - num2

def multiplicar(num1, num2):
    """Multiplica dos números"""
    return num1 * num2

def dividir(num1, num2):
    """Divide dos números"""
    if num2 == 0:
        return "Error: No se puede dividir entre 0"
    return num1 / num2

def potencia(num1, num2):
    """Eleva el primer número a la potencia del segundo"""
    return num1 ** num2

def modulo(num1, num2):
    """Calcula el resto de la división"""
    if num2 == 0:
        return "Error: No se puede calcular módulo de 0"
    return num1 % num2

# Programa principal
def main():
    print("¡Bienvenido a la Calculadora!")
    
    while True:
        mostrar_menu()
        opcion = input("\nSelecciona una opción: ")
        
        if opcion == "0":
            print("\n¡Hasta luego!")
            break
        elif opcion in ["1", "2", "3", "4", "5", "6"]:
            num1, num2 = pedir_numeros()
            
            if opcion == "1":
                resultado = sumar(num1, num2)
                print(f"\nResultado: {num1} + {num2} = {resultado}")
            
            elif opcion == "2":
                resultado = restar(num1, num2)
                print(f"\nResultado: {num1} - {num2} = {resultado}")
            
            elif opcion == "3":
                resultado = multiplicar(num1, num2)
                print(f"\nResultado: {num1} * {num2} = {resultado}")
            
            elif opcion == "4":
                resultado = dividir(num1, num2)
                print(f"\nResultado: {num1} / {num2} = {resultado}")
            
            elif opcion == "5":
                resultado = potencia(num1, num2)
                print(f"\nResultado: {num1} ** {num2} = {resultado}")
            
            elif opcion == "6":
                resultado = modulo(num1, num2)
                print(f"\nResultado: {num1} % {num2} = {resultado}")
        else:
            print("\n❌ Opción no válida. Intenta de nuevo.")

if __name__ == "__main__":
    main()

