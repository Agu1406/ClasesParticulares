"""
U06 — Repaso completo de listas.

OBJETIVO:
  - Integrar creacion, CRUD basico, recorridos, filtro y ordenacion.
  - Aplicar el patron: lista de datos -> procesar -> mostrar resultado.
  - Repasar errores frecuentes (indice fuera de rango, alias vs copia).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Mapa mental de operaciones.
"""
print("¡MAPA MENTAL!\n")
print("- Crear: [] o [1, 2, 3]")
print("- Leer: lista[i]  |  longitud: len(lista)")
print("- Agregar: append / insert")
print("- Quitar: remove / pop / clear")
print("- Buscar: in / index / count")
print("- Recorrer: for x in lista  |  enumerate")
print("- Ordenar: sort() (in-place)  |  sorted() (copia)")
print("- Copiar: lista.copy() o lista[:]")

"""
SEGUNDA PARTE — Mini gestion de notas (integrado).
"""
print("\n¡DEMO INTEGRADA: NOTAS!\n")

notas = [7.5, 4.0, 9.0, 5.5, 8.0]
print(f"Notas iniciales: {notas}")

notas.append(6.0)
print(f"Tras append(6.0): {notas}")

aprobados = []
for n in notas:
    if n >= 5:
        aprobados.append(n)
print(f"Aprobados: {aprobados}")
print(f"Media de la clase: {sum(notas) / len(notas):.2f}")
print(f"Mejor nota: {max(notas)}")

ordenadas = sorted(notas, reverse=True)
print(f"De mayor a menor (copia): {ordenadas}")
print(f"Original intacta: {notas}")

"""
TERCERA PARTE — Recordatorio de errores tipicos.
"""
print("\n¡CUIDADO CON!\n")
print("- lista[len(lista)] -> IndexError (el ultimo indice es len-1)")
print("- otra = lista  -> NO es copia; usa .copy()")
print("- remove(x) falla si x no esta; mejor: if x in lista: remove(x)")

# Ejemplo seguro de remove
compras = ["pan", "leche", "huevos"]
producto = "agua"
if producto in compras:
    compras.remove(producto)
else:
    print(f"'{producto}' no estaba en la lista de compras.")
print(f"Compras: {compras}")

print("\n¡FIN DEL PROGRAMA!\n")
