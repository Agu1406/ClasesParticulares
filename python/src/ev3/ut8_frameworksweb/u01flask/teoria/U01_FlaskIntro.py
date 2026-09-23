"""
U01 — Introduccion a Flask: app, ruta raiz y respuesta HTML.

OBJETIVO:
  - Crear Flask(__name__) y registrar una ruta con @app.route('/').
  - Devolver un string HTML simple desde la vista.
  - Relacionar con Spring: @Controller / @GetMapping vs decorador @app.route.
  - Ejecutar demos SIN bloquear con app.run (imprimir rutas registradas).

Requisito: pip install flask

En Spring MVC: @Controller + @GetMapping("/") + return "vista" o ResponseEntity.
En Flask: Flask(__name__) + @app.route('/') + return "<h1>...</h1>".

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from flask import Flask

print("\n¡INICIO DEL PROGRAMA!\n")

"""
PRIMERA PARTE — Crear la aplicacion Flask.
Flask(__name__) usa el nombre del modulo para localizar recursos (templates, static).
Equivalente pedagogico a arrancar un contexto web en Spring Boot (@SpringBootApplication).
"""
print("¡DEMO 1: Flask(__name__)!\n")
app = Flask(__name__)
print(f"Tipo de app: {type(app).__name__}")
print(f"Nombre del modulo: {app.name}\n")

"""
SEGUNDA PARTE — Ruta raiz con @app.route('/').
En Spring: @GetMapping("/") en un @Controller.
En Flask: el decorador asocia la URL al handler (funcion de vista).
"""
print("¡DEMO 2: @app.route('/')!\n")


@app.route("/")
def index():
    return "<h1>Hola Flask</h1><p>UT8 — Frameworks web</p>"


print("Handler 'index' registrado en '/'.\n")

"""
TERCERA PARTE — Invocar la vista sin servidor HTTP.
test_request_context simula una peticion; no abre puerto ni bloquea.
"""
print("¡DEMO 3: test_request_context (sin app.run)!\n")
with app.test_request_context("/"):
    html = index()
    print(f"Respuesta de index(): {html}\n")

print("Rutas registradas:")
for regla in app.url_map.iter_rules():
    metodos = ",".join(sorted(m for m in regla.methods if m not in ("HEAD", "OPTIONS")))
    print(f"  {regla.rule}  [{metodos}]  -> {regla.endpoint}")

print("\n# Opcional — descomenta para servir en http://127.0.0.1:5000/")
print("# app.run(debug=True)")
# app.run(debug=True)  # descomenta para servir

print("\n¡FIN DEL PROGRAMA!")
