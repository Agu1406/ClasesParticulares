"""
U02 — Salida por consola con print().

OBJETIVO:
  - Usar print() para mostrar texto, numeros y varios valores a la vez.
  - Conocer secuencias utiles dentro de cadenas: \\n y \\t.
  - Repetir caracteres con el operador * en una expresion.

NOTA:
  - print() es una funcion incorporada (built-in): no hace falta importarla.
  - Cada print() termina en una linea nueva por defecto (ver end= en UT2 si lo necesitas).

COMO EJECUTAR ESTE ARCHIVO (PowerShell):
  cd .../u01entornopython/teoria
  python U02_PrintIntro.py

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
"""

# print(): muestra el texto "Hola, Python!" en la consola
print("Hola, Python!")
# print(): muestra un segundo mensaje en otra linea
print("Este es mi primer script en FP.")

# print(): puede recibir varios valores; los separa con un espacio al mostrarlos
print("Curso:", "DAW/DAM", 2026)

# print(): \\n dentro del texto fuerza un salto de linea
print("Linea 1\nLinea 2")
# print(): \\t inserta un tabulador entre "Nombre:" y "Ana"
print("Nombre:\tAna")

# print(): el operador * repite el caracter "=" treinta veces en una sola linea
print("=" * 30)
# print(): mensaje final del bloque de teoria
print("Fin del bloque de teoria U02")
