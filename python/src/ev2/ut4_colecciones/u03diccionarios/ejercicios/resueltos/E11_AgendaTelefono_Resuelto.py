"""
OBJETIVO: Agenda Ana->600111222; agrega Eva; imprime todos los pares.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

agenda = {"Ana": "600111222"}
agenda["Eva"] = "600555666"
for nombre, tel in agenda.items():
    print(f"{nombre}: {tel}")
