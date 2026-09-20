"""
U06 — Repaso completo de diccionarios.

OBJETIVO:
  - Integrar CRUD, recorridos, conteo y anidados.
  - Comparar mentalmente con HashMap (Java) y Dictionary (C#).
  - Repasar errores tipicos (KeyError, confundir keys con values).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Mapa mental (paridad Java/C#).
"""
print("¡MAPA MENTAL!\n")
print("- Crear: {} o {'Ana': 20}")
print("- Leer: d[k]  |  seguro: d.get(k, defecto)")
print("- Existe: k in d  (containsKey)")
print("- Escribir: d[k] = v  (put / indexador)")
print("- Quitar: pop(k) / del d[k]")
print("- Recorrer: items() / keys() / values()")
print("- Contar: d[k] = d.get(k, 0) + 1")

"""
SEGUNDA PARTE — Mini agenda.
"""
print("\n¡DEMO INTEGRADA: AGENDA!\n")

agenda = {"Ana": "600111222", "Luis": "600333444"}
agenda["Eva"] = "600555666"
agenda["Luis"] = "600999000"

for nombre, telefono in agenda.items():
    print(f"{nombre}: {telefono}")

buscado = "Pedro"
print(f"{buscado}: {agenda.get(buscado, 'No esta en la agenda')}")

"""
TERCERA PARTE — Errores tipicos.
"""
print("\n¡CUIDADO CON!\n")
print("- d['clave_inexistente'] -> KeyError; usa get o 'in'")
print("- Las claves deben ser inmutables (str, int, tupla; no lista)")
print("- update sobrescribe claves repetidas")

print("\n¡FIN DEL PROGRAMA!\n")
