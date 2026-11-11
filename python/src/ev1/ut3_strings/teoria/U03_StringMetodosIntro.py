"""
U03 — Metodos utiles de str.

OBJETIVO:
  - Limpiar y cambiar mayusculas: strip, lower, upper, title.
  - Sustituir y partir: replace, split, join.
  - Buscar: find, in, startswith, endswith, count.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")

"""
PRIMERA PARTE — strip y mayusculas/minusculas.
"""
print("¡DEMO 1: strip / lower / upper / title!\n")
frase = "  Aprender Python en FP  "
print("original:", repr(frase))
print("strip:", repr(frase.strip()))
print("lower+strip:", frase.lower().strip())
print("upper+strip:", frase.upper().strip())
print("title:", frase.strip().title())

"""
SEGUNDA PARTE — replace, split, join.
"""
print("\n¡DEMO 2: replace / split / join!\n")
print("replace:", "hola mundo".replace("mundo", "Python"))
email = "usuario@dominio.com"
print("usuario:", email.split("@")[0])
palabras = "uno dos tres".split()
print("lista:", palabras)
print("join:", "-".join(palabras))

"""
TERCERA PARTE — busquedas.
"""
print("\n¡DEMO 3: find / in / starts / ends / count!\n")
texto = "programacion en python"
print("find 'python':", texto.find("python"))
print("contiene 'java':", "java" in texto)
print("startswith 'prog':", texto.startswith("prog"))
print("count 'o':", texto.count("o"))
archivo = "informe.pdf"
if archivo.endswith(".pdf"):
    print("sin extension:", archivo.removesuffix(".pdf"))

print("\n¡FIN DEL PROGRAMA!\n")
