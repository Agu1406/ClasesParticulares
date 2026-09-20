"""
U07 — Marco de texto en ficheros.

OBJETIVO:
  - Leer una frase de linea.txt (con strip para quitar \\n).
  - Generar un marco de asteriscos segun len(frase).
  - Escribir el resultado en marco.txt.
  - Usar "*" * n para repetir caracteres (sin import).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Crear linea.txt con una frase de ejemplo.
"""
print("¡DEMO 1: CREAR linea.txt!\n")

fichero = open("linea.txt", "w", encoding="utf-8")
fichero.write("Hola Python\n")
fichero.close()

"""
SEGUNDA PARTE — Leer y limpiar con strip().
  Si no quitas el \\n, el marco se rompe en dos lineas.
"""
print("¡DEMO 2: LEER Y strip()!\n")

fichero = open("linea.txt", "r", encoding="utf-8")
frase = fichero.read().strip()
fichero.close()
print(f"Frase: {frase}")
print(f"Longitud: {len(frase)}")

"""
TERCERA PARTE — Construir el marco y guardarlo en marco.txt.
  Borde = 2 espacios laterales + 2 asteriscos de esquina -> len + 4
"""
print("\n¡DEMO 3: ESCRIBIR marco.txt!\n")

ancho = len(frase) + 4
borde = "*" * ancho
interior = f"* {frase} *"

fichero = open("marco.txt", "w", encoding="utf-8")
fichero.write(borde + "\n")
fichero.write(interior + "\n")
fichero.write(borde + "\n")
fichero.close()

fichero = open("marco.txt", "r", encoding="utf-8")
print(fichero.read())
fichero.close()

print("¡FIN DEL PROGRAMA!\n")
