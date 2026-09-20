"""
U05 — De fichero a listas (tratamiento de datos).

OBJETIVO:
  - Partir de contenido (str) y personas (lista de lineas).
  - Crear lista_personas con split(",") por cada linea (comprension).
  - Acceder por indices; listas de nombres/estudios; filtrar edad > 20.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

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
PRIMERA PARTE — Leer y trocear por lineas (repaso U03).
"""
print("¡DEMO 1: read + split lineas!\n")

fichero = open("datos.txt", "r", encoding="utf-8")
contenido = fichero.read()
fichero.close()
print(contenido)

personas = contenido.split("\n")
personas = [p for p in personas if p != ""]
print("personas =", personas)

"""
SEGUNDA PARTE — Cada linea -> lista de campos con split(",").
  Nombre, Edad, Ciudad, Estudios, Hobby
  indices:  0      1       2         3       4
"""
print("\n¡DEMO 2: lista_personas!\n")

lista_personas = [persona.split(",") for persona in personas]
print(lista_personas)

"""
TERCERA PARTE — Acceder a elementos concretos.
"""
print("\n¡DEMO 3: ACCESOS!\n")

print(f"Nombre de la primera persona: {lista_personas[0][0]}")
print(f"Ciudad de la ultima persona: {lista_personas[-1][2]}")
print(f"Hobby de la tercera persona: {lista_personas[2][-1]}")

"""
CUARTA PARTE — Listas de nombres y estudios (bucle clasico).
"""
print("\n¡DEMO 4: NOMBRES Y ESTUDIOS!\n")

nombres = []
estudios = []
for persona in lista_personas:
    nombres.append(persona[0])
    estudios.append(persona[3])
print("nombres =", nombres)
print("estudios =", estudios)

"""
QUINTA PARTE — Comprension con if: edad > 20.
"""
print("\n¡DEMO 5: MAYORES DE 20!\n")

mayores = [persona[0] for persona in lista_personas if int(persona[1]) > 20]
print("mayores =", mayores)

print("\n¡FIN DEL PROGRAMA!\n")
