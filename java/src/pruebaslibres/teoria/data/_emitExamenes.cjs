/* Genera programacion2022.js y programacion2023.js (40 preguntas cada uno). */
const fs = require("fs");
const path = require("path");

const Q = (numero, enunciado, opciones, correcta, explicacion) => ({
  numero,
  enunciado,
  opciones,
  correcta,
  explicacion,
});

const header = (year, conv) => `// Pruebas libres ${year} — ${conv}
// Fuente: src/pruebaslibres/Pruebas_libres_${year}.pdf

window.bancoExamenes = window.bancoExamenes || {};

`;

function escapar(s) {
  return JSON.stringify(s);
}

function emitir(nombreArchivo, id, preguntas) {
  const cuerpo =
    `window.bancoExamenes.${id} = [\n` +
    preguntas
      .map(
        (p) => `  {
    numero: ${p.numero},
    enunciado: ${escapar(p.enunciado)},
    opciones: ${JSON.stringify(p.opciones)},
    correcta: ${p.correcta},
    explicacion: ${escapar(p.explicacion)}
  }`
      )
      .join(",\n") +
    "\n];\n";
  fs.writeFileSync(
    path.join(__dirname, nombreArchivo),
    header(nombreArchivo.match(/\d{4}/)[0], id) + cuerpo,
    "utf8"
  );
}

const codeQ2Herencia = `Object o1 = new A();
Object o2 = new B();
System.out.print(o1 instanceof A);
System.out.print(" ");
System.out.print(o1 instanceof B);
System.out.print(" ");
System.out.print(o2 instanceof A);
System.out.print(" ");
System.out.print(o2 instanceof B);`;

const examen2022 = [
  Q(
    1,
    `¿Qué se imprime cuando se compila y ejecuta el siguiente programa? Seleccione la respuesta correcta.
class test {
public static void main (String[] args) {
int i;
do{
i++;
}while (i<0);
System.out.println(i);
}
}`,
    [
      "El programa no se compila porque i no está inicializado.",
      "El programa se compila y se ejecuta, pero no imprime nada.",
      "El programa imprime 0.",
      "El programa imprime 1.",
    ],
    0,
    "La variable local i no está asignada antes del primer i++; el compilador exige asignación definida."
  ),
  Q(
    2,
    `Si en Java la clase B hereda de la clase A y ejecutamos el siguiente código
¿cuál será la salida que se imprima?

${codeQ2Herencia}`,
    [
      "true false false true",
      "true false true true",
      "true true false true",
      "false false true false",
    ],
    1,
    "o1 referencia un A: instanceof A sí, B no. o2 referencia un B: instanceof A y B sí → true false true true."
  ),
  Q(
    3,
    "¿Cuáles de las siguientes son palabras clave de Java?",
    [
      "external, implement",
      "throw, void",
      "integer, synchronize",
      "unsigned, extend",
    ],
    1,
    "throw y void son palabras reservadas en Java."
  ),
  Q(
    4,
    `¿Cuál es la salida del siguiente programa?
public class Ejemplo{
private int i= dameJ();
private int j=10;
private int dameJ (){
return j;
}
public static void main (String[] args){
System.out.println ((new Ejemplo()).i);
}}`,
    [
      "Da un error de compilación debido a las restricciones de acceso a las variables privadas de Ejemplo.",
      "Da un error de compilación debido a la referencia que se hace a métodos declarados con posterioridad.",
      "No da ningún error de compilación y produce como salida el valor 10.",
      "No da ningún error de compilación y produce como salida el valor 0.",
    ],
    3,
    "i se inicializa antes que j; al ejecutar dameJ(), j vale 0 por defecto, así que i queda en 0."
  ),
  Q(
    5,
    `Dado el siguiente código, ¿es correcto o presenta errores en tiempo de compilación o ejecución?
public class PreguntaStatic {
private static final int MAX_INTERVALOS = 14;
private static Intervalo [] intervalos = null;
public PreguntaStatic() {
PreguntaStatic.intervalos = new Intervalo[PreguntaStatic.MAX_INTERVALOS];
}
static {
Intervalo first = new Intervalo(2,4);
PreguntaStatic.intervalos[0] = first;
...
}
}`,
    [
      "No, porque daría una excepción java.lang.NullPointerException cuando se intenta acceder a una posición del array en el bloque de código static.",
      "Sí, el array de intervalos al ser un atributo estático se inicializa correctamente en el bloque static.",
      "No, porque no se puede inicializar un atributo estático dentro de un constructor.",
      "Sí, porque inicializa el array de intervalos cada vez que se crea una instancia de la clase PreguntaStatic.",
    ],
    0,
    "Al ejecutar el bloque static, intervalos sigue siendo null al asignar intervalos[0] (el constructor aún no ha corrido)."
  ),
  Q(
    6,
    "Cuando se tiene una referencia polimórfica",
    [
      "Se pueden invocar métodos heredados de la clase padre y añadidos en la clase hija.",
      "Se pueden invocar métodos heredados de la clase padre y sólo se podrán invocar los métodos añadidos en la clase hija si se hace un casting.",
      "Se pueden invocar métodos heredados de la clase padre y sólo algunos de los añadidos en la clase hija.",
      "Ninguna de las respuestas es correcta.",
    ],
    1,
    "Con referencia de tipo padre, los métodos solo de la hija requieren casting explícito."
  ),
  Q(
    7,
    `En Java, ¿Cuál es la salida del siguiente código?
for (int i=0;i<4;i++)
System.out.print("Hola ");`,
    ["Hola", "Hola Hola", "Hola Hola Hola", "Hola Hola Hola Hola"],
    3,
    "El PDF original muestra el bucle en imagen; un for de 0 a 3 imprime cuatro veces \"Hola \"."
  ),
  Q(
    8,
    `¿Cuál es la salida del siguiente código?
try {
Float f1 = new Float("3.0");
int x = f1.intValue();
byte b = f1.byteValue();
double d = f1.doubleValue();
System.out.println(x + b + d);
}
catch (NumberFormatException e){
System.out.println("bad number");
}`,
    [
      "9.0",
      "bad number",
      "La compilación falla en la línea 8.",
      "La compilación falla en la línea 9.",
    ],
    0,
    "x=3, b=3, d=3.0; la suma numérica promociona a double → 9.0."
  ),
  Q(
    9,
    `¿Cuál es la salida del siguiente código?
public enum Mes{
ENERO(1), ..., DICIEMBRE(12);
private final int numero;
Mes(int numero){ this.numero=numero; }
public static void main(String[] args){
Mes mes1=Mes.MAYO;
System.out.println(mes1);
}
}`,
    ["MAYO(5)", "(5)MAYO", "MAYO", "Ninguna de las respuestas es correcta"],
    2,
    "println de un enum muestra el nombre literal del constante."
  ),
  Q(
    10,
    "¿Cuál de las siguientes afirmaciones es correcta?",
    [
      "Al ejecutar javadoc se generan ficheros en formato XML para la documentación",
      "Al ejecutar javadoc se genera un único fichero HTML con la documentación",
      "Al ejecutar javadoc se generan ficheros en formato HTML para la documentación, al menos se genera uno por cada archivo .java, entre otras cosas",
      "Todas las respuestas son correctas",
    ],
    2,
    "Javadoc genera HTML (varios ficheros según la estructura del proyecto)."
  ),
  Q(
    11,
    `¿Cuál es la salida del siguiente código?
class xyz {
public static void main (String[] args){
int i, j, k;
for (i=0; i<3; i++){
for (j=1; j<4; j++) {
for (k=2; k<5; k++){
if ( (i==j) && (j==k) )
System.out.println(i);
}}}}}`,
    ["1", "2", "3", "4"],
    1,
    "Solo cuando i=j=k=2 se cumple la condición; se imprime 2."
  ),
  Q(
    12,
    `¿Cuál es la salida del siguiente código?
class test {
static boolean check;
public static void main(String args[]) {
int i;
if(check == true)
i=1;
else
i=2;
if(i=2) i=i+2;
else i = i + 4;
System.out.println(i);
}
}`,
    ["4", "5", "0", "El programa no compila"],
    3,
    "if(i=2) usa asignación en lugar de comparación; no compila en Java."
  ),
  Q(
    13,
    "¿En cuál de los siguientes tipos de ResultSet, el cursor puede avanzar sólo hacia delante en el conjunto de resultados?",
    [
      "ResultSet.TYPE_FORWARD_ONLY",
      "ResultSet.TYPE_SCROLL_INSENSITIVE",
      "ResultSet.TYPE_SCROLL_SENSITIVE",
      "Ninguna de las anteriores.",
    ],
    0,
    "TYPE_FORWARD_ONLY es el cursor solo hacia adelante por defecto."
  ),
  Q(
    14,
    `¿Cuál es la salida del siguiente código?
class MiClase { public int valor; }
class Test {
public static void main(String[] args){
MiClase a1 = new MiClase ();
MiClase a2 = new MiClase ();
MiClase a3 = new MiClase ();
a1.valor=150;
a2.valor=150;
a3 = a2;
if (a1 == a2) { System.out.println(" UNO");}
if (a1 == a3) { System.out.println(" DOS");}
if (a2 == a3) { System.out.println(" TRES");}
}
}`,
    ["TRES", "UNO TRES", "UNO", "UNO DOS TRES"],
    0,
    "Solo a2 y a3 comparten referencia; se imprime TRES."
  ),
  Q(
    15,
    `¿Cuál es la salida al siguiente programa? (Padre con constructores; Hija sin constructor explícito)
FICHERO Hija.java — new Hija(); System.out.println(h);`,
    [
      "Da un error en tiempo de compilación porque la clase hija no tiene constructor",
      "La salida es \"Soy la clase hija con valor 0\"",
      "Da un error en tiempo de ejecución porque la clase hija no tiene constructor",
      "Ninguna de las respuestas es correcta.",
    ],
    1,
    "Se añade constructor por defecto que llama a super(); toString muestra h=0."
  ),
  Q(
    16,
    `Dado el siguiente fragmento de código, indica cuál de las siguientes afirmaciones es correcta en relación al valor de la variable foo.
int index = 1;
boolean[] test = new boolean[3];
boolean foo = test [index];`,
    [
      "foo tiene el valor 0",
      "foo tiene el valor null",
      "foo tiene el valor false",
      "Se produce una excepción y foo no posee ningún valor",
    ],
    2,
    "Los boolean del array se inicializan a false."
  ),
  Q(
    17,
    `¿Qué ocurrirá al compilar y ejecutar el siguiente código?
public class MiClase{
static int variableEstatica;
public static void main(String argv[]){
System.out.println(variableEstatica);
}
}`,
    [
      "Error en tiempo de ejecución. La variable \"variableEstatica\" no ha sido inicializada",
      "Se mostrará en pantalla null",
      "Se mostrará en pantalla 1",
      "Se mostrará en pantalla 0",
    ],
    3,
    "Los enteros estáticos de clase se inicializan a 0."
  ),
  Q(
    18,
    `Dado el siguiente código, ¿Cuál de las siguientes afirmaciones es correcta?
Set<Object> objetos = new HashSet<Object>();
String obj1 = "JAVA";
int obj2 = 5;
Boolean obj3 = new Boolean(true);
objetos.add(obj3);
objetos.add(obj1);
objetos.add(obj2);
objetos.add(obj3);
for(Object object : objetos)
System.out.print(object);`,
    [
      "Error en tiempo de ejecución.",
      "Se muestran por pantalla JAVA 5 y true en el orden exacto en el que fueron insertadas en la colección.",
      "Se muestran por pantalla JAVA 5 y true en un orden no determinado.",
      "Se muestran por pantalla JAVA 5 y true en un orden no determinado y, además, \"true\" se muestra dos veces.",
    ],
    2,
    "HashSet no permite duplicados; el orden de iteración no está garantizado."
  ),
  Q(
    19,
    "Indique cuál de las siguientes afirmaciones es falsa:",
    [
      "El objetivo de la sobrecarga de métodos es facilitar la invocación de un mismo método pasándole un conjunto de parámetros de entrada diferentes.",
      "Se puede sobrecargar un método variando el tipo de retorno de éste sin variar los parámetros de entrada.",
      "Un método puede ser sobrecargado en la misma clase o en una subclase.",
      "Los métodos sobrecargados pueden cambiar el modificador de acceso del método original.",
    ],
    1,
    "No basta con cambiar el tipo de retorno; debe cambiar la firma (parámetros)."
  ),
  Q(
    20,
    `En Java, ¿Cuál es la salida del siguiente código?
int[] a = new int[0];
System.out.println(a[0]);`,
    [
      "ArrayIndexOutOfBoundsException",
      "UntrustableBoundsException",
      "1",
      "Ninguna de las anteriores",
    ],
    0,
    "Índice 0 en array de longitud 0 provoca ArrayIndexOutOfBoundsException."
  ),
  Q(
    21,
    `¿Cuál es la salida del siguiente programa?
public class incr {
public static void main(String args[]) {
int i , j;
i = j = 3;
int n = 2 * ++i;
int m = 2 * j++;
System.out.println(i + " " + j + " " + n + " " + m);
}
}`,
    ["4 4 8 6", "4 4 8 8", "4 4 6 6", "4 3 8 6"],
    0,
    "++i deja i=4, n=8; j++ usa 3 en m y luego j=4, m=6."
  ),
  Q(
    22,
    "¿Qué clase abstracta es la superclase de todas las clases usadas para leer bytes?",
    ["FileReader", "ByteReader", "InputStream", "FileInputStream"],
    2,
    "InputStream es la clase base abstracta para lectura de bytes."
  ),
  Q(
    23,
    "Indicar la respuesta correcta. Un conjunto es una estructura,",
    [
      "Que almacena cada elemento individual una sola vez como mínimo. No mantiene un orden específico.",
      "Que almacena cada elemento individual una sola vez como mínimo. Mantiene un orden específico.",
      "Que almacena cada elemento individual una sola vez como máximo. No mantiene un orden específico.",
      "Que almacena cada elemento individual una sola vez como máximo. Mantiene un orden específico.",
    ],
    2,
    "Un Set no admite duplicados (como máximo una copia) y normalmente sin orden garantizado."
  ),
  Q(
    24,
    "¿Qué clase permite la lectura de datos primitivos de un fichero binario?",
    ["DataInputStream", "DataOutputStream", "ObjectInputStream", "BufferedWriter"],
    0,
    "DataInputStream lee tipos primitivos en binario."
  ),
  Q(
    25,
    "Nombre de la excepción lanzada por el método de lectura definido en la clase InputStream",
    ["IOException", "ClassNotFoundException", "EOFException", "Las 3 respuestas son correctas."],
    0,
    "read() declara IOException (EOF se modela con -1, no siempre como EOFException en read())."
  ),
  Q(
    26,
    `Sea la siguiente definición de clase y subclase, ¿Cuál de las siguientes afirmaciones es cierta al ejecutar el código?
public class ClaseB extends ClaseA {
public ClaseB(String s) {
System.out.print("Construyendo Clase B.");
super(s);
}
}`,
    [
      "Se produce un error en tiempo de ejecución.",
      "Se muestra el mensaje \"Construyendo Clase B. Construyendo Clase A.\".",
      "Se muestra el mensaje \"Construyendo Clase A. Construyendo Clase B.\".",
      "Error de compilación.",
    ],
    3,
    "super(s) debe ser la primera instrucción del constructor; aquí hay error de compilación."
  ),
  Q(
    27,
    "Se tiene creado el fichero serializable \"fichero.obj\" y se quiere añadir más información a dicho fichero. ¿Qué sentencia se pondría?",
    [
      'new ObjectOutputStream ("fichero.obj",append);',
      'new ObjectOutputStream ("fichero.obj",true);',
      'new FileOutputStream ("fichero.obj",true);',
      "Ninguna es correcta",
    ],
    2,
    "Para abrir en modo append se usa FileOutputStream(fichero, true) y encadenar el stream adecuado."
  ),
  Q(
    28,
    "¿Cuál es la salida de esta línea System.out.println(Math.sqrt(-4D));?",
    ["-2", "NaN", "Error de compilación", "Error en tiempo de ejecución"],
    1,
    "sqrt de negativo en double devuelve NaN."
  ),
  Q(
    29,
    "En Oracle ¿cuál de las opciones siguientes para definir un objeto denominado Personal es correcta?",
    [
      "CREATE OR REPLACE TYPE Personal AS OBJECT(codigo VARCHAR2(3));",
      "CREATE OR REPLACE OBJECT Personal AS OBJECT(codigo VARCHAR2(3));",
      "CREATE OR REPLACE ENTITY OBJECT Personal AS OBJECT(codigo VARCHAR2(3));",
      "CREATE OR REPLACE CLASS Personal AS OBJECT(codigo VARCHAR2(3));",
    ],
    0,
    "Sintaxis Oracle: TYPE ... AS OBJECT."
  ),
  Q(
    30,
    "¿Cuál es el resultado de la sentencia System.out.println(100>>4);?",
    ["true", "false", "6", "25"],
    2,
    "100 >> 4 equivale a división entera entre 16 → 6."
  ),
  Q(
    31,
    `¿Qué se producirá si intenta compilar y ejecutar el código siguiente, pero no hay ningún archivo llamado Hello.txt en el directorio actual?
(método amethod con try/catch FileNotFoundException, finally y return -1)`,
    [
      "No such file found",
      "No such file found ,-1",
      "No such file found, Doing finally, -1",
      "0",
    ],
    2,
    "Se entra en catch, imprime mensaje, ejecuta finally y luego retorna -1 desde el catch."
  ),
  Q(
    32,
    `Dada el siguiente código, indicar la salida:
public int xyz(int num) {
if(num == 1) return 1;
else return(xyz(num-1) + num);
}
System.out.println(test1.xyz(100));`,
    [
      "Un error en tiempo de ejecución",
      "Se mostrará 100",
      "Se mostrará 1",
      "Se mostrará 5050",
    ],
    3,
    "Suma recursiva 1+2+...+100 = 5050."
  ),
  Q(
    33,
    `Dado el siguiente fragmento (metodo con NPE y catch; main con try/catch). Nota: el orden catch(Exception) antes de catch(NullPointerException) en main es inválido en Java.
¿Cuál afirmación encaja con el planteamiento del examen?`,
    ["3-5-FIN", "3-4-5-FIN", "3-FIN", "5-FIN"],
    2,
    "Si el código compilara tras corregir el orden de catch, metodo captura la NPE con Exception e imprime 3- y luego FIN. Ojo: tal como está en el PDF, main no compila."
  ),
  Q(
    34,
    "¿Qué es JDBC?",
    [
      "JDBC es un protocolo basado en java",
      "JDBC es una API Java estándar para la conectividad independiente de la base de datos",
      "JDBC es una especificación para indicar cómo conectarse a una base de datos.",
      "Controlador común para conexión básica",
    ],
    1,
    "JDBC es la API estándar de conectividad con bases de datos."
  ),
  Q(
    35,
    `Indicar cuál es la salida por consola cuando se ejecuta el siguiente programa:
call_array(arr[0], arr) con arr = {1,2,3,4}; arr[i]=6 dentro del método.`,
    ["1, 2", "5, 2", "1, 6", "5, 6"],
    2,
    "i vale 1; se modifica arr[1] a 6; arr[0] sigue siendo 1."
  ),
  Q(
    36,
    `Persona p = new Persona(28); ... p = new Alumno(15); p.pasarCurso();`,
    [
      "Se muestra en la consola 28-15.",
      "No compilará por la línea p.pasarCurso();",
      "Se muestra en la consola 28-29.",
      "Se muestra en la consola 28-28.",
    ],
    1,
    "p es referencia Persona; pasarCurso() no existe en Persona → error de compilación."
  ),
  Q(
    37,
    "En Java, dada la clase Alumno definida en el siguiente código ¿Cómo se puede instanciar un objeto de la clase Alumno?",
    [
      "Alumno a = newobject Alumno(Maria, 9);",
      'Alumno a = new Alumno( "Maria" , 7 );',
      "Alumno a = new Alumno( 'Luis' , 6.5 );",
      "Ninguna de las anteriores",
    ],
    1,
    'Sintaxis correcta: new Alumno("Maria", 7) si el constructor acepta (String,int).'
  ),
  Q(
    38,
    `TestExcepciones con getNumeroPositivo() y varios objetos en un único try (E1=1, E2=-2, ...).
¿Cuál será la salida del programa por consola?`,
    ["1-270", "1-2Terminó con error", "1Terminó con error", "1-270Terminó con error"],
    2,
    "Tras imprimir 1, la llamada con número negativo lanza la excepción y se imprime el mensaje del catch."
  ),
  Q(
    39,
    "Indicar cuál de las siguientes afirmaciones es correcta",
    [
      "Un atributo friendly es visible desde la misma clase y también desde el paquete al que pertenece.",
      "Si no se define el modificador de acceso, el modificador de un método es protected.",
      "Un atributo o método private solo es visible dentro de un paquete.",
      "No se puede acceder a un atributo public desde una subclase.",
    ],
    0,
    "Sin modificador (package-private) es visible en el mismo paquete."
  ),
  Q(
    40,
    `TestUFO con Disparo dn = new DisparoNave(); inicio(dn); d.disparar();
Indicar cuál de las siguientes afirmaciones es correcta`,
    [
      "El método disparar está sobrecargado.",
      "No se muestra por pantalla ningún mensaje.",
      "Muestra por pantalla el mensaje \"Dispara la nave\".",
      "Obtenemos un error en tiempo de ejecución.",
    ],
    2,
    "Polimorfismo: se ejecuta disparar() de DisparoNave."
  ),
];

// --- 2023: mismas preguntas con variaciones del PDF 2022-2023 ---
const examen2023 = examen2022.map((p, idx) => {
  const n = idx + 1;
  if (n === 1) {
    return Q(
      1,
      `¿Qué se imprime cuando se compila y ejecuta el siguiente programa? Seleccione la respuesta correcta.
class test {
public static void main (String[] args) {
int i=0;
do{
i++;
}while (i<0);
System.out.println(i);
}
}`,
      [
        "El programa no se compila porque i no está inicializado.",
        "El programa se compila y se ejecuta, pero no imprime nada.",
        "El programa imprime 0.",
        "El programa imprime 1.",
      ],
      3,
      "i se inicializa a 0; tras i++ vale 1; la condición del while es falsa; se imprime 1."
    );
  }
  if (n === 2) {
    return Q(
      2,
      `Si en Java la clase B hereda de la clase A y ejecutamos el siguiente código
¿cuál será la salida que se imprima?

${codeQ2Herencia}`,
      [
        "true false false true",
        "true true false true",
        "true false true true",
        "false false true false",
      ],
      2,
      "Mismo razonamiento que 2022: la salida es true false true true → opción c en este orden."
    );
  }
  if (n === 3) {
    return Q(
      3,
      "¿Cuáles de las siguientes son palabras clave de Java?",
      [
        "void, implement",
        "unsigned, float",
        "integer, synchronize",
        "static, float",
      ],
      3,
      "static y float son palabras reservadas."
    );
  }
  if (n === 4) {
    return Q(
      4,
      `¿Cuál es la salida del siguiente programa?
public class Ejemplo{
private int j=10;}
class Main {
public static void main(String[] args) {
Ejemplo x= new Ejemplo();
System.out.println (x.j);
}
}`,
      [
        "Da un error de compilación debido a las restricciones de acceso a las variables privadas de Ejemplo.",
        "Da un error de compilación debido a la creación del objeto x.",
        "No da ningún error de compilación y produce como salida el valor 10.",
        "No da ningún error de compilación y produce como salida el valor 0.",
      ],
      0,
      "j es privado; Main no puede acceder a x.j desde fuera de Ejemplo."
    );
  }
  if (n === 5) {
    return Q(
      5,
      p.enunciado,
      [
        "Sí, porque inicializa el array de intervalos cada vez que se crea una instancia de la clase PreguntaStatic.",
        "Sí, el array de intervalos al ser un atributo estático se inicializa correctamente en el bloque static.",
        "No, porque no se puede inicializar un atributo estático dentro de un constructor.",
        "No, porque daría una excepción java.lang.NullPointerException cuando se intenta acceder a una posición del array en el bloque de código static.",
      ],
      3,
      "Mismo fallo NPE al usar intervalos null en el bloque static (orden de opciones distinto al de 2022)."
    );
  }
  if (n === 6) {
    // Misma respuesta que 2022 (opción b): métodos solo de la hija requieren casting.
    return Q(
      6,
      p.enunciado,
      [
        "Se pueden invocar métodos heredados de la clase padre y añadidos en la clase hija.",
        "Se pueden invocar métodos heredados de la clase padre y sólo se podrán invocar los métodos añadidos en la clase hija si se hace un casting.",
        "Se pueden invocar métodos heredados de la clase padre y sólo algunos de los añadidos en la clase hija.",
        "Ninguna de las respuestas es correcta.",
      ],
      1,
      "Con referencia de tipo padre solo ves la API del padre; los métodos exclusivos de la hija requieren casting explícito (opción b)."
    );
  }
  if (n === 7) {
    return Q(
      7,
      `En Java, ¿Cuál es la salida del siguiente código?
float[] vector = new float[4];
for (int i=0;i<vector.length;i=i+2)
System.out.println("Hola ");`,
      ["Hola", "Hola Hola", "Hola Hola Hola", "Hola Hola Hola Hola"],
      1,
      "i toma 0 y 2: dos iteraciones, dos líneas \"Hola \"."
    );
  }
  if (n === 8) {
    return Q(
      8,
      `¿Cuál es la salida del siguiente código?
try {
Float f1 = new Float(3.0);
int x = f1.intValue();
System.out.println(x % 2);
}
catch (NumberFormatException e){
System.out.println("bad number");
}`,
      ["1", "1,5", "bad number", "Hay errores sintácticos en el código."],
      0,
      "3 % 2 = 1; no hay NumberFormatException."
    );
  }
  if (n === 9) {
    return Q(
      9,
      `¿Cuál es la salida del siguiente código?
public enum Demarcacion
{PORTERO, DEFENSA, CENTROCAMPISTA, DELANTERO}
public static void main(String[] args){
Demarcacion delantero = Demarcacion.DELANTERO;
Demarcacion defensa = Demarcacion.DEFENSA;
System.out.println(delantero.compareTo(defensa));
}`,
      ["0", "1", "2", "3"],
      2,
      "compareTo por ordinal: DELANTERO (3) vs DEFENSA (1) → 2."
    );
  }
  if (n === 10) {
    return Q(
      10,
      "¿Cuál de las siguientes afirmaciones es correcta?",
      [
        "Al ejecutar javadoc se generan ficheros en formato XML para la documentación",
        "Al ejecutar javadoc se genera un único fichero HTML con la documentación",
        "Al ejecutar javadoc se generan ficheros en formato DOCX para la documentación, al menos se genera uno por cada archivo .java, entre otras cosas",
        "Ninguna de las anteriores",
      ],
      3,
      "Ninguna describe bien Javadoc (genera HTML, no DOCX/XML como única opción válida tal cual)."
    );
  }
  if (n === 11) {
    // Mismo código que 2022: solo i=j=k=2 cumple la condición → se imprime 2.
    return Q(
      11,
      p.enunciado,
      ["1", "2", "3", "4"],
      1,
      "Solo cuando i=2, j=2 y k=2 se cumple (i==j)&&(j==k); se imprime 2."
    );
  }
  if (n === 16) {
    return Q(
      16,
      `¿Cuál es la salida al siguiente programa?
int index = 2;
boolean[] test = new boolean[3];
for (int i=0;i<test.length;i=i+3)
test[i]=true;
boolean foo = test [index];
System.out.println(foo);`,
      [
        "true",
        "false",
        "null",
        "Se produce una excepción y no se termina de ejecutar el programa correctamente",
      ],
      1,
      "Solo test[0] se pone true; test[2] sigue false."
    );
  }
  if (n === 17) {
    return Q(
      17,
      `¿Qué ocurrirá al compilar y ejecutar el siguiente código?
public class MiClase{
static int variableEstatica=2;
public static void main(String argv[]){
System.out.println(++variableEstatica);
}
}`,
      [
        "Se mostrará en pantalla 0",
        "Se mostrará en pantalla 2",
        "Se mostrará en pantalla 3",
        "Hay errores de sintácticos que hace que el código no compile.",
      ],
      2,
      "++variableEstatica incrementa 2 a 3 antes de imprimir."
    );
  }
  if (n === 19) {
    return Q(
      19,
      "Indique cuál de las siguientes afirmaciones es verdadera:",
      [
        "El objetivo de la sobrecarga de métodos es facilitar la invocación de un mismo método pasándole un conjunto de parámetros de entrada diferentes.",
        "Se puede sobrecargar un método variando el tipo de retorno de éste y el identificador del método",
        "Se puede sobrecargar un método variando el tipo de retorno de éste sin variar los parámetros de entrada.",
        "Los métodos en Java no pueden ser sobrecargados.",
      ],
      0,
      "La sobrecarga permite mismo nombre con distintos parámetros."
    );
  }
  if (n === 21) {
    return Q(
      21,
      `¿Cuál es la salida del siguiente programa?
public class incr {
public static void main(String args[]) {
int i , j;
i = j = 3 % 1;
int n = 7 * ++i;
System.out.println(i + " " + j + " " + n);
}
}`,
      ["1 0 7", "0 0 7", "1 0 14", "0 0 14"],
      0,
      "3%1=0; i y j quedan en 0; ++i deja i=1; n=7*1=7 → imprime 1 0 7."
    );
  }
  if (n === 22) {
    return Q(
      22,
      p.enunciado,
      ["FileReader", "InputStream", "InputStreamReader", "FileInputStream"],
      1,
      "Superclase abstracta para leer bytes: InputStream."
    );
  }
  if (n === 23) {
    return Q(
      23,
      p.enunciado,
      [
        "Que almacena cada elemento individual una sola vez como máximo. No mantiene un orden específico.",
        "Que almacena cada elemento individual una sola vez como mínimo. No mantiene un orden específico.",
        "Que almacena cada elemento individual una sola vez como máximo. Mantiene un orden específico.",
        "Que almacena cada elemento individual una sola vez como mínimo. Mantiene un orden específico.",
      ],
      0,
      "Set: sin duplicados (como máximo una vez), sin orden garantizado."
    );
  }
  if (n === 24) {
    return Q(
      24,
      p.enunciado,
      [
        "ClassInputStream",
        "ImplementInputStream",
        "ObjectInputStream",
        "Ninguna de las anteriores",
      ],
      3,
      "Para primitivos en binario se usa DataInputStream; no está en la lista → ninguna de las anteriores."
    );
  }
  if (n === 25) {
    return Q(
      25,
      p.enunciado,
      [
        "ClassNotFoundException",
        "EOFException",
        "IOException",
        "Ninguna de las anteriores",
      ],
      2,
      "InputStream.read() declara IOException."
    );
  }
  if (n === 28) {
    return Q(
      28,
      "¿Cuál es la salida de esta línea System.out.println(Math.sqrt(4));?",
      ["2.0", "16.0", "NaN", "Error de compilación"],
      0,
      "sqrt(4) es 2.0."
    );
  }
  if (n === 29) {
    return Q(
      29,
      "¿Cuál de las siguientes opciones gestiona una lista de controladores de bases de datos en JDBC que permite manejar objetos de la base de datos?",
      [
        "JDBC driver.",
        "ClassDriverManager.",
        "DriverManager.",
        "StreamOuputDriverManager.",
      ],
      2,
      "DriverManager registra y obtiene drivers JDBC."
    );
  }
  if (n === 30) {
    return Q(
      30,
      '¿Cuál es el resultado de la sentencia System.out.println("Solución: " + "(3+4)");?',
      [
        "Solución: (3+4)",
        "Solución: (7)",
        "Solución: 7",
        "Error de compilación",
      ],
      0,
      "Es concatenación de cadenas; no se evalúa la suma."
    );
  }
  if (n === 32) {
    return Q(
      32,
      `Dada el siguiente código, indicar la salida:
public int xyz(int num) {
if(num == 1) return 1;
else return(xyz(num-1));
}
System.out.println(test1.xyz(100));`,
      ["Se mostrará 4", "Se mostrará 100", "Se mostrará 1", "Se mostrará 5050"],
      2,
      "La recursión devuelve siempre 1 (no suma n)."
    );
  }
  if (n === 34) {
    return Q(
      34,
      "¿Qué es JDBC?",
      [
        "Controlador común para conexión básica",
        "JDBC es un protocolo basado en java",
        "JDBC es una especificación para indicar cómo conectarse a una base de datos.",
        "JDBC es una API Java estándar para la conectividad independiente de la base de datos",
      ],
      3,
      "Definición estándar: API de conectividad con BD."
    );
  }
  if (n === 35) {
    return Q(
      35,
      `Indicar cuál es la salida por consola cuando se ejecuta el siguiente programa:
class Main {
public static void main(String args[]) {
int[] arr = {1,2,3};
call_array(arr);
System.out.println(arr[0]);
}
static void call_array(int arr[]) {
arr[0] = 5;
}
}`,
      ["1", "5", "Null", "d) Error de compilación"],
      1,
      "El array se pasa por referencia; arr[0] pasa a 5."
    );
  }
  if (n === 36) {
    return Q(
      36,
      `Persona p = new Persona(28);
System.out.print(p.darEdad()+" - ");
p = new Alumno(15);
p.pasarCurso();
System.out.print(p.darEdad());`,
      [
        "Se muestra en la consola 15-28.",
        "Se muestra en la consola 28-29.",
        "Se muestra en la consola 29-28.",
        "No compilará por la línea p.pasarCurso();",
      ],
      3,
      "Mismo problema: pasarCurso no está en Persona."
    );
  }
  if (n === 37) {
    return Q(
      37,
      "En Java, dada la clase Alumno definida en el siguiente código ¿Cómo se puede instanciar un objeto de la clase Alumno?",
      [
        "Alumno a = new Alumno( 'María' , 2.5 );",
        "Alumno a = newobject Alumno(Maria, 2);",
        'Alumno a = new Alumno( "Luis" , 2 );',
        "Alumno a = new Alumno( 'María', '2.5' );",
      ],
      2,
      'new Alumno("Luis", 2) con (String, int).'
    );
  }
  if (n === 38) {
    return Q(
      38,
      p.enunciado,
      [
        "1Terminó con error",
        "2Terminó con error",
        "1-2Terminó con error",
        "2-1Terminó con error",
      ],
      0,
      "Tras 1, la siguiente llamada con número negativo lanza y se imprime Terminó con error."
    );
  }
  if (n === 39) {
    return Q(
      39,
      p.enunciado,
      [
        "Un atributo o método private solo es visible dentro de un paquete.",
        "Si no se define el modificador de acceso, el modificador de un método es protected.",
        "No se puede acceder a un atributo public desde una subclase.",
        "Ninguna de las anteriores",
      ],
      3,
      "Las tres primeras son falsas; la correcta es ninguna de las anteriores."
    );
  }
  if (n === 40) {
    return Q(
      40,
      p.enunciado,
      [
        "Muestra por pantalla el mensaje \"Dispara la nave\".",
        "Muestra por pantalla el mensaje \"null\".",
        "No se muestra por pantalla ningún mensaje.",
        "Hay errores de compilación.",
      ],
      0,
      "Igual que 2022: polimorfismo y mensaje en consola."
    );
  }
  return { ...p, opciones: [...p.opciones] };
});

emitir("programacion2022.js", "programacion2022", examen2022);
emitir("programacion2023.js", "programacion2023", examen2023);

console.log("OK: programacion2022.js y programacion2023.js generados.");
