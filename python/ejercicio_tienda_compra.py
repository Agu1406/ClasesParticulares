"""
1. Introducción del programa.

Pequeño bucle que pide un nombre hasta que sea
valido (no puede ser un nombre en blanco y debe
ser un nombre valido en carácteres del alfabeto)

Cuando el nombre es valido sale del bucle y saluda
a ese nombre.
"""

# Mensaje de bienvenida al supermercado.
print('Bienvenido al supermercado.')

# Variable para guardar el nombre (vacia por defecto)
nombre = ''


while True:
    # Solicitamos el nombre con un input
    nombre = input("Ingrese su nombre: ")

    # Ejemplo "  Elias  " se convierte en "Elias"
    nombre = nombre.strip()

    # Si el nombre esta en blanco o vacio da un error.
    if not nombre:
        print('Error: Debes introducir un nombre valido.')
    
    # Si el nombre no esta en blanco sale del bucle.
    else:
        # Rompe el "true" del bucle.
        break
    
print("¡Hola! Bienvenido ", nombre)

"""
2. Introducción de productos
Se le solicita al usuario un nombre de producto
que se valida hasta que exista (no sea nulo) y
no este en blanco.

Posteriormente se solicita un precio del producto
el cual se intenta convertir a float (en caso de
fallo es atrapado en el "Except" del "Try") y
valida que no sea un número negativo.

Si todo sale bien sale de los bucles y pasa a la
siguiente sección.
"""

# Creamos una lista de productos vacia.
productos = []
# Salto de linea para separar de los mensajes anteriores.
print("")
# Mensaje que invita al usuario a introducir los productos.
print("¡Introduce los productos que deseas comprar!")
# Mensaje que avisa al usuario como terminar la compra.
print("Cuando hayas terminado escribe 'fin' para salir.")

while True:
    # Solicitamos el nombre del producto
    nombre_producto = input("Nombre del producto: ")
    # Eliminamos espacios al inicio y final
    nombre_producto = nombre_producto.strip()

    # Si escribe "fin" se acaba el programa.
    if nombre_producto.lower() == "fin":
        # Para el bucle principal acabando con esta sección.
        break

    # Si el producto es "null" o esta en blanco da un error.
    if not nombre_producto:
        print('Error: Debes introducir un producto valido, ¡Intentalo de nuevo!')
        # Continua ejecutando el bucle para un nuevo intento.
        continue
    
    """
    3. Validación de los precios.

    Es un bucle dentro del bucle de productos, el primer bucle
    es el encargador de pedir infinitamente productos hasta que
    el usuario escriba la palabra "fin".

    Este segundo bucle es el encargado de asignarle un precio a
    los productos y asegurarse de que sean validos.
    """
    while True:
        # Solicita al cliente el precio del producto.
        precio_producto_string = input("Introduce el precio del producto: ")
        # Eliminamos espacios al inicio y final
        precio_producto_string = precio_producto_string.strip()
        
        # Valida el precio del producto, si es nulo o en blanco, error.
        if not precio_producto_string:
            print("Error: Debes introducir un precio valido. ¡Intentalo de nuevo!")
            continue

        # Intentamos convertir el precio a un número entero positivo.
        try:
            # Intentamos convertir en un número "float" el precio del producto.
            precio_producto_float = float(precio_producto_string)

            if precio_producto_float > 0:
                
                # Si el precio es un número positivo entonces es correcto, lo añado.
                productos.append((nombre_producto, precio_producto_float))
                
                # Mensaje de confirmación de que el producto fue añadido.
                print("¡Producto añadido exitosamente!")

                # Break para "salir" del bucle.
                break
            
            # Si el precio es un número pero no es positivo error.
            else:
                print("Error: Precio no valido, solo sirven números positivos, intentalo de nuevo.")
        
        # Atrapa excepciones, por ejemplo, si el precio son letras o carácteres especiales.
        except ValueError:
            print("Error: Precio no valido, solo pueden ser números positivos, intentalo de nuevo.")

"""
4. Tratamiento de los datos, mostrar el carrito y
calcular el precio total.
"""
# Salto de linea para separar de los mensajes anteriores.
print("")
# Mensaje que avisa que se va a mostrar el carrito de compra.
print("¡Este es tu carrito de compra!")

# Error en caso de que no se hayan añadido productos.
if not productos:
    print("Error: No existe ningún producto, el carrito esta vacio.")
# Si existen los productos se ejecuta el "else".
else:
    # Precio total del pedido, incrementa con el bucle inferior.
    precio_total = 0

    # Bucle que recorre uno por uno todos los productos.
    for producto in productos:
        # Extraemos los datos de los productos uno por uno.
        nombre_producto = producto[0]
        precio_producto_float = producto[1]

        # Muestra la información de ese producto antes de pasar al siguiente.
        print("Nombre: ", nombre_producto, " - precio: ", precio_producto_float, "€")

        # Sumamos el precio de ese producto al precio total.
        precio_total += precio_producto_float
    
    # Salto de linea
    print("")
    # Mensaje que avisa del "Subtotal".
    print("¡Subtotal de los productos!")

    # Si el precio asciende a más de 100€ hay descuento.
    if precio_total > 100:
        # El descuento será del 10% del pedido.
        descuento = precio_total * 0.10

        # Creamos una variable que guarda el precio con descuento.
        precio_con_descuento = precio_total - descuento

        print("¡Se ha realizado un descuento del 10%")
        print("Precio sin descuento: ", precio_total)
        print("Precio con descuento: ", precio_con_descuento)
        print("Descuento aplicado: ", descuento)
        
    # Si el pedido no es de más de 100€ no hay descuento.
    else:
        print("Precio total a pagar: ", precio_total)

# Mensaje final que se ejecuta cuando acaba el programa.
print("¡Gracias por tú compra! Fin del programa, vuelva pronto.")