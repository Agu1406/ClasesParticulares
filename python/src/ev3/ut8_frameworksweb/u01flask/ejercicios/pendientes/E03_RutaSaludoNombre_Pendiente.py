"""
OBJETIVO: GET '/saludo/<nombre>' que devuelva "Hola, {nombre}".
Requisito: pip install flask

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from flask import Flask

app = Flask(__name__)


@app.route("/saludo/<nombre>")
def saludo(nombre):
    # TODO: return f"Hola, {nombre}"
    pass


if __name__ == "__main__":
    # TODO: test_client.get("/saludo/Ana")
    pass
