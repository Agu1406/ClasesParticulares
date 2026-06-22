#!/usr/bin/env python3
"""Genera los 10 pares de ejercicios EV1."""
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2] / "src" / "ev1"
AUTHOR = """Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
"""

EXERCISES = [
    {
        "id": "E01",
        "name": "HolaMundo",
        "folder": "ut1_fundamentospython/u01entornopython/ejercicios",
        "obj": 'Muestra por pantalla el mensaje "Hola, Python!" y una segunda linea con el nombre del alumno.',
        "pendiente": "# TODO: usa print() para mostrar los dos mensajes\n",
        "resuelto": 'print("Hola, Python!")\nprint("Alumno: Maria")\n',
    },
    {
        "id": "E02",
        "name": "VariablesPersonales",
        "folder": "ut1_fundamentospython/u02tiposvariables/ejercicios",
        "obj": "Crea variables nombre (str), edad (int) y altura (float). Muestralas con un f-string.",
        "pendiente": "# TODO: define las variables y el print con f-string\n",
        "resuelto": (
            'nombre = "Ana"\n'
            "edad = 19\n"
            "altura = 1.65\n"
            'print(f"{nombre} tiene {edad} anos y mide {altura} m")\n'
        ),
    },
    {
        "id": "E03",
        "name": "AreaRectangulo",
        "folder": "ut1_fundamentospython/u02tiposvariables/ejercicios",
        "obj": "Con base=8 y altura=5 calcula y muestra el area del rectangulo (base * altura).",
        "pendiente": "base = 8\naltura = 5\n# TODO: calcula el area y muestrala\n",
        "resuelto": (
            "base = 8\n"
            "altura = 5\n"
            "area = base * altura\n"
            'print(f"Area del rectangulo: {area}")\n'
        ),
    },
    {
        "id": "E04",
        "name": "SumaDosNumeros",
        "folder": "ut1_fundamentospython/u03inputcomentarios/ejercicios",
        "obj": "Pide dos numeros enteros con input(), conviertelos con int() y muestra la suma.",
        "pendiente": "# TODO: pide dos numeros, convierte y suma\n",
        "resuelto": (
            'a = int(input("Primer numero: "))\n'
            'b = int(input("Segundo numero: "))\n'
            'print(f"Suma: {a + b}")\n'
        ),
    },
    {
        "id": "E05",
        "name": "ParOImpar",
        "folder": "ut2_controlflujometodos/u01condicionales/ejercicios",
        "obj": "Lee un entero numero y di si es par o impar (usa if y el operador %).",
        "pendiente": 'numero = int(input("Numero: "))\n# TODO: imprime si es par o impar\n',
        "resuelto": (
            'numero = int(input("Numero: "))\n'
            "if numero % 2 == 0:\n"
            '    print(f"{numero} es par")\n'
            "else:\n"
            '    print(f"{numero} es impar")\n'
        ),
    },
    {
        "id": "E06",
        "name": "NotaLetra",
        "folder": "ut2_controlflujometodos/u01condicionales/ejercicios",
        "obj": "Con nota 0-10 muestra: >=9 Sobresaliente, >=7 Notable, >=5 Aprobado, si no Suspenso.",
        "pendiente": 'nota = float(input("Nota (0-10): "))\n# TODO: clasifica con if / elif / else\n',
        "resuelto": (
            'nota = float(input("Nota (0-10): "))\n'
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
        "id": "E07",
        "name": "TablaMultiplicar",
        "folder": "ut2_controlflujometodos/u02bucles/ejercicios",
        "obj": "Pide un numero n y muestra su tabla de multiplicar del 1 al 10 con un for.",
        "pendiente": 'n = int(input("Tabla del: "))\n# TODO: bucle for del 1 al 10\n',
        "resuelto": (
            'n = int(input("Tabla del: "))\n'
            "for i in range(1, 11):\n"
            '    print(f"{n} x {i} = {n * i}")\n'
        ),
    },
    {
        "id": "E08",
        "name": "ContadorWhile",
        "folder": "ut2_controlflujometodos/u02bucles/ejercicios",
        "obj": "Con while cuenta del 1 al 5 mostrando cada numero en una linea.",
        "pendiente": "# TODO: while que muestre 1, 2, 3, 4, 5\n",
        "resuelto": (
            "contador = 1\n"
            "while contador <= 5:\n"
            "    print(contador)\n"
            "    contador += 1\n"
        ),
    },
    {
        "id": "E09",
        "name": "FuncionSaludo",
        "folder": "ut2_controlflujometodos/u03funciones/ejercicios",
        "obj": 'Define saludar(nombre) que imprima "Hola, <nombre>!" y llamala dos veces.',
        "pendiente": "# TODO: def saludar(nombre): ...\n# TODO: llama con dos nombres distintos\n",
        "resuelto": (
            "def saludar(nombre):\n"
            '    print(f"Hola, {nombre}!")\n\n'
            'saludar("Luis")\n'
            'saludar("Sara")\n'
        ),
    },
    {
        "id": "E10",
        "name": "ContarVocales",
        "folder": "ut3_strings/ejercicios",
        "obj": 'En la palabra "programacion" cuenta cuantas vocales (a,e,i,o,u) hay usando un for.',
        "pendiente": 'palabra = "programacion"\n# TODO: recorre cada letra y cuenta vocales\n',
        "resuelto": (
            'palabra = "programacion"\n'
            'vocales = "aeiou"\n'
            "contador = 0\n"
            "for letra in palabra:\n"
            "    if letra in vocales:\n"
            "        contador += 1\n"
            'print(f"Vocales en {palabra}: {contador}")\n'
        ),
    },
]

for ex in EXERCISES:
    base = ROOT / ex["folder"]
    for kind, suffix in [("pendientes", "Pendiente"), ("resueltos", "Resuelto")]:
        body = ex["pendiente"] if suffix == "Pendiente" else ex["resuelto"]
        extra = "\nSOLUCION: ver codigo siguiente.\n" if suffix == "Resuelto" else ""
        content = f'"""\nOBJETIVO: {ex["obj"]}{extra}\n{AUTHOR}"""\n\n{body}'
        path = base / kind / f"{ex['id']}_{ex['name']}_{suffix}.py"
        path.parent.mkdir(parents=True, exist_ok=True)
        path.write_text(content, encoding="utf-8")
        print(path.relative_to(ROOT))

print("Total:", len(EXERCISES) * 2, "archivos")
