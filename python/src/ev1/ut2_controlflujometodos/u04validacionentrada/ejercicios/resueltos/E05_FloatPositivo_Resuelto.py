"""
OBJETIVO: Aceptar float positivo sin try; secuencia ['abc', '12.5'].
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

def es_float_simple(texto):
    t = texto.strip().replace(",", ".")
    if t == "" or t == ".":
        return False
    partes = t.split(".")
    if len(partes) == 1:
        return partes[0].isdigit()
    if len(partes) == 2:
        return partes[0].isdigit() and partes[1].isdigit()
    return False


precios = ["abc", "12.5"]
i = 0
ok = False
precio = 0.0
while not ok:
    t = precios[i]
    i = i + 1
    if es_float_simple(t):
        precio = float(t.strip().replace(",", "."))
        if precio > 0:
            ok = True
        else:
            print("Debe ser positivo")
    else:
        print("No valido:", t)
print("Precio:", precio)
