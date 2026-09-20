"""
Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev

ENUNCIADO
---------
Fuente: examen.txt — Problema 4
(Texto del .txt con erratas OCR corregidas: n/2 si par; 3*n+1 si impar.)

NORMAS (examen):
- Incluye el algoritmo lo más detallado posible, además del código.
- Solo estructuras, tipos e instrucciones vistas durante el curso.
- No librerías externas.
- No usar break ni continue.

Problema 4 [1,5 puntos]

La serie de Collatz es una secuencia de números que se define de la siguiente manera:
dado un número natural n, el siguiente término de la secuencia es n/2 (si n es par) o
3*n+1 (si n es impar). La serie finaliza cuando llega al número 1.

Por ejemplo: primer número de la serie n = 6
como 6 es par, el segundo número de la serie será 6/2=3; como 3 es impar, el tercer
número de la serie será 3*3+1=10; como 10 es par, el cuarto número de la serie será
10/2=5 ... y así sucesivamente hasta obtener la serie completa: 6,3,10,5,16,8,4,2,1

Implementa una función llamada "collatz" que, dado un número inicial n, retorne una lista
con la secuencia de Collatz hasta llegar a 1.
"""

# TODO: escribe el algoritmo (comentado) y el código.
