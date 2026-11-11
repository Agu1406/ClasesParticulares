"""
OBJETIVO: Demuestra inmutabilidad: upper() sin asignar no cambia la variable;
  luego reasignar con s = s.upper().
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

s = "hola"
s.upper()
print("Sin asignar:", s)
s = s.upper()
print("Tras asignar:", s)
