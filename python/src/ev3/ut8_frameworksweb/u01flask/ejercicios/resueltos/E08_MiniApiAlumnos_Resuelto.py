"""
OBJETIVO: Mini-API en memoria: GET '/api/alumnos' (lista) y GET '/api/alumnos/<id>' (uno o 404).
SOLUCION: lista en memoria + jsonify; demo con test_client (sin servidor).
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
    return jsonify(ALUMNOS)


@app.route("/api/alumnos/<int:alumno_id>")
def por_id(alumno_id):
    for alumno in ALUMNOS:
        if alumno["id"] == alumno_id:
            return jsonify(alumno)
    return jsonify({"error": "no encontrado"}), 404


if __name__ == "__main__":
    cliente = app.test_client()
    print("GET /api/alumnos ->", cliente.get("/api/alumnos").get_json())
    r1 = cliente.get("/api/alumnos/1")
    print(f"GET /api/alumnos/1 -> {r1.get_json()} status={r1.status_code}")
    r99 = cliente.get("/api/alumnos/99")
    print(f"GET /api/alumnos/99 -> {r99.get_json()} status={r99.status_code}")
