"""
U02 — Funciones de orden superior (HOF).

OBJETIVO:
  - Recibir una funcion como argumento (aplicar, filtrar, transformar).
  - Devolver una funcion (fabrica / cierre / decorador simple).
  - Ver que en Python las funciones son objetos de primera clase.

En Java: Predicate, Function, Consumer, Supplier + interfaces SAM.
En Python: cualquier callable (def o lambda) se pasa/devuelve sin interfaz.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


def aplicar(operacion, a, b):
    """Recibe una funcion binaria y la ejecuta con a y b."""
    return operacion(a, b)


def filtrar(lista, predicado):
    """Equivalente informal a stream().filter(Predicate)."""
    return [x for x in lista if predicado(x)]


def fabricar_multiplicador(factor):
    """Devuelve una funcion que multiplica por factor (cierre)."""
    def multiplicar(n):
        return n * factor
    return multiplicar


print("\n¡INICIO DEL PROGRAMA!\n")

"""
PRIMERA PARTE — Funciones que reciben funciones.
"""
print("¡DEMO 1: RECIBIR FUNCIONES!\n")

suma = lambda x, y: x + y
resta = lambda x, y: x - y
print(f"aplicar(suma, 2, 6)  -> {aplicar(suma, 2, 6)}")
print(f"aplicar(resta, 10, 5) -> {aplicar(resta, 10, 5)}")
print(f"aplicar(lambda, 6, 7) -> {aplicar(lambda x, y: x * y, 6, 7)}")

palabras = ["pf", "java", "lambda", "stream"]
largas = filtrar(palabras, lambda p: len(p) > 4)
print(f"filtrar largas: {largas}\n")

"""
SEGUNDA PARTE — Funciones que devuelven funciones.
"""
print("¡DEMO 2: DEVOLVER FUNCIONES!\n")

por_diez = fabricar_multiplicador(10)
por_dos = fabricar_multiplicador(2)
print(f"por_diez(3) -> {por_diez(3)}")
print(f"por_dos(8)  -> {por_dos(8)}")

# Supplier informal: callable sin argumentos
mensaje = lambda: "Programacion funcional"
print(f"supplier: {mensaje()}")

# Consumer informal: callable que no "devuelve" valor util
imprimir = lambda texto: print(f">> {texto}")
imprimir("Consumer de ejemplo")

print("\n¡FIN DEL PROGRAMA!")
