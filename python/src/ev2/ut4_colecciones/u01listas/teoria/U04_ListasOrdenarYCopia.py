"""
U04 — Ordenar, invertir y copiar listas.

OBJETIVO:
  - Ordenar in-place con sort() y obtener copia ordenada con sorted().
  - Invertir el orden con reverse() / reversed.
  - Copiar bien (lista.copy() o lista[:]) para no compartir la misma lista.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — sort() modifica la lista original.
"""
print("¡DEMO 1: sort() IN-PLACE!\n")

nums = [5, 2, 8, 1]
print(f"Antes: {nums}")
nums.sort()
print(f"Tras sort(): {nums}")

nums.sort(reverse=True)
print(f"Tras sort(reverse=True): {nums}")

"""
SEGUNDA PARTE — sorted() devuelve una lista nueva; la original no cambia.
"""
print("\n¡DEMO 2: sorted() COPIA ORDENADA!\n")

original = [5, 2, 8, 1]
ordenada = sorted(original)
print(f"Original: {original}")
print(f"Ordenada: {ordenada}")

"""
TERCERA PARTE — reverse() invierte el orden actual (no ordena).
"""
print("\n¡DEMO 3: reverse()!\n")

letras = ["c", "a", "b"]
print(f"Antes: {letras}")
letras.reverse()
print(f"Tras reverse(): {letras}")

"""
CUARTA PARTE — Copiar vs alias.
  otra = lista NO copia: las dos variables apuntan a la misma lista.
  lista.copy() o lista[:] si crean una copia independiente.
"""
print("\n¡DEMO 4: COPIA VS ALIAS!\n")

a = [1, 2, 3]
alias = a
copia = a.copy()

alias.append(99)
print(f"a tras modificar alias: {a}")
print(f"copia (no afectada): {copia}")

b = a[:]
b.append(7)
print(f"a tras modificar b = a[:]: {a}")
print(f"b: {b}")

print("\n¡FIN DEL PROGRAMA!\n")
