"""
U03 — Formato de cadenas: f-strings y plantillas.

OBJETIVO:
  - f"...{variable}..." es la forma recomendada en Python moderno.
  - Formato de numeros: decimales, anchura, alineacion.
  - :< izquierda, :> derecha, :^ centro (util para tablas).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")

nombre = "Elena"
nota = 8.456
horas = 3

"""
PRIMERA PARTE — f-strings y decimales.
"""
print("¡DEMO 1: f-strings!\n")
print(f"Alumna: {nombre}, nota: {nota}")
print(f"Nota con 1 decimal: {nota:.1f}")
print(f"Nota con 2 decimales: {nota:.2f}")
print(f"¿Aprobado? {nota >= 5}")

"""
SEGUNDA PARTE — Anchura y alineacion: < > ^
  {texto:<10}  izquierda en 10 caracteres
  {texto:>10}  derecha
  {texto:^10}  centro
  {num:^10.2f} centro + 2 decimales
"""
print("\n¡DEMO 2: ALINEACION!\n")

print(f"{'Producto':<12} {'Precio':>8}")
print(f"{'Teclado':<12} {19.99:>8.2f}")

print()
print(f"{'Etiqueta':<10}|{'A':^10}|{'B':^10}|{'C':^10}|")
a, b, c = 1.5, 2.0, 3.25
print(f"{'Original':<10}|{a:^10.2f}|{b:^10.2f}|{c:^10.2f}|")
print(f"{'Cuadrado':<10}|{(a**2):^10.2f}|{(b**2):^10.2f}|{(c**2):^10.2f}|")

"""
TERCERA PARTE — Multilinea y format().
"""
print("\n¡DEMO 3: OTROS!\n")

mensaje = f"""
Hola {nombre},
Has estudiado {horas} horas hoy.
Sigue asi.
"""
print(mensaje.strip())
print("Hola {}, nota {:.1f}".format(nombre, nota))

print("\n¡FIN DEL PROGRAMA!\n")
