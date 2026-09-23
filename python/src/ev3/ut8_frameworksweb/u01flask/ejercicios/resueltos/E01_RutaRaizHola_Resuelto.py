"""
OBJETIVO: Crea una app Flask con ruta GET '/' que devuelva el texto "Hola Flask".
SOLUCION: @app.route('/') + return string; demo con test_client.
Requisito: pip install flask

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from flask import Flask

app = Flask(__name__)


@app.route("/")
def index():
    return "Hola Flask"


if __name__ == "__main__":
    cliente = app.test_client()
    resp = cliente.get("/")
    print(resp.get_data(as_text=True))
    print(f"status={resp.status_code}")
