"""
Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev

ENUNCIADO
---------
Fuente: sevilla-iesvelazquez-ejercicio-ampliacion-python.pdf
IES Velázquez — Ejercicio ampliación Python

Ejercicio para practicar
Realiza un programa en Python que simule el proceso de una compra en una tienda.

1. Inicio del programa
   - Mostrar un mensaje de bienvenida.
   - Solicitar el nombre del usuario.
   - Saludar usando el nombre.
   - Si el nombre está vacío o solo espacios: error y volver a pedir hasta que sea válido.
   - No continuar sin nombre correcto.

2. Introducción de productos
   - Por cada producto: nombre (no vacío) y precio (número positivo, decimales OK).
   - Tantos productos como desee; para terminar escribir "fin" como nombre.
   - Nombre vacío/espacios: error y repetir.

3. Validación de precios
   - Si el precio no es válido (texto, negativo, vacío, símbolos):
     mostrar "Precio no válido. Introduce un número positivo. Inténtalo de nuevo."
     y pedir de nuevo hasta que sea correcto.
   - El programa no debe romperse por entradas erróneas.

4. Tratamiento de los datos
   - Mostrar la lista de productos con precio.
   - Calcular el total.
   - Si total > 100 €, aplicar 10 % de descuento.
   - Si no hay productos: mensaje informativo y no calcular totales.
"""

# TODO: escribe el algoritmo (comentado) y el código.
# Pistas: bucles while para validar; lista de tuplas (nombre, precio); try/except ValueError.
