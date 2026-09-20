"""
U02 — Bucle while.

OBJETIVO:
  - Repetir mientras una condicion sea True.
  - Actualizar la variable de control dentro del bucle (evitar infinito).
  - break sale del bucle; continue salta a la siguiente vuelta.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""
print("\n¡INICIO DEL PROGRAMA!\n")
"""
PRIMERA PARTE - Sintaxis y uso del bucle "while".
"""
contador = 0
while contador < 5:
    # print(): muestra el valor actual del contador
    print("contador =", contador)
    contador += 1

suma = 0
numero = 1
while suma < 20:
    suma += numero
    # print(): f-string con el numero sumado y el total parcial
    print(f"sumando {numero}, total = {suma}")
    numero += 1

# print(): titulo del ejemplo con break
print("\nBuscando el primer multiplo de 7 mayor que 20:")
n = 21
while True:
    if n % 7 == 0:
        # print(): encontro el multiplo
        print("Encontrado:", n)
        # break: sale del while True
        break
    n += 1

# print(): titulo del ejemplo con continue
print("\nNumeros del 1 al 8 excepto el 5:")
i = 0
while i < 8:
    i += 1
    if i == 5:
        # continue: salta el print de abajo y vuelve al while
        continue
    # print(): muestra i en la misma linea
    print(i, end=" ")
# print(): salto de linea final
print()

secreto = 7
# for intento in range(1, 11): prueba numeros del 1 al 10 sin usar listas.
for intento in range(1, 11):
    # print(): muestra el intento actual
    print("Intento:", intento)
    if intento == secreto:
        # print(): acerto
        print("Correcto!")
        # break: deja el bucle for
        break
    # print(): no acerto esta vuelta
    print("Fallo, sigue...")
else:
    # else del for: solo si no hubo break
    print("No acertaste en 10 intentos")

print("\n¡FIN DEL PROGRAMA!\n")
