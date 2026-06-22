"""
U03 — Formato de cadenas: f-strings y plantillas.

OBJETIVO:
  - f"...{variable}..." es la forma recomendada en Python moderno.
  - Formato de numeros: decimales, anchura, porcentaje.
  - Escapar llaves duplicandolas: {{ }}

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

nombre = "Elena"
nota = 8.456
horas = 3

# print(): f-string inserta variables nombre y nota en el texto
print(f"Alumna: {nombre}, nota: {nota}")

# print(): :.1f formatea nota con un decimal fijo
print(f"Nota con 1 decimal: {nota:.1f}")
# print(): :.2f formatea nota con dos decimales
print(f"Nota con 2 decimales: {nota:.2f}")

# print(): dentro de {} se puede poner una expresion booleana
print(f"¿Aprobado? {nota >= 5}")

# print(): :<12 alinea a la izquierda en 12 caracteres; :>8 a la derecha
print(f"{'Producto':<12} {'Precio':>8}")
# print(): :>8.2f alinea el precio a la derecha con 2 decimales
print(f"{'Teclado':<12} {19.99:>8.2f}")

# f-string multilinea: las triple comillas permiten varias lineas
mensaje = f"""
Hola {nombre},
Has estudiado {horas} horas hoy.
Sigue asi.
"""
# strip(): quita saltos de linea iniciales/finales del bloque multilinea
print(mensaje.strip())

# format(): metodo clasico; {} son marcadores reemplazados por argumentos
print("Hola {}, nota {:.1f}".format(nombre, nota))
