/*
U03 — Entrada con Console.ReadLine.

OBJETIVO:
  - Leer texto del teclado con Console.ReadLine().
  - Mostrar mensajes previos con Console.Write (sin salto de linea).
  - Convertir la entrada a numeros con int.Parse o Convert.
  - Entender string? y el operador null-forgiving (!) en Parse.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - Leer un string con ReadLine.
  ReadLine() devuelve string? (puede ser null si no hay entrada).
  En consola interactiva casi siempre devuelve un string, aunque sea vacio "".
  Patron tipico: Write (pregunta) + ReadLine (respuesta).
*/
Console.WriteLine("--- PRIMERA PARTE: Leer texto ---\n");

Console.Write("Escribe tu nombre: ");
string? nombre = Console.ReadLine();
Console.WriteLine("Hola, " + nombre + "!");

Console.Write("Escribe tu ciudad: ");
string? ciudad = Console.ReadLine();
Console.WriteLine($"Vives en {ciudad}.");

/*
SEGUNDA PARTE - Leer y convertir a int con Parse.
  ReadLine devuelve string; para operar matematicamente hay que convertir.
  int.Parse(texto!) usa ! (null-forgiving) para decir al compilador:
  "Confio en que esto no sera null en este contexto didactico".
  En produccion conviene validar con int.TryParse.
*/
Console.WriteLine("\n--- SEGUNDA PARTE: Leer entero con Parse ---\n");

Console.Write("Escribe un numero entero: ");
string? textoEntero = Console.ReadLine();
int numero = int.Parse(textoEntero!);
Console.WriteLine("El doble es: " + (numero * 2));
Console.WriteLine("El cuadrado es: " + (numero * numero));

/*
TERCERA PARTE - Leer y convertir a double.
  double.Parse acepta decimales con punto: "3.14".
  Convert.ToDouble funciona igual para strings numericos.
*/
Console.WriteLine("\n--- TERCERA PARTE: Leer decimal ---\n");

Console.Write("Escribe un numero decimal (ej: 3.5): ");
string? textoDecimal = Console.ReadLine();
double decimalLeido = double.Parse(textoDecimal!);
Console.WriteLine($"Valor leido: {decimalLeido}");
Console.WriteLine($"Mitad: {decimalLeido / 2}");

Console.Write("Otro decimal con Convert.ToDouble: ");
double otroDecimal = Convert.ToDouble(Console.ReadLine()!);
Console.WriteLine($"Convert.ToDouble -> {otroDecimal}");

/*
CUARTA PARTE - Patron compacto: Parse directamente sobre ReadLine.
  Forma habitual en ejercicios cortos del curso.
  El ! va despues de ReadLine() porque es ReadLine quien puede ser null.
*/
Console.WriteLine("\n--- CUARTA PARTE: Parse en una sola linea ---\n");

Console.Write("Edad: ");
int edad = int.Parse(Console.ReadLine()!);
Console.WriteLine($"El proximo año tendras {edad + 1} años.");

Console.Write("Nota (0-10): ");
double nota = double.Parse(Console.ReadLine()!);
if (nota >= 5)
{
    Console.WriteLine($"Nota {nota}: APROBADO.");
}
else
{
    Console.WriteLine($"Nota {nota}: SUSPENSO.");
}

/*
QUINTA PARTE - Leer varios datos y calcular un resultado.
  Secuencia: pedir -> leer -> convertir -> procesar -> mostrar.
*/
Console.WriteLine("\n--- QUINTA PARTE: Mini calculadora ---\n");

Console.Write("Primer numero: ");
int a = int.Parse(Console.ReadLine()!);

Console.Write("Segundo numero: ");
int b = int.Parse(Console.ReadLine()!);

Console.WriteLine($"Suma:      {a + b}");
Console.WriteLine($"Resta:     {a - b}");
Console.WriteLine($"Producto:  {a * b}");

if (b != 0)
{
    Console.WriteLine($"Division:  {(double)a / b}");
}
else
{
    Console.WriteLine("Division:  no se puede dividir entre cero.");
}

/*
SEXTA PARTE - Nota sobre string? y el operador !.
  string?  = el valor puede ser null (anotacion de nullable reference types).
  !        = le dice al compilador "no sera null aqui" (supresion de advertencia).
  En programas didacticos de consola es aceptable; en apps reales usa TryParse.
*/
Console.WriteLine("\n--- SEXTA PARTE: Resumen de patrones ---\n");

Console.WriteLine("Patron 1: string? x = Console.ReadLine();");
Console.WriteLine("Patron 2: int n = int.Parse(Console.ReadLine()!);");
Console.WriteLine("Patron 3: double d = Convert.ToDouble(Console.ReadLine()!);");

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");
