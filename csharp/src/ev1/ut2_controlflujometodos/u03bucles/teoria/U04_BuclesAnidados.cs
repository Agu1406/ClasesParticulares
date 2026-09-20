/*
U04 — Bucles anidados: un bucle dentro de otro.

OBJETIVO:
  - Combinar for externo e interno para tablas y patrones.
  - Dibujar un triangulo de asteriscos con bucles anidados.
  - Generar una tabla de multiplicar completa (filas y columnas).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - Tabla de multiplicar 3x3 (filas x columnas).
  Bucle externo = filas; bucle interno = columnas.
*/
Console.WriteLine("¡DEMO 1: TABLA 3x3!\n");

for (int fila = 1; fila <= 3; fila++)
{
    for (int col = 1; col <= 3; col++)
    {
        Console.Write($"{fila}x{col}={fila * col,3}  ");
    }
    Console.WriteLine();
}

/*
SEGUNDA PARTE - Triangulo de asteriscos.
  Fila 1 imprime 1 *, fila 2 imprime 2 *, etc.
*/
Console.WriteLine("\n¡DEMO 2: TRIANGULO DE ASTERISCOS!\n");

int altura = 5;
for (int fila = 1; fila <= altura; fila++)
{
    for (int estrella = 1; estrella <= fila; estrella++)
    {
        Console.Write("* ");
    }
    Console.WriteLine();
}

/*
TERCERA PARTE - Tabla de multiplicar del 1 al 5 (formato compacto).
*/
Console.WriteLine("\n¡DEMO 3: TABLA COMPLETA 1-5!\n");

Console.Write("    |");
for (int cab = 1; cab <= 5; cab++)
{
    Console.Write($"{cab,4}");
}
Console.WriteLine();
Console.WriteLine("----+----");

for (int i = 1; i <= 5; i++)
{
    Console.Write($"{i,3} |");
    for (int j = 1; j <= 5; j++)
    {
        Console.Write($"{i * j,4}");
    }
    Console.WriteLine();
}

/*
CUARTA PARTE - Patron de numeros: cada fila repite su numero.
*/
Console.WriteLine("\n¡DEMO 4: PATRON NUMERICO!\n");

for (int f = 1; f <= 4; f++)
{
    for (int c = 1; c <= f; c++)
    {
        Console.Write($"{f} ");
    }
    Console.WriteLine();
}

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");
