"""
OBJETIVO: Mini-API en memoria: GET '/api/alumnos' (lista) y GET '/api/alumnos/<id>' (uno o 404).
Datos iniciales: [{id:1,nombre:Ana,nota:8.5}, {id:2,nombre:Luis,nota:6.0}].
Requisito: pip install flask

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

from flask import Flask, jsonify

app = Flask(__name__)

ALUMNOS = [
    {"id": 1, "nombre": "Ana", "nota": 8.5},
    {"id": 2, "nombre": "Luis", "nota": 6.0},
]


@app.route("/api/alumnos")
def listar():
    # TODO: return jsonify(ALUMNOS)
    pass


@app.route("/api/alumnos/<int:alumno_id>")
def por_id(alumno_id):
    # TODO: buscar por id; si existe jsonify(alumno), si no ({"error": "no encontrado"}, 404)
    pass


if __name__ == "__main__":
    # TODO: test_client: GET lista y GET /api/alumnos/1 y /api/alumnos/99
    pass
