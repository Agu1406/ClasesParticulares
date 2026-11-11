<!--
OBJETIVO: Asignar cardinalidades 1:1, 1:N y N:M leyendo el enunciado.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
-->

# Cardinalidades

Responden: **cuantas** ocurrencias de B se relacionan con una de A (y al reves).

| Tipo | Lectura | Ejemplo |
|------|---------|---------|
| 1:1 | uno a uno | Persona — Pasaporte |
| 1:N | uno a muchos | Cliente — Pedidos |
| N:M | muchos a muchos | Alumno — Curso |

Notacion frecuente (min,max): Cliente (1,1) —— (0,N) Pedido  
= un pedido tiene exactamente 1 cliente; un cliente puede tener 0..N pedidos.

## Como decidirlo

Lee el negocio: "un pedido pertenece a **un** cliente" → lado pedido = 1.
"un cliente puede tener **varios** pedidos" → lado cliente = N.

## Prueba tu

Autor — Libro (un libro un autor vs varios autores): 1:N o N:M?
