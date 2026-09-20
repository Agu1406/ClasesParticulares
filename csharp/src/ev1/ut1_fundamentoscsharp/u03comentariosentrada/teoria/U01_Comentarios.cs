/*
U01 — Comentarios en C#.

OBJETIVO:
  - Escribir comentarios de una linea con //.
  - Escribir comentarios de varias lineas con bloques multilinea.
  - Entender que los comentarios NO se ejecutan ni afectan al programa.
  - Evitar anidar bloques multilinea incorrectamente (reglas de anidamiento).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - Comentarios de una linea con //.
  Todo lo que va despues de // en esa misma linea es un comentario.
  El compilador lo ignora por completo.
*/
Console.WriteLine("--- PRIMERA PARTE: Comentarios // ---\n");

// Este comentario explica la siguiente instruccion.
Console.WriteLine("Los comentarios // no aparecen en la consola.");

int a = 10; // Variable entera con valor inicial 10.
int b = 20; // Otra variable; el codigo ejecutable va ANTES del //.

// Se pueden poner varios comentarios seguidos:
// Linea 1 del comentario dividido.
// Linea 2 del comentario dividido.
Console.WriteLine("a = " + a + ", b = " + b);

// SEGUNDA PARTE - Comentarios de bloque (multilinea).
// Permiten comentar varias lineas de una vez.
// Se abren con barra-asterisco y se cierran con asterisco-barra.
//
// IMPORTANTE sobre anidamiento:
// - NO se pueden anidar bloques multilinea dentro de otro bloque.
// - El primer cierre (asterisco-barra) termina el bloque aunque quede texto.
// - Si necesitas comentar codigo que ya contiene cierres, usa // linea a linea.
// - Los comentarios // SI se pueden usar dentro de un bloque multilinea.
Console.WriteLine("\n--- SEGUNDA PARTE: Comentarios de bloque ---\n");

/*
   Este bloque ocupa tres lineas.
   El compilador ignora todo el contenido.
   Util para explicar un algoritmo completo.
*/
Console.WriteLine("El bloque multilinea no se ejecuta.");

/*
   Ejemplo de mezcla segura:
   // Este comentario de linea vive DENTRO del bloque multilinea.
   // Eso es perfectamente valido en C#.
*/
int suma = 2 + 3; // resultado esperado: 5
Console.WriteLine("Suma = " + suma);

/*
TERCERA PARTE - Comentarios al final de linea (inline).
  Muy habitual para aclarar una variable o una formula concreta.
*/
Console.WriteLine("\n--- TERCERA PARTE: Comentarios inline ---\n");

double precio = 19.99;        // precio base del producto en euros
const double IVA = 0.21;        // tipo de IVA aplicable (21 %)
double total = precio * (1 + IVA); // precio final con impuesto incluido

Console.WriteLine("Precio base: " + precio);
Console.WriteLine("Total con IVA: " + total);

/*
CUARTA PARTE - Comentarios para documentar secciones del codigo.
  En programas didacticos usamos bloques multilinea para marcar cada demo.
  En proyectos reales, los comentarios explican el "por que", no el "que".
*/
Console.WriteLine("\n--- CUARTA PARTE: Documentar secciones ---\n");

// --- Demo de operaciones basicas ---
int x = 7;
int y = 3;
int producto = x * y; // multiplicacion de enteros

Console.WriteLine($"{x} x {y} = {producto}");

// QUINTA PARTE - Que NO hacer con comentarios.
// - No comentar codigo obvio (innecesario repetir lo evidente).
// - No anidar bloques multilinea: el compilador dara error.
// - No confundir comentarios con cadenas entre comillas dobles.
Console.WriteLine("\n--- QUINTA PARTE: Buenas practicas ---\n");

Console.WriteLine("Comentarios utiles = explican decisiones o formulas.");
Console.WriteLine("Comentarios inutiles = repiten lo que ya dice el codigo.");

// Cadena de texto: las comillas dobles forman un string, NO un comentario.
string frase = "Esto se ejecuta y se muestra";
Console.WriteLine(frase);

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");
