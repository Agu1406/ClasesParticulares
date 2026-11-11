<!--
OBJETIVO: Explicar integridad de entidad y referencial.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
-->

# Integridad

## De entidad

La PK **no puede ser NULL** (ni parcial en PK compuesta).

## Referencial

Toda FK es NULL (si se permite) o existe en la tabla referenciada.

Opciones al borrar/actualizar el padre (preview UT3/UT5): RESTRICT, CASCADE, SET NULL...

## Dominio

Los valores respetan el tipo/rango (CHECK en DDL).

## Prueba tu

Si borras un cliente con pedidos y hay FK RESTRICT: que ocurre?
