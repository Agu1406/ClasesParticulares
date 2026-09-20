"""
OBJETIVO: Crea datos.txt y copia su contenido a datos.bak.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from pathlib import Path

CARPETA = Path(__file__).resolve().parent / "salida_demo"
CARPETA.mkdir(exist_ok=True)
datos = CARPETA / "datos.txt"
backup = CARPETA / "datos.bak"
datos.write_text("datos importantes\n", encoding="utf-8")
backup.write_text(datos.read_text(encoding="utf-8"), encoding="utf-8")
print("Backup:", backup.read_text(encoding="utf-8"))
