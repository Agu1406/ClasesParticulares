"""
U01 — Entrada de datos con input().

"Entrada de datos" o "input" se refiere a la capacidad que tenemos de escribír
código capaz de recibir datos desde "el teclado" (nuestro dispositivo), así
podemos introducir datos al programa.

OBJETIVO:
  - input() lee texto del teclado (siempre devuelve str).
  - Convertir con int(), float(), bool() cuando haga falta.
  - Validar datos simples antes de calcular.

NOTA DIDACTICA:
  Este bloque usa valores fijos para que puedas ejecutarlo sin teclear.
  Descomenta el bloque "VERSION INTERACTIVA" para practicar con input().

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""
print("\nINICIO DEL PROGRAMA\n")
"""
PRIMERA PARTE: Primer uso de la función nativa "input()
"""

# Dentro del parantesís de "input()" escribimos un mensaje que indica que dato esperamos.
nombre = input("¿Cual es tú nombre?: ")
edad = input("¿Cual es tú edad?: ")
altura = input("¿Cual es tú altura?: ")
es_humano = input("¿Eres humano?: ")
print()

# Todos los datos que capturamos con "input()" son del tipo "str".
print(
  f"¡Datos introducidos en el programa! \n"
  f"Nombre: {nombre} | tipo: {type(nombre)}. \n"
  f"Edad: {edad} años | tipo: {type(edad)}. \n"
  f"Altura: {altura} centimetros | tipo: {type(altura)}. \n"
  f"¿Humano?: {es_humano} | tipo: {type(es_humano)}. \n"
)

"""
SEGUNDA PARTE: Conversión de tipos de los datos recibidos con "input()" 
"""

# Si queremos usar los datos en el programa es probable que haya que trasnformalos.
edad_int = int(edad)
altura_float = float(altura)
es_humano_bool = bool(es_humano)

# De esta forma, si cumplo años, crezco algunos centimetros o me convierto en cyborg puedo modificar los datos.
edad_int = edad_int + 1
altura_float = altura_float + 0.02
es_humano_bool = False

print(
  f"¡Datos convertidos y modificados en el programa! \n"
  f"Nombre: {nombre} | tipo: {type(nombre)}. \n"
  f"Edad: {edad_int} años | tipo: {type(edad_int)}. \n"
  f"Altura: {altura_float} centimetros | tipo: {type(altura_float)}. \n"
  f"¿Humano?: {es_humano_bool} | tipo: {type(es_humano_bool)}. \n"
)

print("\nFIN DEL PROGRAMA\n")