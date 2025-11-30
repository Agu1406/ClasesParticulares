/**
 * Interfaz que representa un lenguaje o framework de programación.
 * Define la estructura de datos para los lenguajes disponibles en la plataforma.
 * 
 * - ID: Identificador interno y unico de cada lenguaje.
 * - Name: Una versión más "amable y humana" del ID para el usuario.
 * - Icon: URL/RUTA del icono/imagén relacionado con ese lenguaje.
 * - Description: Descripción corta del lenguaje y el material ofrecido.
 * - Path: URL especifica del lenguaje, ejemplo "/java".
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 1.0.0
 * 
 * @see https://github.com/Agu1406/ClasesParticulares Repositorio GitHub
 * @see https://agu1406.github.io/ClasesParticulares GitHub Pages
 */
export interface Language {
    id: string;
    name: string;
    icon: string;
    description: string;
    path: string;
}

/**
 * Interfaz que representa un ejercicio de programación.
 * La relación de ejercicios a lenguajes es de 1:N, es decir,
 * un lenguaje puede tener varios ejercicios, varios ejercicios
 * pueden pertenecer al mismo lenguaje. Para establecer la
 * relación usamos el campo "language" que referencia directamente
 * al campo "id" de la interfaz "Language".
 * 
 * - ID: Identificador unico e intenro de cada ejercicio.
 * - Title: Titulo del ejercicio disponible (ID más humano).
 * - File: URL/RUTA del archivo/pdf descargable del ejercicio.
 * - Language: Relación de los ejercicios con un "Language".
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 1.0.0
 * 
 * @see https://github.com/Agu1406/ClasesParticulares Repositorio GitHub
 * @see https://agu1406.github.io/ClasesParticulares GitHub Pages
 */
export interface Exercise {
    id: string;
    title: string;
    file: string;
    language: string;
}