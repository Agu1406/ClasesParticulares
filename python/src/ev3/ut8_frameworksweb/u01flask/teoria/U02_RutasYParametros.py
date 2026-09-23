"""
U02 — Rutas dinamicas, methods GET y query string (request.args).

OBJETIVO:
  - Definir rutas con parametro de path: /hola/<nombre>.
  - Restringir metodos HTTP con methods=['GET'].
  - Leer query params con request.args.get(...).
  - Demostrar sin servidor usando test_request_context.

Requisito: pip install flask

En Spring: @PathVariable / @RequestParam.
En Flask: <nombre> en la URL + request.args.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from flask import Flask, request

print("\n¡INICIO DEL PROGRAMA!\n")

app = Flask(__name__)

"""
PRIMERA PARTE — Parametro de path /hola/<nombre>.
Equivalente a @GetMapping("/hola/{nombre}") + @PathVariable.
"""
print("¡DEMO 1: /hola/<nombre>!\n")


@app.route("/hola/<nombre>", methods=["GET"])
def hola(nombre):
    return f"<p>Hola, {nombre}!</p>"


with app.test_request_context("/hola/Ana"):
    print(f"hola('Ana') -> {hola('Ana')}\n")

"""
SEGUNDA PARTE — Query string con request.args.
URL ejemplo: /edad?valor=20
En Spring: @RequestParam("valor") int valor.
"""
print("¡DEMO 2: request.args!\n")


@app.route("/edad", methods=["GET"])
def edad():
    valor = request.args.get("valor", default="?")
    return f"<p>Edad recibida: {valor}</p>"


with app.test_request_context("/edad?valor=20"):
    print(f"edad() con ?valor=20 -> {edad()}\n")

print("Rutas registradas:")
for regla in app.url_map.iter_rules():
    if regla.endpoint == "static":
        continue
    metodos = ",".join(sorted(m for m in regla.methods if m not in ("HEAD", "OPTIONS")))
    print(f"  {regla.rule}  [{metodos}]  -> {regla.endpoint}")

print("\n¡FIN DEL PROGRAMA!")
