# Matriz BOE 0485 por criterios (RA -> criterios -> evidencia)

Fuente normativa usada: `BOE-A-2023-13221` (texto oficial del modulo `0485 Programación`, seccion "Resultados de aprendizaje y criterios de evaluación").

Convencion de estado:

- **C** = cubierto con evidencia clara en el repo.
- **P** = parcial (hay base, pero no cobertura completa/evidencia debil).
- **F** = falta o no se identifica evidencia.

---

## RA1. Estructura de programa

| Criterio | Estado | Evidencia repo |
|---|---|---|
| a) Bloques de un programa | C | `src/ev1/ut1-fundamentos-java/` |
| b) Proyectos de desarrollo | C | estructura por EV/UT/subtemas y practicas en `src/` |
| c) Uso de IDE | P | implícito en flujo, no hay practica dedicada de entorno |
| d) Tipos de variables | C | `ut1/02-tipos-variables-conversion` |
| e) Crear/usar variables modificando codigo | C | ejercicios EV1 UT1/UT2 |
| f) Constantes y literales | C | EV1 fundamentos y ejercicios |
| g) Operadores en expresiones | C | `ut2/01-operadores-y-basicos` |
| h) Conversiones explicitas/implicitas | C | `ut1/02-tipos-variables-conversion` |
| i) Comentarios en codigo | C | convención de JavaDoc en todo el repo |

## RA2. Programas sencillos con POO

| Criterio | Estado | Evidencia repo |
|---|---|---|
| a) Fundamentos POO identificados | C | `ut5/01-poo-basica/teoria/PooBasicaIntro.java` |
| b) Programas simples | C | ejercicios EV1/EV2 |
| c) Instanciacion de objetos | C | `ut5/01-poo-basica/teoria/02-objetos` |
| d) Uso de metodos/propiedades | C | `ut5/01-poo-basica/teoria/04-metodos` |
| e) Llamadas a metodos estaticos | C | `ut5/01-poo-basica/teoria/07-estatico` |
| f) Parametros en metodos | C | `ut2/04-metodos` + POO basica |
| g) Incorporar librerias de objetos | P | uso de librerias Java, no bloque especifico dedicado |
| h) Uso de constructores | C | `ut5/01-poo-basica/teoria/03-constructores` |
| i) Uso de IDE en compilacion | P | implícito, no evidencia didactica explicita |

## RA3. Estructuras de control y depuracion

| Criterio | Estado | Evidencia repo |
|---|---|---|
| a) Estructuras de seleccion | C | `ut2/02-condicionales` |
| b) Estructuras de repeticion | C | `ut2/03-bucles` |
| c) Sentencias de salto | P | presentes en ejercicios, no subtema propio |
| d) Control de excepciones | C | `ut5/02-excepciones` |
| e) Ejecutables con distintas estructuras | C | practicas y ejercicios mixtos |
| f) Prueba y depuracion | P | existe repaso/practicas, no bloque de testing formal |
| g) Comentado/documentado | C | JavaDoc y comentarios en clases |
| h) Creacion de excepciones | C | `ut5/02-excepciones` |
| i) Aserciones para detectar errores | F | no se ve cobertura explicita de `assert` |

## RA4. Programas organizados en clases

| Criterio | Estado | Evidencia repo |
|---|---|---|
| a) Sintaxis/estructura de clase | C | `ut5/01-poo-basica/teoria/01-clases` |
| b) Definicion de clases | C | ejercicios `01-clases` |
| c) Propiedades y metodos | C | `04-metodos`, `05-encapsulamiento` |
| d) Constructores | C | `03-constructores` |
| e) Instanciar y usar objetos | C | `02-objetos` + ejercicios |
| f) Control de visibilidad | C | `05-encapsulamiento` |
| g) Clases heredadas | C | `ev3/ut6/01-herencia-polimorfismo` |
| h) Metodos estaticos | C | `07-estatico` |
| i) Conjuntos/librerias de clases | C | `ut4` colecciones + proyectos |

## RA5. Entrada y salida de informacion

| Criterio | Estado | Evidencia repo |
|---|---|---|
| a) E/S por consola | C | ejercicios base EV1/EV2 |
| b) Formatos de visualizacion | P | se usa en ejercicios, poca teoria focalizada |
| c) Posibilidades E/S y librerias | C | `ut5/04-ficheros-io` |
| d) Ficheros para almacenar/recuperar | C | `ut5/04-ficheros-io` |
| e) Metodos de acceso a ficheros | C | ejercicios `pendientes/resueltos` de ficheros |
| f) GUI simple con herramientas IDE | P | hay GUI en `ut9/02-gui`, no orientado al criterio IDE |
| g) Programacion de eventos | P | aparece en GUI practicas, no subtema formal |
| h) GUI para E/S | P | presente en practicas GUI, no cobertura sistematica |

## RA6. Tipos avanzados de datos

| Criterio | Estado | Evidencia repo |
|---|---|---|
| a) Arrays | C | `ut4/01-arrays` |
| b) Librerias de datos avanzados | C | `ut4/02-arraylist-y-mapas` |
| c) Listas para procesar info | C | `ArrayListIntro` + ejercicios |
| d) Iteradores en listas | C | aparece en practicas (`Iterator`) |
| e) Ventajas de colecciones | C | teoria de mapas/colecciones |
| f) Clases y metodos genericos | P | uso parcial, no bloque explicito fuerte |
| g) Expresiones regulares | P | cobertura no homogénea en UT |
| h) Clases para lenguajes intercambio datos | P | aparece por proyectos, no subtema claro |
| i) Manipular documentos intercambio datos | P | parcial (proyectos concretos) |
| j) Operaciones agregadas en colecciones | P | uso parcial; faltaria cobertura didactica sistematica |

## RA7. Caracteristicas avanzadas OO y entorno

| Criterio | Estado | Evidencia repo |
|---|---|---|
| a) Herencia/super/subclase | C | `ut6/01-herencia-polimorfismo` |
| b) Modificadores que bloquean/fuerzan herencia | P | parcialmente tocado, no subtema dedicado |
| c) Constructores en herencia | C | ejemplos de herencia UT6 |
| d) Sobrescritura de metodos | C | polimorfismo UT6 |
| e) Jerarquias de clases | C | UT6 + practicas UT9 |
| f) Probar/depurar jerarquias | P | evidencia practica, no bloque formal de depuracion |
| g) Programas con jerarquias | C | ejercicios y practicas EV3 |
| h) Comentado/documentado | C | JavaDoc en clases principales |
| i) Escenarios de uso de interfaces | P | hay material, cobertura no completa/homogenea |
| j) Herencia vs composicion | P | aparece en practicas, no subtema teorico explicito |

## RA8. BDOO y persistencia de objetos

| Criterio | Estado | Evidencia repo |
|---|---|---|
| a) Caracteristicas BDOO | F | no se identifica unidad BDOO dedicada |
| b) Aplicacion en OO | P | enfoque de persistencia existe, pero en relacional/JDBC |
| c) Instalacion de SGBD orientado a objetos | F | no evidenciado |
| d) Metodos de gestion del SGBDOO | F | no evidenciado |
| e) BD y estructuras para objetos | F | no evidenciado como BDOO |
| f) Almacenar objetos en BDOO | F | no evidenciado |
| g) Recuperar/actualizar/eliminar objetos en BDOO | F | no evidenciado |
| h) Tipos estructurados/compuestos/relacionados en BDOO | F | no evidenciado |

## RA9. Gestion de datos con integridad y consistencia

| Criterio | Estado | Evidencia repo |
|---|---|---|
| a) Caracteristicas/metodos de acceso a SGBD | C | `ut7/01-jdbc/teoria` |
| b) Conexiones a BD | C | practica `colegio-jdbc` |
| c) Almacenamiento de informacion en BD | C | DAO y operaciones SQL |
| d) Recuperar/mostrar informacion | C | `AlumnosDAO`, demos |
| e) Borrados y modificaciones | C | CRUD en practicas JDBC |
| f) Apps que muestren informacion de BD | C | demos/proyectos en UT7 |
| g) Apps para gestionar informacion de BD | C | `ut7/02-bases-datos-y-proyectos/practicas` |

---

## Diagnostico global

- **Cobertura fuerte**: RA1, RA2, RA4, RA9.
- **Cobertura buena con matices**: RA3, RA5, RA6, RA7.
- **Brecha principal**: **RA8** (BOE pide BDOO explícita y en el repo predomina JDBC relacional).

## Acciones recomendadas (ordenadas por impacto)

1. Crear en EV3 un subtema explícito para **RA8 BDOO** (aunque sea mínimo con teoría + práctica guiada).
2. Añadir bloque breve de **aserciones (`assert`)** para cerrar RA3.i.
3. Refuerzo focalizado en RA5 (GUI/eventos con objetivo de criterio) y RA6 (genéricos/regex/formatos de intercambio).
4. Mantener este archivo como checklist vivo: cuando cierres un criterio, cambia `P/F` a `C` con evidencia concreta.
