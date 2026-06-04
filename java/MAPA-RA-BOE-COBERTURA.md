# Mapa RA BOE (0485) vs repositorio

Este documento cruza los **Resultados de Aprendizaje (RA)** del modulo 0485 con la estructura real de `src/` para poder auditar cobertura didactica.

## Por que este mapa si ayuda

- El `BOE-2023-06-03-RD-405-modulo-0485-programacion.md` actual del repo solo enumera los RA (1..9), pero no desglosa criterios ni evidencias.
- Este mapa anade trazabilidad: **RA -> EV -> UT -> subtemas -> evidencia (clases/practicas)**.
- Permite detectar huecos de forma objetiva (p. ej. contenido "reservado" o subtema sin ejercicios).

## Referencias base

- BOE resumido en repo: `BOE-2023-06-03-RD-405-modulo-0485-programacion.md`
- Estructura principal: `src/ev1`, `src/ev2`, `src/ev3` (UT cortas: `ut1`, `ut4`, `ut7`, … sin guiones)

## Matriz de cobertura RA

### RA1. Reconoce la estructura de un programa informatico

- **Estado**: Cubierto.
- **EV/UT principal**: EV1 -> `ut1`.
- **Subtemas clave**: `entornojvmjdk`, `tiposvariablesconversion`, `comentariosestilo`
- **Evidencia**: `src/ev1/ut1/`

### RA2. Escribe y prueba programas sencillos aplicando fundamentos de POO

- **Estado**: Cubierto.
- **EV/UT principal**: EV1 -> `ut3`.
- **Refuerzo**: EV2 -> `ut5/poobasica`.
- **Subtemas clave**: `strings`, `envolventes`, `utilidadesypractica`; POO en `poobasica`
- **Evidencia**:
  - `src/ev1/ut3/strings/teoria/u01/StringIntro.java`
  - `src/ev2/ut5/poobasica/teoria/u08/PooBasicaIntro.java`

### RA3. Escribe y depura codigo usando estructuras de control

- **Estado**: Cubierto.
- **EV/UT principal**: EV1 -> `ut2`.
- **Subtemas clave**: `condicionales`, `bucles`, `metodos`, `operadoresybasicos`
- **Evidencia**:
  - `src/ev1/ut2/condicionales/teoria/u04/CondicionalesComparacionIntro.java`
  - `src/ev1/ut2/bucles/teoria/u04/BuclesComparacionIntro.java`
  - `src/ev1/ut2/metodos/teoria/u01/MetodosIntro.java`

### RA4. Desarrolla programas organizados en clases (POO)

- **Estado**: Cubierto.
- **EV/UT principal**: EV2 -> `ut5/poobasica`.
- **Evidencia**:
  - `src/ev2/ut5/poobasica/teoria/u01/ClasesIntro.java`
  - `src/ev2/ut5/poobasica/teoria/u03/EncapsulamientoIntro.java`

### RA5. Realiza operaciones de entrada/salida con librerias del lenguaje

- **Estado**: Cubierto.
- **EV/UT principal**: EV2 -> `ut5/ficherosio`.
- **Refuerzo**: EV2 -> `ut5/excepciones`.
- **Evidencia**:
  - `src/ev2/ut5/ficherosio/teoria/u02/FicherosIntro.java`
  - `src/ev2/ut5/excepciones/teoria/u01/ExcepcionesIntro.java`

### RA6. Manipula informacion con tipos avanzados de datos

- **Estado**: Cubierto.
- **EV/UT principal**: EV2 -> `ut4`.
- **Subtemas clave**: `arrays`, `arraylistymapas`
- **Evidencia**:
  - `src/ev2/ut4/arrays/teoria/u01/ArraysIntro.java`
  - `src/ev2/ut4/arraylistymapas/teoria/u01/ArrayListIntro.java`
  - `src/ev2/ut4/arraylistymapas/teoria/u02/MapasIntro.java`

### RA7. Aplica caracteristicas avanzadas de lenguajes OO y entorno

- **Estado**: Cubierto (contenido de entorno avanzado parcialmente "reservado" en UT7/UT8).
- **EV/UT principal**: EV3 -> `ut6`.
- **Subtemas clave**: `herenciapolimorfismo`, `coleccionesestructuras`, `concurrenciamultihilo`
- **Evidencia**:
  - `src/ev3/ut6/herenciapolimorfismo/teoria/u04/HerenciaPolimorfismoIntro.java`
  - `src/ev3/ut6/coleccionesestructuras/teoria/u01/ColeccionesEstructurasIntro.java`
  - UT9 PF: `src/ev3/ut9/pf/`

### RA8. Utiliza bases de datos orientadas a objetos para persistencia

- **Estado**: Parcial/interpretado como persistencia JDBC relacional en este repo.
- **EV/UT principal**: EV3 -> `ut7/jdbc`.
- **Evidencia**:
  - `src/ev3/ut7/jdbc/teoria/u06/JdbcIntro.java`
  - practica: `src/ev3/ut7/jdbc/practicas/sevillaiesvelazquezcolegiojdbc/`
- **Observacion**: En el material disponible predomina JDBC/MySQL (relacional); no hay una unidad explicita de BDOO como tal.

### RA9. Gestiona informacion en bases de datos con integridad y consistencia

- **Estado**: Cubierto a nivel de enfoque (proyectos BD y transacciones), con subtemas reservados aun en EV3.
- **EV/UT principal**: EV3 -> `ut7`.
- **Subtemas clave**: `jdbc`, `basesdatos`, `bdoo`, `repaso`
- **Evidencia**:
  - `src/ev3/ut7/jdbc/teoria/`
  - `src/ev3/ut7/basesdatos/practicas/`
  - Bili / examen biblioteca: `src/ev3/ut7/u02basesdatos/practicas/proyectoexamenbibliotecaapi/`

## Resumen ejecutivo de cobertura

- **Cobertura estructural por RA**: alta (RA1-RA7 y RA9 con soporte claro en UT/subtemas).
- **Zona a vigilar**:
  - RA8 por redaccion oficial (BDOO) frente a implementacion real del repo (JDBC relacional).
  - Subtemas reservados en `ut7` / `ut8` sin desarrollo completo.
  - Convencion de teoría en carpetas `u01`…`uNN` (orden didactico; ver `README.md`).

## Recomendacion practica

Para cerrar la validacion "si o si BOE", anadir en este repo un anexo con:

1. **RA -> criterios de evaluacion oficiales** (copiados/resumidos del BOE).
2. **Criterio -> evidencia concreta** (ruta de clase, practica o prueba).
3. **Estado por criterio**: cubierto / parcial / pendiente.

Con eso pasas de una comprobacion por estructura (actual) a una comprobacion curricular completa y auditable.
