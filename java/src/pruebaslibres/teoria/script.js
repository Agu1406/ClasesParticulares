// Banco de preguntas teóricas del examen de Programación (Pruebas libres 2021).
// Cada objeto representa una de las 40 preguntas tipo test.

const bancoExamenes = {
  programacion2021: [
  {
    numero: 1,
    enunciado:
      "¿Qué hace el siguiente programa?\nint x = 0;\nint y = 0;\nwhile (x < 10) {\n  y += x;\n  x++;\n}\nSystem.out.println(y);",
    opciones: [
      "Sumar uno a uno los valores de x hasta llegar a 10.",
      "Suma y acaba obteniendo un 11 en la variable y.",
      "Calcular la suma de los números 0 al 9.",
      "Ninguna de las tres respuestas es correcta."
    ],
    correcta: 2,
    explicacion:
      "Dentro del while se va sumando a y el valor de x desde 0 hasta 9. El resultado es la suma 0+1+...+9 = 45."
  },
  {
    numero: 2,
    enunciado: "¿Cuál es el resultado de la operación?\nSystem.out.println(2|1);",
    opciones: ["true", "false", "3", "2"],
    correcta: 2,
    explicacion:
      "El operador | es OR a nivel de bits. 2 es 10 en binario y 1 es 01, 10 | 01 = 11 que es 3 en decimal."
  },
  {
    numero: 3,
    enunciado:
      "¿Cuál es el valor que se muestra por pantalla?\nint x = 1;\nif (x==1)\n  System.out.println(\"Es uno\");\nelse;\n  System.out.println(\"No es uno\");",
    opciones: [
      "\"Es uno\"",
      "\"No es uno\"",
      "\"Es uno\" y \"No es uno\"",
      "Ninguna de las tres opciones"
    ],
    correcta: 2,
    explicacion:
      "Por el ; después del else, ese else no afecta a la siguiente línea. El if imprime \"Es uno\" y después siempre se ejecuta \"No es uno\"."
  },
  {
    numero: 4,
    enunciado:
      "¿Qué hace el siguiente código fuente?\nint suma = 0;\nfor (int x=1;x=100;x++) {\n  if (x%2!=0) suma+=x;\n}",
    opciones: [
      "Suma los 100 primeros números",
      "Suma los 100 primeros números impares",
      "Suma los 100 primeros números pares",
      "Ninguna de las anteriores respuestas es válida"
    ],
    correcta: 3,
    explicacion:
      "La condición del for es x=100 (asignación), no una expresión booleana; en Java eso no compila. Por tanto, ninguna de las descripciones de suma es correcta."
  },
  {
    numero: 5,
    enunciado:
      "¿Qué resultado da la siguiente operación?\nSystem.out.println(17>>2);",
    opciones: ["19", "15", "true", "4"],
    correcta: 3,
    explicacion:
      "Desplazar a la derecha 2 bits equivale a dividir entre 4 (entero). 17 / 4 = 4 con resto, así que el resultado es 4."
  },
  {
    numero: 6,
    enunciado:
      "¿Cuál es el valor que se muestra por pantalla?\nint x = 5;\nint y = 5;\ny /= ++x;\nSystem.out.println(y);",
    opciones: ["6", "5", "1", "0"],
    correcta: 3,
    explicacion:
      "++x incrementa x de 5 a 6 antes de usarlo. Luego se ejecuta y/=6, es decir, 5/6 en división entera, que da 0. Por tanto se imprime 0."
  },
  {
    numero: 7,
    enunciado:
      "¿Qué hace el siguiente código fuente?\nint suma = 0;\nint y = 1;\nint x = 0;\nwhile (x<100) {\n  if (y%2!=0) {\n    suma+=y;\n    x++;\n  }\n  y++;\n}",
    opciones: [
      "Suma los 100 primeros números impares",
      "Suma del 1 al 100 los números que sean impares",
      "Suma los 100 primeros números pares",
      "Ninguna de las anteriores respuestas es válida"
    ],
    correcta: 0,
    explicacion:
      "El bucle cuenta 100 números impares en y (1,3,5...) y los suma; exactamente los 100 primeros impares."
  },
  {
    numero: 8,
    enunciado:
      "¿Cuál es el resultado del siguiente programa?\nint j=2;\nint k=3;\nint m=2;\nSystem.out.println ((k+m < j) | (3-j >= k));",
    opciones: ["true", "false", "undefined", "Da error de compilación"],
    correcta: 1,
    explicacion:
      "k+m es 5, 5<2 es falso; 3-j es 1, 1>=3 también es falso. Falso OR falso da false."
  },
  {
    numero: 9,
    enunciado:
      "Indique qué resultado se obtendrá de ejecutar el siguiente código:\n\npackage test;\npublic class test {\n  public static void main (String args[]) {\n    Integer i = new Integer (0);\n    annadirCinco (i);\n    System.out.println (i.intValue ( ) );\n  }\n  public static void annadirCinco (Integer i) {\n    int val = i.intValue();\n    val += 5;\n    i = new Integer (val);\n  }\n}",
    opciones: ["5", "0", "05", "Se produce una excepción"],
    correcta: 1,
    explicacion:
      "Integer es inmutable y en el método se crea un objeto nuevo pero no se devuelve. La i original sigue valiendo 0."
  },
  {
    numero: 10,
    enunciado:
      "Dado el siguiente código, ¿qué se imprime por pantalla?\nint total = 10;\nint contador = 4;\ntotal -= ++contador;\nSystem.out.println(total);",
    opciones: ["7", "5", "4", "6"],
    correcta: 1,
    explicacion:
      "++contador pasa contador de 4 a 5 y se resta a total: 10-5 = 5."
  },
  {
    numero: 11,
    enunciado:
      "¿Cuál es el resultado de ejecutar este código?\nint i=0;\nif (i) {\n  System.out.println (\"Hola\");\n}",
    opciones: [
      "No imprime nada.",
      "Imprime \"Hola\".",
      "Da error de compilación.",
      "Se produce una excepción ArithmeticException."
    ],
    correcta: 2,
    explicacion:
      "En Java no se puede usar un int como condición de if directamente; debe ser boolean. Por eso no compila."
  },
  {
    numero: 12,
    enunciado:
      "¿Cuál es el resultado de ejecutar este programa?:\n\npackage test2;\npublic class Test2 {\n  static int j=20;\n  public static void main (String[] Args) {\n    int i=10;\n    Test2 p = new Test2();\n    p.metodo(i);\n    System.out.println(i);\n    System.out.println(j);\n  }\n  public void metodo (int x) {\n    x=x*2;\n    j=j*2;\n  }\n}",
    opciones: [
      "Muestra en pantalla los números 10 y 40.",
      "Muestra en pantalla los números 20 y 20.",
      "Muestra en pantalla los números 20 y 40.",
      "Ninguna es correcta."
    ],
    correcta: 0,
    explicacion:
      "El parámetro i se pasa por valor; dentro del método se modifica x y j, pero i en main sigue siendo 10. j, al ser static, queda multiplicado por 2 y pasa de 20 a 40."
  },
  {
    numero: 13,
    enunciado:
      "Dado el siguiente código, indique la salida:\n\npublic class Test33 {\n  public static void main(String[] args) {\n    final char a = 'A', d = 'D';\n    char nota = 'B';\n    switch(nota) {\n      case a :\n      case 'B' :\n        System.out.print(\"enhorabuena\");\n      case 'C' :\n        System.out.print(\"aprobado\");\n        break;\n      case d :\n        System.out.print(\"suspendido\");\n      case 'F' :\n        System.out.print(\"no presentado\");\n    }\n  }\n}",
    opciones: [
      "enhorabuena",
      "enhorabuenaaprobado",
      "No devuelve nada porque no entra en ningún case",
      "Se produce un error de compilación"
    ],
    correcta: 1,
    explicacion:
      "Para nota 'B' entran los case a y 'B' y, al no tener break, también ejecuta el case 'C'. Se imprime \"enhorabuenaaprobado\"."
  },
  {
    numero: 14,
    enunciado:
      "Dado el siguiente programa, indique la salida:\n\npublic class Test34 {\n  public static void main(String[] args) {\n    String input=\"Guadalajara\";\n    int count = 0;\n    int length = input.length();\n    int i = 0;\n    String lowercase = input.toLowerCase();\n    while(i < length) {\n      switch(lowercase.charAt(i)) {\n        case 'a':\n        case 'e':\n        case 'i':\n        case 'o':\n        case 'u':\n          count++;\n      }\n      i++;\n    }\n    System.out.println(count);\n  }\n}",
    opciones: ["6", "11", "0", "1"],
    correcta: 0,
    explicacion:
      "\"Guadalajara\" tiene 6 vocales. El código recorre la cadena y cuenta las vocales en minúscula."
  },
  {
    numero: 15,
    enunciado:
      "Dado el siguiente código, indique cuál será su salida:\n\npublic class Test37 {\n  public static void main(String[] args) {\n    ClaseHija objB1=new ClaseHija(2);\n    ClasePadre objB2;\n    System.out.println(\"**FIN\");\n  }\n}\nclass ClasePadre{\n  public ClasePadre (int x){\n    System.out.print(\"**ClasePadre-\" + x);\n  }\n}\nclass ClaseHija extends ClasePadre{\n  public ClaseHija(int x){\n    super(x);\n    System.out.print(\"**ClaseHija-\" + x*x);\n  }\n}",
    opciones: [
      "**ClasePadre-2**ClaseHija-4**FIN",
      "**ClaseHija-4**ClasePadre-2**FIN",
      "Hay un error en el método main ya que no se ha instanciado el objeto de ClasePadre",
      "Hay un error en ClaseHija. La sentencia super(x) no puede ser la primera de su constructor"
    ],
    correcta: 0,
    explicacion:
      "Se llama primero al constructor de la clase padre y luego al de la hija, imprimiendo en ese orden, y al final \"**FIN\"."
  },
  {
    numero: 16,
    enunciado: "Indique cuál de las siguientes afirmaciones es cierta:",
    opciones: [
      "Una clase puede implementar más de una interfaz al mismo tiempo.",
      "Una interfaz puede implementar alguno de los métodos que declara.",
      "Cuando una clase implementa una interfaz específica no hace falta que implemente todos los métodos que ésta declara.",
      "Una interfaz puede declarar variables de instancia o de clase."
    ],
    correcta: 0,
    explicacion:
      "En Java una clase puede implementar varias interfaces separadas por comas, por eso esta opción es correcta."
  },
  {
    numero: 17,
    enunciado:
      "Supongamos que necesita crear una clase que almacene como elemento base de la misma, objetos únicos. No se necesita que guarden orden alguno, pero sí que no se repitan. ¿Qué interfaz sería la más apropiada para este fin?",
    opciones: ["Vector.", "List.", "Set.", "Map."],
    correcta: 2,
    explicacion:
      "Set es la interfaz pensada para conjuntos sin elementos repetidos y sin obligación de orden."
  },
  {
    numero: 18,
    enunciado: "Indique cuál de las siguientes afirmaciones es falsa:",
    opciones: [
      "Para diferenciar los componentes Swing de los AWT, los Swing tienen nombres precedidos de una “J”.",
      "Los componentes Swing dependen del sistema operativo.",
      "La clase JFrame extiende de la clase Frame.",
      "Los componentes o controles de AWT se insertan en contenedores."
    ],
    correcta: 1,
    explicacion:
      "Swing está implementado completamente en Java y no depende del sistema operativo como AWT, por tanto decir que depende del SO es falso."
  },
  {
    numero: 19,
    enunciado:
      "Indique cuál será la salida del siguiente programa:\n\npublic class Test47 {\n  public static void main(String args[]) {\n    int i=1, j=1;\n    try {\n      i++;\n      j--;\n      if(i == j)\n        i++;\n    }\n    catch(ArithmeticException e) {\n      System.out.print(\"A\");\n    }\n    catch(ArrayIndexOutOfBoundsException e) {\n      System.out.print(\"B\");\n    }\n    catch(Exception e) {\n      System.out.print(\"C\");\n    }\n    finally {\n      System.out.print(\"D\");\n    }\n    System.out.print(\"F\");\n  }\n}",
    opciones: ["AF", "BF", "CF", "DF"],
    correcta: 3,
    explicacion:
      "No se lanza ninguna excepción; siempre entra en finally, por lo que se imprime DF."
  },
  {
    numero: 20,
    enunciado:
      "Indique cuál de las siguientes definiciones de un método \"metodo\", que lanza IOException, y que devuelve void, es correcta:",
    opciones: [
      "void metodo() throw IOException {}",
      "void metodo(void) throws IOException {}",
      "void metodo() throws IOException {}",
      "void metodo() {} throw IOException"
    ],
    correcta: 2,
    explicacion:
      "La sintaxis correcta para declarar que un método puede lanzar IOException es usar \"throws\" en la cabecera."
  },
  {
    numero: 21,
    enunciado:
      "Indique la salida del siguiente programa:\n\npublic class Test32 {\n  public static void main(String[] args) {\n    Integer i = 3;\n    switch(i) {\n      case 1: System.out.print(1); break;\n      case 3: System.out.print(3);\n      case 5: System.out.print(5);\n      case 7: System.out.print(7); break;\n      default: System.out.print(\"default\");\n    }\n  }\n}",
    opciones: ["3", "3default", "357", "357default"],
    correcta: 2,
    explicacion:
      "Al no haber break, para i=3 se ejecutan los case 3, 5 y 7 y se imprime 357."
  },
  {
    numero: 22,
    enunciado: "Indique la afirmación incorrecta:",
    opciones: [
      "Los miembros privados de una clase pueden ser heredados.",
      "En Java, una clase que se hereda se denomina superclase. La clase que hereda se llama subclase.",
      "Una subclase hereda todas las variables y métodos definidos por la superclase y agrega sus propios elementos únicos.",
      "El mecanismo de herencia solo es aplicable para miembros públicos y protegidos."
    ],
    correcta: 3,
    explicacion:
      "Los miembros privados también se heredan aunque no sean accesibles directamente desde la subclase, por tanto decir que solo se heredan públicos y protegidos es falso."
  },
  {
    numero: 23,
    enunciado:
      "Sean una variable \"dividendo\" y una variable \"divisor\". Si ambas variables son de tipo float entonces al dividirlas tomado el \"divisor\" valor cero, el resultado:",
    opciones: [
      "Dará 0.",
      "Se producirá una excepción.",
      "Devolverá Infinity.",
      "Devolverá Infinity y se producirá una excepción."
    ],
    correcta: 2,
    explicacion:
      "Dividir un float entre 0 en Java no lanza excepción, devuelve Infinity."
  },
  {
    numero: 24,
    enunciado:
      "Suponiendo que tengo un ArrayList de objetos Vehiculo llamado concesionario, entonces la sentencia:\nconcesionario.add(concesionario.size(), miVehiculo);",
    opciones: [
      "Es errónea, provocando error en compilación.",
      "Es errónea, provocando error en tiempo de ejecución por intentar insertar fuera del ArrayList.",
      "Es correcta, insertando el objeto miVehiculo en la penúltima posición y desplazando al final la que antes era la última.",
      "Es correcta, insertando el objeto miVehiculo en la última posición."
    ],
    correcta: 3,
    explicacion:
      "add(size, elemento) inserta al final de un ArrayList sin error."
  },
  {
    numero: 25,
    enunciado: "Indique la afirmación falsa:",
    opciones: [
      "Un JFrame no admite a ninguna otra ventana como padre.",
      "Un JDialog sí admite como padres un JFrame u otros JDialog.",
      "Un JFrame puede tener otra ventana como padre.",
      "Un JDialog siempre quedará por encima de su JFrame."
    ],
    correcta: 2,
    explicacion:
      "Un JFrame sí puede tener otra ventana como padre (por ejemplo, un JFrame principal). Esa afirmación es la falsa."
  },
  {
    numero: 26,
    enunciado: "En Java:",
    opciones: [
      "Una ventana hija siempre debe quedar por encima de su ventana padre.",
      "Una ventana hija siempre debe quedar por encima de su ventana padre.",
      "Una ventana hija puede quedar por encima y por debajo de su ventana padre.",
      "Una ventana hija no puede quedar ni por encima ni por debajo de su ventana padre."
    ],
    correcta: 2,
    explicacion:
      "Una ventana hija puede pasar por delante y por detrás de su padre dependiendo de cómo se gestione el enfoque."
  },
  {
    numero: 27,
    enunciado: "Con cuál de estas alternativas no se puede crear un proyecto en Netbeans:",
    opciones: ["Maven", "Gradle", "Ant", "Mercury"],
    correcta: 3,
    explicacion:
      "\"Mercury\" no es uno de los tipos de proyecto estándar en NetBeans (como Maven, Gradle o Ant)."
  },
  {
    numero: 28,
    enunciado: "Indica cuál de los siguientes no es un layout de Swing:",
    opciones: ["CardLayout", "FlowLayout", "TableLayout", "GroupLayout"],
    correcta: 2,
    explicacion:
      "TableLayout no es un layout estándar incluido en Swing; los otros sí."
  },
  {
    numero: 29,
    enunciado: "Indique la afirmación correcta:",
    opciones: [
      "JComboBox permite solo selección única mientras que JList permite selección múltiple.",
      "JComboBox permite selección múltiple, mientras que JList permite sólo selección única.",
      "JComboBox y JList permiten ambos selección múltiple.",
      "Tanto JComboBox como JList sólo permiten selección única."
    ],
    correcta: 0,
    explicacion:
      "JComboBox solo permite seleccionar un elemento, mientras que JList puede configurarse para permitir múltiples selecciones."
  },
  {
    numero: 30,
    enunciado: "Indique la afirmación correcta:",
    opciones: [
      "La interfaz Comparable requiere implementar el método compare() y la interfaz Comparator el método compareTo().",
      "La interfaz Comparable requiere implementar el método compareTo() y la interfaz Comparator el método compare().",
      "La interfaz Comparable y la interfaz Comparator requieren implementar tanto el método compareTo(), como el método compare().",
      "Ni la interfaz Comparable ni la interfaz Comparator requieren implementar el método compareTo(), ni el método compare()."
    ],
    correcta: 1,
    explicacion:
      "Comparable usa compareTo() y Comparator define compare()."
  },
  {
    numero: 31,
    enunciado: "¿Qué código de los siguientes tiene que ver con la herencia?",
    opciones: [
      "public class Componente inherit Producto.",
      "public class Componente implements Producto.",
      "public class Componente extends Producto.",
      "public class Componente belong to Producto."
    ],
    correcta: 2,
    explicacion:
      "La herencia en Java se expresa con \"extends\" entre clases."
  },
  {
    numero: 32,
    enunciado: "¿Qué significa sobrecargar un método?",
    opciones: [
      "Crear un método con el mismo nombre que otro, pero diferentes argumentos.",
      "Editarlo para modificar su comportamiento.",
      "Cambiarle el nombre dejándolo con la misma funcionalidad.",
      "Añadirle funcionalidades a un método."
    ],
    correcta: 0,
    explicacion:
      "Sobrecargar es definir varios métodos con el mismo nombre pero distinta lista de parámetros."
  },
  {
    numero: 33,
    enunciado: "¿Cuál de los siguientes códigos escribirías para utilizar una interfaz en Java?",
    opciones: [
      "public class Componente interface InterfazProducto.",
      "Componente cp = new Componente (interface).",
      "public class Componente implements Printable.",
      "Componente cp = new Componente.interface."
    ],
    correcta: 2,
    explicacion:
      "Para usar una interfaz se implementa con la palabra clave \"implements\" en la declaración de la clase."
  },
  {
    numero: 34,
    enunciado: "Indique cuál de los siguientes es el valor por defecto de una variable local:",
    opciones: ["0.", "null.", "No asignado.", "Dependerá del tipo de variable."],
    correcta: 2,
    explicacion:
      "Las variables locales en Java no tienen valor por defecto, deben ser inicializadas antes de usarse."
  },
  {
    numero: 35,
    enunciado:
      "Dado este fragmento de código, ¿cuál será su salida?\n\nclass Cantante {\n  public static String cantar() { return \"la\"; }\n}\npublic class Tenor extends Cantante {\n  public static String cantar () { return \"fa\"; }\n  public static void main (String [] args ) {\n    Tenor t = new Tenor ();\n    Cantante s = new Tenor ();\n    System.out.println (t.cantar () + \" \" + s.cantar() );\n  }\n}",
    opciones: ["fa la", "la la", "la fa", "fa fa"],
    correcta: 3,
    explicacion:
      "Los métodos static no se polimorfizan, se resuelven según el tipo de referencia. Ambos cantan \"fa\"."
  },
  {
    numero: 36,
    enunciado:
      "Cuando usamos JavaFX, los ficheros propios de la vista o interfaz gráfica tienen extensión:",
    opciones: [".css", ".fxml", ".java", ".fx"],
    correcta: 1,
    explicacion:
      "En JavaFX las vistas se describen normalmente en ficheros FXML, que tienen extensión .fxml."
  },
  {
    numero: 37,
    enunciado: "Indique la afirmación correcta sobre JavaFX:",
    opciones: [
      "JavaFX admite el uso de ficheros css.",
      "JavaFX está siendo sustituido por AWT.",
      "JavaFX está siendo sustituido por Swing.",
      "JavaFX utiliza el patrón de diseño DAO (Data Access Object)"
    ],
    correcta: 0,
    explicacion:
      "JavaFX puede aplicar hojas de estilo CSS para definir la apariencia de la interfaz."
  },
  {
    numero: 38,
    enunciado:
      "¿Con qué modificador se indica que una clase termina una cadena de herencia?",
    opciones: ["public.", "abstract.", "finalize.", "final."],
    correcta: 3,
    explicacion:
      "Una clase final no se puede heredar, por eso termina una cadena de herencia."
  },
  {
    numero: 39,
    enunciado: "¿Qué es una interface de Java?",
    opciones: [
      "Una superclase.",
      "Un conjunto de declaraciones de métodos o funciones.",
      "Un sistema de herencia múltiple.",
      "Un fichero de tipo public accesible por otros ficheros."
    ],
    correcta: 1,
    explicacion:
      "Una interfaz define solo la firma de métodos (contratos), no su implementación."
  },
  {
    numero: 40,
    enunciado:
      "¿Qué imprime el siguiente código?\nint x=2;\nint y=2;\nint z;\nz = x++ + y;\nSystem.out.println(z);",
    opciones: ["2.", "3.", "4.", "5."],
    correcta: 2,
    explicacion:
      "x++ devuelve primero 2 y luego incrementa a 3. z = 2 + 2 = 4 y luego x pasa a valer 3."
  }
  ]
};

// Examen actualmente cargado (array de preguntas) y su identificador.
let preguntasActuales = [];
let idExamenActual = null;

function crearPregunta(pregunta) {
  const contenedor = document.createElement("article");
  contenedor.className = "pregunta";

  const titulo = document.createElement("h2");
  titulo.textContent = `Pregunta ${pregunta.numero}`;

  const texto = document.createElement("pre");
  texto.textContent = pregunta.enunciado;

  contenedor.appendChild(titulo);
  contenedor.appendChild(texto);

  pregunta.opciones.forEach((opcion, indice) => {
    const etiqueta = document.createElement("label");
    etiqueta.className = "opcion";

    const radio = document.createElement("input");
    radio.type = "radio";
    radio.name = `pregunta-${pregunta.numero}`;
    radio.value = indice;

    radio.addEventListener("change", () => {
      manejarRespuestaInmediata(pregunta.numero, indice);
    });

    etiqueta.appendChild(radio);
    etiqueta.appendChild(document.createTextNode(opcion));
    contenedor.appendChild(etiqueta);
  });

  const parrafoFeedback = document.createElement("p");
  parrafoFeedback.id = `feedback-${pregunta.numero}`;
  parrafoFeedback.className = "feedback";
  contenedor.appendChild(parrafoFeedback);

  return contenedor;
}

function manejarRespuestaInmediata(numeroPregunta, indiceElegido) {
  const pregunta = preguntasActuales.find(
    (preguntaBuscada) => preguntaBuscada.numero === numeroPregunta
  );
  if (!pregunta) {
    return;
  }

  const parrafoFeedback = document.getElementById(`feedback-${numeroPregunta}`);
  if (!parrafoFeedback) {
    return;
  }

  const respuestaEsCorrecta = indiceElegido === pregunta.correcta;
  const textoBase = pregunta.explicacion || "";

  if (respuestaEsCorrecta) {
    parrafoFeedback.textContent = "Correcto. " + textoBase;
    parrafoFeedback.classList.remove("feedback-incorrecto");
    parrafoFeedback.classList.add("feedback-correcto");
  } else {
    parrafoFeedback.textContent = "Incorrecto. " + textoBase;
    parrafoFeedback.classList.remove("feedback-correcto");
    parrafoFeedback.classList.add("feedback-incorrecto");
  }
}

function cargarPreguntas(idExamen) {
  idExamenActual = idExamen;
  preguntasActuales = bancoExamenes[idExamen] || [];
  const zonaPreguntas = document.getElementById("zona-preguntas");
  zonaPreguntas.innerHTML = "";
  const zonaResultados = document.getElementById("zona-resultados");
  zonaResultados.classList.add("oculto");

  preguntasActuales.forEach((pregunta) => {
    const nodoPregunta = crearPregunta(pregunta);
    zonaPreguntas.appendChild(nodoPregunta);
  });
}

function corregirTest() {
  let aciertos = 0;

  preguntasActuales.forEach((pregunta) => {
    const nombreGrupo = `pregunta-${pregunta.numero}`;
    const opcionesMarcadas = document.querySelectorAll(
      `input[name="${nombreGrupo}"]:checked`
    );
    if (opcionesMarcadas.length === 1) {
      const indiceElegido = parseInt(opcionesMarcadas[0].value, 10);
      if (indiceElegido === pregunta.correcta) {
        aciertos++;
      }
    }
  });

  const zonaResultados = document.getElementById("zona-resultados");
  const textoResultado = document.getElementById("texto-resultado");
  zonaResultados.classList.remove("oculto");

  textoResultado.textContent = `Has acertado ${aciertos} de ${preguntasActuales.length} preguntas.`;
}

document.addEventListener("DOMContentLoaded", () => {
  const selectorExamen = document.getElementById("selector-examen");
  const botonCargarExamen = document.getElementById("boton-cargar-examen");
  const botonCorrector = document.getElementById("boton-corrector");

  botonCargarExamen.addEventListener("click", () => {
    const idSeleccionado = selectorExamen.value;
    cargarPreguntas(idSeleccionado);
  });

  botonCorrector.addEventListener("click", corregirTest);
});

