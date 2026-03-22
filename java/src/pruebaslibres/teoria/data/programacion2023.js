// Pruebas libres 2023 — programacion2023
// Fuente: src/pruebaslibres/Pruebas_libres_2023.pdf

window.bancoExamenes = window.bancoExamenes || {};

window.bancoExamenes.programacion2023 = [
  {
    numero: 1,
    enunciado: "¿Qué se imprime cuando se compila y ejecuta el siguiente programa? Seleccione la respuesta correcta.\nclass test {\npublic static void main (String[] args) {\nint i=0;\ndo{\ni++;\n}while (i<0);\nSystem.out.println(i);\n}\n}",
    opciones: ["El programa no se compila porque i no está inicializado.","El programa se compila y se ejecuta, pero no imprime nada.","El programa imprime 0.","El programa imprime 1."],
    correcta: 3,
    explicacion: "i se inicializa a 0; tras i++ vale 1; la condición del while es falsa; se imprime 1."
  },
  {
    numero: 2,
    enunciado: "Si en Java la clase B hereda de la clase A y ejecutamos el siguiente código\n¿cuál será la salida que se imprima?\n\nObject o1 = new A();\nObject o2 = new B();\nSystem.out.print(o1 instanceof A);\nSystem.out.print(\" \");\nSystem.out.print(o1 instanceof B);\nSystem.out.print(\" \");\nSystem.out.print(o2 instanceof A);\nSystem.out.print(\" \");\nSystem.out.print(o2 instanceof B);",
    opciones: ["true false false true","true true false true","true false true true","false false true false"],
    correcta: 2,
    explicacion: "Mismo razonamiento que 2022: la salida es true false true true → opción c en este orden."
  },
  {
    numero: 3,
    enunciado: "¿Cuáles de las siguientes son palabras clave de Java?",
    opciones: ["void, implement","unsigned, float","integer, synchronize","static, float"],
    correcta: 3,
    explicacion: "static y float son palabras reservadas."
  },
  {
    numero: 4,
    enunciado: "¿Cuál es la salida del siguiente programa?\npublic class Ejemplo{\nprivate int j=10;}\nclass Main {\npublic static void main(String[] args) {\nEjemplo x= new Ejemplo();\nSystem.out.println (x.j);\n}\n}",
    opciones: ["Da un error de compilación debido a las restricciones de acceso a las variables privadas de Ejemplo.","Da un error de compilación debido a la creación del objeto x.","No da ningún error de compilación y produce como salida el valor 10.","No da ningún error de compilación y produce como salida el valor 0."],
    correcta: 0,
    explicacion: "j es privado; Main no puede acceder a x.j desde fuera de Ejemplo."
  },
  {
    numero: 5,
    enunciado: "Dado el siguiente código, ¿es correcto o presenta errores en tiempo de compilación o ejecución?\npublic class PreguntaStatic {\nprivate static final int MAX_INTERVALOS = 14;\nprivate static Intervalo [] intervalos = null;\npublic PreguntaStatic() {\nPreguntaStatic.intervalos = new Intervalo[PreguntaStatic.MAX_INTERVALOS];\n}\nstatic {\nIntervalo first = new Intervalo(2,4);\nPreguntaStatic.intervalos[0] = first;\n...\n}\n}",
    opciones: ["Sí, porque inicializa el array de intervalos cada vez que se crea una instancia de la clase PreguntaStatic.","Sí, el array de intervalos al ser un atributo estático se inicializa correctamente en el bloque static.","No, porque no se puede inicializar un atributo estático dentro de un constructor.","No, porque daría una excepción java.lang.NullPointerException cuando se intenta acceder a una posición del array en el bloque de código static."],
    correcta: 3,
    explicacion: "Mismo fallo NPE al usar intervalos null en el bloque static (orden de opciones distinto al de 2022)."
  },
  {
    numero: 6,
    enunciado: "Cuando se tiene una referencia polimórfica",
    opciones: ["Se pueden invocar métodos heredados de la clase padre y añadidos en la clase hija.","Se pueden invocar métodos heredados de la clase padre y sólo se podrán invocar los métodos añadidos en la clase hija si se hace un casting.","Se pueden invocar métodos heredados de la clase padre y sólo algunos de los añadidos en la clase hija.","Ninguna de las respuestas es correcta."],
    correcta: 1,
    explicacion: "Con referencia de tipo padre solo ves la API del padre; los métodos exclusivos de la hija requieren casting explícito (opción b)."
  },
  {
    numero: 7,
    enunciado: "En Java, ¿Cuál es la salida del siguiente código?\nfloat[] vector = new float[4];\nfor (int i=0;i<vector.length;i=i+2)\nSystem.out.println(\"Hola \");",
    opciones: ["Hola","Hola Hola","Hola Hola Hola","Hola Hola Hola Hola"],
    correcta: 1,
    explicacion: "i toma 0 y 2: dos iteraciones, dos líneas \"Hola \"."
  },
  {
    numero: 8,
    enunciado: "¿Cuál es la salida del siguiente código?\ntry {\nFloat f1 = new Float(3.0);\nint x = f1.intValue();\nSystem.out.println(x % 2);\n}\ncatch (NumberFormatException e){\nSystem.out.println(\"bad number\");\n}",
    opciones: ["1","1,5","bad number","Hay errores sintácticos en el código."],
    correcta: 0,
    explicacion: "3 % 2 = 1; no hay NumberFormatException."
  },
  {
    numero: 9,
    enunciado: "¿Cuál es la salida del siguiente código?\npublic enum Demarcacion\n{PORTERO, DEFENSA, CENTROCAMPISTA, DELANTERO}\npublic static void main(String[] args){\nDemarcacion delantero = Demarcacion.DELANTERO;\nDemarcacion defensa = Demarcacion.DEFENSA;\nSystem.out.println(delantero.compareTo(defensa));\n}",
    opciones: ["0","1","2","3"],
    correcta: 2,
    explicacion: "compareTo por ordinal: DELANTERO (3) vs DEFENSA (1) → 2."
  },
  {
    numero: 10,
    enunciado: "¿Cuál de las siguientes afirmaciones es correcta?",
    opciones: ["Al ejecutar javadoc se generan ficheros en formato XML para la documentación","Al ejecutar javadoc se genera un único fichero HTML con la documentación","Al ejecutar javadoc se generan ficheros en formato DOCX para la documentación, al menos se genera uno por cada archivo .java, entre otras cosas","Ninguna de las anteriores"],
    correcta: 3,
    explicacion: "Ninguna describe bien Javadoc (genera HTML, no DOCX/XML como única opción válida tal cual)."
  },
  {
    numero: 11,
    enunciado: "¿Cuál es la salida del siguiente código?\nclass xyz {\npublic static void main (String[] args){\nint i, j, k;\nfor (i=0; i<3; i++){\nfor (j=1; j<4; j++) {\nfor (k=2; k<5; k++){\nif ( (i==j) && (j==k) )\nSystem.out.println(i);\n}}}}}",
    opciones: ["1","2","3","4"],
    correcta: 1,
    explicacion: "Solo cuando i=2, j=2 y k=2 se cumple (i==j)&&(j==k); se imprime 2."
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
    enunciado: "¿Cuál es la salida al siguiente programa?\nint index = 2;\nboolean[] test = new boolean[3];\nfor (int i=0;i<test.length;i=i+3)\ntest[i]=true;\nboolean foo = test [index];\nSystem.out.println(foo);",
    opciones: ["true","false","null","Se produce una excepción y no se termina de ejecutar el programa correctamente"],
    correcta: 1,
    explicacion: "Solo test[0] se pone true; test[2] sigue false."
  },
  {
    numero: 17,
    enunciado: "¿Qué ocurrirá al compilar y ejecutar el siguiente código?\npublic class MiClase{\nstatic int variableEstatica=2;\npublic static void main(String argv[]){\nSystem.out.println(++variableEstatica);\n}\n}",
    opciones: ["Se mostrará en pantalla 0","Se mostrará en pantalla 2","Se mostrará en pantalla 3","Hay errores de sintácticos que hace que el código no compile."],
    correcta: 2,
    explicacion: "++variableEstatica incrementa 2 a 3 antes de imprimir."
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
    enunciado: "Indique cuál de las siguientes afirmaciones es verdadera:",
    opciones: ["El objetivo de la sobrecarga de métodos es facilitar la invocación de un mismo método pasándole un conjunto de parámetros de entrada diferentes.","Se puede sobrecargar un método variando el tipo de retorno de éste y el identificador del método","Se puede sobrecargar un método variando el tipo de retorno de éste sin variar los parámetros de entrada.","Los métodos en Java no pueden ser sobrecargados."],
    correcta: 0,
    explicacion: "La sobrecarga permite mismo nombre con distintos parámetros."
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
    enunciado: "¿Cuál es la salida del siguiente programa?\npublic class incr {\npublic static void main(String args[]) {\nint i , j;\ni = j = 3 % 1;\nint n = 7 * ++i;\nSystem.out.println(i + \" \" + j + \" \" + n);\n}\n}",
    opciones: ["1 0 7","0 0 7","1 0 14","0 0 14"],
    correcta: 0,
    explicacion: "3%1=0; i y j quedan en 0; ++i deja i=1; n=7*1=7 → imprime 1 0 7."
  },
  {
    numero: 22,
    enunciado: "¿Qué clase abstracta es la superclase de todas las clases usadas para leer bytes?",
    opciones: ["FileReader","InputStream","InputStreamReader","FileInputStream"],
    correcta: 1,
    explicacion: "Superclase abstracta para leer bytes: InputStream."
  },
  {
    numero: 23,
    enunciado: "Indicar la respuesta correcta. Un conjunto es una estructura,",
    opciones: ["Que almacena cada elemento individual una sola vez como máximo. No mantiene un orden específico.","Que almacena cada elemento individual una sola vez como mínimo. No mantiene un orden específico.","Que almacena cada elemento individual una sola vez como máximo. Mantiene un orden específico.","Que almacena cada elemento individual una sola vez como mínimo. Mantiene un orden específico."],
    correcta: 0,
    explicacion: "Set: sin duplicados (como máximo una vez), sin orden garantizado."
  },
  {
    numero: 24,
    enunciado: "¿Qué clase permite la lectura de datos primitivos de un fichero binario?",
    opciones: ["ClassInputStream","ImplementInputStream","ObjectInputStream","Ninguna de las anteriores"],
    correcta: 3,
    explicacion: "Para primitivos en binario se usa DataInputStream; no está en la lista → ninguna de las anteriores."
  },
  {
    numero: 25,
    enunciado: "Nombre de la excepción lanzada por el método de lectura definido en la clase InputStream",
    opciones: ["ClassNotFoundException","EOFException","IOException","Ninguna de las anteriores"],
    correcta: 2,
    explicacion: "InputStream.read() declara IOException."
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
    enunciado: "¿Cuál es la salida de esta línea System.out.println(Math.sqrt(4));?",
    opciones: ["2.0","16.0","NaN","Error de compilación"],
    correcta: 0,
    explicacion: "sqrt(4) es 2.0."
  },
  {
    numero: 29,
    enunciado: "¿Cuál de las siguientes opciones gestiona una lista de controladores de bases de datos en JDBC que permite manejar objetos de la base de datos?",
    opciones: ["JDBC driver.","ClassDriverManager.","DriverManager.","StreamOuputDriverManager."],
    correcta: 2,
    explicacion: "DriverManager registra y obtiene drivers JDBC."
  },
  {
    numero: 30,
    enunciado: "¿Cuál es el resultado de la sentencia System.out.println(\"Solución: \" + \"(3+4)\");?",
    opciones: ["Solución: (3+4)","Solución: (7)","Solución: 7","Error de compilación"],
    correcta: 0,
    explicacion: "Es concatenación de cadenas; no se evalúa la suma."
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
    enunciado: "Dada el siguiente código, indicar la salida:\npublic int xyz(int num) {\nif(num == 1) return 1;\nelse return(xyz(num-1));\n}\nSystem.out.println(test1.xyz(100));",
    opciones: ["Se mostrará 4","Se mostrará 100","Se mostrará 1","Se mostrará 5050"],
    correcta: 2,
    explicacion: "La recursión devuelve siempre 1 (no suma n)."
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
    opciones: ["Controlador común para conexión básica","JDBC es un protocolo basado en java","JDBC es una especificación para indicar cómo conectarse a una base de datos.","JDBC es una API Java estándar para la conectividad independiente de la base de datos"],
    correcta: 3,
    explicacion: "Definición estándar: API de conectividad con BD."
  },
  {
    numero: 35,
    enunciado: "Indicar cuál es la salida por consola cuando se ejecuta el siguiente programa:\nclass Main {\npublic static void main(String args[]) {\nint[] arr = {1,2,3};\ncall_array(arr);\nSystem.out.println(arr[0]);\n}\nstatic void call_array(int arr[]) {\narr[0] = 5;\n}\n}",
    opciones: ["1","5","Null","d) Error de compilación"],
    correcta: 1,
    explicacion: "El array se pasa por referencia; arr[0] pasa a 5."
  },
  {
    numero: 36,
    enunciado: "Persona p = new Persona(28);\nSystem.out.print(p.darEdad()+\" - \");\np = new Alumno(15);\np.pasarCurso();\nSystem.out.print(p.darEdad());",
    opciones: ["Se muestra en la consola 15-28.","Se muestra en la consola 28-29.","Se muestra en la consola 29-28.","No compilará por la línea p.pasarCurso();"],
    correcta: 3,
    explicacion: "Mismo problema: pasarCurso no está en Persona."
  },
  {
    numero: 37,
    enunciado: "En Java, dada la clase Alumno definida en el siguiente código ¿Cómo se puede instanciar un objeto de la clase Alumno?",
    opciones: ["Alumno a = new Alumno( 'María' , 2.5 );","Alumno a = newobject Alumno(Maria, 2);","Alumno a = new Alumno( \"Luis\" , 2 );","Alumno a = new Alumno( 'María', '2.5' );"],
    correcta: 2,
    explicacion: "new Alumno(\"Luis\", 2) con (String, int)."
  },
  {
    numero: 38,
    enunciado: "TestExcepciones con getNumeroPositivo() y varios objetos en un único try (E1=1, E2=-2, ...).\n¿Cuál será la salida del programa por consola?",
    opciones: ["1Terminó con error","2Terminó con error","1-2Terminó con error","2-1Terminó con error"],
    correcta: 0,
    explicacion: "Tras 1, la siguiente llamada con número negativo lanza y se imprime Terminó con error."
  },
  {
    numero: 39,
    enunciado: "Indicar cuál de las siguientes afirmaciones es correcta",
    opciones: ["Un atributo o método private solo es visible dentro de un paquete.","Si no se define el modificador de acceso, el modificador de un método es protected.","No se puede acceder a un atributo public desde una subclase.","Ninguna de las anteriores"],
    correcta: 3,
    explicacion: "Las tres primeras son falsas; la correcta es ninguna de las anteriores."
  },
  {
    numero: 40,
    enunciado: "TestUFO con Disparo dn = new DisparoNave(); inicio(dn); d.disparar();\nIndicar cuál de las siguientes afirmaciones es correcta",
    opciones: ["Muestra por pantalla el mensaje \"Dispara la nave\".","Muestra por pantalla el mensaje \"null\".","No se muestra por pantalla ningún mensaje.","Hay errores de compilación."],
    correcta: 0,
    explicacion: "Igual que 2022: polimorfismo y mensaje en consola."
  }
];
