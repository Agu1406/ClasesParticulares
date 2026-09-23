"""
OBJETIVO: GET '/api/alumno' devuelve JSON {"nombre": "Ana", "nota": 8.5}.
SOLUCION: jsonify de dict + test_client.
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
    return jsonify({"nombre": "Ana", "nota": 8.5})


if __name__ == "__main__":
    cliente = app.test_client()
    resp = cliente.get("/api/alumno")
    print(resp.get_json())
    print(f"status={resp.status_code}")
