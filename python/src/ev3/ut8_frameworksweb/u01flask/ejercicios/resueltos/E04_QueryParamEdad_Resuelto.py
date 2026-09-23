"""
OBJETIVO: GET '/info' lee query ?edad= y responde "Edad: {edad}" (o "Edad: ?" si falta).
SOLUCION: request.args.get + test_client.
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
    edad = request.args.get("edad", "?")
    return f"Edad: {edad}"


if __name__ == "__main__":
    cliente = app.test_client()
    resp = cliente.get("/info?edad=20")
    print(resp.get_data(as_text=True))
    print(f"status={resp.status_code}")
    resp2 = cliente.get("/info")
    print(resp2.get_data(as_text=True))
