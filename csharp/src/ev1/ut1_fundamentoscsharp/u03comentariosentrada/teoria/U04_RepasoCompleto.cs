/*
U04 — Repaso: comentarios, entrada, conversion y salida.

OBJETIVO:
  - Integrar comentarios, ReadLine, Parse y WriteLine en un mini programa.
  - Repasar el flujo completo: pedir datos -> convertir -> calcular -> mostrar.
  - Aplicar buenas practicas de comentarios y formato de salida.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

Console.WriteLine("\n¡INICIO DEL PROGRAMA!\n");

/*
PRIMERA PARTE - Suma de dos numeros enteros.
  Demo clasica que une entrada por teclado y conversion con Parse.
*/
Console.WriteLine("--- PRIMERA PARTE: Suma de dos enteros ---\n");

// Pedimos el primer operando al usuario.
Console.Write("Primer numero: ");
int a = int.Parse(Console.ReadLine()!);

// Pedimos el segundo operando.
Console.Write("Segundo numero: ");
int b = int.Parse(Console.ReadLine()!);

int suma = a + b; // calculamos la suma
Console.WriteLine("La suma es: " + suma);

/*
SEGUNDA PARTE - Calculo de media con decimales.
  Leemos doubles, calculamos media aritmetica y formateamos con $.
*/
Console.WriteLine("\n--- SEGUNDA PARTE: Media de dos notas ---\n");

Console.Write("Nota del primer examen: ");
double nota1 = double.Parse(Console.ReadLine()!);

Console.Write("Nota del segundo examen: ");
double nota2 = double.Parse(Console.ReadLine()!);

double media = (nota1 + nota2) / 2.0; // 2.0 fuerza division decimal
Console.WriteLine($"Media: {media:F2}"); // F2 = dos decimales fijos

if (media >= 5)
{
    Console.WriteLine("Resultado: APROBADO.");
}
else
{
    Console.WriteLine("Resultado: SUSPENSO.");
}

/*
TERCERA PARTE - Saludo personalizado con nombre y edad.
  Mezcla string (sin conversion) e int (con Parse).
*/
Console.WriteLine("\n--- TERCERA PARTE: Saludo personalizado ---\n");

Console.Write("Tu nombre: ");
string? nombre = Console.ReadLine();

Console.Write("Tu edad: ");
int edad = int.Parse(Console.ReadLine()!);

// Interpolacion: forma clara de combinar texto y variables.
Console.WriteLine($"Hola {nombre}, tienes {edad} años.");
Console.WriteLine($"El año que viene tendras {edad + 1} años.");

/*
CUARTA PARTE - Conversion de temperatura Celsius -> Fahrenheit.
  Formula: F = C * 9/5 + 32
  Demuestra Parse + calculo + salida formateada en un solo flujo.
*/
Console.WriteLine("\n--- CUARTA PARTE: Celsius a Fahrenheit ---\n");

Console.Write("Temperatura en Celsius: ");
double celsius = double.Parse(Console.ReadLine()!);

double fahrenheit = celsius * 9.0 / 5.0 + 32.0;
Console.WriteLine($"{celsius}°C = {fahrenheit:F1}°F");

/*
QUINTA PARTE - Precio con IVA.
  Lee un precio base, aplica IVA del 21 % y muestra desglose.
  Comentarios inline explican cada paso del calculo.
*/
Console.WriteLine("\n--- QUINTA PARTE: Precio con IVA ---\n");

Console.Write("Precio sin IVA (euros): ");
double precioBase = double.Parse(Console.ReadLine()!);

const double IVA = 0.21;                    // tipo impositivo fijo
double importeIva = precioBase * IVA;     // cantidad de IVA
double precioFinal = precioBase + importeIva;

Console.WriteLine($"Base imponible: {precioBase:F2} €");
Console.WriteLine($"IVA (21 %):     {importeIva:F2} €");
Console.WriteLine($"Total:          {precioFinal:F2} €");

/*
SEXTA PARTE - Resumen del flujo aprendido.
  Patron repetido en todos los mini programas anteriores.
*/
Console.WriteLine("\n--- SEXTA PARTE: Flujo completo repasado ---\n");

Console.WriteLine("1) Console.Write  -> mostrar pregunta (sin salto).");
Console.WriteLine("2) ReadLine       -> leer respuesta del usuario.");
Console.WriteLine("3) Parse/Convert  -> transformar string a numero.");
Console.WriteLine("4) Calculo        -> operar con las variables.");
Console.WriteLine("5) WriteLine      -> mostrar el resultado.");
Console.WriteLine("6) Comentarios    -> explicar cada paso al lector.");

Console.WriteLine("\n¡FIN DEL PROGRAMA!\n");
