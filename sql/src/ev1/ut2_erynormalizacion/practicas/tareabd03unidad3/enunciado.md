<!--
OBJETIVO: Enunciado estructurado de la Tarea Unidad 3 (BD03).
@author Agustin. A. Marquez. Pina
@see mailto:agu1406@outlook.es
@see https://github.com/Agu1406/ClasesParticulares
@see https://www.agustinmarquez.dev
@since 08/11/2026
-->

# TAREA UNIDAD 3 (BD03)

## Normas de entrega

- Entrega en **UT03 – Tarea para BD03**.
- Un único PDF: `TuNombreCompleto_Documento_Tarea3.pdf` con:
  - Los **3 ejercicios** completos (obligatorio).
  - Boceto del diagrama E/R en papel (foto o escaneo).
  - Diagrama E/R con programa (imagen insertada).
  - Tablas de cada fase de normalización, indicando fase y dependencias.
  - Modelo relacional con restricciones y claves.
  - Aclaraciones a las decisiones tomadas.

---

## Ejercicio 1 — Diseño modelo Entidad/Relación

La Sociedad Pública de Alquiler (Ministerio de la Vivienda) necesita una BD para gestionar alquileres de viviendas de particulares.

Requisitos:

- Histórico de alquileres de cada vivienda (duración / secuencia en el tiempo).
- De cada **alquiler**: identificador único, fecha inicio, fecha fin, importe mensual, fianza, fecha de la firma.
- Saber si un alquiler es **renovación** de otro alquiler anterior (misma persona / vivienda) para seguir la secuencia.
- Un alquiler lo realiza un **inquilino**: id, NIF, nombre, apellidos, fecha de nacimiento, teléfono.
- **Agencias inmobiliarias** que gestionan alquileres: id agencia, CIF, dirección, teléfono.
- Una vivienda se oferta en **una única** agencia. Una agencia solo gestiona alquileres de las viviendas que oferta ella.
- **Vivienda**: id, calle, número, piso, código postal, población, descripción.
- Una vivienda pertenece a un único **propietario**; un propietario puede tener muchas viviendas.
- **Propietario**: id, NIF, nombre, apellidos, teléfono, dirección, email.

---

## Ejercicio 2 — Normalización hasta 3FN

Aplica la normalización a la tabla siguiente hasta **3FN**, pasando por todas las formas previas necesarias. Justifica e indica dependencias.

```text
ordenes (id_orden, fecha, id_cliente, nom_cliente, estado,
         num_art, nom_art, cant, precio)
```

| Id_orden | Fecha    | Id_cliente | Nom_cliente | Estado  | Num_art | nom_art  | cant | Precio |
|----------|----------|------------|-------------|---------|---------|----------|------|--------|
| 2301     | 23/02/11 | 101        | Martin      | Caracas | 3786    | Red      | 3    | 35,00  |
| 2301     | 23/02/11 | 101        | Martin      | Caracas | 4011    | Raqueta  | 6    | 65,00  |
| 2301     | 23/02/11 | 101        | Martin      | Caracas | 9132    | Paq-3    | 8    | 4,75   |
| 2302     | 25/02/11 | 107        | Herman      | Coro    | 5794    | Paq-6    | 4    | 5,00   |
| 2303     | 27/02/11 | 110        | Pedro       | Maracay | 4011    | Raqueta  | 2    | 65,00  |
| 2303     | 27/02/11 | 110        | Pedro       | Maracay | 3141    | Funda    | 2    | 10,00  |

---

## Ejercicio 3 — E/R → modelo relacional (sedes / complejos)

Transforma el modelo E/R de la página 3 del PDF (`_refs/TAREA_UNIDAD_3.pdf`) al **modelo relacional**.

Indica restricciones **PK, FK, NN, UQ**. Explica cómo resuelves la **ISA**.

Requisitos adicionales del enunciado:

- No puede haber dos jefes de organización iguales.
- Número de comisarios, participantes y complejos **no puede ser nulo**.

Resumen del diagrama (Chen):

- **SEDES** — Dividen — **COMPLEJOS** (1 sede, varios complejos).
- **COMPLEJOS** — Celebra — **EVENTOS**.
- **EVENTOS** — Involucrado (atributo Tarea) — **COMISARIOS** (N:M).
- ISA (COMPLEJOS): **UNIC.DEPORTE** | **POLIDEPORTIVO**.
- **Areas** (entidad débil) de POLIDEPORTIVO.
