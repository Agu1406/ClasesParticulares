"""
U03 — Desempaquetado y retorno multiple.

OBJETIVO:
  - Asignar varios nombres a la vez desde una tupla.
  - Usar *resto para capturar el sobrante.
  - Devolver varios valores desde una funcion (en realidad una tupla).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


def obtener_estadisticas(numeros):
    promedio = sum(numeros) / len(numeros)
    maximo = max(numeros)
    minimo = min(numeros)
    return promedio, maximo, minimo


print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Desempaquetado basico.
"""
print("¡DEMO 1: DESEMPAQUETAR!\n")

persona = ("Juan", 25, "Ingeniero")
nombre, edad, profesion = persona
print(f"Nombre: {nombre}")
print(f"Edad: {edad}")
print(f"Profesion: {profesion}")

"""
SEGUNDA PARTE — *resto.
"""
print("\n¡DEMO 2: *RESTO!\n")

valores = (1, 2, 3, 4, 5)
primero, *medio, ultimo = valores
print(f"primero={primero}, medio={medio}, ultimo={ultimo}")

"""
TERCERA PARTE — Varios valores de retorno.
"""
print("\n¡DEMO 3: RETURN MULTIPLE!\n")

datos = [5, 3, 9, 2, 7]
prom, maxi, mini = obtener_estadisticas(datos)
print(f"Datos: {datos}")
print(f"Promedio: {prom}, Maximo: {maxi}, Minimo: {mini}")

print("\n¡FIN DEL PROGRAMA!\n")
