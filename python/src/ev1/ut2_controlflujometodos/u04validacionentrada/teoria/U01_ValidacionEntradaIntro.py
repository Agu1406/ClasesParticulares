"""
U01 — Validacion de entrada (sin excepciones).

OBJETIVO:
  - Entender por que hay que comprobar el texto ANTES de convertirlo.
  - Usar strip() para quitar espacios.
  - Usar isdigit() para detectar enteros sin signo (estilo TryParse de C#, pero a mano).
  - En EV1 no usamos try/except; eso llega en EV2 UT5 u02excepciones.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


def es_entero(texto):
    # Solo digitos 0-9. No acepta "", "-3", "3.5" ni " 42 ".
    return texto.isdigit()


print("\n¡INICIO DEL PROGRAMA!\n")

"""
PRIMERA PARTE — strip(): limpiar espacios antes de validar.
"""
print("¡DEMO 1: strip()!\n")
crudo = "  42  "
limpio = crudo.strip()
print("Crudo:", repr(crudo))
print("Limpio:", repr(limpio))
print("isdigit sin strip?", crudo.isdigit())
print("isdigit con strip?", limpio.isdigit())

"""
SEGUNDA PARTE — Comprobar y luego convertir (entrada valida).
"""
print("\n¡DEMO 2: ENTRADA VALIDA!\n")
texto_ok = "18"
if es_entero(texto_ok):
    edad = int(texto_ok)
    print("Edad valida:", edad)
else:
    print("Entrada no valida")

"""
TERCERA PARTE — Entrada invalida: no llamamos a int() a ciegas.
"""
print("\n¡DEMO 3: ENTRADA INVALIDA!\n")
texto_malo = "dieciocho"
if es_entero(texto_malo):
    print("Edad:", int(texto_malo))
else:
    print("Entrada no valida: usa solo digitos (0-9)")

"""
CUARTA PARTE — Limites de isdigit (hay que conocerlos).
"""
print("\n¡DEMO 4: LIMITES DE isdigit()!\n")
ejemplos = ["42", "-3", "3.5", "", " 7 ", "007"]
for e in ejemplos:
    print(repr(e), "->", e.isdigit())

print("\nSiguiente: U02 — reintentar con while hasta que sea valido.")
print("try/except (EV2): ev2/ut5_pooexcepcionesio/u02excepciones/")

print("\n¡FIN DEL PROGRAMA!\n")
