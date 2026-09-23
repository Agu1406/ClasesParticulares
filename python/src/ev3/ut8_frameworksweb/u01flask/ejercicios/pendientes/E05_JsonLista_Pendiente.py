"""
OBJETIVO: GET '/api/lenguajes' devuelve JSON ["Python", "Java", "C#"] con jsonify.
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
    # TODO: return jsonify(["Python", "Java", "C#"])
    pass


if __name__ == "__main__":
    # TODO: test_client.get("/api/lenguajes") e imprimir get_json()
    pass
