/**
 * Los tipos permiten definir los datos/campos que componen los diferentes objetos
 * que emplea mi SPA para definir el contenido de si misma, soy un fanatico de la
 * documentación aunque muchas personas crean que está mal, puedes consultar más
 * del proyecto desde los siguientes enlaces:
 * 
 * @see https://github.com/Agu1406/ClasesParticulares Repositorio GitHub
 * @see https://agu1406.github.io/ClasesParticulares GitHub Pages
 */

/**
 * Intefaz utilizada para definir el conjunto de datos que definen la esructura
 * de un leguaje de programación, con los siguientes campos:
 * 
 * - ID: Identificador unico de cada lenguaje, normalmente, su nombre.
 * - name: Nombre completo del lenguaje de programación.
 * - icon: Icono alojado en Assets en forma de ruta relativa.
 * - description: Descripción completa del lenguaje de programación.
 * - path: URL/RUTA interna del lenguaje de programación.
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 1.0.0
 * */
export interface Language {
    id: string;
    name: string;
    icon: string;
    description: string;
    path: string;
}

/**
 * Intefaz utilizada para definir el conjunto de datos que definen la esructura
 * de un ejercicio (archivo descargable) de un leguaje de programación, con los 
 * siguientes campos:
 * 
 * - ID: Identificador unico e intenro de cada ejercicio.
 * - Title: Titulo del ejercicio disponible (ID más humano).
 * - File: URL/RUTA del archivo/pdf descargable del ejercicio.
 * - Language: Relación de los ejercicios con un "Language".
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 1.0.0
 */
export interface Exercise {
    id: string;
    title: string;
    file: string;
    language: string;
}
/**
 * Intefaz utilizada para definir el conjunto de datos que definen la esructura
 * de una lección de un leguaje de programación, con los siguientes campos:
 * 
 * - ID: Identificador unico e intenro de cada lección.
 * - languageId: Asocia la lección con un lenguaje especifico.
 * - title: Titulo descriptivo de la lección.
 * - description: Descripción completa y detallada de la sección.
 * - part: Número que identifica cual de las lecciones es, ejemplo "2" de "40".
 * - totalParts: Indica la cantidad total de lecciones disponibles.
 * - content: define el contenido complet de la lección, es un Array con el siguiente contenido:
 *      1) sections (Array): Contiene la teoría y ejemplos de código de la lección.
 *          A) title: titulo no de la lección, si no de la teoría.
 *          B) icon: URL/RUTA relativa al icono estetico que acompaña al titulo.
 *          C) content: teoría explicativa de la lección.
 *          D) code: En caso de existir, ejemplos con código de la lección.
 *          E) codeLanguage: Si existe "code" esto define de que lenguaje es el ejemplo.
 *      2) exercises (Array): Contiene los ejercicios descargables de la lección.
 *          A) id: Identificador unico del ejercicio.
 *          B) title: Titulo explicativo del ejercicio.
 *      3) pdfUrl: Enlace de descarga de PDF's con ejercicios de la lección.
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 1.0.0
 */
export interface Lesson {
    id: string; // ID unico de la lección, aún no lo defino, se me ocurren cosas como "JAVALESSON1".
    languageId: string; // identificador del lenguaje al que pertenece la lección.
    title: string; // Titulo de la lección, ejemplo: "Lección 1 - Equis, Ye, Zeta..."
    description: string; // Descripción de la lección, ejemplo "Aquí aprendemores esto, aquello y lo otro."
    part: number; // Las lecciones son finitas, está indica cual es, si la primera, segunda, ultima, etc.
    totalParts: number; // Indicador de cuantas lecciones hay disponibles del lenguaje.
    /**
     * Aquí viene una de las cosas más complejas (hasta ahora) que he tenido que diseñar porque la IA
     * me recomendaba cosas muy raras y complejas o viceversa, cosas nada escalables.
     * 
     * Todas las lecciones tienen más o menos el mismo contenido.
     * 
     * Seccion 1: Teoría explicanda con texto y ejemplos de código.
     * Sección 2: Ejercicios correspondientes a la teoría dada.
     * Sección 3: (Opcional) enlaces de descarga de PDF's con ejercicios teoricos y/o practicos.
     * 
     * Dentor de la sección 1 se pueden crear tantas sub-secciones internas como haga falta, por lo tanto
     * es un Array que contiene varias secciones.
     */
    content: {
        // He aquí las que pueden ser una o varias secciones de teoría con ejemplos de código.
        sections: Array<{
            title: string; // Todas las lecciones deben tener un titulo.
            icon?: string; // Los iconos no son obligatorios, son meramente esteticos.
            content: string; // Todas las lecciones deben tener un contenido escrito.
            code?: string; // Los ejemplos de código no son obligatorios.
            codeLanguage?: string; // Esto define los estilos del "code" en caso de usarse, es opcional.
        }>
        // Luego vienen los ejercicios, siempre debe haberlos, aunque sean teoricos, para reforzar.
        exercises: Array<{
            id: string; // Ejemplos, "ejercicio1, ejercicio2, etc"
            title: string; // Titulo del objetivo del ejercicio.
            completed?: boolean; // Opcional: indica si el ejercicio está marcado como completado (solo UI).
        }>
        // Finalmente (opcional) las URL's de descarga de los documentos de ejercicios.
        pdfUrl?: string;
    }
}