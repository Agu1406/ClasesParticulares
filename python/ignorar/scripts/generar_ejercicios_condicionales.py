#!/usr/bin/env python3
"""Regenera los 10 ejercicios de u01condicionales con todos los tipos."""
from pathlib import Path

BASE = (
    Path(__file__).resolve().parents[2]
    / "src/ev1/ut2_controlflujometodos/u01condicionales/ejercicios"
)
AUTHOR = """Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
"""

EXERCISES = [
    {
        "id": "E01",
        "name": "ParOImpar",
        "tipo": "if / else",
        "obj": "Lee un entero y di si es par o impar.",
        "pendiente": 'numero = int(input("Numero: "))\n# TODO: if / else con operador %\n',
        "resuelto": (
            'numero = int(input("Numero: "))\n'
            "if numero % 2 == 0:\n"
            '    print(f"{numero} es par")\n'
            "else:\n"
            '    print(f"{numero} es impar")\n'
        ),
    },
    {
        "id": "E02",
        "name": "NotaTexto",
        "tipo": "if / elif / else",
        "obj": "Nota 0-10: >=9 SB, >=7 NT, >=5 AP, si no SS.",
        "pendiente": 'nota = float(input("Nota: "))\n# TODO: cadena if / elif / else\n',
        "resuelto": (
            'nota = float(input("Nota: "))\n'
            "if nota >= 9:\n"
            '    print("Sobresaliente")\n'
            "elif nota >= 7:\n"
            '    print("Notable")\n'
            "elif nota >= 5:\n"
            '    print("Aprobado")\n'
            "else:\n"
            '    print("Suspenso")\n'
        ),
    },
    {
        "id": "E03",
        "name": "MayorDeEdad",
        "tipo": "if / else",
        "obj": "Pide edad. Imprime Mayor o Menor segun >= 18.",
        "pendiente": 'edad = int(input("Edad: "))\n# TODO: if / else\n',
        "resuelto": (
            'edad = int(input("Edad: "))\n'
            "if edad >= 18:\n"
            '    print("Mayor")\n'
            "else:\n"
            '    print("Menor")\n'
        ),
    },
    {
        "id": "E04",
        "name": "SignoNumero",
        "tipo": "if / elif / else",
        "obj": "Entero: positivo, negativo o cero (tres ramas).",
        "pendiente": 'n = int(input("n: "))\n# TODO: if / elif / else\n',
        "resuelto": (
            'n = int(input("n: "))\n'
            "if n > 0:\n"
            '    print("positivo")\n'
            "elif n < 0:\n"
            '    print("negativo")\n'
            "else:\n"
            '    print("cero")\n'
        ),
    },
    {
        "id": "E05",
        "name": "SoloIfStock",
        "tipo": "if (sin else)",
        "obj": "Si stock > 0 imprime Hay producto. Si no, no imprimas nada.",
        "pendiente": "stock = int(input(\"Stock: \"))\n# TODO: solo if, sin else\n",
        "resuelto": (
            'stock = int(input("Stock: "))\n'
            "if stock > 0:\n"
            '    print("Hay producto")\n'
        ),
    },
    {
        "id": "E06",
        "name": "AccesoAnd",
        "tipo": "if + and",
        "obj": 'Si usuario admin Y clave 1234 imprime OK, si no ERROR.',
        "pendiente": 'u = input("Usuario: ")\nc = input("Clave: ")\n# TODO: if con and\n',
        "resuelto": (
            'u = input("Usuario: ")\n'
            'c = input("Clave: ")\n'
            'if u == "admin" and c == "1234":\n'
            '    print("OK")\n'
            "else:\n"
            '    print("ERROR")\n'
        ),
    },
    {
        "id": "E07",
        "name": "FinDeSemana",
        "tipo": "if / elif + in",
        "obj": "Dia 1-7: 6 o 7 fin de semana, si no laborable.",
        "pendiente": 'dia = int(input("Dia (1-7): "))\n# TODO: if / elif con in (6, 7)\n',
        "resuelto": (
            'dia = int(input("Dia (1-7): "))\n'
            "if dia in (6, 7):\n"
            '    print("fin de semana")\n'
            "else:\n"
            '    print("laborable")\n'
        ),
    },
    {
        "id": "E08",
        "name": "MenuMatch",
        "tipo": "match / case",
        "obj": 'Menu texto: "1" Hola, "2" Adios, "0" Fin, otro caso invalido (match/case).',
        "pendiente": 'op = input("Opcion (1/2/0): ")\n# TODO: match op con case y case _\n',
        "resuelto": (
            'op = input("Opcion (1/2/0): ")\n'
            "match op:\n"
            '    case "1":\n'
            '        print("Hola")\n'
            '    case "2":\n'
            '        print("Adios")\n'
            '    case "0":\n'
            '        print("Fin")\n'
            "    case _:\n"
            '        print("Opcion invalida")\n'
        ),
    },
    {
        "id": "E09",
        "name": "DiaMatch",
        "tipo": "match / case + |",
        "obj": "Entero dia 1-7: match con case 6 | 7 fin de semana, case _ laborable.",
        "pendiente": 'dia = int(input("Dia: "))\n# TODO: match dia, case 6 | 7, case _\n',
        "resuelto": (
            'dia = int(input("Dia: "))\n'
            "match dia:\n"
            "    case 6 | 7:\n"
            '        print("fin de semana")\n'
            "    case _:\n"
            '        print("laborable")\n'
        ),
    },
    {
        "id": "E10",
        "name": "TernarioAprobado",
        "tipo": "operador ternario",
        "obj": "Nota con una linea: Aprobado si >=5 else Suspenso (sin if multilinea).",
        "pendiente": 'nota = float(input("Nota: "))\n# TODO: mensaje = "Aprobado" if ... else ...\n',
        "resuelto": (
            'nota = float(input("Nota: "))\n'
            'mensaje = "Aprobado" if nota >= 5 else "Suspenso"\n'
            "print(mensaje)\n"
        ),
    },
]

for ex in EXERCISES:
    for kind, suffix in (("pendientes", "Pendiente"), ("resueltos", "Resuelto")):
        body = ex["pendiente"] if suffix == "Pendiente" else ex["resuelto"]
        extra = "\nSOLUCION: ver codigo.\n" if suffix == "Resuelto" else ""
        content = (
            '"""\n'
            f"OBJETIVO: {ex['obj']}\n"
            f"TIPO: {ex['tipo']}.{extra}\n"
            f"{AUTHOR}"
            '"""\n\n'
            f"{body}"
        )
        path = BASE / kind / f"{ex['id']}_{ex['name']}_{suffix}.py"
        path.write_text(content, encoding="utf-8")
        print(path.name)

# Borrar ejercicios viejos que ya no estan en la lista
nombres = {f"{ex['id']}_{ex['name']}_{s}.py" for ex in EXERCISES for s in ("Pendiente", "Resuelto")}
for kind in ("pendientes", "resueltos"):
    for f in (BASE / kind).glob("*.py"):
        if f.name not in nombres:
            f.unlink()
            print("borrado", f.name)

print("Listo:", len(EXERCISES) * 2, "archivos")
