"""
U03 — Leer texto: read() y split por lineas.

OBJETIVO:
  - Leer todo el fichero con read() en una cadena llamada contenido.
  - Observar los saltos de linea '\\n' dentro de la cadena.
  - Trocear con split("\\n") para obtener una lista de lineas (personas).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

# Creamos datos.txt al inicio (asi el ejemplo funciona solo).
fichero = open("datos.txt", "w", encoding="utf-8")
fichero.write(
    "Ana,21,Madrid,Ingeniería,Leer\n"
    "Luis,19,Valencia,Medicina,Fútbol\n"
    "Carmen,22,Sevilla,Historia,Pintar\n"
    "Pedro,20,Bilbao,Economía,Ajedrez\n"
    "Lucía,23,Barcelona,Biología,Viajar\n"
)
fichero.close()

print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — read() guarda TODO en una sola cadena.
"""
print("¡DEMO 1: contenido = fichero.read()!\n")

fichero = open("datos.txt", "r", encoding="utf-8")
contenido = fichero.read()
fichero.close()

print(contenido)
print("---")
print("La variable contenido es un str. Entre lineas hay el caracter \\n.")
print(repr(contenido[:40]), "...")

"""
SEGUNDA PARTE — split("\\n") convierte la cadena en lista de lineas.
"""
print("\n¡DEMO 2: personas = contenido.split('\\n')!\n")

personas = contenido.split("\n")
# Si el fichero acaba en \\n, split deja un ultimo elemento vacio: lo quitamos.
personas = [p for p in personas if p != ""]
print(personas)
print(f"Numero de personas (lineas): {len(personas)}")

print("\n¡FIN DEL PROGRAMA!\n")
