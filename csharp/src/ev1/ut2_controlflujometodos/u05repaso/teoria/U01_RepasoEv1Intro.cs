/*
U01 — Repaso general EV1: UT1 variables y UT2 control de flujo.

OBJETIVO:
  - Repasar tipos basicos, operadores y estructuras de control en un solo programa.
  - Conectar variables (UT1) con if, bucles y metodos (UT2).
  - Servir como mapa mental antes del repaso practico de la unidad.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - UT1: variables y tipos basicos.
*/
Console.WriteLine("¡UT1: VARIABLES Y TIPOS!\n");

string nombre = "Agustin";
int edad = 26;
double altura = 1.76;
bool activo = true;
Console.WriteLine($"{nombre}, {edad} años, {altura} m, activo={activo}");

/*
SEGUNDA PARTE - UT2 u01: operadores aritmeticos y compuestos.
*/
Console.WriteLine("\n¡UT2 u01: OPERADORES!\n");

int a = 10, b = 3;
Console.WriteLine($"{a}+{b}={a + b} | {a}/{b} entera={a / b} | {a}%{b}={a % b}");
int x = 5;
x += 3;
x++;
Console.WriteLine($"Tras x+=3 y x++: x={x}");

/*
TERCERA PARTE - UT2 u02-u03: condicionales y bucles.
*/
Console.WriteLine("\n¡UT2 u02-u03: IF Y FOR!\n");

if (edad >= 18)
{
    Console.WriteLine("Mayor de edad");
}

Console.Write("Conteo 1-5: ");
for (int i = 1; i <= 5; i++)
{
    Console.Write($"{i} ");
}
Console.WriteLine();

/*
CUARTA PARTE - UT2 u04: idea de metodo (funcion local de repaso).
  En archivos de metodos usamos class Program; aqui una funcion local rapida.
*/
Console.WriteLine("\n¡UT2 u04: METODOS (funcion local)!\n");

int Doble(int n) => n * 2;
Console.WriteLine($"Doble de 7 = {Doble(7)}");

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");
