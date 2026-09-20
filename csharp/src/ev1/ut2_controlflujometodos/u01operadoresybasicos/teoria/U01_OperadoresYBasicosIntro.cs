/*
U01 — Operadores aritmeticos y vision general.

OBJETIVO:
  - Repasar los cinco operadores aritmeticos basicos (+, -, *, /, %).
  - Diferenciar division entera (int) y division decimal (double).
  - Conocer el modulo (%) para restos y paridad.
  - Anticipar asignacion compuesta, incremento y precedencia (clases siguientes).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - Operadores aritmeticos con enteros.
  + suma    - resta    * producto    / cociente    % resto (modulo)
*/
Console.WriteLine("¡OPERADORES ARITMETICOS (int)!\n");

int a = 17;
int b = 5;

Console.WriteLine($"a = {a}, b = {b}");
Console.WriteLine($"Suma:       {a} + {b} = {a + b}");
Console.WriteLine($"Resta:      {a} - {b} = {a - b}");
Console.WriteLine($"Producto:   {a} * {b} = {a * b}");
Console.WriteLine($"Division:   {a} / {b} = {a / b}  (entera: descarta decimales)");
Console.WriteLine($"Modulo:     {a} % {b} = {a % b}  (resto de la division)\n");

/*
SEGUNDA PARTE - Division entera vs decimal.
  Si ambos operandos son int, / es entera.
  Si al menos uno es double, el resultado es decimal.
*/
Console.WriteLine("¡DIVISION ENTERA VS DECIMAL!\n");

int total = 10;
int personas = 3;
Console.WriteLine($"Repartir {total} galletas entre {personas} personas:");
Console.WriteLine($"  Entera:  {total} / {personas} = {total / personas} galletas por persona");
Console.WriteLine($"  Decimal: {total} / {personas}.0 = {total / (double)personas} galletas por persona\n");

double precio = 7.50;
int unidades = 4;
Console.WriteLine($"Precio unitario {precio} x {unidades} = {precio * unidades} euros\n");

/*
TERCERA PARTE - Modulo en situaciones reales.
  % devuelve el resto. Sirve para saber si un numero es par o multiplo.
*/
Console.WriteLine("¡MODULO EN LA PRACTICA!\n");

int minutos = 127;
int horas = minutos / 60;
int minutosRestantes = minutos % 60;
Console.WriteLine($"{minutos} minutos = {horas} h y {minutosRestantes} min");

int numero = 14;
Console.WriteLine($"¿{numero} es par? {numero % 2 == 0}");
numero = 7;
Console.WriteLine($"¿{numero} es par? {numero % 2 == 0}\n");

/*
CUARTA PARTE - Vision general de la unidad.
  En las siguientes clases veremos += -= ++ -- y precedencia de operadores.
*/
Console.WriteLine("¡VISTA PREVIA DE LA UNIDAD!\n");
Console.WriteLine("Asignacion compuesta:  x += 3  equivale a  x = x + 3");
Console.WriteLine("Incremento:            contador++  suma 1 al valor");
Console.WriteLine("Precedencia:           (2 + 3) * 4  no es lo mismo que  2 + 3 * 4");

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");
