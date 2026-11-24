# Ejercicio 4 — Filtrado PGM (pendiente material del curso)

## Qué pide (en cristiano)

Una imagen PGM en gris es una **matriz de enteros 0..255** (un píxel = un número).
Filtrar = aplicar una **máscara 3×3** (media, bordes, etc.) a cada píxel usando sus vecinos.

En paralelo: repartes trozos de la imagen entre procesos MPI, cada uno filtra su trozo
(cuidado con los bordes del trozo: necesitan píxeles del vecino), y luego juntáis el resultado.

El enunciado exige nombres: `aplicaFiltro`, `tIni`, `tFin`, `TagN`, y medir tiempos.

## Por qué no hay `.c` todavía

El curso da un **ZIP** con funciones C de leer/escribir PGM. Sin ese ZIP no inventamos
la I/O oficial (cambiaría el formato de entrega).

Cuando tengas el ZIP:

1. Colócalo en esta carpeta (o en `madrid/uned/`).
2. Escribimos juntos `Ej4_…_Pendiente.c` / `_Resuelto.c`.
3. Uso típico: `mpirun -np K ./ej4 entrada.pgm numero_filtro salida.pgm`

## Mientras tanto

Machaca ej1–ej3 y los exámenes en `../../examenes/`: eso sí cae igual en la práctica
y en la prueba presencial.
