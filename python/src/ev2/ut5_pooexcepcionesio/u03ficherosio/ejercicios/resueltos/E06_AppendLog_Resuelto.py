"""
OBJETIVO: Crea log.txt con "inicio" y anade una linea "evento" con modo "a".
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from pathlib import Path

CARPETA = Path(__file__).resolve().parent / "salida_demo"
CARPETA.mkdir(exist_ok=True)
fichero = CARPETA / "log.txt"
fichero.write_text("inicio\n", encoding="utf-8")
with open(fichero, "a", encoding="utf-8") as f:
    f.write("evento\n")
print(fichero.read_text(encoding="utf-8"))
