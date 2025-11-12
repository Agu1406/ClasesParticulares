# Sistema de Tests para JavaFX

Sistema de tests tipo Google Forms para preparar exámenes sobre JavaFX y Diseño de Interfaces.

## Como usar

1. Abrir el archivo principal:
   - Abre `index.html` en tu navegador
   - Veras una lista de tests disponibles con filtros por modo (Examen/Estudio)

2. Comenzar un test:
   - Haz clic en "Comenzar Test" en la tarjeta del test que quieras realizar
   - Responde todas las preguntas
   - Puedes navegar entre preguntas con los botones "Anterior" y "Siguiente"
   - Puedes cambiar tus respuestas en cualquier momento antes de enviar
   - Puedes cancelar el test en cualquier momento (con confirmación)

3. Modos de test:
   - **Modo Examen**: No recibes feedback hasta el final. Ideal para evaluarte.
   - **Modo Estudio**: Recibes feedback inmediato al responder cada pregunta. Ideal para aprender.

4. Enviar el test:
   - Cuando termines, haz clic en "Enviar Test" o "Ver Resumen"
   - Veras tus resultados con puntuacion total, porcentaje de aciertos, tiempo empleado, detalle de cada respuesta y explicaciones

## Estructura de archivos

```
tests/
├── index.html                    # Pagina principal con lista de tests
├── css/
│   └── styles.css                # Estilos tipo Google Forms
├── js/
│   ├── test.js                   # Logica del test modo examen (Test 1)
│   ├── test-estudio.js           # Logica del test modo estudio (Test 1)
│   ├── test-codigo.js            # Logica del test modo examen (Test 2)
│   ├── test-codigo-estudio.js    # Logica del test modo estudio (Test 2)
│   └── questions/
│       ├── javafx.js             # Banco de preguntas Test 1 (22 preguntas)
│       └── javafx-codigo.js      # Banco de preguntas Test 2 (15 preguntas)
├── tests/
│   └── javafx/
│       ├── test-javafx.html      # Test 1: Conceptos básicos (modo examen)
│       ├── test-javafx-estudio.html  # Test 1: Conceptos básicos (modo estudio)
│       ├── test-codigo.html      # Test 2: Completar código (modo examen)
│       └── test-codigo-estudio.html  # Test 2: Completar código (modo estudio)
└── README.md                     # Este archivo
```

## Caracteristicas

- Diseño responsive que funciona en movil y escritorio
- Dos modos: Examen (sin feedback) y Estudio (con feedback inmediato)
- Barra de progreso que muestra cuantas preguntas has respondido
- Navegacion entre preguntas (anterior/siguiente)
- Navegacion por teclado (flechas, números 1-4, Enter)
- Validacion de respuestas
- Resultados detallados con explicaciones de cada respuesta
- Explicaciones con metáforas y lenguaje humano para facilitar el aprendizaje
- Soporte para mostrar codigo en las preguntas
- Temporizador que muestra el tiempo empleado
- Boton de cancelar con confirmacion
- Filtros en la pagina principal para ver solo modo examen o estudio
- Accesibilidad: atributos ARIA y navegacion por teclado
- Facil de extender con mas preguntas

## Tests disponibles

### Test 1: Conceptos Básicos de JavaFX
- **22 preguntas** sobre Application, Stage, Scene, FXML y conceptos fundamentales
- Disponible en modo Examen y Estudio
- Tiempo estimado: ~25 minutos

### Test 2: Completar Código JavaFX
- **15 preguntas** para completar espacios en blanco del código
- Enfocado en lo que el programador escribe en Java (no FXML de SceneBuilder)
- Disponible en modo Examen y Estudio
- Tiempo estimado: ~20 minutos

## Agregar mas preguntas

Para agregar mas preguntas, edita el archivo correspondiente en `js/questions/`:

**Para Test 1 (Conceptos):** Edita `js/questions/javafx.js`

**Para Test 2 (Código):** Edita `js/questions/javafx-codigo.js`

Formato de pregunta:

```javascript
{
    id: 23,  // Siguiente numero disponible
    question: "Tu pregunta aqui?",
    options: [
        "Opcion 1",
        "Opcion 2",
        "Opcion 3",
        "Opcion 4"
    ],
    correct: 0,  // Indice de la respuesta correcta (0-3)
    explanation: "Explicacion tecnica. Es como una metafora para facilitar el aprendizaje.",
    code: "// Codigo opcional si la pregunta lo requiere"
}
```

## Personalizar colores

Puedes cambiar los colores editando las variables CSS en `css/styles.css`:

```css
:root {
    --primary-color: #4285f4;
    --secondary-color: #34a853;
    --danger-color: #ea4335;
    /* mas variables ... */
}
```

## Crear nuevos tests

1. Crea un nuevo archivo HTML en `tests/javafx/` (ej: `test-controllers.html`)
2. Copia la estructura de `test-javafx.html`
3. Crea un nuevo archivo JS con las preguntas en `js/questions/` (ej: `controllers.js`)
4. Crea un nuevo archivo JS con la logica en `js/` (ej: `test-controllers.js`)
5. Crea tambien la version estudio: `test-controllers-estudio.html` y `test-controllers-estudio.js`
6. Actualiza `index.html` para incluir el nuevo test (ambos modos)

## Tips para estudiar

- Lee bien cada pregunta y todas las opciones antes de responder
- Si hay codigo en la pregunta, analizalo linea por linea
- No te apresures, puedes cambiar respuestas antes de enviar
- Revisa las explicaciones despues del test para aprender de los errores
- Usa el modo Estudio para aprender y el modo Examen para evaluarte
- Las explicaciones incluyen metáforas para facilitar la comprensión

## Temas cubiertos

### Test 1: Conceptos Básicos de JavaFX
- Application y metodo start()
- @FXML y anotaciones
- Stage, Scene y Node
- Controles basicos (TextField, PasswordField, ComboBox, etc.)
- Controllers e Initializable
- FXMLLoader
- Layouts (VBox, HBox, GridPane, BorderPane)
- Navegacion entre ventanas
- Propiedades FXML (fx:id, fx:controller, onAction)

### Test 2: Completar Código JavaFX
- Declaracion de clases Application
- Uso de FXMLLoader y getResource()
- Creacion de Scene y Stage
- Metodo launch() y start()
- Anotaciones @FXML
- Implementacion de Initializable
- Manejo de excepciones (IOException)
- Metodos de Stage (setTitle, setScene, show)

## Contacto

Si tienes preguntas o sugerencias sobre estos tests, puedes contactarme a través de:
- GitHub: [@Agu1406](https://github.com/Agu1406)
- LinkedIn: [agustin6041](https://www.linkedin.com/in/agustin6041)
- Email: agu1406@outlook.es
