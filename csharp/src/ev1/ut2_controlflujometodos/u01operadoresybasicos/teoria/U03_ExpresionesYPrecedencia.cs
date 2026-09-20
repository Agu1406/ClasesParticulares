/*
U03 — Expresiones compuestas y precedencia de operadores.

OBJETIVO:
  - Evaluar expresiones con varios operadores respetando el orden.
  - Usar parentesis para forzar el orden deseado.
  - Recordar la diferencia entre division entera y decimal en expresiones mixtas.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - Precedencia basica.
  Orden tipico: parentesis > * / % > + -
  Ejemplo: 2 + 3 * 4  ->  2 + 12  ->  14  (no 20)
*/
Console.WriteLine("¡PRECEDENCIA SIN PARENTESIS!\n");

int r1 = 2 + 3 * 4;
Console.WriteLine($"2 + 3 * 4 = {r1}  (primero 3*4, luego +2)");

int r2 = 10 - 6 / 2;
Console.WriteLine($"10 - 6 / 2 = {r2}  (primero 6/2=3, luego 10-3)\n");

/*
SEGUNDA PARTE - Parentesis cambian el resultado.
*/
Console.WriteLine("¡PARENTESIS CAMBIAN EL RESULTADO!\n");

int sinParentesis = 2 + 3 * 4;
int conParentesis = (2 + 3) * 4;
Console.WriteLine($"2 + 3 * 4     = {sinParentesis}");
Console.WriteLine($"(2 + 3) * 4   = {conParentesis}");

int media = (8 + 6 + 10) / 3;
Console.WriteLine($"Media de 8, 6 y 10: ({8}+{6}+{10})/3 = {media}\n");

/*
TERCERA PARTE - Expresion mixta con modulo y asignacion.
*/
Console.WriteLine("¡EXPRESION MIXTA!\n");

int x = 5;
int y = 2;
int resultado = (x + y) * 3 - x % y;
Console.WriteLine($"x={x}, y={y}");
Console.WriteLine($"(x + y) * 3 - x % y = ({x}+{y})*3 - {x % y} = {resultado}");

int horasTotales = 47;
int dias = horasTotales / 24;
int horasSobrantes = horasTotales % 24;
Console.WriteLine($"{horasTotales} horas = {dias} dias y {horasSobrantes} horas\n");

/*
CUARTA PARTE - Division entera dentro de expresiones.
  7 / 2 con int da 3; con double da 3.5
*/
Console.WriteLine("¡INT VS DOUBLE EN EXPRESIONES!\n");

Console.WriteLine($"7 / 2 (int)           = {7 / 2}");
Console.WriteLine($"7 / 2.0 (double)      = {7 / 2.0}");
Console.WriteLine($"7.0 / 2 (double)      = {7.0 / 2}");
Console.WriteLine($"(double)(7 / 2)       = {(double)(7 / 2)}  (cast despues: sigue 3.0)");
Console.WriteLine($"Math.Round(7 / 2.0)   = {Math.Round(7 / 2.0)}");

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");
