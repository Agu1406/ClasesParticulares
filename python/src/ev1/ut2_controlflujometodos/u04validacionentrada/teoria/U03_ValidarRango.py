"""
U03 — Validar entero Y rango.

OBJETIVO:
  - Encadenar dos comprobaciones: formato (digitos) + rango (ej. 1-5 o 0-10).
  - Repetir con while not valido hasta cumplir ambas (patron C# do-while rango 1-5).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


def es_entero(texto):
    return texto.strip().isdigit()


def en_rango(n, minimo, maximo):
    return minimo <= n <= maximo


print("\n¡INICIO DEL PROGRAMA!\n")

"""
PRIMERA PARTE — Opcion de menu 1..5 (demo C#).
"""
print("¡DEMO 1: RANGO 1-5!\n")
secuencia = [0, 8, 3]
i = 0
valido = False
opcion = 0

while not valido:
    texto = str(secuencia[i])
    i = i + 1
    print("Leido:", texto)
    if not es_entero(texto):
        print("  No es un entero")
    else:
        opcion = int(texto.strip())
        if en_rango(opcion, 1, 5):
            valido = True
            print("  Valor aceptado:", opcion)
        else:
            print("  Fuera de rango (usa 1-5)")

"""
SEGUNDA PARTE — Nota 0..10.
"""
print("\n¡DEMO 2: NOTA 0-10!\n")
notas_texto = ["15", "hola", "7"]
j = 0
ok = False
nota = 0

while not ok:
    t = notas_texto[j]
    j = j + 1
    print("Nota candidata:", repr(t))
    if es_entero(t):
        nota = int(t.strip())
        if en_rango(nota, 0, 10):
            ok = True
            print("  Nota valida:", nota)
        else:
            print("  Debe estar entre 0 y 10")
    else:
        print("  Formato incorrecto")

print("\n¡FIN DEL PROGRAMA!\n")
