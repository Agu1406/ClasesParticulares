"""
U05 — Operadores logicos.

Los operadores logicos permiten mezclar los operadores aritmeticos
y logicos para crear condiciones especificas donde si "X" dato cumple
con dos o más condiciones el programa actue de una forma u otra.

OBJETIVO:
  - Comparar con "and", "or" y "not"

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""
print("\nINICIO DEL PROGRAMA\n")

# Datos del profesor
nombre_p = "Agustín"
edad_p = 26
altura_p = 1.76

# Datos del alumno
nombre_a = 'Eduardo'
edad_a = 29
altura_a = 1.74

# OPERADOR "and": Sirve para combinar dos condiciones o dos preguntas que determine un resultado u otro.
print("\n¡COMPROBANDO QUIEN PUEDE SUBIRSE Y QUIEN NO A LA MONTAÑA RUSA! (operador \"and\")\n")

puede_subir = altura_p >= 1.75 and edad_p >= 18
print(f"¿El profesor puede subirse a la montaña rusa? respuesta: {puede_subir}. \n")

puede_subir = altura_a >= 1.75 and edad_a >= 18
print(f"¿El alumno puede subirse a la montaña rusa? respuesta: {puede_subir}. \n")

# OPERADOR "and": No tiene limites, puede usarse una o más veces para encadenar las condiciones que quieras.
print("\n¡COMPROBANDO QUIEN PUEDE UNIRSE AL CLUB DE EDUARDOS! (operador \"and\")\n")

puede_entrar = edad_a >= 18 and altura_a > 1.50 and nombre_a == "Eduardo"
print(f"¿El alumno puede entrar al club de Eduardo's? respuesta: {puede_entrar}. \n")

puede_entrar = edad_p >= 18 and altura_p > 1.50 and nombre_p == "Eduardo"
print(f"¿El profesor puede entrar al club de Eduardo's? respuesta: {puede_entrar}. \n")

# OPERADOR "or": Sirve para que siempre que al menos 1 de las condiciones se cumpla el código haga algo.
print("\n¡COMPROBANDO SI HOY SE COMPRA TINTO DE VERANO O NO! (operador \"or\")\n")

hoy_cobre = True
hoy_sabado = False
hoy_domingo = False
compro_tinto_verano = hoy_cobre or hoy_sabado or hoy_domingo
print(f"¿Compro tinto de verano? La respuesta es {compro_tinto_verano}")

# OPERADOR "not": Sirve para que el código actue de una "X" forma si detecta que algo no se cumple.
print("\n¡COMPROBANDO SI HOY SE LLUEVE Y SI SE VA AL PARRQUE! (operador \"not\")\n")
hoy_llueve = False
vamos_parque = not hoy_llueve

print(f"¿Hoy llueve? {hoy_llueve}, ¿Vamos al parque? {vamos_parque}. \n")
print("\nFIN DEL PROGRAMA\n")