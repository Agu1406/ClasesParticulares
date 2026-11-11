"""
U01 — Cadenas str: creacion, longitud, indices y rebanado.

OBJETIVO:
  - Crear cadenas y consultar len() (como Length en C#).
  - Acceder por indice [0] y [-1].
  - Extraer trozos con [inicio:fin] / [inicio:fin:paso] (Substring en C#/Java).
  - Recorrer caracteres con for.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")

"""
PRIMERA PARTE — Crear y medir longitud.
"""
print("¡DEMO 1: len()!\n")
saludo = "Hola mundo"
print("Cadena:", repr(saludo))
print("Longitud:", len(saludo))
print('Vacia "" ->', len(""))

"""
SEGUNDA PARTE — Indices (base 0).
"""
print("\n¡DEMO 2: INDICES!\n")
print("Primer caracter [0]:", saludo[0])
print("Ultimo [-1]:", saludo[-1])
print("Espacio [4]:", repr(saludo[4]))

"""
TERCERA PARTE — Rebanado (slice).
"""
print("\n¡DEMO 3: SLICE!\n")
frase = "Aprender Python en FP"
print("Completa:", frase)
print("[0:8]:", frase[0:8])
print("[9:]:", frase[9:])
print("[-2:]:", frase[-2:])
print("[::2] (de 2 en 2):", frase[::2])

"""
CUARTA PARTE — Recorrido.
"""
print("\n¡DEMO 4: for letra in cadena!\n")
for letra in "Python":
    print(letra, end=" ")
print()

print("\n¡FIN DEL PROGRAMA!\n")
