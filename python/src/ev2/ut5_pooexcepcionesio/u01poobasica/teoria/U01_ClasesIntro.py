"""
U01 — Clases y objetos.

OBJETIVO:
  - Distinguir clase (plantilla) de objeto (instancia concreta).
  - Definir atributos en la clase y crear objetos con NombreClase().
  - Acceder a atributos con punto: objeto.atributo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""


class Coche:
    # Atributos de instancia: cada objeto tendra los suyos.
    marca = ""
    velocidad = 0


print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE — Crear un objeto y asignar atributos.
"""
print("¡DEMO 1: UN COCHE!\n")
coche1 = Coche()
coche1.marca = "Toyota"
coche1.velocidad = 90
print(coche1.marca, "a", coche1.velocidad, "km/h")

"""
SEGUNDA PARTE — Varios objetos independientes.
"""
print("\n¡DEMO 2: DOS COCHES!\n")
coche2 = Coche()
coche2.marca = "Renault"
coche2.velocidad = 60
print(coche1.marca, coche1.velocidad)
print(coche2.marca, coche2.velocidad)

print("\n¡FIN DEL PROGRAMA!\n")
