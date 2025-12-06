/**
 * - ID: Identificador interno y unico de cada lenguaje.
 * - Name: Una versión más "amable y humana" del ID para el usuario.
 * - Icon: URL/RUTA del icono/imagén relacionado con ese lenguaje.
 * - Description: Descripción corta del lenguaje y el material ofrecido.
 * - Path: URL especifica del lenguaje, ejemplo "/java".
 */
export interface Language {
    id: string;
    name: string;
    icon: string;
    description: string;
    path: string;
}

/**
 * La relacion de ejercicios a lenguajes es de 1:N, es decir,
 * un lenguaje puede tener varios ejercicios, varios ejercicios
 * pueden pertenecer al mismo lenguaje, para establecer la
 * relación usamos el campo "Lenguage" que referencia directamente
 * al campo "ID" de la interfaces "Lenguage".
 * 
 * - ID: Identificador unico e intenro de cada ejercicio.
 * - Title: Titulo del ejercicio disponible (ID más humano).
 * - File: URL/RUTA del archivo/pdf descargable del ejercicio.
 * - Language: Relación de los ejercicios con un "Language".
 */
export interface Exercise {
    id: string;
    title: string;
    file: string;
    language: string;
}