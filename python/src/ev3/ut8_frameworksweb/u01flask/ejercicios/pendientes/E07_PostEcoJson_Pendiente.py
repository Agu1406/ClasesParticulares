"""
OBJETIVO: POST '/api/eco' lee JSON del cuerpo y responde {"recibido": <datos>}.
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
    # TODO: datos = request.get_json(silent=True) or {}; return jsonify({"recibido": datos})
    pass


if __name__ == "__main__":
    # TODO: test_client.post("/api/eco", json={"msg": "hola"})
    pass
