"""
U02 — Comentarios y estilo basico.

OBJETIVO:
  - Comentario de linea con #
  - Docstring con triple comilla para documentar modulos y funciones
  - Indentacion obligatoria (4 espacios) en bloques if/for/def
  - Nombres claros: snake_case para variables y funciones

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

# Esto es un comentario de una linea: el interprete lo ignora

"""
Esto es un docstring multilinea.
Suele ir al inicio del archivo o de una funcion.
"""

nota_examen = 7.5
nota_practica = 8.0
nota_final = (nota_examen + nota_practica) / 2

# print(): f-string con nota_final formateada a un decimal (:.1f)
print(f"Nota final: {nota_final:.1f}")

if nota_final >= 5:
    # print(): se ejecuta solo si la condicion del if es verdadera
    print("Aprobado")
    # print(): segunda linea del mismo bloque if (misma indentacion)
    print("Enhorabuena")
else:
    # print(): se ejecuta si la condicion del if es falsa
    print("Suspenso")
