"""
Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev

ENUNCIADO
---------
Fuente: Práctica 3 — Tipos de Datos Compuestos (T5-P3)

EJERCICIO 4. Fichero a Listas y Tratamiento de Datos

Crea un fichero denominado "datos.txt" con información sobre distintas personas.
Cada línea contiene cinco campos separados por comas:
Nombre,Edad,Ciudad,Estudios,Hobby

Por ejemplo, el contenido podría ser:
Ana,21,Madrid,Ingeniería,Leer
Luis,19,Valencia,Medicina,Fútbol
Carmen,22,Sevilla,Historia,Pintar
Pedro,20,Bilbao,Economía,Ajedrez
Lucía,23,Barcelona,Biología,Viajar

A partir de este fichero, implementa las siguientes tareas de manera progresiva:

1. Leer todo el fichero usando el método read() almacenando la información en una cadena
   llamada contenido y mostrar por pantalla dicha cadena.
   Observa la variable contenido con las líneas del fichero separadas por '\\n' (salto de línea).
2. Crea una nueva lista personas troceando la cadena con el método split(). Imprímela.
3. Aprovechando que una lista es un iterable, utiliza la sintaxis de comprensión de listas:
   lista_personas = [persona.split(',') for persona in personas]
   Observa el resultado...
4. Accede a elementos concretos de la lista_personas para mostrar:
   - El nombre de la primera persona.
   - La ciudad de la última persona.
   - El hobby de la tercera persona.
5. Genera dos listas, una con los nombres de las personas y otra con sus estudios.
6. Generar una lista que contenga únicamente los nombres de las personas cuya edad sea
   mayor que 20 años. Para ello, practica el uso de:
   [ <expresión> for <elemento> in <iterable> if <condición> ]
"""

# ALGORITMO: crear datos.txt y seguir los 6 puntos del enunciado.

fichero = open("datos.txt", "w", encoding="utf-8")
fichero.write("Ana,21,Madrid,Ingeniería,Leer\n")
fichero.write("Luis,19,Valencia,Medicina,Fútbol\n")
fichero.write("Carmen,22,Sevilla,Historia,Pintar\n")
fichero.write("Pedro,20,Bilbao,Economía,Ajedrez\n")
fichero.write("Lucía,23,Barcelona,Biología,Viajar\n")
fichero.close()

# 1
fichero = open("datos.txt", "r", encoding="utf-8")
contenido = fichero.read()
fichero.close()
print("1) contenido:")
print(contenido)

# 2
personas = contenido.split("\n")
# quitar posible línea vacía final
personas_limpias = []
for p in personas:
    if p != "":
        personas_limpias.append(p)
personas = personas_limpias
print("2) personas:", personas)

# 3
lista_personas = [persona.split(",") for persona in personas]
print("3) lista_personas:", lista_personas)

# 4
print("4) nombre primera:", lista_personas[0][0])
print("4) ciudad ultima:", lista_personas[-1][2])
print("4) hobby tercera:", lista_personas[2][4])

# 5
nombres = [persona[0] for persona in lista_personas]
estudios = [persona[3] for persona in lista_personas]
print("5) nombres:", nombres)
print("5) estudios:", estudios)

# 6
mayores_20 = [persona[0] for persona in lista_personas if int(persona[1]) > 20]
print("6) mayores de 20:", mayores_20)
