"""
OBJETIVO: GET '/saludo/<nombre>' que devuelva "Hola, {nombre}".
SOLUCION: parametro de path + test_client.
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
    return f"Hola, {nombre}"


if __name__ == "__main__":
    cliente = app.test_client()
    resp = cliente.get("/saludo/Ana")
    print(resp.get_data(as_text=True))
    print(f"status={resp.status_code}")
