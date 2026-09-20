"""
U01 — Validacion de entrada (sin excepciones).

OBJETIVO:
  - Comprobar datos del usuario antes de convertirlos o usarlos.
  - int(input()) y float(input()) fallan si el texto no es valido.
  - En EV1 usamos comprobaciones simples; try/except se ve en EV2 UT5.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


def es_entero(texto):
    # str.isdigit(): True si solo hay digitos (ej. "42", no "-3" ni "3.5")
    return texto.isdigit()


def pedir_edad_demo(texto):
    if es_entero(texto):
        edad = int(texto)
        print(f"Edad valida: {edad}")
    else:
        print("Entrada no valida: usa solo digitos (0-9)")


print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Comprobar antes de convertir.
"""
print("¡DEMO 1: ENTRADA VALIDA!\n")
pedir_edad_demo("18")

"""
SEGUNDA PARTE — Entrada invalida sin try/except.
"""
print("\n¡DEMO 2: ENTRADA INVALIDA!\n")
pedir_edad_demo("dieciocho")

"""
TERCERA PARTE — Donde continuar el tema.
"""
print("\n¡DEMO 3: SIGUIENTE PASO!\n")
print("Manejo formal de errores (try / except / finally):")
print("  ev2/ut5_pooexcepcionesio/u02excepciones/")

print("\n¡FIN DEL PROGRAMA!\n")
