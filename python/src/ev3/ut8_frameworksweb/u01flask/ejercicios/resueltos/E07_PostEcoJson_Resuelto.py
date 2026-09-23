"""
OBJETIVO: POST '/api/eco' lee JSON del cuerpo y responde {"recibido": <datos>}.
SOLUCION: request.get_json + jsonify; demo con test_client.post(json=...).
Requisito: pip install flask

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from flask import Flask, jsonify, request

app = Flask(__name__)


@app.route("/api/eco", methods=["POST"])
def eco():
    datos = request.get_json(silent=True) or {}
    return jsonify({"recibido": datos})


if __name__ == "__main__":
    cliente = app.test_client()
    resp = cliente.post("/api/eco", json={"msg": "hola"})
    print(resp.get_json())
    print(f"status={resp.status_code}")
