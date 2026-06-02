# Mapa RA BOE (0485) vs repositorio

Este documento cruza los **Resultados de Aprendizaje (RA)** del modulo 0485 con la estructura real de `src/` para poder auditar cobertura didactica.

## Por que este mapa si ayuda

- El `BOE-2023-06-03-RD-405-modulo-0485-programacion.md` actual del repo solo enumera los RA (1..9), pero no desglosa criterios ni evidencias.
- Este mapa anade trazabilidad: **RA -> EV -> UT -> subtemas -> evidencia (clases/practicas)**.
- Permite detectar huecos de forma objetiva (p. ej. contenido "reservado" o subtema sin ejercicios).

## Referencias base

- BOE resumido en repo: `BOE-2023-06-03-RD-405-modulo-0485-programacion.md`
- Estructura principal: `src/ev1`, `src/ev2`, `src/ev3`

## Matriz de cobertura RA

### RA1. Reconoce la estructura de un programa informatico

- **Estado**: Cubierto.
- **EV/UT principal**: EV1 -> `ut1-fundamentos-java`.
- **Subtemas clave**:
  - `01-entorno-jvm-jdk`
  - `02-tipos-variables-conversion`
  - `03-comentarios-estilo`
- **Evidencia**:
  - estructura de fundamentos en `src/ev1/ut1-fundamentos-java/`

### RA2. Escribe y prueba programas sencillos aplicando fundamentos de POO

- **Estado**: Cubierto.
- **EV/UT principal**: EV1 -> `ut3-cadenas-envolventes-intro-poo`.
- **Refuerzo**: EV2 -> `ut5-poo-excepciones-io/01-poo-basica`.
- **Subtemas clave**:
  - `01-strings`, `02-envolventes`, `03-utilidades-y-practica`
  - `01-clases` ... `07-estatico` (POO basica)
- **Evidencia**:
  - `src/ev1/ut3-cadenas-envolventes-intro-poo/01-strings/teoria/StringIntro.java`
  - `src/ev2/ut5-poo-excepciones-io/01-poo-basica/teoria/PooBasicaIntro.java`

### RA3. Escribe y depura codigo usando estructuras de control

- **Estado**: Cubierto (con un ajuste de convencion pendiente).
- **EV/UT principal**: EV1 -> `ut2-control-flujo-metodos`.
- **Subtemas clave**:
  - `02-condicionales` (if/ifelse/switch)
  - `03-bucles` (for/while/dowhile)
  - `04-metodos`
- **Evidencia**:
  - `src/ev1/ut2-control-flujo-metodos/02-condicionales/teoria/CondicionalesComparacionIntro.java`
  - `src/ev1/ut2-control-flujo-metodos/03-bucles/teoria/BuclesComparacionIntro.java`
  - `src/ev1/ut2-control-flujo-metodos/04-metodos/teoria/MetodosIntro.java`
- **Nota**:
  - pendiente interno de normalizacion indicado en README para `01-operadores-y-basicos`.

### RA4. Desarrolla programas organizados en clases (POO)

- **Estado**: Cubierto.
- **EV/UT principal**: EV2 -> `ut5-poo-excepciones-io/01-poo-basica`.
- **Subtemas clave**:
  - `01-clases`, `02-objetos`, `03-constructores`, `04-metodos`, `05-encapsulamiento`, `06-instancias`, `07-estatico`
- **Evidencia**:
  - `src/ev2/ut5-poo-excepciones-io/01-poo-basica/teoria/01-clases/ClasesIntro.java`
  - `src/ev2/ut5-poo-excepciones-io/01-poo-basica/teoria/05-encapsulamiento/EncapsulamientoIntro.java`

### RA5. Realiza operaciones de entrada/salida con librerias del lenguaje

- **Estado**: Cubierto.
- **EV/UT principal**: EV2 -> `ut5-poo-excepciones-io/04-ficheros-io`.
- **Refuerzo**: EV2 -> `02-excepciones`.
- **Evidencia**:
  - `src/ev2/ut5-poo-excepciones-io/04-ficheros-io/teoria/FicherosIntro.java`
  - `src/ev2/ut5-poo-excepciones-io/02-excepciones/teoria/ExcepcionesIntro.java`

### RA6. Manipula informacion con tipos avanzados de datos

- **Estado**: Cubierto.
- **EV/UT principal**: EV2 -> `ut4-colecciones`.
- **Subtemas clave**:
  - `01-arrays`
  - `02-arraylist-y-mapas`
- **Evidencia**:
  - `src/ev2/ut4-colecciones/01-arrays/teoria/ArraysIntro.java`
  - `src/ev2/ut4-colecciones/02-arraylist-y-mapas/teoria/01-arraylist/ArrayListIntro.java`
  - `src/ev2/ut4-colecciones/02-arraylist-y-mapas/teoria/02-mapas/MapasIntro.java`

### RA7. Aplica caracteristicas avanzadas de lenguajes OO y entorno

- **Estado**: Cubierto (contenido de entorno avanzado parcialmente "reservado" en UT7/UT8).
- **EV/UT principal**: EV3 -> `ut6-poo-avanzada-estructuras`.
- **Subtemas clave**:
  - `01-herencia-polimorfismo`
  - `02-colecciones-estructuras`
  - practicas avanzadas en `ut9-practicas-centro` (`01-poo`, `02-gui`, `03-concurrencia-multihilo`)
- **Evidencia**:
  - `src/ev3/ut6-poo-avanzada-estructuras/01-herencia-polimorfismo/teoria/HerenciaPolimorfismoIntro.java`
  - `src/ev3/ut6-poo-avanzada-estructuras/02-colecciones-estructuras/teoria/ColeccionesEstructurasIntro.java`
  - `src/ev3/ut9-practicas-centro/teoria/PracticasCentroIntro.java`

### RA8. Utiliza bases de datos orientadas a objetos para persistencia

- **Estado**: Parcial/interpretado como persistencia JDBC relacional en este repo.
- **EV/UT principal**: EV3 -> `ut7-persistencia-jdbc-api/01-jdbc`.
- **Evidencia**:
  - `src/ev3/ut7-persistencia-jdbc-api/01-jdbc/teoria/JdbcIntro.java`
  - practica: `src/ev3/ut7-persistencia-jdbc-api/01-jdbc/practicas/sevilla-iesvelazquez-colegio-jdbc/`
- **Observacion**:
  - En el material disponible predomina JDBC/MySQL (relacional); no hay una unidad explicita de BDOO como tal.

### RA9. Gestiona informacion en bases de datos con integridad y consistencia

- **Estado**: Cubierto a nivel de enfoque (proyectos BD y transacciones), con subtemas reservados aun en EV3.
- **EV/UT principal**: EV3 -> `ut7-persistencia-jdbc-api`.
- **Subtemas clave**:
  - `01-jdbc` (incluye transacciones)
  - `02-bases-datos-y-proyectos` (proyectos de persistencia)
- **Evidencia**:
  - `src/ev3/ut7-persistencia-jdbc-api/01-jdbc/teoria/`
  - `src/ev3/ut7-persistencia-jdbc-api/02-bases-datos-y-proyectos/practicas/`

## Resumen ejecutivo de cobertura

- **Cobertura estructural por RA**: alta (RA1-RA7 y RA9 con soporte claro en UT/subtemas).
- **Zona a vigilar**:
  - RA8 por redaccion oficial (BDOO) frente a implementacion real del repo (JDBC relacional).
  - Subtemas "reservados" (`ut7/03-poo-avanzado`, `ut7/04-repaso`, `ut8/01-spring`, `ut8/03-repaso`) todavia sin desarrollo completo.
  - pendiente de convencion interna en `ut2/01-operadores-y-basicos` (segun README).

## Recomendacion practica

Para cerrar la validacion "si o si BOE", anadir en este repo un anexo con:

1. **RA -> criterios de evaluacion oficiales** (copiados/resumidos del BOE).
2. **Criterio -> evidencia concreta** (ruta de clase, practica o prueba).
3. **Estado por criterio**: cubierto / parcial / pendiente.

Con eso pasas de una comprobacion por estructura (actual) a una comprobacion curricular completa y auditable.
