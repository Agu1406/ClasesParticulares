"""
OBJETIVO: Aceptar solo enteros entre 1 y 5 (secuencia [9, 0, 4]).
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

def es_entero(texto):
    return texto.strip().isdigit()


seq = ["9", "0", "4"]
i = 0
ok = False
n = 0
while not ok:
    t = seq[i]
    i = i + 1
    if es_entero(t):
        n = int(t.strip())
        if 1 <= n <= 5:
            ok = True
        else:
            print("Fuera de rango:", n)
    else:
        print("No entero:", t)
print("Aceptado:", n)
