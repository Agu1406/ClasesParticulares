"""
Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev

ENUNCIADO
---------
Fuente: examen.txt — Problema 6

NORMAS (examen):
- Incluye el algoritmo lo más detallado posible, además del código.
- Solo estructuras, tipos e instrucciones vistas durante el curso.
- No librerías externas.
- No usar break ni continue.

Problema 6 [1,5 puntos]

El fichero 'ventas.txt' contiene las ventas del mes de un comercio. Cada línea contiene una
venta con la siguiente información (separadas por comas): código del artículo, precio
unitario y unidades vendidas. Teniendo en cuenta que pueden haber varias líneas con el
mismo código de artículo, calcular qué artículo ha generado mayores ingresos al comercio
(acumulado mayor cantidad de euros en ventas).

Usa el fichero ventas.txt de esta práctica (carpeta padre o la misma carpeta al ejecutar).
"""

# ALGORITMO:
# 1. Abrir ventas.txt y leer todas las líneas.
# 2. Por cada línea: codigo, precio, unidades -> ingreso = precio * unidades.
# 3. Acumular ingresos por codigo en un diccionario.
# 4. Recorrer el diccionario y quedarse con el codigo de mayor ingreso.
# 5. Mostrar ese artículo.

fichero = open("ventas.txt", "r", encoding="utf-8")
contenido = fichero.read()
fichero.close()

ingresos = {}
lineas = contenido.split("\n")
i = 0
while i < len(lineas):
    linea = lineas[i]
    if linea != "":
        partes = linea.split(",")
        codigo = partes[0]
        precio = float(partes[1])
        unidades = float(partes[2])
        total = precio * unidades
        if codigo in ingresos:
            ingresos[codigo] = ingresos[codigo] + total
        else:
            ingresos[codigo] = total
    i = i + 1

mejor_codigo = ""
mejor_ingreso = -1.0
for codigo in ingresos:
    if ingresos[codigo] > mejor_ingreso:
        mejor_ingreso = ingresos[codigo]
        mejor_codigo = codigo

print("Articulo con mayores ingresos:", mejor_codigo)
print("Ingresos totales:", mejor_ingreso)
