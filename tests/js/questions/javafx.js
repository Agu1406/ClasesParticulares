/**
 * Banco de preguntas sobre JavaFX y Diseño de Interfaces
 * Cada pregunta tiene:
 * - id: identificador unico
 * - question: texto de la pregunta
 * - options: array con las 4 opciones de respuesta
 * - correct: indice de la respuesta correcta (0-3)
 * - explanation: explicacion de por que esa es la respuesta correcta
 * - code: (opcional) codigo de ejemplo si la pregunta lo requiere
 */
const questions = [
    {
        id: 1,
        question: "¿Qué método debe implementar obligatoriamente una clase que extiende de Application en JavaFX?",
        options: [
            "start(Stage stage)",
            "init()",
            "main(String[] args)",
            "launch()"
        ],
        correct: 0,
        explanation: "El método start(Stage stage) es el único método abstracto de la clase Application y debe ser implementado obligatoriamente."
    },
    {
        id: 2,
        question: "¿Para qué se utiliza la anotación @FXML en JavaFX?",
        options: [
            "Para marcar métodos que se ejecutan automáticamente",
            "Para inyectar componentes del archivo FXML en el controlador",
            "Para indicar que un método es público",
            "Para crear nuevos componentes gráficos"
        ],
        correct: 1,
        explanation: "@FXML se utiliza para inyectar componentes definidos en el archivo FXML (como TextField, Button, etc.) en los campos del controlador."
    },
    {
        id: 3,
        question: "¿Qué representa un Stage en JavaFX?",
        options: [
            "Una escena completa de la aplicación",
            "Una ventana o contenedor de nivel superior",
            "Un componente gráfico individual",
            "Un archivo de configuración"
        ],
        correct: 1,
        explanation: "Stage representa una ventana de la aplicación. Es el contenedor de nivel superior que contiene las Scene."
    },
    {
        id: 4,
        question: "¿Cuál es la diferencia principal entre TextField y PasswordField?",
        options: [
            "PasswordField solo acepta números",
            "PasswordField oculta los caracteres escritos",
            "TextField no permite edición",
            "No hay diferencia, son iguales"
        ],
        correct: 1,
        explanation: "PasswordField oculta los caracteres escritos mostrándolos como puntos o asteriscos, mientras que TextField muestra el texto normalmente."
    },
    {
        id: 5,
        question: "¿Qué hace el método initialize() de la interfaz Initializable?",
        options: [
            "Inicializa la aplicación completa",
            "Se ejecuta después de que se cargan todos los componentes FXML",
            "Crea nuevos componentes gráficos",
            "Cierra la ventana"
        ],
        correct: 1,
        explanation: "initialize() se ejecuta automáticamente después de que FXMLLoader carga el FXML y todos los componentes están listos para ser utilizados."
    },
    {
        id: 6,
        question: "En el siguiente código, ¿qué hace FXMLLoader?",
        code: `FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
Scene scene = new Scene(fxmlLoader.load(), 320, 240);`,
        options: [
            "Crea una nueva ventana",
            "Carga y parsea el archivo FXML para crear la jerarquía de componentes",
            "Cierra la aplicación",
            "Guarda los datos del formulario"
        ],
        correct: 1,
        explanation: "FXMLLoader carga el archivo FXML, lo parsea y crea la jerarquía de componentes JavaFX definidos en el archivo."
    },
    {
        id: 7,
        question: "¿Qué atributo FXML se utiliza para asociar un componente con un campo del controlador?",
        options: [
            "fx:controller",
            "fx:id",
            "onAction",
            "fx:name"
        ],
        correct: 1,
        explanation: "fx:id se utiliza para dar un identificador único a un componente, permitiendo que sea inyectado en el controlador mediante @FXML."
    },
    {
        id: 8,
        question: "¿Cuál es la función principal de un Scene en JavaFX?",
        options: [
            "Representar una ventana completa",
            "Contener todos los componentes gráficos (Nodes) de una pantalla",
            "Manejar eventos del usuario",
            "Gestionar la base de datos"
        ],
        correct: 1,
        explanation: "Scene es el contenedor para todos los componentes gráficos (Nodes) que forman parte de una pantalla. Un Stage puede tener múltiples Scene."
    },
    {
        id: 9,
        question: "Si queremos abrir una segunda ventana en JavaFX, ¿qué debemos hacer?",
        options: [
            "Llamar a show() en el mismo Stage",
            "Crear un nuevo objeto Stage y asignarle una Scene",
            "Usar el método openNewWindow()",
            "No es posible abrir múltiples ventanas"
        ],
        correct: 1,
        explanation: "Para abrir una segunda ventana, debemos crear un nuevo objeto Stage, asignarle una Scene y llamar a show()."
    },
    {
        id: 10,
        question: "¿Qué layout se utiliza cuando queremos organizar componentes en filas y columnas?",
        options: [
            "VBox",
            "HBox",
            "GridPane",
            "BorderPane"
        ],
        correct: 2,
        explanation: "GridPane permite organizar componentes en una cuadrícula de filas y columnas, ideal para formularios estructurados."
    },
    {
        id: 11,
        question: "En el archivo FXML, ¿qué atributo se usa para asociar un controlador a la vista?",
        options: [
            "fx:id=\"controller\"",
            "fx:controller=\"package.ClassName\"",
            "controller=\"ClassName\"",
            "fx:handler=\"controller\""
        ],
        correct: 1,
        explanation: "fx:controller especifica la clase controladora que manejará los eventos y componentes de esa vista FXML."
    },
    {
        id: 12,
        question: "¿Qué método se utiliza para agregar elementos a un ComboBox en JavaFX?",
        options: [
            "addItem()",
            "getItems().add() o getItems().addAll()",
            "setItems()",
            "insertItem()"
        ],
        correct: 1,
        explanation: "Para agregar elementos a un ComboBox, se accede a su ObservableList mediante getItems() y se usa add() o addAll()."
    },
    {
        id: 13,
        question: "¿Cuál es la diferencia entre VBox y HBox?",
        options: [
            "VBox organiza componentes verticalmente, HBox horizontalmente",
            "VBox es para texto, HBox para imágenes",
            "No hay diferencia",
            "VBox organiza horizontalmente, HBox verticalmente"
        ],
        correct: 0,
        explanation: "VBox (Vertical Box) organiza componentes en una columna vertical, mientras que HBox (Horizontal Box) los organiza en una fila horizontal."
    },
    {
        id: 14,
        question: "¿Qué hace el método stage.show()?",
        options: [
            "Oculta la ventana",
            "Muestra la ventana en pantalla",
            "Cierra la aplicación",
            "Actualiza los componentes"
        ],
        correct: 1,
        explanation: "stage.show() hace visible la ventana (Stage) en pantalla. Sin este método, la ventana no se mostrará aunque esté creada."
    },
    {
        id: 15,
        question: "Si un controlador implementa Initializable, ¿cuándo se ejecuta el método initialize()?",
        options: [
            "Antes de cargar el FXML",
            "Después de cargar el FXML y antes de mostrar la ventana",
            "Solo cuando el usuario hace clic en un botón",
            "Nunca se ejecuta automáticamente"
        ],
        correct: 1,
        explanation: "initialize() se ejecuta automáticamente después de que FXMLLoader carga el FXML y todos los componentes @FXML están inyectados, pero antes de mostrar la ventana."
    },
    {
        id: 16,
        question: "¿Qué atributo FXML se utiliza para asociar un método del controlador con un evento de clic en un botón?",
        options: [
            "fx:action",
            "onAction",
            "fx:onClick",
            "actionHandler"
        ],
        correct: 1,
        explanation: "onAction es el atributo FXML que se usa para asociar un método del controlador con el evento de clic de un botón. El método debe estar marcado con @FXML."
    },
    {
        id: 17,
        question: "¿Qué layout divide la ventana en cinco áreas: top, bottom, left, right y center?",
        options: [
            "GridPane",
            "VBox",
            "BorderPane",
            "HBox"
        ],
        correct: 2,
        explanation: "BorderPane divide la ventana en cinco áreas predefinidas: top (arriba), bottom (abajo), left (izquierda), right (derecha) y center (centro)."
    },
    {
        id: 18,
        question: "¿Cuál es la diferencia entre TextField y TextArea?",
        options: [
            "TextField es para una línea, TextArea para múltiples líneas",
            "TextField es para números, TextArea para texto",
            "No hay diferencia",
            "TextField es más grande que TextArea"
        ],
        correct: 0,
        explanation: "TextField es un control de una sola línea para entrada de texto corto, mientras que TextArea permite múltiples líneas y es ideal para texto largo o comentarios."
    },
    {
        id: 19,
        question: "¿Qué componente se utiliza para mostrar texto que el usuario no puede editar?",
        options: [
            "TextField",
            "TextArea",
            "Label",
            "Button"
        ],
        correct: 2,
        explanation: "Label se utiliza para mostrar texto estático que el usuario no puede editar. Es útil para etiquetas, títulos o información de solo lectura."
    },
    {
        id: 20,
        question: "¿Cuál es la diferencia entre RadioButton y CheckBox?",
        options: [
            "RadioButton permite múltiples selecciones, CheckBox solo una",
            "RadioButton permite una sola selección en un grupo, CheckBox permite múltiples selecciones independientes",
            "No hay diferencia",
            "RadioButton es para texto, CheckBox para números"
        ],
        correct: 1,
        explanation: "RadioButton permite seleccionar una sola opción dentro de un grupo (ToggleGroup), mientras que CheckBox permite seleccionar múltiples opciones de forma independiente."
    },
    {
        id: 21,
        question: "En el siguiente código FXML, ¿qué hace el atributo onAction?",
        code: `<Button onAction="#onHelloButtonClick" text="¡Abrir formulario!" />`,
        options: [
            "Define el texto del botón",
            "Asocia el método onHelloButtonClick del controlador con el evento de clic",
            "Crea un nuevo botón",
            "Oculta el botón"
        ],
        correct: 1,
        explanation: "onAction asocia el método onHelloButtonClick (que debe existir en el controlador marcado con @FXML) con el evento de clic del botón."
    },
    {
        id: 22,
        question: "¿Qué clase se utiliza para definir márgenes y espaciado interno en layouts de JavaFX?",
        options: [
            "Margin",
            "Padding",
            "Insets",
            "Spacing"
        ],
        correct: 2,
        explanation: "Insets se utiliza para definir el espaciado interno (padding) de los layouts. Se puede usar en VBox, HBox, GridPane, etc."
    }
];

// Si estamos en un entorno Node.js, exportar el array de preguntas
// Esto es util si en el futuro queremos usar estas preguntas en otro contexto
if (typeof module !== 'undefined' && module.exports) {
    module.exports = questions;
}

