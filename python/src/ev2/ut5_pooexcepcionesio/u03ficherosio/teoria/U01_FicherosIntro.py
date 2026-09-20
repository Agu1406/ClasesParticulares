"""
U01 — Introduccion a ficheros (nivel junior).

OBJETIVO:
  - Entender que un fichero guarda texto en el disco (ej. datos.txt).
  - Abrir, escribir y cerrar con open / close.
  - Crear datos.txt con personas (campos separados por comas).

NOTA:
  Ejecuta el .py desde la carpeta de trabajo del IDE (o crea datos.txt
  en esa misma carpeta). No hace falta pathlib ni import os.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Que es un fichero.
  Un .txt es un archivo de texto. Cada linea puede ser un registro.
  Campos: Nombre,Edad,Ciudad,Estudios,Hobby
"""
print("¡DEMO 1: IDEA!\n")
print("Ejemplo de linea: Ana,21,Madrid,Ingenieria,Leer")
print("Campos: Nombre | Edad | Ciudad | Estudios | Hobby")

"""
SEGUNDA PARTE — Crear datos.txt con open(..., "w").
  "w" = escribir (si el fichero existia, se SOBRESCRIBE).
"""
print("\n¡DEMO 2: CREAR datos.txt!\n")

lineas = (
    "Ana,21,Madrid,Ingeniería,Leer\n"
    "Luis,19,Valencia,Medicina,Fútbol\n"
    "Carmen,22,Sevilla,Historia,Pintar\n"
    "Pedro,20,Bilbao,Economía,Ajedrez\n"
    "Lucía,23,Barcelona,Biología,Viajar\n"
)

fichero = open("datos.txt", "w", encoding="utf-8")
fichero.write(lineas)
fichero.close()
print("Fichero datos.txt creado.")

"""
TERCERA PARTE — Abrir y leer.
"""
print("\n¡DEMO 3: ABRIR Y LEER!\n")

fichero = open("datos.txt", "r", encoding="utf-8")
contenido = fichero.read()
fichero.close()
print(contenido)

print("¡FIN DEL PROGRAMA!\n")
