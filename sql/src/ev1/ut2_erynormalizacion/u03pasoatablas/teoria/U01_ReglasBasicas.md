<!--
OBJETIVO: Enunciar las reglas basicas de transformacion E/R a tablas.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
-->

# Del E/R a tablas — reglas basicas

1. **Cada entidad fuerte** → una tabla; identificador → PK.
2. Atributos simples → columnas.
3. Atributos compuestos → columnas separadas (calle, ciudad...) o una sola si no se consultan partes.
4. Multivalor → **tabla aparte** (o modelado previo).

Aun no escribimos `CREATE TABLE` completo (UT3): aqui dejamos el **esquema logico**.

```text
Cliente(id_cliente, nombre, apellidos, email, ...)
```
