"""
OBJETIVO: Crea una app Flask con ruta GET '/' que devuelva el texto "Hola Flask".
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
    # TODO: return "Hola Flask"
    pass


if __name__ == "__main__":
    # TODO: imprimir rutas o probar con test_client (sin app.run)
    pass
