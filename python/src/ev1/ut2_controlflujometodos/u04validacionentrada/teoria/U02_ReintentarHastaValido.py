"""
U02 — Reintentar hasta que la entrada sea valida.

OBJETIVO:
  - Usar while not valido (equivalente didactico al do-while de C#/Java).
  - Pedir (o simular) un entero hasta que pase la comprobacion.
  - Preferir bandera frente a break (util tambien en examenes).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


def es_entero(texto):
    return texto.strip().isdigit()


print("\n¡INICIO DEL PROGRAMA!\n")

"""
PRIMERA PARTE — Simulacion de reintentos (como demo C# do-while).
  Secuencia: invalida, invalida, valida.
"""
print("¡DEMO 1: REINTENTOS SIMULADOS!\n")
entradas = ["abc", "", "25"]
indice = 0
valido = False
numero = 0

while not valido:
    texto = entradas[indice]
    indice = indice + 1
    print("Intento con:", repr(texto))
    if es_entero(texto):
        numero = int(texto.strip())
        valido = True
        print("  Aceptado:", numero)
    else:
        print("  No valido. Reintentando...")

"""
SEGUNDA PARTE — Misma idea empaquetada en una funcion (datos simulados).
"""
print("\n¡DEMO 2: FUNCION pedir_entero_simulado!\n")


def pedir_entero_simulado(lista_textos):
    i = 0
    ok = False
    valor = 0
    while not ok:
        t = lista_textos[i]
        i = i + 1
        if es_entero(t):
            valor = int(t.strip())
            ok = True
        else:
            print("  Rechazado:", repr(t))
    return valor


resultado = pedir_entero_simulado(["x", "12"])
print("Resultado final:", resultado)

print("\nEn clase real: sustituye la lista por input('Numero: ').")
print("\n¡FIN DEL PROGRAMA!\n")
