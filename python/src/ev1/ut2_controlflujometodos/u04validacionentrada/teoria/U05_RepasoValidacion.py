"""
U05 — Repaso validacion de entrada.

OBJETIVO:
  - Integrar texto no vacio + entero en rango en un mini flujo.
  - Repasar bandera while not valido sin break ni try/except.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


def texto_no_vacio(texto):
    return texto.strip() != ""


def es_entero(texto):
    return texto.strip().isdigit()


print("\n¡INICIO DEL PROGRAMA!\n")
print("¡DEMO INTEGRADA: NOMBRE + EDAD (0-120)!\n")

# --- nombre ---
nombres = ["", "  Luis  "]
i = 0
nombre = ""
ok_nombre = False
while not ok_nombre:
    t = nombres[i]
    i = i + 1
    if texto_no_vacio(t):
        nombre = t.strip()
        ok_nombre = True
    else:
        print("Nombre vacio, reintentando...")

# --- edad ---
edades = ["abc", "200", "20"]
j = 0
edad = 0
ok_edad = False
while not ok_edad:
    t = edades[j]
    j = j + 1
    print("Edad candidata:", repr(t))
    if es_entero(t):
        edad = int(t.strip())
        if 0 <= edad <= 120:
            ok_edad = True
        else:
            print("  Edad fuera de rango 0-120")
    else:
        print("  No es un entero")

print(f"\nUsuario: {nombre}, edad: {edad}")
print("Mapa del subtema: U01 strip/isdigit · U02 reintentos · U03 rango · U04 texto/float")
print("\n¡FIN DEL PROGRAMA!\n")
