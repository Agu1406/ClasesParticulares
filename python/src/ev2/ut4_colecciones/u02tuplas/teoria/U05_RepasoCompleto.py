"""
U05 — Repaso completo de tuplas.

OBJETIVO:
  - Repasar cuando usar tupla frente a lista.
  - Integrar acceso, operaciones, desempaquetado y conversion.
  - Recordar errores tipicos (asignar a un indice, olvidar la coma).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Mapa mental.
"""
print("¡MAPA MENTAL!\n")
print("- Crear: (1, 2)  |  un elemento: (1,)")
print("- Leer: t[i]  |  len(t)  |  in / index / count")
print("- No modificar: sin append, sin t[i] = ...")
print("- Desempaquetar: a, b = (1, 2)")
print("- Convertir: tuple(lista) / list(tupla)")
print("- Uso tipico: coordenadas, return multiple, claves de dict")

"""
SEGUNDA PARTE — Mini caso: ciudades y coordenadas.
"""
print("\n¡DEMO INTEGRADA: CIUDADES!\n")

ciudades = (
    ("Sevilla", 37.39, -5.99),
    ("Madrid", 40.42, -3.70),
    ("Barcelona", 41.39, 2.17),
)

for nombre, lat, lon in ciudades:
    print(f"{nombre}: lat={lat}, lon={lon}")

"""
TERCERA PARTE — Errores tipicos.
"""
print("\n¡CUIDADO CON!\n")
print("- (42) no es tupla; usa (42,)")
print("- t[0] = 1 lanza TypeError")
print("- Para 'cambiar' una tupla: list(t) -> modificar -> tuple(...)")

print("\n¡FIN DEL PROGRAMA!\n")
