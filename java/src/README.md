# Notas y matices

El contenido de esta guía esta fuertemente inspirado en dos cosas, la primera, el temario de Java que aprendí durante mi curso de **DAW 2023/2025** en el **IES Arquitecto Ventura Rodriguez**, instituto publico de Boadilla del Monte, Madrid, España y segundo en el **RoadMap** de Java que se puede ver y encontrar en https://roadmap.sh/java 

# Indice de contenido

1. [**Conceptos básicos**](#conceptos-básicos)
    * [**Ciclo de vida de un programa**](#ciclo-de-vida-de-un-programa)
    * [**Sintaxis básica**](#sintaxis-básica)
    * [**Tipos de datos**](#tipos-de-datos)
    * [**Variables y alcances**](#variables-y-alcances)
    * [**Tipo fundición**](#tipo-fundición)
    * [**Cuerdas y métodos**](#cuerdas-y-métodos)
    * [**Operaciones matemáticas**](#operaciones-matemáticas)
    * [**Matrices**](#matrices)
    * [**Condicionales**](#condicionales)
    * [**Bucles**](#bucles)
    * [**Conceptos básicos de la POO**](#conceptos-básicos-de-la-poo)
2. [****]()

# Conceptos básicos

Los lenguajes de programación no se aprenden de la noche a la mañana y Java no es la excepción, antes de llamarnos profesionales tenemos que comprender los conceptos básicos, las terminologías, convenciones de nomenclatura y otros aspectos basícos que nos permitan entender mejor el lenguaje, es por eso que he dividido el contenido de aprendizaje usando guías ofiiclaes como https://roadmap.sh/java para definir el contenido de está guía.

## Ciclo de vida de un programa

La mayoría de las personas están familiarizadas de una forma u otra con los distintos formatos que tienen los archivos, documentos y/o programas que usamos en el día a día, por ejemplo, todos sabemos que un **.pdf** es un archivo que tiene texto, imagenes e información en el, otros formatos conocidos por ejemplo son los de Microsoft Word que son los archivos **.docx** o los **.txt** que son de texto básico.

Todos los archivos de **Java** terminan en el formato **.java**, estos son los archivos editables, es decir, se pueden abrir y/o modificar desde programas de edición de código/texto como **IntelliJ**, **VSCode**, **Eclipse**, **NetBeans** e incluso **NotePad++**.

Cuando ejecutamos el **Kit de desarrollo de Java (JDK)** este "programa" o "software" lee el código y si no tiene errores, lo "compila", es decir, convierte el código en algo realmente ejecutable y/o usable, el encargado de esta misión es el **compilador de java (javac)**, estos archivos ejecutables pasan a llevar el mismo nombre que tenían originalmente pero su extensión deja de ser **.java** y pasa a ser **.class**, los cuales son ejecutables con la maquina virtual de Java.

Todo esto es la explicación resumida de lo que ocurre detrás de nuestros entornos de desarrollo cuando escribimos y ejecutamos/probamos código, es muy bueno saberlo, aunque conozco programadores que han llegado muy lejos sin entender nada de esto.

## Sintaxis básica

Mi profesor de Java, la persona que me enseño a amar el lenguaje, **Jaime Martin Garcia Cuerca** siempre me decía "A veces cuando aprendemos algo nuevo no hace falta entender completamente todo lo que hacemos, lo importante es ir entiendo poco a poco lo que podamos y dejar aquello que no sin preocuparnos hasta que sea entendible", yo pienso exactamente igual, por ejemlos, en las primeras etapas de nuestro aprendizaje vamos a leer mucho las siguientes 4 lineas de código:

```java
public class NombreDelPrograma {
    public static void main (String [] args) {

    }
}
```

Ahora, hay cosas sencillas, por ejemplo, **"NombreDelPrograma"**, es bastante intuitivo, si nuestro archivo se llama **NombreDelPrograma.java**, el código tiene que reflejar el mismo nombre, pero las otras palabras como `public`, `class`, `static`, `void`, `main`, `String`, etc, no tienen sentido ahora, pero poco a poco, según avancemos iran adquiriendo sentido hasta que un día podamos entender todo lo que significan. 

Es de hecho aquí donde aprendemos a usar tres cosas muy importantes, el **System.out.println();** para imprimir mensajes/información en nuestro programa y aprendemos a usar **Scanner** y/o **BufferedReader** para introducir mensajes/información en nuestro programa.

```java
public class EjemploDeLasTresCosas {
    public static void main(String[] args) {
        // ✅ Esta linea siempre es necesaria para activar el Scanner en el programa.
        Scanner teclado = new Scanner(System.in);
        // ✅ Usamos el System.out.println para imprimir mensajes/información.
        System.out.println("¿Cual es tú nombre? ");
        // ✅ Usamos el Scanner para introducir/meter información dentro del programa.
        teclado.nextLine();

        // ✅ Esta linea siempre es necesaria para activar el BufferedReader.
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        // ✅ Usamos el System.out.println para imprimir mensajes/información.
        System.out.println("¿Que día es hoy?");
        // ✅ Usamos el BufferedReader para introducir información dentro del programa.
        lector.readLine();
    }
}

```
## Comentarios en Java

Normalmente nuestros archivos/programas editables de código Java se pueden dividir en dos partes, el código y los comentarios.

Los comentarios son "notas" o "apuntes" o "información" que podemos escribír en nuestro código que explican como funciona o que hace pero que no afectan en nada al funcionamiento, ejemplo:

```java
/**
 * Esto es un ejemplo de comentarios, marcamos el inicio y el fin de ellos usando
 * un slash seguido de dos asterícos ("/**") para marcar el inicio, luego,
 * cada linea de información empieza con un asterisco y cuando ya no 
 * necesitamos escribír nada más finalizamos con otro slash seguido 
 * de un solo asterísco ("* /"), estos comentarios sirven para dejar
 * por escrito información, explicaciones o notas que nos ayuden a
 * entender mejor el código. 
 */
public class EjemploComentarios {
    /*
    Otro tipo de comentario más fácil de hacer pero que a mi en lo personal me
    agrada menos es este, empieza con un slash seguido de un asterísco ("/*")
    y termina con un astericos seguido de un slash ("* /"), de la misma forma
    que el ejemplo anterior, puedo escribír todo lo que quiera sin afectar el
    funcionamiento de nuestros programas.
    */
    public static void main (String [] args) {
        // Finalmente, los comentarios de una sola linea que empiezan con ("//").
        // Sirven para escribir una sola linea a la vez de información y son
        // utiles si solo queremos escribír una linea, aquí por ejemplo ya llevo
        // varias lineas por lo que pierde sentido y es mejor usar cualquiera de
        // las dos opciones anteriores a está.
    }
}
```

## Tipos de datos

## Variables y alcances

## Tipo fundición

## Cuerdas y métodos

## Operaciones matemáticas

## Matrices

## Condicionales

## Bucles

## Conceptos básicos de la POO

# Programación orientada a objetos

## Conceptos básicos de la POO

## Conceptos avanzados de la POO

