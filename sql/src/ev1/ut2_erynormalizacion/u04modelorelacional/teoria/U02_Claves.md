<!--
OBJETIVO: Distinguir clave candidata, primaria y ajena.
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
-->

# Claves

- **Candidata:** identifica de forma unica (puede haber varias).
- **Primaria (PK):** la candidata elegida.
- **Alternativa:** candidata no elegida (email UNIQUE).
- **Ajena (FK):** atributo que referencia la PK (u otra candidata) de otra tabla.

```text
pedidos.id_cliente  →  clientes.id_cliente
```

## Prueba tu

En clientes: id_cliente PK; email puede ser alternativa si es UNIQUE NOT NULL.
