<!--
OBJETIVO: Contrastar el almacenamiento en ficheros con una base de datos y motivar el diseno.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
-->

# Ficheros frente a bases de datos

En UT1 ya consultaste la BD `tienda` con SQL. Aqui damos un paso atras: **por que** existe una BD y no un monton de Excel/CSV.

## Ficheros (enfoque clasico)

- Cada aplicacion conoce el formato del fichero.
- Duplicar datos es facil (el mismo cliente en 3 sitios).
- Concurrencia e integridad: a menudo a mano.
- Busquedas complejas: lentas o imposibles sin indices propios.

## Bases de datos

- Datos **compartidos** entre aplicaciones.
- El **SGBD** controla acceso, integridad y concurrencia.
- Modelo logico (tablas/relaciones) independiente del disco.

## Puente con `tienda`

`clientes`, `productos`, `pedidos` no son tres CSV sueltos: estan relacionados (un pedido apunta a un cliente y a un producto). Eso se disena **antes** de crear tablas (UT2) y se implementa con DDL (UT3).

## Errores tipicos

- Pensar que "tener un Excel" ya es una BD relacional.
- Empezar a crear tablas sin dibujar entidades y relaciones.

## Prueba tu

Lista 3 problemas que aparecerian si `pedidos` fuera un CSV aparte sin claves.
