"""
U06 — Repaso completo de ficheros (junior).

OBJETIVO:
  - Repasar open / read / write / with y el paso a listas.
  - Recordar el flujo: fichero -> str -> lineas -> campos -> filtrar.
  - Evitar errores tipicos (olvidar close, "w" que borra, linea vacia).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Mapa mental.
"""
print("¡MAPA MENTAL!\n")
print("1. open(nombre, 'r'|'w'|'a', encoding='utf-8')")
print("2. read()  -> contenido (str con \\n)")
print("3. split('\\n') -> personas (lista de lineas)")
print("4. split(',')  -> campos de cada persona")
print("5. indices [fila][columna]  |  for  |  comprension con if")
print("6. with open(...) as f: cierra solo")

"""
SEGUNDA PARTE — Mini flujo completo sobre datos.txt.
"""
print("\n¡DEMO INTEGRADA!\n")

fichero = open("datos.txt", "w", encoding="utf-8")
fichero.write(
    "Ana,21,Madrid,Ingeniería,Leer\n"
    "Luis,19,Valencia,Medicina,Fútbol\n"
    "Carmen,22,Sevilla,Historia,Pintar\n"
    "Pedro,20,Bilbao,Economía,Ajedrez\n"
    "Lucía,23,Barcelona,Biología,Viajar\n"
)
fichero.close()

with open("datos.txt", "r", encoding="utf-8") as fichero:
    contenido = fichero.read()

personas = [p for p in contenido.split("\n") if p != ""]
lista_personas = [p.split(",") for p in personas]
mayores = [p[0] for p in lista_personas if int(p[1]) > 20]

print(f"Personas leidas: {len(lista_personas)}")
print(f"Mayores de 20: {mayores}")

"""
TERCERA PARTE — Errores tipicos.
"""
print("\n¡CUIDADO CON!\n")
print("- 'w' borra el contenido anterior; usa 'a' para anadir")
print("- Si split('\\n') deja '', filtra lineas vacias")
print("- Edad viene como texto: usa int(persona[1]) para comparar")
print("- Preferible with open para no olvidar close()")

print("\n¡FIN DEL PROGRAMA!\n")
