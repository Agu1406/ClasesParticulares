<!--
OBJETIVO: Definir relacion, tupla, atributo y dominio en el modelo relacional.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
-->

# Modelo relacional — piezas

| Termino | Significado | En SQL lo ves como |
|---------|-------------|--------------------|
| Relacion | tabla | `productos` |
| Tupla | fila | una fila de productos |
| Atributo | columna | `precio` |
| Dominio | valores permitidos | DECIMAL, VARCHAR, DATE |
| Grado | nº atributos | nº columnas |
| Cardinalidad | nº tuplas | nº filas |

Una relacion es un **conjunto** de tuplas (sin duplicados teoricos; en SQL puede haberlos sin PK).
