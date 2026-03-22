// Pruebas libres 2022 — programacion2022
// Fuente: src/pruebaslibres/Pruebas_libres_2022.pdf

window.bancoExamenes = window.bancoExamenes || {};

window.bancoExamenes.programacion2022 = [
  {
    numero: 1,
    enunciado: "¿Qué se imprime cuando se compila y ejecuta el siguiente programa? Seleccione la respuesta correcta.\nclass test {\npublic static void main (String[] args) {\nint i;\ndo{\ni++;\n}while (i<0);\nSystem.out.println(i);\n}\n}",
    opciones: ["El programa no se compila porque i no está inicializado.","El programa se compila y se ejecuta, pero no imprime nada.","El programa imprime 0.","El programa imprime 1."],
    correcta: 0,
    explicacion: "La variable local i no está asignada antes del primer i++; el compilador exige asignación definida."
  },
  {
    numero: 2,
    enunciado: "Si en Java la clase B hereda de la clase A y ejecutamos el siguiente código\n¿cuál será la salida que se imprima?\n\nObject o1 = new A();\nObject o2 = new B();\nSystem.out.print(o1 instanceof A);\nSystem.out.print(\" \");\nSystem.out.print(o1 instanceof B);\nSystem.out.print(\" \");\nSystem.out.print(o2 instanceof A);\nSystem.out.print(\" \");\nSystem.out.print(o2 instanceof B);",
    opciones: ["true false false true","true false true true","true true false true","false false true false"],
    correcta: 1,
    explicacion: "o1 referencia un A: instanceof A sí, B no. o2 referencia un B: instanceof A y B sí → true false true true."
  },
  {
    numero: 3,
    enunciado: "¿Cuáles de las siguientes son palabras clave de Java?",
    opciones: ["external, implement","throw, void","integer, synchronize","unsigned, extend"],
    correcta: 1,
    explicacion: "throw y void son palabras reservadas en Java."
  },
  {
    numero: 4,
    enunciado: "¿Cuál es la salida del siguiente programa?\npublic class Ejemplo{\nprivate int i= dameJ();\nprivate int j=10;\nprivate int dameJ (){\nreturn j;\n}\npublic static void main (String[] args){\nSystem.out.println ((new Ejemplo()).i);\n}}",
    opciones: ["Da un error de compilación debido a las restricciones de acceso a las variables privadas de Ejemplo.","Da un error de compilación debido a la referencia que se hace a métodos declarados con posterioridad.","No da ningún error de compilación y produce como salida el valor 10.","No da ningún error de compilación y produce como salida el valor 0."],
    correcta: 3,
    explicacion: "i se inicializa antes que j; al ejecutar dameJ(), j vale 0 por defecto, así que i queda en 0."
  },
  {
    numero: 5,
    enunciado: "Dado el siguiente código, ¿es correcto o presenta errores en tiempo de compilación o ejecución?\npublic class PreguntaStatic {\nprivate static final int MAX_INTERVALOS = 14;\nprivate static Intervalo [] intervalos = null;\npublic PreguntaStatic() {\nPreguntaStatic.intervalos = new Intervalo[PreguntaStatic.MAX_INTERVALOS];\n}\nstatic {\nIntervalo first = new Intervalo(2,4);\nPreguntaStatic.intervalos[0] = first;\n...\n}\n}",
    opciones: ["No, porque daría una excepción java.lang.NullPointerException cuando se intenta acceder a una posición del array en el bloque de código static.","Sí, el array de intervalos al ser un atributo estático se inicializa correctamente en el bloque static.","No, porque no se puede inicializar un atributo estático dentro de un constructor.","Sí, porque inicializa el array de intervalos cada vez que se crea una instancia de la clase PreguntaStatic."],
    correcta: 0,
    explicacion: "Al ejecutar el bloque static, intervalos sigue siendo null al asignar intervalos[0] (el constructor aún no ha corrido)."
  },
  {
    numero: 6,
    enunciado: "Cuando se tiene una referencia polimórfica",
    opciones: ["Se pueden invocar métodos heredados de la clase padre y añadidos en la clase hija.","Se pueden invocar métodos heredados de la clase padre y sólo se podrán invocar los métodos añadidos en la clase hija si se hace un casting.","Se pueden invocar métodos heredados de la clase padre y sólo algunos de los añadidos en la clase hija.","Ninguna de las respuestas es correcta."],
    correcta: 1,
    explicacion: "Con referencia de tipo padre, los métodos solo de la hija requieren casting explícito."
  },
  {
    numero: 7,
    enunciado: "En Java, ¿Cuál es la salida del siguiente código?\nfor (int i=0;i<4;i++)\nSystem.out.print(\"Hola \");",
    opciones: ["Hola","Hola Hola","Hola Hola Hola","Hola Hola Hola Hola"],
    correcta: 3,
    explicacion: "El PDF original muestra el bucle en imagen; un for de 0 a 3 imprime cuatro veces \"Hola \"."
  },
  {
    numero: 8,
    enunciado: "¿Cuál es la salida del siguiente código?\ntry {\nFloat f1 = new Float(\"3.0\");\nint x = f1.intValue();\nbyte b = f1.byteValue();\ndouble d = f1.doubleValue();\nSystem.out.println(x + b + d);\n}\ncatch (NumberFormatException e){\nSystem.out.println(\"bad number\");\n}",
    opciones: ["9.0","bad number","La compilación falla en la línea 8.","La compilación falla en la línea 9."],
    correcta: 0,
    explicacion: "x=3, b=3, d=3.0; la suma numérica promociona a double → 9.0."
  },
  {
    numero: 9,
    enunciado: "¿Cuál es la salida del siguiente código?\npublic enum Mes{\nENERO(1), ..., DICIEMBRE(12);\nprivate final int numero;\nMes(int numero){ this.numero=numero; }\npublic static void main(String[] args){\nMes mes1=Mes.MAYO;\nSystem.out.println(mes1);\n}\n}",
    opciones: ["MAYO(5)","(5)MAYO","MAYO","Ninguna de las respuestas es correcta"],
    correcta: 2,
    explicacion: "println de un enum muestra el nombre literal del constante."
  },
  {
    numero: 10,
    enunciado: "¿Cuál de las siguientes afirmaciones es correcta?",
    opciones: ["Al ejecutar javadoc se generan ficheros en formato XML para la documentación","Al ejecutar javadoc se genera un único fichero HTML con la documentación","Al ejecutar javadoc se generan ficheros en formato HTML para la documentación, al menos se genera uno por cada archivo .java, entre otras cosas","Todas las respuestas son correctas"],
    correcta: 2,
    explicacion: "Javadoc genera HTML (varios ficheros según la estructura del proyecto)."
  },
  {
    numero: 11,
    enunciado: "¿Cuál es la salida del siguiente código?\nclass xyz {\npublic static void main (String[] args){\nint i, j, k;\nfor (i=0; i<3; i++){\nfor (j=1; j<4; j++) {\nfor (k=2; k<5; k++){\nif ( (i==j) && (j==k) )\nSystem.out.println(i);\n}}}}}",
    opciones: ["1","2","3","4"],
    correcta: 1,
    explicacion: "Solo cuando i=j=k=2 se cumple la condición; se imprime 2."
  },
  {
    numero: 12,
    enunciado: "¿Cuál es la salida del siguiente código?\nclass test {\nstatic boolean check;\npublic static void main(String args[]) {\nint i;\nif(check == true)\ni=1;\nelse\ni=2;\nif(i=2) i=i+2;\nelse i = i + 4;\nSystem.out.println(i);\n}\n}",
    opciones: ["4","5","0","El programa no compila"],
    correcta: 3,
    explicacion: "if(i=2) usa asignación en lugar de comparación; no compila en Java."
  },
  {
    numero: 13,
    enunciado: "¿En cuál de los siguientes tipos de ResultSet, el cursor puede avanzar sólo hacia delante en el conjunto de resultados?",
    opciones: ["ResultSet.TYPE_FORWARD_ONLY","ResultSet.TYPE_SCROLL_INSENSITIVE","ResultSet.TYPE_SCROLL_SENSITIVE","Ninguna de las anteriores."],
    correcta: 0,
    explicacion: "TYPE_FORWARD_ONLY es el cursor solo hacia adelante por defecto."
  },
  {
    numero: 14,
    enunciado: "¿Cuál es la salida del siguiente código?\nclass MiClase { public int valor; }\nclass Test {\npublic static void main(String[] args){\nMiClase a1 = new MiClase ();\nMiClase a2 = new MiClase ();\nMiClase a3 = new MiClase ();\na1.valor=150;\na2.valor=150;\na3 = a2;\nif (a1 == a2) { System.out.println(\" UNO\");}\nif (a1 == a3) { System.out.println(\" DOS\");}\nif (a2 == a3) { System.out.println(\" TRES\");}\n}\n}",
    opciones: ["TRES","UNO TRES","UNO","UNO DOS TRES"],
    correcta: 0,
    explicacion: "Solo a2 y a3 comparten referencia; se imprime TRES."
  },
  {
    numero: 15,
    enunciado: "¿Cuál es la salida al siguiente programa? (Padre con constructores; Hija sin constructor explícito)\nFICHERO Hija.java — new Hija(); System.out.println(h);",
    opciones: ["Da un error en tiempo de compilación porque la clase hija no tiene constructor","La salida es \"Soy la clase hija con valor 0\"","Da un error en tiempo de ejecución porque la clase hija no tiene constructor","Ninguna de las respuestas es correcta."],
    correcta: 1,
    explicacion: "Se añade constructor por defecto que llama a super(); toString muestra h=0."
  },
  {
    numero: 16,
    enunciado: "Dado el siguiente fragmento de código, indica cuál de las siguientes afirmaciones es correcta en relación al valor de la variable foo.\nint index = 1;\nboolean[] test = new boolean[3];\nboolean foo = test [index];",
    opciones: ["foo tiene el valor 0","foo tiene el valor null","foo tiene el valor false","Se produce una excepción y foo no posee ningún valor"],
    correcta: 2,
    explicacion: "Los boolean del array se inicializan a false."
  },
  {
    numero: 17,
    enunciado: "¿Qué ocurrirá al compilar y ejecutar el siguiente código?\npublic class MiClase{\nstatic int variableEstatica;\npublic static void main(String argv[]){\nSystem.out.println(variableEstatica);\n}\n}",
    opciones: ["Error en tiempo de ejecución. La variable \"variableEstatica\" no ha sido inicializada","Se mostrará en pantalla null","Se mostrará en pantalla 1","Se mostrará en pantalla 0"],
    correcta: 3,
    explicacion: "Los enteros estáticos de clase se inicializan a 0."
  },
  {
    numero: 18,
    enunciado: "Dado el siguiente código, ¿Cuál de las siguientes afirmaciones es correcta?\nSet<Object> objetos = new HashSet<Object>();\nString obj1 = \"JAVA\";\nint obj2 = 5;\nBoolean obj3 = new Boolean(true);\nobjetos.add(obj3);\nobjetos.add(obj1);\nobjetos.add(obj2);\nobjetos.add(obj3);\nfor(Object object : objetos)\nSystem.out.print(object);",
    opciones: ["Error en tiempo de ejecución.","Se muestran por pantalla JAVA 5 y true en el orden exacto en el que fueron insertadas en la colección.","Se muestran por pantalla JAVA 5 y true en un orden no determinado.","Se muestran por pantalla JAVA 5 y true en un orden no determinado y, además, \"true\" se muestra dos veces."],
    correcta: 2,
    explicacion: "HashSet no permite duplicados; el orden de iteración no está garantizado."
  },
  {
    numero: 19,
    enunciado: "Indique cuál de las siguientes afirmaciones es falsa:",
    opciones: ["El objetivo de la sobrecarga de métodos es facilitar la invocación de un mismo método pasándole un conjunto de parámetros de entrada diferentes.","Se puede sobrecargar un método variando el tipo de retorno de éste sin variar los parámetros de entrada.","Un método puede ser sobrecargado en la misma clase o en una subclase.","Los métodos sobrecargados pueden cambiar el modificador de acceso del método original."],
    correcta: 1,
    explicacion: "No basta con cambiar el tipo de retorno; debe cambiar la firma (parámetros)."
  },
  {
    numero: 20,
    enunciado: "En Java, ¿Cuál es la salida del siguiente código?\nint[] a = new int[0];\nSystem.out.println(a[0]);",
    opciones: ["ArrayIndexOutOfBoundsException","UntrustableBoundsException","1","Ninguna de las anteriores"],
    correcta: 0,
    explicacion: "Índice 0 en array de longitud 0 provoca ArrayIndexOutOfBoundsException."
  },
  {
    numero: 21,
    enunciado: "¿Cuál es la salida del siguiente programa?\npublic class incr {\npublic static void main(String args[]) {\nint i , j;\ni = j = 3;\nint n = 2 * ++i;\nint m = 2 * j++;\nSystem.out.println(i + \" \" + j + \" \" + n + \" \" + m);\n}\n}",
    opciones: ["4 4 8 6","4 4 8 8","4 4 6 6","4 3 8 6"],
    correcta: 0,
    explicacion: "++i deja i=4, n=8; j++ usa 3 en m y luego j=4, m=6."
  },
  {
    numero: 22,
    enunciado: "¿Qué clase abstracta es la superclase de todas las clases usadas para leer bytes?",
    opciones: ["FileReader","ByteReader","InputStream","FileInputStream"],
    correcta: 2,
    explicacion: "InputStream es la clase base abstracta para lectura de bytes."
  },
  {
    numero: 23,
    enunciado: "Indicar la respuesta correcta. Un conjunto es una estructura,",
    opciones: ["Que almacena cada elemento individual una sola vez como mínimo. No mantiene un orden específico.","Que almacena cada elemento individual una sola vez como mínimo. Mantiene un orden específico.","Que almacena cada elemento individual una sola vez como máximo. No mantiene un orden específico.","Que almacena cada elemento individual una sola vez como máximo. Mantiene un orden específico."],
    correcta: 2,
    explicacion: "Un Set no admite duplicados (como máximo una copia) y normalmente sin orden garantizado."
  },
  {
    numero: 24,
    enunciado: "¿Qué clase permite la lectura de datos primitivos de un fichero binario?",
    opciones: ["DataInputStream","DataOutputStream","ObjectInputStream","BufferedWriter"],
    correcta: 0,
    explicacion: "DataInputStream lee tipos primitivos en binario."
  },
  {
    numero: 25,
    enunciado: "Nombre de la excepción lanzada por el método de lectura definido en la clase InputStream",
    opciones: ["IOException","ClassNotFoundException","EOFException","Las 3 respuestas son correctas."],
    correcta: 0,
    explicacion: "read() declara IOException (EOF se modela con -1, no siempre como EOFException en read())."
  },
  {
    numero: 26,
    enunciado: "Sea la siguiente definición de clase y subclase, ¿Cuál de las siguientes afirmaciones es cierta al ejecutar el código?\npublic class ClaseB extends ClaseA {\npublic ClaseB(String s) {\nSystem.out.print(\"Construyendo Clase B.\");\nsuper(s);\n}\n}",
    opciones: ["Se produce un error en tiempo de ejecución.","Se muestra el mensaje \"Construyendo Clase B. Construyendo Clase A.\".","Se muestra el mensaje \"Construyendo Clase A. Construyendo Clase B.\".","Error de compilación."],
    correcta: 3,
    explicacion: "super(s) debe ser la primera instrucción del constructor; aquí hay error de compilación."
  },
  {
    numero: 27,
    enunciado: "Se tiene creado el fichero serializable \"fichero.obj\" y se quiere añadir más información a dicho fichero. ¿Qué sentencia se pondría?",
    opciones: ["new ObjectOutputStream (\"fichero.obj\",append);","new ObjectOutputStream (\"fichero.obj\",true);","new FileOutputStream (\"fichero.obj\",true);","Ninguna es correcta"],
    correcta: 2,
    explicacion: "Para abrir en modo append se usa FileOutputStream(fichero, true) y encadenar el stream adecuado."
  },
  {
    numero: 28,
    enunciado: "¿Cuál es la salida de esta línea System.out.println(Math.sqrt(-4D));?",
    opciones: ["-2","NaN","Error de compilación","Error en tiempo de ejecución"],
    correcta: 1,
    explicacion: "sqrt de negativo en double devuelve NaN."
  },
  {
    numero: 29,
    enunciado: "En Oracle ¿cuál de las opciones siguientes para definir un objeto denominado Personal es correcta?",
    opciones: ["CREATE OR REPLACE TYPE Personal AS OBJECT(codigo VARCHAR2(3));","CREATE OR REPLACE OBJECT Personal AS OBJECT(codigo VARCHAR2(3));","CREATE OR REPLACE ENTITY OBJECT Personal AS OBJECT(codigo VARCHAR2(3));","CREATE OR REPLACE CLASS Personal AS OBJECT(codigo VARCHAR2(3));"],
    correcta: 0,
    explicacion: "Sintaxis Oracle: TYPE ... AS OBJECT."
  },
  {
    numero: 30,
    enunciado: "¿Cuál es el resultado de la sentencia System.out.println(100>>4);?",
    opciones: ["true","false","6","25"],
    correcta: 2,
    explicacion: "100 >> 4 equivale a división entera entre 16 → 6."
  },
  {
    numero: 31,
    enunciado: "¿Qué se producirá si intenta compilar y ejecutar el código siguiente, pero no hay ningún archivo llamado Hello.txt en el directorio actual?\n(método amethod con try/catch FileNotFoundException, finally y return -1)",
    opciones: ["No such file found","No such file found ,-1","No such file found, Doing finally, -1","0"],
    correcta: 2,
    explicacion: "Se entra en catch, imprime mensaje, ejecuta finally y luego retorna -1 desde el catch."
  },
  {
    numero: 32,
    enunciado: "Dada el siguiente código, indicar la salida:\npublic int xyz(int num) {\nif(num == 1) return 1;\nelse return(xyz(num-1) + num);\n}\nSystem.out.println(test1.xyz(100));",
    opciones: ["Un error en tiempo de ejecución","Se mostrará 100","Se mostrará 1","Se mostrará 5050"],
    correcta: 3,
    explicacion: "Suma recursiva 1+2+...+100 = 5050."
  },
  {
    numero: 33,
    enunciado: "Dado el siguiente fragmento (metodo con NPE y catch; main con try/catch). Nota: el orden catch(Exception) antes de catch(NullPointerException) en main es inválido en Java.\n¿Cuál afirmación encaja con el planteamiento del examen?",
    opciones: ["3-5-FIN","3-4-5-FIN","3-FIN","5-FIN"],
    correcta: 2,
    explicacion: "Si el código compilara tras corregir el orden de catch, metodo captura la NPE con Exception e imprime 3- y luego FIN. Ojo: tal como está en el PDF, main no compila."
  },
  {
    numero: 34,
    enunciado: "¿Qué es JDBC?",
    opciones: ["JDBC es un protocolo basado en java","JDBC es una API Java estándar para la conectividad independiente de la base de datos","JDBC es una especificación para indicar cómo conectarse a una base de datos.","Controlador común para conexión básica"],
    correcta: 1,
    explicacion: "JDBC es la API estándar de conectividad con bases de datos."
  },
  {
    numero: 35,
    enunciado: "Indicar cuál es la salida por consola cuando se ejecuta el siguiente programa:\ncall_array(arr[0], arr) con arr = {1,2,3,4}; arr[i]=6 dentro del método.",
    opciones: ["1, 2","5, 2","1, 6","5, 6"],
    correcta: 2,
    explicacion: "i vale 1; se modifica arr[1] a 6; arr[0] sigue siendo 1."
  },
  {
    numero: 36,
    enunciado: "Persona p = new Persona(28); ... p = new Alumno(15); p.pasarCurso();",
    opciones: ["Se muestra en la consola 28-15.","No compilará por la línea p.pasarCurso();","Se muestra en la consola 28-29.","Se muestra en la consola 28-28."],
    correcta: 1,
    explicacion: "p es referencia Persona; pasarCurso() no existe en Persona → error de compilación."
  },
  {
    numero: 37,
    enunciado: "En Java, dada la clase Alumno definida en el siguiente código ¿Cómo se puede instanciar un objeto de la clase Alumno?",
    opciones: ["Alumno a = newobject Alumno(Maria, 9);","Alumno a = new Alumno( \"Maria\" , 7 );","Alumno a = new Alumno( 'Luis' , 6.5 );","Ninguna de las anteriores"],
    correcta: 1,
    explicacion: "Sintaxis correcta: new Alumno(\"Maria\", 7) si el constructor acepta (String,int)."
  },
  {
    numero: 38,
    enunciado: "TestExcepciones con getNumeroPositivo() y varios objetos en un único try (E1=1, E2=-2, ...).\n¿Cuál será la salida del programa por consola?",
    opciones: ["1-270","1-2Terminó con error","1Terminó con error","1-270Terminó con error"],
    correcta: 2,
    explicacion: "Tras imprimir 1, la llamada con número negativo lanza la excepción y se imprime el mensaje del catch."
  },
  {
    numero: 39,
    enunciado: "Indicar cuál de las siguientes afirmaciones es correcta",
    opciones: ["Un atributo friendly es visible desde la misma clase y también desde el paquete al que pertenece.","Si no se define el modificador de acceso, el modificador de un método es protected.","Un atributo o método private solo es visible dentro de un paquete.","No se puede acceder a un atributo public desde una subclase."],
    correcta: 0,
    explicacion: "Sin modificador (package-private) es visible en el mismo paquete."
  },
  {
    numero: 40,
    enunciado: "TestUFO con Disparo dn = new DisparoNave(); inicio(dn); d.disparar();\nIndicar cuál de las siguientes afirmaciones es correcta",
    opciones: ["El método disparar está sobrecargado.","No se muestra por pantalla ningún mensaje.","Muestra por pantalla el mensaje \"Dispara la nave\".","Obtenemos un error en tiempo de ejecución."],
    correcta: 2,
    explicacion: "Polimorfismo: se ejecuta disparar() de DisparoNave."
  }
];
