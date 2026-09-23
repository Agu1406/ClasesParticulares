"""
OBJETIVO: GET '/info' lee query ?edad= y responde "Edad: {edad}" (o "Edad: ?" si falta).
Requisito: pip install flask

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from flask import Flask, request

app = Flask(__name__)


@app.route("/info")
def info():
    # TODO: edad = request.args.get("edad", "?"); return f"Edad: {edad}"
    pass


if __name__ == "__main__":
    # TODO: test_client.get("/info?edad=20")
    pass
