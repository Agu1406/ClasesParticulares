"""
U03 — JSON con jsonify y cuerpo POST (get_json / form).

OBJETIVO:
  - Devolver JSON con jsonify (lista u objeto).
  - Leer JSON del cuerpo con request.get_json().
  - Mencionar request.form para datos application/x-www-form-urlencoded.
  - Simular POST con test_request_context (sin servidor bloqueante).

Requisito: pip install flask

En Spring: @ResponseBody / @RequestBody + Jackson.
En Flask: jsonify + request.get_json().

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from flask import Flask, jsonify, request

print("\n¡INICIO DEL PROGRAMA!\n")

app = Flask(__name__)

"""
PRIMERA PARTE — jsonify: respuesta JSON tipica de API.
Content-Type application/json automatico.
"""
print("¡DEMO 1: jsonify!\n")


@app.route("/api/frutas", methods=["GET"])
def frutas():
    return jsonify(["manzana", "pera", "uva"])


with app.test_request_context("/api/frutas"):
    resp = frutas()
    print(f"Status: {resp.status_code}")
    print(f"JSON: {resp.get_json()}\n")

"""
SEGUNDA PARTE — POST conceptual con request.get_json().
test_request_context puede inyectar json=... sin abrir puerto.
"""
print("¡DEMO 2: POST + request.get_json()!\n")


@app.route("/api/eco", methods=["POST"])
def eco():
    datos = request.get_json(silent=True) or {}
    return jsonify({"recibido": datos})


with app.test_request_context(
    "/api/eco",
    method="POST",
    json={"nombre": "Ana", "nota": 8.5},
):
    resp = eco()
    print(f"Eco JSON: {resp.get_json()}\n")

"""
TERCERA PARTE — request.form (formulario HTML clasico).
Equivalente pedagogico a parametros de formulario, no JSON.
"""
print("¡DEMO 3: request.form (conceptual)!\n")


@app.route("/form/saludo", methods=["POST"])
def saludo_form():
    nombre = request.form.get("nombre", "anonimo")
    return f"<p>Hola desde form: {nombre}</p>"


with app.test_request_context(
    "/form/saludo",
    method="POST",
    data={"nombre": "Luis"},
):
    print(f"saludo_form() -> {saludo_form()}\n")

print("Rutas registradas:")
for regla in app.url_map.iter_rules():
    if regla.endpoint == "static":
        continue
    metodos = ",".join(sorted(m for m in regla.methods if m not in ("HEAD", "OPTIONS")))
    print(f"  {regla.rule}  [{metodos}]  -> {regla.endpoint}")

print("\n¡FIN DEL PROGRAMA!")
