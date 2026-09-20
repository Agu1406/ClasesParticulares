"""
U05 — Excepciones propias.

OBJETIVO:
  - Definir una clase de error propia heredando de Exception.
  - Lanzarla con raise cuando una regla de negocio no se cumple.
  - Capturarla con except NombreError as e.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


class NotaInvalidaError(Exception):
    """Se lanza cuando la nota no esta entre 0 y 10."""


def validar_nota(n):
    if n < 0 or n > 10:
        raise NotaInvalidaError(f"Nota fuera de rango: {n}")
    return n


print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Nota valida: no se lanza excepcion.
"""
print("¡DEMO 1: NOTA VALIDA!\n")

try:
    print("Nota aceptada:", validar_nota(8))
except NotaInvalidaError as e:
    print("Error:", e)

"""
SEGUNDA PARTE — Nota invalida: se captura NotaInvalidaError.
"""
print("\n¡DEMO 2: NOTA INVALIDA!\n")

try:
    print("Nota aceptada:", validar_nota(12))
except NotaInvalidaError as e:
    print("Error capturado:", e)

"""
TERCERA PARTE — Varias pruebas en bucle.
"""
print("\n¡DEMO 3: VARIAS NOTAS!\n")

for nota in (0, 5, 10, -1, 10.5):
    try:
        print(f"  {nota} -> OK ({validar_nota(nota)})")
    except NotaInvalidaError as e:
        print(f"  {nota} -> {e}")

print("\n¡FIN DEL PROGRAMA!\n")
