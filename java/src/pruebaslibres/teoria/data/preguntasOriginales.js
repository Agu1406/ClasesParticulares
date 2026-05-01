// Banco original adicional para reducir repeticiones en RA y Plan B.
(function () {
  const bancoOriginal = (window.bancoOriginal = window.bancoOriginal || {});

  function q(numero, enunciado, opciones, correcta, explicacion) {
    return { numero, enunciado, opciones, correcta, explicacion };
  }

  const ra1 = [
    q(1, "¿Qué operador devuelve el resto de una división entera en Java?", ["%", "/", "*", "//"], 0, "El operador módulo es %."),
    q(2, "Si int x = 7; int y = 2; ¿cuánto vale x / y?", ["3", "3.5", "4", "2"], 0, "Entre enteros, Java trunca el resultado."),
    q(3, "¿Qué método convierte String a int en Java?", ["Integer.valueOf()", "String.toInt()", "Integer.parseInt()", "Math.parseInt()"], 2, "parseInt devuelve un primitivo int."),
    q(4, "¿Qué tipo es más adecuado para valores true/false?", ["int", "char", "boolean", "byte"], 2, "boolean solo admite true o false."),
    q(5, "¿Qué salida produce System.out.println(5 + \"3\");?", ["8", "53", "Error", "5 3"], 1, "Al intervenir String se concatena."),
    q(6, "¿Qué valor inicial por defecto tiene un atributo int no inicializado?", ["null", "0", "1", "-1"], 1, "Los atributos numéricos se inicializan a 0."),
    q(7, "Con args = [\"12\", \"4\"], ¿qué imprime (a % b == 0) ?", ["false", "true", "Error", "null"], 1, "12 % 4 es 0, por tanto true."),
    q(8, "¿Qué palabra clave declara una constante de clase?", ["static", "const", "final", "readonly"], 2, "final impide reasignación."),
    q(9, "¿Qué hace ++i frente a i++ en una expresión?", ["No hay diferencia nunca", "i++ incrementa antes", "++i incrementa antes de evaluar", "Ambas decrementan"], 2, "Preincremento aplica antes de usar el valor."),
    q(10, "¿Qué operador lógico representa AND?", ["&&", "||", "!", "&|"], 0, "&& evalúa conjunción lógica."),
  ];

  const ra2 = [
    q(1, "¿Qué estructura garantiza ejecutar al menos una vez su bloque?", ["for", "while", "do-while", "switch"], 2, "do-while evalúa condición al final."),
    q(2, "¿Cuál es la mejor opción para múltiples ramas por valor discreto?", ["if simple", "switch", "while", "try-catch"], 1, "switch simplifica selección por casos."),
    q(3, "¿Qué instrucción termina inmediatamente un bucle?", ["continue", "break", "return void", "next"], 1, "break sale del bucle actual."),
    q(4, "En un if-else, ¿cuándo entra en else?", ["Siempre", "Cuando if es true", "Cuando if es false", "Nunca"], 2, "else es la rama alternativa."),
    q(5, "¿Qué produce continue dentro de for?", ["Sale del método", "Reinicia JVM", "Salta a la siguiente iteración", "Rompe todo el bucle y método"], 2, "continue omite el resto de esa iteración."),
    q(6, "¿Qué forma correcta tiene un switch moderno en Java?", ["switch(x) { case 1 -> ... }", "switch x: case 1", "case(x){1}", "if switch(x)"], 0, "La sintaxis con flecha es válida."),
    q(7, "¿Qué condición mantiene while ejecutándose?", ["Mientras sea false", "Mientras sea true", "Solo una vez", "Nunca"], 1, "while itera si la condición es true."),
    q(8, "¿Qué ocurre si faltan break en un switch clásico?", ["Error de compilación", "Se ignoran casos", "Hay fall-through", "No compila en Java 21+"], 2, "Sin break continúa en siguientes casos."),
    q(9, "¿Cuál es el índice inicial típico para recorrer arrays?", ["1", "-1", "0", "Depende siempre de JVM"], 2, "Java indexa desde 0."),
    q(10, "¿Qué estructura usarías para repetir N veces conocidas?", ["for", "if", "switch", "try"], 0, "for es ideal cuando conoces iteraciones."),
  ];

  const ra3 = [
    q(1, "¿Qué define la firma de un método en Java?", ["Nombre + tipo retorno", "Nombre + parámetros", "Solo nombre", "Nombre + cuerpo"], 1, "La firma incluye nombre y tipos de parámetros."),
    q(2, "¿Puede un método void devolver un valor con return valor;", ["Sí, siempre", "Solo en static", "No, error de compilación", "Solo con String"], 2, "void no devuelve valores."),
    q(3, "¿Qué es recursividad?", ["Llamar a otros paquetes", "Un método que se llama a sí mismo", "Heredar una clase", "Sobrecargar constructores"], 1, "Recursión: auto-llamada con caso base."),
    q(4, "¿Qué evita recursión infinita?", ["Más parámetros", "Caso base", "Método private", "Try-catch"], 1, "El caso base finaliza la recursión."),
    q(5, "¿Qué significa sobrecargar métodos?", ["Mismo nombre y distintos parámetros", "Mismo nombre y misma firma", "Cambiar clase padre", "Anular static"], 0, "Overload depende de parámetros."),
    q(6, "¿Qué retorno usar para validar condición?", ["double", "boolean", "char", "Object"], 1, "boolean representa verdadero/falso."),
    q(7, "¿Qué modificador permite llamar al método sin instancia?", ["private", "final", "static", "abstract"], 2, "static se invoca con la clase."),
    q(8, "¿Qué valor devuelve un método int con return 5;", ["String \"5\"", "int 5", "boolean true", "void"], 1, "Retorna entero 5."),
    q(9, "¿Qué sucede si un método non-void no retorna en todos los caminos?", ["Compila con warning", "Error de compilación", "Error solo en runtime", "Java añade return 0"], 1, "El compilador exige retorno en todos los caminos."),
    q(10, "¿Qué describe mejor paso por valor en Java?", ["Se pasa referencia original mutable", "Se copia el valor de la variable", "No se pasan parámetros", "Solo pasa por referencia"], 1, "Siempre se pasa una copia del valor."),
  ];

  const ra4 = [
    q(1, "¿Qué colección permite duplicados y mantiene orden de inserción?", ["Set", "Map", "List", "Queue fija"], 2, "List permite duplicados y mantiene orden."),
    q(2, "¿Qué estructura no permite claves duplicadas?", ["HashMap", "ArrayList", "LinkedList", "Stack"], 0, "Map no duplica claves."),
    q(3, "¿Qué método añade un elemento a ArrayList?", ["put()", "add()", "insert()", "pushBack()"], 1, "add inserta al final (o en índice)."),
    q(4, "¿Qué devuelve size() en colecciones?", ["Capacidad reservada", "Número de elementos", "Índice máximo", "Bytes ocupados"], 1, "size es cantidad actual."),
    q(5, "¿Qué colección elimina duplicados de forma natural?", ["Set", "List", "ArrayList", "Vector"], 0, "Set no admite duplicados."),
    q(6, "¿Qué método recupera valor por clave en Map?", ["find()", "get()", "value()", "at()"], 1, "get(clave) devuelve valor asociado."),
    q(7, "¿Qué excepción puede lanzar get(index) fuera de rango en lista?", ["NullPointerException", "ArithmeticException", "IndexOutOfBoundsException", "IOException"], 2, "Índice inválido lanza esa excepción."),
    q(8, "¿Qué interfaz representa pares clave-valor?", ["List", "Set", "Map", "Collection"], 2, "Map modela clave-valor."),
    q(9, "¿Qué método comprueba si una lista contiene elemento?", ["exists()", "contains()", "in()", "has()"], 1, "contains busca por equals."),
    q(10, "¿Qué implementación común de Map no garantiza orden?", ["TreeMap", "LinkedHashMap", "HashMap", "SortedMap"], 2, "HashMap no garantiza orden de iteración."),
  ];

  const ra5 = [
    q(1, "¿Qué representa herencia en POO?", ["Una clase usa SQL", "Una clase hija reutiliza atributos/métodos de padre", "Solo copiar código", "Crear interfaces"], 1, "Herencia modela relación es-un."),
    q(2, "¿Qué anotación indica sobrescritura correcta?", ["@Over", "@Override", "@Overwrite", "@Super"], 1, "@Override valida método sobrescrito."),
    q(3, "¿Qué miembro pertenece a la clase y no a instancias?", ["Atributo local", "Miembro static", "Parámetro", "Bloque try"], 1, "static es compartido por clase."),
    q(4, "¿Qué método se ejecuta al crear un objeto?", ["main", "constructor", "getter", "toString"], 1, "El constructor inicializa instancia."),
    q(5, "¿Qué permite polimorfismo de subtipo?", ["Referencia padre a objeto hijo", "Solo clases finales", "Solo static", "Evitar interfaces"], 0, "Padre puede apuntar a hijo."),
    q(6, "¿Los métodos static se comportan con despacho dinámico?", ["Sí, siempre", "No, se resuelven por tipo de referencia", "Solo con interfaces", "Solo con final"], 1, "No hay polimorfismo dinámico en static."),
    q(7, "¿Qué sucede si no defines constructor?", ["No compila", "Java genera constructor por defecto", "Se vuelve abstracta", "Se vuelve final"], 1, "Se crea constructor vacío por defecto."),
    q(8, "¿Qué diferencia equals de ==", ["Ambos comparan contenido", "equals compara referencia siempre", "== compara referencia; equals suele comparar contenido", "No hay diferencia"], 2, "== referencia; equals contenido (según implementación)."),
    q(9, "¿Qué palabra impide heredar una clase?", ["static", "abstract", "final", "private"], 2, "final bloquea herencia."),
    q(10, "¿Qué palabra permite usar miembros heredados con modificación?", ["extends", "implements", "import", "package"], 0, "extends crea herencia de clase."),
  ];

  const ra6 = [
    q(1, "¿Qué bloque se ejecuta siempre, haya excepción o no?", ["catch", "throws", "finally", "try"], 2, "finally se ejecuta salvo cierre abrupto del proceso."),
    q(2, "¿Qué excepción es típica al parsear \"abc\" con Integer.parseInt?", ["IOException", "NumberFormatException", "SQLException", "NullPointerException"], 1, "Texto no numérico => NumberFormatException."),
    q(3, "¿Qué palabra clave lanza una excepción manualmente?", ["throws", "throw", "except", "raise"], 1, "throw lanza instancia de excepción."),
    q(4, "¿Para qué sirve throws en firma de método?", ["Capturar excepción", "Declarar que puede propagarse", "Ignorar excepción", "Crear excepción"], 1, "throws declara posibles excepciones."),
    q(5, "¿Cuál es el orden correcto recomendado de catch?", ["General antes que específicas", "Específicas antes que general", "Da igual", "Solo un catch permitido"], 1, "Primero específicas para evitar inalcanzables."),
    q(6, "¿Qué pasa si no capturas una RuntimeException?", ["Nada", "Siempre compila y termina normal", "Puede finalizar programa en ejecución", "Se convierte en IOException"], 2, "Puede propagarse y terminar ejecución."),
    q(7, "¿Qué excepción lanzarías para argumento inválido?", ["IllegalArgumentException", "IOException", "ClassNotFoundException", "InterruptedException"], 0, "Es la más común para validaciones."),
    q(8, "¿Puede existir try sin catch si hay finally?", ["No", "Sí", "Solo en métodos static", "Solo en Java 25"], 1, "try-finally es válido."),
    q(9, "¿Qué excepción chequeada es frecuente en ficheros?", ["ArithmeticException", "IOException", "ArrayIndexOutOfBoundsException", "NumberFormatException"], 1, "IO suele requerir manejo/check."),
    q(10, "¿Qué sentencia asegura liberar recursos automáticamente?", ["try-with-resources", "with open", "auto close", "resource block"], 0, "try-with-resources cierra AutoCloseable."),
  ];

  const ra7 = [
    q(1, "¿Qué clase simplifica escritura de texto línea a línea?", ["FileOutputStream", "BufferedWriter", "ObjectInputStream", "Scanner"], 1, "BufferedWriter optimiza escritura de texto."),
    q(2, "¿Qué clase leería bytes de una imagen JPG?", ["BufferedReader", "FileInputStream", "PrintWriter", "StringReader"], 1, "Las imágenes se manejan como bytes."),
    q(3, "¿Qué método escribe salto de línea en BufferedWriter?", ["newLine()", "line()", "breakLine()", "appendLn()"], 0, "newLine añade separador de línea."),
    q(4, "¿Qué modo usar para copiar binarios sin corrupción?", ["Reader/Writer de texto", "Streams de bytes", "Scanner + println", "String concat"], 1, "Binarios con InputStream/OutputStream."),
    q(5, "¿Qué clase permite leer texto por líneas cómodamente?", ["BufferedReader", "FileInputStream", "ObjectOutputStream", "Path"], 0, "BufferedReader expone readLine()."),
    q(6, "¿Qué devuelve readLine() al llegar al final?", ["\"\"", "null", "-1", "EOF"], 1, "Devuelve null en fin de archivo."),
    q(7, "¿Qué conviene comprobar antes de leer un fichero?", ["file.exists()", "file.hashCode()", "file.toURI()", "Nada"], 0, "exists ayuda a validar presencia."),
    q(8, "¿Qué enfoque es más seguro para cierre de recursos?", ["close manual en varios sitios", "try-with-resources", "No cerrar", "System.gc()"], 1, "try-with-resources evita fugas."),
    q(9, "¿Qué clase escribe bytes de salida?", ["FileWriter", "FileOutputStream", "BufferedReader", "Reader"], 1, "FileOutputStream trabaja en bytes."),
    q(10, "¿Qué ocurre si copias JPG con Reader/Writer?", ["Se comprime mejor", "Puede corromperse", "No cambia nada", "Se vuelve PNG"], 1, "Reader/Writer transforman caracteres, no bytes crudos."),
  ];

  const ra8 = [
    q(1, "¿Cuál es el orden típico JDBC?", ["SQL->Connection->Driver", "Driver->Connection->Statement->ResultSet", "ResultSet->Statement->Connection", "Connection->JSON"], 1, "Flujo básico de uso JDBC."),
    q(2, "¿Qué interfaz ejecuta consultas SQL simples?", ["ResultSet", "Statement", "DriverManager", "ConnectionPool"], 1, "Statement ejecuta SQL."),
    q(3, "¿Qué método de Statement se usa para SELECT?", ["executeUpdate", "executeQuery", "executeSelect", "runQuery"], 1, "executeQuery devuelve ResultSet."),
    q(4, "¿Qué devuelve executeUpdate en INSERT/UPDATE/DELETE?", ["ResultSet", "boolean", "Número de filas afectadas", "String"], 2, "Devuelve int con filas afectadas."),
    q(5, "¿Qué objeto representa una conexión activa a BD?", ["ResultSet", "Connection", "Statement", "Driver"], 1, "Connection mantiene sesión con BD."),
    q(6, "¿Qué clase suele crear conexiones por URL JDBC?", ["ClassLoader", "DriverManager", "StatementFactory", "DBConnector"], 1, "DriverManager.getConnection(...)"),
    q(7, "¿Qué ventaja aporta PreparedStatement?", ["No ejecuta SQL", "Evita parámetros", "Parámetros tipados y ayuda contra inyección", "Solo sirve para DDL"], 2, "Permite placeholders y mejor seguridad."),
    q(8, "¿Cómo recorres filas de un ResultSet?", ["for clásico obligatorio", "while(rs.next())", "rs.iterate()", "nextRow()"], 1, "next avanza fila a fila."),
    q(9, "¿Qué cerrar al final de JDBC?", ["Solo ResultSet", "Solo Connection", "Recursos abiertos (ResultSet, Statement, Connection)", "Nada"], 2, "Cerrar todo para evitar fugas."),
    q(10, "¿Qué prefijo suele tener una URL JDBC?", ["sql://", "jdbc:", "db:", "java-db:"], 1, "Convención estándar de JDBC URL."),
  ];

  const ra9 = [
    q(1, "¿Qué librería Java se usa frecuentemente para JSON en este temario?", ["JUnit", "GSON", "Mockito", "Lombok"], 1, "GSON serializa/deserializa JSON."),
    q(2, "¿Qué anotación marca una entidad en ORM/Hibernate?", ["@Table", "@Entity", "@Column", "@Data"], 1, "@Entity indica clase persistente."),
    q(3, "¿HQL trabaja sobre...?", ["Tablas SQL directas", "Clases/propiedades de entidad", "Ficheros JSON", "XML DOM"], 1, "HQL opera con modelo de objetos."),
    q(4, "En JavaFX, ¿qué elemento representa la ventana principal?", ["Scene", "Stage", "Pane", "Node"], 1, "Stage es la ventana."),
    q(5, "¿Qué contiene los nodos visuales en JavaFX?", ["ResultSet", "Scene", "Thread", "Driver"], 1, "Scene contiene árbol de nodos."),
    q(6, "¿Qué convierte objeto Java a JSON con GSON?", ["toJson()", "parseJson()", "stringify()", "marshalJson()"], 0, "Gson#toJson serializa a texto JSON."),
    q(7, "¿Qué patrón relacional cubre ORM?", ["Objeto a texto", "Objeto a tabla", "String a bytes", "Clase a interfaz"], 1, "Mapea objetos a tablas/columnas."),
    q(8, "¿Qué consulta HQL válida conceptualmente?", ["SELECT * FROM alumno", "from AlumnoEntidad a where a.id > 0", "GET Alumno", "query AlumnoEntidad"], 1, "HQL usa nombres de entidad/campos."),
    q(9, "¿Qué componente JavaFX suele actuar como contenedor?", ["VBox", "SQLException", "ResultSet", "DriverManager"], 0, "VBox organiza nodos verticalmente."),
    q(10, "¿Qué describe mejor serialización JSON?", ["Compilar clases", "Convertir objetos a representación textual", "Ejecutar SQL", "Renderizar GUI"], 1, "JSON es formato textual de intercambio."),
  ];

  bancoOriginal.ra = { RA1: ra1, RA2: ra2, RA3: ra3, RA4: ra4, RA5: ra5, RA6: ra6, RA7: ra7, RA8: ra8, RA9: ra9 };
  bancoOriginal.all = [...ra1, ...ra2, ...ra3, ...ra4, ...ra5, ...ra6, ...ra7, ...ra8, ...ra9];
})();
