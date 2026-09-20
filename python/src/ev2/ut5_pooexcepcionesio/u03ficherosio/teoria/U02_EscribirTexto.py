"""
U02 — Escribir texto en ficheros.

OBJETIVO:
  - Escribir con open(..., "w") (sobrescribe).
  - Anadir al final con open(..., "a") sin borrar lo anterior.
  - Usar encoding="utf-8" (tildes, ñ).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — "w" crea o SOBRESCRIBE.
"""
print("¡DEMO 1: MODO w!\n")

fichero = open("escritura_demo.txt", "w", encoding="utf-8")
fichero.write("Linea 1: primera escritura\n")
fichero.close()

fichero = open("escritura_demo.txt", "r", encoding="utf-8")
print(fichero.read())
fichero.close()

"""
SEGUNDA PARTE — "a" anade al final.
"""
print("¡DEMO 2: MODO a (append)!\n")

fichero = open("escritura_demo.txt", "a", encoding="utf-8")
fichero.write("Linea 2: anadida con append\n")
fichero.write("Linea 3: otra linea\n")
fichero.close()

fichero = open("escritura_demo.txt", "r", encoding="utf-8")
print(fichero.read())
fichero.close()

"""
TERCERA PARTE — Otro "w" borra lo anterior.
"""
print("¡DEMO 3: w OTRA VEZ!\n")

fichero = open("escritura_demo.txt", "w", encoding="utf-8")
fichero.write("Solo queda esta linea (sobrescrito)\n")
fichero.close()

fichero = open("escritura_demo.txt", "r", encoding="utf-8")
print(fichero.read())
fichero.close()

print("¡FIN DEL PROGRAMA!\n")
