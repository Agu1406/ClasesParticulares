/*
U01 — Bucle for.

OBJETIVO:
  - Repetir un bloque un numero conocido de veces.
  - Sintaxis for (inicio; condicion; paso) — equivalente conceptual a range() en Python.
  - Recorrer un string caracter a caracter (foreach).
  - Acumular resultados y generar tablas de multiplicar.

Console.Write vs WriteLine (como end= en Python):
  - WriteLine termina con salto de linea.
  - Write deja el cursor en la misma linea: varias vueltas escriben "0 1 2 3".
  - Al acabar el bucle, WriteLine() fuerza el salto.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - Sintaxis for (inicio; condicion; paso).
*/
Console.WriteLine("¡PROBANDO EL BUCLE FOR CON NUMEROS!\n");

Console.WriteLine("¡Primer bucle - Numeros del 0 al 5!");
for (int numero = 0; numero <= 5; numero++)
{
    Console.WriteLine($"- {numero}");
}
Console.WriteLine();

Console.WriteLine("¡Segundo bucle - Numeros del 1 al 10!");
for (int numero = 1; numero <= 10; numero++)
{
    Console.WriteLine($"- {numero}");
}
Console.WriteLine();

Console.WriteLine("¡Tercer bucle - Pares del 2 al 10!");
for (int numero = 2; numero <= 10; numero += 2)
{
    Console.WriteLine($"- {numero}");
}
Console.WriteLine();

/*
SEGUNDA PARTE - Recorrer cadenas (foreach, como for letra in cadena).
*/
Console.WriteLine("¡PROBANDO EL BUCLE CON CADENAS!\n");
string nombre = "Agustín";

Console.WriteLine($"¡Letras del nombre \"{nombre}\"!");
foreach (char letra in nombre)
{
    Console.WriteLine($"- {letra}");
}
Console.WriteLine();

Console.WriteLine("¡Letras en la misma linea!");
foreach (char letra in nombre)
{
    Console.Write($"{letra} ");
}
Console.WriteLine("\n");

/*
TERCERA PARTE - Acumuladores y tablas.
*/
Console.WriteLine("¡ACUMULADORES Y TABLAS!\n");

int total = 0;
Console.WriteLine("¡Sumando del 1 al 10!");
for (int i = 1; i <= 10; i++)
{
    total += i;
}
Console.WriteLine($"¡Suma del 1 al 10 = {total}!\n");

Console.WriteLine("¡Tabla de multiplicar del 7!");
for (int i = 1; i <= 10; i++)
{
    Console.WriteLine($"7 x {i} = {7 * i}");
}

Console.Write("\nNumeros en una linea (Write): ");
for (int i = 1; i <= 5; i++)
{
    Console.Write($"{i} ");
}
Console.WriteLine();

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");
