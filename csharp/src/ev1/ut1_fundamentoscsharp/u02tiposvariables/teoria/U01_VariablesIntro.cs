/*
U01 — Variables y tipos basicos en C#.

En esta primera clase de variables aprenderemos los conceptos basicos:
¿como se declaran? ¿como funcionan? ¿que puedo guardar en ellas?

OBJETIVO:
  - Declarar variables con tipo explicito (int, double, string, bool, char).
  - Asignar valores y mostrarlos con Console.WriteLine.
  - Usar interpolacion $"..." para mezclar texto y variables.
  - Conocer camelCase como convencion de nombres en C#.

REGLAS:
  - Toda variable tiene un tipo fijo (a diferencia de Python).
  - Cada instruccion termina en punto y coma (;).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

// --- Datos de ejemplo de varios tipos ---
int numeroEntero = 14;
double numeroDecimal = 3.1416;
string cadenaTexto = "Agustín";
bool soyHumano = true;
bool hoyLunes = false;
char inicial = 'A';

// Variables de numeros enteros (int)
int edadProfesor = 26;
int dientes = 32;
int amigos = 5;

// Variables de numeros decimales (double)
double altura = 1.76;
double saldoBanco = 1250.35;
double precioHotDogCostco = 1.50;

// Variables de texto (string)
string diaSemana = "Martes";
string diaActual = "7";
string mesActual = "Julio";
string anioActual = "2026";

// Variables booleanas (bool)
bool lloviendo = false;
bool ganeLoteria = false;
bool tengoMascotas = true;

Console.WriteLine($"¡Soy tu profesor! Mi nombre es {cadenaTexto}, mucho gusto.\n");
Console.WriteLine($"Inicial del nombre: {inicial}\n");

Console.WriteLine("¡IMPRIMIENDO VARIABLES DE NÚMEROS ENTEROS!\n");
Console.WriteLine($"Tu profesor tiene {edadProfesor} años.");
Console.WriteLine($"Tu profesor tiene {dientes} dientes.");
Console.WriteLine($"Tu profesor tiene {amigos} amigos.\n");

Console.WriteLine("¡IMPRIMIENDO VARIABLES DE NÚMEROS DECIMALES!\n");
Console.WriteLine($"Tu profesor mide {altura} metros.");
Console.WriteLine($"Tu profesor tiene {saldoBanco} euros en el banco.");
Console.WriteLine($"Hot Dog en Costco: {precioHotDogCostco} euros.\n");

Console.WriteLine("¡IMPRIMIENDO VARIABLES DE TEXTO!\n");
// Concatenacion clasica con +
Console.WriteLine("Hoy es " + diaSemana + ", " + diaActual + " de " + mesActual + " del " + anioActual + ".");
// Misma idea con interpolacion (mas comoda)
Console.WriteLine($"Hoy es {diaSemana}, {diaActual} de {mesActual} del {anioActual}.");
Console.WriteLine($"El nombre de tu profesor es {cadenaTexto}.\n");

Console.WriteLine("¡IMPRIMIENDO VARIABLES BOOLEANAS!\n");
Console.WriteLine($"¿Hoy esta lloviendo? {lloviendo}");
Console.WriteLine($"¿Me he ganado la loteria? {ganeLoteria}");
Console.WriteLine($"¿Tengo mascotas? {tengoMascotas}");
Console.WriteLine($"¿Soy humano? {soyHumano} | ¿Hoy es lunes? {hoyLunes}");
Console.WriteLine($"Numero de ejemplo: {numeroEntero}, PI aproximado: {numeroDecimal}");

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");
