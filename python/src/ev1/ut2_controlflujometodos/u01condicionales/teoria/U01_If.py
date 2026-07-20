"""
U01 — Condicional if.

OBJETIVO:
    - Entender el funcionamiento de una estructura "if".
    - Permitir que el código ejecuta una acción si una condición se cumple, si no, no.
    - Probar diferentes tipos de condiciones usando diferentes tipos de datos en el "if".

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""
print("\nINICIO DEL PROGRAMA\n")
"""
PRIMERA PARTE - Uso del if con "str" cuando es exactamente igual ("==") o diferente ("!=").
"""
print(f"\n¡PRUEBA DEL IF CON DATOS DEL TIPO \"str\"!\n")
# Ingresamos el nombre del usuario en el programa usando input.
nombre = input("¿Cual es tú nombre?: ")

if nombre == "Agustin":
    print(f"¡Eres el profesor!")

if nombre == "Edu":
    print(f"¡Eres el alumno!")

if nombre != "Agustin":
    print(f"¡Tú no eres Agustín! Tú eres {nombre}")

if nombre != "Edu":
    print(f"¡Tú no eres Edu! Tú eres {nombre}")

"""
SEGUNDA PARTE - Uso del if con "float" cuando el valor es menor ("<"), menor igual ("<="), mayor (">") o mayor igual (">=").
"""
print(f"\n¡PRUEBA DEL IF CON DATOS DEL TIPO \"float\"!\n")

altura = 1.70

# ✅ Si la altura es exactamente "1.50" o mayor, el if se ejecuta.
if altura >= 1.50:
    print(f"¡Mides 1.50 o más! Puedes subirte a la montaña rusa. \n")

# ❌ La altura no es mayor a "1.70", el if no se ejecuta.
if altura > 1.70:
    print(f"¡Mides más de 1.70! Te puedes subir a la rueda extrema. \n")

# ✅ Si la altura es exactamente "1.70" el if si se ejecuta.
if altura == 1.70:
    print(f"¡Mides exactamente 1.70! Bienvenido al club VIP. \n")

 # ❌ La altura no es menor que "1.50", por lo tanto, el if no se ejecuta.
if altura < 1.50:
    print(f"¡El profesor no mide más de metro y medio! No puede subir a la montaña rusa! \n")

# ✅ La altura es menor o igual que 2 metros, por lo tanto el if si se ejecuta.
if altura <= 2.00:
    print(f"¡El profesor mide menos de dos metros! Puede subir a los carritos chocones. \n")

"""
TERCERA PARTE - Uso del if con "bool" cuando el valor es "True" o cuando es "False" usando not
"""
print(f"\n¡PRUEBA DEL IF CON DATOS DEL TIPO \"bool\"!\n")
humano = True
jirafa = False

# ✅ "humano" es True, por lo tanto si se ejecuta.
if humano:
    print(f"¡El profesor es un ser humano! \n")

# ❌ "jirafa" es False, por lo tanto no se ejecuta.
if jirafa:
    print(f"¡El profesor es una jirafa! \n")

# ✅ "jirafa" es False, por lo tanto si se ejecuta.
if not jirafa:
    print(f"¡El profesor no es una jirafa! \n")

# ❌ "huamno" es True, por lo tanto, no se ejecuta.
if not humano:
    print(f"¡El profesor no es un humano! \n")

"""
TERCERA PARTE - Uso del if con "int" cuando el valor es menor ("<"), menor igual ("<="), mayor (">") o mayor igual (">=").
"""
print(f"\n¡PRUEBA DEL IF CON DATOS DEL TIPO \"int\"!\n")
edad = 26

# ✅ La edad es mayor o igual al valor de la condición, por lo tanto, el if si se ejecuta.
if edad >= 18:
    print(f"¡El profesor es mayor de edad! \n")

# ❌ La edad no es menor o igual al valor de la condición, por lo tanto, el if no se ejecuta.
if edad <= 17:
    print(f"¡El profesor no es mayor de edad! \n")

# ✅ La edad es menor o igual al valor de la condición, por lo tanto, el if si se ejecuta.
if edad <= 28:
    print(f"¡El profesor es un adulto joven! \n")

# ❌ La edad no es mayor o igual al valor de la condición, por lo tanto, el if no se ejecuta.
if edad >= 65:
    print(f"¡El profesor es un jubilado! \n")

    
print("\nFIN DEL PROGRAMA\n")