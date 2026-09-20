/*
U04 — break y continue: controlar el flujo dentro de bucles.

OBJETIVO:
  - Usar break para salir del bucle antes de tiempo.
  - Usar continue para saltar a la siguiente vuelta.
  - Aplicarlos en busquedas y filtrado de datos.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - break: buscar el primer multiplo de 13 mayor que 100.
*/
Console.WriteLine("¡DEMO 1: BREAK EN BUSQUEDA!\n");

int candidato = 101;
while (true)  // bucle infinito controlado con break
{
    if (candidato % 13 == 0)
    {
        Console.WriteLine($"Primer multiplo de 13 >= 101: {candidato}");
        break;
    }
    candidato++;
}

/*
SEGUNDA PARTE - continue: imprimir impares del 1 al 15 (saltar pares).
*/
Console.WriteLine("\n¡DEMO 2: CONTINUE SALTANDO PARES!\n");

Console.Write("Impares 1-15: ");
for (int i = 1; i <= 15; i++)
{
    if (i % 2 == 0)
    {
        continue;  // salta el resto de la vuelta y pasa a i++
    }
    Console.Write($"{i} ");
}
Console.WriteLine();

/*
TERCERA PARTE - break en una secuencia simulada sin arrays.
  Vamos generando cada dato con if/else para no introducir colecciones todavia.
*/
Console.WriteLine("\n¡DEMO 3: BREAK AL ENCONTRAR!\n");

int buscado = 16;
int posicion = -1;
int pasoDato = 0;

for (int j = 0; j < 6; j++)
{
    int datoActual;
    pasoDato++;

    if (pasoDato == 1)
    {
        datoActual = 4;
    }
    else if (pasoDato == 2)
    {
        datoActual = 8;
    }
    else if (pasoDato == 3)
    {
        datoActual = 15;
    }
    else if (pasoDato == 4)
    {
        datoActual = 16;
    }
    else if (pasoDato == 5)
    {
        datoActual = 23;
    }
    else
    {
        datoActual = 42;
    }

    if (datoActual == buscado)
    {
        posicion = j;
        break;
    }
}
Console.WriteLine($"Valor {buscado} encontrado en indice {posicion}");

/*
CUARTA PARTE - continue + contador: procesar solo positivos.
*/
Console.WriteLine("\n¡DEMO 4: SOLO POSITIVOS!\n");

int sumaPositivos = 0;
for (int k = 1; k <= 6; k++)
{
    int numeroActual;
    if (k == 1)
    {
        numeroActual = 3;
    }
    else if (k == 2)
    {
        numeroActual = -1;
    }
    else if (k == 3)
    {
        numeroActual = 7;
    }
    else if (k == 4)
    {
        numeroActual = -4;
    }
    else if (k == 5)
    {
        numeroActual = 0;
    }
    else
    {
        numeroActual = 5;
    }

    if (numeroActual <= 0)
    {
        continue;
    }
    sumaPositivos += numeroActual;
}
Console.WriteLine($"Suma de positivos: {sumaPositivos}");

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");
