/**
 * Banco de preguntas sobre completar codigo JavaFX
 * Enfocado en lo que el programador escribe en Java, no en lo que hace SceneBuilder
 * Cada pregunta muestra codigo con espacios en blanco que deben completar
 */
const questionsCodigo = [
    {
        id: 1,
        question: "Completa la declaracion de la clase principal de JavaFX:",
        code: `public class HelloApplication _____ Application {
    @Override
    public void start(Stage stage) throws IOException {
        // ...
    }
}`,
        options: [
            "extends",
            "implements",
            "inherits",
            "imports"
        ],
        correct: 0,
        explanation: "Una clase que representa la aplicacion JavaFX debe extender (extends) de la clase Application. Es como decir 'mi clase es un tipo de Application', similar a como un perro 'es un' animal. Usamos extends porque Application es una clase, no una interfaz."
    },
    {
        id: 2,
        question: "¿Qué debe ir en el espacio en blanco para cargar un archivo FXML?",
        code: `FXMLLoader fxmlLoader = new FXMLLoader(
    HelloApplication.class._____("hello-view.fxml")
);`,
        options: [
            "getResource",
            "getFile",
            "loadFile",
            "openFile"
        ],
        correct: 0,
        explanation: "getResource() es el metodo que se usa para obtener la ruta del archivo FXML desde el classpath. Piensalo como pedirle direcciones a alguien: le dices el nombre del archivo y te devuelve la ruta completa para encontrarlo. Es la forma correcta de acceder a recursos dentro del proyecto."
    },
    {
        id: 3,
        question: "Completa el codigo para crear una Scene a partir del FXML cargado:",
        code: `FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
Scene scene = new Scene(_____._____, 320, 240);`,
        options: [
            "fxmlLoader.load()",
            "fxmlLoader.getScene()",
            "fxmlLoader.create()",
            "fxmlLoader.parse()"
        ],
        correct: 0,
        explanation: "fxmlLoader.load() carga y parsea el archivo FXML, devolviendo el Node raiz que se usa para crear la Scene. Es como abrir una caja: el FXML es la caja cerrada con instrucciones, load() la abre y construye todo lo que hay dentro, dandote el componente principal listo para usar."
    },
    {
        id: 4,
        question: "¿Qué metodos se deben llamar en el Stage para mostrar la ventana? (en orden)",
        code: `stage._____("Hello!");
stage._____(scene);
stage._____();`,
        options: [
            "setTitle, setScene, show",
            "setTitle, show, setScene",
            "show, setTitle, setScene",
            "setScene, setTitle, show"
        ],
        correct: 0,
        explanation: "Primero se establece el titulo con setTitle(), luego se asigna la Scene con setScene(), y finalmente se muestra con show(). Es como preparar una presentacion: primero pones el titulo en la pizarra, luego colocas el contenido, y al final abres las cortinas para que todos lo vean. Sin show(), la ventana existe pero esta invisible."
    },
    {
        id: 5,
        question: "Completa el metodo main para iniciar la aplicacion JavaFX:",
        code: `public static void main(String[] args) {
    _____;
}`,
        options: [
            "launch()",
            "start()",
            "Application.launch()",
            "Application.start()"
        ],
        correct: 0,
        explanation: "launch() es el metodo estatico de Application que inicia la aplicacion JavaFX. Se puede llamar directamente si la clase extiende Application. Es como el boton de encendido de un coche: aunque el coche este alli, hasta que no giras la llave (launch()), nada sucede. Este metodo prepara todo el entorno JavaFX antes de llamar a start()."
    },
    {
        id: 6,
        question: "¿Qué anotacion se usa para marcar un metodo que maneja eventos desde FXML?",
        code: `public class HelloController {
    _____
    protected void onHelloButtonClick() {
        // ...
    }
}`,
        options: [
            "@FXML",
            "@Override",
            "@EventHandler",
            "@Action"
        ],
        correct: 0,
        explanation: "@FXML se usa para marcar metodos que se asocian con eventos definidos en el archivo FXML (por ejemplo, onAction). Es como poner una etiqueta con tu nombre en la puerta: cuando alguien (el FXML) busca a quien llamar cuando pasa algo (un clic), sabe exactamente a que metodo ir gracias a esta anotacion."
    },
    {
        id: 7,
        question: "Completa el codigo para crear una nueva ventana (Stage) desde un controlador:",
        code: `@FXML
protected void onHelloButtonClick() {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("secundary-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        
        // Crear una nueva ventana
        Stage secondaryStage = _____;
        secondaryStage.setTitle("Formulario");
        secondaryStage.setScene(scene);
        secondaryStage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}`,
        options: [
            "new Stage()",
            "Stage.create()",
            "new Stage(scene)",
            "Application.createStage()"
        ],
        correct: 0,
        explanation: "Para crear una nueva ventana, se instancia un nuevo objeto Stage usando new Stage(). Cada ventana necesita su propio Stage, como cada habitacion necesita su propia puerta. No puedes reutilizar el Stage principal porque ya esta ocupado mostrando otra ventana."
    },
    {
        id: 8,
        question: "¿Qué debe implementar un controlador que necesita inicializar componentes despues de cargar el FXML?",
        code: `public class SecundaryController _____ Initializable {
    // ...
}`,
        options: [
            "implements",
            "extends",
            "imports",
            "uses"
        ],
        correct: 0,
        explanation: "Initializable es una interfaz, por lo que se usa implements. Esto permite ejecutar codigo cuando el FXML se ha cargado completamente. Es como firmar un contrato: al implementar Initializable, te comprometes a tener un metodo initialize(), y JavaFX te garantiza que lo llamara cuando todo este listo, como un cocinero que espera a que todos los ingredientes esten en la mesa antes de empezar a cocinar."
    },
    {
        id: 9,
        question: "Completa la firma del metodo initialize() de la interfaz Initializable:",
        code: `@Override
public void initialize(_____ url, _____ resourceBundle) {
    // ...
}`,
        options: [
            "URL, ResourceBundle",
            "String, String",
            "File, Properties",
            "Path, Bundle"
        ],
        correct: 0,
        explanation: "El metodo initialize() recibe dos parametros: URL (ubicacion del FXML) y ResourceBundle (recursos internacionalizados). Estos parametros son como informacion de contexto que JavaFX te pasa: la URL te dice de donde vino el FXML, y el ResourceBundle contiene textos traducidos si los necesitas. Aunque no siempre los uses, deben estar en la firma del metodo."
    },
    {
        id: 10,
        question: "¿Qué anotacion se usa para inyectar un componente FXML en un campo del controlador?",
        code: `public class SecundaryController implements Initializable {
    _____
    private ComboBox<String> comboBoxOpciones;
    
    // ...
}`,
        options: [
            "@FXML",
            "@Inject",
            "@Component",
            "@Bind"
        ],
        correct: 0,
        explanation: "@FXML se usa tanto para metodos como para campos. En campos, permite inyectar componentes definidos en el FXML mediante fx:id. Es como tener una caja fuerte con tu nombre: cuando JavaFX carga el FXML y encuentra un componente con fx:id='comboBoxOpciones', busca en tu clase un campo privado con @FXML y el mismo nombre, y automaticamente le asigna ese componente. Es magia, pero magia que tu defines."
    },
    {
        id: 11,
        question: "Completa el codigo para agregar elementos a un ComboBox en el metodo initialize():",
        code: `@Override
public void initialize(URL url, ResourceBundle resourceBundle) {
    comboBoxOpciones._____.addAll("Option A", "Option B", "Option C");
}`,
        options: [
            "getItems()",
            "getOptions()",
            "getList()",
            "getData()"
        ],
        correct: 0,
        explanation: "getItems() devuelve la ObservableList del ComboBox, sobre la cual se puede llamar addAll() para agregar multiples elementos. El ComboBox es como una caja con una lista dentro. getItems() te da acceso a esa lista, y addAll() te permite meter varios elementos de una vez, como llenar una cesta de la compra con varios productos a la vez."
    },
    {
        id: 12,
        question: "¿Qué excepcion debe capturarse al cargar archivos FXML?",
        code: `@FXML
protected void onHelloButtonClick() {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("secundary-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        // ...
    } catch (_____ e) {
        e.printStackTrace();
    }
}`,
        options: [
            "IOException",
            "FileNotFoundException",
            "FXMLLoadException",
            "Exception"
        ],
        correct: 0,
        explanation: "IOException es la excepcion que lanza FXMLLoader.load() cuando hay problemas al cargar el archivo FXML. Es como cuando intentas abrir una puerta y esta cerrada o la llave no funciona: algo salio mal al acceder al archivo. IOException es la forma generica de Java de decir 'hubo un problema leyendo/escribiendo archivos', y como el FXML es un archivo, esta es la excepcion correcta."
    },
    {
        id: 13,
        question: "Completa el codigo para establecer el titulo de una ventana secundaria:",
        code: `Stage secondaryStage = new Stage();
secondaryStage._____("Formulario");
secondaryStage.setScene(scene);
secondaryStage.show();`,
        options: [
            "setTitle",
            "setName",
            "setLabel",
            "setHeader"
        ],
        correct: 0,
        explanation: "setTitle() establece el titulo que aparece en la barra de titulo de la ventana. Es como ponerle un nombre a tu ventana, como cuando escribes el titulo en la portada de un cuaderno. Sin esto, la ventana apareceria sin nombre o con un nombre por defecto, lo cual no es muy profesional."
    },
    {
        id: 14,
        question: "¿Qué metodo se debe llamar en el Stage para hacer visible la ventana?",
        code: `stage.setTitle("Hello!");
stage.setScene(scene);
stage._____();`,
        options: [
            "show()",
            "display()",
            "visible()",
            "open()"
        ],
        correct: 0,
        explanation: "show() hace visible la ventana en pantalla. Sin este metodo, aunque el Stage este configurado, no se mostrara. Es como tener una obra de teatro completamente preparada pero con las cortinas cerradas: todo esta listo, los actores en posicion, pero el publico no ve nada hasta que alguien abre las cortinas. show() es quien abre esas cortinas."
    },
    {
        id: 15,
        question: "Completa la declaracion del metodo start() en una clase Application:",
        code: `@Override
public void start(_____ stage) _____ IOException {
    // ...
}`,
        options: [
            "Stage, throws",
            "Stage, throws new",
            "Application, throws",
            "Window, throws"
        ],
        correct: 0,
        explanation: "El metodo start() recibe un parametro Stage y puede lanzar IOException, por lo que debe declararse con throws IOException. Es como avisar antes de tiempo: 'oye, este metodo puede fallar al leer archivos, asi que preparate'. El throws es tu forma de advertir a quien llame a start() que debe estar preparado para manejar este error, porque cargar FXML puede fallar si el archivo no existe o esta corrupto."
    }
];

// Si estamos en un entorno Node.js, exportar el array de preguntas
if (typeof module !== 'undefined' && module.exports) {
    module.exports = questionsCodigo;
}

