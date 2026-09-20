"""
U06 — Excepciones y ficheros (FileNotFoundError).

OBJETIVO:
  - Relacionar try/except con lectura de ficheros (puente a u03ficherosio).
  - Capturar FileNotFoundError al leer un path inexistente.
  - Comparar exists() previo vs try/except.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from pathlib import Path

CARPETA = Path(__file__).resolve().parent / "datos_demo"
CARPETA.mkdir(exist_ok=True)
EXISTE = CARPETA / "existe.txt"
NO_EXISTE = CARPETA / "fantasma.txt"

print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Preparar un fichero real.
"""
print("¡DEMO 1: PREPARAR!\n")

EXISTE.write_text("contenido de demo\n", encoding="utf-8")
print(f"Creado: {EXISTE.name}")

"""
SEGUNDA PARTE — try/except FileNotFoundError.
"""
print("\n¡DEMO 2: try/except FileNotFoundError!\n")

try:
    print(NO_EXISTE.read_text(encoding="utf-8"))
except FileNotFoundError:
    print(f"No se pudo leer {NO_EXISTE.name}: el fichero no existe.")

try:
    print("Lectura OK:", EXISTE.read_text(encoding="utf-8").strip())
except FileNotFoundError:
    print("No deberia fallar este fichero.")

"""
TERCERA PARTE — exists() primero (sin excepcion).
"""
print("\n¡DEMO 3: exists() PREVIO!\n")

if NO_EXISTE.exists():
    print(NO_EXISTE.read_text(encoding="utf-8"))
else:
    print(f"{NO_EXISTE.name} no existe (comprobado con exists()).")

print("\n¡FIN DEL PROGRAMA!\n")
