<style>
    /* Justificar todo el texto del documento. */
    * {
        text-align: justify;
    }
    /* Centrar todos los encabezados. */
    h1, h2, h3, h4 {
        text-align: center;
    }
    /* Centrar el contenido dentro de las celdas */
    table th, table td {
        text-align: center;
    }

</style>

# Clase de repaso general

## Índice de los apuntes

1. [Estructura de una base de datos](#estructura-de-la-base-de-datos)
2. [Diagramas de entidad relación (ER)](#diagramas-de-entidad-relacion)
3. [Conceptos fundamentales de SQL](#conceptos-fundamentales-de-sql)
4. [Tipos de JOIN](#tipos-de-joins)
5. [Funciones de fecha (YEAR)](#años-year-en-mysql)
6. [ORDER BY](#ordenar-resultados-de-consultas-en-sql-con-order-by)
7. [GROUP BY](#group-by-en-sql)
8. [HAVING](#having-en-sql)
9. [Fuentes e información](#fuentes-e-información)

## **Estructura de la base de datos.**

La base de datos `viviendas` es una base de datos compuesta por cuatro tablas, su objetivo es relacionar las **personas** que **habitan** una o varias **viviendas** que pertenecen a diferentes **zonas.**

### **Tabla `personas`**

| Columna | Tipo | Descripción |
|---------|------|-------------|
|**dni**|**CHAR(10)**| Sirve para guardar el DNI de las personas de la tabla. |
|**nombre**|**CHAR(20)**| Sirve para guardar el DNI de las personas de la tabla. |
|**apellidos**|**CHAR(20)**| Sirve para guardar el DNI de las personas de la tabla. |
|**dni_padre**|**CHAR(10)**| Sirve para guardar el DNI de las personas de la tabla. |

### **Tipos de variables SQL y sus modificadores**

#### **Tipos de variables**

**CHAR** viene de la palabra en inglés **CHARACTER** que significa carácter, en **SQL** cuando queremos guardar letras, palabras, texto, parrafos, etc, usamos el **tipo de variable CHAR**, cuando le decimos a **SQL** que lo que queremos guardar es carácteres (CHAR) también tenemos que decirle el tamaño maximo del texto que va a guardar.

Al nosotros decirle a **SQL** que usaremos una varible del tipo **CHAR(10)** estamos indicando en el parentesis que el tamaño maximo de letras/números que podremos escribir ahí es de 10 carácteres, ejemplos:

- `12345ABCDE` (10 carácteres) - **¿Funcionaria?** Sí, tiene exactamente 10 carácteres.
- `12345ABCD` (9 carácteres) - **¿Funcionaria?** Sí, tiene 9 carácteres y el maximo que puedo tener son 10, mientras no me pase, todo ok.
- `1A` **¿Funcionaria?** Sí, no tienen ingún sentido, no existen **DNI** de dos letras/números, pero no excede el limite que son 10 carácteres.
- `12345ABCDEF` (11 carácteres) - **¿Funcionaria?** No funcionaria, basta con exceder 1 solo carácter el tamaño y ya no funciona.

#### **Tipos de modificadores**

- `NOT NULL` - Cuando queremos que un dato sea obligatorio para formar parte de una tabla usamos **NOT NULL**, por ejemplo, al abrir una cuenta en el banco hay ciertos datos que son obligatorios aunque yo no lo quiera, mi **DNI**, mi **nombre completo** y mi **fecha de nacimiento**, en la tabla de viviendas es obligatorio que todas las personas se den de alta con su **DNI**.

- `DEFAULT NULL` - Al contrario que con **NOT NULL** es aquella información que no es obligatoria, por ejemplo, en **viviendas** es obligatorio darte de alta con tú **DNI**, pero eres un tio raro y no quieres que nadie sepa cual es tú nombre ni cual es tú apellido, entonces **DEFAULT NULL** pone por defecto un **NULL** en aquellos campos que esten vacios, si yo me doy de alta con el DNI 1234ABCDE y no digo mi nombre mis apellido en la base de datos habrá algo parecido a lo siguiente:

| DNI | Apellidos | Nombre |
|-----|-----------|--------|
|**1234ABCDE**|**NULL**| **NULL** |
|**4321SDFGH**|**Piña**| **Agustín** |
|**4567ASDFG**|**NULL**| **Mary** |

- `PRIMARY KEY` - En la vida real existen docenas, si no, quizás miles de personas con el mismo nombre, la misma fecha de nacimiento, la misma edad que tú y que yo, mi nombre es **Agustín Antonio Marquez Piña**, naci el **14/06/2000** y mi edad son **26 años**, buscando en intener puedes conseguír solo en España aprox. 12.374 personas con el mismo nombre, fecha de cumpleaños y edad, entonces, **¿Que hacé el banco para saber si la cuenta es mía o es de ellos?** necesitan usar un dato (un trozo de información) que sea unico y solamente mio, que nadie más tenga uno igual, por ejemplo, el **DNI**, un código unico, irrepetible, que te acompaña desde que naces y mucho después de la muerte.

- `FOREIGN KEY` - Yo trabajo en **COSTCO**, la empresa tiene una base de datos con una tabla llamada **empleados**, cuando alguien de la empresa, por ejemplo, **RRHH** necesita revisar mi expediente para ver si estoy loquito o estoy cuerdo, ellos pueden usar dos cosas para obtener mi información, el **DNI** (un código unico que solamente tengo yo en el mundo) o mi **Código de empleado**, que es un código unico e irrpetible que la empresa me da a mi por ser empleado, ambas cosas cumplen el mismo rol, pero una de ellas es más importante para la empresa que la otra.

Lo normal es que las empresas usen los **códigos de empleado** como **primary key**, a través de esos códigos pueden consultar información de sus empleados, pero a veces, por ejemplo, cuando un empleado es demasiado nuevo y aún no tiene código de empleado, podemos usar algo alternativo para conseguír su información, eso es una **foreign key**, es una "clave alternativa".

#### **EJEMPLO DE TABLA FICTICIA**

| DNI | Apellidos | Nombre | DNI_padre |
|-----|-----------|--------|-----------|
|**1234ABCDE**|**NULL**| **NULL** ||
|**4321SDFGH**|**Piña**| **Agustín** | **56475SADA** |
|**4321SDFGH**|**Piña**| **Agustína** | **56475SADA** |
|**4567ASDFG**|**NULL**| **Mary** ||
|**56475SADA**|**Marquez**| **Francisco** ||

#### **EJEMPLO DE PSEUDO-CONSULTA**

```sql
SELECT Apellidos FROM Personas WHERE DNI_padre = 56475SADA;
```

#### **EJEMPLO DE LA RESPUESTA DE LA PSEUDO-CONSULTA**

| DNI | Apellidos | Nombre | DNI_padre |
|-----|-----------|--------|-----------|
|**4321SDFGH**|**Piña**| **Agustín** | **56475SADA** |
|**4321SDFGH**|**Piña**| **Agustína** | **56475SADA** |

## **Diagramas de entidad relacion**

```
┌───────────────────┐
|   PERSONAS        |
├───────────────────┤
|   (PK) DNI        | => 1234ABCD   => 12354HFD => 34737FHD
|   nombre          | => Agustín    => Bárbara  => Vanessa
|   apellidos       | => Piña       => Piña     => Vidal
| (FK) DNI_padre    | => NULL       => NULL     => NULL
└──────┬────────────┘
       |
       |    1 (Una persona puede habitar como minímo una vivienda).
       |    N (Una persona puede habitar comno maximno maximo varias viviendas).
       |
┌───────▼────────────┐
│     HABITAR        │
├────────────────────┤
│ PK,FK dni          │ => 1234ABCD   => 12354HFD => 34737FHD => 1234ABCD
│ PK,FK              │ => CODV2025   => CODV2025 => CODV2025 => COVD2024
│ cod_vivienda       │ => 14/06/00   => 02/11/95 => 07/14/03 => NULL
│ fecha_inicio       │ 
└───────▲────────────┘
        |
        | N (Las viviendas pueden ser habitadas por maximo varias persona).
        | 1 (Las viviendas pueden ser habitadas por minímo una persona).
        |
┌───────┴───────────┐
│     VIVIENDAS     │
├───────────────────┤
│ PK cod_vivienda   │ => COD2025
│ calle             │ => Avenida Coruña
│ numero            │ => 58
│ piso              │ => 2
│ etc...            │ => E
└───────┬───────────┘
        |
        |
        |
┌───────┴───────────┐
│     ZONAS         │
├───────────────────┤
│ PK nombre_zona    │
│ descripción       │ 
└───────────────────┘
```

## **Conceptos fundamentales de SQL**

### **SELECT - Consultar/leer/ver datos**

¿Para que se usa **SELECT**? Cuando deseamos ver/obtener la información de algo sin modificarla, borrarla ni editarla, por ejemplo, si quiero ver el nombre de una persona y nada más, solo verlo, usaría **SELECT.**

Vamos a usar de ejemplo la tabla real que tenemos en **viviendas** llamada **personas**:

| DNI | Apellidos | Nombre | DNI_padre |
|-----|-----------|--------|-----------|
|**1234ABCDE**|**NULL**| **NULL** | **NULL** |
|**4321SDFGH**|**Piña**| **Agustín** | **56475SADA** |
|**4321SDFGH**|**Piña**| **Agustína** | **56475SADA** |
|**4567ASDFG**|**NULL**| **Mary** | **NULL** |
|**56475SADA**|**Marquez**| **Francisco** | **NULL** |

Cuando usamos **SELECT** tengo que decirle que columnas quiero ver, de que tabla (**"WHERE"**) quiero verlas y si necesito filtrarlas basandome en alguna condición (**"FROM"**), ejemplo: 

```sql
SELECT columna1, columna2 FROM tabla WHERE condicion;
```

#### **Ejemplo: ver nombres y apellidos de todas las personas**

```sql
SELECT Nombre, Apellidos FROM personas;
```

**Resultado:**

| Apellidos | Nombre |
|-----------|--------|
| NULL | NULL |
| Piña | Agustín |
| Piña | Agustína |
| NULL | Mary |
| Marquez | Francisco |

#### **Ejemplo: nombres que empiecen por la letra A**

`A%` = cualquier texto que **empiece** con "A". El `%` va al final.

```sql
SELECT Nombre, Apellidos FROM personas WHERE nombre LIKE 'A%';
```

**Resultado:**

| Apellidos | Nombre |
|-----------|--------|
| Piña | Agustín |
| Piña | Agustína |

#### **Ejemplo: nombres que terminen con la letra Y**

`%Y` = cualquier texto que **termine** con "Y". El `%` va al principio.

```sql
SELECT Nombre, Apellidos FROM personas WHERE nombre LIKE '%Y';
```

**Resultado:**

| Apellidos | Nombre |
|-----------|--------|
| NULL | Mary |

#### **Ejemplo: ver todos los datos de una tabla**

El asterisco (`*`) significa "todo" — muestra todas las columnas sin filtrar.

```sql
SELECT * FROM personas;
```

**Resultado:**

| DNI | Apellidos | Nombre | DNI_padre |
|-----|-----------|--------|-----------|
| 1234ABCDE | NULL | NULL | NULL |
| 4321SDFGH | Piña | Agustín | 56475SADA |
| 4321SDFGH | Piña | Agustína | 56475SADA |
| 4567ASDFG | NULL | Mary | NULL |
| 56475SADA | Marquez | Francisco | NULL |

### **WHERE - Filtrado de resultados.**

Con **SELECT** podemos elegir todos los datos de una tabla pero cuando necesitamos recudir los datos a unos pocos usando filtros (ejemplo, solo aquellas viviendas que tengan más de 30 metros cuadrados, solo aquellas viviendas que estén en la zona centro de la ciudad, solo aquellas personas cuyo nombre sea Juan, etc) tenemos que usar **WHERE** que, usando una simbología informatica (simbolos) permite filtrar resultados, está simbología se explica a continuación:

**Operadores de comparación:**

- "=": Cuando necesito que dos cosas sean exactamente iguales, ejemplo, busca el nombre de la persona cuyo DNI es el siguiente... `SELECT nombre FROM personas WHERE DNI = 1234AVCDE;`.
- "!=": Cuando necesito ver todos los resultados que no coincidan, ejemplo, busca viviendas que no esten en la zona centro... `SELECT * FROM vivienda WHERE nombre_zona != "Centro";`.
- ">": Filtro que uso cuando necesito que el valor de "X" campo sea mayor a un número que yo le de, ejemplo, necesito ver solo las viviendas que tengan más de 70 metros de superficie... `SELECT * FROM viviendas WHERE metros > 70;`
- "<": Filtro que uso cuando necesito que el valor de "X" campo sea menor a un número que yo le de, ejemplo, necesito ver solo las viviendas que tengan menos de 100 metros de superficie... `SELECT * FROM viviendas WHERE metros < 100;`
- ">=": Filtro que uso cuando necesito que el valor de "X" campo sea mayor o igual a un número que yo le de, ejemplo, necesito ver solo las viviendas que tengan más de 70 metros o 70 metros exactos de superficie  ... `SELECT * FROM viviendas WHERE metros >= 70;`
- "<=": Filtro que uso cuando necesito que el valor de "X" campo sea menor o igual a un número que yo le de, ejemplo, necesito ver solo las viviendas que tengan menos de 100 metros o 100 metros exactos de superficie... `SELECT * FROM viviendas WHERE metros <= 100;`

**Operadores logicos:**

- "AND" - Filtro que uso cuando necesito que se cumplan todas las condiciones, por ejemplo, quiero ver toda la información de los pisos que cumplan con las siguientes dos condiciones, superficie de más de 70 metros pero de menos de 100... `SELECT * FROM viviendas WHERE metros >= 70 AND metros <= 100;`
- "OR" - Filtro que uso cuando quiero que se cumpla al menos una de las condiciones, si son todas o no son todas, no pasa nada, pero al menos una, ejemplo, necesito ver de la tabla de personas todos los nombres y apellidos de las personas cuyo nombre empiecen con la letra "A" o terminen con la letra "Y"... `SELECT nombre, apellidos FROM personas WHERE nombre LIKE "A%" OR nombre LIKE "%Y";`.
- "NOT" - Filtro que uso cuando solo quiero ver resultados que no cumplan con el filtro, por ejemplo, quiero ver pisos que **NO** estén en la zona centro ni el sector norte... `SELECT * FROM viviendas WHERE nombre_zona NOT "centro" OR NOT "sector norte`
- "IN" - Filtro que uso cuando quiero agrupar diferentes condiciones en una sola, ejemplo, quiero ver solamente aquellas viviendas que esten en mis zonas favoritas, el centro o el sector norte... `SELECT * FROM viviendas WHERE nombre_zona IN ("Centro", "Sector Norte", "Este");`
- "BETWEEN" - Filtro que uso cuando quiera seleccionar un valor entre dos números dados (un rango), ejemplo, ver todos los pisos cuya superficie (metros) este entre 70 y 100 (ambos incluidos)... `SELECT * FROM viviendas WHERE metros BETWEEN 70 AND 100;`

### **LIKE - Buscar/filtrar usando patrones**

A veces necesitamos buscar datos que coincidan parcial o completamente con ciertos patrones, por ejemplo, necesitamos ver todos los empleados cuyo apellido sea "Piña" porque hoy es el día internacional de la piña y les vamos a regalar un zumo de piña y una tarta de piña, entonces podría hacer la siguiente consulta:

```sql
SELECT * FROM personas WHERE apellidos LIKE "%piña%";
```

Esta consulta va a mostrar a todas las personas cuyos apellidos contengan la palabra "piña", da igual si al principio, al final, en medio o mezclado, ejemplo de personas que aparecerían:

- Agustín Marquéz Piña (le dieron zumo y tarta).
- Antonio Piña Gonzale (le dieron zumo y tarta).
- Miguel Popiña Guzman (le dieron zumo y tarta).

### **ORDER BY - Ordenar los resultados obtenidos en una consulta**

A veces obtenemos resultados en las consultas, por ejemplo, una lista de empleados y sus sueldos y queremos organizar la lista, por ejemplo, en orden alfabetico o en orden de mayor a menor salario o vivecersa, eso es lo que hace **ORDER BY**, se usan con los siguientes argumentos:

- `ORDER BY... ASC`: **ASC** ordena los resultados de una consulta de forma **ascendente**, si son palabras de la `A` a la `Z` y si son números del `menor` al `mayor`, **ejemplo:** `SELECT * FROM personas ORDER BY apellidos ASC;` organizaría todas las personas por orden alfabetico de sus apellidos.
- `ORDER BY... DESC`: **DESC** hace exactamente lo mismo pero al revés, si son palabras, de la `Z` a la `A` y si son números del `mayor` al `menor`, **ejemplo:** ``SELECT * FROM viviendas ORDER BY metros DESC;` organizaría todas las viviendas empezando por las de mayor cantidad de metros hasta la que tenga menos.
- `USAR AMBOS AL MISMO TIEMPO`: Esto es más complejo de entender, hay ciertos escenarios donde queremos organizar la información en base a dos cosas, por ejemplo, queremos ver la viviendas en orden alfabetico según la zona donde están y a la vez que en esas zonas se organice de mayor a menor cantidad de metros, **ejemplo:** `SELECT * FROM viviendas ORDER BY nombre_zona ASC, metros DESC;`.

#### **TABLA SIN ORDER BY**

| cod_vivienda | calle | numero | piso | puerta | metros | fecha | zona |
|--------------|-------|--------|------|--------|--------|-------|------|
| 12345ABCD | Mery      | 10    | 1 | C | 250   | 14/06/2000 | Centro   |
| 77890QWER	| Sol       | 22    | 3 | B | 95    | 03/11/2015 | Norte    |
| 99887LMNO	| Olmo	    | 5     | 2	| A	| 80	| 19/02/2018 |	Oeste   |
| 44556ZXCV	| Prado	    | 18	| 4	| D	| 120	| 27/09/2010 |	Centro  |
| 66221ASDF	| Mar       | 7     | 1	| B	| 60	| 08/01/2020 |	Este    |
| 33445HJKL	| Sierra    | 30	| 5	| A	| 140	| 12/12/2005 |	Norte   |
| 55119BNMQ	| Luna	    | 14	| 2	| C	| 90	| 21/05/2012 |	Sur     |
| 88990RTYU	| Roble	    | 3     | 0	| A	| 70	| 01/07/2019 |	Oeste   |
| 77654POIU	| Levante	| 25	| 6	| B	| 110	| 16/03/2008 |	Este    |
| 11223VCXZ |	Alameda	| 40	| 3	| D	| 100	| 10/10/2016 |	Sur     |

#### **TABLA CON ORDER BY COMBINADO**

| cod_vivienda | calle | numero | piso | puerta | metros | fecha | zona |
|--------------|-------|--------|------|--------|--------|-------|------|
| 12345ABCD | Mery      | 10    | 1 | C | 250   | 14/06/2000 | Centro   |
| 44556ZXCV	| Prado	    | 18	| 4	| D	| 120	| 27/09/2010 | Centro   |
| 77654POIU	| Levante	| 25	| 6	| B	| 110	| 16/03/2008 | Este     |
| 66221ASDF	| Mar       | 7     | 1	| B	| 60	| 08/01/2020 | Este     |
| 33445HJKL	| Sierra    | 30	| 5	| A	| 140	| 12/12/2005 | Norte    |
| 77890QWER	| Sol       | 22    | 3 | B | 95    | 03/11/2015 | Norte    |
| 99887LMNO	| Olmo	    | 5     | 2	| A	| 80	| 19/02/2018 | Oeste    |
| 88990RTYU	| Roble	    | 3     | 0	| A	| 70	| 01/07/2019 | Oeste    |
| 11223VCXZ |	Alameda	| 40	| 3	| D	| 100	| 10/10/2016 | Sur      |
| 55119BNMQ	| Luna	    | 14	| 2	| C	| 90	| 21/05/2012 | Sur      |

## **Tipos de JOINS**

Cuando tenemos una base de datos muy grande o muy compleja, donde hay muchos datos relacionados pero almacenados en diferetentas tablas usamos los **JOINS** para "unir" esas tablas de forma temporalmente y consultar más facilmente los datos, hay una forma muy común de aprender a usarlos que es usando **diagramas de Venn**, pero pintar esas cosas en digital es muy dificíl, así que usaremos tablas.

### **INNER JOIN - Solo la intersección de datos**

**Tabla `personas` (izquierda)**
| dni | nombre | apellidos |
|-----|--------|-----------|
| 33456123A | Rodrigo   | Perez F       |
| 33456789C | Marcos    | Rodriguez B   |
| 34561232D | Carlos    | Duran         |
| 50123456X | Juan      | Gil           |
| 4347898D | Agustín | Piña |

**Tabla `habitar` (derecha):**
| dni | cod_vivienda | fecha_inicio |
|-----|--------------|--------------|
| 33456789C | 10003 | 1987-10-30 |
| 34561232D | 30000 | 1990-12-12 |
| 50123456X | 10003 | 2000-12-12 |
| 50123456X | 10004 | 1987-10-30 | 

Imagina que quiero consultar todos los nombres, apellidos, codigos de vivienda y fechas de inicio de las personas que aparezcan en ambas tablas, haría una consulta parecida a la siguiente:

**Consulta:**
```sql
SELECT p.nombre, p.apellidos, h.cod_vivienda, h.fecha_inicio FROM personas p INNER JOIN habitar h ON p.dni = h.dni
```

**Resultado del INNER JOIN:**
| nombre | apellidos | cod_vivienda | fecha_inicio |
|--------|-----------|--------------|--------------|
| Marcos | Rodriguez B | 10003 | 1987-10-30 |
| Carlos | Duran | 30000 | 1990-12-12 |
| Juan | Gil | 10003 | 2000-12-12 |
| Juan | Gil | 10004 | 1987-10-30 |

**Observaciones del resultado:**
- **¿Qué incluye?** Incluye a Marcos, Carlos y Juan porque aparecen en ambas tablas, en `personas` y en `habitar`.
- **¿Qué excluye?** Excluye a Rodrigo y Agustín porque solo existen en la tabla de `personas` pero no aparecen en la tabla de `habitar`.
- **¿Hay valores repetidos?** En este caso si, Juan aparece dos veces porque en la tabla de `habitar` parece que vive en dos viviendas aunque en `personas` solo aparece una vez. 

### **LEFT JOIN - Toda la tabla de la izquierda y la intersección de la derecha**

A diferencia de **INNER JOIN** cuando usamos **LEFT JOIN** todas las filas (información) de la tabla de la izquierda es visible y de la derecha solo la información que exista (coincidencia).11223VCXZ

**Tabla `personas` (izquierda)**
| dni | nombre | apellidos |
|-----|--------|-----------|
| 33456123A | Rodrigo   | Perez F       |
| 33456789C | Marcos    | Rodriguez B   |
| 34561232D | Carlos    | Duran         |
| 50123456X | Juan      | Gil           |
| 4347898D | Agustín    | Piña          |

**Tabla `habitar` (derecha):**
| dni | cod_vivienda | fecha_inicio |
|-----|--------------|--------------|
| 33456789C | 10003 | 1987-10-30 |
| 34561232D | 30000 | 1990-12-12 |
| 50123456X | 10003 | 2000-12-12 |
| 50123456X | 10004 | 1987-10-30 | 

**Consulta:**
```sql
SELECT personas.nombre, personas.apellidos, habitar.cod_vivienda, habitar.fecha_inicio FROM personas LEFT JOIN habitar ON personas.dni = habitar.dni;
```

**Resultado del LEFT JOIN:**
| nombre | apellidos | cod_vivienda | fecha_inicio |
|--------|-----------|--------------|--------------|
| Rodrigo   | Perez F       | **NULL**  | **NULL**      |
| Marcos    | Rodriguez B   | 10003     | 1987-10-30    |
| Carlos    | Duran         | 30000     | 1990-12-12    |
| Juan      | Gil           | 10003     | 2000-12-12    |
| Juan      | Gil           | 10004     | 1987-10-30    |
| Agustín   | Piña          | **NULL**  | **NULL**      |

**Observaciones del resultado:**
- **¿Qué incluye?** Incluye a todas las personas, sin excepción porque vienen de la tabla de la izquierda (**LEFT**)
- **¿Qué excluye?** Si hay personas que en la tabla de la derecha no tienen datos, no los excluye, pero esos datos que no existen los muestra en forma de **NULL**.
- **¿Hay valores repetidos?** En este caso si, Juan aparece dos veces porque en la tabla de `habitar` parece que vive en dos viviendas aunque en `personas` solo aparece una vez. 

### **RIGHT JOIN - Toda la tabla de la derecha y la intersección de la izquierda**

Hace lo mismo que **LEFT JOIN** pero mostrando todos los datos de la tabla derecha y marcando como **NULL** aquellos que no existan a la izquierda.

**Tabla `viviendas` (izquierda):**
| cod_vivienda | calle | nombre_zona |
|--------------|-------|-------------|
| 10000 | Cernadas | Sector Sur |
| 20000 | Barcelona | Sector Norte |
| 30000 | Juan Florez | Centro |
| 40000 | Juan Florez | Centro |

**Tabla `zonas` (derecha):**
| nombre_zona | descripcion |
|-------------|-------------|
| Centro | Zona central |
| Sector Norte | Al norte de la ciudad |
| Sector Sur | Al sur |
| Sector Este | Al este |
| Sector Oeste | Al west |

**Consulta:**
```sql
SELECT zonas.nombre_zona, zonas.descripcion, viviendas.cod_vivienda, viviendas.calle FROM viviendas RIGHT JOIN zonas ON viviendas.nombre_zona = zonas.nombre_zona;
```

**Resultado del RIGHT JOIN:**
| nombre_zona | descripcion | cod_vivienda | calle |
|-------------|-------------|--------------|-------|
| Centro | Zona central | 30000 | Juan Florez |
| Centro | Zona central | 40000 | Juan Florez |
| Sector Norte | Al norte de la ciudad | 20000 | Barcelona |
| Sector Sur | Al sur | 10000 | Cernadas |
| Sector Este | Al este | **NULL** | **NULL** |
| Sector Oeste | Al west | **NULL** | **NULL** |

**Observaciones del resultado:**
- **¿Qué incluye?** Incluye todas las zonas incluso aunque no tengan viviendas porque zonas es la tabla de la derecha (**RIGHT**).
- **¿Qué excluye?** Si hay zonas que no tienen viviendas los datos de viviendas aparecen como **NULL** porque no existen.
- **¿Hay valores repetidos?** Si, Juan es terrateniente, tiene al menos dos viviendas siempre en todos lados.

### **MULTIPLES JOINS - Usar varios JOINS al mismo tiempo***

A veces queremos unir más de dos tablas (tres, cuatro, cinco, etc), en esos escenarios existe algo llamado **FULL OUTER JOIN** pero no está disponible en **MySQL**, por eso en las empresas a nivel mundia se usan otros gestores de bases de datos (**PostgreSQL**, **MongoDB**, **NoSQL**), cuando lo usamos se ejecutan los joins uno detrás de otro (secuencialmente), ejeplo de sintaxis:

**Tabla `personas`:**
| dni | nombre | apellidos |
|-----|--------|-----------|
| 33456789C | Marcos | Rodriguez B |
| 50123456X | Juan | Gil |

**Tabla `habitar`:**
| dni | cod_vivienda | fecha_inicio |
|-----|--------------|--------------|
| 33456789C | 10003 | 1987-10-30 |
| 50123456X | 10003 | 2000-12-12 |

**Tabla `viviendas`:**
| cod_vivienda | calle | nombre_zona |
|--------------|-------|-------------|
| 10003 | Juan Florez | Centro |

**Tabla `zonas`:**
| nombre_zona | descripcion |
|-------------|-------------|
| Centro | Zona central |

**Sintaxis de ejemplo:**
```sql
SELECT columnas... FROM tabla1
JOIN tabla2 ON tabla1.dni = tabla2.dni
JOIN tabla3 ON tabla2.nombre_zona = tabla3.condicion
JOIN tabla4 ON tabla3.condicion = tabla4.condicion
```

**Consulta real de viviendas con múltiples JOINS:**
```sql
SELECT personas.nombre, personas.apellidos, viviendas.cod_vivienda AS 'codigo vivienda', viviendas.calle, zonas.descripcion
FROM personas
INNER JOIN habitar ON personas.dni = habitar.dni
INNER JOIN viviendas ON habitar.cod_vivienda = viviendas.cod_vivienda
INNER JOIN zonas ON viviendas.nombre_zona = zonas.nombre_zona;
```

**Resultado de la consulta:**
| nombre | apellidos | codigo vivienda | calle | descripcion |
|--------|-----------|--------------|-------|------------------|
| Marcos | Rodriguez B | 10003 | Juan Florez | Zona central |
| Juan | Gil | 10003 | Juan Florez | Zona central |

## **Años (YEAR) en MySQL**

En bases de datos **SQL** estás tienen la capacidad de guardar fechas, como en diferentes lugares del mundo se usan diferentes formatos, el creador de **SQL** es estado unidense, por eso, eligio guardar las fechas en todas las bases de datos **SQL** del mundo en el **formato YYYY/MM/DD**, si miramos la base de datos **viviendas.sql** y miramos la tabla de viviendas podremos apreciar un campo llamado **fecha de construcción**, con los siguientes valores:

| ID | Calle / Edificio | Número | Piso | Letra | Metros² | Fecha | Sector |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 10000 | Cernadas | 45 | 1 | A | 50 | 1987-10-25 | Sector Sur |
| 10001 | Cernadas | 45 | 1 | B | 65 | 1987-10-25 | Sector Sur |
| 10002 | Cernadas | 45 | 2 | A | 78 | 1987-10-25 | Sector Sur |
| 10003 | Cernadas | 45 | 2 | B | 80 | 1987-10-25 | Sector Sur |
| 10004 | Cernadas | 45 | 3 | A | 78 | 1987-10-25 | Sector Sur |
| 10005 | Cernadas | 45 | 3 | B | 80 | 1987-10-25 | Sector Sur |
| 20001 | Barcelona | 20 | 1 | B | 80 | 1984-10-22 | Sector Norte |
| 20000 | Barcelona | 20 | 1 | A | 80 | 1974-10-22 | Sector Norte |
| 50000 | Barcelona | 78 | 2 | C | 90 | 1990-10-10 | Sector Norte |
| 30000 | Juan Florez | 35 | 1 | A | 90 | 1990-10-12 | Centro |
| 30001 | Juan Florez | 35 | 1 | B | 88 | 1990-10-12 | Centro |
| 40000 | Juan Florez | 40 | 1 | A | 61 | 1985-10-11 | Centro |

Cuando guardamos por ejemplo el **ID** de las viviendas, usamos números enteros, eso es un tipo de variable llamado **integer**, cuando guardamos palabras o texto usamos un tipo de variable llamado **char**, por ejemplo con la calle, la letra, el sector, etc, las fechas ciertamente son números pero son especiales, son **fechas** y existe un tipo de variable usado solo para guardar fechas llamado **DATETIME**, si yo quiero consultar información sobre fechas, puedo elegir que quiero ver, si solo quiero ver el año de "X" fecha en la consulta puedo usar **YEAR**, si solo quiero ver el día o el mes de una fecha uso **DAY** o **MONTH**.

### **¿Como usar "YEAR" al consultar fechas?**

Imaginemos que queremos consultar en que año se construyeron las viviendas, pero no nos interesa ni el día ni la hora ni el mes, solo el año, entonces usamos **YEAR** como filtro de datos, mirad el siguiente ejemplo:

**Sintaxis:**
```sql
SELECT * FROM tabla WHERE YEAR(fecha) < 2000;
```

**Ejemplo con viviendas:**
```sql
SELECT * FROM viviendas WHERE YEAR(fecha_construccion) < 1986;
```

**Resultado:**
| ID | Calle / Edificio | Número | Piso | Letra | Metros² | Fecha | Sector |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 20001 | Barcelona | 20 | 1 | B | 80 | 1984-10-22 | Sector Norte |
| 40000 | Juan Florez | 40 | 1 | A | 61 | 1985-10-11 | Centro |


## **Ordenar resultados de consultas en SQL con "ORDER BY"**

Hasta ahora cuando hemos hecho las consultas no nos ha interesado ordenarlas de ninguna forma, pero en la vida real no suele ser así, por ejemplo, si yo consulto todas las viviendas de la capital de Galicia basandome en su fecha de construcción a mi no me gustaría que salga desordenado, probablemente me gustaría poder verlas de más antigua a más reciente o viceversa.

Lo mismo pasa en una empresa, si queremos ver una lista de todos los empleados es probable que quiera ordenarla por orden alfabetico de los nombres o quizás de los apellidos, para eso, **SQL** tiene una función o carácteristica llamada **ORDER BY** que nos permite usar un campo de la tabla para ordenar los resultados.

### **¿Como usar "ORDER BY" al consultar tablas?**

Imagina que queremos consultar todas las viviendas y ordenarlas por el número de la calle donde están ubicadas, mira el siguiente ejemplo:

**Sintaxis:**
```sql
SELECT * FROM tabla ORDER BY campo;
```

**Ejemplo: orden ascendente (menor a mayor)**
```sql
SELECT * FROM viviendas ORDER BY numero ASC;
```

**Resultado:**
| ID | Calle / Edificio | Número | Piso | Letra | Metros² | Fecha | Sector |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 20000 | Barcelona | 20 | 1 | A | 80 | 1974-10-22 | Sector Norte |
| 20001 | Barcelona | 20 | 1 | B | 80 | 1984-10-22 | Sector Norte |
| 30001 | Juan Florez | 35 | 1 | B | 88 | 1990-10-12 | Centro |
| 30000 | Juan Florez | 35 | 1 | A | 90 | 1990-10-12 | Centro |
| 40000 | Juan Florez | 40 | 1 | A | 61 | 1985-10-11 | Centro |
| 10000 | Cernadas | 45 | 1 | A | 50 | 1987-10-25 | Sector Sur |
| 10005 | Cernadas | 45 | 3 | B | 80 | 1987-10-25 | Sector Sur |
| 10004 | Cernadas | 45 | 3 | A | 78 | 1987-10-25 | Sector Sur |
| 10003 | Cernadas | 45 | 2 | B | 80 | 1987-10-25 | Sector Sur |
| 10002 | Cernadas | 45 | 2 | A | 78 | 1987-10-25 | Sector Sur |
| 10001 | Cernadas | 45 | 1 | B | 65 | 1987-10-25 | Sector Sur |
| 50000 | Barcelona | 78 | 2 | C | 90 | 1990-10-10 | Sector Norte |

**Ejemplo: orden descendente (mayor a menor)**

*Nota: En el ejemplo anterior hay un error — debería ser `DESC` para descendente:*
```sql
SELECT * FROM viviendas ORDER BY numero DESC;
```

**Resultado:**
| ID | Calle / Edificio | Número | Piso | Letra | Metros² | Fecha | Sector |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 50000 | Barcelona | 78 | 2 | C | 90 | 1990-10-10 | Sector Norte |
| 10000 | Cernadas | 45 | 1 | A | 50 | 1987-10-25 | Sector Sur |
| 10005 | Cernadas | 45 | 3 | B | 80 | 1987-10-25 | Sector Sur |
| 10004 | Cernadas | 45 | 3 | A | 78 | 1987-10-25 | Sector Sur |
| 10003 | Cernadas | 45 | 2 | B | 80 | 1987-10-25 | Sector Sur |
| 10002 | Cernadas | 45 | 2 | A | 78 | 1987-10-25 | Sector Sur |
| 10001 | Cernadas | 45 | 1 | B | 65 | 1987-10-25 | Sector Sur |
| 40000 | Juan Florez | 40 | 1 | A | 61 | 1985-10-11 | Centro |
| 30000 | Juan Florez | 35 | 1 | A | 90 | 1990-10-12 | Centro |
| 30001 | Juan Florez | 35 | 1 | B | 88 | 1990-10-12 | Centro |
| 20001 | Barcelona | 20 | 1 | B | 80 | 1984-10-22 | Sector Norte |
| 20000 | Barcelona | 20 | 1 | A | 80 | 1974-10-22 | Sector Norte |

## **GROUP BY en SQL** 

`GROUP BY` sirve para **agrupar** filas que tienen el mismo valor en una columna y obtener un **resumen** (contar, sumar, promediar, etc.).

### **Ejemplo sencillo: cuántas viviendas hay por zona**

Tabla `viviendas` (fragmento):

| cod_vivienda | calle | nombre_zona |
|--------------|-------|-------------|
| 10000 | Cernadas | Sector Sur |
| 10001 | Cernadas | Sector Sur |
| 10002 | Cernadas | Sector Sur |
| 20000 | Barcelona | Sector Norte |
| 20001 | Barcelona | Sector Norte |
| 30000 | Juan Florez | Centro |

**Objetivo:** Saber cuántas viviendas hay en cada zona.

**Consulta:**
```sql
SELECT nombre_zona, COUNT(*) AS total_viviendas
FROM viviendas
GROUP BY nombre_zona;
```

**Resultado:**

| nombre_zona | total_viviendas |
|-------------|-----------------|
| Sector Sur | 3 |
| Sector Norte | 2 |
| Centro | 1 |

`GROUP BY nombre_zona` agrupa todas las filas que tienen la misma zona. `COUNT(*)` cuenta cuántas filas hay en cada grupo.

### **Regla importante**

En el `SELECT` solo puedes poner:
- Las columnas por las que agrupas (ej: `nombre_zona`).
- Funciones de agregación: `COUNT(*)`, `SUM()`, `AVG()`, `MAX()`, `MIN()`.

## **HAVING en SQL**

`HAVING` filtra **grupos** después de que se han formado con `GROUP BY`. Es como un `WHERE`, pero aplicado a los resultados de las funciones de agregación.

### **Ejemplo: zonas con más de 2 viviendas**

Usando el mismo ejemplo anterior, ahora queremos ver **solo** las zonas que tienen más de 2 viviendas:

```sql
SELECT nombre_zona, COUNT(*) AS total_viviendas
FROM viviendas
GROUP BY nombre_zona
HAVING COUNT(*) > 2;
```

**Resultado:**

| nombre_zona | total_viviendas |
|-------------|-----------------|
| Sector Sur | 3 |

Solo aparece Sector Sur porque es la única zona con más de 2 viviendas. Centro (1) y Sector Norte (2) se excluyen.

### **Diferencia entre WHERE y HAVING**

| | WHERE | HAVING |
|---|-------|--------|
| **Filtra** | Filas individuales | Grupos completos |
| **Cuándo** | Antes del agrupamiento | Después del agrupamiento |
| **Ejemplo** | `WHERE metros > 70` | `HAVING COUNT(*) > 2` |

### **Más ejemplos con la base de datos `circo`**

La base de datos del circo tiene tablas como `animales`, `atraccion_dia`, `artista_animal`, etc. (ver `galicia/circo/BDCirco.sql`).

#### **Ejemplo 1: Cuántos animales hay de cada tipo (GROUP BY)**

```sql
USE circo;

SELECT tipo, COUNT(*) AS cantidad
FROM animales
WHERE tipo IS NOT NULL
GROUP BY tipo;
```

**Resultado (con los datos del circo):**

| tipo | cantidad |
|------|----------|
| Cocodrilo | 1 |
| León | 1 |
| grillo | 1 |
| Mono | 1 |
| Jirafa | 2 |

#### **Ejemplo 2: Tipos de animal con más de 1 ejemplar (GROUP BY + HAVING)**

```sql
USE circo;

SELECT tipo, COUNT(*) AS cantidad
FROM animales
WHERE tipo IS NOT NULL
GROUP BY tipo
HAVING COUNT(*) > 1;
```

**Resultado:**

| tipo | cantidad |
|------|----------|
| Jirafa | 2 |

Solo Jirafa aparece porque es el único tipo con más de un animal (Princesa1 y Princesa2).

## **Fuentes e información**

- [¿Qué es un diagrama entidad-relacion? Según lucidchart.](https://www.lucidchart.com/pages/es/que-es-un-diagrama-entidad-relacion)
- [Modelo entidad relación (ER) explicado por KeepCoding.](https://keepcoding.io/blog/modelo-entidad-relacion/)
- [Como hacer diagramas de entidad relación explicado por Miro.](https://miro.com/es/diagrama/como-hacer-diagrama-entidad-relacion/)
- [Tipos de JOINS explicados con diagramass de Venn](https://adictosaltrabajo.com/2010/09/03/joinsgraficos/)
