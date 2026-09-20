"""
U02 — Operaciones con listas (agregar, eliminar, buscar).

OBJETIVO:
  - Agregar con append (al final) e insert (en una posicion).
  - Eliminar con remove (por valor), pop (por indice) y clear.
  - Comprobar existencia con in y localizar con index / count.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — append e insert.
  append(x) anade al final.
  insert(i, x) inserta en la posicion i (el resto se desplaza).
"""
print("¡DEMO 1: AGREGAR!\n")

nombres = ["Ana", "Luis", "Marta"]
print(f"Inicial: {nombres}")

nombres.append("Eva")
print(f"Tras append('Eva'): {nombres}")

nombres.insert(1, "Pedro")
print(f"Tras insert(1, 'Pedro'): {nombres}")

"""
SEGUNDA PARTE — remove, pop y clear.
  remove(valor) elimina la primera coincidencia.
  pop() elimina el ultimo; pop(i) elimina en la posicion i.
  clear() vacia toda la lista.
"""
print("\n¡DEMO 2: ELIMINAR!\n")

nombres.remove("Luis")
print(f"Tras remove('Luis'): {nombres}")

ultimo = nombres.pop()
print(f"pop() devolvio: {ultimo}")
print(f"Lista tras pop(): {nombres}")

sacado = nombres.pop(0)
print(f"pop(0) devolvio: {sacado}")
print(f"Lista tras pop(0): {nombres}")

nombres.clear()
print(f"Tras clear(): {nombres} (longitud {len(nombres)})")

"""
TERCERA PARTE — in, index y count.
  valor in lista -> True/False.
  index(valor) -> primera posicion.
  count(valor) -> cuantas veces aparece.
"""
print("\n¡DEMO 3: BUSCAR!\n")

nums = [5, 2, 8, 2, 1]
print(f"Lista: {nums}")
print(f"8 in nums -> {8 in nums}")
print(f"99 in nums -> {99 in nums}")
print(f"index(2) -> {nums.index(2)}")
print(f"count(2) -> {nums.count(2)}")

if 2 in nums:
    print("El numero 2 esta en la lista.")
else:
    print("El numero 2 no esta.")

print("\n¡FIN DEL PROGRAMA!\n")
