"""
U02 — Conversión de tipos.

OBJETIVO:
  - Transformar los datos de un tipo a otro.
  - Usar la función "int()".
  - Usar la función "float()".
  - Usar la función "bool()".
  - Usar la función "str()".

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""
print("\nINICIO DEL PROGRAMA\n")
"""
PRIMERA PARTE - Transformar datos de los tipos "int", "float" y "bool" a "str".
"""
print("\n¡TRANSFORMANDO DATOS \"int\" \"float\" Y \"bool\" EN \"str\"!\n")

# PRIMERA TRANSFORMACIÓN: Transformamos números enteros en cadenas de texto.
valor_a = 1406
valor_b = 2000
valor_c = 2026
valor_d = 1234

valor_a_str = str(valor_a)
valor_b_str = str(valor_b)
valor_c_str = str(valor_c)
valor_d_str = str(valor_d)

print(
  f"¡Ejemplo de números enteros convertidos en cadenas de texto!: \n"
  f"- Valor A original: {valor_a} | Valor A str: {valor_a_str}. \n"
  f"- Valor B original: {valor_b} | Valor B str: {valor_b_str}. \n"
  f"- Valor C original: {valor_c} | Valor C str: {valor_c_str}. \n"
  f"- Valor D original: {valor_d} | Valor D str: {valor_d_str}. \n"
    )

# SEGUNDA TRANSFORMACIÓN: Transformamos números decimales en cadenas de texto.
valor_a = 3.1416
valor_b = 0.0001
valor_c = 0.9999
valor_d = 1.9999

valor_a_str = str(valor_a)
valor_b_str = str(valor_b)
valor_c_str = str(valor_c)
valor_d_str = str(valor_d)

print(
  f"¡Ejemplo de números decimales convertidos en cadenas de texto!: \n"
  f"- Valor A original: {valor_a} | Valor A str: {valor_a_str}. \n"
  f"- Valor B original: {valor_b} | Valor B str: {valor_b_str}. \n"
  f"- Valor C original: {valor_c} | Valor C str: {valor_c_str}. \n"
  f"- Valor D original: {valor_d} | Valor D str: {valor_d_str}. \n"
    )

# TERCERA TRANSFORMACIÓN: Transformamos booleanos en cadenas de texto.
valor_a = True
valor_b = False
valor_c = True
valor_d = False

valor_a_str = str(valor_a)
valor_b_str = str(valor_b)
valor_c_str = str(valor_c)
valor_d_str = str(valor_d)

print(
  f"¡Ejemplo de booleanos convertidos en cadenas de texto!: \n"
  f"- Valor A original: {valor_a} | Valor A str: {valor_a_str}. \n"
  f"- Valor B original: {valor_b} | Valor B str: {valor_b_str}. \n"
  f"- Valor C original: {valor_c} | Valor C str: {valor_c_str}. \n"
  f"- Valor D original: {valor_d} | Valor D str: {valor_d_str}. \n"
    )

"""
SEGUNDA PARTE - Transformar datos de "str", "float" y "bool" a "int".
"""
print("\n¡TRANSFORMANDO DATOS \"str\" \"float\" Y \"bool\" EN \"int\"!\n")

# PRIMERA TRANSFORMACIÓN: Transformamos cadenas de texto en números enteros.
valor_a = "2026"
valor_b = "0001"
valor_c = "1.50"
valor_d = "0.01"

valor_a_int = int(valor_a)
valor_b_int = int(valor_b)
# ❌ Si el formato no es compatible, la transformación causara un error.
# valor_c_int = int(valor_c)
# valor_d_int = int(valor_d)

print(
  f"¡Ejemplo de cadenas de texto convertidas en números enteros!: \n"
  f"- Valor A original: {valor_a} | Valor A int: {valor_a_int}. \n"
  f"- Valor B original: {valor_b} | Valor B int: {valor_b_int}. \n"
  f"- Valor C original: {valor_c} | Valor C int: No es posible convertirlo en int. \n"
  f"- Valor D original: {valor_d} | Valor D int: No es posible convertirlo en int. \n"
    )

# SEGUNDA TRANSFORMACIÓN: Transformamos números decimales en números enteros.
valor_a = 3.1416
valor_b = 0.0001
valor_c = 1.9999
valor_d = 1,1234

valor_a_int = int(valor_a)
valor_b_int = int(valor_b)
valor_c_int = int(valor_c)
# ❌ Si el formato no es compatible, la transformación causara un error.
# valor_d_int = int(valor_d)

print(
  f"¡Ejemplo de números decimales convertidos en números enteros!: \n"
  f"- Valor A original: {valor_a} | Valor A int: {valor_a_int}. \n"
  f"- Valor B original: {valor_b} | Valor B int: {valor_b_int}. \n"
  f"- Valor C original: {valor_c} | Valor C int: {valor_c_int}. \n"
  f"- Valor D original: {valor_d} | Valor D int: No es posible convertirlo en int. \n"
    )

# TERCERA TRANSFORMACIÓN: Transformamos booleanos en números enteros.
valor_a = True
valor_b = False
valor_c = True
valor_d = False

valor_a_int = int(valor_a)
valor_b_int = int(valor_b)
valor_c_int = int(valor_c)
valor_d_int = int(valor_d)

print(
  f"¡Ejemplo de booleanos convertidos en números enteros!: \n"
  f"- Valor A original: {valor_a} | Valor A int: {valor_a_int}. \n"
  f"- Valor B original: {valor_b} | Valor B int: {valor_b_int}. \n"
  f"- Valor C original: {valor_c} | Valor C int: {valor_c_int}. \n"
  f"- Valor D original: {valor_d} | Valor D int: {valor_d_int}. \n"
    )


"""
TERCERA PARTE - Transformar datos de "str", "int" y "bool" a "float".
"""
print("\n¡TRANSFORMANDO DATOS \"str\" \"int\" Y \"bool\" EN \"float\"!\n")

# PRIMERA TRANSFORMACIÓN: Transformamos cadenas de texto en números decimales.
valor_a = "3.1416"
valor_b = "3,1416"
valor_c = "0.0001"
valor_d = "Veinte"

valor_a_float = float(valor_a)
# ❌ Si el formato no es compatible, la transformación causara un error.
# valor_b_float = float(valor_b)
valor_c_float = float(valor_c)
# ❌ Si el formato no es compatible, la transformación causara un error.
# valor_d_float = float(valor_d)

print(
  f"¡Ejemplo de cadenas de texto convertidas en números decimales!: \n"
  f"- Valor A original: {valor_a} | Valor A float: {valor_a_float}. \n"
  f"- Valor B original: {valor_b} | Valor B float: No es posible convertirlo en float. \n"
  f"- Valor C original: {valor_c} | Valor C float: {valor_c_float}. \n"
  f"- Valor D original: {valor_d} | Valor D float: No es posible convertirlo en float. \n"
    )

# SEGUNDA TRANSFORMACIÓN: Transformamos números enteros en números decimales.
valor_a = 1234
valor_b = 1406
valor_c = 1
valor_d = 0

valor_a_float = float(valor_a)
valor_b_float = float(valor_b)
valor_c_float = float(valor_c)
valor_d_float = float(valor_d)

print(
  f"¡Ejemplo de números enteros convertidos en números decimales!: \n"
  f"- Valor A original: {valor_a} | Valor A float: {valor_a_float}. \n"
  f"- Valor B original: {valor_b} | Valor B float: {valor_b_float}. \n"
  f"- Valor C original: {valor_c} | Valor C float: {valor_c_float}. \n"
  f"- Valor D original: {valor_d} | Valor D float: {valor_d_float}. \n"
    )

# TERCERA TRANSFORMACIÓN: Transformamos booleanos en números decimales.
valor_a = True
valor_b = False
valor_c = True
valor_d = False

valor_a_float = float(valor_a)
valor_b_float = float(valor_b)
valor_c_float = float(valor_c)
valor_d_float = float(valor_d)

print(
  f"¡Ejemplo de booleanos convertidos en números decimales!: \n"
  f"- Valor A original: {valor_a} | Valor A float: {valor_a_float}. \n"
  f"- Valor B original: {valor_b} | Valor B float: {valor_b_float}. \n"
  f"- Valor C original: {valor_c} | Valor C float: {valor_c_float}. \n"
  f"- Valor D original: {valor_d} | Valor D float: {valor_d_float}. \n"
    )

"""
CUARTA PARTE - Transformar datos de "str", "int" y "float" a "bool".
"""
print("\n¡TRANSFORMANDO DATOS \"str\" \"int\" Y \"float\" EN \"bool\"!\n")

# PRIMERA TRANSFORMACIÓN: Transformamos cadenas de texto en booleanos.
valor_a = "True"
valor_b = "Agustín"
valor_c = ""
valor_d = ''

valor_a_boolean = bool(valor_a)
valor_b_boolean = bool(valor_b)
valor_c_boolean = bool(valor_c)
valor_d_boolean = bool(valor_d)

print(
  f"¡Ejemplo de cadenas de texto convertidas en booleanos!: \n"
  f"- Valor A original: {valor_a} | Valor A boolean: {valor_a_boolean}. \n"
  f"- Valor B original: {valor_b} | Valor B boolean: {valor_b_boolean}. \n"
  f"- Valor C original: \"\" | Valor C boolean: {valor_c_boolean}. \n"
  f"- Valor D original: '' | Valor D boolean: {valor_d_boolean}. \n"
    )

# SEGUNDA TRANSFORMACIÓN: Transformamos números enteros en booleanos.
valor_a = 1
valor_b = 0
valor_c = -10
valor_d = 420

valor_a_boolean = bool(valor_a)
valor_b_boolean = bool(valor_b)
valor_c_boolean = bool(valor_c)
valor_d_boolean = bool(valor_d)

print(
  f"¡Ejemplo de números enteros convertidos en booleanos!: \n"
  f"- Valor A original: {valor_a} | Valor A boolean: {valor_a_boolean}. \n"
  f"- Valor B original: {valor_b} | Valor B boolean: {valor_b_boolean}. \n"
  f"- Valor C original: {valor_c} | Valor C boolean: {valor_c_boolean}. \n"
  f"- Valor D original: {valor_d} | Valor D boolean: {valor_d_boolean}. \n"
    )

# TERCERA TRANSFORMACIÓN: Transformamos números decimales en booleanos.
valor_a = 1.0005
valor_b = 0.0000
valor_c = 0.0001
valor_d = 3.1416

valor_a_boolean = bool(valor_a)
valor_b_boolean = bool(valor_b)
valor_c_boolean = bool(valor_c)
valor_d_boolean = bool(valor_d)

print(
  f"¡Ejemplo de números decimales convertidos en booleanos!: \n"
  f"- Valor A original: {valor_a} | Valor A boolean: {valor_a_boolean}. \n"
  f"- Valor B original: {valor_b} | Valor B boolean: {valor_b_boolean}. \n"
  f"- Valor C original: {valor_c} | Valor C boolean: {valor_c_boolean}. \n"
  f"- Valor D original: {valor_d} | Valor D boolean: {valor_d_boolean}. \n"
    )

print("\nFIN DEL PROGRAMA\n")