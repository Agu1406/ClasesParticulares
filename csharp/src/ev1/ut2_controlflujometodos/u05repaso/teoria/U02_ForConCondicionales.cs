/*
U02 — Combinar bucle for con condicionales if.

OBJETIVO:
  - Filtrar numeros dentro de un for (pares, multiplos, rangos).
  - Clasificar cada elemento de una secuencia con if/else if.
  - Contar cuantos elementos cumplen una condicion.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - Imprimir solo pares del 1 al 20.
*/
Console.WriteLine("¡DEMO 1: SOLO PARES!\n");

Console.Write("Pares 1-20: ");
for (int i = 1; i <= 20; i++)
{
    if (i % 2 == 0)
    {
        Console.Write($"{i} ");
    }
}
Console.WriteLine("\n");

/*
SEGUNDA PARTE - Clasificar notas simuladas sin arrays.
*/
Console.WriteLine("¡DEMO 2: CLASIFICAR NOTAS!\n");

int nota1 = 3;
int nota2 = 5;
int nota3 = 7;
int nota4 = 9;
int nota5 = 10;
int nota6 = 4;
int nota7 = 6;

MostrarClasificacion(nota1);
MostrarClasificacion(nota2);
MostrarClasificacion(nota3);
MostrarClasificacion(nota4);
MostrarClasificacion(nota5);
MostrarClasificacion(nota6);
MostrarClasificacion(nota7);

/*
TERCERA PARTE - Contar multiplos de 3 entre 1 y 30.
*/
Console.WriteLine("\n¡DEMO 3: CONTAR MULTIPLOS DE 3!\n");

int contador = 0;
for (int n = 1; n <= 30; n++)
{
    if (n % 3 == 0)
    {
        contador++;
    }
}
Console.WriteLine($"Multiplos de 3 entre 1 y 30: {contador}");

/*
CUARTA PARTE - Tabla del 7 solo para resultados mayores que 30.
*/
Console.WriteLine("\n¡DEMO 4: TABLA DEL 7 FILTRADA!\n");

for (int i = 1; i <= 10; i++)
{
    int producto = 7 * i;
    if (producto > 30)
    {
        Console.WriteLine($"  7 x {i} = {producto}");
    }
}

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");

static void MostrarClasificacion(int nota)
{
    if (nota >= 9)
    {
        Console.WriteLine($"  Nota {nota}: Sobresaliente");
    }
    else if (nota >= 5)
    {
        Console.WriteLine($"  Nota {nota}: Aprobado");
    }
    else
    {
        Console.WriteLine($"  Nota {nota}: Suspenso");
    }
}
