#!/usr/bin/env python3
"""Genera 10 ejercicios pendiente/resuelto por subtema EV1 (UT1-UT3)."""
from pathlib import Path

EV1 = Path(__file__).resolve().parents[2] / "src" / "ev1"
AUTHOR = """Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
"""

# (ruta_relativa_ev1, lista de 10 dicts con name, obj, pendiente, resuelto)
BLOCKS: list[tuple[str, list[dict]]] = []

def ex(name, obj, pendiente, resuelto):
    return {"name": name, "obj": obj, "pendiente": pendiente, "resuelto": resuelto}

# --- UT1 u01entornopython ---
BLOCKS.append(("ut1_fundamentospython/u01entornopython/ejercicios", [
    ex("HolaMundo", "Muestra Hola, Python! y una linea con el nombre del alumno.",
       "# TODO: dos print()\n",
       'print("Hola, Python!")\nprint("Alumno: Maria")\n'),
    ex("LineaSeparadora", "Imprime una linea de 20 guiones y debajo la frase Fin.",
       "# TODO:\n",
       'print("-" * 20)\nprint("Fin")\n'),
    ex("PrintVariosValores", "En un solo print muestra: Curso Python - EV1",
       "# TODO: un print con varios textos separados por comas\n",
       'print("Curso", "Python", "-", "EV1")\n'),
    ex("SaltoDeLinea", 'Muestra "Linea A" y en la siguiente linea "Linea B" usando \\n.',
       "# TODO:\n",
       'print("Linea A\\nLinea B")\n'),
    ex("Tabulador", 'Muestra "Nombre:\\tAna" usando el caracter tabulador.',
       "# TODO:\n",
       'print("Nombre:\\tAna")\n'),
    ex("RepetirCaracter", "Imprime 15 asteriscos en una linea con el operador *.",
       "# TODO:\n",
       'print("*" * 15)\n'),
    ex("TresMensajes", "Tres print seguidos: Inicio, Proceso, Fin.",
       "# TODO:\n",
       'print("Inicio")\nprint("Proceso")\nprint("Fin")\n'),
    ex("NumeroYTexto", "Muestra El ano es y el numero 2026 en un print.",
       "# TODO:\n",
       'print("El ano es", 2026)\n'),
    ex("BloqueVisual", "Imprime un marco: linea de =, texto Centro, otra linea de =.",
       "# TODO:\n",
       'print("=" * 24)\nprint("Centro")\nprint("=" * 24)\n'),
    ex("Presentacion", "Presentate con dos lineas: nombre ficticio y modulo FP.",
       "# TODO:\n",
       'print("Me llamo Carlos")\nprint("Estudio FP Informatica")\n'),
]))

# --- UT1 u02tiposvariables ---
BLOCKS.append(("ut1_fundamentospython/u02tiposvariables/ejercicios", [
    ex("VariablesPersonales", "Variables nombre, edad, altura y un f-string.",
       "# TODO:\n",
       'nombre = "Ana"\nedad = 19\naltura = 1.65\nprint(f"{nombre}, {edad} anos, {altura} m")\n'),
    ex("TiposBasicos", "Crea int, float, str, bool y muestra type() de cada una.",
       "# TODO:\n",
       'a, b, c, d = 7, 3.5, "hola", True\nprint(type(a), type(b), type(c), type(d))\n'),
    ex("SumaYResta", "a=12, b=5. Muestra suma y resta con f-string.",
       "a = 12\nb = 5\n# TODO:\n",
       'a = 12\nb = 5\nprint(f"Suma: {a+b}, Resta: {a-b}")\n'),
    ex("AreaRectangulo", "base=8, altura=5. Calcula y muestra el area.",
       "base = 8\naltura = 5\n# TODO:\n",
       'base = 8\naltura = 5\nprint(f"Area: {base * altura}")\n'),
    ex("PerimetroCuadrado", "lado=6. Calcula perimetro 4*lado.",
       "lado = 6\n# TODO:\n",
       'lado = 6\nprint(f"Perimetro: {4 * lado}")\n'),
    ex("ConversionEntero", 'Convierte "42" a int y suma 8.',
       '# TODO: texto = "42"\n',
       'texto = "42"\nprint(int(texto) + 8)\n'),
    ex("Comparaciones", "x=10, y=3. Muestra si x>y y si x==y.",
       "x = 10\ny = 3\n# TODO:\n",
       'x = 10\ny = 3\nprint(f"x>y: {x>y}, x==y: {x==y}")\n'),
    ex("ModuloPar", "n=14. Di si es par usando %.",
       "n = 14\n# TODO:\n",
       'n = 14\nprint("par" if n % 2 == 0 else "impar")\n'),
    ex("PrecioConIva", "precio=100, IVA=0.21. Muestra total con IVA.",
       "precio = 100\niva = 0.21\n# TODO:\n",
       'precio = 100\niva = 0.21\ntotal = precio * (1 + iva)\nprint(f"Total: {total:.2f}")\n'),
    ex("Intercambio", "Intercambia a y b usando variable auxiliar. a=1, b=9.",
       "a = 1\nb = 9\n# TODO:\n",
       'a = 1\nb = 9\ntemp = a\na = b\nb = temp\nprint(a, b)\n'),
]))

# --- UT1 u03inputcomentarios ---
BLOCKS.append(("ut1_fundamentospython/u03inputcomentarios/ejercicios", [
    ex("SumaDosNumeros", "Pide dos enteros y muestra la suma.",
       "# TODO:\n",
       'a = int(input("A: "))\nb = int(input("B: "))\nprint(f"Suma: {a+b}")\n'),
    ex("SaludoNombre", "Pide el nombre y saluda con Hola, nombre.",
       "# TODO:\n",
       'nombre = input("Nombre: ")\nprint(f"Hola, {nombre}")\n'),
    ex("EdadProximoAno", "Pide edad entera y muestra edad el proximo ano.",
       "# TODO:\n",
       'edad = int(input("Edad: "))\nprint(f"El ano que viene tendras {edad + 1}")\n'),
    ex("RectanguloInput", "Pide base y altura float y muestra area.",
       "# TODO:\n",
       'b = float(input("Base: "))\nh = float(input("Altura: "))\nprint(f"Area: {b*h}")\n'),
    ex("MediaDosNotas", "Pide dos notas y muestra la media.",
       "# TODO:\n",
       'n1 = float(input("Nota 1: "))\nn2 = float(input("Nota 2: "))\nprint(f"Media: {(n1+n2)/2:.2f}")\n'),
    ex("PrecioIvaInput", "Pide precio y calcula total con 21% IVA.",
       "# TODO:\n",
       'p = float(input("Precio: "))\nprint(f"Total: {p * 1.21:.2f}")\n'),
    ex("StripNombre", "Pide nombre con espacios y muestralo sin espacios extra (strip).",
       "# TODO:\n",
       'nombre = input("Nombre: ")\nprint(nombre.strip())\n'),
    ex("ComentarioExplicativo", "Asigna horas=3 y muestrala. Usa un comentario # que diga horas de estudio.",
       "# TODO: comentario + variable + print\n",
       '# Horas de estudio hoy\nhoras = 3\nprint(f"Estudiaste {horas} horas")\n'),
    ex("DobleNumero", "Pide un entero y muestra su doble.",
       "# TODO:\n",
       'n = int(input("Numero: "))\nprint(f"Doble: {n*2}")\n'),
    ex("CelsiusAFahrenheit", "Pide Celsius y muestra F = C*9/5+32.",
       "# TODO:\n",
       'c = float(input("Celsius: "))\nf = c * 9 / 5 + 32\nprint(f"Fahrenheit: {f:.1f}")\n'),
]))

# --- UT2 u01condicionales ---
BLOCKS.append(("ut2_controlflujometodos/u01condicionales/ejercicios", [
    ex("ParOImpar", "Lee un entero y di si es par o impar.",
       'numero = int(input("Numero: "))\n# TODO: if / else con operador %\n',
       'numero = int(input("Numero: "))\nif numero % 2 == 0:\n    print(f"{numero} es par")\nelse:\n    print(f"{numero} es impar")\n'),
    ex("NotaTexto", "Nota 0-10: >=9 SB, >=7 NT, >=5 AP, si no SS.",
       'nota = float(input("Nota: "))\n# TODO: cadena if / elif / else\n',
       'nota = float(input("Nota: "))\nif nota >= 9:\n    print("Sobresaliente")\nelif nota >= 7:\n    print("Notable")\nelif nota >= 5:\n    print("Aprobado")\nelse:\n    print("Suspenso")\n'),
    ex("MayorDeEdad", "Pide edad. Imprime Mayor o Menor segun >= 18.",
       'edad = int(input("Edad: "))\n# TODO: if / else\n',
       'edad = int(input("Edad: "))\nif edad >= 18:\n    print("Mayor")\nelse:\n    print("Menor")\n'),
    ex("SignoNumero", "Entero: positivo, negativo o cero (tres ramas).",
       'n = int(input("n: "))\n# TODO: if / elif / else\n',
       'n = int(input("n: "))\nif n > 0:\n    print("positivo")\nelif n < 0:\n    print("negativo")\nelse:\n    print("cero")\n'),
    ex("SoloIfStock", "Si stock > 0 imprime Hay producto. Si no, no imprimas nada.",
       'stock = int(input("Stock: "))\n# TODO: solo if, sin else\n',
       'stock = int(input("Stock: "))\nif stock > 0:\n    print("Hay producto")\n'),
    ex("AccesoAnd", 'Si usuario admin Y clave 1234 imprime OK, si no ERROR.',
       'u = input("Usuario: ")\nc = input("Clave: ")\n# TODO: if con and\n',
       'u = input("Usuario: ")\nc = input("Clave: ")\nif u == "admin" and c == "1234":\n    print("OK")\nelse:\n    print("ERROR")\n'),
    ex("FinDeSemana", "Dia 1-7: 6 o 7 fin de semana, si no laborable.",
       'dia = int(input("Dia (1-7): "))\n# TODO: if / elif con in (6, 7)\n',
       'dia = int(input("Dia (1-7): "))\nif dia in (6, 7):\n    print("fin de semana")\nelse:\n    print("laborable")\n'),
    ex("MenuMatch", 'Menu texto: "1" Hola, "2" Adios, "0" Fin, otro caso invalido (match/case).',
       'op = input("Opcion (1/2/0): ")\n# TODO: match op con case y case _\n',
       'op = input("Opcion (1/2/0): ")\nmatch op:\n    case "1":\n        print("Hola")\n    case "2":\n        print("Adios")\n    case "0":\n        print("Fin")\n    case _:\n        print("Opcion invalida")\n'),
    ex("DiaMatch", "Entero dia 1-7: match con case 6 | 7 fin de semana, case _ laborable.",
       'dia = int(input("Dia: "))\n# TODO: match dia, case 6 | 7, case _\n',
       'dia = int(input("Dia: "))\nmatch dia:\n    case 6 | 7:\n        print("fin de semana")\n    case _:\n        print("laborable")\n'),
    ex("TernarioAprobado", "Nota con una linea: Aprobado si >=5 else Suspenso (sin if multilinea).",
       'nota = float(input("Nota: "))\n# TODO: mensaje = "Aprobado" if ... else ...\n',
       'nota = float(input("Nota: "))\nmensaje = "Aprobado" if nota >= 5 else "Suspenso"\nprint(mensaje)\n'),
]))

# --- UT2 u02bucles ---
BLOCKS.append(("ut2_controlflujometodos/u02bucles/ejercicios", [
    ex("TablaMultiplicar", "Pide n y tabla del 1 al 10.",
       'n = int(input("Tabla: "))\n# TODO:\n',
       'n = int(input("Tabla: "))\nfor i in range(1, 11):\n    print(f"{n} x {i} = {n*i}")\n'),
    ex("ContadorWhile", "While del 1 al 5.",
       "# TODO:\n",
       'i = 1\nwhile i <= 5:\n    print(i)\n    i += 1\n'),
    ex("SumaUnoADiez", "For: suma numeros del 1 al 10.",
       "# TODO:\n",
       's = 0\nfor i in range(1, 11):\n    s += i\nprint(s)\n'),
    ex("CuentaAtras", "While cuenta atras de 5 a 1 y luego Despegue.",
       "# TODO:\n",
       'n = 5\nwhile n >= 1:\n    print(n)\n    n -= 1\nprint("Despegue")\n'),
    ex("ParesHastaVeinte", "Imprime pares del 2 al 20.",
       "# TODO:\n",
       'for i in range(2, 21, 2):\n    print(i)\n'),
    ex("FactorialCinco", "Calcula factorial de 5 con for.",
       "# TODO:\n",
       'f = 1\nfor i in range(1, 6):\n    f *= i\nprint(f)\n'),
    ex("TrianguloAsteriscos", "For 1..4 imprime *, **, ***, ****.",
       "# TODO:\n",
       'for i in range(1, 5):\n    print("*" * i)\n'),
    ex("MultiplosDeTres", "Lista multiplos de 3 del 3 al 15.",
       "# TODO:\n",
       'for i in range(3, 16, 3):\n    print(i)\n'),
    ex("SumaImpares", "Suma impares del 1 al 19.",
       "# TODO:\n",
       's = 0\nfor i in range(1, 20, 2):\n    s += i\nprint(s)\n'),
    ex("RecorrerLista", 'Recorre ["rojo","verde","azul"] e imprime cada color.',
       '# TODO: colores = ["rojo", "verde", "azul"]\n',
       'colores = ["rojo", "verde", "azul"]\nfor c in colores:\n    print(c)\n'),
]))

# --- UT2 u03funciones ---
BLOCKS.append(("ut2_controlflujometodos/u03funciones/ejercicios", [
    ex("FuncionSaludo", "def saludar(nombre) y llamala dos veces.",
       "# TODO:\n",
       'def saludar(nombre):\n    print(f"Hola, {nombre}!")\n\nsaludar("Luis")\nsaludar("Sara")\n'),
    ex("FuncionSumar", "def sumar(a,b) return. Imprime sumar(4,7).",
       "# TODO:\n",
       'def sumar(a, b):\n    return a + b\n\nprint(sumar(4, 7))\n'),
    ex("AreaTriangulo", "def area(base, altura) return base*altura/2. Demo 6 y 4.",
       "# TODO:\n",
       'def area(base, altura):\n    return base * altura / 2\n\nprint(area(6, 4))\n'),
    ex("EsPar", "def es_par(n) return bool. Prueba con 8 y 7.",
       "# TODO:\n",
       'def es_par(n):\n    return n % 2 == 0\n\nprint(es_par(8), es_par(7))\n'),
    ex("MaximoDos", "def maximo(a,b). Prueba 3 y 9.",
       "# TODO:\n",
       'def maximo(a, b):\n    return a if a >= b else b\n\nprint(maximo(3, 9))\n'),
    ex("Cuadrado", "def cuadrado(n). Imprime cuadrado(5).",
       "# TODO:\n",
       'def cuadrado(n):\n    return n * n\n\nprint(cuadrado(5))\n'),
    ex("EurosADolares", "def convertir(eur, tasa=1.1). 100 euros.",
       "# TODO:\n",
       'def convertir(eur, tasa=1.1):\n    return eur * tasa\n\nprint(convertir(100))\n'),
    ex("ContarHasta", "def contar_hasta(n): for 1..n print.",
       "# TODO:\n",
       'def contar_hasta(n):\n    for i in range(1, n + 1):\n        print(i)\n\ncontar_hasta(4)\n'),
    ex("DobleTriple", "def doble(n) y triple(n). n=4.",
       "# TODO:\n",
       'def doble(n):\n    return n * 2\n\ndef triple(n):\n    return n * 3\n\nprint(doble(4), triple(4))\n'),
    ex("MainSaludo", "def main(): pide nombre y saluda. Llama main().",
       "# TODO:\n",
       'def main():\n    nombre = input("Nombre: ")\n    print(f"Hola, {nombre}")\n\nmain()\n'),
]))

# --- UT2 u04excepciones ---
BLOCKS.append(("ut2_controlflujometodos/u04excepciones/ejercicios", [
    ex("IntSeguro", "try/except: convierte 25 y hola a int.",
       "# TODO:\n",
       'for t in ("25", "hola"):\n    try:\n        print(int(t))\n    except ValueError:\n        print("no es entero")\n'),
    ex("DivisionSegura", "def dividir(a,b) captura ZeroDivisionError.",
       "# TODO:\n",
       'def dividir(a, b):\n    try:\n        return a / b\n    except ZeroDivisionError:\n        return "error"\n\nprint(dividir(10, 2), dividir(10, 0))\n'),
    ex("PedirEntero", "Bucle: pide entero hasta que sea valido.",
       "# TODO:\n",
       'while True:\n    try:\n        n = int(input("Entero: "))\n        print("OK", n)\n        break\n    except ValueError:\n        print("Repite")\n'),
    ex("FloatSeguro", "Convierte 3.14 y abc a float con try.",
       "# TODO:\n",
       'for t in ("3.14", "abc"):\n    try:\n        print(float(t))\n    except ValueError:\n        print("fallo")\n'),
    ex("FinallyMensaje", "try: 10/2. finally: imprime fin.",
       "# TODO:\n",
       'try:\n    print(10 / 2)\nfinally:\n    print("fin")\n'),
    ex("ElseTry", "try 10/2 else imprime sin error.",
       "# TODO:\n",
       'try:\n    r = 10 / 2\nexcept ZeroDivisionError:\n    print("error")\nelse:\n    print("sin error", r)\n'),
    ex("ListaIndice", "try acceder indice 10 en lista de 3.",
       "# TODO:\n",
       'lista = [1, 2, 3]\ntry:\n    print(lista[10])\nexcept IndexError:\n    print("indice malo")\n'),
    ex("SumaDosInputs", "Pide dos numeros; si falla int, mensaje amable.",
       "# TODO:\n",
       'try:\n    a = int(input("a: "))\n    b = int(input("b: "))\n    print(a + b)\nexcept ValueError:\n    print("escribe numeros")\n'),
    ex("CapturarError", "except ValueError as e: muestra e.",
       "# TODO:\n",
       'try:\n    int("x")\nexcept ValueError as e:\n    print(e)\n'),
    ex("MenuTry", "Pide opcion 1 o 2; si no es digito valido, repite una vez (simplificado).",
       "# TODO:\n",
       'ok = False\nfor _ in range(2):\n    try:\n        op = int(input("1 o 2: "))\n        print("opcion", op)\n        ok = True\n        break\n    except ValueError:\n        print("invalido")\nif not ok:\n    print("fin")\n'),
]))

# --- UT2 u05repaso ---
BLOCKS.append(("ut2_controlflujometodos/u05repaso/ejercicios", [
    ex("RepasoVariablesIf", "edad=20. Si >=18 imprime puede conducir.",
       "edad = 20\n# TODO:\n",
       'edad = 20\nif edad >= 18:\n    print("puede conducir")\n'),
    ex("RepasoForSuma", "Suma 1..5 con for.",
       "# TODO:\n",
       's = 0\nfor i in range(1, 6):\n    s += i\nprint(s)\n'),
    ex("RepasoWhile", "While imprime 10,9,8.",
       "# TODO:\n",
       'n = 10\nwhile n >= 8:\n    print(n)\n    n -= 1\n'),
    ex("RepasoFuncionNota", "def aprobado(n): return n>=5. Prueba 4 y 6.",
       "# TODO:\n",
       'def aprobado(n):\n    return n >= 5\n\nprint(aprobado(4), aprobado(6))\n'),
    ex("RepasoOperadores", "x=5,y=2. Muestra // y %.",
       "x,y=5,2\n# TODO:\n",
       'x, y = 5, 2\nprint(x // y, x % y)\n'),
    ex("RepasoInput", "Pide nombre y muestra Bienvenido, nombre.",
       "# TODO:\n",
       'nombre = input("Nombre: ")\nprint(f"Bienvenido, {nombre}")\n'),
    ex("RepasoTry", "try int de 7, imprime ok.",
       "# TODO:\n",
       'try:\n    print(int("7"))\nexcept ValueError:\n    print("mal")\n'),
    ex("RepasoTabla", "Tabla del 3 del 1 al 5 sin input.",
       "# TODO:\n",
       'for i in range(1, 6):\n    print(f"3 x {i} = {3*i}")\n'),
    ex("RepasoMixto", "Lista [2,4,6]. For: imprime cada numero y su cuadrado.",
       "# TODO:\n",
       'for n in [2, 4, 6]:\n    print(n, n**2)\n'),
    ex("RepasoIntegrado", "def clasificar(n): SB si n>=9 else AP si n>=5 else SS. n=7.",
       "# TODO:\n",
       'def clasificar(n):\n    if n >= 9:\n        return "SB"\n    if n >= 5:\n        return "AP"\n    return "SS"\n\nprint(clasificar(7))\n'),
]))

# --- UT3 strings ---
BLOCKS.append(("ut3_strings/ejercicios", [
    ex("ContarVocales", 'Cuenta vocales en "programacion".',
       'p = "programacion"\n# TODO:\n',
       'p = "programacion"\nv = "aeiou"\nc = 0\nfor ch in p:\n    if ch in v:\n        c += 1\nprint(c)\n'),
    ex("MayusMinus", 'Convierte "Python" a upper y lower.',
       't = "Python"\n# TODO:\n',
       't = "Python"\nprint(t.upper(), t.lower())\n'),
    ex("StripLen", 'Quita espacios a "  hola  " y muestra len.',
       't = "  hola  "\n# TODO:\n',
       't = "  hola  "\nt = t.strip()\nprint(t, len(t))\n'),
    ex("Replace", 'En "gato" cambia a por o.',
       't = "gato"\n# TODO:\n',
       't = "gato"\nprint(t.replace("a", "o"))\n'),
    ex("SplitJoin", 'Split "a-b-c" y join con |.',
       't = "a-b-c"\n# TODO:\n',
       'partes = "a-b-c".split("-")\nprint("|".join(partes))\n'),
    ex("Startswith", 'Comprueba si "informatica".startswith("info").',
       't = "informatica"\n# TODO:\n',
       't = "informatica"\nprint(t.startswith("info"))\n'),
    ex("ContarLetra", 'Cuenta cuantas "a" hay en "panaderia".',
       't = "panaderia"\n# TODO:\n',
       't = "panaderia"\nprint(t.count("a"))\n'),
    ex("FstringNota", "nombre y nota con f-string formateada a 1 decimal.",
       "nombre, nota = \"Luis\", 8.456\n# TODO:\n",
       'nombre, nota = "Luis", 8.456\nprint(f"{nombre}: {nota:.1f}")\n'),
    ex("IndiceSlice", 'De "ABCDEF" muestra primer char y subcadena BC.',
       't = "ABCDEF"\n# TODO:\n',
       't = "ABCDEF"\nprint(t[0], t[1:3])\n'),
    ex("PalindromoSimple", 'Di si "ala" es palindromo (== invertida).',
       'p = "ala"\n# TODO:\n',
       'p = "ala"\nprint(p == p[::-1])\n'),
]))


def write_block(rel_path: str, exercises: list[dict]) -> int:
    base = EV1 / rel_path
    count = 0
    for i, exd in enumerate(exercises, start=1):
        eid = f"E{i:02d}"
        for kind, suffix in (("pendientes", "Pendiente"), ("resueltos", "Resuelto")):
            body = exd["pendiente"] if suffix == "Pendiente" else exd["resuelto"]
            extra = "\n" if suffix == "Pendiente" else "\nSOLUCION: ver codigo.\n"
            content = f'"""\nOBJETIVO: {exd["obj"]}{extra}\n{AUTHOR}"""\n\n{body}'
            path = base / kind / f"{eid}_{exd['name']}_{suffix}.py"
            path.parent.mkdir(parents=True, exist_ok=True)
            path.write_text(content, encoding="utf-8")
            count += 1
    return count


def main():
    total = 0
    for rel, exs in BLOCKS:
        if len(exs) != 10:
            raise ValueError(f"{rel}: se esperaban 10 ejercicios, hay {len(exs)}")
        n = write_block(rel, exs)
        total += n
        print(f"{rel}: {n} archivos")
    print("TOTAL:", total)


if __name__ == "__main__":
    main()
