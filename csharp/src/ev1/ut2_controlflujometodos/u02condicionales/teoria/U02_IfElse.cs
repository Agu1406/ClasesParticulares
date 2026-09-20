/*
U02 — if-else y cadenas else if.

OBJETIVO:
  - Elegir entre dos caminos con if / else.
  - Encadenar varias condiciones con else if.
  - Clasificar valores en rangos (notas, temperatura, etc.).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - if / else basico: par o impar.
*/
Console.WriteLine("¡DEMO 1: PAR O IMPAR!\n");

int numero = 14;
if (numero % 2 == 0)
{
    Console.WriteLine($"{numero} es par.");
}
else
{
    Console.WriteLine($"{numero} es impar.");
}

numero = 7;
if (numero % 2 == 0)
{
    Console.WriteLine($"{numero} es par.");
}
else
{
    Console.WriteLine($"{numero} es impar.\n");
}

/*
SEGUNDA PARTE - else if: clasificacion de nota.
  Se evalua de arriba abajo; solo entra en UN bloque.
*/
Console.WriteLine("¡DEMO 2: CALIFICACION POR NOTA!\n");

int nota = 8;
if (nota >= 9)
{
    Console.WriteLine($"Nota {nota}: Sobresaliente");
}
else if (nota >= 7)
{
    Console.WriteLine($"Nota {nota}: Notable");
}
else if (nota >= 5)
{
    Console.WriteLine($"Nota {nota}: Aprobado");
}
else
{
    Console.WriteLine($"Nota {nota}: Suspenso");
}

nota = 4;
if (nota >= 9)
{
    Console.WriteLine("Sobresaliente");
}
else if (nota >= 7)
{
    Console.WriteLine("Notable");
}
else if (nota >= 5)
{
    Console.WriteLine("Aprobado");
}
else
{
    Console.WriteLine($"Nota {nota}: Suspenso\n");
}

/*
TERCERA PARTE - else if con temperatura y descuento.
*/
Console.WriteLine("¡DEMO 3: TEMPERATURA Y DESCUENTO!\n");

double temp = 32.5;
if (temp >= 35)
{
    Console.WriteLine("Ola de calor: hidratate.");
}
else if (temp >= 25)
{
    Console.WriteLine("Dia caluroso.");
}
else if (temp >= 15)
{
    Console.WriteLine("Temperatura agradable.");
}
else
{
    Console.WriteLine("Hace fresco, abrigate.");
}

int edad = 12;
double precio = 10.0;
if (edad < 12)
{
    precio = precio * 0.5;  // 50% descuento infantil
}
else if (edad >= 65)
{
    precio = precio * 0.7;  // 30% descuento senior
}

Console.WriteLine($"Edad {edad}: precio final = {precio} euros");

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");
