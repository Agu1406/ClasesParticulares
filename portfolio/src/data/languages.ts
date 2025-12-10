// Importación de la interfaz que define la estructura de datos.
import type { Language } from "../types";

// Importación de los iconos SVG como módulos ES6/Vite.
import javaIcon from "../assets/icons/java/java-original.svg";
import pythonIcon from "../assets/icons/python/python-original.svg";
import cIcon from "../assets/icons/c/c-original.svg";
import cppIcon from "../assets/icons/cplusplus/cplusplus-original.svg";
import phpIcon from "../assets/icons/php/php-original.svg";
import mysqlIcon from "../assets/icons/mysql/mysql-original.svg";
import kotlinIcon from "../assets/icons/kotlin/kotlin-original.svg";
import reactNativeIcon from "../assets/icons/reactnative/reactnative-original.svg";
import javascriptIcon from "../assets/icons/javascript/javascript-original.svg";
import html5Icon from "../assets/icons/html5/html5-original.svg";
import css3Icon from "../assets/icons/css3/css3-original.svg";
import typescriptIcon from "../assets/icons/typescript/typescript-original.svg";
import gradleIcon from "../assets/icons/gradle/gradle-original.svg";

/**
 * Creación de los datos asociados a las interfaces diseñadas y creadas
 * en el directorio de "types", puedes verlas en {@link Language} para
 * entender mejor su estructura y comportamiento.
 * 
 * Aqui he de crear los datos de todos los lenguajes que espero poder
 * compartir en mi sitio web de clases particulares, para ello usando
 * como guía los directorios de las clases que ya he dado hasta el
 * momento.
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 1.0.0
 * 
 * @see https://github.com/Agu1406/ClasesParticulares Repositorio GitHub
 * @see https://agu1406.github.io/ClasesParticulares GitHub Pages
 * */
export const languages: Language[] = [
    {
        id: "java",
        name: "Java",
        icon: javaIcon,
        description: "Programación orientada a objetos (POO), Swing, JavaFX, JDBC, multihilo, estructuras de datos",
        path: "/java"
    },
    {
        id: "python",
        name: "Python",
        icon: pythonIcon,
        description: "Sintaxis básica, POO, estructuras de datos (listas, tuplas, diccionarios), proyectos prácticos",
        path: "/python"
    },
    {
        id: "c",
        name: "C",
        icon: cIcon,
        description: "Programación estructurada, estructuras de datos, pilas, colas, registros, memoria dinámica",
        path: "/c"
    },
    {
        id: "cpp",
        name: "C++",
        icon: cppIcon,
        description: "Algoritmos, estructuras de datos, POO, gestión de proyectos, aplicaciones con CMake",
        path: "/cpp"
    },
    {
        id: "php",
        name: "PHP",
        icon: phpIcon,
        description: "Desarrollo web, formularios, bases de datos, arquitectura MVC y DAO, e-commerce",
        path: "/php"
    },
    {
        id: "sql",
        name: "SQL",
        icon: mysqlIcon,
        description: "Bases de datos MySQL, consultas, gestión de datos, operadores y funciones SQL",
        path: "/sql"
    },
    {
        id: "kotlin",
        name: "Kotlin",
        icon: kotlinIcon,
        description: "Desarrollo Android, SharedPreferences, SQLite, sistema de archivos, aplicaciones móviles",
        path: "/kotlin"
    },
    {
        id: "react-native",
        name: "React Native",
        icon: reactNativeIcon,
        description: "Desarrollo multiplataforma Android & iOS, Expo, TypeScript, componentes modernos",
        path: "/react-native"
    },
    {
        id: "javascript",
        name: "JavaScript",
        icon: javascriptIcon,
        description: "Desarrollo web, interactividad, maquetación y diseño responsive, frontend",
        path: "/javascript"
    },
    {
        id: "html5",
        name: "HTML5",
        icon: html5Icon,
        description: "Interfaces web, maquetación, estructura semántica, formularios interactivos",
        path: "/html5"
    },
    {
        id: "css3",
        name: "CSS3",
        icon: css3Icon,
        description: "Estilos reutilizables, diseño web, componentes compartidos, diseño responsive",
        path: "/css3"
    },
    {
        id: "typescript",
        name: "TypeScript",
        icon: typescriptIcon,
        description: "JavaScript con tipos estáticos, desarrollo moderno, React Native, proyectos escalables",
        path: "/typescript"
    },
    {
        id: "javafx",
        name: "JavaFX",
        icon: gradleIcon,
        description: "Interfaces gráficas de escritorio, FXML, controladores, aplicaciones con Gradle",
        path: "/javafx"
    }
]
