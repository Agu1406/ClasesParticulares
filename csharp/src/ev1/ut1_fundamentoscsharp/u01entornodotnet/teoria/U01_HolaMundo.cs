/*
U01 — Primer programa en C#.

OBJETIVO:
  - Conocer la estructura minima de un programa con sentencias de nivel superior.
  - Usar Console.WriteLine para mostrar texto en la consola.
  - Entender que cada instruccion termina con punto y coma (;).
  - Diferenciar instrucciones ejecutables de comentarios explicativos.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - El clasico "Hola Mundo".
  En C# moderno (.NET 6+) podemos escribir instrucciones directamente
  en el archivo, sin crear una clase Program ni un metodo Main.
  Esto se llama "top-level statements" (sentencias de nivel superior).
*/
Console.WriteLine("--- PRIMERA PARTE: Hola Mundo ---\n");

// WriteLine: escribe el texto y salta a la siguiente linea automaticamente.
Console.WriteLine("Hola Mundo");

// Cada instruccion termina con punto y coma. Sin el ; el compilador da error.
Console.WriteLine("Bienvenido a C#");

/*
SEGUNDA PARTE - Varias instrucciones en secuencia.
  El programa se ejecuta de arriba a abajo, linea a linea.
  Cada WriteLine es una instruccion independiente.
*/
Console.WriteLine("\n--- SEGUNDA PARTE: Varias lineas de salida ---\n");

Console.WriteLine("Linea 1: Aprendiendo C#");
Console.WriteLine("Linea 2: Paso a paso");
Console.WriteLine("Linea 3: Con ejemplos claros");

/*
TERCERA PARTE - Texto entre comillas y caracteres especiales.
  Las cadenas van entre comillas dobles " ".
  Para mostrar comillas dentro del texto, se escapan con backslash \".
*/
Console.WriteLine("\n--- TERCERA PARTE: Comillas y mensajes variados ---\n");

Console.WriteLine("El lenguaje se llama \"C#\" (con almohadilla).");
Console.WriteLine("FP = Formacion Profesional");
Console.WriteLine("¡Este mensaje lleva signos de exclamacion!");

/*
CUARTA PARTE - Comentarios: el compilador los ignora.
  Los comentarios de una linea empiezan con //
  Los comentarios de bloque van entre /* y * / (sin espacio entre * y /).
  Sirven para explicar el codigo a otros programadores (o a ti mismo).
*/
Console.WriteLine("\n--- CUARTA PARTE: Comentarios vs codigo ejecutable ---\n");

// Este comentario NO se ejecuta; solo documenta la siguiente linea.
Console.WriteLine("Solo las instrucciones sin // se ejecutan.");

/*
   Este bloque multilinea tampoco se ejecuta.
   Puede ocupar varias lineas sin problema.
*/
Console.WriteLine("Los comentarios no cambian el comportamiento del programa.");

/*
QUINTA PARTE - Estructura minima de un programa didactico.
  Patron habitual en este repositorio:
    1) Cabecera con objetivos (bloque /* al inicio del archivo).
    2) Mensaje de inicio.
    3) Demos organizadas por partes.
    4) Mensaje de fin.
*/
Console.WriteLine("\n--- QUINTA PARTE: Resumen de estructura ---\n");

Console.WriteLine("Un programa C# minimo necesita:");
Console.WriteLine("  - Instrucciones que hagan algo (Console.WriteLine, etc.).");
Console.WriteLine("  - Punto y coma al final de cada instruccion.");
Console.WriteLine("  - Comentarios opcionales para explicar el codigo.");

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");
