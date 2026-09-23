"""
OBJETIVO: Anade GET '/about' que devuelva "Sobre UT8 Flask".
Requisito: pip install flask

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from flask import Flask

app = Flask(__name__)


@app.route("/about")
def about():
    # TODO: return "Sobre UT8 Flask"
    pass


if __name__ == "__main__":
    # TODO: probar con test_client.get("/about")
    pass
