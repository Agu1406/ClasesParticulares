"""
Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev

ENUNCIADO
---------
Fuente: sevilla-iesvelazquez-ejercicio-ampliacion-python.pdf
Simulacion de compra en tienda (bienvenida, productos, validacion, total + descuento).
SOLUCION: ver codigo.
"""

# ALGORITMO:
# 1. Pedir nombre hasta que strip() no sea vacio.
# 2. Bucle productos: nombre; si "fin" salir; si vacio repetir; pedir precio valido.
# 3. Si lista vacia: avisar. Si no: listar, sumar, descuento 10% si total > 100.


def pedir_nombre():
    while True:
        nombre = input("Tu nombre: ").strip()
        if nombre != "":
            return nombre
        print("Error: el nombre no puede estar vacio.")


def pedir_precio():
    while True:
        texto = input("Precio: ").strip()
        try:
            precio = float(texto.replace(",", "."))
            if precio > 0:
                return precio
            print("Precio no válido. Introduce un número positivo. Inténtalo de nuevo.")
        except ValueError:
            print("Precio no válido. Introduce un número positivo. Inténtalo de nuevo.")


print("¡Bienvenido a la tienda!")
usuario = pedir_nombre()
print("Hola,", usuario)

productos = []
seguir = True
while seguir:
    nombre = input('Nombre del producto (o "fin"): ').strip()
    if nombre.lower() == "fin":
        seguir = False
    elif nombre == "":
        print("Error: el nombre del producto no puede estar vacio.")
    else:
        precio = pedir_precio()
        productos.append((nombre, precio))

if len(productos) == 0:
    print("No se ha introducido ningun producto.")
else:
    print("\nLista de productos:")
    total = 0.0
    for nombre, precio in productos:
        print(f"- {nombre}: {precio:.2f} €")
        total = total + precio
    print(f"Total: {total:.2f} €")
    if total > 100:
        total_desc = total * 0.90
        print(f"Descuento 10% aplicado. A pagar: {total_desc:.2f} €")
    else:
        print(f"A pagar: {total:.2f} €")
