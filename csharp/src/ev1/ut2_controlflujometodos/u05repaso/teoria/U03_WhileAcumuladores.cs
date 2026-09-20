/*
U03 — Bucles while con acumuladores y contadores.

OBJETIVO:
  - Acumular sumas y productos dentro de un while.
  - Contar cuantas veces ocurre una condicion.
  - Detener el bucle cuando se alcanza un objetivo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - Acumulador de suma: sumar hasta superar 500.
*/
Console.WriteLine("¡DEMO 1: SUMA ACUMULADA!\n");

int suma = 0;
int termino = 1;
while (suma < 500)
{
    suma += termino;
    termino++;
}
Console.WriteLine($"Primera suma >= 500: {suma} (terminos 1..{termino - 1})\n");

/*
SEGUNDA PARTE - Contador: cuantos numeros impares hay antes de 50.
*/
Console.WriteLine("¡DEMO 2: CONTAR IMPARES!\n");

int n = 1;
int impares = 0;
while (n < 50)
{
    if (n % 2 != 0)
    {
        impares++;
    }
    n++;
}
Console.WriteLine($"Impares menores que 50: {impares}\n");

/*
TERCERA PARTE - Acumulador de producto: factorial de 6.
*/
Console.WriteLine("¡DEMO 3: FACTORIAL CON WHILE!\n");

int numero = 6;
int factorial = 1;
int i = 1;
while (i <= numero)
{
    factorial *= i;
    i++;
}
Console.WriteLine($"{numero}! = {factorial}\n");

/*
CUARTA PARTE - Media de valores simulados hasta centinela 0.
  Se usan variables separadas para mantener el ejemplo dentro de EV1.
*/
Console.WriteLine("¡DEMO 4: MEDIA HASTA CENTINELA 0!\n");

int valor1 = 10;
int valor2 = 20;
int valor3 = 30;
int valor4 = 0;  // centinela
int idx = 1;
int total = 0;
int cantidad = 0;
int actual = valor1;

while (actual != 0)
{
    total += actual;
    cantidad++;
    idx++;

    if (idx == 2)
    {
        actual = valor2;
    }
    else if (idx == 3)
    {
        actual = valor3;
    }
    else
    {
        actual = valor4;
    }
}

double media = (double)total / cantidad;
Console.WriteLine($"Media de {cantidad} valores = {media:F2}");

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");
