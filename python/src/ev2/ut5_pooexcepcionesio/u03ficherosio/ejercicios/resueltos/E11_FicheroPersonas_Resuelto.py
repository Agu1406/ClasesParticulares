"""
OBJETIVO: Con datos.txt (Nombre,Edad,Ciudad,Estudios,Hobby):
  1) read() -> contenido
  2) split("\\n") -> personas
  3) lista_personas = [p.split(",") for p in personas]
  4) Imprime nombre[0][0], ciudad ultima [ -1 ][2], hobby tercera [2][-1]
  5) Listas nombres y estudios
  6) Mayores de 20 con comprension
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from pathlib import Path

CARPETA = Path(__file__).resolve().parent / "salida_demo"
CARPETA.mkdir(exist_ok=True)
fichero_path = CARPETA / "datos.txt"

fichero_path.write_text(
    "Ana,21,Madrid,Ingeniería,Leer\n"
    "Luis,19,Valencia,Medicina,Fútbol\n"
    "Carmen,22,Sevilla,Historia,Pintar\n"
    "Pedro,20,Bilbao,Economía,Ajedrez\n"
    "Lucía,23,Barcelona,Biología,Viajar\n",
    encoding="utf-8",
)

fichero = open(fichero_path, "r", encoding="utf-8")
contenido = fichero.read()
fichero.close()
print(contenido)
print()

personas = [p for p in contenido.split("\n") if p != ""]
print(personas)
print()

lista_personas = [persona.split(",") for persona in personas]
print(lista_personas)
print()

print(f"nombre de la primera persona: {lista_personas[0][0]}")
print(f"ciudad de la ultima persona: {lista_personas[-1][2]}")
print(f"el hobby de la tercera persona: {lista_personas[2][-1]}")
print()

nombres = []
estudios = []
for persona in lista_personas:
    nombres.append(persona[0])
    estudios.append(persona[3])
print(nombres)
print(estudios)

mayores = [persona[0] for persona in lista_personas if int(persona[1]) > 20]
print(mayores)
