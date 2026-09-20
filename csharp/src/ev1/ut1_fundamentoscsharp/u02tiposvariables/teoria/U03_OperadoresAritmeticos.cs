/*
U03 — Operadores aritmeticos.

OBJETIVO:
  - Operar con + - * / %
  - Conocer Math.Pow para potencias (en C# no existe **).
  - Distinguir division entera (int/int) de division decimal (double).
  - Guardar el resultado en una variable o usarlo solo al imprimir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

int a = 10;
int b = 3;

int resultadoS = a + b;
int resultadoR = a - b;
int resultadoM = a * b;
int resultadoDr = a % b;          // resto
int resultadoDe = a / b;          // division entera (int): 10/3 = 3
double resultadoDc = (double)a / b; // division con decimales
double resultadoPo = Math.Pow(a, b); // potencia

Console.WriteLine("¡IMPRIMIENDO OPERACIONES ARITMETICAS!\n");
Console.WriteLine($"Suma: {a} + {b} = {resultadoS}");
Console.WriteLine($"Resta: {a} - {b} = {resultadoR}");
Console.WriteLine($"Multiplicacion: {a} x {b} = {resultadoM}");
Console.WriteLine($"Division entera (int): {a} / {b} = {resultadoDe}");
Console.WriteLine($"Division decimal: {a} / {b} = {resultadoDc}");
Console.WriteLine($"Modulo (resto): {a} % {b} = {resultadoDr}");
Console.WriteLine($"Potencia Math.Pow({a}, {b}) = {resultadoPo}");

/*
Dos escenarios habituales:
  1) Guardar el resultado para usarlo despues.
  2) Calcular solo al mostrar (sin variable intermedia).
*/
Console.WriteLine("\n¡GUARDAR vs IMPRIMIR DIRECTO!\n");
int resultado = a + b;
Console.WriteLine($"La suma de {a} y {b} da {resultado}");
Console.WriteLine($"La resta de {a} y {b} da {a - b}");

/*
CUIDADO: int / int trunca. Si quieres decimales, convierte al menos un operando.
*/
Console.WriteLine("\n¡CUIDADO CON LA DIVISION ENTERA!\n");
Console.WriteLine($"Sin cast: 10 / 3 = {10 / 3}");
Console.WriteLine($"Con cast: 10 / 3.0 = {10 / 3.0}");
Console.WriteLine($"Con (double): {(double)10 / 3}");

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");
