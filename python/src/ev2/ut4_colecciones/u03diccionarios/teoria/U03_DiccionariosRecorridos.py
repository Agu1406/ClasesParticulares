"""
U03 — Recorridos de diccionarios.

OBJETIVO:
  - Recorrer pares con items() (como entrySet / KeyValuePair).
  - Recorrer solo keys() o solo values().
  - Aplicar logica durante el recorrido (filtrar, sumar).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — items().
"""
print("¡DEMO 1: items()!\n")

notas = {"Matematicas": 7, "Lengua": 8, "Historia": 6}
for asignatura, nota in notas.items():
    print(f"  {asignatura} -> {nota}")

"""
SEGUNDA PARTE — keys() y values().
"""
print("\n¡DEMO 2: keys() Y values()!\n")

print("Claves:")
for clave in notas.keys():
    print(f"  {clave}")

print("Valores:")
for valor in notas.values():
    print(f"  {valor}")

"""
TERCERA PARTE — Logica en el recorrido.
"""
print("\n¡DEMO 3: FILTRAR Y SUMAR!\n")

print("Aprobados (>= 5):")
for asignatura, nota in notas.items():
    if nota >= 5:
        print(f"  {asignatura}: {nota}")

suma = 0
for nota in notas.values():
    suma += nota
print(f"Suma de notas: {suma}")
print(f"Media: {suma / len(notas):.2f}")

print("\n¡FIN DEL PROGRAMA!\n")
