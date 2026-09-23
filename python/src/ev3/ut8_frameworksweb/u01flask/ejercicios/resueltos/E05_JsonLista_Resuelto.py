"""
OBJETIVO: GET '/api/lenguajes' devuelve JSON ["Python", "Java", "C#"] con jsonify.
SOLUCION: jsonify + test_client.get_json().
Requisito: pip install flask

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from flask import Flask, jsonify

app = Flask(__name__)


@app.route("/api/lenguajes")
def lenguajes():
    return jsonify(["Python", "Java", "C#"])


if __name__ == "__main__":
    cliente = app.test_client()
    resp = cliente.get("/api/lenguajes")
    print(resp.get_json())
    print(f"status={resp.status_code}")
