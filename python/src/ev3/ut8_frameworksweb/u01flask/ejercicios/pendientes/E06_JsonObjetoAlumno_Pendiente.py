"""
OBJETIVO: GET '/api/alumno' devuelve JSON {"nombre": "Ana", "nota": 8.5}.
Requisito: pip install flask

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from flask import Flask, jsonify

app = Flask(__name__)


@app.route("/api/alumno")
def alumno():
    # TODO: return jsonify({"nombre": "Ana", "nota": 8.5})
    pass


if __name__ == "__main__":
    # TODO: test_client.get("/api/alumno") e imprimir get_json()
    pass
