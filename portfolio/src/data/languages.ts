// Importación de la interfaz que define la estructura de datos.
import type { Language } from "../types";

// Importación de los iconos SVG como módulos ES6/Vite.
import javaIcon from "../assets/icons/java/java-original.svg";
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
        description: "Programación orientada a objetos (POO), Swing, JavaFX, JDBC, Spring y más",
        path: "/java"
    },

]
