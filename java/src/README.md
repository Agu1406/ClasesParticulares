<!-- Etiquetas de estilo personales para el README. -->
<style>
    h1, h2, h3 {
        text-align: center;
        border: 5px solid grey;
        padding: 20px
    }

    h4 {
        text-align: center;
        font-size: 16px;
    }
    p {
        text-indent: 20px;
        text-align: justify;
    }

    table {
        border: 1px solid white;
        margin-left: auto;
        margin-right: auto;
        margin-bottom: 10%;
        margin-top: 10%;
    }
    th, td {
        border: 1px solid white;
        text-align: center;
    }
</style>
# Notas y matices

El contenido de esta guía está fuertemente inspirado en dos cosas, la primera, el temario de Java que aprendí durante mi curso de **DAW 2023/2025** en el **IES Arquitecto Ventura Rodríguez**, instituto público de Boadilla del Monte, Madrid, España y segundo en el **RoadMap** de Java que se puede ver y encontrar en [**RoadMap de Java**](https://roadmap.sh/java).

#### La organización del directorio de aprendizaje de Java es la siguiente:

```bash
src/
├── ev1/
│   └── ut0/
│       ├── ciclovida/
│       │   └── Ejemplo.java
│       ├── sintaxisbasica/
│       │   ├── Programa1.java
│       │   └── Programa2.java
│       ├── tipodatos/
│       │   ├── DatosPrimitivos.java
│       │   └── DatosAvanzados.java
│       └── casteotipos/
│           ├── CasteoTipos.java
│           └── CasteoTiposPrimitivos.java
├── ev2/   # (planificado)
├── ev3/   # (planificado)
└── README.md
```

# Indice de contenido

* **Primera evaluación (EV1)**
    + **Contenido de la unidad teórica 0 (UT0)**
        1. [**Conceptos básicos**](#conceptos-básicos)
        2. [**Ciclo de vida de un programa**](#ciclo-de-vida-de-un-programa)
        3. [**Sintaxis básica**](#sintaxis-básica)
        4. [**Tipos de datos**](#tipos-de-datos)
    * [**Casteo de tipos**](#casteo-de-tipos)
    * [**Bucles**](#bucles)
    * [**Condicionales**](#condicionales)
    * [**Strings y funciones**](#strings-y-funciones)
    * [**Operaciones matemáticas**](#operaciones-matemáticas)
    * [**Arrays**](#arrays)
    * [**Conceptos básicos de la POO**](#conceptos-básicos-de-la-poo)
* [**Segunda evaluación (EV2)**]()
* [**Tercera evaluación (EV3)**]()

| [**Siguiente**](#primera-evaluación-ev1) | [**Indice**](#indice-de-contenido) | [**Anterior**](#indice-de-contenido)  |
|-------------------------------------------|-------------------------------------------|-------------------------------------------|

# **Primera evaluación (EV1)**

En la primera evaluación aprenderemos a introducirnos en Java como lenguaje de programación, aprenderemos a escribir nuestras primeras líneas de código, cómo imprimir mensajes en nuestros programas. Posteriormente, aprenderemos las estructuras de control de un programa (bucles, condicionales), el uso de funciones, el uso de `String`, `StringBuilder`, `Character`, `Integer`, `Math`, `Double`, etc. y, finalmente, una breve introducción a la programación orientada a objetos **(POO)**. El [**indice de contenido**](#indice-de-contenido) nos ayudará a desplazarnos durante toda nuestra etapa de aprendizaje a través de los diferentes niveles del curso.

Siempre que quieras ver el código real asociado a las explicaciones de esta evaluación, podrás encontrarlo en la carpeta `src/ev1` y sus subcarpetas.

| [**Siguiente**](#conceptos-básicos) | [**Indice**](#indice-de-contenido) | [**Anterior**](#indice-de-contenido)  |
|-------------------------------------------|-------------------------------------------|-------------------------------------------|

## Conceptos básicos

Los lenguajes de programación se pueden comparar a los lenguajes humanos, aprender uno nuevo toma tiempo y esfuerzo pero a la vez da unos resultados muy satisfactorios.

**Java** es un lenguaje de `alto nivel`, es decir, es más cercano al lenguaje humano que al lenguaje de las máquinas, por lo tanto, más fácil de aprender. Es un lenguaje orientado a objetos, ejecutable en casi cualquier sistema siempre que se instale Java en él. **No es el más simple para escribir tu primera línea de código**, pero sí es uno de los más sólidos y estructurados para construir aplicaciones reales.

Cuando avances con estos conceptos, te recomiendo ir revisando también los ejemplos prácticos de código que irán apareciendo en `src/ev1`.

| [**Siguiente**](#ciclo-de-vida-de-un-programa) | [**Indice**](#indice-de-contenido) | [**Anterior**](#primera-evaluación-ev1)  |
|-------------------------------------------|-------------------------------------------|-------------------------------------------|

### Ciclo de vida de un programa

#### **¿Quien lee y ejecuta el código?**

Existen dos cosas muy importantes en el uso y desarrollo de aplicaciones **Java**, las cuales son:

* **JVM (Java Virtual Machine):** Es una "máquina virtual" que lee el código Java y lo traduce a nuestros ordenadores para que puedan ejecutarlo, la mayoría de usuarios a nivel mundial lo instalan sin saberlo porque cientos de aplicaciones funcionan con él. Yo, por ejemplo, mucho antes de siquiera saber qué era **Java** lo instalé para poder jugar **Minecraft**. Sin **JVM** nada que esté diseñado y/o creado con **Java** sería ejecutable en nuestros ordenadores.

* **JDK (Java Development Kit):** Esto es algo que en cambio solo instalamos las personas que diseñamos y creamos programas en **Java**, es decir, de ahora en adelante, tú y yo. Incluye tres cosas muy importantes: el `compilador`, que es el encargado de leer nuestro código y, en caso de no encontrar errores, convertirlo en programas que la **JVM** pueda ejecutar; los `depuradores`, que leen el código y nos avisan si hay errores y/o nos permiten identificar exactamente dónde están y cuáles son si es que los hay; y las `librerías`, que son todas las herramientas que ya incluye **Java** de forma nativa. Por ejemplo, si queremos hacer una calculadora no es necesario hacerla desde cero, **Java** ya incluye muchas "piezas" preconstruidas en esas librerías que facilitan el trabajo.

Existe también el **Java Runtime Environment (JRE)** que es lo mismo que **JVM** pero incluye las bibliotecas necesarias para ejecutar un programa concreto, hoy en día por ejemplo `Minecraft` cuando se instala incluye su propio **JRE** con lo justo y necesario para ejecutar el juego, no incluye nada más que no sea necesario.

#### **Etapas del ciclo de vida de un programa Java**

Normalmente con el tiempo y algo de curiosidad por parte de nosotros mismos queda mucho más clara la diferencia entre **JVM**, **JRE** y **JDK**, hablemos ahora del ciclo de vida de nuestros programas (una vez que empecemos a hacerlos de forma recurrente).

1. **Edición (código fuente):** Esta parte es aquella de la que tendremos el control al 100%, se refiere a nosotros escribiendo código (líneas y líneas del mismo) en archivos con la extensión `.java`, por ejemplo **MiPrimerPrograma.java**. 
2. **Compilación:** Aquí nosotros no hacemos nada, normalmente programas como **Eclipse**, **NetBeans**, **VSCode** e **IntelliJ** (los más usados) traen un botón llamado `compilar` que por sí solo usará el **JDK** que tengamos instalado para ello.  
3. **Carga:** Si en el proceso de `compilar` nuestro programa no se detectan errores de ningún tipo, si intentamos ejecutar/probar nuestro código la **JVM** o el **JRE** usarán los archivos compilados para ello, cargándolos dentro de la `máquina virtual de Java`.
4. **Verificación:** Ya cargados dentro de la `máquina virtual de Java` esta se encargará de revisar que no haya datos corruptos, violaciones de seguridad, no es lo mismo que compilar, compilar busca errores "ortográficos" (de sintaxis), aquí se buscan errores de diseño o de seguridad.
5. **Ejecución:** Superada todas las fases anteriores la **JVM** traduce el código a `bits` que nuestro ordenador puede ejecutar y hace que nuestro programa arranque.

Por ejemplo, si seguimos la siguiente ruta dentro de este proyecto `src > ev1 > ut0 > ciclovida` podremos encontrar dos archivos, uno es el `.java` donde he escrito un par de líneas de código que luego de **editar, compilar y cargar** se ha convertido en un `.class` que puede ser ejecutado usando el **JRE** para que nuestro ordenador lo entienda.


Mientras lees esta sección, es muy buena idea abrir y ejecutar esos archivos en la ruta `src/ev1/ut0/ciclovida` para ver el ciclo completo en acción.

```bash
# Ruta de los archivos mencionados.
src/
└── ev1/
    └── ut0/
        └── ciclovida/
            ├── Ejemplo.java
            └── Ejemplo.class

```
| [**Siguiente**](#sintaxis-básica) | [**Indice**](#indice-de-contenido) | [**Anterior**](#conceptos-básicos)  |
|-------------------------------------------|-------------------------------------------|-------------------------------------------|

### Sintaxis básica

#### **Nuestro primer programa en Java**

Mi profesor de Java, la persona que me enseñó a amar el lenguaje, **Jaime Martín García Cuerca** siempre me decía: "No hay que frustrarnos intentando entender todo desde el principio, se puede avanzar en algo nuevo sin entender del todo cómo funciona".

Por ahora vamos a aprender de memoria cómo escribir las siguientes 4 líneas de código que serán las líneas mínimas necesarias para que (por ahora) nuestros programas funcionen y sean ejecutables.

```java
public class NombreDelPrograma { // Línea 1
    public static void main (String [] args) { // Línea 2
    } // Línea 3
} // Línea 4
```

Los únicos aspectos que nos van a importar por ahora son que ahí donde dice `NombreDelPrograma` tiene que ir exactamente el mismo nombre con mayúsculas y minúsculas del archivo `.java` al que pertenece. Puedes abrir el archivo `Programa1.java` que se encuentra en `src > ev1 > ut0 > sintaxisbasica`.

#### **Nuestro primer "Hola mundo" en Java**

Existe una tradición muy común en el mundo del desarrollo la cual es, al aprender cualquier lenguaje, lo primero que suelen hacer las personas es **imprimir un mensaje** usando código con las palabras `¡Hola mundo!`, para ello nosotros vamos a darle a Java esa orden, esa instrucción, que él ejecutara permitiendonos imprimir ese mensaje y todos los que queramos, puedes abrir el archivo `Programa2.java` el cual tiene más o menos el siguiente contenido.

```java
public class Programa2 {
    public static void main (String [] args) {
        // Aquí le doy la instrucción de imprimir "¡Hola mundo!".
        System.out.println("¡Hola mundo!");

        // Una vez más, en otra línea diferente, le doy otra instrucción.
        System.out.println("¡Mi nombre es Agustín!");
    }
}
```

Cuando usamos `System.out.println();` el mensaje/texto/información que deseamos imprimir tiene que ir dentro del paréntesis y entre comillas dobles o simples, las de nuestra preferencia. Puede ser cualquier cosa, yo elegí por tradición el **"¡Hola mundo!"** y mi nombre. Las instrucciones en Java **siempre terminan con un punto y coma (";")**, si no, no funcionan.

Para practicar esta lección, abre y modifica los archivos `Programa1.java` y `Programa2.java` que encontrarás en la carpeta `src/ev1/ut0/sintaxisbasica`.

```bash
# Ruta de los archivos asociados a esta lección.
src/
└── ev1/
    └── ut0/
        └── sintaxisbasica/
            ├── Programa1.java
            └── Programa2.java
```

| [**Siguiente**](#comentarios-en-java) | [**Indice**](#indice-de-contenido) | [**Anterior**](#ciclo-de-vida-de-un-programa)  |
|-------------------------------------------|-------------------------------------------|-------------------------------------------|

### Comentarios en Java

Cuando escribimos código en cualquier lenguaje de programación es normal que olvidemos que hacen o no ciertas palabras, lineas de código, archivos, etc, por eso **existen los comentarios en lenguajes de programación**, nos permiten escribir cosas para nosotros mismos y otras personas que lean nuestro código de forma que expliquen como funcionan las cosas que hacemos, existen varios tipos, vamos a explicarlos:

#### **Comentarios de una línea**

Estos comentarios están pensados para tener un tamaño máximo de una línea, por lo que sirven para explicar algo muy puntual y brevemente. Para usarlos escribimos una barra inclinada doble seguida de nuestro comentario/explicación, **ejemplo:**

```java
// Este es un comentario de Java.
public class Ejemplo {
    // Se pueden poner en cualquier lugar siempre que ocupen su propia línea.
    public static void main (String [] args) {
    // Por ejemplo, aquí te explico que esto es lo que imprime un mensaje.
    System.out.println("¡Hola otra vez!"); // También pueden ir delante de las cosas.
    }
}
// Pero no pueden ir detrás, si no, no funcionan.
```

#### **Comentarios multilínea**

Los comentarios **multilínea** existen porque no todo se puede explicar con una sola línea y a veces necesitamos esa libertad de escribir sin límites todo lo que necesitemos para recordarnos a nosotros mismos y a otras personas lo que hace o no hace nuestro código. Estos comentarios empiezan con una barra inclinada seguida de un asterisco **(" / * ")** y terminan con un asterisco y una barra inclinada **(" * / ")**, mira el siguiente **ejemplo**:

```java
public class Ejemplo {
    public static void main (String [] args) {
        /* <-- AQUÍ EMPIEZA EL COMENTARIO.

        Yo puedo crear todo el espacio que quiera entre la marca que indica el
        inicio del comentario y la marca que indica el fin del mismo y escribir
        todo lo que quiera, fundamental para dar grandes explicaciones o para,
        por ejemplo, dejarnos notas a nosotros mismos, muchas veces cuando yo
        estoy haciendo cosas para no olvidar qué era lo siguiente que tenía que
        hacer me dejo comentarios explicándome a mí mismo qué falta por hacer.

        AQUÍ TERMINA EL COMENTARIO. -->*/

        // Otro mensaje para ti.
        System.out.println("¡Hola por tercera vez!");
    }
}
```

#### **Comentarios de JavaDoc**

Luego existe el último tipo de comentario el cual es el más profesional siempre y cuando se use correctamente, el **JavaDoc** es un tipo de comentario que permite, con un par de clicks y botones crear una especie de **PDF** que muestra todos los archivos de nuestro proyecto usando estos comentarios para explicar la utilidad completa de un archivo **Java** completo, suele ir por ejemplo al principio de una clase y tiene que explicarla al 100%, esto suele incluir también la versión del archivo (si tiene versiones), la fecha en la que fue creado y/o el autor, entre otras cosas, este es más complejo y para los fines educativos de este curso lo aprenderemos a usar más adelante.

Estos comentarios empiezan con una barra inclinada seguida de dos asteriscos `("/**")` y terminan con un asterisco y una barra inclinada `("*/")`, además cada línea entre la marca de inicio y de fin lleva un asterisco al principio `("*")`, aquí tienes un **ejemplo:**

```java
/**  <-- INICIO DEL COMENTARIO JAVADOC.
 * 
 * Clase Ejemplo utilizada para explicarle a mis alumnos los distintos tipos
 * de comentarios que existen, explicando de forma teórica y práctica los
 * comentarios de una línea, multilínea y los de JavaDoc.
 * 
 * @Since 14/06/2025
 * @Author Agustín Antonio Marquez Piña
 * @Version 1.0
 * 
 * LA LINEA DE ABAJO ES EL FIN DEL COMENTARIO JAVADOC.
 */
public class Ejemplo {
    /*
    El de arriba más profesional explica todo el código completo del archivo,
    este en cambio lo uso más para apuntes y notas personales o para recordar
    o explicar cosas.
    */
    public static void main (String [] args) {
        // Y este para explicaciones muy sencillas.
        System.out.println("¡Cuarto saludo del día!");
    }
}
```

#### **Conclusión**

Yo, particularmente, dejo muchos comentarios en todo lo que hago, me he dado cuenta que muchos alumnos repasan las clasas dadas juntos y los comentarios aportan breves explicaciones que les ayudan a recordar el porque de las cosas, espera verlos muchos si sigues dando clases conmigo.

Cuando quieras practicar estos tipos de comentario, crea tus propios archivos en `src/ev1/ut0` o revisa los ejemplos que iré añadiendo en esa misma carpeta.

| [**Siguiente**](#tipos-de-datos) | [**Indice**](#indice-de-contenido) | [**Anterior**](#comentarios-en-java)  |
|-------------------------------------------|-------------------------------------------|-------------------------------------------|
### Tipos de datos

En la vida real cuando desayunamos el café suele ir en un vaso o en una taza por ejemplo y la tostada con tomate y aceite en un plato, ¿cierto? es como que **cada cosa tiene su lugar**, lo mismo pasa con los lenguajes de programación.

**Java** es un lenguaje "especial", si por ejemplo estamos usando números **Java** quiere que los guardes en unos contenedores especiales para números **(como si los números fueron café y esos contenedores fueran tazas)**, en cambio, si usamos por ejemplo palabras, estás tienen su propio contenedor diferente al de los números **(como si las palabras fueran las tostada y sus contenedores los platos)**.

Esto se conoce como `lenguaje tipado` porque cada tipo de dato/información que nuestro programa use necesita ser guardado en un lugar dentro de nuestro programa que sea especialmente hecho para ese tipo de dato, ahora, en **Java** existen principalmente dos tipos de datos, los `datos primitivos` y los `datos avanzados`, vamos a ver más de ellos.

Cuando escribimos en una linea un dato y su valor debe seguir la siguiente sintaxis:

```java
public class Ejemplo {
    public static void main (String [] args) {
        // Ejemplo de sintaxis
        tipo nombre = valor
        tipo nombre = valor;

        // Ejemplo para guardar mi número favorito.
        int miNumeroFavorito = 14;

        // Ejemplo para guardar mi letra favorita.
        char miLetraFavorita = 'A';
    }
}
```

No puedo guardar un `número entero` dentro de un **char** porque **char** es especial solo para letras/carácteres y viceversa, no puedo guardar una `letra/caracter` en un **int** porque **int** es especial para números enteros, **cada cosa tiene su lugar.**

#### **Datos primitivos**

Son las formas más básicas de los datos. Entre ellas podemos encontrar **números enteros**, **números decimales**, **símbolos/caracteres** e incluso un tipo muy especial que solo puede ser **verdadero** o **falso**. Podemos leer más sobre esto en el sitio web en inglés de [**Jenkov Java variables**](https://jenkov.com/tutorials/java/variables.html), sin embargo, aquí puedes verlos de forma resumida, explicados con comentarios sobre qué es cada uno en el siguiente **ejemplo:**

```java
public class DatosPrimitivos {
    public static void main (String [] args) {
        // byte: número entero muy pequeño (de -128 a 127)
        byte unByte = 42;

        // short: número entero pequeño (de -32.768 a 32.767)
        short unShort = 32000;

        // char: un solo símbolo/carácter (letra, número, signo, etc.)
        char unChar = 'A';

        // int: número entero “normal” (de -2.147.483.648 a 2.147.483.647)
        int unInt = 123456;

        // long: número entero muy grande (de -9.223.372.036.854.775.808 a 9.223.372.036.854.775.807)
        long unLong = 123456789L;

        // float: número decimal de precisión sencilla (lleva una “f” al final)
        float unFloat = 3.14f;

        // double: número decimal de doble precisión (el más usado para decimales)
        double unDouble = 3.1415926535;

        // boolean: solo puede ser true (verdadero) o false (falso)
        boolean unBoolean = true;
    }
}
```

En otros tiempo era muy importante elegir con pinzas el tipo de variable porque antes había ordenadores con menos cantidades de RAM y espacio de almacenamiento muy bajo, **hoy en día** recomiendo para aprender a usar **java** relativamente rapido usar `int` siempre para los números entero y `double` para los números decimales, así es más facil de recordar y aprender.

En el proyecto tienes un archivo real llamado `DatosPrimitivos.java` en la carpeta `src/ev1/ut0/tipodatos` donde puedes probar y modificar estos ejemplos de tipos primitivos.

```bash
# Ruta de los archivos asociados a esta lección.
src/
└── ev1/
    └── ut0/
        └── tipodatos/
            ├── DatosPrimitivos.java
            └── DatosAvanzados.java
```

#### **Datos avanzados**

Si nos fijamos **todos los datos primitivos** tienen su nombre de tipo escrito completamente en minúsculas `(int, byte, char, double, float, etc)`. Los datos **avanzados** tienen siempre la primera letra de sus nombre en maýuscula.

La diferencia entre estos datos y los primitivos es, primero, que **ocupan más espacio de memoria** y lo segundo es que ofrecen **carácteristicas avanzadas** que los primitivos no tienen, pero de momento no vamos a necesitarlos, sin embargo, igual que antes, aquí te dejo un **ejemplo:**

```java
public class Ejemplo {
    public static void main (String [] args) {
        // Byte: “envoltorio” (wrapper) de byte, rango: -128 a 127
        Byte       myByte   = 42;

        // Short: “envoltorio” de short, rango: -32.768 a 32.767
        Short      myShort  = 32_000;

        // Character: “envoltorio” de char (un único símbolo/caracter)
        Character  myChar   = 'A';

        // Integer: “envoltorio” de int (muy usado), rango: -2.147.483.648 a 2.147.483.647
        Integer    myInt    = 123_456;

        // Long: “envoltorio” de long, rango: -9.223.372.036.854.775.808 a 9.223.372.036.854.775.807
        Long       myLong   = 123_456_789L;

        // Float: “envoltorio” de float
        Float      myFloat  = 3.14f;

        // Double: “envoltorio” de double
        Double     myDouble = 3.1415926535;

        // String: tipo de dato avanzado para cadenas de texto
        String     myString = "Hola, soy un texto";
    }
}
```

**Llegara el día y el momento** en el que, de forma muy casual, usemos estás variables avanzadas **(variables objeto)** y probemos sus carácteristicas que las diferencian de las primitivas, pero hasta entonces, nos quedamos con lo fácil y sencillo.

Más adelante, cuando trabajemos con datos avanzados en ejercicios reales, los ejemplos de código estarán también organizados dentro de `src/ev1` y, en evaluaciones posteriores, en `src/ev2` y `src/ev3`.

| [**Siguiente**](#variables-y-alcances) | [**Indice**](#indice-de-contenido) | [**Anterior**](#comentarios-en-java)  |
|-------------------------------------------|-------------------------------------------|-------------------------------------------|

### Casteo de tipos

`Casteo` es la palabra tecnica y elegante para referirnos al proceso de convertir una "X" variable de un tipo a otro, por ejemplo, si quiero convertir el valor de un número decimal como **PI** (3,1416) a un número entero sacrificando los decimales en el proceso o viceversa, convertir un número entero como **"14"** en un número decimal agregando ceros (14,00).

**Java** permite hacer esto siempre que la conversión sea coherente, por ejemplo, no puedo convertir la palabra `Aguacate` en un número, pero si puedo convertir una letra o carácter individual por si solo en un número **(su valor en la tabla ASCII)**.

Este proceso lo tenemos que separar en dos partes, las cuales son la `conversión de tipos primitivos` y la `conversión de tipos avanzados`, porque aunque el objetivo es el mismo, **la sintaxis es diferente**.

#### **Conversión de tipos primitivos**

Recordemos de puntos anteriores que los **datos primitivos** se escriben completamente en minúscula, entre ellos podemos recordar algunos como `int, double, float, char, byte` aunque los que yo uso siempre para dar clases son `int` y `double` por que son más faciles de usar y recordar.

El proceso de conversión requiere crear una variable donde guardar el valor convertido y, por supuesto, un valor inicial que convertir, ejemplo, convertir un número entero en un decimal, **ejemplo:**

```java
public class Ejemplo {
    public static void main (String [] args) {
        // Variable original del tipo "int" que quiero convertir.
        int valorOriginal = 14;
        // Variable "recipiente" donde guardare el valor convertido.
        double valorConvertido;
    }
}
```

Ahora que ya tengo las dos variables, aquella con el valor original y aquella donde guardare el valor una vez ya convertido, sigue el proceso de conversión que implica utilizar, entre parentesis, el tipo al que deseo convertir la variable original, **ejemplo:**

```java
public class Ejemplo {
    public static void main (String [] args) {
        int valorOriginal = 14;
        double valorConvertido;

        // ✅ al usar "(double)" entre parentesis convierto el valor de "int" a "double".
        valorConvertido = (double) valorOriginal;
    }
}
```

El proceso funciona igual en otros escenarios, **por ejemplo** si deseo convertir **PI** y sus primeros 4 decimales en un número entero **Java** lo hará sin problemas, ignorando completamente la existencia de los decimales y quedandose solo con el número entero de **PI**, **ejemplo:**

```java
public class Ejemplo {
    public static void main (String [] args) {
        // Valor original de PI con sus primeros cuatro decimales.
        double valorPIOriginal = 3.1416;
        // Variable recipiente para guardar PI convertido en entero.
        int valorPIConvertido;

        // Proceso de conversión de PI de un tipo a otro.
        valorPIConvertido = (int) valorPIOriginal;

        // Imprimimos ambos, el valor original y el valor convertido.
        System.out.println("Valor de PI original:" + valorPIOriginal); // 3.1416
        System.out.println("Valor de PI convertido: " + valorPIConvertido); // 3
    }
}
```

**Hay que tomar en cuenta** que en el proceso de convertir algo de un tipo a otro el valor original no se pierde, si no que más bien se crea una "copia" del valor original pero en el nuevo formato deseado.

En el código del proyecto encontrarás ejemplos prácticos de estas conversiones en la carpeta `src/ev1/ut0/casteotipos`, por ejemplo en los archivos `CasteoTipos.java` y `CasteoTiposPrimitivos.java`.

```bash
# Ruta de los archivos asociados a esta lección.
src/
└── ev1/
    └── ut0/
        └── casteotipos/
            ├── CasteoTipos.java
            └── CasteoTiposPrimitivos.java
```
#### **Conversión de tipos avanzados**

| [**Siguiente**](#bucles) | [**Indice**](#indice-de-contenido) | [**Anterior**](#tipos-de-datos)  |
|-------------------------------------------|-------------------------------------------|-------------------------------------------|

### Bucles

| [**Siguiente**](#condicionales) | [**Indice**](#indice-de-contenido) | [**Anterior**](#casteo-de-tipos)  |
|-------------------------------------------|-------------------------------------------|-------------------------------------------|

### Condicionales

| [**Siguiente**](#strings-y-funciones) | [**Indice**](#indice-de-contenido) | [**Anterior**](#bucles)  |
|-------------------------------------------|-------------------------------------------|-------------------------------------------|

### Strings y funciones

| [**Siguiente**](#operaciones-matemáticas) | [**Indice**](#indice-de-contenido) | [**Anterior**](#condicionales)  |
|-------------------------------------------|-------------------------------------------|-------------------------------------------|

### Operaciones matemáticas

| [**Siguiente**](#arrays) | [**Indice**](#indice-de-contenido) | [**Anterior**](#strings-y-funciones)  |
|-------------------------------------------|-------------------------------------------|-------------------------------------------|

### Arrays

| [**Siguiente**](#conceptos-básicos-de-la-poo) | [**Indice**](#indice-de-contenido) | [**Anterior**](#operaciones-matemáticas)  |
|-------------------------------------------|-------------------------------------------|-------------------------------------------|

### Conceptos básicos de la POO

| [**Siguiente**](#segunda-evaluación-ev2) | [**Indice**](#indice-de-contenido) | [**Anterior**](#bucles)  |
|-------------------------------------------|-------------------------------------------|-------------------------------------------|

# **Segunda evaluación (EV2)**

## Programación orientada a objetos

### Conceptos básicos de la POO

### Conceptos avanzados de la POO

Cuando lleguemos a esta evaluación, los ejercicios y proyectos correspondientes se organizarán en la carpeta `src/ev2` del proyecto. De la misma forma, el contenido de la tercera evaluación se guardará en `src/ev3`.

