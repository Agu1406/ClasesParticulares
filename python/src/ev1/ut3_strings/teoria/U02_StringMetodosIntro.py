"""
U02 — Metodos utiles de str.

OBJETIVO:
  - upper, lower, capitalize, title, strip.
  - replace, split, join.
  - find, startswith, endswith, count.

Autor: Agustin. A. Marquez. Pina
"""

frase = "  Aprender Python en FP  "
# repr(): muestra la cadena con espacios visibles
print("original:", repr(frase))
# lower(): minusculas; strip(): quita espacios; se encadenan con punto
print("lower:", frase.lower().strip())
# upper(): mayusculas; strip(): quita espacios
print("upper:", frase.upper().strip())
# strip(): quita espacios; title(): capitaliza cada palabra
print("title:", frase.strip().title())

email = "usuario@dominio.com"
# split("@"): divide la cadena en lista usando @ como separador; [0] toma la primera parte
usuario = email.split("@")[0]
# print(): muestra la parte antes de @
print("usuario:", usuario)

# split(): sin argumento divide por espacios en blanco
palabras = "uno dos tres".split()
# print(): muestra la lista resultante
print("lista:", palabras)
# join(): une elementos de la lista con "-" entre ellos
print("unido:", "-".join(palabras))

texto = "programacion en python"
# find(): devuelve la posicion de "python" o -1 si no existe
print("find 'python':", texto.find("python"))
# in: comprueba si "java" esta contenido en texto
print("contiene 'java':", "java" in texto)
# startswith(): True si el texto empieza por "prog"
print("empieza por 'prog':", texto.startswith("prog"))
# count(): cuenta cuantas veces aparece "o"
print("cuenta 'o':", texto.count("o"))

archivo = "informe.pdf"
if archivo.endswith(".pdf"):
    # removesuffix(): quita el sufijo ".pdf" del final (Python 3.9+)
    print("nombre sin extension:", archivo.removesuffix(".pdf"))
