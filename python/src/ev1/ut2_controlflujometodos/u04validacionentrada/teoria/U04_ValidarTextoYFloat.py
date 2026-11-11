"""
U04 — Validar texto no vacio y float simple (sin try).

OBJETIVO:
  - Nombre/producto: strip() y rechazar cadena vacia (practicas Sevilla/Elche).
  - Float junior: digitos y como mucho un punto decimal; luego float().
  - Sin try/except (EV2).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


def texto_no_vacio(texto):
    return texto.strip() != ""


def es_float_simple(texto):
    t = texto.strip().replace(",", ".")
    if t == "" or t == ".":
        return False
    # Permite "3", "3.14"; no permite "-2" ni "1.2.3" en esta version junior.
    partes = t.split(".")
    if len(partes) == 1:
        return partes[0].isdigit()
    if len(partes) == 2:
        izq = partes[0]
        der = partes[1]
        if izq == "":
            return der.isdigit()  # ".5" -> opcional; aqui pedimos digitos a la derecha
        return izq.isdigit() and der.isdigit()
    return False


print("\n¡INICIO DEL PROGRAMA!\n")

"""
PRIMERA PARTE — Texto no vacio.
"""
print("¡DEMO 1: NOMBRE!\n")
nombres = ["   ", "Ana"]
k = 0
nombre_ok = False
nombre = ""

while not nombre_ok:
    candidato = nombres[k]
    k = k + 1
    print("Candidato:", repr(candidato))
    if texto_no_vacio(candidato):
        nombre = candidato.strip()
        nombre_ok = True
        print("  Hola,", nombre)
    else:
        print("  Error: el nombre no puede estar vacio")

"""
SEGUNDA PARTE — Precio float positivo.
"""
print("\n¡DEMO 2: PRECIO!\n")
precios = ["hola", "-5", "12.50"]
p = 0
precio_ok = False
precio = 0.0

while not precio_ok:
    raw = precios[p]
    p = p + 1
    print("Precio candidato:", repr(raw))
    if es_float_simple(raw):
        precio = float(raw.strip().replace(",", "."))
        if precio > 0:
            precio_ok = True
            print("  Precio aceptado:", precio)
        else:
            print("  Debe ser positivo")
    else:
        print("  Precio no valido. Introduce un numero positivo.")

print("\n¡FIN DEL PROGRAMA!\n")
