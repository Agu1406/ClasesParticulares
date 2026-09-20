/*
U02 — Console.Write y Console.WriteLine.

OBJETIVO:
  - Diferenciar Write (sin salto de linea) y WriteLine (con salto de linea).
  - Usar secuencias de escape \n (salto) y \t (tabulador) dentro de cadenas.
  - Concatenar textos con el operador +.
  - Formatear mensajes con interpolacion de cadenas ($"...").

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - Write vs WriteLine.
  Write:     escribe en la misma linea, NO salta al final.
  WriteLine: escribe y luego pasa a la linea siguiente.
*/
Console.WriteLine("--- PRIMERA PARTE: Write vs WriteLine ---\n");

Console.Write("Hola ");
Console.Write("desde ");
Console.Write("Write");
Console.WriteLine(""); // WriteLine vacio fuerza el salto de linea final.

Console.WriteLine("Esta linea empieza en una fila nueva.");

Console.Write("A");
Console.Write("B");
Console.Write("C");
Console.WriteLine(" -> ABC en la misma linea, luego salto.");

/*
SEGUNDA PARTE - Secuencias de escape \n y \t.
  \n = nueva linea (como pulsar Enter).
  \t = tabulador (espaciado horizontal, util para alinear columnas).
  \\ = backslash literal (hay que escaparlo con otro backslash).
*/
Console.WriteLine("\n--- SEGUNDA PARTE: Secuencias de escape ---\n");

Console.WriteLine("Linea 1\nLinea 2\nLinea 3  (todo en un solo WriteLine)");

Console.WriteLine("Nombre\tEdad\tNota");
Console.WriteLine("Ana\t20\t8.5");
Console.WriteLine("Luis\t22\t7.0");
Console.WriteLine("Maria\t19\t9.2");

Console.WriteLine("Ruta: C:\\Users\\Alumno\\Documentos");

/*
TERCERA PARTE - Concatenacion con el operador +.
  Se pueden unir cadenas y convertir automaticamente numeros a texto.
  El operador + entre strings crea una cadena mas larga.
*/
Console.WriteLine("\n--- TERCERA PARTE: Concatenacion con + ---\n");

string nombre = "Carlos";
int edad = 25;
double nota = 8.75;

Console.WriteLine("Me llamo " + nombre + " y tengo " + edad + " años.");
Console.WriteLine("Mi nota es " + nota + " sobre 10.");
Console.WriteLine("Saludo: " + "Hola" + " " + "mundo" + "!");

// Concatenacion encadenada: se evalua de izquierda a derecha.
string mensaje = "FP" + " " + "DAM" + " " + "2025";
Console.WriteLine("Curso: " + mensaje);

/*
CUARTA PARTE - Interpolacion de cadenas con $.
  Forma moderna y mas legible: las variables van dentro de { }.
  Permite expresiones: {edad + 1}, {nota >= 5}, etc.
*/
Console.WriteLine("\n--- CUARTA PARTE: Interpolacion con $ ---\n");

Console.WriteLine($"Alumno: {nombre}, edad: {edad}, nota: {nota}");
Console.WriteLine($"El proximo año tendra {edad + 1} años.");
Console.WriteLine($"¿Aprobado? {(nota >= 5 ? "Si" : "No")}");

// Se puede mezclar texto fijo con variables de forma natural.
string ciudad = "Sevilla";
Console.WriteLine($"Vivo en {ciudad} y estudio {mensaje}.");

/*
QUINTA PARTE - Comparativa rapida: + vs $.
  Ambas formas producen el mismo resultado en pantalla.
  La interpolacion ($) suele ser mas clara cuando hay muchas variables.
*/
Console.WriteLine("\n--- QUINTA PARTE: + vs $ (mismo resultado) ---\n");

string resultadoMas = "Hola, " + nombre + "! Tienes " + edad + " años.";
string resultadoDolar = $"Hola, {nombre}! Tienes {edad} años.";

Console.WriteLine("Con +:  " + resultadoMas);
Console.WriteLine("Con $:  " + resultadoDolar);

if (resultadoMas == resultadoDolar)
{
    Console.WriteLine("Ambos mensajes son identicos.");
}

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");
