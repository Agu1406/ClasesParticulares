"""
U01 — Entorno Python: instalar, comprobar y ejecutar.

OBJETIVO:
  - Saber que Python es interpretado (no compilas como en Java).
  - Instalar Python y comprobar que funciona desde la terminal.
  - Diferenciar REPL (consola interactiva) y script (.py).
  - Ejecutar este archivo y leer la version que esta corriendo.

INSTALACION (Windows, resumen):
  1. Descarga desde https://www.python.org/downloads/
  2. En el instalador, marca "Add python.exe to PATH".
  3. Abre PowerShell y comprueba:
       python --version
     Si no responde, prueba tambien:
       py --version

REPL (modo interactivo):
  - Escribir solo: python   (o py en algunos equipos Windows)
  - Aparece el prompt >>> : puedes escribir expresiones y pulsar Enter.
  - Salir: exit()  o  Ctrl+Z y Enter en Windows.

SCRIPT (modo archivo):
  - Guardas codigo en un .py y lo ejecutas:
       python nombre.py
  - No hace falta public class ni main: el interprete lee el archivo de arriba abajo.

DIFERENCIA RAPIDA CON JAVA:
  - Java: JDK compila .java -> bytecode; la JVM ejecuta; hace falta class + main.
  - Python: el interprete lee el .py directamente; print() sustituye a System.out.println.

ERRORES FRECUENTES:
  - "python no se reconoce..." -> Python no esta en el PATH o no esta instalado.
  - "can't open file ..." -> estas en otra carpeta; usa cd hasta la ruta del .py.
  - SyntaxError -> revisa comillas, dos puntos o indentacion (se vera en u03).

SIGUIENTE BLOQUE: U02_PrintIntro.py (salida por consola con print).

COMO EJECUTAR ESTE ARCHIVO (PowerShell):
  cd .../u01entornopython/teoria
  python U01_EntornoIntro.py

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
"""

import sys

# print(): confirma que el script se ejecuto correctamente
print("Entorno Python: OK")

# sys.version: cadena con la version del interprete (y mas datos tecnicos)
# .split()[0]: nos quedamos solo con el numero, por ejemplo 3.12.4
print("Version:", sys.version.split()[0])

# sys.executable: ruta del ejecutable python que esta corriendo este script
print("Ejecutable:", sys.executable)

# __file__: nombre (y ruta) del archivo .py que estas ejecutando
print("Archivo:", __file__)

# print(): mensaje final del bloque de teoria U01
print("Si ves estas lineas, tu entorno esta listo para seguir con U02_PrintIntro.")
