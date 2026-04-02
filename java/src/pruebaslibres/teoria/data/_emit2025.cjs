/**
 * Genera programacion2025.js desde el contenido del PDF 2024-2025 (DAW).
 * Ejecutar: node _emit2025.cjs
 */
const fs = require("fs");
const path = require("path");

const examen2025 = [
  {
    numero: 1,
    enunciado:
      'Dado el siguiente fragmento de código, cuál es el resultado del comando java test 8 2\npublic class Test {\npublic static void main(String[] args) {\nint a = Integer.parseInt(args[0]);\nint b = Integer.parseInt(args[1]);\nif (a % b == 0) {\nSystem.out.println("Divisible");\n} else {\nSystem.out.println("No divisible");\n}\n}\n}',
    opciones: ["Divisible", "No divisible", "Error en tiempo de compilación", "Error en tiempo de ejecución"],
    correcta: 0,
    explicacion: "8 % 2 == 0 → se imprime Divisible.",
  },
  {
    numero: 2,
    enunciado: "¿Cuál es la función principal de JDBC en Java?",
    opciones: [
      "Proporcionar una interfaz gráfica para aplicaciones de escritorio.",
      "Conectar aplicaciones Java con bases de datos relacionales.",
      "Crear servicios RESTful.",
      "Optimizar el rendimiento de aplicaciones web",
    ],
    correcta: 1,
    explicacion: "JDBC es la API de conectividad con bases de datos relacionales.",
  },
  {
    numero: 3,
    enunciado: "¿Cuál de las siguientes interfaces de colección en Java no permite elementos duplicados?",
    opciones: ["java.util.Queue", "java.util.Set", "java.util.List", "java.util.Map"],
    correcta: 1,
    explicacion: "Set no admite duplicados (Map tampoco en claves, pero la pregunta pide interfaz de colección típica: Set).",
  },
  {
    numero: 4,
    enunciado:
      '¿Cuál es la salida del siguiente programa?\npublic class Example {\nstatic int count = 0;\npublic int incrementCount() {\ncount++;\nreturn count;\n}\npublic static void main(String[] args) {\nExample ex1 = new Example();\nExample ex2 = new Example();\nex1.incrementCount();\nex2.incrementCount();\nSystem.out.println(count);\n}\n}',
    opciones: ["0", "1", "2", "El código da errores de compilación."],
    correcta: 2,
    explicacion: "count es estático y compartido; dos incrementos → 2.",
  },
  {
    numero: 5,
    enunciado:
      'Dado el siguiente código, ¿es correcto o presenta errores en tiempo de compilación o ejecución?\npublic class PreguntaStatic {\nprivate static int contador;\nprivate static final int LIMITE = 5;\nstatic {\nfor (int i = 0; i < LIMITE; i++) {\nincrementarContador();\n}\n}\npublic static void incrementarContador() {\ncontador++;\n}\npublic PreguntaStatic() {\ncontador = 0;\n}\npublic static void main(String[] args) {\nSystem.out.println("Contador (antes del constructor): " + contador);\nPreguntaStatic ps = new PreguntaStatic();\nSystem.out.println("Contador (después del constructor): " + contador);\n}\n}',
    opciones: [
      'El código es correcto y muestra "Contador (antes del constructor): 5" y "Contador (después del constructor): 0".',
      "El código presenta error de compilación porque no se permite modificar una variable static final dentro de un bloque static.",
      "El código presentará un NullPointerException en el bloque static.",
      "El valor de contador se mantiene en 5 después de ejecutar el constructor.",
    ],
    correcta: 0,
    explicacion: "El bloque static deja contador en 5; el constructor lo pone a 0. Luego se imprime 5 y 0.",
  },
  {
    numero: 6,
    enunciado: "Dadas las siguientes afirmaciones sobre métodos de clase en Java, indicar cuál es la correcta:",
    opciones: [
      "Un método de clase puede acceder directamente a atributos de instancia.",
      "Un método de clase no puede ser sobrecargado.",
      "Un método de clase puede ser accedido sin necesidad de crear una instancia de la clase.",
      "Un método de clase siempre tiene que ser public.",
    ],
    correcta: 2,
    explicacion: "Los métodos static (de clase) se invocan con el nombre de la clase sin instancia.",
  },
  {
    numero: 7,
    enunciado:
      '¿Cuál es la salida del siguiente programa?\npublic class ExcepcionTest {\npublic static void main(String[] args) {\ntry {\nmetodoPeligroso();\nSystem.out.print("X");\n} catch (IllegalArgumentException ex) {\nSystem.out.print("Y");\n} finally {\nSystem.out.print("Z");\n}\nSystem.out.print("W");\n}\npublic static void metodoPeligroso() {\nthrow new IllegalArgumentException("Excepción lanzada");\n}\n}',
    opciones: ["YZW", "XZW", "YW", "YZ"],
    correcta: 0,
    explicacion: "Se captura la excepción (Y), siempre se ejecuta finally (Z) y luego W → YZW.",
  },
  {
    numero: 8,
    enunciado:
      '¿Cuál es la salida del siguiente código?\ntry {\nInteger i1 = new Integer("abc");\ndouble d1 = i1.doubleValue();\nlong l1 = i1.longValue();\nshort s1 = i1.shortValue();\nSystem.out.println(d1 + l1 + s1);\n}\ncatch (NumberFormatException e) {\nSystem.out.println("bad number");\n}',
    opciones: ["9.0", "bad number", "La compilación falla en la línea 4.", "La compilación falla en la línea 5."],
    correcta: 1,
    explicacion: "La cadena \"abc\" no es un entero válido → NumberFormatException → bad number.",
  },
  {
    numero: 9,
    enunciado:
      '¿Cuál es la salida del siguiente código?\nString str1 = "java";\nString str2 = new String("java");\nString str3 = "java";\nObject obj1 = str1;\nObject obj2 = str2;\nObject obj3 = str3;\nif (obj1 == str1) {\nSystem.out.println("A");\n} else {\nSystem.out.println("B");\n}\nif (obj2 == str2) {\nSystem.out.println("C");\n} else {\nSystem.out.println("D");\n}\nif (obj3.equals(str3)) {\nSystem.out.println("E");\n} else {\nSystem.out.println("F");\n}\nif (obj2.equals(str1)) {\nSystem.out.println("G");\n} else {\nSystem.out.println("H");\n}',
    opciones: ["A, C, E, G", "A, D, E, H", "B, C, E, G", "A, C, E, H"],
    correcta: 0,
    explicacion: "obj1==str1 (A), obj2==str2 (C), obj3.equals(str3) (E), obj2.equals(str1) (G).",
  },
  {
    numero: 10,
    enunciado: "¿Cuál de las siguientes afirmaciones sobre la palabra clave transient en Java es correcta?",
    opciones: [
      "La palabra clave transient indica que el campo de una clase no debe ser serializado.",
      "La palabra clave transient se utiliza para indicar que un campo no debe ser accesible fuera de la clase.",
      "La palabra clave transient impide que un campo sea modificado por métodos de acceso.",
      "La palabra clave transient se utiliza para marcar un campo como constante y no modificable.",
    ],
    correcta: 0,
    explicacion: "transient excluye el campo del proceso de serialización por defecto.",
  },
  {
    numero: 11,
    enunciado:
      '¿Cuál es la salida del siguiente código?\nclass Parent {\nParent() {\nSystem.out.print("Parent ");\n}\n}\nclass Child extends Parent {\nChild() {\nSystem.out.print("Child ");\n}\npublic static void main(String[] args) {\nnew Child();\n}\n}',
    opciones: ["Parent Child", "Child Parent", "Parent", "Child"],
    correcta: 0,
    explicacion: "Se ejecuta primero el constructor del padre y luego el de la hija.",
  },
  {
    numero: 12,
    enunciado:
      '¿Cuál es la salida del siguiente código?\nclass Test {\nstatic boolean flag;\npublic static void main(String[] args) {\nint j;\nif (flag == false)\nj = 10;\nelse\nj = 20;\nif (j == 10)\nj = j + 5;\nelse\nj = j - 5;\nSystem.out.println(j);\n}\n}',
    opciones: ["5", "10", "15", "El programa no compila."],
    correcta: 2,
    explicacion: "flag es false por defecto → j=10 → se cumple j==10 → j=15.",
  },
  {
    numero: 13,
    enunciado: "¿Qué hace el método Class.getDeclaredMethods()?",
    opciones: [
      "Devuelve todos los métodos públicos de la clase, incluidos los heredados.",
      "Devuelve solo los métodos privados de la clase.",
      "Devuelve los métodos de la clase, pero solo los estáticos.",
      "Devuelve todos los métodos declarados en la clase (incluidos private), excluyendo los heredados.",
    ],
    correcta: 3,
    explicacion:
      "getDeclaredMethods() devuelve exactamente los métodos declarados en esa clase (public/protected/package/private), y no incluye heredados.",
  },
  {
    numero: 14,
    enunciado: "¿Qué hace el método Class.getSuperclass() en Java?",
    opciones: [
      "Devuelve la clase del objeto actual.",
      "Devuelve la clase base (superclase) de la clase actual.",
      "Devuelve el nombre de la clase de la superclase.",
      "Devuelve todos los métodos de la superclase.",
    ],
    correcta: 1,
    explicacion: "Devuelve el objeto Class correspondiente a la superclase directa.",
  },
  {
    numero: 15,
    enunciado:
      '¿Cuál es la salida al siguiente programa?\nFICHERO Persona.java\npublic class Persona {\nprivate String nombre;\npublic Persona(String nombre) {\nthis.nombre = nombre;\n}\npublic Persona() {\nthis.nombre = "Anónimo";\n}\npublic String getNombre() {\nreturn this.nombre;\n}\n}\nFICHERO Estudiante.java\npublic class Estudiante extends Persona {\nprivate int edad;\npublic Estudiante(int edad) {\nsuper("Estudiante");\nthis.edad = edad;\n}\npublic String toString() {\nreturn "Soy un " + getNombre() + " de " + this.edad + " años.";\n}\npublic static void main(String[] args) {\nEstudiante e = new Estudiante(21);\nSystem.out.println(e);\n}\n}',
    opciones: [
      'La salida es: "Soy un Estudiante de 21 años."',
      'La salida es: "Soy un Anónimo de 21 años."',
      'La salida es: "Soy un Estudiante de 0 años."',
      'La salida es: "Soy un Estudiante de null años."',
    ],
    correcta: 0,
    explicacion: "super(\"Estudiante\") fija el nombre; la edad es 21.",
  },
  {
    numero: 16,
    enunciado:
      '¿Cuál es la salida del siguiente código?\nimport java.util.HashMap;\npublic class HashMapExample {\npublic static void main(String[] args) {\nHashMap<String, Integer> map = new HashMap<>();\nmap.put("uno", 1);\nmap.put("dos", 2);\nmap.put("tres", 3);\nmap.put("dos", 22);\nSystem.out.println(map.get("dos"));\nmap.put(null, 100);\nSystem.out.println(map.get(null));\nSystem.out.println(map.size());\n}\n}',
    opciones: ["22\n100\n4", "2\n100\n4", "22\nnull\n4", "22\nnull\n3"],
    correcta: 0,
    explicacion: "Se sobrescribe \"dos\" con 22; clave null permitida; tamaño 4 (uno, dos, tres, null).",
  },
  {
    numero: 17,
    enunciado:
      '¿Qué ocurrirá al compilar y ejecutar el siguiente código?\npublic class MiClase {\nstatic int variableEstatica = 5;\npublic static void main(String[] args) {\nint x = variableEstatica++ + --variableEstatica;\nint y = --variableEstatica + variableEstatica++;\nint z = ++variableEstatica + --variableEstatica;\nSystem.out.println("x = " + x);\nSystem.out.println("y = " + y);\nSystem.out.println("z = " + z);\n}\n}',
    opciones: [
      "x = 10\ny = 8\nz = 11",
      "x = 9\ny = 8\nz = 8",
      "x = 10\ny = 10\nz = 10",
      "x = 9\ny = 7\nz = 8",
    ],
    correcta: 0,
    explicacion:
      "Traza: x=(5++)+(--6)=5+5=10; y=(--5)+(5++)=4+4=8; z=(++5)+(--6)=6+5=11. (El PDF original listaba otras cifras; la salida real en Java es esta.)",
  },
  {
    numero: 18,
    enunciado:
      '¿Cuál es la salida al siguiente programa?\npublic class WrapTest {\npublic static void main(String [] args) {\nint result = 0;\nInteger a = new Integer(100);\nInteger b = new Integer("100");\nInteger c = Integer.valueOf("100");\nInteger d = 100; // Autoboxing\nif (a == b)\nresult = 1;\nif (a.equals(b))\nresult = result + 10;\nif (a == c)\nresult = result + 100;\nif (a.equals(d))\nresult = result + 1000;\nif (b.equals(c))\nresult = result + 10000;\nSystem.out.println("result = " + result);\n}\n}',
    opciones: [
      "result = 11010",
      "result = 11111",
      "result = 11101",
      "result = 10000",
    ],
    correcta: 0,
    explicacion:
      "a==b y a==c son false (objetos distintos); +10, +1000, +10000 por equals → 11010. (Opciones del PDF sin 11010; aquí se corrige según JDK.)",
  },
  {
    numero: 19,
    enunciado: "¿Cuál de las siguientes afirmaciones sobre la sobrecarga de métodos en Java es correcta?",
    opciones: [
      "Se puede sobrecargar un método variando únicamente su tipo de retorno.",
      "Se puede sobrecargar un método si la lista de parámetros difiere en número o en tipos, manteniendo el mismo nombre.",
      "La sobrecarga obliga a cambiar también el nombre del método.",
      "Solo se puede sobrecargar si todos los parámetros son del mismo tipo.",
    ],
    correcta: 1,
    explicacion:
      "La sobrecarga (overload) es mismo nombre y distinta firma: distinto número o tipos de parámetros (p. ej. void f(int) y void f(int,double)).",
  },
  {
    numero: 20,
    enunciado:
      'En Java, ¿Cuál es la salida del siguiente código?\npublic class ArrayTest {\npublic static void main(String[] args) {\nString[] fruits = {"Apple", "Banana", "Orange"};\nSystem.out.println(fruits[3]);\n}\n}',
    opciones: [
      'Se imprimirá "Apple".',
      "El programa lanzará una ArrayIndexOutOfBoundsException.",
      'Se imprimirá "Banana".',
      'El programa se ejecutará sin problemas y mostrará "Orange".',
    ],
    correcta: 1,
    explicacion: "Índice 3 está fuera de rango (0..2).",
  },
  {
    numero: 21,
    enunciado: "¿Qué clase abstracta es la superclase de todas las clases usadas para escribir bytes?",
    opciones: ["OutputStream", "FileWriter", "PrintWriter", "FileOutputStream"],
    correcta: 0,
    explicacion: "La raíz de flujos de salida de bytes es OutputStream.",
  },
  {
    numero: 22,
    enunciado: "¿Qué clase abstracta es la superclase de todas las clases usadas para leer bytes?",
    opciones: ["InputStream", "FileReader", "InputStreamReader", "FileInputStream"],
    correcta: 0,
    explicacion: "InputStream es la superclase abstracta para lectura de bytes.",
  },
  {
    numero: 23,
    enunciado: "¿Cuál de las siguientes afirmaciones describe correctamente una List en Java?",
    opciones: [
      "Una List es una colección que almacena pares llave/valor.",
      "Una List es una colección que almacena elementos en un orden específico y permite elementos duplicados.",
      "Una List es una colección que almacena únicamente valores únicos.",
      "Una List es una colección que almacena elementos con un índice único, pero no permite duplicados.",
    ],
    correcta: 1,
    explicacion: "List mantiene orden de inserción/indexación y admite duplicados.",
  },
  {
    numero: 24,
    enunciado: "¿Qué clase se utiliza para leer objetos serializados desde un archivo en Java?",
    opciones: ["ObjectInputStream", "DataInputStream", "ObjectOutputStream", "BufferedReader"],
    correcta: 0,
    explicacion: "ObjectInputStream deserializa objetos desde un flujo.",
  },
  {
    numero: 25,
    enunciado:
      "¿Qué excepción se lanza cuando intentas escribir en un archivo de solo lectura utilizando FileOutputStream?",
    opciones: ["FileNotFoundException", "SecurityException", "IOException", "AccessDeniedException"],
    correcta: 0,
    explicacion:
      "Al abrir FileOutputStream sobre archivo no escribible suele lanzarse FileNotFoundException (subclase de IOException).",
  },
  {
    numero: 26,
    enunciado:
      'Dadas las siguientes clases Clase1 y Clase2.\npublic class Clase1 {\nprivate int atributo1;\npublic Clase1(int atributo1) {\nSystem.out.print(" Clase1");\nthis.atributo1 = atributo1;\nSystem.out.print(" "+this.atributo1);\n}\npublic int getAtributo1() {\nreturn atributo1;\n}\n}\npublic class Clase2 {\nprivate int atributo1;\nprivate Clase1 atributo2;\npublic Clase2(int atributo1) {\nSystem.out.print(" Clase2");\nthis.atributo1 = atributo1;\nSystem.out.print(" "+this.atributo1);\nthis.atributo2 = new Clase1(atributo1);\natributo1++;\n}\npublic int getAtributo1() {\nreturn atributo1;\n}\npublic int getAtributo2() {\nreturn atributo2.getAtributo1();\n}\n}\nY la ejecución del siguiente main()\npublic class Test{\npublic static void main(String[] args) throws Exception{\nClase1 c1 = new Clase1(1) ;\nClase2 c2 = new Clase2(2) ;\n}\n}\nIndicar cuál es la salida correcta',
    opciones: [
      "Clase1 1 Clase2 1 Clase1 2",
      "Clase1 1 Clase2 2 Clase1 3",
      "Clase1 1 Clase2 2 Clase1 2",
      "Clase1 1 Clase1 2 Clase2 2",
    ],
    correcta: 2,
    explicacion: "El ++ del constructor de Clase2 afecta al parámetro, no al campo; la traza coincide con la opción c.",
  },
  {
    numero: 27,
    enunciado: "¿Qué clase se utiliza para leer el contenido de un archivo de texto línea por línea?",
    opciones: ["FileReader", "BufferedReader", "FileInputStream", "PrintWriter"],
    correcta: 1,
    explicacion: "BufferedReader (p. ej. readLine()) sobre un Reader.",
  },
  {
    numero: 28,
    enunciado:
      '¿Qué ocurrirá con el siguiente código?\npublic class Test {\npublic static void main(String[] args) {\nSystem.out.println(Math.sqrt("hello")); // Error de compilación\n}\n}',
    opciones: [
      "El programa se ejecutará correctamente y mostrará un resultado.",
      "El programa compilará, pero dará un error en tiempo de ejecución.",
      "El programa no compilará debido a un tipo incorrecto en el método Math.sqrt().",
      "El programa no compilará debido a un error de sintaxis en el comentario.",
    ],
    correcta: 2,
    explicacion: "Math.sqrt espera double; una cadena no compila.",
  },
  {
    numero: 29,
    enunciado: "¿Qué clase se utiliza para ejecutar consultas SQL en JDBC?",
    opciones: ["Connection", "Statement", "DriverManager", "ResultSet"],
    correcta: 1,
    explicacion: "Statement / PreparedStatement ejecutan consultas.",
  },
  {
    numero: 30,
    enunciado: "¿Cuál es el resultado de la sentencia System.out.println(5 ^ 3);?",
    opciones: ["8", "6", "1", "2"],
    correcta: 1,
    explicacion: "XOR binario: 101 ^ 011 = 110 → 6.",
  },
  {
    numero: 31,
    enunciado:
      '¿Qué se producirá si intenta compilar y ejecutar el siguiente código, pero no hay ningún archivo llamado Data.txt en el directorio actual?\nimport java.io.*;\npublic class FileTest {\npublic static void main(String[] args) {\nFileTest ft = new FileTest();\nSystem.out.println(ft.readFile());\n}\npublic int readFile() {\ntry {\nFileReader fr = new FileReader("Data.txt");\nfr.close();\n} catch (FileNotFoundException e) {\nSystem.out.println("File not found");\nreturn -1;\n} catch (IOException e) {\nSystem.out.println("IOException occurred");\n} finally {\nSystem.out.println("Finally block executed");\n}\nreturn 0;\n}\n}',
    opciones: [
      "File not found, Finally block executed, -1",
      "File not found, IOException occurred, Finally block executed",
      "File not found, Finally block executed, 0",
      "File not found, IOException occurred, 0",
    ],
    correcta: 0,
    explicacion: "Entra en catch, imprime, ejecuta finally y el return -1 del catch prevalece.",
  },
  {
    numero: 32,
    enunciado:
      'Dado el siguiente código, ¿que se mostrará?\npublic class CharacterExample {\nstatic char a = \'A\';\npublic static void main(String[] args) {\nchar b = \'B\';\nCharacterExample obj = new CharacterExample();\nobj.changeCharacters(b);\nSystem.out.println(b);\nSystem.out.println(a);\n}\npublic void changeCharacters(char c) {\nc = (char)(c + 1);\na = (char)(a + 1);\n}\n}',
    opciones: ["B y A", "B y B", "C y B", "A y C"],
    correcta: 1,
    explicacion: "char se pasa por valor (b no cambia); el campo estático a pasa a \'B\'.",
  },
  {
    numero: 33,
    enunciado:
      'Dado el siguiente fragmento de código, indicar cuál es la salida por consola cuando se ejecuta el main().\npublic class Test {\npublic static void metodo(int i) {\ntry {\nString[] cadenas = new String[i];\ncadenas[3] = "Hello";\nSystem.out.print(cadenas[3]);\n} catch (ArrayIndexOutOfBoundsException e) {\nSystem.out.print("Array error");\n} catch (Exception e) {\nSystem.out.print("General error");\n}\n}\npublic static void main(String[] args) {\ntry {\nmetodo(3);\n} catch (ArrayIndexOutOfBoundsException e) {\nSystem.out.print("Out of bounds");\n} catch (Exception e) {\nSystem.out.print("Main exception");\n}\nSystem.out.print(" FIN");\n}\n}\nIndicar cuál de las siguientes afirmaciones es correcta',
    opciones: ["Array error FIN", "General error FIN", "Out of bounds FIN", "Main exception FIN"],
    correcta: 0,
    explicacion: "metodo(3) provoca ArrayIndexOutOfBoundsException capturada dentro de metodo → Array error; luego FIN.",
  },
  {
    numero: 34,
    enunciado: "¿Cuál de las siguientes afirmaciones sobre JDBC es correcta?",
    opciones: [
      "JDBC se utiliza para crear aplicaciones gráficas en Java.",
      "JDBC permite realizar operaciones CRUD en bases de datos desde aplicaciones Java.",
      "JDBC es una librería utilizada para gestionar archivos de texto en Java.",
      "JDBC solo se puede usar para bases de datos MySQL.",
    ],
    correcta: 1,
    explicacion: "JDBC es la API estándar para acceso a datos en BD.",
  },
  {
    numero: 35,
    enunciado:
      '¿Cuál será el resultado cuando intente compilar y ejecutar el código siguiente?\npublic class Conv {\npublic static void main(String[] args) {\nConv c = new Conv();\nint i = 10;\nString s = "20";\nc.amethod(i, s);\n}\npublic void amethod(int i, String s) {\ni += s;\nSystem.out.println(i);\n}\n}',
    opciones: [
      'Compila y muestra 1020.',
      "Compila y muestra 30.",
      'Compila y muestra la cadena "1020".',
      "El programa muestra un error de compilación.",
    ],
    correcta: 3,
    explicacion: "No se puede hacer += entre int y String en esa forma; no compila.",
  },
  {
    numero: 36,
    enunciado:
      'Dado el siguiente fragmento de código:\npublic class Persona {\nprivate int edad;\npublic Persona (int edad){\nthis.edad = edad;\n}\npublic void incrementarEdad ( ) {\nthis.edad++;\n}\npublic int darEdad ( ) {\nreturn this.edad;\n}\n}\npublic class Alumno extends Persona {\nprivate int curso;\npublic Alumno (int edad) {\nsuper (edad);\nthis.curso = 1;\n}\npublic void pasarCurso ( ) {\nthis.curso++;\nthis.incrementarEdad ( );\n}\n}\nY la ejecución del siguiente programa\npublic static void main (String[] args) {\nPersona p = new Persona(28);\nSystem.out.print(p.darEdad()+" - ");\np = new Alumno(15);\np.pasarCurso();\nSystem.out.print(p.darEdad());\n}\nIndicar cuál de las siguientes afirmaciones es correcta',
    opciones: [
      "Se muestra en la consola 15-28.",
      "Se muestra en la consola 28-29.",
      "Se muestra en la consola 29-28",
      "No compilará por la línea p.pasarCurso();",
    ],
    correcta: 3,
    explicacion: "pasarCurso() no existe en el tipo Persona de la referencia p.",
  },
  {
    numero: 37,
    enunciado: "En Java, dada la clase Alumno definida en el siguiente código ¿Cómo se puede instanciar un objeto de la clase Alumno?",
    opciones: [
      "Alumno a = new Alumno( 'María' , 2.5 );",
      "Alumno a = newobject Alumno(Maria, 2);",
      'Alumno a = new Alumno( "Pedro" , 2 );',
      "Alumno a = new Alumno( 'María', '2.5' );",
    ],
    correcta: 2,
    explicacion: "Constructor coherente (String, int).",
  },
  {
    numero: 38,
    enunciado:
      'Supongamos que tenemos el siguiente código:\npublic class TestExcepciones {\nprivate int numero;\npublic TestExcepciones(int n) {\nnumero = n;\n}\npublic int getNumeroPositivo() throws ExcepcionNegativa {\nif (numero < 0)\nthrow new ExcepcionNegativa("Número negativo");\nreturn numero;\n}\npublic static void main(String[] args) {\nTestExcepciones E1 = new TestExcepciones(1);\nTestExcepciones E2 = new TestExcepciones(-2);\nTestExcepciones E3 = new TestExcepciones(3);\ntry {\nSystem.out.print(E1.getNumeroPositivo());\nSystem.out.print(E2.getNumeroPositivo());\nSystem.out.print(E3.getNumeroPositivo());\n} catch (ExcepcionNegativa e) {\nSystem.out.print(e.getMessage());\n}\n}\n}\nclass ExcepcionNegativa extends Exception {\npublic ExcepcionNegativa(String message) {\nsuper(message);\n}\n}\n¿Cuál será la salida del programa por consola?',
    opciones: ["1Número negativo3", "1Error3", "1-2-3", "1Número negativo"],
    correcta: 3,
    explicacion: "Al lanzarse en E2 se interrumpe el try y se imprime el mensaje de la excepción; E3 no se ejecuta.",
  },
  {
    numero: 39,
    enunciado: "Indicar cuál de las siguientes afirmaciones es correcta:",
    opciones: [
      "Un atributo protected es accesible solo dentro de la misma clase.",
      "Un método default (sin modificador) es accesible solo dentro de la misma clase.",
      "Un atributo private es accesible en las subclases de la clase en la que está definido.",
      "Un método protected es accesible en las subclases y dentro del mismo paquete.",
    ],
    correcta: 3,
    explicacion: "protected permite acceso en subclases y clases del mismo paquete.",
  },
  {
    numero: 40,
    enunciado: "¿Cuál de las siguientes afirmaciones sobre herencia en Java es correcta?",
    opciones: [
      "Las subclases pueden heredar atributos private de la clase padre, pero no pueden acceder a ellos directamente.",
      "Las subclases no pueden sobrescribir métodos protected de la clase padre.",
      "Los constructores de la clase padre se heredan automáticamente en las subclases.",
      "Una subclase puede heredar un atributo default de la clase padre, pero solo si se encuentra en el mismo paquete.",
    ],
    correcta: 3,
    explicacion:
      "Los miembros package-private (default) solo son heredables/accesibles dentro del mismo paquete; los constructores no se heredan y protected sí puede sobreescribirse.",
  },
];

const out = path.join(__dirname, "programacion2025.js");
const body = `// Pruebas libres 2025 — programacion2025 (DAW Web)
// Fuente: src/pruebaslibres/Pruebas_libres_2025.pdf
// Nota: en 17–18 se añadió la opción que coincide con JDK (el PDF traía cifras distintas).

window.bancoExamenes = window.bancoExamenes || {};

window.bancoExamenes.programacion2025 = ${JSON.stringify(examen2025, null, 2)};
`;
fs.writeFileSync(out, body, "utf8");
console.log("OK:", out);
