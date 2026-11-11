"""
U06 — Repaso strings.

OBJETIVO:
  - Integrar strip, indices, metodos, formato y join en un mini flujo.
  - Servir de mapa mental antes de los ejercicios E01-E12.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
"""

print("\n¡INICIO DEL PROGRAMA!\n")

crudo = "  ana lopez, nota 8.5  "
limpio = crudo.strip()
print("1) limpio:", repr(limpio))

# partir por coma
trozos = limpio.split(",")
nombre = trozos[0].strip().title()
resto = trozos[1].strip()
print("2) nombre:", nombre)

# sacar el numero al final (tras la ultima palabra)
palabras = resto.split()
nota_texto = palabras[-1]
nota = float(nota_texto)
print("3) nota:", nota)

linea = f"{nombre:<12} | {nota:^6.1f} | {'OK' if nota >= 5 else 'KO'}"
print("4) ficha:", linea)

piezas = [nombre, "aprobado" if nota >= 5 else "suspendido"]
print("5) join:", " — ".join(piezas))

print("\nMapa: U01 indices · U02 inmutabilidad · U03 metodos · U04 formato · U05 join")
print("\n¡FIN DEL PROGRAMA!\n")
